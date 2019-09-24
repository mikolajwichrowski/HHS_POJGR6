package HHS_PROJGR6;

// imports from project
import HHS_PROJGR6.Entities.*;
import HHS_PROJGR6.External.HotelEvent;
import HHS_PROJGR6.External.HotelEventListener;
import HHS_PROJGR6.External.HotelEventManager;
import HHS_PROJGR6.External.HotelEventType;
import HHS_PROJGR6.Factories.EntityFactory;
import HHS_PROJGR6.Interfaces.IEntity;
import HHS_PROJGR6.Utils.JsonReader;

// External imports
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    public Hotel(Canvas hotelCanvas) {
        // init the canvas and rooms
        this.hotelCanvas = hotelCanvas;
        this.initRooms();

        HotelEventManager eventManager = new HotelEventManager();
        eventManager.register(this);
        eventManager.changeSpeed(2);
        eventManager.start();
    }

    @Override
    public void run() {
        // Timer TODO: oplossen met een design pattern
        Timer t = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < Clock.getClockspeed(); i++) {
                    for (IEntity entity : entities) {
                        entity.Notify();
                    }
                }

                hotelCanvas.setDrawableEntities(entities);
            }
        });

        // Start timer
        t.start();
    }

    /**
     * 
     * @param actor
     */
    private void register(IEntity actor) {
        entities.add(actor);
        hotelCanvas.setDrawableEntities(entities);
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
    private void initRooms() {
        try {
            // Read hotel and get highest position values
            JSONArray jsonArray = (JSONArray) new JsonReader("hotel(1).layout").getJsonObject();
            Iterator i = jsonArray.iterator();
            int[] highestPositions = getHighest(jsonArray, "Position");

            // Init array with the size of the json array (better for memory)
            entities = new ArrayList<IEntity>();

            // Loop trough json array
            while (i.hasNext()) {
                JSONObject jsonObject = (JSONObject) i.next();

                String type = (String) jsonObject.get("AreaType");
                String[] position = ((String) jsonObject.get("Position")).split(",");

                // Dimensions TODO: set dimensions
                String[] dimension = ((String) jsonObject.get("Dimension")).split(",");

                // Reverse the grid layout
                int x = Integer.parseInt(position[1].trim());
                int y = highestPositions[0] + 1 - Integer.parseInt(position[0].trim());

                // Create entity with factory
                IEntity entity = EntityFactory.createEntity(type);
                entity.setPosition(x, y);

                // Add entity
                register(entity);
            }

            // Draw only the nessecary grid size
            hotelCanvas.setGridHeight(highestPositions[1]);
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
        // TODO: make this a better algol

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

    public Canvas getHotelCanvas() {
        return hotelCanvas;
    }

    @Override
    public void Notify(HotelEvent event) {
        if (event.Type == HotelEventType.CHECK_IN) {
            IEntity actor = EntityFactory.createEntity("Guest");
            actor.setPosition(1, 1);

            register(actor);
        }
    }
}
