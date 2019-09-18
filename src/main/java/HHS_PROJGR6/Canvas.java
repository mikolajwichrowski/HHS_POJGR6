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
    private Integer height;

    /**
     * 
     */
    private Integer width;

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
        this.height = 0;
        this.width = 0;

        setSize(d);
    }

    /**
     * 
     * @param g
     */
    private void drawGrid(Graphics g) {
        // Loop door elke row heen
        for (int i = 1; i <= this.height; i++) {
            for (int j = 1; j <= this.width; j++) {
                g.setColor(Color.BLACK);
                g.drawRect(50, 50, i * 50, j * 50);
            }
        }
    }

    /**
     * 
     * @param g
     */
    private void drawableEntity(Graphics g) {
        // Loop door elke row heen
        drawableEntities = new Entity[1];
        drawableEntities[0] = new Entity();

        for (Entity entity : drawableEntities) {
            entity.drawEntity(g);
        }
    }

    /**
     * 
     */
    public int getHeight() {
        return height;
    }

    /**
     * 
     */
    public void setHeight(int height) {
        this.height = height;
        repaint();
    }

    /**
     * 
     */
    public int getWidth() {
        return width;
    }

    /**
     * 
     */
    public void setWidth(int width) {
        this.width = width;
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
