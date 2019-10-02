package HHS_PROJGR6.Entities;

import HHS_PROJGR6.Interfaces.IEntity;

import java.awt.*;
import java.util.List;

/*
* Guest class
* Inherits from Entity
*/

public class EntityGuest extends Entity implements IEntity {
    public String guestID;
    private int preference;

    // Constructor
    public EntityGuest(Color entityColor) {
        super(entityColor);
        this.guestID="";
    }


/*    // Action to execute when triggered
    public void Notify(ArrayList<IEntity> entities) {
        // Logic for Guest entity.
        // Make sure to implement features by OOSE principles

        // for (IEntity entity : entities) {
        // Welke kamer ga ik naar toe?
        // Is de kamer al bezet?
        // als er een kamer is ga ik daar naartoe
        // Als er geen kamer is dan ga ik weg! en ik wil de manager spreken.
        // TODO: zoek lege kamer als niet al in kamer
        // TODO:
        // }

        int[] nextPosition = nextStep();
        setPosition(nextPosition[0], nextPosition[1]);

    }*/

    public void drawEntity(Graphics g) {
        super.drawEntity(g);
        // g.setColor(Color.BLACK);
        g.fillRect(x * 60, y * 60, 60, 60);
    }

    public int getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = Integer.parseInt(preference.replaceAll("[^0-9]+", ""));
    }
}

/*
    private int[] nextStep() {
        int[] yx = new int[2];
        yx[0] = getYPosition();
        yx[1] = getXPosition();

        return yx;
    }
*/

