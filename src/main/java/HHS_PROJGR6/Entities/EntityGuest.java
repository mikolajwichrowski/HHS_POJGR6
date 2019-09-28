package HHS_PROJGR6.Entities;

import HHS_PROJGR6.Interfaces.IEntity;

import java.awt.*;

/*
* Guest class
* Inherits from Entity
*/

public class EntityGuest extends Entity implements IEntity {

    // Constructor
    public EntityGuest(Color entityColor) {
        super(entityColor);
    }
    // Action to execute when triggered
    public void Notify() {
        // Logic for Guest entity.
        // Make sure to implement features by OOSE principles

        if (getXPosition() == 2) {
            setPosition(7, 3);
        } else if (getXPosition() == 3) {
            setPosition(7, 4);
        } else if (getXPosition() == 4) {
            setPosition(7, 5);
        } else if (getXPosition() == 5) {
            setPosition(7, 6);
        } else if (getXPosition() == 6) {
            setPosition(7, 7);
        } else if (getXPosition() == 7) {
            setPosition(7, 8);
        } else if (getYPosition() == 7) {
            setPosition(6, 8);
        } else if (getXPosition() == 8) {
            setPosition(6, 7);
        }
    }

    public void drawEntity(Graphics g) {
        super.drawEntity(g);
        //g.setColor(Color.BLACK);
        g.fillRect(x * 60, y * 60, 60, 60);
    }
}
