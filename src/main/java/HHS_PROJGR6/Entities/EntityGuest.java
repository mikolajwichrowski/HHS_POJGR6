package HHS_PROJGR6.Entities;

import HHS_PROJGR6.Interfaces.IEntity;
import HHS_PROJGR6.External.*;
import HHS_PROJGR6.Utils.Node;

import java.awt.*;
import java.util.ArrayList;

/*
* Guest class
* Inherits from Entity
*/

public class EntityGuest extends Entity implements IEntity {
    /**
     * Guest number
     */
    private int guestId;

    /**
     * The preference for a room
     */
    private int preference;

    /**
     * Set of instructions the guest has to follow
     */
    private ArrayList<Node> instructions;

    // Constructor
    public EntityGuest(Color entityColor) {
        super(entityColor);
    }

    public void checkout(){
        // Loop naar xyEntityLobby
        // Verwijder uit hotel

    }

    public void Panic(){
        // Gast sterft, verander image van gast naar dode gast? || Stop tekenen van guest?

    }

    public void drawEntity(Graphics g) {
        super.drawEntity(g);
        // g.setColor(Color.BLACK);
        g.fillRect(x * 60, y * 60, 60, 60);
    }

    public int getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = EntityGuest.parseInt(preference);
    }

    public void setID(String id) {
        this.guestId = EntityGuest.parseInt(id);
    }

    public Integer getID() {
        return this.guestId;
    }

    public boolean getActive() {
        return this.guestId != 0 && this.instructions.size() > 0;
    }

    private static Integer parseInt(String someText) {
        return Integer.parseInt(someText.replaceAll("[^0-9]+", ""));
    }
}
