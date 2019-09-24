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
    public void Notify() {
        // Logic for Guest entity.
        // Make sure to implement features by OOSE principles

        if (getYPosition() == 1) {
            setPosition(2, 1);
        } else if (getYPosition() == 2) {
            setPosition(3, 1);
        } else if (getYPosition() == 3) {
            setPosition(4, 1);
        } else if (getYPosition() == 4) {
            setPosition(5, 1);
        } else if (getYPosition() == 5) {
            setPosition(6, 1);
        } else if (getYPosition() == 6) {
            setPosition(1, 1);
        }
    }

    public void drawEntity(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(XPosition * 30 + 5, YPosition * 30 + 5, 20, 20);
        // g.drawRect(XPosition*30, YPosition*30, 30, 30);

    }
}
