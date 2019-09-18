package HHS_PROJGR6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

/**
 * bron: https://www.youtube.com/watch?v=wznbvBuf8ys
 * Timer is een leuk extratje voor de weergave
 */
public class Clock extends JFrame {

    private static final long serialVersionUID = 1L;

    JTextField timeF;
    JPanel panel;

    public Clock() {
        //super("Java Clock");
        setSize(175, 90);
        setLocation(1180,600);
        setResizable(true);
        setVisible(true);
        //setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        timeF = new JTextField(5);

        // true gezet zodat we straks de tijd kunnen versnellen.
        timeF.setEditable(true);
        timeF.setFont(new Font("Arial", Font.PLAIN, 32));

        panel.add(timeF);
        add(panel);

        Timer t = new Timer(1000, new Listener());
        t.start();
    }

    // deze moet straks in een aparte class
        public class Listener implements ActionListener {
            public void actionPerformed (ActionEvent e) {

                Calendar thisMoment = Calendar.getInstance();

                int hour = thisMoment.get(Calendar.HOUR_OF_DAY);
                int minute = thisMoment.get(Calendar.MINUTE);
                int second = thisMoment.get(Calendar.SECOND);

                timeF.setText(hour+":"+minute+":"+second);
            }
        }
    }
