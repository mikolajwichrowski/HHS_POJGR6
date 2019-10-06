package HHS_PROJGR6.Entities;

import HHS_PROJGR6.Interfaces.IEntity;

import javax.swing.*;
import java.awt.*;

import static HHS_PROJGR6.Settings.getPixelResolution;

public class EntityLobby extends Entity implements IEntity {

    public EntityLobby(JLabel label) {
        super(label);
    }

    public void drawEntity(Graphics g) {
        //g.setColor(new Color(84, 84, 84));
        //g.fillRect(x * getPixelResolution(), (y - (height - 1)) * getPixelResolution(), width * getPixelResolution(), height * getPixelResolution());
        Image img1 = Toolkit.getDefaultToolkit().getImage("Images/reception1.png");
        g.drawImage(img1, x * getPixelResolution(), y * getPixelResolution(), getPixelResolution(), getPixelResolution(), null);
        super.drawEntity(g);
    }

    /**
     * 
     */
    public void frame() {
        // TODO: nothing
    }
}
