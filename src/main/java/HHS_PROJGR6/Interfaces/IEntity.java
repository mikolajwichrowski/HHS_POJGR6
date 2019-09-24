package HHS_PROJGR6.Interfaces;

import java.awt.*;

public interface IEntity {

    void Notify();

    void drawEntity(Graphics g);

    void setPosition(Integer x, Integer y);

    void setDimensions(Integer width, Integer height);
}