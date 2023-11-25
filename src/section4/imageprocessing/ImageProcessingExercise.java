package section4.imageprocessing;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;

public class ImageProcessingExercise {
    public static final String SOURCE_FILE = "./resources/many-flowers.jpg";
    public static final String DESTINATION_FILE = "./output/many-flowers.jpg";

    public static void main () throws IOException {
        BufferedImage originalImage = ImageIO.read(new File(SOURCE_FILE));
        BufferedImage resultImage = new BufferedImage(originalImage.getWidth(),
                originalImage.getHeight(), BufferedImage.TYPE_INT_RGB);

    }

    public static void recolorPixel (BufferedImage originalImage, BufferedImage resultImage, int x, int y) {

    }

    public static boolean isShadeOfGray (int red, int green, int blue) {
        return Math.abs(red - green) < 30 && Math.abs(red - blue) < 30 && Math.abs(green - blue) < 30;
    }

    public static int createRGBFromColors (int red, int green, int blue) {
        int rgb = 0;
        rgb |= blue;
        rgb |= green << 8;
        rgb |= red << 16;

        rgb |= 0xFF000000;

        return rgb;
    }

    public static int getRed (int rgb) {
        return (rgb & 0x00FF0000) >> 16;
    }

    public static int getGreen (int rgb) {
        return (rgb & 0x0000FF00) >> 8;
    }

    public static int getBlue (int rgb) {
        return rgb & 0x000000FF;
    }
}
