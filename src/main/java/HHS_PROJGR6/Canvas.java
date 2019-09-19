package HHS_PROJGR6;

import HHS_PROJGR6.Entities.Entity;

import javax.swing.*;
import java.awt.*;

/**
 * Entity class
 */
public class Canvas extends JPanel {
    /**
     * 
     */
    private Integer gridHeight;

    /**
     * 
     */
    private Integer gridWidth;

    /**
     * 
     */
    private Entity[] drawableEntities;

    /**
     * Generated serial id
     */
    private static final long serialVersionUID = -2041936094389559508L;

    /**
     * 
     */
    public Canvas(Dimension d) {
        // Set sizes
        this.gridHeight = 10;
        this.gridWidth = 10;

        setSize(d);
        setBackground(Color.BLUE);
        repaint();
    }

    /**
     * 
     * @param g
     */
    private void drawGrid(Graphics g) {
        // Loop door elke row heen
        for (int i = 1; i <= this.gridHeight; i++) {
            for (int j = 1; j <= this.gridWidth; j++) {
                g.setColor(Color.BLACK);
                g.drawRect(30, 30, i * 30, j * 30);
            }
        }
    }

    /**
     * 
     * @param g
     */
    private void drawableEntity(Graphics g) {
        // Loop door elke row heen

        for (Entity entity : drawableEntities) {
            entity.drawEntity(g);
        }
    }

    /**
     * 
     */
    public int getGridHeight() {
        return gridHeight;
    }

    /**
     * 
     */
    public void setGridHeight(int height) {
        this.gridHeight = height;
        repaint();
    }

    /**
     * 
     */
    public int getGridWidth() {
        return gridWidth;
    }

    /**
     * 
     */
    public void setGridWidth(int width) {
        this.gridWidth = width;
        repaint();
    }

    /**
     * 
     */
    public Entity[] getDrawableEntities() {
        return drawableEntities;
    }

    /**
     * 
     */
    public void setDrawableEntities(Entity[] drawableEntities) {
        this.drawableEntities = drawableEntities;
        repaint();
    }

    /**
     * 
     */
    @Override
    protected void paintComponent(Graphics g) {
        drawGrid(g);
        drawableEntity(g);
    }
}
