package HHS_PROJGR6;

import HHS_PROJGR6.Entities.Entity;

public class Hotel {
    public Canvas hotelCanvas;
    public String[][] grid;
    public Entity[] drawableEntities;


    // Creates a grid
    public Hotel(Canvas hotelCanvas) {

        // Set grid sizes
        this.grid = new String[23][13];
        // Agregate, hotel contains a canvas
        this.hotelCanvas = hotelCanvas;
        // Set grid on canvas
        hotelCanvas.setGrid(grid);
        hotelCanvas.repaint();


        // hotelCanvas.setEntity
/*        hotelCanvas.setEntities(drawEntity); // 1x aan het begin*/


/*        // elke actie/frme
        drawEntity[0].doAction();
        hotelCanvas.setEntities(drawEntity);
        hotelCanvas.repaint();*/

        // TODO: Entities .... (Goed nadenken)
    }
}