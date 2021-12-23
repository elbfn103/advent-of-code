public class Vents {

  private int numOverlapVents;
  private int[][] ventMap;

  public Vents() {
    initVentMap();
    this.numOverlapVents = 0;
  }

  private void initVentMap() {
    int[][] temp = new int[1000][1000];
    for (int i = 0; i < 1000; i++) {
      for (int j = 0; j < 1000; j++) {
        temp[i][j] = 0;
      }
    }
    setVentMap(temp);
  }

  public void addVent(int[] coords) {
    if (coords[0] == coords[2]) {

      if (coords[1] > coords[3]) {
        for (int i = coords[3]; i <= coords[1]; i++) {
          ventMap[coords[0]][i]++;

        }
      } else {
        for (int i = coords[1]; i <= coords[3]; i++) {
          ventMap[coords[0]][i]++;
        }
      }

      System.out.println("vertical line added from: " + coords[1] + " to " + coords[3]);

    } else if (coords[1] == coords[3]) {

      if (coords[0] > coords[2]) {
        for (int i = coords[2]; i <= coords[0]; i++) {
          ventMap[i][coords[1]]++;
        }
      } else {
        for (int i = coords[0]; i <= coords[2]; i++) {
          ventMap[i][coords[1]]++;
        }
      }

      System.out.println("horizontal line added from: " + coords[0] + " to " + coords[2]);

    }
  }

  public void checkVents() {
    int numOverlap = 0;
    for (int i = 0; i < ventMap.length; i++) {
      for (int j = 0; j < ventMap[0].length; j++) {
        if (ventMap[i][j] >= 2) {
          numOverlap++;
        }
      }
    }
    setNumOverlapVents(numOverlap);
  }

  public int getNumOverlapVents() {
    return numOverlapVents;
  }

  public void setNumOverlapVents(int numOverlapVents) {
    this.numOverlapVents = numOverlapVents;
  }

  public int[][] getVentMap() {
    return ventMap;
  }

  public void setVentMap(int[][] ventMap) {
    this.ventMap = ventMap;
  }
}
