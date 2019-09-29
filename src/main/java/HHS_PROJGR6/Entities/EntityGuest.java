package HHS_PROJGR6.Entities;

import HHS_PROJGR6.Interfaces.IEntity;

import java.awt.*;
import java.util.ArrayList;

/*
* Guest class
* Inherits from Entity
*/

public class EntityGuest extends Entity implements IEntity {
    private int preference;
    private ArrayList<int[]> nodeMapping;

    public int getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = Integer.parseInt(preference.replaceAll("[^0-9]+", ""));
    }

    // Constructor
    public EntityGuest(Color entityColor) {
        super(entityColor);
    }
    // Action to execute when triggered
    public void Notify(ArrayList<IEntity> entities) {
        // Logic for Guest entity.
        // Make sure to implement features by OOSE principles

        for (IEntity entity: entities) {
            // Welke kamer ga ik naar toe?
            // Is de kamer al bezet?
            // als er een kamer is ga ik daar naartoe
            // Als er geen kamer is dan ga ik weg! en ik wil de manager spreken.
        }

        int[] nextPosition = nextStep();
        setPosition(nextPosition[0], nextPosition[1]);


    }

    public void drawEntity(Graphics g) {
        super.drawEntity(g);
        //g.setColor(Color.BLACK);
        g.fillRect(x * 60, y * 60, 60, 60);
    }

    private int[] nextStep (){
        int[] yx = new int[2];
        yx[0] = getYPosition();
        yx[1] = getXPosition();

        // Pathfinding ...


//        if (getXPosition() == 2) {
//            yx[1] = 3;
//        } else if (getXPosition() == 3) {
//            yx[1] = 4;
//        } else if (getXPosition() == 4) {
//            yx[1] = 5;
//        } else if (getXPosition() == 5) {
//            yx[1] = 6;
//        } else if (getXPosition() == 6) {
//            yx[1] = 7;
//        } else if (getXPosition() == 7) {
//            yx[1] = 8;
//        }

        return yx;
    }
}
