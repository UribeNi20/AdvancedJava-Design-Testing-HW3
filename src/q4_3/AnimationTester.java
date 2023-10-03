/*
 * Nicolas Uribe
 * Homework 3
 * COP 4331 002
 */
package q4_3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;import java.util.List;
import java.util.Arrays;



/**
 This program implements an animation that moves
 a car shape.
 */
public class AnimationTester
{
    public static void main(String[] args)
    {
        /**
         * Added four cars to the list
         */
        final MoveableShape carA = new CarShape(0, 0, CAR_WIDTH);
        final MoveableShape carB = new CarShape(0, 75, CAR_WIDTH);
        final MoveableShape carC = new CarShape(0, 150, CAR_WIDTH);
        final MoveableShape carD = new CarShape(0, 225, CAR_WIDTH);

        List<MoveableShape> cars = Arrays.asList(carA, carB, carC, carD);
        JFrame frame = new JFrame();


        ShapeIcon icon = new ShapeIcon(cars, ICON_WIDTH, ICON_HEIGHT);


        final JLabel label = new JLabel(icon);
        frame.setLayout(new FlowLayout());
        frame.add(label);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        final int DELAY = 100;
        // Milliseconds between timer ticks
        Timer t = new Timer(DELAY, new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                for (MoveableShape car : cars) {
                    car.translate(1, 0);
                }
                label.repaint();
            }
        });

        t.start();
    }

    private static final int ICON_WIDTH = 400;
    private static final int ICON_HEIGHT = 625;
    private static final int CAR_WIDTH = 100;
}
