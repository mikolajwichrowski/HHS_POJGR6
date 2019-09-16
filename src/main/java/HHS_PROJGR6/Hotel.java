package HHS_PROJGR6;

public class Hotel {
    public Canvas hotelCanvas;
    public String[][] grid;

    // Creates a grid from 5x6
    public Hotel(Canvas hotelCanvas) {
        this.grid = new String[23][13];
        this.hotelCanvas = hotelCanvas;
        hotelCanvas.setGrid(grid);
    }
}