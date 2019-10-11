package HHS_PROJGR6.Entities;

import java.awt.*;

import static HHS_PROJGR6.Settings.getPixelResolution;

/*
 * Diner class
 * Inherits from Entity
 */

public class EntityDiner extends Entity {
    int capacity;
    int guests;

    // Constructor
    public EntityDiner(String entityImage) {
        super(entityImage);
        this.capacity = 0;
        this.guests = 0;
    }

    public void drawEntity(Graphics g) {
        g.fillRect(getX() * getPixelResolution(), (getY() - (getHeight() - 1)) * getPixelResolution(), getWidth() * getPixelResolution(), getHeight() * getPixelResolution());
        super.drawEntity(g);
    }

    /**
     *
     */
    public void setCapacity(String capacity) {
        this.capacity = Entity.parseInt(capacity);
    }
}
