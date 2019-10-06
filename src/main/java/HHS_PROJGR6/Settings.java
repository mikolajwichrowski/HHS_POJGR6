package HHS_PROJGR6;

/**
 * Settings
 */
public class Settings {
    private static int pixelResolution = 62;
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
     * @param pixelResolution
     *                            the pixelResolution to set
     */
    public static void setPixelResolution(int pixelResolution) {
        switch (pixelResolution) {
        case 12:
        case 24:
        case 32:
        case 48:
            pixelResolution = pixelResolution;
            break;

        default:
            // TODO: verander naar default en geef melding aan gebruiker
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
        filthTime = filthTime;
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
        leasureTime = leasureTime;
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
        stairCost = stairCost;
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
        elevatorCost = elevatorCost;
    }
}