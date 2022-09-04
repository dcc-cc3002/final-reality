package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.model.character.AbstractCharacter;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import java.util.concurrent.BlockingQueue;
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a single character of the game.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Your name~
 */
public abstract class AbstractPlayerCharacter extends AbstractCharacter {

  /**
   * Creates a new character.
   *
   * @param name
   *     the character's name
   * @param maxHp
   *     the character's max hp
   * @param defense
   *     the character's defense
   * @param turnsQueue
   *     the queue with the characters waiting for their turn
   */
  protected AbstractPlayerCharacter(@NotNull final String name, final int maxHp,
      final int defense,
      @NotNull final BlockingQueue<GameCharacter> turnsQueue) {
    super(name, maxHp, defense, turnsQueue);
  }
}
