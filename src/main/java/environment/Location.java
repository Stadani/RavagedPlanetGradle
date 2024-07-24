package environment;

import npc.HostileNPC;
import player.Player;

import java.util.List;

public class Location {
    private String name;
    private char[][] area;
    private List<HostileNPC> npcs;
    Player player;

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

    public int[] getPlayerPosition() {
        for (int i = 0; i < area.length; i++) {
            for (int j = 0; j < area[i].length; j++) {
                if (area[i][j] == '+') {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public boolean isPositionFree(int x, int y) {
        if (this.getPlayerPosition()[0] == x && this.getPlayerPosition()[1] == y) {
            return false;
        }

        for (HostileNPC npc : npcs) {
            if (npc.getPosition()[0] == x && npc.getPosition()[1] == y) {
                return false;
            }
        }

        return true;
    }

    public void addHostileNPC(HostileNPC npc) {
        if (isPositionFree(npc.getPosition()[0], npc.getPosition()[1])) {
            npcs.add(npc);
        } else {
            System.out.println("Can't add hostile NPC at this location");
        }
    }

    public void placeObjectInLocation(int x, int y, char symbol) {
        this.area[x][y] = symbol;
    }



    public String getName() {
        return name;
    }
}
