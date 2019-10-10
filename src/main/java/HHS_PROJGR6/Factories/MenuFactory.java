package HHS_PROJGR6.Factories;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Made a MenuFactory for al the JButtons, JLabels, JTextfields to make the code more DRY in class Menu.
 */
public class MenuFactory {

    /**
     * Method for the JButtons that returns a text, type, position, and a action.
     * the ternary operator gives the right positions to the JButtons.
     * The switch statement gives the right color to the button.
     *
     * @param text
     * @param type
     * @param position
     * @param action
     * @return
     */
    public static JButton createJButton(String text, String type, int position, ActionListener action) {
        JButton button = new JButton(text);
        button.setBounds(type == "plus" ? 20 : 228, 30 + (position * 70), 100, 40);

        switch (type) {
            case "plus":
                button.setBackground(new Color(112, 219, 112));
                button.setForeground(new Color(255, 255, 255));
                break;

            case "min":
                button.setBackground(new Color(255, 77, 77));
                button.setForeground(new Color(255, 255, 255));
                break;

            default:
                return button;
        }
        button.addActionListener(action);
        return button;
    }

    /**
     * Method for the JLabels that returns a (diffrent) text and a (y) position.
     *
     * @param text
     * @param position
     * @return
     */
    public static JLabel createJLabel(String text, int position) {
        JLabel label = new JLabel(text);
        label.setBounds(20, 0 + (position * 70), 150, 40);
        label.setFont(new Font("Calabri", Font.ITALIC, 12));
        return label;
    }

    /**
     * Method for the JTextField that returns a (diffrent) text and a (y) position.
     * if the ternary operator is equals 6 than get the JTextField get a diffrent (x position) because of the timeDisplay.
     *
     * @param text
     * @param position
     * @return
     */
    public static JTextField createJTextField(String text, int position) {
        JTextField textField = new JTextField(text);
        textField.setBounds(position == 6 ? 20 : 125, 30 + (position * 70), 100, 40);
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setBorder(null);
        textField.setFont(new Font("Consolas", Font.BOLD, 18));
        return textField;
    }
}
