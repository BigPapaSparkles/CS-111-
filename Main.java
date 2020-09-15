import java.util.Scanner;
import java.util.Random;
public class Main
{
    public static void main(String[] args)
    {
      // System Objects
      Scanner in = new Scanner(System.in);
      Random rand = new Random();
      Hero pc = new Hero();
      Items item = new Items();

      boolean running = true;

      pc.CreateCharacter();

      GAME: // The label
      while(running)
      {
        System.out.println("-------------------------------------");

        Monsters.enemyHealth = rand.nextInt(Monsters.maxEnemyHealth);
        System.out.println("\t# " + Monsters.enemy + " attacks! #");
          while(Monsters.enemyHealth > 0)
          {
            System.out.println("\n\t" + Hero.Name + "'s HP: " + Hero.health + "\t MP: " + Hero.mana);
            System.out.println("\t" + Monsters.enemy + "'s HP: " + Monsters.enemyHealth);
            System.out.println("\n\tWhat would you like to do?");
            System.out.println("\t1. Attack");
            System.out.println("\t2. Item");
            System.out.println("\t3. Skill");
            System.out.println("\t4. Flee.");
            System.out.println("-------------------------------------");

            String input = in.nextLine();
              if(input.equals("1"))
              {
                int damageDealt = rand.nextInt(Hero.attackDamage);
                int damageTaken = rand.nextInt(Monsters.enemyAttackDamage);


                if (rand.nextInt(100) < Hero.accuracy)
                {
                Monsters.enemyHealth -= damageDealt;
                System.out.println("\n\t" + Hero.Name + " strikes the " + Monsters.enemy + " for " + damageDealt + " damage!");
                }
                else {
                System.out.println("\n\t" + Hero.Name + " missed!");
                }
                if (Monsters.enemyHealth <= 0)
                  break;
                else if(rand.nextInt(100) < Monsters.enemyAccuracy)
                {
                Hero.health -= damageTaken;
                System.out.println("\n\tThe " + Monsters.enemy + " attacks " + Hero.Name + " for " + damageTaken + "!");

                	if(Hero.health <= 0)
                	{
                		System.out.println("\nYou leave the dungeon weakened from battle.");
                		break GAME;
                	}
                }

                else {
                System.out.println("\n\tThe " + Monsters.enemy + " Missed!");
                }
              }

              else if(input.equals("2"))
              {
                item.items();
              }
                     else if(input.equals("3"))
                     {
                         if (Hero.mana < 5)
                         {
                	    	System.out.println("You don't have enough mana to cast magic!");
                	    	continue;
                         }

                        int damageTaken = rand.nextInt(Monsters.enemyAttackDamage);
                        System.out.println("-------------------------------------");
                        System.out.println("\tWhich will you use?");
                        System.out.println("\t1. Fire (5MP)");
                        System.out.println("\t2. Thunder (10MP)");
                        System.out.println("\t3. Cancel");
                        System.out.println("-------------------------------------");

                        input = in.nextLine();
                        while(!input.equals("1") && !input.equals("2")  && !input.equals("3"))
                        {
                          System.out.println("\tInvalid command!");
                          input = in.nextLine();
                        }

                        if (input.equals("1"))
                     {

                          Monsters.enemyHealth -= 25;
                          System.out.println("\n\t" + Hero.Name + " casts a Fireball at the " + Monsters.enemy + " for a flat 25 damage!");
                          Hero.mana -= 5;
                          if (Monsters.enemyHealth <= 0)
                              break;
                            else if(rand.nextInt(100) < Monsters.enemyAccuracy)
                            {
                            Hero.health -= damageTaken;
                            System.out.println("\n\tThe " + Monsters.enemy + " attacks " + Hero.Name + " for " + damageTaken + "!");

                            	if(Hero.health <= 0)
                            	{
                            		System.out.println("\nYou leave the dungeon weakened from battle.");
                            		break GAME;
                            	}
                            }

                            else {
                            System.out.println("\n\tThe " + Monsters.enemy + " Missed!");
                            }

                       }
                        else if (input.equals("2"))
                        {
                        Monsters.enemyHealth -= 35;
                        System.out.println("\n\t" + Hero.Name + " Smite's the " + Monsters.enemy + " with lightning for a flat 35 damage!");
                        Hero.mana -= 10;
                        if (Monsters.enemyHealth <= 0)
                        break;
                          else if(rand.nextInt(100) < Monsters.enemyAccuracy)
                          {
                          Hero.health -= damageTaken;
                          System.out.println("\n\tThe " + Monsters.enemy + " attacks " + Hero.Name + " for " + damageTaken + "!");
                          	if(Hero.health <= 0)
                          	{
                            System.out.println("\nYou leave the dungeon weakened from battle.");
                            break GAME;
                          	}
                          }

                          else {
                          System.out.println("\n\tThe " + Monsters.enemy + " Missed!");
                          }
                        }
                        else if (input.equals("3"))
                        {
                        continue;
                        }
                      }

                else if(input.equals("4"))
                    {
                    	  int damageTaken = rand.nextInt(Monsters.enemyAttackDamage);

                          if(rand.nextInt(100) < Hero.chanceToFlee )
                          {
                          System.out.println("\n\tYou failed to flee from the " + Monsters.enemy + "!");
                          	if(rand.nextInt(100) < Monsters.enemyAccuracy)
                          	{
                        	  Hero.health -= damageTaken;
                        	  System.out.println("\n\tThe " + Monsters.enemy + " attacks " + Hero.Name + " for " + damageTaken + "!");

                        	  if(Hero.health <= 0)
                              {
                                System.out.println("\nYou leave the dungeon weakened from battle.");
                                break GAME;
                              }
                          	}

                          	else {
                                System.out.println("\n\tThe " + Monsters.enemy + " Missed!");
                          		 }
      	                  }
      	                else {
      	                System.out.println("\nYou escaped and encountered something else!\n");
                      	continue GAME; // Goes back to the start of the loop.
      	                }
                     }

              while(!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4"))
              {
                System.out.println("Invalid command! Enter again.");
                input = in.nextLine();
              }
          	}
                  System.out.println("\n-------------------------------------");
                  System.out.println(" # " + Monsters.enemy + " Was defeated! #");
                  System.out.println(" # You have " + Hero.health + "HP left. #" );
                  System.out.println("-------------------------------------");
                  Monsters.enemyDeathCounter++;


                  if(rand.nextInt(100) < Monsters.healthPotDrop)
                 {
                   Hero.numHealthPots++;
                   System.out.println("\n# Health Pot Get! You now have " + Hero.numHealthPots + " left.");
                 }

                 System.out.println("\n-------------------------------------");
                 System.out.println("What would you like to do now?");
                 System.out.println("1. Keep moving?");
                 System.out.println("2. Exit dungeon?");
                 System.out.println("-------------------------------------");
                 String input = in.nextLine();

                 while(!input.equals("1") && !input.equals("2"))
                 {
                   System.out.println("Invalid command! Enter again.");
                   input = in.nextLine();
                 }

                 if(input.equals("1"))
                 {
                   System.out.println("\n" + Hero.Name + " Presses forward!");
                 }
                 if(input.equals("2"))
                 {
                   System.out.println( Hero.Name + " exit's the dungeon after slaying a total of: " + Monsters.enemyDeathCounter + " Monsters!");
                   break;
                 }
              } // while running bracket
              System.out.println("-------------------------------------");
              System.out.println("Thanks for playing!");
              System.out.println("-------------------------------------");

      } // Void Main.
    } // Public class Main.
