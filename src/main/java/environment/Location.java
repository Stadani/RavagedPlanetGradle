package environment;

public class Location {
    private String name;
    private char[][] area;

    public Location(String name, char[][] area) {
        this.name = name;
        this.area = area;
    }

    public void printLocation() {
        for (int i = 0; i < this.area.length; i++) {
            for (int j = 0; j < this.area[0].length; j++) {
                System.out.print(this.area[i][j]);
                System.out.print(" ");
                if (j == this.area[0].length - 1) {
                    System.out.println();
                }
            }
        }
    }

    public void placeObjectInLocation(int x, int y, char symbol) {
        this.area[x][y] = symbol;
    }

    public String getName() {
        return name;
    }
}
