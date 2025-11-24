import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main
{
    public static void main(String[] args) {
        String[] lockers = initLockerText();
        // TODO
    }

    private static String[] initLockerText() {
        try {
            Path path = Paths.get("lockerText.txt");
            List<String> lines = Files.readAllLines(path);
            String[] lockers = lines.toArray(new String[0]);
            return lockers;
        } catch (Exception e) {
            System.err.println("Error reading file: " + e.getMessage());
            return null;
        }
    }
}
