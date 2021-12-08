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
    ArrayList<ArrayList<String>> tempBoard = new ArrayList<>();

    List<Board> boards = new ArrayList<>();

    // skip past first empty line
    bufferedReader.readLine();
    while ((line = bufferedReader.readLine()) != null) {
      if (line.equals("")) {
        Board board = new Board(tempBoard);
        boards.add(board);
        tempBoard = new ArrayList<>();
      } else {
        // regex gets rid of heading/trailing spaces, splits on any number of spaces
        tempBoard.add(new ArrayList<>(
            Arrays.stream(line.replaceAll("(^\\s+|\\s+$)", "").split("\\s+")).toList()));
      }
    }

    boolean solved = false;
    Board ansBoard = new Board();
    int winningNum = 0;
    for (String s : order) {
      for (Board board : boards) {
        int num = Integer.parseInt(s);
        board.solveBoard(num);
        System.out.println(num);
        System.out.println(board.getBoard());
        board.checkBoard();
        if (board.isSolved()) {
          System.out.println(ansBoard.getBoard());
          ansBoard = board;
          solved = true;
          winningNum = num;
          break;
        }
      }
      if (solved) {
        break;
      }
    }

    System.out.println(ansBoard.getScore() * winningNum);
  }
}
