package HHS_PROJGR6.Entities;

import HHS_PROJGR6.Interfaces.IEntity;

import java.awt.*;

/*
* Room class
* Inherits from Entity
*/

public class EntityRoom extends Entity implements IEntity {
    public Color roomColor;

    private int classification;

    public EntityRoom(Color roomColor) {
        this.roomColor = roomColor;
        this.classification = 0;
    }

    @Override
    public void drawEntity(Graphics g) {
        super.drawEntity(g);
        g.setColor(roomColor);
        switch (this.classification) {

        case 1:
            g.setColor(new Color(0, 64, 255));
            break;

        case 2:
            g.setColor(new Color(255, 255, 0));
            break;
        case 3:
            g.setColor(new Color(255, 0, 128));
            break;
        case 4:
            g.setColor(new Color(0, 255, 0));
            break;

            case 5:
                g.setColor(new Color(0, 255, 191));
                break;

        default:
           // g.setColor(new Color(255, 255, 255));
            break;
        }
        g.fillRect(x * 60, (y - (height - 1)) * 60, width * 60, height * 60);
    }

    // Action to execute when triggered
    public void Notify() {
        // Logic for Room entity.
        // Make sure to implement features by OOSE principles
    }

    public void setClassification(String classification) {
        this.classification = Integer.parseInt(classification.replaceAll("[^0-9]+", ""));
    }

    public boolean getClassification(int classification) {
        return this.classification == classification;
    }
}
