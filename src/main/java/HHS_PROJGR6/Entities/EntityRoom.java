package HHS_PROJGR6.Entities;

import HHS_PROJGR6.External.HotelEvent;
import HHS_PROJGR6.External.HotelEventListener;
import HHS_PROJGR6.Interfaces.IEntity;
import HHS_PROJGR6.Interfaces.IStressable;

import java.awt.*;

import static HHS_PROJGR6.Settings.getPixelResolution;

/*
* Room class
* Inherits from Entity
*/

public class EntityRoom extends Entity implements IEntity, IStressable {

    private int classification;
    private boolean dirty = false;

    public EntityRoom(String entityImage) {
        super(entityImage);
        this.classification = 0;
    }

    @Override
    public void drawEntity(Graphics g) {
        g.setColor(new Color(84, 84, 84));
        g.fillRect(x * getPixelResolution(), (y - (height - 1)) * getPixelResolution(), width * getPixelResolution(), height * getPixelResolution());

        switch (this.classification) {
        case 1:
            this.entityImage = Toolkit.getDefaultToolkit().getImage("Images/star1.png");

            break;
        case 2:
            this.entityImage = Toolkit.getDefaultToolkit().getImage("Images/star2.png");
            break;
        case 3:
            this.entityImage = Toolkit.getDefaultToolkit().getImage("Images/star3.png");
            break;
        case 4:
            this.entityImage = Toolkit.getDefaultToolkit().getImage("Images/star4.png");

            break;
        case 5:
            this.entityImage = Toolkit.getDefaultToolkit().getImage("Images/star5.png");
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
