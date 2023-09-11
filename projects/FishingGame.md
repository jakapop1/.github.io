---
layout: project
type: project
image: img/4k1.jpg  
title: "Fishing Tournament"
date: 2022
published: true
labels:
  - Java
  - GitHub
summary: "A text fishing game that I developed for ICS 211."
---

<!-- Add a professional header with centered title -->
<div style="text-align: center;">
  <h1 style="font-size: 28px;"></h1>
  <img src="/img/4k1.jpeg" alt="Fishing Game" style="max-width: 400px; margin: 20px auto;" />  <!-- Updated image path -->
</div>

<!-- Brief project summary -->
A text-based fishing game developed for ICS 211.

## Project Overview

The Fishing Game project is a collaborative effort with my partner. The objective was to create an interactive two-player fishing tournament game. The game involved the development of a virtual ecosystem where players would take turns catching, collecting, and managing fish through the console. The project aimed to apply object-oriented programming principles and demonstrate proficiency in Java.

## Goal of the Project

Create a text-driven fishing experience while conforming to some of real world constraints and classifications such as legal fish sizes and seasonal availabilities.

## My Role and Contributions

In this project, my primary responsibility was to implement various fish species according to the specifications provided. The fish species I worked on included Weke'ula, Weke'a, Uhu, Pua'ama, Panuhunuhu, Ohua, Oama, Kahaha, and Anae. Each fish had to adhere to the Fishable interface and its associated requirements, such as legal size, bait status, and catch methods.


Another of my responsibility was in ensuring that the implemented fish classes integrated seamlessly with the existing codebase. This involved modifying the inheritance hierarchy, updating class methods, and testing the classes to verify their functionality.

At the same time, my partner is doing the same but with different sets of classes representing other families of fishes.

Last, my partner and I put the classes together to then structure the core gameplay of the Fishing Tournament. This included implementing the game's main loop, player turns, fish interactions, and the determination of the game's outcome while allowing players to make decisions on catching and managing their fish.

## Tools and Technologies
- Programming Language: Java
- Platform: Console
- Testing: JUnit tests



## Design & Implementation
Class Structure and Hierarchy:
- Ama_ama.java
- Anae.java
- Kahaha.java
- Oama.java
- Panuhunuhu.java
- Pua_ama.java
- Uhu.java
- Weke_a.java
- Weke_ula.java

## Game Logic
- Fishingtournament.java


## Core Game Loop
Base structure of the fishing game.
```
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
       ......
         }
      
      }
       }
```
## Player Interaction within Game Rounds
Logic for how to handle a player's turn with possible actions.
```
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
                        ......
```

## Fishing Logic: 
Demonstrates some of the randomness in the game's mechanics through the use of exceptions, and decision/logic based player's actions.
```
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

            .....
                                          
            

```

## Class Hierarchy Visual

<img width="600px" 
     class="rounded float-start pe-4" 
     src="https://github.com/jakapop1/jakapop1.github.io/blob/main/img/classHier.PNG?raw=true" >

A code snippet for one of the classes I had to implement extending another class.
```
public class Anae extends Ama_ama {

   /** constant maximum length for this Ia. */
   private static final double anaeMaxLength = 27.0;

   /** constant minimum length for this Ia. */
   private static final double anaeMinLength = 12.0;


   /**
   * Constructor for making Anae with random length.
   * This is the fourth phase of the family fish.
   * @throws FishSizeException if length is less than minLength
   */
   public Anae() {
      super("'Anae", anaeMaxLength, anaeMinLength, 
         anaeMinLength, (anaeMinLength * 2), dietItems, "silver", "silver", "none");   

      this.initLength();
   }
    ......
```





## Lessons Learned

Through this project, I gained a lot of valuable experience in object-oriented design through Java programming. I learned how to design and implement a hierarchy of classes that adhered to specific interfaces. This project also improved my problem-solving skills, as I had to tackle various challenges related to fish behavior and game mechanics.

Additionally, I learned the importance of effective collaboration and communication within a development team. We worked together to ensure that our individual contributions integrated smoothly, resulting in a cohesive and functional game.

In conclusion it served as an opportunity to apply theoretical knowledge to a practical, hands-on project, and I am proud of the final product we created!

Source: Github Repository unavailable to public.

