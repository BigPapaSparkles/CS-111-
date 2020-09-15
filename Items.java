import java.util.Scanner;
import java.util.Random;

public class Items {

	Scanner in = new Scanner(System.in);
    Random rand = new Random();
    Main game = new Main();

	  public void items()
	  {
		int damageTaken = rand.nextInt(Monsters.enemyAttackDamage);
	    System.out.println("-------------------------------------");
	    System.out.println("Which would you liked to use?");
	    System.out.println("\t1. Health Pot (Restores 30 HP)");
	    System.out.println("\t2. Mana Pot (Restores 20 MP)");
	    System.out.println("-------------------------------------");

	    String input = in.nextLine();

	    if (input.equals("1") && Hero.numHealthPots > 0)
	      {
	        Hero.health += Hero.healthPotHeal;
	        Hero.numHealthPots--;
	        if (Hero.health >= 100)
	        {
	          Hero.health = 100;
	        }
	        System.out.println("-------------------------------------");
	        System.out.println("\t" + Hero.Name + " drank a health pot and recovered " + Hero.healthPotHeal + "!"
	                + "\n\tYour current health now is " + Hero.health + "\n\t" + Hero.Name +  " now has " + Hero.numHealthPots + " health pots left.");

	        if(rand.nextInt(100) < Monsters.enemyAccuracy)
            {
            Hero.health -= damageTaken;
            System.out.println("\n\t>The " + Monsters.enemy + " attacks " + Hero.Name + " for " + damageTaken + "!");
            }
            else {
            System.out.println("\tThe " + Monsters.enemy + " Missed!");
            }
	      }

	       if (Hero.numHealthPots == 0){
	            System.out.println("\tYou have no Health Pots left.");
	       }

	        if (input.equals("2") && Hero.numManaPots > 0)
	        {
	          Hero.mana += Hero.manaPotRecovery;
	          Hero.numManaPots--;

	          if (Hero.mana >= 50)
	          {
	            Hero.mana = 50;
	          }

	              System.out.println("-------------------------------------");
		          System.out.println("\t" + Hero.Name + " drank a Mana pot and recovered " + Hero.manaPotRecovery + "!"
		                      + "\n\tYour current Mana is " + Hero.mana + "\n\t" + Hero.Name +  " now have " + Hero.numManaPots + " mana pots left.");

		          if(rand.nextInt(100) < Monsters.enemyAccuracy)
	                {
	                Hero.health -= damageTaken;
	                System.out.println("\n\t>The " + Monsters.enemy + " attacks " + Hero.Name + " for " + damageTaken + "!");
	                }
	                else {
                        System.out.println("\n\tThe " + Monsters.enemy + " Missed!");
	                }
	        }
	        if (Hero.numManaPots == 0){
		            System.out.println("\tYou have no Mana Pots left.");
	         }
	         while(!input.equals("1") && !input.equals("2") && input.equals("3")){
	         System.out.println("\tInvalid command!");
           input = in.nextLine();
	         }

	  }
}
