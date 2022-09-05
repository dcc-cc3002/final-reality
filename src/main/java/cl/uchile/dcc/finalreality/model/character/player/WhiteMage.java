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

public class WhiteMage extends AbstractPlayerCharacter {

  private final int currentMp;
  private int maxMp;

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
  protected WhiteMage(final @NotNull String name, final int maxHp, final int defense,
      int maxMp, final @NotNull BlockingQueue<GameCharacter> turnsQueue) {
    super(name, maxHp, defense, turnsQueue);
    this.maxMp = maxMp;
    this.currentMp = maxMp;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final WhiteMage that)) {
      return false;
    }
    return hashCode() == that.hashCode()
        && maxMp == that.maxMp
        && name.equals(that.name)
        && maxHp == that.maxHp
        && defense == that.defense;
  }

  @Override
  public int hashCode() {
    return Objects.hash(WhiteMage.class, name, maxHp, defense, maxMp);
  }

  @Override
  public String toString() {
    return "WhiteMage{maxMp=%d, maxHp=%d, defense=%d, name='%s'}"
        .formatted(maxMp, maxHp, defense, name);
  }
}