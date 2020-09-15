import java.util.Scanner;

public class Hero
{
  static String Name;
  static int health = 100;
  static int attackDamage = 50;
  static int mana = 50;
  static int accuracy = 90;     // Your percent change to hit
  static int numHealthPots = 3; // Amount of potions you start with.
  static int healthPotHeal = 30;
  static int numManaPots = 2;
  static int manaPotRecovery = 20;
  static int chanceToFlee = 60;
  Scanner in = new Scanner(System.in);
  Scanner input = new Scanner(System.in);

  public void CreateCharacter()
  {
    System.out.println("Hello, and welcome. What is your name?");
    Name = input.next();
    System.out.println("Welcome " + Name + " please enjoy the Demo.");
    System.out.println("Manapots are non renewable, only healthpots are.");
    System.out.println("Kill as many monsters as you can, their health and damage are randomized.");
  }

}
