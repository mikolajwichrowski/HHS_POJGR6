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
    }

    /**
     * 
     * @param classification
     */
    public void setClassification(String classification) {
        this.classification = Entity.parseInt(classification);
    }

    /**
     * 
     * @param classification
     * @return
     */
    public int getClassification() {
        return this.classification;
    }

    /**
     * @return the inhabitantID
     */
    public int getInhabitantID() {
        return this.inhabitantID;
    }

    /**
     * @param inhabitantID
     *                         the inhabitantID to set
     */
    public void setInhabitantID(int inhabitantID) {
        this.inhabitantID = inhabitantID;
    }

    /**
     * @return the housekeeperID
     */
    public int getHousekeeperID() {
        return this.housekeeperID;
    }

    /**
     * @param inhabitantID
     *                         the housekeeperID to set
     */
    public void setHousekeeperID(int housekeeperID) {
        this.housekeeperID = housekeeperID;
    }

    /**
     * 
     * @return
     */
    public boolean isDirty() {
        return this.dirty >= getFilthTime();
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
}
