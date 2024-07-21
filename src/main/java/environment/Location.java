package environment;

public class Location {
    private String name;
    private char[][] area;

    public Location(String name, char[][] area) {
        this.name = name;
        this.area = area;
    }

    /**
     * prints the area of location
     */
    public void printLocation() {
        for (char[] row : area) {
            for (char cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }

    public void placeObjectInLocation(int x, int y, char symbol) {
        this.area[x][y] = symbol;
    }

    public String getName() {
        return name;
    }
}
