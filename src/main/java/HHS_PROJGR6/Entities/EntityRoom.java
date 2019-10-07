package HHS_PROJGR6.Entities;

import HHS_PROJGR6.External.HotelEvent;
import HHS_PROJGR6.Interfaces.IEntity;
import HHS_PROJGR6.Interfaces.IStressable;

import javax.swing.*;
import java.awt.*;

import static HHS_PROJGR6.Settings.getPixelResolution;

/*
* Room class
* Inherits from Entity
*/

public class EntityRoom extends Entity implements IEntity, IStressable {
    private int inhabitantID;
    private int classification;
    private boolean dirty = false;

    public EntityRoom(String entityImage) {
        super(entityImage);
        this.classification = 0;
        this.inhabitantID = 0;
    }

    @Override
    public void drawEntity(Graphics g) {
        g.fillRect(x * getPixelResolution(), (y - (height - 1)) * getPixelResolution(), width * getPixelResolution(), height * getPixelResolution());

        switch (this.classification) {
        case 1:
            this.entityImage = "Images/star1.png";

            break;
        case 2:
            this.entityImage = "Images/star2.png";
            break;
        case 3:
            this.entityImage = "Images/star3.png";
            break;
        case 4:
            this.entityImage = "Images/star4.png";

            break;
        case 5:
            this.entityImage = "Images/star5.png";
            break;
        default:
            break;
        }
        super.drawEntity(g);
    }

    public void panic() {
        this.dirty = true;
    }

    /**
     * 
     * @param classification
     */
    public void setClassification(String classification) {
        // TODO: verplaatsen naar een util
        this.classification = Integer.parseInt(classification.replaceAll("[^0-9]+", ""));
    }

    /**
     * 
     * @param classification
     * @return
     */
    public int getClassification() {
        return this.classification;
    }

    public boolean isDirty() {
        return dirty;
    }

    public void setDirty(boolean dirty) {
        this.dirty = dirty;
    }

    /**
     * @return the inhabitantID
     */
    public int getInhabitantID() {
        return inhabitantID;
    }

    /**
     * @param inhabitantID
     *                         the inhabitantID to set
     */
    public void setInhabitantID(int inhabitantID) {
        this.inhabitantID = inhabitantID;
    }

    /**
     * 
     */
    public void frame() {
        // TODO: make room dirty after x ticks
    }
}
