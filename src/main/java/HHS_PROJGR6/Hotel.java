package HHS_PROJGR6;

public class Hotel {
    public Canvas hotelCanvas;
    public String[][] grid;

    // Creates a grid
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