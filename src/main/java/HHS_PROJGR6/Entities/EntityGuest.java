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
            setPosition(2, 3);
        } else if (getYPosition() == 2) {
            setPosition(3, 3);
        } else if (getYPosition() == 3) {
            setPosition(4, 3);
        } else if (getYPosition() == 4) {
            setPosition(5, 3);
        } else if (getYPosition() == 5) {
            setPosition(6, 3);
        } else if (getYPosition() == 6) {
            setPosition(1, 3);
        }
    }

    public void drawEntity(Graphics g) {
        super.drawEntity(g);
        g.setColor(Color.BLACK);
        g.fillRect(x * 60, y * 60, 60, 60);
    }
}
x