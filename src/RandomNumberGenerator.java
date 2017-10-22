import java.io.*;
import java.util.Random;

public class RandomNumberGenerator {

        public static void main(String... aArgs) throws IOException {
            //generate 1000 uniformly distributed int value within range (0 - 1000000)
            Writer wr = new FileWriter("RandomNumber1.txt");
            Random randomGenerator = new Random();
            for (int idx = 1; idx <= 1000; ++idx) {
                int randomInt = randomGenerator.nextInt(1000001);
                wr.write(String.valueOf(randomInt) + System.getProperty( "line.separator" ));
            }
            wr.close();
        }
}
