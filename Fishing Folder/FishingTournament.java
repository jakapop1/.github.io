/**
* FishingTournament game for 2 players.
* @ author, Christian | Jakapop | Juvy 
* @since 12/08/22
*
*/

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class FishingTournament {

   private static final int gameDuration = 12;
   
   private static final int POND_CAPACITY = 40;
   
   private static ArrayList<FishableI_a> lokoi_a = new ArrayList<>();
   
   private static ArrayList<I_a> player1 = new ArrayList<>();
   
   private static ArrayList<I_a> player2 = new ArrayList<>();
   
   private static boolean playerOnesTurn;
   
   
   public static void main(String[] args) {
   
      Scanner userIn = new Scanner(System.in);
      String inString = new String("");
      boolean stopLoop = false;
   
      while (!stopLoop) {
         System.out.println("******** Welcome to the Fishing Tournament Simulation! ********");
         System.out.println("\nThis Game requires 2 players to play.");
         System.out.println("Enter 1 to play.");
         System.out.println("Enter 0 to quit.");
      
      //read in from user as a String -- much less errors can happen!
         inString = userIn.nextLine();
      
      //take off any spaces on the string
         inString = inString.trim();
         
         switch(inString) {
            case "1":
               playGame();
               stopLoop = true;
               break;
            case "0":
               break;
            default :
               System.out.println("Not a valid entry, please enter 1 or 0!");
               break;
         }
      
      }
      
      
   }
   
   public static void playGame() {
   
      
      Scanner userIn = new Scanner(System.in);
      String inString = new String("");
      boolean endLoop = false;
      boolean endLoop2 = false;
   
   
   
      
      
      lokoi_a = FishingDriver.fillPond();
      System.out.println("Filling pond with Fish!");
      
      FishingDriver.growFish(lokoi_a);
      System.out.println("Waiting 2 years for fish to grow....");
        
      System.out.println("\n********Let the tournament begin!********");
      
      System.out.println("\nRound 1 will now begin.");
      
      
      for (int i = 0; i < gameDuration;) {
      
      
         while (!endLoop) {
            playerOnesTurn = true;
            System.out.println("\nPlayer 1, it is your turn!");
            System.out.println("\n* Choose:");
            System.out.println("1. Cast out for a fish");
            System.out.println("2. View sack of fish");
            System.out.println("3. Throw back a fish in the sack");
         
         //read in from user as a String -- much less errors can happen!
            inString = userIn.nextLine();
         
         //take off any spaces on the string
            inString = inString.trim();
         
            switch(inString) {
               case "1":
                  I_a tempFish = lawai_a(lokoi_a);
                  if (tempFish != null) {
                     player1.add(tempFish); 
                  }
                  endLoop = true;
                  break;
               case "2":
                  System.out.println("You have " + player1.size() + " fish in your sack."); 
                  for (int j = 0; j < player1.size(); j++) { 
                     System.out.println("Fish " + (j+1) + " \n" +
                        player1.get(j).toString());
                  } 
                  break;
               case "3":
                  for (int j = 0; j < player1.size(); j++) { 
                     System.out.println("Fish " + (j+1) + " \n" +
                        player1.get(j).toString());
                  }
                  System.out.println("At what index would you like to remove?");
                  
                  try { int index = Integer.parseInt(userIn.nextLine()); 
                     player1.remove((index+1)); 
                  } catch (Exception e) { 
                     System.out.println("Invalid Index!"); 
                  }
               
               
                  break;
               default :
                  System.out.println("Not a valid entry! Please enter 1-3,");
            } // end inString
         } // end while player 1 menu
            
         while (!endLoop2) {
               
            playerOnesTurn = false;
            System.out.println("\nPlayer 2, it is your turn!");
            System.out.println("\n* Choose:");
            System.out.println("1. Cast out for a fish");
            System.out.println("2. View sack of fish");
            System.out.println("3. Throw back a fish in the sack");
         
         //read in from user as a String -- much less errors can happen!
            inString = userIn.nextLine();
         
         //take off any spaces on the string
            inString = inString.trim();
         
            switch(inString) {
               case "1":
                  I_a tempFish = lawai_a(lokoi_a);
                  if (tempFish != null) {
                     player2.add(tempFish); 
                  }
                  endLoop2 = true;
                  break;
               case "2":
                  System.out.println("You have " + player2.size() + " fish in your sack."); 
                  for (int j = 0; j < player2.size(); j++) { 
                     System.out.println("Fish " + (j+1) + " \n" +
                        player2.get(j).toString());
                  } 
                  //endLoop = true; 
                  break;
               case "3":
                  System.out.println("");
                  break;
               default :
                  System.out.println("Not a valid entry! Please enter 1-3,");
            } // end inString
           
            
         } // end while
      
      
      // reset whileLoop
         endLoop = false;
         endLoop2 = false;
      
      // increments turn by 1
         i++;
      // round ending
         System.out.println("\n******** This month of fishing has ended! ********");
      // feeding/growing fish
         growFishByMonth(lokoi_a);
         System.out.println("Round " + (i+1) + " will now begin.");
      
         if (i == gameDuration) {
            System.out.println("END");
         }
      
      }  
   } // end playGame
   
   public static I_a lawai_a(ArrayList<FishableI_a> fishPond) {
      
      Random randGen = new Random();
      FishableI_a ia;
      int chosenFish = 0;
      boolean isCaught = false;
      boolean isLegal = false;
      Scanner userIn = new Scanner(System.in);
      String inString = new String("");
      boolean endLoop = false;
   
      
      chosenFish = randGen.nextInt(POND_CAPACITY);
      
      try {
         ia = fishPond.get(chosenFish);
      
         System.out.println("You have hooked a fish!");
      //randomly caught or not
         isCaught = randGen.nextBoolean();
         if (isCaught) {
            System.out.println("You have caught a fish!");
            System.out.println(ia);
            System.out.println("Do you want to keep this fish y/n?");
            
            inString = userIn.nextLine();
            
            if (inString.equalsIgnoreCase("y")) {
               System.out.println("You have kept your fish");
               fishPond.remove(chosenFish);
            
               if (ia.isLegalSize()) {
                  System.out.println("Your fish is legal");
                  return ia;
               } else {
                  System.out.println("You kept an illegal fish!");
                  System.out.println("You got a ticket and all of your fish were confiscated!");
                  getConfiscated();
               }
            } else {
               System.out.println("You have chosen not to keep the fish");
               System.out.println("Throwing fish back in water!");
            }
         } else {
            System.out.println("Your fish got away!");
         }
      } catch (IndexOutOfBoundsException ie) { //fish has been removed already
         System.out.println("You didn't hook anything.");
      }
      return null;
   }
   
   public static void growFishByMonth(ArrayList<FishableI_a> al) {
      FishableI_a ia;
      
      System.out.println("Month of Feeding and Growing Has Passed!");
     
      //all fish in the pond
      for (int i = 0; i < al.size(); i++) {
         //loop over array 
            
         ia = al.get(i);
            // feeding fish
         try { //must check for need to levelUp
            //use EnglishName because doesn't change with size
            if (ia.getEnglishName().equals("Striped Mullet")) {
               ia.eat("algae");
            } else if (ia.getEnglishName().equals("Goatfish") 
                     || ia.getEnglishName().equals("Yellowfin Goatfish") 
                     || ia.getEnglishName().equals("Square-spot Goatfish"))  {
               ia.eat("worms");
            } else if (ia.getEnglishName().equals("Parrotfish")) {
               ia.eat("algae");
                  
            } else if (ia.getEnglishName().equals("Six-fingered threadfin")) {
               ia.eat("crustaceans");
                  
            }
         
         } catch (FishSizeException fe) {
               //need to level up
               
            ia = ia.levelUp();
         
         }
         al.set(i, ia);
      }
   }

      
   public static void getConfiscated() {
      if (playerOnesTurn == true) {
         player1.removeAll(player1);
      } else {
         player2.removeAll(player2);
      }
   
   }
      
      
}


   
