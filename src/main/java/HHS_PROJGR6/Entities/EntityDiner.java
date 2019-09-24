
package HHS_PROJGR6.Entities;

import HHS_PROJGR6.Interfaces.IEntity;

import java.awt.*;

/*
* Diner class
* Inherits from Entity
*/

public class EntityDiner extends Entity implements IEntity {

    // Constructor
    public EntityDiner() {

    }

    // Action to execute when triggered
    public void Notify() {
        // Logic for Diner entity.
        // Make sure to implement features by OOSE principles
    }

    public void drawEntity(Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillRect(x * 30, y * 30, width * 30, height * 30);
    }
}
