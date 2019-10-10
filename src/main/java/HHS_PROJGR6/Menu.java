package HHS_PROJGR6;

import HHS_PROJGR6.Factories.MenuFactory;

import javax.swing.*;
import java.awt.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Menu extends JFrame {

    /**
     * global JTextField variables
     */
    private JTextField timeFactor, pixelFactor, filthFactor, leasureFactor, elevatorFactor, stairFactor, timeDisplay;

    /**
     * Constructor Menu
     */
    public Menu() {

        //set the (title, size, location, color, layout) of the JFrame(super class) of the Menu.
        setTitle("Regulation screen");
        setSize(365, 540);
        setLocation(0, 0);
        setResizable(true);
        getContentPane().setBackground(new Color(245, 245, 240));
        setLayout(null);

        //add the create Jlabels to the JFrame wich are fabric in the MenuFactory
        add(MenuFactory.createJLabel("Hotel Time Unit", 0));
        add(MenuFactory.createJLabel("Pixel Resolution", 1));
        add(MenuFactory.createJLabel("Cleaning expensive", 2));
        add(MenuFactory.createJLabel("Leasure Time", 3));
        add(MenuFactory.createJLabel("Elevator time", 4));
        add(MenuFactory.createJLabel("Stair time", 5));
        add(MenuFactory.createJLabel("Local time", 6));

        //add the create JTextFields to the JFrame wich are fabric in the MenuFactory
        timeFactor = MenuFactory.createJTextField(String.format("%.1f", Clock.getClockspeed()), 0);
        add(timeFactor);

        pixelFactor = MenuFactory.createJTextField("" + Settings.getPixelResolution(), 1);
        add(pixelFactor);

        filthFactor = MenuFactory.createJTextField("" + Settings.getFilthTime(), 2);
        add(filthFactor);

        leasureFactor = MenuFactory.createJTextField("" + Settings.getLeasureTime(), 3);
        add(leasureFactor);

        elevatorFactor = MenuFactory.createJTextField("" + Settings.getElevatorCost(), 4);
        add(elevatorFactor);

        stairFactor = MenuFactory.createJTextField("" + Settings.getStairCost(), 5);
        add(stairFactor);

        timeDisplay = MenuFactory.createJTextField("" + Clock.datetime.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM)), 6);
        timeDisplay.setBackground(new Color(0, 0, 128));
        timeDisplay.setForeground(new Color(255, 255, 255));
        add(timeDisplay);

        //add the create JButtons to the JFrame wich are fabric in the MenuFactory
        add(MenuFactory.createJButton("Time unit +", "plus", 0, e -> {
            Clock.addClockspeed();
            timeFactor.setText(String.format("%.1f", Clock.getClockspeed()));
        }));

        add(MenuFactory.createJButton("Time unit -", "min", 0, e -> {
            Clock.reduceClockspeed();
            timeFactor.setText(String.format("%.1f", Clock.getClockspeed()));
        }));

        add(MenuFactory.createJButton("Resolution +", "plus", 1, e -> {
            if (Settings.getPixelResolution() < 60) {
                Settings.setPixelResolution(Settings.getPixelResolution() + 10);
                repaint();
            }
            pixelFactor.setText("" + Settings.getPixelResolution());
        }));

        add(MenuFactory.createJButton("Resolution -", "min", 1, e -> {
            if (Settings.getPixelResolution() > 10) {
                Settings.setPixelResolution(Settings.getPixelResolution() - 10);
                repaint();
            }
            pixelFactor.setText("" + Settings.getPixelResolution());
        }));

        add(MenuFactory.createJButton("Cleaning +", "plus", 2, e -> {
            if (Settings.getFilthTime() < 20) {
                Settings.setFilthTime(Settings.getFilthTime() + 2);
            }
            filthFactor.setText("" + Settings.getFilthTime());
        }));

        add(MenuFactory.createJButton("Cleaning -", "min", 2, e -> {
            if (Settings.getFilthTime() > 0) {
                Settings.setFilthTime(Settings.getFilthTime() - 2);
            }
            filthFactor.setText("" + Settings.getFilthTime());
        }));

        add(MenuFactory.createJButton("Leasure +", "plus", 3, e -> {
            if (Settings.getLeasureTime() < 20) {
                Settings.setLeasureTime(Settings.getLeasureTime() + 2);
            }
            leasureFactor.setText("" + Settings.getLeasureTime());
        }));

        add(MenuFactory.createJButton("Leasure -", "min", 3, e -> {
            if (Settings.getLeasureTime() > 0) {
                Settings.setLeasureTime(Settings.getLeasureTime() - 2);
            }
            leasureFactor.setText("" + Settings.getLeasureTime());
        }));

        add(MenuFactory.createJButton("Elevator +", "plus", 4, e -> {
            if (Settings.getElevatorCost() < 10) {
                Settings.setElevatorCost(Settings.getElevatorCost() + 1);
            }
            elevatorFactor.setText("" + Settings.getElevatorCost());
        }));

        add(MenuFactory.createJButton("Elevator -", "min", 4, e -> {
            if (Settings.getElevatorCost() > 0) {
                Settings.setElevatorCost(Settings.getElevatorCost() - 1);
            }
            elevatorFactor.setText("" + Settings.getElevatorCost());
        }));

        add(MenuFactory.createJButton("Stair +", "plus", 5, e -> {
            if (Settings.getStairCost() < 5) {
                Settings.setStairCost(Settings.getStairCost() + 1);
            }
            stairFactor.setText("" + Settings.getStairCost());
        }));

        add(MenuFactory.createJButton("Stair -", "min", 5, e -> {
            if (Settings.getStairCost() > 0) {
                Settings.setStairCost(Settings.getStairCost() - 1);
            }
            stairFactor.setText("" + Settings.getStairCost());
        }));

        // update clock every real time second.
        new Timer(1000, e -> timeDisplay.setText(Clock.datetime.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM)))).start();

    }
}
