/*
 * Nicolas Uribe
 * Homework 3
 * COP 4331 002
 */
package q4_3;

import java.awt.*;
import java.util.List;
import javax.swing.*;

/**
 An icon that contains a moveable shape.
 */
public class ShapeIcon implements Icon
{
    /**
     * Changed shape attribute to shapes attribute which is now a list.
     * From "MoveableShape" to "List<MoveableShape>"
     */
    public ShapeIcon(List<MoveableShape> shapes,
                     int width, int height)
    {
        this.shapes = shapes;
        this.width = width;
        this.height = height;
    }

    public int getIconWidth()
    {
        return width;
    }

    public int getIconHeight()
    {
        return height;
    }

    public void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2 = (Graphics2D) g;
        for (MoveableShape shape : shapes) {
            shape.draw(g2);
        }
    }

    private int width;
    private int height;
    private List<MoveableShape> shapes;
}

