import java.util.Random;

public class Monsters
{
	
  static String[] enemies = { "Skeleton", "Zombie", "Assassin"};
  static int maxEnemyHealth = 75;
  static int enemyAttackDamage = 25;
  static int enemyDeathCounter = 0;
  static int enemyAccuracy = 90; // Enemy chance to hit.
  static int healthPotDrop = 50; // Percent drop rate.
  static int enemyHealth = 0;
  static Random rand = new Random();
  static String enemy = enemies[rand.nextInt(enemies.length)];

}