import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        String path = "Day4/resources/input.txt";

        FileReader input = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(input);

        String[] order = bufferedReader.readLine().split(",");
        String line;
        ArrayList<ArrayList<String>> board = new ArrayList<>();

        List<Bingo> boards = new ArrayList<>();

        // skip past first empty line
        bufferedReader.readLine();
        while ((line = bufferedReader.readLine()) != null) {
            if (line.equals("")) {
                Bingo bingo = new Bingo(board);
                boards.add(bingo);
                board = new ArrayList<>();
            } else {
                // regex gets rid of heading/trailing spaces, splits on any number of spaces
                board.add(new ArrayList<>(Arrays.stream(line.replaceAll("(^\\s+|\\s+$)", "").split("\\s+")).toList()));
            }
        }

        boolean solved = false;
        Bingo ansBoard = new Bingo();
        int winningNum = 0;
        for (String s : order) {
            for (Bingo bingo : boards) {
                int num = Integer.parseInt(s);
                bingo.solveBoard(num);
                bingo.checkBoard();
                if (bingo.isSolved()) {
                    ansBoard = bingo;
                    System.out.println(ansBoard.getBoard());
                    solved = true;
                    winningNum = num;
                    System.out.println(winningNum);
                    break;
                }
            }
            if (solved) break;
        }

        System.out.println(ansBoard.getScore() * winningNum);
    }
}
