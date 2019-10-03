package HHS_PROJGR6;

// imports from project

import HHS_PROJGR6.Entities.*;
import HHS_PROJGR6.External.*;
import HHS_PROJGR6.Factories.EntityFactory;
import HHS_PROJGR6.Interfaces.IEntity;
import HHS_PROJGR6.Utils.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;

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
    private ArrayList<IEntity> entities;

    /**
     * Hotel class
     * 
     * The object derived from this class must contain all the entities. All the
     * enties will live and act here. Every event is triggered in the object derived
     * from this class. The canvas is aggregated in this class to make sure that
     * only elements from the hotel are drawn on the canvas.
     * 
     * @param hotelCanvas
     */
    public Hotel() {
        // Initilize entities
        this.entities = new ArrayList<IEntity>();

        // Run events
        HotelEventManager eventManager = new HotelEventManager();
        eventManager.register(this);
        eventManager.changeSpeed(2);
        eventManager.start();

        // DijkstraAlgorithm da = new DijkstraAlgorithm();

        // System.out.println("the path is " + da.findPath().size() + " steps long");
        // System.out.println("ELEMEMTS");
        // for (Node step : da.findPath()) {
        // System.out.println(step.getX() + " " + step.getY());
        // for (Node neighbour : step.getNeighbours()) {
        // System.out.println(" + " + neighbour.getX() + " " + neighbour.getY());
        // }
        // }
        // System.out.println("DONE");

        // Start frames
        frame();
    }

    private void frame() {
        // Wait for clockspeed
        LocalDateTime start = LocalDateTime.now();
        while (TODO) {
        }

        // Remove checked out guests
        entities.stream().filter(entity -> {
            // Filter guests
            return entity instanceof EntityGuest;
        }).forEach(entity -> {
            // If guest done
            if (!((EntityGuest) entity).getActive()) {
                // Remove guest from hotel
                deregister(entity);
            }
        });

        // Notify all entities that they have to do something
        entities.stream().forEach(entity -> ((HotelEventListener) entity).Notify(new HotelEvent(HotelEventType.NONE, "", 0, new HashMap<String, String>())));

        // Recursion to keep loop going
        frame();
    }

    /**
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
     * 
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
            JSONArray jsonArray = (JSONArray) new JsonReader("hotel(3).layout").getJsonObject();
            Iterator i = jsonArray.iterator();
            int[] highestPositions = getHighest(jsonArray, "Position");
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
                this.register(entity);
            }

            // TODO: maak deze dynamisch (dimensions en position)!
            // Create entity with factory
            entity = EntityFactory.createEntity("Elevator");
            entity.setPosition(7, 1);
            entity.setDimensions(1, 7);
            this.register(entity);

            // TODO: maak deze dynamisch (dimensions en position)!
            // Create entity with factory
            entity = EntityFactory.createEntity("Stairs");
            entity.setPosition(7, 8);
            entity.setDimensions(1, 7);
            this.register(entity);

            entity = EntityFactory.createEntity("Lift");
            entity.setPosition(7, 2);
            entity.setDimensions(6, 1);

            this.register(entity);

            // Draw only the nessecary grid size
            hotelCanvas.setGridHeight(highestPositions[1] + 1);
            hotelCanvas.setGridWidth(highestPositions[0] + 2);

            // Draw entities
            hotelCanvas.setDrawableEntities(entities);
        } catch (Exception e) {
            // TODO: better exception handling
            throw e;
        }
    }

    /**
     * 
     * @param array
     * @param value
     * @return
     */
    private int[] getHighest(JSONArray array, String value) {
        // TODO: make this a better algol !!!!!!!!!!!!
        Iterator i = array.iterator();
        int[] highes = new int[2];
        highes[0] = 0;
        highes[1] = 0;

        try {
            while (i.hasNext()) {
                JSONObject slide = (JSONObject) i.next();
                String[] compare = ((String) slide.get(value)).split(",");

                if (Integer.parseInt(compare[0].trim()) > highes[0]) {
                    highes[0] = Integer.parseInt(compare[0].trim());
                }

                if (Integer.parseInt(compare[1].trim()) > highes[1]) {
                    highes[1] = Integer.parseInt(compare[1].trim());
                }
            }
        } catch (Exception e) {
            // TODO: better exception handling
            throw e;
        }

        return highes;
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
            // TODO: maak gasten aan
            EntityGuest guest = (EntityGuest) EntityFactory.createEntity("Guest");

            break;
        case CLEANING_EMERGENCY:
            EntityHousekeeping housekeeping = (EntityHousekeeping) EntityFactory.createEntity("Housekeeping");
            // TODO: Gast maakt kamer vies. Schoonmaker gaat er naartoe
            break;
        case EVACUATE:
            // TODO: Notify alle gasten dat ze naar de deur moeten
            entities.stream().filter(entity -> {
                return entity instanceof EntityGuest || entity instanceof EntityHousekeeping;
            }).forEach(entity -> {
                ((HotelEventListener) entity).Notify(new HotelEvent(HotelEventType.CHECK_OUT, "", 0, new HashMap<String, String>()));
            });
            break;
        case GODZILLA:
            // TODO Hotel gaat deud iedeereen er aan
            this.Notify(new HotelEvent(HotelEventType.EVACUATE, "", 0, new HashMap<String, String>()));
            // TODO: Teken afbeelding van godzilla (Erwinzilla?)
            break;
        case START_CINEMA:
            entities.stream().filter(entity -> {
                // TODO: filter de entity waar het om gaat op basis van de data = entity.xy
                return entity instanceof EntityLeasure || false;
            }).forEach(entity -> {
                ((HotelEventListener) entity).Notify(event);
            });
            break;
        default:
            entities.stream().filter(entity -> {
                return entity instanceof EntityGuest || entity instanceof EntityHousekeeping;
            }).forEach(entity -> {
                ((HotelEventListener) entity).Notify(event);
            });
            break;

        }
    }
}
