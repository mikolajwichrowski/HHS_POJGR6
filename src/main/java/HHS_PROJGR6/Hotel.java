package HHS_PROJGR6;

import HHS_PROJGR6.Entities.Entity;
import HHS_PROJGR6.External.HotelEvent;
import HHS_PROJGR6.External.HotelEventListener;
import HHS_PROJGR6.External.HotelEventManager;

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
    public Hotel(Canvas hotelCanvas) 
    {

        // Set grid sizes
        this.grid = new String[23][13];
        // Agregate, hotel contains a canvas
        this.hotelCanvas = hotelCanvas;
        // Set grid on canvas
        hotelCanvas.setGrid(grid);
        hotelCanvas.repaint();

    }

    @Override
    public void Notify(HotelEvent event) 
    {
        System.out.println("From hotel: \n" + event.Message);


        this.grid = new String[10][5];
        hotelCanvas.setGrid(grid);
        hotelCanvas.repaint();
    }

    // TODO: Get event every

    // TODO: Set HTE speed ;)

    // TODO: turn HotelEvent into entity
    
}