package cl.uchile.dcc.finalreality.exceptions;/*
 * "Final Reality" (c) by R8V and ~Your name~
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

public class Require {

  public static void statValueAtLeast(int least, int actualStat, String statName)
      throws InvalidStatValueException {
    if (least > actualStat) {
      throw new InvalidStatValueException(
          "'%s'(%d) must be at least %d".formatted(statName, actualStat, least));
    }
  }

  public static void statValueAtMost(final int most, final int actualStat,
      final String statName) throws InvalidStatValueException {
    if (most < actualStat) {
      throw new InvalidStatValueException(
          "'%s'(%d) must be at most %d".formatted(statName, actualStat, most));
    }
  }
}
