import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) throws IOException {

    String path = "Day5/resources/input.txt";

    FileReader input = new FileReader(path);
    BufferedReader bufferedReader = new BufferedReader(input);

    String line = null;
    Vents vents = new Vents();

    List<int[]> ventCoords = new ArrayList<>();

    while ((line = bufferedReader.readLine()) != null) {
      line = line.replaceAll("(->)", ",");
      line = line.replaceAll("\\s+", "");
      int[] values = Arrays.stream(line.split(",")).toList().stream().mapToInt(Integer::parseInt)
          .toArray();

      for (int i = 0; i < values.length; i += 4) {
        int[] coords = new int[4];
        coords[0] = values[i];
        coords[1] = values[i + 1];
        coords[2] = values[i + 2];
        coords[3] = values[i + 3];
        ventCoords.add(coords);
      }
    }

//    int counter = 0;
    for (int[] coords : ventCoords) {
      vents.addVent(coords);
//      counter++;
//      if (counter == 4) {
//        break;
//      }
//      for (int[] row : vents.getVentMap()) {
//        System.out.println(Arrays.toString(row));
//      }
    }

    vents.checkVents();

    System.out.println(vents.getNumOverlapVents());
  }
}
