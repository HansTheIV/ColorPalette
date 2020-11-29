import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static Color getStartColor()
    {
        Scanner sc = new Scanner(System.in);
        while(true)
        {
            try
            {
                System.out.print("Enter 3 values for Red, Green, Blue, in that order, between 0 and 255, separated by spaces: ");
                String str = sc.nextLine();
                String[] vals = str.split(" ");
                if(vals.length > 3)
                {
                    throw new IllegalArgumentException("Illegal format.");
                }
                int r = Integer.parseInt(vals[0]);
                int g = Integer.parseInt(vals[1]);
                int b = Integer.parseInt(vals[2]);
                Color c = new Color(r, g, b);
                return c;
            }catch (Exception e)
            {
                System.out.print(Arrays.toString(e.getStackTrace()));
            }
        }
    }

    public static void main(String[] args) {
        Color f = getStartColor();
        palette p = new palette(f);
        Color[] colors = p.getPalette();
        colorApp.createWindow(colors);
    }
}
