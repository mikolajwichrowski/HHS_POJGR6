package HHS_PROJGR6.Entities;

import HHS_PROJGR6.Interfaces.IEntity;

import java.awt.*;

import static HHS_PROJGR6.Settings.getPixelResolution;
import static HHS_PROJGR6.Settings.getFilthTime;

/*
 * Room class
 * Inherits from Entity
 */

public class EntityRoom extends Entity implements IEntity {
    /**
     *
     */
    private int inhabitantID;

    /**
     *
     */
    private int housekeeperID;

    /**
     *
     */
    private int classification;

    /**
     *
     */
    private int dirty;

    /**
     *
     */
    public EntityRoom(String entityImage, String classification) {
        super(entityImage);
        setClassification(classification);
        this.inhabitantID = 0;
        this.housekeeperID = 0;
        this.dirty = 0;
    }

    /**
     *
     */
    public void drawEntity(Graphics g) {
        g.fillRect(getX() * getPixelResolution(), (getY() - (getHeight() - 1)) * getPixelResolution(), getWidth() * getPixelResolution(), getHeight() * getPixelResolution());
        super.drawEntity(g);

        // Draw status
        boolean drawStatus = false;
        if (this.inhabitantID != 0) {
            g.setColor(Color.green);
            drawStatus = true;
        }

        if (isDirty()) {
            g.setColor(Color.red);
            drawStatus = true;
        }

        if (this.housekeeperID != 0) {
            g.setColor(Color.orange);
            drawStatus = true;
        }

        if (drawStatus) {
            g.drawRect(getX() * getPixelResolution() + 1, (getY() - (getHeight() - 1)) * getPixelResolution() + 1, (getWidth() * getPixelResolution()) - 2, (getHeight() * getPixelResolution()) - 2);
            // Reset color
            g.setColor(Color.black);
        }

    }

    /**
     * @param classification
     */
    public void setClassification(String classification) {
        this.classification = Entity.parseInt(classification);
    }

    /**
     * @return
     */
    public boolean isDirty() {
        return this.dirty >= getFilthTime();
    }

    /**
     *
     */
    public void makeDirty() {
        this.dirty = getFilthTime();
    }

    /**
     *
     */
    public void cleanRoom() {
        this.housekeeperID = 0;
        this.dirty = 0;
    }

    /**
     * Room gets dirtier with every second if there is an inhabitant
     */
    public void Notify() {
        if (this.inhabitantID != 0) {
            this.dirty++;
        }
    }

    /**
     * @return
     */
    public int getClassification() {
        return this.classification;
    }

    /**
     * @return the housekeeperID
     */
    public int getHousekeeperID() {
        return this.housekeeperID;
    }

    /**
     * @return the inhabitantID
     */
    public int getInhabitantID() {
        return this.inhabitantID;
    }

    /**
     * @param inhabitantID the inhabitantID to set
     */
    public void setInhabitantID(int inhabitantID) {
        this.inhabitantID = inhabitantID;
    }

    /**
     * @param housekeeperID
     */
    public void setHousekeeperID(int housekeeperID) {
        this.housekeeperID = housekeeperID;
    }

}
