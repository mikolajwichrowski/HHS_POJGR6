package HHS_PROJGR6;

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

    /**
     * Generated serial id
     */
    private static final long serialVersionUID = -2041936094389559508L;

    /**
     * 
     * @param dimension
     */
    public Canvas(Dimension dimension) {
        setSize(dimension);
        setBackground(Color.BLUE);
        repaint();
    }

    /**
     * 
     * @return Two dimensional string array with the grid
     */
    public String[][] getGrid() {
        return grid;
    }

    /**
     * 
     * @param grid
     */
    public void setGrid(String[][] grid) {
        this.grid = grid;
    }

    /**
     * 
     * @param g
     */
    private void drawGrid(Graphics g) {
        // Loop door elke row heen
        int currentRow = 0;
        for (String[] row : grid) {
            // Loop door elke cell heen in de de row array
            int currentCell = 0;

            for (String cell : row) {
                // Drawing one square per position
                g.setColor(Color.BLACK);
                g.drawRect(50,50, currentRow *50, currentCell * 50);

                // Increment onze teller van welke cel in de row we tekenen.
                currentCell++;
            }
            // Increment onze teller van welke row we tekenen.
            currentRow++;
        }
    }

    // TODO: Entiteiten tekenen
    // public ..... ..... ... (entieiten, graphics)

    /**
     * We are overriding the paint method because we want to draw our own elements in a specific order.
     */
    @Override
    protected void paintComponent(Graphics g) {
        drawGrid(g);
    }
}

