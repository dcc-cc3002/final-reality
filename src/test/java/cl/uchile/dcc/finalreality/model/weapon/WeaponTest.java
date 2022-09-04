package cl.uchile.dcc.finalreality.model.weapon;

import static cl.uchile.dcc.finalreality.TestUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class WeaponTest {

  private String name;
  private long seed;
  private int damage;
  private int speed;
  private WeaponType type;

  @BeforeEach
  void setUp() {
    seed = new Random().nextLong();
    randomNumberGenerator = new Random(seed);
    name = randomString(randomInt(1, 20));
    damage = randomInt(1, 100);
    speed = randomInt(1, 100);
    type = randomEnum(WeaponType.class);
  }

  @DisplayName("Two weapons with the same parameters are equal")
  @RepeatedTest(20)
  public void equalTest() {
    var weapon = new Weapon(name, damage, speed, type);
    var sameWeapon = new Weapon(name, damage, speed, type);
    assertEquals(weapon, sameWeapon, "Test failed with seed: " + seed);
    assertEquals(weapon.hashCode(), sameWeapon.hashCode(),
        "Test failed with seed: " + seed);
  }

  @DisplayName("Two weapons with different names are not equal")
  @RepeatedTest(20)
  public void notEqualNameTest() {
    var weapon = new Weapon(name, damage, speed, type);
    var differentWeapon = new Weapon(randomDifferentString(name.length(), name), damage,
        speed, type);
    assertNotEquals(weapon, differentWeapon, "Test failed with seed: " + seed);
  }

  @DisplayName("Two weapons with different damage are not equal")
  @RepeatedTest(20)
  public void notEqualDamageTest() {
    var weapon = new Weapon(name, damage, speed, type);
    var differentWeapon = new Weapon(name, randomDifferentInt(1, 100, damage), speed,
        type);
    assertNotEquals(weapon, differentWeapon, "Test failed with seed: " + seed);
  }

  @DisplayName("Two weapons with different speed are not equal")
  @RepeatedTest(20)
  public void notEqualSpeedTest() {
    var weapon = new Weapon(name, damage, speed, type);
    var differentWeapon = new Weapon(name, damage, randomDifferentInt(1, 100, speed),
        type);
    assertNotEquals(weapon, differentWeapon, "Test failed with seed: " + seed);
  }

  @DisplayName("Two weapons with different type are not equal")
  @RepeatedTest(20)
  public void notEqualTypeTest() {
    var weapon = new Weapon(name, damage, speed, type);
    var differentWeapon = new Weapon(name, damage, speed,
        randomDifferentEnum(WeaponType.class, type));
    assertNotEquals(weapon, differentWeapon, "Test failed with seed: " + seed);
  }
}