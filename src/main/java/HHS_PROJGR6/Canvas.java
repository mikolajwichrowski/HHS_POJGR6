package HHS_PROJGR6;

import HHS_PROJGR6.Interfaces.IEntity;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import static HHS_PROJGR6.Settings.getPixelResolution;

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
    private List<IEntity> drawableEntities;

    /**
     * Generated serial id
     */
    private static final long serialVersionUID = -2041936094389559508L;

    /**
     * 
     */

    public Canvas(Dimension d) {
        // Set sizes
        this.gridHeight = 0;
        this.gridWidth = 0;

        setSize(d);
        repaint();
    }

    /**
     * 
     * @param g
     */
    private void drawGrid(Graphics g) {
        // Loop door elke row heen
        for (int i = 1; i <= this.gridWidth; i++) {
            for (int j = 1; j <= this.gridHeight; j++) {
                g.setColor(Color.BLACK);
                g.drawRect(getPixelResolution(), getPixelResolution(), i * getPixelResolution(), j * getPixelResolution());

            }
        }
    }

    /**
     * 
     * @param g
     */
    private void drawableEntity(Graphics g) {
        // Loop door elke row heen
        for (IEntity entity : drawableEntities) {
            if (entity != null) {
                g.setColor(new Color(189, 189, 189));
                entity.drawEntity(g);
            }
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
    public List<IEntity> getDrawableEntities() {
        return drawableEntities;
    }

    /**
     * 
     */
    public void setDrawableEntities(List<IEntity> drawableEntities) {
        this.drawableEntities = drawableEntities;
        //repaint();
    }

    /**
     * 
     */
    @Override
    protected void paintComponent(Graphics g) {
        drawableEntity(g);
        drawGrid(g);

    }
}
