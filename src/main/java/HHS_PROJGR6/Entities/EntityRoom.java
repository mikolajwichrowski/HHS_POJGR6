package HHS_PROJGR6.Entities;

import HHS_PROJGR6.External.HotelEvent;
import HHS_PROJGR6.External.HotelEventListener;
import HHS_PROJGR6.Interfaces.IEntity;

import java.awt.*;

import static HHS_PROJGR6.Settings.getPixelResolution;

/*
* Room class
* Inherits from Entity
*/

public class EntityRoom extends Entity implements IEntity {

    private int classification;
    private boolean dirty = false;

    public EntityRoom(Color entityColor) {
        super(entityColor);

        this.classification = 0;
    }

    @Override
    public void drawEntity(Graphics g) {

        g.setColor(entityColor);
        switch (this.classification) {

        case 1:
            g.setColor(new Color(0, 191, 255));
            break;
        case 2:
            g.setColor(new Color(255, 255, 0));
            break;
        case 3:
            g.setColor(new Color(0, 129, 0));
            break;
        case 4:
            g.setColor(new Color(0, 255, 0));
            break;
        case 5:
            g.setColor(new Color(0, 64, 255));
            break;

        default:
            // g.setColor(new Color(255, 255, 255));
            break;
        }
        g.fillRect(x * getPixelResolution(), (y - (height - 1)) * getPixelResolution(), width * getPixelResolution(), height * getPixelResolution());
        super.drawEntity(g);
    }

    // Action to execute when triggered
    public void Notify(HotelEvent event) {
        // Logic for Room entity.
        // Make sure to implement features by OOSE principles
        // TODO: na 10x is deze vies bv
    }

    public void Panic() {
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
    public boolean getClassification(int classification) {
        return this.classification == classification;
    }

    public boolean isDirty() {
        return dirty;
    }

    public void setDirty(boolean dirty) {
        this.dirty = dirty;
    }

    /**
     * 
     */
    public void frame() {
        // TODO: make room dirty after x ticks
    }
}
