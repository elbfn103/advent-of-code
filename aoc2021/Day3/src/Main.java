import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        String path = "Day3/resources/input.txt";

        FileReader input = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(input);
        String line = bufferedReader.readLine();

        Submarine submarine = new Submarine(0, 0, new int[line.length()]);
        submarine.processDiagnostic(line);

        while ( (line = bufferedReader.readLine()) != null) {
            submarine.processDiagnostic(line);
        }

        System.out.println(submarine.getPowerConsumption());
    }
}
