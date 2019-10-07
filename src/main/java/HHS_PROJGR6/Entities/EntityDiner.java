
package HHS_PROJGR6.Entities;

import HHS_PROJGR6.External.HotelEvent;
import HHS_PROJGR6.Interfaces.IEntity;

import javax.swing.*;
import java.awt.*;

import static HHS_PROJGR6.Settings.getPixelResolution;

/*
* Diner class
* Inherits from Entity
*/

public class EntityDiner extends Entity implements IEntity {
    private int capacity;
    private int guests;

    // Constructor
    public EntityDiner(String entityImage) {
        super(entityImage);
        this.capacity = 0;
        this.guests = 0;
    }

    // Action to execute when triggered
    public void Notify(HotelEvent event) {
        // Logic for Diner entity.
        // Make sure to implement features by OOSE principles
        if (false) {
            // Als er een guest bij komt
            this.guests++;
        }
    }

    public void drawEntity(Graphics g) {
        g.fillRect(x * getPixelResolution(), (y - (height - 1)) * getPixelResolution(), width * getPixelResolution(), height * getPixelResolution());
        super.drawEntity(g);
    }

    /**
     * 
     */
    public void setCapacity(String capacity) {
        this.capacity = Integer.parseInt(capacity.replaceAll("[^0-9]+", ""));
    }

    /**
     * 
     */
    public boolean getCapacity() {
        return capacity >= guests;
    }

    /**
     * 
     */
    public void frame() {
        // TODO: ?
    }
}
