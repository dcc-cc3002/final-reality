package cl.uchile.dcc.finalreality.model.character;

import cl.uchile.dcc.finalreality.model.character.player.AbstractPlayerCharacter;
import cl.uchile.dcc.finalreality.model.character.player.CharacterClass;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;

/**
 * An abstract class that holds the common behaviour of all the characters in the game.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Your name~
 * @version 2.1.22.3
 */
public abstract class AbstractCharacter implements GameCharacter {

  protected BlockingQueue<GameCharacter> turnsQueue;
  protected String name;
  private Weapon equippedWeapon = null;
  private ScheduledExecutorService scheduledExecutor;

  protected AbstractCharacter(@NotNull BlockingQueue<GameCharacter> turnsQueue,
      @NotNull String name) {
    this.turnsQueue = turnsQueue;
    this.name = name;
  }

  @Override
  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    if (this instanceof AbstractPlayerCharacter) {
      scheduledExecutor
          .schedule(this::addToQueue, equippedWeapon.getWeight() / 10, TimeUnit.SECONDS);
    } else {
      var enemy = (Enemy) this;
      scheduledExecutor
          .schedule(this::addToQueue, enemy.getWeight() / 10, TimeUnit.SECONDS);
    }
  }

  /**
   * Adds this character to the turns queue.
   */
  private void addToQueue() {
    try {
      turnsQueue.put(this);
    } catch (Exception e) {
      e.printStackTrace();
    }
    scheduledExecutor.shutdown();
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void equip(Weapon weapon) {
    if (this instanceof AbstractPlayerCharacter) {
      this.equippedWeapon = weapon;
    }
  }

  @Override
  public Weapon getEquippedWeapon() {
    return equippedWeapon;
  }
}
