package HHS_PROJGR6.Entities;

import java.awt.Color;
import java.awt.Graphics;

import HHS_PROJGR6.Interfaces.IEntity;

/*
* Entity class
*/

public class Entity implements IEntity {
    // TODO: dit is belangrijk
    private int XPosition;
    private int YPosition;

    // Constructor
    public Entity() {
        // TODO: Kijk maar of het nodig is
    }

    // Action to execute when triggered
    public void doAction() {
        // Logic for entity.
        // Make sure to implement features by OOSE principles
        // NOT TO DO : hier komen de algoritmes, afblijven
    }

    public void drawEntity(Graphics g) 
    {
        // TODO: Teken mij :)
        g.setColor(Color.RED);
        g.drawRect(50,50, 50, 50);
    }

    // TODO: getters, setters
}


