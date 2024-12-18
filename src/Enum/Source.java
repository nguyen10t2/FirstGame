package Enum;
import java.nio.file.Paths;

public class Source {
    public static final String iconWindow   = getSource("resources/image/IconWindow.png");
    public static final String yellowKnight = getSource("resources/image/YellowKnight.png");

    private static String getSource(String path) {
        return Paths.get(path).toAbsolutePath().toString();
    }
}
