import java.util.ArrayList;
import java.util.List;

public class Board {

  private ArrayList<ArrayList<String>> board;
  private int score;
  private boolean solved;

  Board() {
  }

  Board(ArrayList<ArrayList<String>> board) {
    this.board = board;
    this.score = 0;
    this.solved = false;
  }

  // sets board entry to 0 to mark drawn numbers (so score is calculated accurately)
  public void solveBoard(int num) {
    for (int i = 0; i < board.size(); i++) {
      for (int j = 0; j < board.get(0).size(); j++) {
        int entry = Integer.parseInt(board.get(i).get(j));
        if (entry == num) {
          board.get(i).set(j, "0");
        }
      }
    }
  }

  public void checkBoard() {
    for (int i = 0; i < board.size(); i++) {
      List<String> row = board.get(i);
      List<String> column = getColumn(i);
      // OMG!!!!!!!! NOT HAVING THIS RETURN EARLY WHEN FOUND SCREWED ME SO HARD
      if (row.stream().allMatch("0"::equals)
          || column.stream().allMatch("0"::equals)) {
        solved = true;
        return;
      }
    }
  }

  private List<String> getColumn(int index) {
    List<String> column = new ArrayList<>();
    for (int i = 0; i < board.size(); i++) {
      column.add(board.get(i).get(index));
    }
    return column;
  }

  public int getScore() {
    int ret = this.score;
    for (int i = 0; i < board.size(); i++) {
      for (int j = 0; j < board.get(0).size(); j++) {
        ret += Integer.parseInt(board.get(i).get(j));
      }
    }

    return ret;
  }

  public ArrayList<ArrayList<String>> getBoard() {
    return board;
  }

  public void setBoard(ArrayList<ArrayList<String>> board) {
    this.board = board;
  }

  public boolean isSolved() {
    return solved;
  }

  public void setSolved(boolean solved) {
    this.solved = solved;
  }
}
