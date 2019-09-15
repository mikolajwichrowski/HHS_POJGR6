package HHS_PROJGR6;

import java.awt.*;

/*
* Entity class
*/
public class Hotel {
    public Canvas hotelCanvas;
    public String[][] grid;

    // Dimensions mee geven aan hotel zodat deze mee "groeit" zodra de 2d array groter wordt?
    public Dimension d;

    // Creates a grid from 5x6
    public Hotel(Canvas hotelCanvas) {
        this.grid = new String[10][10];
        this.hotelCanvas = hotelCanvas;
        hotelCanvas.setGrid(grid);

    }
}