package HHS_PROJGR6;

import HHS_PROJGR6.Entities.Entity;
import HHS_PROJGR6.Entities.EntityRoom;
import HHS_PROJGR6.External.HotelEvent;
import HHS_PROJGR6.External.HotelEventListener;
import HHS_PROJGR6.External.HotelEventType;

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
    // private Entity[] drawableEntities;

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

        Entity[] entities = new Entity[4];
        entities[0] = new Entity();
        entities[0].setPosition(3, 3);
        entities[1] = new Entity();
        entities[1].setPosition(4, 4);
        entities[2] = new Entity();
        entities[2].setPosition(5, 5);

        /*
        @ miek entiteit room waardes meegegeven. Gaarne checken wat je er van vindt.
        @ fer/boyd/ruben : Gebruik nu de entity factory om dit te doen ;) 
         */
        entities[3] = new EntityRoom(2,true);
        entities[3].setPosition(7,7);

        hotelCanvas.setDrawableEntities(entities);

        // System.out.println(new JsonReader("hotel(1).layout").getJsonObject());

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
