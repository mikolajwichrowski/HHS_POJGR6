package HHS_PROJGR6;

// imports from project
import HHS_PROJGR6.External.HotelEvent;
import HHS_PROJGR6.External.HotelEventListener;
import HHS_PROJGR6.External.HotelEventManager;
import HHS_PROJGR6.External.HotelEventType;
import HHS_PROJGR6.Factories.EntityFactory;
import HHS_PROJGR6.Interfaces.IEntity;
import HHS_PROJGR6.Utils.JsonReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

// External imports

/**
 * 
 */
public class Hotel implements HotelEventListener, Runnable {
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

    // private void deregister(IEntity actor) {
    // entities.remove(actor);
    // hotelCanvas.setDrawableEntities(entities);
    // }

    /**
     * 
     */
    public void initRooms() {
        try {
            // Read hotel and get highest position values
            JSONArray jsonArray = (JSONArray) new JsonReader("hotel(3).layout").getJsonObject();
            Iterator i = jsonArray.iterator();
            int[] highestPositions = getHighest(jsonArray, "Position");

            // Loop trough json array
            while (i.hasNext()) {
                JSONObject jsonObject = (JSONObject) i.next();

                String type = (String) jsonObject.get("AreaType");

//                String classification = (String) jsonObject.get("Classification");

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
                IEntity entity = EntityFactory.createEntity(type);
//                IEntity entityRoom = EntityFactory.createEntity(classification);

                entity.setPosition(y, x);
                entity.setDimensions(width, height);

//                entityRoom.setPosition(y, x);
//                entityRoom.setDimensions(width, height);

                // Add entity
                this.register(entity);
//                this.register(entityRoom);

            }

            // TODO: maak deze automatisch!
            // Create entity with factory
            IEntity entityStairs = EntityFactory.createEntity("Transport");
            entityStairs.setPosition(7, 1);
            entityStairs.setDimensions(1, 7);

            // Add entity
            this.register(entityStairs);

            // TODO: maak deze automatisch!
            // Create entity with factory
            IEntity entityEscalator = EntityFactory.createEntity("Transport");
            entityEscalator.setPosition(7, 8);
            entityEscalator.setDimensions(1, 7);

            // Add entity
            this.register(entityEscalator);

            // Draw only the nessecary grid size
            hotelCanvas.setGridHeight(highestPositions[1] + 1);
            hotelCanvas.setGridWidth(highestPositions[0]);

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
        if (event.Type == HotelEventType.CHECK_IN) {
            IEntity actor = EntityFactory.createEntity("Guest");

            // @ Miek : Gast op 0,6 binnen laten lopen???
            actor.setPosition(1, 1);

            register(actor);
        }
    }

    @Override
    public void run() {
//        // Draw every frame
//        new Timer(1000, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                for (int i = 0; i < Clock.getClockspeed(); i++) {
//                    for (IEntity entity : entities) {
//                        entity.Notify();
//                    }
//                }
//
//                //hotelCanvas.setDrawableEntities(entities);
//            }
//        }).start();
    }
}
