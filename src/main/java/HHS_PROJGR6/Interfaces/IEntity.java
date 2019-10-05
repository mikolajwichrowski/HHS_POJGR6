package HHS_PROJGR6.Interfaces;

import java.awt.*;
import java.util.ArrayList;

public interface IEntity {
    void drawEntity(Graphics g);

    void setPosition(Integer x, Integer y);

    void setDimensions(Integer width, Integer height);

    int getXPosition();

    int getYPosition();

    int getWidth();

    int getHeight();

    void frame();
}