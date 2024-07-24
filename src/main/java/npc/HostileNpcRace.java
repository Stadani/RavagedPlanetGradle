package npc;

public enum HostileNpcRace {
    SLIME(1, 0, 10, 0, 0, 2),
    GOBLIN(5, 0, 20, 0, 1, 5),
    ORC(10, 0, 40, 0, 5, 3);

    private int attack;
    private int magic;
    private int health;
    private int mana;
    private int defense;
    private int speed;

    HostileNpcRace(int attack, int magic, int health, int mana, int defense, int speed) {
        this.attack = attack;
        this.magic = magic;
        this.health = health;
        this.mana = mana;
        this.defense = defense;
        this.speed = speed;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getMagic() {
        return magic;
    }

    public void setMagic(int magic) {
        this.magic = magic;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
