package q4_2;
import javax.swing.*;
import java.awt.*;

public class ColorFrame extends JFrame {
    private JButton[] btn = new JButton[3];
    private ColorIcon colorIcon = new ColorIcon(Color.YELLOW);
    private JLabel colorLabel = new JLabel(colorIcon);

    public ColorFrame() {
        setLayout(new FlowLayout());

        for (int i = 0; i < 3; i++) {
            btn[i] = createButton(i);
            add(btn[i]);
        }

        add(colorLabel);
        pack();
        setVisible(true);
    }

    private JButton createButton(int index) {
        String[] labels = {"Red", "Yellow", "Blue"};
        Color[] colors = {Color.RED, Color.YELLOW, Color.BLUE};

        JButton button = new JButton(labels[index]);
        button.addActionListener(e -> {
            colorIcon.setColor(colors[index]);
            colorLabel.repaint();
        });

        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ColorFrame::new);
    }
}
