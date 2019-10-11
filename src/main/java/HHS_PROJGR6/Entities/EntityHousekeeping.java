package HHS_PROJGR6.Entities;

import HHS_PROJGR6.Interfaces.IEntity;
import HHS_PROJGR6.Utils.Node;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/*
 * Housekeeping class
 * Inherits from Entity
 */

public class EntityHousekeeping extends Entity implements IEntity {
    /**
     *
     */
    private int id;

    /**
     * Set of instructions the guest has to follow
     */
    private List<Node> instructions;

    /**
     * @param entityImage
     */
    public EntityHousekeeping(String entityImage) {
        super(entityImage);
        this.instructions = new ArrayList<Node>();
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

    /**
     *
     */
    public void drawEntity(Graphics g) {
        if (instructions.size() > 0) {
            super.drawEntity(g);
        }
    }

    /**
     * @return
     */
    public boolean getActive() {
        return instructions.size() > 0;
    }

    /**
     * @return
     */
    public Integer getID() {
        return id;
    }

    /**
     * @param instructions
     */
    public void setInstructions(List<Node> instructions) {
        this.instructions = instructions;
    }

    /**
     * @param id
     */
    public void setID(String id) {
        this.id = Entity.parseInt(id);
    }

}
