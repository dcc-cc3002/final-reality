/*
 * "final-reality" (c) by R8V.
 * "final-reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <https://creativecommons.org/licenses/by/4.0/>.
 */

package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import java.util.concurrent.BlockingQueue;
import org.jetbrains.annotations.NotNull;

/**
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Your name~
 * @version 2.1.22.2
 */
public class Knight extends AbstractPlayerCharacter {

  /**
   * Creates a new knight playable character.
   *
   * @param name
   *     the character's name
   * @param turnsQueue
   *     the queue with the characters waiting for their turn
   * @param characterClass
   *     the class of this character
   */
  protected Knight(@NotNull final String name,
      @NotNull final BlockingQueue<GameCharacter> turnsQueue,
      final CharacterClass characterClass) {
    super(name, turnsQueue, characterClass);
  }
}
