package HHS_PROJGR6.Entities;

import HHS_PROJGR6.Interfaces.IEntity;
import HHS_PROJGR6.Utils.Node;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static HHS_PROJGR6.Settings.getPixelResolution;

/*
* Guest class
* Inherits from Entity
*/

public class EntityGuest extends Entity implements IEntity {
    /**
     * Guest number
     */
    private int id;

    /**
     * The preference for a room
     */
    private int preference;

    /**
     * Set of instructions the guest has to follow
     */
    private List<Node> instructions;

    /**
     * 
     * @param entityImage
     */
    public EntityGuest(String entityImage) {
        super(entityImage);
        this.instructions = new ArrayList<Node>();
    }

    /**
     * 
     */
    public void checkout() {
        setID("0");
    }

    /**
     * 
     */
    public void drawEntity(Graphics g) {
        if (instructions.size() > 0) {
            super.drawEntity(g);
        }

    }

    /**
     * 
     * @return
     */
    public int getPreference() {
        return preference;
    }

    /**
     * 
     * @param preference
     */
    public void setPreference(String preference) {
        this.preference = Entity.parseInt(preference);
    }

    /**
     * 
     * @param id
     */
    public void setID(String id) {
        this.id = Entity.parseInt(id);
    }

    /**
     * 
     * @return
     */
    public Integer getID() {
        return id;
    }

    /**
     * 
     * @return
     */
    public boolean getActive() {
        return !(id == 0);
    }

    /**
     * 
     * @param instructions
     */
    public void setInstructions(List<Node> instructions) {
        this.instructions = instructions;
    }

    /**
     * 
     */
    public void Notify() {
        // if has instructions do them
        if (instructions.size() > 0) {
            Node instruction = instructions.get(0);
            setPosition(instruction.getY(), instruction.getX());
            instructions.remove(0);
        }
    }
}
