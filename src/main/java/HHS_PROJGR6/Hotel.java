package HHS_PROJGR6;

import HHS_PROJGR6.Entities.Entity;
import HHS_PROJGR6.External.HotelEvent;
import HHS_PROJGR6.External.HotelEventType;
import HHS_PROJGR6.External.HotelEventListener;
import HHS_PROJGR6.External.HotelEventManager;
import HHS_PROJGR6.Utils.JsonReader;

/**
 * 
 */
public class Hotel implements HotelEventListener {
    /**
     * 
     */
    public Canvas hotelCanvas;

    /**
     * 
     */
    public String[][] grid;

    /**
     * 
     */
    public Entity[] drawableEntities;

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
        hotelCanvas.setWidth(23);
        hotelCanvas.setHeight(13);

        // System.out.println(new JsonReader("hotel(1).layout").getJsonObject());

        // Start Events thread
        // HotelEventManager eventManager = new HotelEventManager();
        // eventManager.register(this);
        // eventManager.changeSpeed(2);
        // new Thread(eventManager).start();
    }

    @Override
    public void Notify(HotelEvent event) {
        if (event.Type == HotelEventType.EVACUATE) {
            hotelCanvas.setWidth(5);
        }
        // What will hotel do if its being called upon?
    }
}git