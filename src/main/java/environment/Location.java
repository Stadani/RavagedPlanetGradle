package environment;

public class Location {
    private String name;
    private String[][] map;

    public Location(String name) {
        this.name = name;
        this.map = new String[8][8];
        for (int i = 0; i < this.map.length; i++) {
            for (int j = 0; j < this.map[0].length; j++) {
                this.map[i][j] = "□";
            }
        }
    }

    public void printLocation() {
        for (int i = 0; i < this.map.length; i++) {
            for (int j = 0; j < this.map[0].length; j++) {
                System.out.print(this.map[i][j]);
                System.out.print(" ");
                if (j == this.map[0].length - 1) {
                    System.out.println();
                }
            }
        }
    }

    public void placeObjectInLocation(int x, int y, String symbol) {
        this.map[x][y] = symbol;
    }

    public String getName() {
        return name;
    }
}
