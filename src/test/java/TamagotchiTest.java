import org.junit.*;
import static org.junit.Assert.*;

public class TamagotchiTest {

  @Test
  public void tamagotchi_instantiatesCorrectly() {
    Tamagotchi myPet = new Tamagotchi("lil dragon");
    assertEquals("lil dragon", myPet.getName());
    assertEquals(8, myPet.getFoodLevel());
    assertEquals(8, myPet.getSleepLevel());
    assertEquals(8, myPet.getActivityLevel());
    assertEquals(20, myPet.getHealthLevel());
  }

  @Test
  public void timePasses_foodDecreasesByOne_9() {
    Tamagotchi myPet = new Tamagotchi("lil dragon");
    myPet.timePasses();
    assertEquals(7, myPet.getFoodLevel());
  }

  @Test
  public void isAlive_foodLevelAbove0_true() {
    Tamagotchi myPet = new Tamagotchi("lil dragon");
    assertEquals(true, myPet.isAlive());
  }

  @Test
  public void feedTamagotchi_foodLevelIncramentsWhenFed_9() {
    Tamagotchi myPet = new Tamagotchi("lil dragon");
    assertEquals(9, myPet.feed());
  }

  @Test
  public void napTamagotchi_sleepLevelIncramentsWhenNapped_9() {
    Tamagotchi myPet = new Tamagotchi("lil dragon");
    assertEquals(9, myPet.nap());
  }

  @Test
  public void playTamagotchi_activityLevelIncramentsWhenPlayed_9() {
    Tamagotchi myPet = new Tamagotchi("lil dragon");
    assertEquals(9, myPet.play());
  }
}
