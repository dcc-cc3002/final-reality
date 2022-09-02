package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.model.character.AbstractCharacter;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import java.util.Objects;
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
   * @param turnsQueue
   *     the queue with the characters waiting for their turn
   */
  protected AbstractPlayerCharacter(@NotNull String name,
      @NotNull BlockingQueue<GameCharacter> turnsQueue) {
    super(turnsQueue, name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(AbstractPlayerCharacter.class, name);
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final AbstractPlayerCharacter that)) {
      return false;
    }
    return this.name.equals(that.name)
        && this.hashCode() == that.hashCode();
  }
}
