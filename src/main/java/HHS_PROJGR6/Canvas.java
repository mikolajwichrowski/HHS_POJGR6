package HHS_PROJGR6;
import HHS_PROJGR6.Entities.Entity;

import javax.swing.*;
import java.awt.*;
/**
 * Entity class
 */
public class Canvas extends JPanel {
    /**
     * Our grid containing ....
     */
    public String[][] grid;
    public Entity[] drawableEntities;

    /**
     * Generated serial id
     */
    private static final long serialVersionUID = -2041936094389559508L;

    // Constructor
    public Canvas(Dimension d) {
        grid = new String[0][0];
        setSize(d);
        setBackground(Color.BLUE);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        drawGrid(g);
        drawableEntity(g);
    }
    
    // Draw een grid for hotel.
    private void drawGrid(Graphics g) {
        // Loop door elke row heen
        int currentRow = 0;
        for (String[] row : grid) {
            // Loop door elke cell heen in de de row array
            int currentCell = 0;
            for (String cell : row) {
                // Draw's grid
                g.setColor(Color.BLACK);
                g.drawRect(50,50, currentRow *50, currentCell * 50);

                // Increment onze teller van welke cel in de row we tekenen.
                currentCell++;
            }
            // Increment onze teller van welke row we tekenen.
            currentRow++;
        }
    }

    private void drawableEntity(Graphics g) {
        // Loop door elke row heen
        drawableEntities = new Entity[1];
        drawableEntities[0] = new Entity();

        for (Entity entity : drawableEntities) {
            entity.drawEntity(g);
        }
    }


    public String[][] getGrid() {
        return grid;
    }

    public void setGrid(String[][] grid) {
        this.grid = grid;
    }
}
