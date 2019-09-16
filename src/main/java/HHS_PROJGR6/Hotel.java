package HHS_PROJGR6;

/**
 * 
 */
public class Hotel {
    /**
     * 
     */
    public Canvas hotelCanvas;

    /**
     * 
     */
    public String[][] grid;

    /**
     * Hotel class
     * 
     * The object derived from this class must contain all the entities.
     * All the enties will live and act here. Every event is triggered in the object derived from this class.
     * The canvas is aggregated in this class to make sure that only elements from the hotel are drawn on the canvas.
     * 
     * @param hotelCanvas
     */
    public Hotel(Canvas hotelCanvas) {
        // Set grid sizes
        this.grid = new String[23][13];

        // Agregate, hotel contains a canvas
        this.hotelCanvas = hotelCanvas;

        // Set grid on canvas 
        hotelCanvas.setGrid(grid);

        // TODO: Entities .... (Goed nadenken)
    }
}