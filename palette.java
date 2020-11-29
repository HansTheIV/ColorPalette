import java.awt.Color;
import java.util.Random;

public class palette {
    private final Color starterColor;
    private Color complementaryColor;
    private Color[] palette = new Color[5];

    private float[] convertToHSV(Color color)
    {
        float[] hsv = new float[3];
        Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), hsv);
        return hsv;
    }

    /**
     * Creates a palette using a starting color
     * @param starterColor color object to build a palette from
     */
    public palette(Color starterColor)
    {
         this.starterColor = new Color(starterColor.getRed(), starterColor.getGreen(), starterColor.getBlue());
         generatePalette(starterColor);
    }

    /**
     * Default constructor, sets starting color to white
     */
    public palette()
    {
        System.out.print("Palette color set to white: this may cause poor color matching.");
        this.starterColor = new Color(0, 0, 0);
    }

    public static int getRandomInt(int min, int max)
    {
        if(min > max)
        {
            throw new IllegalArgumentException("Maximum must be greater than minimum");
        }

        return (int)(Math.random() * ((max-min) + 1)) + min;
    }



    /**
     *
     * @param firstColor
     * @return Complementary color, opposite on the color wheel
     */
    private Color createComplementary(Color firstColor)
    {
        float[] colorHSV = convertToHSV(firstColor);
        float newH = ((float) 360.0)-colorHSV[0];
        double posOrNegSeed = Math.random();
        int posNeg;
        if(posOrNegSeed >= 0.5)
        {
            posNeg = 1;
        }
        else
        {
            posNeg = -1;
        }
        float check = (float) (Math.random() * posNeg);
        System.out.println(check);
        newH = colorHSV[0] + check;
        System.out.println(colorHSV[0]);
        System.out.println(newH);

        int colorRGB = Color.HSBtoRGB(newH, colorHSV[1], colorHSV[2]);
        Color complementary = new Color(colorRGB);
        return complementary;

    }

    /**
     *
     * @param testColor
     * @return
     */
    private String getTemperature(Color testColor)
    {
        float differenceBetweenRB = testColor.getRed()-testColor.getBlue();
        // if the red value is more than 10 greater than the blue value, it'll be warm (probably)
        if( differenceBetweenRB > 25)
        {
            if(testColor.getGreen() <= 110)
            {
                return "warm";
            }
            else
            {
                return "cool";
            }
        }
        else
        {
            if(Math.abs(differenceBetweenRB) < 25)
            {
                return "neutral";
            }
            else
            {
                if(testColor.getGreen() >= 110)
                {
                    return "warm";
                }
                else
                {
                    return "cool";
                }
            }
        }
    }

    /**
     * Retrieves generated palette
     * @return Palette array
     */
    public Color[] getPalette()
    {
        return palette;
    }

    public void printPalette()
    {
        for(Color c: palette)
        {
            System.out.println(c);
        }
    }


    /**
     * Creates a dark color based on a color.
     * @param color
     * @return
     */
    private Color createDark(Color color)
    {
        float[] colorHSV = convertToHSV(color);
        colorHSV[1] = getRandomInt(85, 100);
        colorHSV[2] = getRandomInt(20, 30);
        int rgb = Color.HSBtoRGB(colorHSV[0], colorHSV[1], colorHSV[2]);
        return new Color(rgb);

    }

    private Color createLight(Color color)
    {
        float[] colorHSV = convertToHSV(color);
        colorHSV[1] = getRandomInt(15, 35);
        colorHSV[2] = getRandomInt(70, 88);
        int rgb = Color.HSBtoRGB(colorHSV[0], colorHSV[1], colorHSV[2]);
        return new Color(rgb);
    }

    /**
     *
     * @param starterColor
     */
    public void generatePalette(Color starterColor)
    {
        palette[0] = starterColor;
        palette[1] = createComplementary(starterColor);
        palette[2] = createDark(starterColor);
        palette[3] = createDark(palette[2]);
        palette[4] = createDark(palette[1]);



    }


}
