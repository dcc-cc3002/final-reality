package cl.uchile.dcc.finalreality.model.weapon;

import java.util.Objects;

/**
 * A class that holds all the information of a weapon.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Your name~
 * @version 2.1.22.4
 */
public class Weapon {

  private String name;
  private int damage;
  private int weight;
  private WeaponType type;

  /**
   * Creates a weapon with a name, a base damage, speed and it's type.
   */
  public Weapon(final String name, final int damage, final int weight,
      final WeaponType type) {
    this.name = name;
    this.damage = damage;
    this.weight = weight;
    this.type = type;
  }

  private String getName() {
    return name;
  }

  private int getDamage() {
    return damage;
  }

  /**
   * Returns the weight of the weapon.
   */
  public int getWeight() {
    return weight;
  }

  private WeaponType getType() {
    return type;
  }

  @Override
  public int hashCode() {
    return Objects.hash(Weapon.class, name, damage, weight, type);
  }


  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final Weapon weapon)) {
      return false;
    }
    return name.equals(weapon.name)
        && damage == weapon.damage
        && weight == weapon.weight
        && type == weapon.type
        && hashCode() == weapon.hashCode();
  }


  @Override
  protected Object clone() throws CloneNotSupportedException {
    var clone = (Weapon) super.clone();
    clone.name = name;
    clone.damage = damage;
    clone.weight = weight;
    clone.type = type;
    return clone;
  }
}
