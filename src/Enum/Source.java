package Enum;
import java.nio.file.Paths;

public class Source {
    private static final String imagePath    = "resources/image/";
    public static final String iconWindow    = getSource(imagePath + "iconWindow.png");
    public static final String yellowKnight  = getSource(imagePath + "YellowKnight.png");
    public static final String yellowButton  = getSource(imagePath + "YellowButton.png");
    public static final String yellowButtonP = getSource(imagePath + "YellowButtonPressed.png");
    public static final String greenButtonP  = getSource(imagePath + "GreenButtonPressed.png");


    private static String getSource(String path) {
        return Paths.get(path).toAbsolutePath().toString();
    }
}
