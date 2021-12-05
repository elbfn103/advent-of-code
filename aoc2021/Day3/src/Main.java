import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        String path = "Day3/resources/input.txt";

        FileReader input = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(input);
        String line = null;
        List<String> lines = new ArrayList<>();

        while ( (line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }

        Submarine submarine = new Submarine("", "", "", "", new int[lines.get(0).length()]);

        submarine.oxygenRating(lines);
        submarine.co2Rating(lines);


        System.out.println(submarine.getLifeSupportRating());
    }
}
