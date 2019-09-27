
package HHS_PROJGR6.Entities;

import HHS_PROJGR6.Interfaces.IEntity;

import java.awt.*;

/*
* Diner class
* Inherits from Entity
*/

public class EntityDiner extends Entity implements IEntity {
    private int capacity;
    private int guests;

    // Constructor
    public EntityDiner() {
        this.capacity = 0;
        this.guests = 0;
    }

    // Action to execute when triggered
    public void Notify() {
        // Logic for Diner entity.
        // Make sure to implement features by OOSE principles
        if (false) {
            // Als er een guest bij komt
            this.guests++;
        }
    }

    public void drawEntity(Graphics g) {
        super.drawEntity(g);
        g.setColor(new Color(255, 128, 0));
        g.fillRect(x * 60, (y - (height - 1)) * 60, width * 60, height * 60);
    }

    public void setCapacity(String capacity) {
        this.capacity = Integer.parseInt(capacity.replaceAll("[^0-9]+", ""));
    }

    public boolean getCapacity() {
        return capacity >= guests;
    }
}
