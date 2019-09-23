package HHS_PROJGR6;

import HHS_PROJGR6.Entities.*;
import HHS_PROJGR6.External.HotelEvent;
import HHS_PROJGR6.External.HotelEventListener;
import HHS_PROJGR6.External.HotelEventType;
import HHS_PROJGR6.Factories.EntityFactory;
import HHS_PROJGR6.Interfaces.IEntity;
import HHS_PROJGR6.Utils.JsonReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.Iterator;
import static HHS_PROJGR6.Enums.EntityType.ENTITY_DINER;

/**
 * 
 */
public class Hotel implements HotelEventListener {
    /**
     * 
     */
    private Canvas hotelCanvas;

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
        this.hotelCanvas = hotelCanvas;
        hotelCanvas.setGridWidth(20);
        hotelCanvas.setGridHeight(30);

        // Start Events thread
        // HotelEventManager eventManager = new HotelEventManager();
        // eventManager.register(this);
        // eventManager.changeSpeed(2);
        // new Thread(eventManager).start();

        roomsInit();
    }

    private void roomsInit() {
        /*
         * @ miek entiteit room waardes meegegeven. Gaarne checken wat je er van vindt.
         * 
         * @ fer/boyd/ruben : Gebruik nu de entity factory om dit te doen ;)
         */

        try {
            JSONArray slideContent = (JSONArray) new JsonReader("hotel(1).layout").getJsonObject();
            Iterator i = slideContent.iterator();

            // Aantal elementen die in de json zitten
            IEntity[] entities = new IEntity[slideContent.size()];

            int counter = 0;
            while (i.hasNext()) {
                JSONObject slide = (JSONObject) i.next();
                String title = (String) slide.get("AreaType");
                String[] position = ((String) slide.get("Position")).split(",");

                // Dimensions
                String[] dimension = ((String) slide.get("Dimension")).split(",");

                // Create entity
                IEntity entity = EntityFactory.createEntity(title);

                // Set entity on array position and set location on entity
                entities[counter] = entity;

                // Reverse
                int x = Integer.parseInt(position[1].trim());
                int y = getHighest(slideContent, "Position")[0] + 1 - Integer.parseInt(position[0].trim());

                entities[counter].setPosition(x, y);

                counter++;
            }

            hotelCanvas.setGridHeight(getHighest(slideContent, "Position")[1]);
            hotelCanvas.setGridWidth(getHighest(slideContent, "Position")[0]);
            hotelCanvas.setDrawableEntities(entities);
        } catch (Exception e) {
            throw e;
        }
    }

    public Canvas getHotelCanvas() {
        return hotelCanvas;
    }

    @Override
    public void Notify(HotelEvent event) {
        if (event.Type == HotelEventType.EVACUATE) {
            hotelCanvas.setGridWidth(5);
        }
        // What will hotel do if its being called upon?
    }

    private int[] getHighest(JSONArray array, String value) {
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
            System.out.println("TODO ALL OF THIS");
        }
        return highes;
    }
}
