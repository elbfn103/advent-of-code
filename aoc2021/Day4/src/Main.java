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

    Board ansBoard = new Board();
    int winningNum = 0;
    for (String s : order) {

      int num = Integer.parseInt(s);

      if (boards.size() == 1) {
        ansBoard = boards.get(0);
        ansBoard.solveBoard(num);
        ansBoard.checkBoard();

        if (ansBoard.isSolved()) {
          winningNum = Integer.parseInt(s);
          break;
        }
        System.out.println(ansBoard.getBoard());
      } else {
        List<Board> toRemove = new ArrayList<>();

        System.out.println("Boards being checked for " + num);
        for (Board board : boards) {
          System.out.println(board.getBoard());
          board.solveBoard(num);
          board.checkBoard();
          if (board.isSolved()) {
            toRemove.add(board);
          }
        }

        for (Board board : toRemove) {
          boards.remove(board);
        }
      }
    }

    System.out.println(ansBoard.getScore() * winningNum);
  }
}
