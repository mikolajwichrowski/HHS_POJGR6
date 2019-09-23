package HHS_PROJGR6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

/**
 * bron: https://www.youtube.com/watch?v=wznbvBuf8ys
 * Timer is een leuk extratje voor de weergave
 */
public class Clock extends JPanel {

    private static final long serialVersionUID = 1L;

    private JTextField timeF;
    private static int clockspeed = 1;
    private Timer internalClock;
    private LocalDateTime datetime;

    public Clock() {
        setBounds(1175,250,175,60);
        setVisible(true);
        datetime = LocalDateTime.now();

        timeF = new JTextField(5);

        // true gezet zodat we straks de tijd kunnen versnellen.
        timeF.setEditable(true);
        timeF.setFont(new Font("Arial", Font.PLAIN, 32));

        add(timeF);


        Timer t = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                datetime = datetime.plusSeconds(Clock.getClockspeed());
                System.out.println(Clock.getClockspeed());
                timeF.setText(datetime.getHour()+":"+datetime.getMinute()+":"+datetime.getSecond());
            }
        });
        t.start();
    }

    public static void addClockspeed() {
        // Iets op bedenken
        Clock.clockspeed += 1;
    }

    public static void decreaseClockspeed(){
        Clock.clockspeed -= 1;
    }

    public static int getClockspeed() {
        return clockspeed;
    }
}
