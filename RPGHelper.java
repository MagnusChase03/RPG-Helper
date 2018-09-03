import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RPGHelper extends JFrame {

    public static void makeDiceButton(String name, int x, int y, int dice, JLabel label, JPanel panel) {

        JButton button = new JButton(name);
        button.setForeground(Color.WHITE);
        button.setBackground(Color.BLACK);
        button.setFont(new Font("Ubuntu Mono", Font.PLAIN, 16));
        button.setBounds(x, y, 75, 50);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getModifiers() == 16) {
                    int num = (int) Math.round(Math.random() * dice + 1);
                    label.setText(String.valueOf(num));
                }
            }
        });
        panel.add(button);

    }

    public static void makeHealthButton(String name, int x, int y, int change, JLabel label, JPanel panel) {

        JButton button = new JButton(name);
        button.setForeground(Color.WHITE);
        button.setBackground(Color.BLACK);
        button.setFont(new Font("Ubuntu Mono", Font.PLAIN, 16));
        button.setBounds(x, y, 75, 50);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getModifiers() == 16) {
                    int num = Integer.valueOf(label.getText()) + change;
                    label.setText(String.valueOf(num));
                }
            }
        });
        panel.add(button);

    }

    public RPGHelper() {

        JFrame frame = new JFrame("RPG Helper");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
        panel.setLayout(null);
        frame.add(panel);

        JTextArea text = new JTextArea();
        JScrollPane scroll = new JScrollPane(text);
        text.setForeground(Color.WHITE);
        text.setBackground(Color.BLACK);
        text.setFont(new Font("Ubuntu Mono", Font.PLAIN, 16));
        text.setCaretColor(Color.WHITE);
        text.setMargin(new Insets(8, 8, 8, 8));
        scroll.setBounds(20, 20, 460, 100);
        panel.add(scroll);

        JLabel roll = new JLabel("None");
        roll.setForeground(Color.WHITE);
        roll.setFont(new Font("Ubuntu Mono", Font.BOLD, 40));
        roll.setBounds(220, 300, 100, 100);
        panel.add(roll);

        makeDiceButton("D20", 20, 140, 19, roll, panel);
        makeDiceButton("D12", 105, 140, 11, roll, panel);
        makeDiceButton("D10", 190, 140, 9, roll, panel);
        makeDiceButton("D8", 275, 140, 7, roll, panel);
        makeDiceButton("D6", 360, 140, 5, roll, panel);
        makeDiceButton("D4", 190, 200, 3, roll, panel);

        JLabel health = new JLabel("10");
        health.setForeground(Color.WHITE);
        health.setFont(new Font("Ubuntu Mono", Font.BOLD, 40));
        health.setBounds(220, 400, 100, 100);
        panel.add(health);

        makeHealthButton("+", 115, 425, 1, health, panel);
        makeHealthButton("-", 295, 425, -1, health, panel);

        frame.setVisible(true);

    }

    public static void main(String[] args) {

        new RPGHelper();

    }

}
