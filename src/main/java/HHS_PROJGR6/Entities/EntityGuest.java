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

public class EntityGuest extends Entity implements IEntity, HotelEventListener {
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

    // Action to execute when triggered
    public void Notify(HotelEvent event) {
        // int[] nextPosition = nextStep();
        // setPosition(nextPosition[0], nextPosition[1]);
        switch (event.Type) {
        case CHECK_IN:
            // Set guest id for check in guest
            // TODO: vraag pathfinding algoritme aan en zet in instructies
            break;
        case CHECK_OUT:
            // guest does not exist anymor
            this.guestId = 0;
            // TODO: vraag pathfinding naar deur aan
            break;
        case NEED_FOOD:
            // TODO haal food
            break;
        case GOTO_CINEMA:
            // TO DO GO TO INEMA
            break;
        case GOTO_FITNESS:
            // Gast moet naar fitness GASTID + HTE
            break;
        default:
            // Gewoon doorgaan met de set van instructies die hij moet doen
            // Node currentInstruction = instructions.get(0);
            // setPosition(instructions.getY(), instructions.getX());
            // instructions.remove(0);
            break;
        }
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
