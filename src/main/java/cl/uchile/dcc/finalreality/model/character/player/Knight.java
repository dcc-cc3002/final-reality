/*
 * "Final Reality" (c) by R8V and ~Your name~
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */
package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import org.jetbrains.annotations.NotNull;

/**
 * A {@code Knight} is a type of Player Character that can equip {@code Sword}s,
 * {@code Axe}s and {@code Knife}s.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Your name~
 * @version 2.0
 */
public class Knight extends AbstractPlayerCharacter {

  /**
   * Creates a new Knight.
   *
   * @param name
   *     the character's name
   * @param maxHp
   *     the character's maximum health points
   * @param defense
   *     the character's defense
   * @param turnsQueue
   *     the queue with the characters waiting for their turn
   */
  public Knight(@NotNull final String name, int maxHp, int defense,
      @NotNull final BlockingQueue<GameCharacter> turnsQueue) {
    super(name, maxHp, defense, turnsQueue);
  }

  @Override
  public String toString() {
    return "Knight{maxHp=%d, defense=%d, name='%s'}".formatted(maxHp, defense, name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(Knight.class, name, maxHp, defense);
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof final Knight that)) {
      return false;
    }
    return hashCode() == that.hashCode()
        && name.equals(that.name)
        && maxHp == that.maxHp
        && defense == that.defense;
  }
}
