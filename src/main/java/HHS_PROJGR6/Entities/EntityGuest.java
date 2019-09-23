package HHS_PROJGR6.Entities;

import HHS_PROJGR6.Interfaces.IEntity;

import java.awt.*;

/*
* Guest class
* Inherits from Entity
*/

public class EntityGuest extends Entity implements IEntity {

    // Constructor
    public EntityGuest() {

    }

    // Action to execute when triggered
    public void doAction() {
        // Logic for Guest entity.
        // Make sure to implement features by OOSE principles
    }
    public void drawEntity(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(XPosition*30, YPosition*30, 30, 30);
        //g.drawRect(XPosition*30, YPosition*30, 30, 30);

    }
}
