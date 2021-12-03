import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        String path = "Day1/resources/input.txt";

        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = null;

//        int prevDepth = Integer.MAX_VALUE;
//        int count = 0;
//        while ( (line = bufferedReader.readLine()) != null) {
//            int depth = Integer.parseInt(line);
//            if (depth > prevDepth) {
//                count++;
//            }
//            prevDepth = depth;
//        }
//
//        System.out.println(count);
        List<Integer> depths = new ArrayList<>();
        while ( (line = bufferedReader.readLine()) != null) {
            depths.add(Integer.parseInt(line));
        }

        System.out.println(countThreeDepths(depths));
    }

    private static int countThreeDepths(List<Integer> depths) {

        int prevSum = Integer.MAX_VALUE;
        int count = 0;
        for (int i = 0; i < depths.size() - 2; i++) {
            int sum = 0;
            sum += depths.get(i);
            sum += depths.get(i + 1);
            sum += depths.get(i + 2);
            if (sum > prevSum) count++;
            prevSum = sum;
        }

        return count;
    }
}
