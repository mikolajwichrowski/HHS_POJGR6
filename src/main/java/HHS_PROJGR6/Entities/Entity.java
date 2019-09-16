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

    /**
     * 
     */
    public Entity() {
        // TODO: Kijk maar of het nodig is
    }

    /**
     * Action to execute when triggered
     * 
     * 
     */
    public void doAction() {
        // Logic for entity.
        // Make sure to implement features by OOSE principles
        // NOT TO DO : hier komen de algoritmes, afblijven
    }

    /**
     * 
     * @param graphics
     */
    public void drawEntity(Graphics graphics) 
    {
        // TODO: Teken mij :)
        graphics.setColor(Color.RED);
        graphics.drawRect(50,50, 50, 50);
    }

    // TODO: getters, setters
}


