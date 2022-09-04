package cl.uchile.dcc.finalreality;
/*
 * "Final Reality" (c) by R8V and ~Your name~
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;
import org.jetbrains.annotations.NotNull;

public class TestUtils {

  public static Random randomNumberGenerator = new Random();

  public static @NotNull String randomString(int length) {
    return RandomStringUtils.random(length, 0, Character.MAX_CODE_POINT, false, false,
        null, randomNumberGenerator);
  }

  public static String randomDifferentString(int length, String original) {
    String randomString = randomString(length);
    while (randomString.equals(original)) {
      randomString = randomString(length);
    }
    return randomString;
  }

  public static int randomInt(int min, int max) {
    return randomNumberGenerator.nextInt(max - min) + min;
  }

  public static int randomDifferentInt(int min, int max, int original) {
    int randomInt = randomInt(min, max);
    while (randomInt == original) {
      randomInt = randomInt(min, max);
    }
    return randomInt;
  }

  public static <T extends Enum<?>> T randomEnum(@NotNull Class<T> clazz) {
    int x = randomNumberGenerator.nextInt(clazz.getEnumConstants().length);
    return clazz.getEnumConstants()[x];
  }

  public static <T extends Enum<?>> T randomDifferentEnum(@NotNull Class<T> clazz,
      T original) {
    T randomEnum = randomEnum(clazz);
    while (randomEnum == original) {
      randomEnum = randomEnum(clazz);
    }
    return randomEnum;
  }
}
