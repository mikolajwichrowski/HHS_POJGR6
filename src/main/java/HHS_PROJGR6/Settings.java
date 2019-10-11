package HHS_PROJGR6;

/**
 * Settings
 */
public class Settings {
    private static int pixelResolution = 60;
    private static int filthTime = 10;
    private static int leasureTime = 10;
    private static int stairCost = 2;
    private static int elevatorCost = 5;

    /**
     * @return the pixelResolution
     */
    public static int getPixelResolution() {
        return pixelResolution;
    }

    /**
     * @param pixelResolution the pixelResolution to set
     */
    public static void setPixelResolution(int pixelResolution) {
        Settings.pixelResolution = pixelResolution;
    }

    /**
     * @return the filthTime
     */
    public static int getFilthTime() {
        return filthTime;
    }

    /**
     * @param filthTime the filthTime to set
     */
    public static void setFilthTime(int filthTime) {
        Settings.filthTime = filthTime;
    }

    /**
     * @return the leasureTime
     */
    public static int getLeasureTime() {
        return leasureTime;
    }

    /**
     * @param leasureTime the leasureTime to set
     */
    public static void setLeasureTime(int leasureTime) {
        Settings.leasureTime = leasureTime;
    }

    /**
     * @return the stairCost
     */
    public static int getStairCost() {
        return stairCost;
    }

    /**
     * @param stairCost the stairCost to set
     */
    public static void setStairCost(int stairCost) {
        Settings.stairCost = stairCost;
    }

    /**
     * @return the elevatorCost
     */
    public static int getElevatorCost() {
        return elevatorCost;
    }

    /**
     * @param elevatorCost the elevatorCost to set
     */
    public static void setElevatorCost(int elevatorCost) {
        Settings.elevatorCost = elevatorCost;
    }
}