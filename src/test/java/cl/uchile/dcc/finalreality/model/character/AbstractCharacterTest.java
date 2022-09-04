package cl.uchile.dcc.finalreality.model.character;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import cl.uchile.dcc.finalreality.model.weapon.WeaponType;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Abstract class containing the common tests for all the types of characters.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Your name~
 * @see GameCharacter
 */
public abstract class AbstractCharacterTest {

  protected BlockingQueue<GameCharacter> turns;
  protected List<GameCharacter> testCharacters;
  protected Weapon testWeapon;

  /**
   * Checks that the character waits the appropriate amount of time for it's turn.
   */
  @Test
  void waitTurnTest() {
    Assertions.assertTrue(turns.isEmpty());
    tryToEquip(testCharacters.get(0));
    testCharacters.get(0).waitTurn();
    try {
      // Thread.sleep is not accurate so this values may be changed to adjust the
      // acceptable error margin.
      // We're testing that the character waits approximately 1 second.
      Thread.sleep(900);
      Assertions.assertEquals(0, turns.size());
      Thread.sleep(200);
      Assertions.assertEquals(1, turns.size());
      Assertions.assertEquals(testCharacters.get(0), turns.peek());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private void tryToEquip(GameCharacter character) {
    character.equip(testWeapon);
  }

  protected void checkConstruction(final GameCharacter expectedCharacter,
      final GameCharacter testEqualCharacter,
      final GameCharacter sameClassDifferentCharacter,
      final GameCharacter differentClassCharacter) {
    assertEquals(expectedCharacter, testEqualCharacter);
    assertNotEquals(sameClassDifferentCharacter, testEqualCharacter);
    assertNotEquals(testEqualCharacter, differentClassCharacter);
    assertEquals(expectedCharacter.hashCode(), testEqualCharacter.hashCode());
  }

  protected void basicSetUp() {
    turns = new LinkedBlockingQueue<>();
    testWeapon = new Weapon("Test", 15, 10, WeaponType.AXE);
    testCharacters = new ArrayList<>();
  }
}
