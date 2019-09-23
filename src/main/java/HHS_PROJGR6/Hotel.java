package HHS_PROJGR6;

import HHS_PROJGR6.Entities.*;
import HHS_PROJGR6.External.HotelEvent;
import HHS_PROJGR6.External.HotelEventType;
import HHS_PROJGR6.External.HotelEventListener;
import HHS_PROJGR6.External.HotelEventManager;
import HHS_PROJGR6.Utils.JsonReader;
import HHS_PROJGR6.Interfaces.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

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
        hotelCanvas.setGridHeight(20);

        // Zo haal je het layout bestand op. Dit geeft voor nu altijd een error in de
        // weeraven maar niet in het starten
        JSONArray array = new JsonReader("hotel(1).layout").getJsonObject();

        Entity[] entities = new Entity[3];
        entities[0] = new EntityDiner();
        entities[0].setPosition(3, 3);

        entities[1] = new EntityGuest();
        entities[1].setPosition(4, 4);

        entities[2] = new EntityHousekeeping();
        entities[2].setPosition(5, 5);

        hotelCanvas.setDrawableEntities(entities);

        // Start Events thread
        // HotelEventManager eventManager = new HotelEventManager();
        // eventManager.register(this);
        // eventManager.changeSpeed(2);
        // new Thread(eventManager).start();
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
}