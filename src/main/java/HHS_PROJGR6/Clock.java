package HHS_PROJGR6;

import java.time.LocalDateTime;

/**
 * bron: https://www.youtube.com/watch?v=wznbvBuf8ys TODO: oplossen met een
 * normaal object en een singleton
 */
public class Clock {

    /**
     *
     */
    private static final long serialVersionUID = 5747202131986299347L;
    /**
     *
     */
    private static double clockspeed = 1.0;
    /**
     *
     */
    public static LocalDateTime datetime = LocalDateTime.now();

    /**
     * Method to make the clockspeed go faster.
     */
    public static void addClockspeed() {
        if (Clock.clockspeed < 2.0) {
            Clock.clockspeed += 0.1;
        }
    }

    /**
     * Method to reduce the clockspeed.
     */
    public static void reduceClockspeed() {
        if (Clock.clockspeed > 0.2) {
            Clock.clockspeed -= 0.1;
        }
    }

    /**
     * @return
     */
    public static double getClockspeed() {
        return Clock.clockspeed;
    }
}
