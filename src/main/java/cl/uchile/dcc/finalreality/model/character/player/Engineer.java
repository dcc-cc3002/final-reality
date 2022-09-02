/*
 * "final-reality" (c) by R8V.
 * "final-reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <https://creativecommons.org/licenses/by/4.0/>.
 */

package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import org.jetbrains.annotations.NotNull;

/**
 * An {@code Engineer} is a type of {@code PlayerCharacter} that can equip Axes and Bows.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Your name~
 * @version 2.1.22.3
 */
public class Engineer extends AbstractPlayerCharacter {

  /**
   * Creates a new character.
   *
   * @param name
   *     the character's name
   * @param turnsQueue
   *     the queue with the characters waiting for their turn
   */
  protected Engineer(@NotNull final String name,
      @NotNull final BlockingQueue<GameCharacter> turnsQueue) {
    super(name, turnsQueue);
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    var clone = (Engineer) super.clone();
    clone.name = name;
    clone.turnsQueue = turnsQueue;
    return clone;
  }

  @Override
  public String toString() {
    return "Engineer{" + "turnsQueue=" + turnsQueue
        + ", name='" + name + '\''
        + '}';
  }

  @Override
  public int hashCode() {
    return Objects.hash(Engineer.class, name);
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final Engineer that)) {
      return false;
    }
    return name.equals(that.name)
        && hashCode() == that.hashCode();
  }
}
