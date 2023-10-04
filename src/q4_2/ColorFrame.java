package q4_2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorFrame extends JFrame {
    private JButton[] btn = new JButton[3];
    private ColorIcon colorIcon;
    private JLabel colorLabel;

    public ColorFrame() {
        setTitle("Color Changer");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        colorIcon = new ColorIcon(Color.YELLOW, 50, 50);
        colorLabel = new JLabel(colorIcon);
        add(colorLabel);

        Color[] colors = new Color[]{Color.RED, Color.YELLOW, Color.BLUE};
        for (int i = 0; i < 3; i++) {
            btn[i] = createButton(i, colors);
            add(btn[i]);
        }
    }

    private JButton createButton(int index, Color[] colors) {
        String[] labels = {"Red", "Yellow", "Blue"};
        JButton button = new JButton(labels[index]);
        final Color c = colors[index];
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorIcon.setColor(c);
                colorLabel.repaint();
            }
        });
        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ColorFrame frame = new ColorFrame();
            frame.setVisible(true);
        });
    }
}

class ColorIcon implements Icon {
    private Color color;
    private int width;
    private int height;

    public ColorIcon(Color color, int width, int height) {
        this.color = color;
        this.width = width;
        this.height = height;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }

    @Override
    public int getIconWidth() {
        return width;
    }

    @Override
    public int getIconHeight() {
        return height;
    }
}
