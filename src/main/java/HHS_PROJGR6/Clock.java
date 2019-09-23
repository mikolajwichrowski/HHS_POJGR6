package HHS_PROJGR6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

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
    private static JTextField timeDisplay;

    /**
     * 
     */
    private static JTextField timeFactor;

    /**
     * 
     */
    private static int clockspeed = 1;

    /**
     * 
     */
    private static LocalDateTime datetime;

    /**
     * 
     */
    public Clock() {
        // Init panel, show panel and set current (start)datetime
        setBounds(1175, 250, 175, 120);
        setVisible(true);
        datetime = LocalDateTime.now();

        // Init display fields
        timeDisplay = new JTextField(5);
        timeFactor = new JTextField(5);

        // Set time display and factor display style
        timeDisplay.setFont(new Font("Consolas", Font.PLAIN, 32));
        timeDisplay.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        timeFactor.setFont(new Font("Consolas", Font.PLAIN, 32));
        timeFactor.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        // Add to current panel
        add(timeDisplay);
        add(timeFactor);

    }

    public static void updateState() {
        // The factor only changes when time goes faster
        timeFactor.setText("HTE: " + getClockspeed());

        // Set the visible time
        datetime = datetime.plusSeconds(Clock.getClockspeed());

        // Format time and display
        timeDisplay.setText(datetime.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM)));
    }

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
