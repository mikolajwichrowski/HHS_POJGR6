package HHS_PROJGR6.Entities;

import HHS_PROJGR6.External.HotelEvent;
import HHS_PROJGR6.External.HotelEventListener;
import HHS_PROJGR6.Interfaces.IEntity;
import HHS_PROJGR6.Interfaces.IStressable;
import HHS_PROJGR6.External.*;
import HHS_PROJGR6.Utils.Node;

import java.awt.*;
import java.util.ArrayList;

import static HHS_PROJGR6.Settings.getPixelResolution;

/*
* Guest class
* Inherits from Entity
*/

public class EntityGuest extends Entity implements IEntity, IStressable {
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
    public EntityGuest(String entityImage) {
        super(entityImage);
        this.instructions = new ArrayList<Node>();
    }

    public void goToRestaurant() {
        // TODO: get path to restaurant
    }

    public void goToCinema() {
        // TODO: get path to cinema
    }

    public void goToFitness() {
        // TODO: get path to fittness
    }

    public void checkout() {
        this.guestId = 0;
        // TODO: get path to exit
    }

    public void panic() {
        // Gast sterft, verander image van gast naar dode gast? || Stop tekenen van
        // guest?
    }

    public void drawEntity(Graphics g) {
        g.setColor(entityColor);
        g.fillRect(x * getPixelResolution(), y * getPixelResolution(), getPixelResolution(), getPixelResolution());

        super.drawEntity(g);
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

    public static Integer parseInt(String someText) {
        return Integer.parseInt(someText.replaceAll("[^0-9]+", ""));
    }

    /**
     * 
     */
    public void frame() {
        // TODO: if has instructions
        Node instruction = instructions.get(0);
        setPosition(instruction.getY(), instruction.getX());
        instructions.remove(0);

        // TODO: if on room
        // make dirty

        // TODO: if no instructions and no movie playing
        // Go back to room
    }
}
