package cl.uchile.dcc;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import cl.uchile.dcc.finalreality.model.weapon.WeaponType;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Example of a simple timer.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 */
public class TimerExample {

  /**
   * Runs a simple timer to show the usage of {@code LinkedBlockingQueue}.
   *
   * @param args
   *      not used.
   * @throws InterruptedException
   *      if the thread is interrupted while waiting.
   *      See {@link BlockingQueue#put(Object)}.
   *      See {@link BlockingQueue#take()}.
   */
  public static void main(String[] args) throws InterruptedException {
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    Random rng = new Random();
    for (int i = 0; i < 10; i++) {
      // Gives a random speed to each character to generate different waiting times
      var weapon = new Weapon("", 0, rng.nextInt(50), WeaponType.KNIFE);
      var character = new Knight(Integer.toString(i), queue
      );
      character.equip(weapon);
      character.waitTurn();
    }
    // Waits for 6 seconds to ensure that all characters have finished waiting
    Thread.sleep(6000);
    while (!queue.isEmpty()) {
      // Pops and prints the names of the characters of the queue to illustrate the turns
      // order
      System.out.println(queue.poll().getName());
    }
  }
}
