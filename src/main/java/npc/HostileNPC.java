package npc;

/**
 * parent class of all hostile NPCs
 */
public class HostileNPC {
    private HostileNpcRace race;
    private int health;
    private final char symbol;
    private int row;
    private int col;
    private int[] position;

    public HostileNPC(HostileNpcRace race, int row, int col, char symbol) {
        this.race = race;
        this.health = race.getHealth();
        this.position = new int[]{row, col};
        this.symbol = symbol;
    }

    public void decreaseHealth(int amount) {
        this.health = Math.max(this.health - amount, 0);
    }

    public void increaseHealth(int amount) {
        if (this.health <= 0) {
            this.health = 0;
        } else {
            this.health = Math.min(this.health + amount, this.race.getHealth());
        }
    }



    public int getHealth() {
        return this.health;
    }

    public int setHealth(int health) {
        return this.health = health;
    }
    public HostileNpcRace getRace() {
        return this.race;
    }

    public char getSymbol() {
        return this.symbol;
    }


    public int[] getPosition() {
        return this.position;
    }

    public void setPosition(int[] position) {
        this.position = position;
    }
}
