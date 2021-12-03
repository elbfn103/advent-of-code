import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        String path = "Day2/resources/input.txt";

        FileReader input = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(input);
        String line = null;

        Submarine submarine = new Submarine(0, 0, 0);

        while ( (line = bufferedReader.readLine()) != null) {
            submarine.moveSubmarine(line);
        }

        System.out.println(submarine.getFinalPos());
    }
}

