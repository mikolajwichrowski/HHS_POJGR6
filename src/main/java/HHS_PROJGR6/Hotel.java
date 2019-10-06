package HHS_PROJGR6;

// imports from project

import HHS_PROJGR6.Entities.*;
import HHS_PROJGR6.External.HotelEvent;
import HHS_PROJGR6.External.HotelEventListener;
import HHS_PROJGR6.External.HotelEventManager;
import HHS_PROJGR6.External.HotelEventType;
import HHS_PROJGR6.Factories.EntityFactory;
import HHS_PROJGR6.Interfaces.IEntity;
import HHS_PROJGR6.Interfaces.IStressable;
import HHS_PROJGR6.Utils.*;
import HHS_PROJGR6.Utils.JsonReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Iterator;

// External imports

/**
 *
 */
public class Hotel implements HotelEventListener {
    /**
     *
     */
    private Canvas hotelCanvas;

    /**
     *
     */
    private int[] highestPositions;

    /**
     * 
     */
    private ArrayList<IEntity> entities;

    /**
     *
     */
    private HotelEventManager eventManager;

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

        // Run events
        eventManager = new HotelEventManager();
        eventManager.register(this);
        eventManager.start();
    }

    /**
     * 
     */
    public void frame() {
        // Wait for clockspeed
        LocalDateTime start = LocalDateTime.now();
        long hteInNano = 1000000000 / Clock.getClockspeed();
        LocalDateTime end = LocalDateTime.now().plusNanos(hteInNano);

        // TODO: fix change speed
        // Change hte based on clock speed from clock singleton
        // eventManager.changeSpeed(1.00 / Clock.getClockspeed());

        // While the hte has not yet ticked. Keep checking
        while (start.isBefore(end)) {
            start = LocalDateTime.now();
        }

        // Remove checked out guests
        // TODO: fix
        // if (false) {
        // ArrayList<IEntity> removeEntities = new ArrayList<IEntity>();
        // entities.stream().filter(entity -> {
        // // Filter guests
        // return entity instanceof EntityGuest;
        // }).forEach(entity -> {
        // // If guest is not a guest
        // if (!((EntityGuest) entity).getActive()) {
        // // Remove guest from hotel
        // removeEntities.add(entity);
        // }
        // });
        // removeEntities.stream().forEach(e -> this.deregister(e));

        // // TODO: Notify all entities that they have to do something
        // entities.stream().forEach(entity -> entity.frame());
        // }

        // Recursion to keep loop going
        this.frame();
    }

    /**
     * 
     */
    private void pathFinder() {
        // TODO: dit moet globaal zijn
        // Van/Tot: DijkstraAlgorithm.createLocationNode(1, 4)
        // Graph maken: da.getGraph(4, 4, entities)
        // da.findPath(van, tot, graph): instructies maken van de kortste route

        // Zo werkt het dijkstra algoritme
        DijkstraAlgorithm da = new DijkstraAlgorithm();

        da.findPath(DijkstraAlgorithm.createLocationNode(1, 4), DijkstraAlgorithm.createLocationNode(4, 1), da.getGraph(4, 4, entities)).stream().forEach(step -> {
            // Elke stap moet als instructie worden meegegeven
            System.out.println(step.getX() + " " + step.getY() + " " + step.getCostToParent());
        });
    }

    /**
     * @param actor
     */
    private void register(IEntity actor) {
        entities.add(actor);
        if (hotelCanvas != null) {
            hotelCanvas.setDrawableEntities(entities);
        }
    }

    /**
     * @param actor
     */
    private void deregister(IEntity actor) {
        entities.remove(actor);
        hotelCanvas.setDrawableEntities(entities);
    }

    /**
     *
     */
    public void initRooms() {
        try {
            // Read hotel and get highest position values
            JSONArray jsonArray = (JSONArray) new JsonReader("hotel(4).layout").getJsonObject();
            Iterator i = jsonArray.iterator();
            this.highestPositions = getHighest(jsonArray, "Position");
            IEntity entity = null;

            // Loop trough json array
            while (i.hasNext()) {
                JSONObject jsonObject = (JSONObject) i.next();

                String type = (String) jsonObject.get("AreaType");

                String[] position = ((String) jsonObject.get("Position")).split(",");

                // Dimensions
                String[] dimension = ((String) jsonObject.get("Dimension")).split(",");

                // Reverse the grid layout
                int x = Integer.parseInt(position[0].trim()) + 1;
                int y = this.highestPositions[1] - Integer.parseInt(position[1].trim()) + 1;

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
                this.register(entity);
            }

            // Create entity elevator with factory
            // TODO: dynamic position and sizes
            entity = EntityFactory.createEntity("Elevator");
            entity.setPosition(this.highestPositions[1] + 1, 1);
            entity.setDimensions(1, this.highestPositions[1] + 1);
            this.register(entity);

            // Create stairs entity with factory
            // TODO: dynamic position and sizes
            entity = EntityFactory.createEntity("Stairs");
            entity.setPosition(this.highestPositions[1] + 1, 8);
            entity.setDimensions(1, this.highestPositions[1] + 1);
            this.register(entity);

            // Create lobby entity with factory
            entity = EntityFactory.createEntity("Lobby");
            entity.setPosition(7, 4);
            entity.setDimensions(2, 7);
            this.register(entity);

            // Create housekeeping with factory
            // TODO: with loop
            entity = EntityFactory.createEntity("Housekeeping");
            entity.setPosition(7, 6);
            entity.setDimensions(1, 1);
            this.register(entity);

            entity = EntityFactory.createEntity("Housekeeping");
            entity.setPosition(7, 3);
            entity.setDimensions(1, 1);
            this.register(entity);
        } catch (Exception e) {
            // TODO: better exception handling
            throw e;
        }
    }

    /**
     * @param array
     * @param value
     * @return
     */
    private int[] getHighest(JSONArray array, String value) {
        // TODO: make this a better algo !!!!!!!!!!!!
        Iterator i = array.iterator();
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
     *
     */
    public Canvas getHotelCanvas() {
        return hotelCanvas;
    }

    /**
     *
     */
    public void setHotelCanvas(Canvas hotelCanvas) {
        this.hotelCanvas = hotelCanvas;

        // Draw only the nessecary grid size
        hotelCanvas.setGridHeight(this.highestPositions[1] + 1);
        hotelCanvas.setGridWidth(this.highestPositions[0] + 2);

        // Draw entities
        hotelCanvas.setDrawableEntities(entities);
    }

    private void evacuateEvent(HotelEvent event) {
        // entities.stream().filter(entity -> {
        // return entity instanceof EntityHousekeeping && entity instanceof EntityGuest;
        // }).forEach(entity -> {
        // ((HotelEventListener) entity).checkout(event);
        // });
    }

    private void checkInEvent(HotelEvent event) {
        // TODO: maak gasten aan
        EntityGuest guest = (EntityGuest) EntityFactory.createEntity("Guest");
        guest.setPosition(7, 2);
        String guestKey = event.Data.keySet().iterator().next();
        guest.setID(guestKey);
        guest.setPreference(event.Data.get(guestKey));
        register(guest);

    }

    private void checkOutEvent(HotelEvent event) {
        entities.stream().filter(entity -> {
            // Get guest that has to check out
            String guestKey = event.Data.keySet().iterator().next();
            int guestID = EntityGuest.parseInt(guestKey);
            return entity instanceof EntityGuest && ((EntityGuest) entity).getID() == guestID;
        }).forEach(entity -> {
            // Make guest checkout
            ((EntityGuest) entity).checkout();
        });
    }

    private void cleaningEmergencyEvent(HotelEvent event) {
        // TODO: Gast maakt kamer vies. Schoonmaker gaat er naartoe
        // TODO: fix
        // entities.stream().filter(entity -> {
        // // Get guest that has to check out
        // String guestKey = event.Data.keySet().iterator().next();
        // int guestID = EntityGuest.parseInt(guestKey);
        // return entity instanceof EntityGuest && ((EntityGuest) entity).getID() ==
        // guestID;
        // }).forEach(entity -> {
        // // Make guest make the room filthy
        // // TODO: ((EntityGuest) entity).filthy();
        // });

        // // TODO: pass pathfinding
        // ((EntityHousekeeping) entities.stream().filter(entity -> {
        // // Get housekeeping that is not cleaning
        // return entity instanceof EntityHousekeeping;
        // }).collect(Collectors.toList()).get(0)).cleanRoom();

    }

    private void godzillaEvent(HotelEvent event) {
        // TODO Hotel gaat deud iedeereen er aan ... Alle kamers zijn vies en alle
        entities.stream().filter(entity -> {
            // Get all living entities
            return entity instanceof EntityHousekeeping && entity instanceof EntityGuest && entity instanceof EntityRoom;
        }).forEach(entity -> {
            // Make them panic
            ((IStressable) entity).panic();
        });

        // TODO: Teken afbeelding van godzilla (Erwinzilla?)
    }

    private void startCinemaEvent(HotelEvent event) {
        // TODO zoek cinema waar het over gaat en start hier de film

    }

    private void goToCinemaEvent(HotelEvent event) {
        // TODO: Desbetreffende EntityGuest gaat naar Cinema
        entities.stream().filter(entity -> {
            String guestKey = event.Data.keySet().iterator().next();
            int guestID = EntityGuest.parseInt(guestKey);
            return entity instanceof EntityGuest && ((EntityGuest) entity).getID() == guestID;
        }).forEach(entity -> {
            // TODO: pass pathfinding
            ((EntityGuest) entity).goToCinema();
        });
    }

    private void goToFitnessEvent(HotelEvent event) {
        entities.stream().filter(entity -> {
            String guestKey = event.Data.keySet().iterator().next();
            int guestID = EntityGuest.parseInt(guestKey);
            return entity instanceof EntityGuest && ((EntityGuest) entity).getID() == guestID;
        }).forEach(entity -> {
            // TODO: pass pathfinding
            ((EntityGuest) entity).goToFitness();
        });
    }

    private void goToRestaurantEvent(HotelEvent event) {
        entities.stream().filter(entity -> {

            return entity instanceof EntityGuest;
        }).forEach(entity -> {
            ((EntityGuest) entity).goToRestaurant();
        });

    }

    /**
     *
     */
    public void Notify(HotelEvent event) {
        // Set the time for every HTE
        Clock.datetime = Clock.datetime.plusSeconds(Clock.getClockspeed());

        // TODO: data
        System.out.println(event.Data);

        // Which event is fired
        switch (event.Type) {
        case CHECK_IN:
            this.checkInEvent(event);
            break;

        case CLEANING_EMERGENCY:
            this.cleaningEmergencyEvent(event);
            break;

        case EVACUATE:
            this.evacuateEvent(event);
            break;

        case GODZILLA:
            this.godzillaEvent(event);
            break;

        case START_CINEMA:
            this.startCinemaEvent(event);
            break;

        case CHECK_OUT:
            this.checkOutEvent(event);
            break;

        case GOTO_RESTAURANT:
            this.goToRestaurantEvent(event);
            break;

        case GOTO_FITNESS:
            this.goToFitnessEvent(event);
            break;

        case GOTO_CINEMA:
            this.goToCinemaEvent(event);
            break;

        case NONE:
        default:
            // No event happends here
            break;

        }
    }

    /*
    *
     */
    public int[] getHighestPositions() {
        return highestPositions;
    }
}
