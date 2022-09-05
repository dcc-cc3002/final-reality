package cl.uchile.dcc.finalreality.exceptions;/*
 * "Final Reality" (c) by R8V and ~Your name~
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

public class InvalidStatValueException extends Exception {
  public InvalidStatValueException(String description) {
    super("The required condition is not met. " + description);
  }
}
