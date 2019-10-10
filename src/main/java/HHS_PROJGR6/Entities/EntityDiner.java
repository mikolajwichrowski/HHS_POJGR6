
package HHS_PROJGR6.Entities;

import HHS_PROJGR6.External.HotelEvent;
import HHS_PROJGR6.Interfaces.IEntity;

import java.awt.*;

import static HHS_PROJGR6.Settings.getPixelResolution;

/*
* Diner class
* Inherits from Entity
*/

public class EntityDiner extends Entity {
    private int capacity;
    private int guests;

    // Constructor
    public EntityDiner(String entityImage) {
        super(entityImage);
        this.capacity = 0;
        this.guests = 0;
    }

    public void drawEntity(Graphics g) {
        g.fillRect(x * getPixelResolution(), (y - (height - 1)) * getPixelResolution(), width * getPixelResolution(), height * getPixelResolution());
        super.drawEntity(g);
    }

    /**
     * 
     */
    public void setCapacity(String capacity) {
        this.capacity = Entity.parseInt(capacity);
    }

    /**
     * 
     */
    public boolean getCapacity() {
        return capacity >= guests;
    }
}
