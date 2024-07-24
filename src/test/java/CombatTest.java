import npc.Goblin;

import npc.HostileNpcRace;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CombatTest {
    Goblin goblin;

    public CombatTest() {
        this.goblin = new Goblin(HostileNpcRace.GOBLIN, 3, 3);
    }

    @Test
    public void decreaseHealthTest() {
        var amount = 5;
        this.goblin.decreaseHealth(amount);
        var expected = this.goblin.getHealth();
        var actual = this.goblin.getRace().getHealth() - amount;
//        System.out.println("expected hp: " + expected + "\nactual hp: " + actual);
        assertEquals(expected, actual);
    }

    @Test
    public void increaseHealthTest() {
        var amount = 5;
        this.goblin.decreaseHealth(15);
        var actual = this.goblin.getHealth() + amount;
        this.goblin.increaseHealth(amount);
        var expected = this.goblin.getHealth();
//        System.out.println("expected hp: " + expected + "\nactual hp: " + actual);
        assertEquals(expected, actual);
    }
}
