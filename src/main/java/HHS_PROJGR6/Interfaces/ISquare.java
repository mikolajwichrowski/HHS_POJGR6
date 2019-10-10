package HHS_PROJGR6.Interfaces;

/**
 * ISquare
 */
public interface ISquare {
    void setPosition(Integer x, Integer y);

    void setDimensions(Integer width, Integer height);

    int getX();

    int getY();

    int getWidth();

    int getHeight();
}