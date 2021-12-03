public class Submarine {

    private long horizontalPos;
    private long depth;
    private long aim;

    private enum Direction {
        forward, down, up;

        public static Direction findByDirection(String direction) {
            for (Direction d : values()) {
                if (direction.equals(d.toString())) {
                    return d;
                }
            }
            return null;
        }
    }

    public Submarine(long horizontalPos, long depth, long aim) {
        this.horizontalPos = horizontalPos;
        this.depth = depth;
        this.aim = aim;
    }

    public void moveSubmarine(String input) {

        String[] movement = input.split(" ");

        Direction direction = Direction.findByDirection(movement[0]);
        int degree = Integer.parseInt(movement[1]);
        System.out.println(input);
        switch (direction) {
            case forward: this.horizontalPos += degree;
            this.depth += (degree * aim);
            break;
            case down: this.aim += degree;
            break;
            case up: this.aim -= degree;
            break;
        }

        System.out.println("horiz: " + horizontalPos + " depth: " + depth);
    }

    public long getFinalPos() {return this.horizontalPos * this.depth;}
}
