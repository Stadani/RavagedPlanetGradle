package player;

public enum PlayerRole {
    KNIGHT(5, 0, 5, 0, 5, 5, 2),
    SORCERER(2, 10, 5, 100, 5, 0, 3),
    THIEF(5, 0, 10, 0, 0, 10, 5),
    CLERIC(5, 5, 10, 50, 5, 0, 3);

    private int attack;
    private int magic;
    private int health;
    private int mana;
    private int defense;
    private int critChance;
    private int speed;

    PlayerRole(int attack, int magic, int health, int mana, int defense, int critChance, int speed) {
        this.attack = attack;
        this.magic = magic;
        this.health = health;
        this.mana = mana;
        this.defense = defense;
        this.critChance = critChance;
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

    public int getCritChance() {
        return critChance;
    }

    public void setCritChance(int critChance) {
        this.critChance = critChance;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
