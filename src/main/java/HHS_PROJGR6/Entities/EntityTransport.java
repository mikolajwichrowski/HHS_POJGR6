
package HHS_PROJGR6.Entities;

import HHS_PROJGR6.Interfaces.IEntity;

import java.awt.*;

/*
* Diner class
* Inherits from Entity
*/

public class EntityTransport extends Entity implements IEntity {

    // Constructor
    public EntityTransport() {

    }

    // Action to execute when triggered
    public void Notify() {
        // Logic for Diner entity.
        // Make sure to implement features by OOSE principles
    }

    public void drawEntity(Graphics g) {
        super.drawEntity(g);
        g.setColor(Color.GRAY);
        g.fillRect(x * 60, (y - (height - 1)) * 60, width * 60, height * 60);


    }
}
