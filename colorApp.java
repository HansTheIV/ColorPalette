import javax.swing.*;
import java.awt.*;

public class colorApp {
    public static void createWindow(Color[] colors) {
        JFrame frame1 = new JFrame("Color1");
        JFrame frame2 = new JFrame("Color2");
        JFrame frame3 = new JFrame("Color3");
        JFrame frame4 = new JFrame("Color4");
        JFrame frame5 = new JFrame("Color5");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.getContentPane().setBackground(colors[0]);
        frame2.getContentPane().setBackground(colors[1]);
        frame3.getContentPane().setBackground(colors[2]);
        frame4.getContentPane().setBackground(colors[3]);
        frame5.getContentPane().setBackground(colors[4]);
        frame1.setLocation(0, 600);
        frame2.setLocation(400, 600);
        frame3.setLocation(800, 600);
        frame4.setLocation(1200, 600);
        frame5.setLocation(1600, 600);
        frame1.pack();
        frame2.pack();
        frame3.pack();
        frame4.pack();
        frame5.pack();
        frame1.setSize(400, 400);
        frame2.setSize(400, 400);
        frame3.setSize(400, 400);
        frame4.setSize(400, 400);
        frame5.setSize(400, 400);
        frame1.setVisible(true);
        frame2.setVisible(true);
        frame3.setVisible(true);
        frame4.setVisible(true);
        frame5.setVisible(true);
        frame1.setState(Frame.NORMAL);
        frame2.setState(Frame.NORMAL);
        frame3.setState(Frame.NORMAL);
        frame4.setState(Frame.NORMAL);
        frame5.setState(Frame.NORMAL);

    }
}
