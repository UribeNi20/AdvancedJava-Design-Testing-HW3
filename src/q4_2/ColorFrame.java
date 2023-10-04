/*
 * Nicolas Uribe
 * Homework 3
 * COP 4331 002
 */
package q4_2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Represents a frame that allows users to change the color of the square.
 */
public class ColorFrame extends JFrame {
    private JButton[] btn = new JButton[3];
    private ColorIcon colorIcon;
    private JLabel colorLabel;


    /**
     * Constructs a ColorFrame
     * Pre: None.
     * Post: A ColorFrame object is initialized with default settings and components.
     */

    public ColorFrame() {
        setTitle("Color Changer");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // What color the box will be to create affect
        colorIcon = new ColorIcon(Color.WHITE, Color.BLACK, 50, 50);
        colorLabel = new JLabel(colorIcon);
        add(colorLabel);

        Color[] colors = new Color[]{Color.RED, Color.YELLOW, Color.BLUE};
        //Given in instructions
        for (int i = 0; i < 3; i++) {
            btn[i] = createButton(i, colors);
            add(btn[i]);
        }
    }

    /**
     * Creates and returns a JButton
     *
     * The index of the button to be created.
     * arrays are colored depending on the button.
     * @return A JButton object with the correct label and action listener.
     *
     * Pre: 0 <= index < 3 and colors.length == 3.
     * Post: A JButton object is returned with the correct label and action listener.
     */
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

/**
 * Represents a colored square (icon) that can be displayed in a JLabel.
 */
class ColorIcon implements Icon {
    private Color fillColor;
    private Color borderColor; // allow the square to be transparent in a way
    private int width;
    private int height;

    public ColorIcon(Color fillColor, Color borderColor, int width, int height) {
        this.fillColor = fillColor;
        this.borderColor = borderColor; // Initialize the border color
        this.width = width;
        this.height = height;
    }

    /**
     * Sets the color of the icon.
     * Pre: color is not null.
     * Post: The color of the icon is updated to the provided color.
     */
    public void setColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        // Fill the rectangle with the fill color
        g.setColor(fillColor);
        g.fillRect(x, y, width, height);

        // Draw a border with the border color
        g.setColor(borderColor);
        g.drawRect(x, y, width, height);
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
