package HHS_PROJGR6;

import javax.swing.*;
import java.awt.*;

/**
 * Entity class
 */

public class Canvas extends JPanel {
    public String[][] grid;

    /**
     * Generated serial id
     */

    private static final long serialVersionUID = -2041936094389559508L;

    // Constructor
    public Canvas(Dimension d) {
        setSize(d);
        setBackground(Color.BLUE);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        drawGrid(g);
    }

    // Draw een grid for hotel.
    private void drawGrid(Graphics g) {

        // Loop door elke row heen
        int currentRow = 0;
        for (String[] row : grid) {
            // Loop door elke cell heen in de de row array
            int currentCell = 0;

            for (String cell : row) {
                // TODO: Draw grid
                g.setColor(Color.BLACK);
                g.drawRect(50,50, currentRow *50, currentCell * 50);


                //g.drawString("E", currentRow * 50, currentCell * 50);

                // Increment onze teller van welke cel in de row we tekenen.
                currentCell++;
            }
            // Increment onze teller van welke row we tekenen.
            currentRow++;
        }
    }


    public String[][] getGrid() {
        return grid;
    }

    public void setGrid(String[][] grid) {
        this.grid = grid;
    }
}

