package HHS_PROJGR6;

import java.awt.*;

/*
* Entity class
*/
public class Hotel {
    public Canvas hotelCanvas;
    public String[][] grid;

    // Creates a grid from 5x6
    public Hotel(Canvas hotelCanvas) {
        this.grid = new String[9][9];
        this.hotelCanvas = hotelCanvas;
        hotelCanvas.setGrid(grid);
    }
}