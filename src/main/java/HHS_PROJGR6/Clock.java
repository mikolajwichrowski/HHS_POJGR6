package HHS_PROJGR6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;



/**
 * bron: https://www.youtube.com/watch?v=wznbvBuf8ys TODO: oplossen met een
 * normaal object en een singleton
 */
public class Clock extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 5747202131986299347L;

    /**
     * 
     */
    private static int clockspeed = 1;

    /**
     * 
     */
    public static LocalDateTime datetime = LocalDateTime.now();

    /**
     * 
     */
    public static void addClockspeed() {
        Clock.clockspeed += 1;
    }

    /**
     * 
     */
    public static void reduceClockspeed() {
        Clock.clockspeed -= 1;
    }

    /**
     * 
     * @return
     */
    public static int getClockspeed() {
        return clockspeed;
    }

}
