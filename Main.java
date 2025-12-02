import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Write a description of class Main here.
 *
 * @author Kara
 * @version F25
 */
public class Main
{
    public static void main(String[] args) {
        // this array represents the word inside each locker
        String[] lockers = initLockerText(); 
        // this array represents if the door is open/closed
        boolean[] doors = new boolean[lockers.length]; 
        // this array represents the number of times a locker is touched
        int[] count = new int[lockers.length];
        // simulation
        for (int i = 1; i <= 100; i++) { // each person taking their turn
            // i represent the ith heir
            for (int L = 1; L <= lockers.length; L++) { // with each locker
                // L represents the locker number
                if (L % i == 0) { // the locker is divisible by the heir
                    if (doors[L-1] == true) { // if the door is currently open
                        doors[L-1] = false; // shut it
                    } else { // the door is currently closed
                        doors[L-1] = true; // open it
                    }
                    count[L-1]++;
                }
            }
        }
        
        // now which are open at the end
        for (int L = 1; L <= lockers.length; L++) {
            boolean currentLocker = doors[L-1];
            if (currentLocker) {
                System.out.println("" + L + " " + currentLocker + " " + lockers[L-1]);
            // } else {
                // System.out.println("" + L + " " + currentLocker);
            }
        }
        
        // now which lockers were touched only twice...
        for (int L = 1; L <= lockers.length; L++) {
            int c = count[L-1];
            if (c == 2) {
                System.out.println(lockers[L-1]);
            }
        }
        
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
