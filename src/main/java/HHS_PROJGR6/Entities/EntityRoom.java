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

public class EntityRoom extends Entity implements IEntity, HotelEventListener {

    private int classification;

    public EntityRoom(Color entityColor) {
        super(entityColor);

        this.classification = 0;
    }

    @Override
    public void drawEntity(Graphics g) {

        g.setColor(entityColor);
        switch (this.classification) {

        case 1:
            Image img1 = Toolkit.getDefaultToolkit().getImage("Images/star1.png");
            g.drawImage(img1, x * getPixelResolution(), y * getPixelResolution(),getPixelResolution(),getPixelResolution(), null);
            //g.setColor(new Color(0, 191, 255));
            break;
        case 2:
            Image img2 = Toolkit.getDefaultToolkit().getImage("Images/star2.png");
            g.drawImage(img2, x * getPixelResolution(), y * getPixelResolution(),getPixelResolution(),getPixelResolution(), null);
            //g.setColor(new Color(255, 255, 0));
            break;
        case 3:
            Image img3 = Toolkit.getDefaultToolkit().getImage("Images/star3.png");
            g.drawImage(img3, x * getPixelResolution(), y * getPixelResolution(),getPixelResolution(),getPixelResolution(), null);
            //g.setColor(new Color(0, 129, 0));
            break;
        case 4:
            Image img4 = Toolkit.getDefaultToolkit().getImage("Images/star4.png");
            g.drawImage(img4, x * getPixelResolution(), y * getPixelResolution(),getPixelResolution(),getPixelResolution(), null);
            //g.setColor(new Color(0, 255, 0));
            break;
        case 5:
            Image img5 = Toolkit.getDefaultToolkit().getImage("Images/star5.png");
            g.drawImage(img5, x * getPixelResolution(), y * getPixelResolution(),getPixelResolution(),getPixelResolution(), null);
            //g.setColor(new Color(0, 64, 255));
            break;

        default:
            Image img6 = Toolkit.getDefaultToolkit().getImage("Images/0star.png");
            g.drawImage(img6, x * getPixelResolution(), y * getPixelResolution(),getPixelResolution(),getPixelResolution(), null);
            // g.setColor(new Color(255, 255, 255));
            break;
        }
        //g.fillRect(x * getPixelResolution(), (y - (height - 1)) * getPixelResolution(), width * getPixelResolution(), height * getPixelResolution());
        super.drawEntity(g);
    }

    // Action to execute when triggered
    public void Notify(HotelEvent event) {
        // Logic for Room entity.
        // Make sure to implement features by OOSE principles
        // TODO: na 10x is deze vies bv
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
}
