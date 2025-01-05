package constants;
import java.nio.file.Paths;

public class Source {
    private static final String imagePath    = "resources/image/";
    public static final String iconWindow    = getSource(imagePath + "iconWindow.png");
    public static final String yellowKnight  = getSource(imagePath + "YellowKnight.png");
    public static final String yellowButton  = getSource(imagePath + "YellowButton.png");
    public static final String yellowButtonP = getSource(imagePath + "YellowButtonPressed.png");
    public static final String greenButtonP  = getSource(imagePath + "GreenButtonPressed.png");
    public static final String testSprite    = getSource(imagePath + "YellowKnight.png");
    public static final int[] knightSize    = {50, 10, 10, 128, 128}; // health, attack, speed, width, height

    private static String getSource(String path) {
        return Paths.get(path).toAbsolutePath().toString();
    }
}
