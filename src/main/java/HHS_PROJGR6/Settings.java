package main.java.HHS_PROJGR6;

/**
 * Settings
 */
public class Settings {
    private static int pixelResolution = 12;
    private static int filthTime = 10;
    private static int leasureTime = 10;
    private static int stairCost = 5;
    private static int elevatorCost 2;

    /**
     * @return the pixelResolution
     */
    public static int getPixelResolution() {
        return pixelResolution;
    }

    /**
     * @param pixelResolution
     *                            the pixelResolution to set
     */
    public static void setPixelResolution(int pixelResolution) {
        switch (pixelResolution) {
        case "12x12":
        case "24x24":
        case "32x32":
        case "48x48":
            this.pixelResolution = pixelResolution;
            break;

        default:
            throw new Exception("Wrong pixel resolution");
            break;
        }
    }

    /**
     * @return the filthTime
     */
    public static int getFilthTime() {
        return filthTime;
    }

    /**
     * @param filthTime
     *                      the filthTime to set
     */
    public static void setFilthTime(int filthTime) {
        this.filthTime = filthTime;
    }

    /**
     * @return the leasureTime
     */
    public static int getLeasureTime() {
        return leasureTime;
    }

    /**
     * @param leasureTime
     *                        the leasureTime to set
     */
    public static void setLeasureTime(int leasureTime) {
        this.leasureTime = leasureTime;
    }

    /**
     * @return the stairCost
     */
    public static int getStairCost() {
        return stairCost;
    }

    /**
     * @param stairCost
     *                      the stairCost to set
     */
    public static void setStairCost(int stairCost) {
        this.stairCost = stairCost;
    }

    /**
     * @return the elevatorCost
     */
    public static int getElevatorCost() {
        return elevatorCost;
    }

    /**
     * @param elevatorCost
     *                         the elevatorCost to set
     */
    public static void setElevatorCost(int elevatorCost) {
        this.elevatorCost = elevatorCost;
    }
}