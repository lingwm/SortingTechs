/**
 * Created by Yuxiao Guo
 * generate 1000 uniformly distributed int value within range (0 - 1000000)
 */

import java.io.*;
import java.util.Random;

public class RandomNumberGenerator {

        public static void main(String... aArgs) throws IOException {

            Writer wr = new FileWriter("RandomNumber2.txt");
            Random randomGenerator = new Random();
            for (int idx = 1; idx <= 20000; ++idx) {
                int randomInt = randomGenerator.nextInt(1000001);
                wr.write(String.valueOf(randomInt) + System.getProperty( "line.separator" ));
            }
            wr.close();
        }
}
