package npc;

import environment.Location;

public class Goblin extends HostileNPC{
    Location location;
    public Goblin(HostileNpcRace race, int row, int col) {
        super(race, row, col, 'G');
    }


}
