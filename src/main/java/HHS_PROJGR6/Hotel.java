package HHS_PROJGR6;

import HHS_PROJGR6.Entities.Entity;

// imports from project

import HHS_PROJGR6.Entities.EntityDiner;
import HHS_PROJGR6.Entities.EntityGuest;
import HHS_PROJGR6.Entities.EntityRoom;
import HHS_PROJGR6.External.HotelEvent;
import HHS_PROJGR6.External.HotelEventListener;
import HHS_PROJGR6.External.HotelEventManager;
import HHS_PROJGR6.Factories.EntityFactory;
import HHS_PROJGR6.Interfaces.IEntity;
import HHS_PROJGR6.Utils.DijkstraAlgorithm;
import HHS_PROJGR6.Utils.JsonReader;
import HHS_PROJGR6.Utils.Node;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

/**
 *
 */
public class Hotel implements HotelEventListener {
    /**
     * The canvas on wich the entities are drawn
     */
    private Canvas hotelCanvas;

    /**
     * Highest position to make sure the grid is not unnesecary big and entities are
     * aligned where they schould be
     */
    private int[] highestPositions;

    /**
     * The event manager from external dev
     */
    private HotelEventManager eventManager;

    /**
     * All entities in simulation
     */
    private ArrayList<IEntity> entities;

    /**
     * Graph of positions to walk on
     */
    private ArrayList<Node> nodeGraph;

    /**
     * Hotel class
     * 
     * The object derived from this class must contain all the entities. All the
     * enties will live and act here. Every event is triggered in the object derived
     * from this class. The canvas is aggregated in this class to make sure that
     * only elements from the hotel are drawn on the canvas.
     */
    public Hotel() {
        // Initilize entities
        this.entities = new ArrayList<IEntity>();
    }

    /**
     * Draws frame
     */
    public void frame() {
        // Set the time for every HTE
        Clock.datetime = Clock.datetime.plusSeconds(1);

        // Wait for clockspeed
        LocalDateTime start = LocalDateTime.now();
        long hteInNano = (long) (100000000 / Clock.getClockspeed());
        LocalDateTime end = LocalDateTime.now().plusNanos(hteInNano);

        // Change hte based on clock speed from clock singleton
        eventManager.changeSpeed(Clock.getClockspeed());

        // While the hte has not yet ticked. Keep checking
        while (start.isBefore(end)) {
            start = LocalDateTime.now();
        }

        // Let's every entity react to frame
        for (IEntity entity : entities) {
            entity.frame();
        }

        // Removes guest that are checked out
        removeCheckoutGuest();

        // Repaints canvas because JAVA
        hotelCanvas.repaint();

        // Recursion to keep loop going
        frame();
    }

    /**
     * Removes guest that are checked out
     */
    private void removeCheckoutGuest() {
        ArrayList<IEntity> removalbleEntities = new ArrayList<IEntity>();
        for (IEntity entity : entities) {
            if (entity instanceof EntityGuest && !((EntityGuest) entity).getActive()) {
                removalbleEntities.add(entity);
            }
        }

        for (IEntity entity : removalbleEntities) {
            entities.remove(entity);
        }
    }

    /**
     * Initializes rooms and basic entities
     */
    public void init() {
        try {
            // Read hotel and get highest position values
            JsonReader reader = new JsonReader("hotel(4).layout");

            // Set highest position
            highestPositions = getHighest(reader.getIterable(), "Position");

            // Declare entity to reuse
            IEntity entity = null;

            // Loop trough json array
            Iterator i = reader.getIterable();
            while (i.hasNext()) {
                // Current object
                JSONObject jsonObject = (JSONObject) i.next();

                // Type
                String type = (String) jsonObject.get("AreaType");

                // Position
                String[] position = ((String) jsonObject.get("Position")).split(",");

                // Dimensions
                String[] dimension = ((String) jsonObject.get("Dimension")).split(",");

                // Reverse the grid layout
                int x = Integer.parseInt(position[0].trim()) + 1;
                int y = highestPositions[1] - Integer.parseInt(position[1].trim()) + 1;

                // Entity size
                int width = Integer.parseInt(dimension[0].trim());
                int height = Integer.parseInt(dimension[1].trim());

                // Create entity with factory
                entity = EntityFactory.createEntity(type);
                entity.setPosition(y, x);
                entity.setDimensions(width, height);

                String classification = (String) jsonObject.get("Classification");
                if (classification != null && classification != "") {
                    ((EntityRoom) entity).setClassification(classification);
                }

                String capacity = (String) jsonObject.get("Capacity");
                if (capacity != null && capacity != "") {
                    ((EntityDiner) entity).setCapacity(capacity);
                }

                // Add entity
                register(entity);
            }

            // Create entity elevator with factory
            entity = EntityFactory.createEntity("Elevator");
            entity.setPosition(getHighestPositions()[1] + 1, 1);
            entity.setDimensions(1, getHighestPositions()[0] + 1);
            register(entity);

            // Create stairs entity with factory
            entity = EntityFactory.createEntity("Stairs");
            entity.setPosition(getHighestPositions()[1] + 1, 8);
            entity.setDimensions(1, getHighestPositions()[0] + 1);
            register(entity);

            // Create lobby entity with factory
            entity = EntityFactory.createEntity("Lobby");
            entity.setPosition(getHighestPositions()[1] + 1, 2);
            entity.setDimensions(getHighestPositions()[1], 1);
            register(entity);

            // Create housekeeping with factory
            for (int j = 1; j < 5; j++) {
                entity = EntityFactory.createEntity("Housekeeping");
                entity.setPosition(getHighestPositions()[1] + 1, getHighestPositions()[0] + 2);
                entity.setDimensions(1, 1);
                register(entity);
            }

            // Init path finder after all basic entites are created
            nodeGraph = DijkstraAlgorithm.getGraph(getHighestPositions()[0] + 2, getHighestPositions()[1] + 1, entities);

            // Run events
            eventManager = new HotelEventManager();

            eventManager.changeSpeed(0.5);
            Clock.reduceClockspeed();
            Clock.reduceClockspeed();
            Clock.reduceClockspeed();
            Clock.reduceClockspeed();

            eventManager.register(this);
            eventManager.start();
        } catch (Exception e) {
            // TODO: better exception handling
            throw e;
        }
    }

    /**
     * returns hotel canvas
     * 
     * @return
     */
    public Canvas getHotelCanvas() {
        return hotelCanvas;
    }

    /**
     * sets hotel canvas and its resolution
     * 
     * @param hotelCanvas
     */
    public void setHotelCanvas(Canvas hotelCanvas) {
        this.hotelCanvas = hotelCanvas;

        // Draw only the nessecary grid size
        hotelCanvas.setGridHeight(this.highestPositions[1] + 1);
        hotelCanvas.setGridWidth(this.highestPositions[0] + 2);

        // Draw entities
        hotelCanvas.setDrawableEntities(entities);

        // Add bindings now we know canvas is OK
        setMenuBindings();
    }

    /**
     * Sets the methods for menus
     */
    private void setMenuBindings() {
        // Add key listeners
        hotelCanvas.registerKeyboardAction(e -> showStatistics(), KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, false), JComponent.WHEN_FOCUSED);
        hotelCanvas.registerKeyboardAction(e -> showMenu(), KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, false), JComponent.WHEN_FOCUSED);
    }

    /**
     * Called upon when event manager has a event
     */
    public void Notify(HotelEvent event) {
        String key = event.Data.keySet().iterator().next();

        // Which event is fired
        switch (event.Type) {
        case CHECK_IN:
            // Create new guest
            EntityGuest guest = (EntityGuest) EntityFactory.createEntity("Guest");
            guest.setPosition(getHighestPositions()[1] + 1, getHighestPositions()[0] + 2);
            guest.setID(key);
            guest.setPreference(event.Data.get(key));

            // Find available room with preference
            EntityRoom room = null;
            for (IEntity entity : entities) {
                if (entity instanceof EntityRoom && ((EntityRoom) entity).getClassification() == guest.getPreference() && ((EntityRoom) entity).getInhabitantID() == 0) {
                    room = ((EntityRoom) entity);
                }
            }

            // If there is a room
            if (room != null) {
                // Set inhabitant
                room.setInhabitantID(guest.getID());

                // Generate instructions to available room
                Node from = DijkstraAlgorithm.createLocationNode(2, 7);
                Node to = DijkstraAlgorithm.createLocationNode(room.getXPosition(), room.getYPosition());

                // This is weird but this needs to be
                nodeGraph = DijkstraAlgorithm.getGraph(getHighestPositions()[0] + 2, getHighestPositions()[1] + 1, entities);

                guest.setInstructions(DijkstraAlgorithm.findPath(from, to, (ArrayList<Node>) nodeGraph.clone()));

                register(guest);
            }
            break;
        case CHECK_OUT:
            int removeInhabitantID = 0;
            for (IEntity entity : entities) {
                if (entity instanceof EntityGuest && ((EntityGuest) entity).getID() == Entity.parseInt(event.Data.get(key))) {
                    // Generate instructions to available room
                    Node from = DijkstraAlgorithm.createLocationNode(entity.getXPosition(), entity.getYPosition());
                    Node to = DijkstraAlgorithm.createLocationNode(2, 7);

                    // This is weird but this needs to be
                    nodeGraph = DijkstraAlgorithm.getGraph(getHighestPositions()[0] + 2, getHighestPositions()[1] + 1, entities);

                    // Remove inhabitant from room
                    removeInhabitantID = ((EntityGuest) entity).getID();

                    // Set last instructions and set ID to 0
                    ((EntityGuest) entity).setInstructions(DijkstraAlgorithm.findPath(from, to, (ArrayList<Node>) nodeGraph.clone()));
                    ((EntityGuest) entity).checkout();
                }
            }

            // Remove inhabitant from room
            for (IEntity entity : entities) {
                if (entity instanceof EntityRoom && removeInhabitantID == ((EntityRoom) entity).getInhabitantID()) {
                    ((EntityRoom) entity).setInhabitantID(0);
                }
            }
            break;

        case CLEANING_EMERGENCY:

            break;

        case EVACUATE:

            break;

        case GODZILLA:

            break;

        case START_CINEMA:

            break;

        case GOTO_RESTAURANT:

            break;

        case GOTO_FITNESS:

            break;

        case GOTO_CINEMA:

            break;

        case NONE:
        default:
            // No event
            break;

        }
    }

    /**
     * returns array of highest values. Array contains [x, y]
     * 
     * @return
     */
    public int[] getHighestPositions() {
        return highestPositions;
    }

    /**
     * Gets highest value from layout file
     * 
     * @param array
     * @param value
     * @return
     */
    private int[] getHighest(Iterator i, String value) {
        // This is not so good :'(
        int[] highest = new int[2];
        highest[0] = 0;
        highest[1] = 0;

        try {
            while (i.hasNext()) {
                JSONObject slide = (JSONObject) i.next();
                String[] compare = ((String) slide.get(value)).split(",");

                if (Integer.parseInt(compare[0].trim()) > highest[0]) {
                    highest[0] = Integer.parseInt(compare[0].trim());
                }

                if (Integer.parseInt(compare[1].trim()) > highest[1]) {
                    highest[1] = Integer.parseInt(compare[1].trim()) + 1;
                }
            }
        } catch (Exception e) {
            // TODO: better exception handling
            throw e;
        }

        return highest;
    }

    /**
     * Shows menu
     */
    public void showMenu() {
        Menu menu = new Menu();
        menu.setVisible(true);
    }

    /**
     * Shows statistics
     */
    public void showStatistics() {
        Statistics statistics = new Statistics(entities);
        statistics.setVisible(true);
    }

    /**
     * Registers entities
     * 
     * @param actor
     */
    private void register(IEntity actor) {
        entities.add(actor);
        if (hotelCanvas != null) {
            hotelCanvas.setDrawableEntities(entities);
        }
    }

    /**
     * Removes entities
     * 
     * @param actor
     */
    private void deregister(IEntity actor) {
        entities.remove(actor);
        hotelCanvas.setDrawableEntities(entities);
    }
}
