---
layout: project
type: project
image: img/4k1.jpg  
title: "HACC 2023"
date: 2023
published: true
labels:
  - Javascript
  - GitHub
  - HTML
  - CSS
  - Web-Development
summary: "ICS314/HACC project"
---
<div style="text-align: center;">
  <h1 style="font-size: 28px;"></h1>
  <img src="/img/fishing.jpg" alt="Fishing Game" style="max-width: 600px; margin: 20px auto;" />  
</div>

<!-- Brief project summary -->
HACC-2023 project with the goal of creating a web application for the people of Hawaii to find medical care regardless of insurance status. 

## Introduction

Getting medical coverage can be tricky especially if you are un/under-insured. In some cases, as a result, people seeking medical care end up not going at all as most medical facilities require decent medical coverage. This project aims to help people avoid that situation with the goals of connecting them to a qualified expert that can help.


## Project Overview

What this project aims to do is to provide a web application that stores and filters the locations based off of specific requirements like whether or not a facility requires insurance. Thus, people seeking medical care will be able to find experts in each field of their desired care with the hopes of saving on costs. Around the filter, my team and I have created various pages to fill out the website with things that would provide the user with as much information as possible. 

## Goal of the Project

Create a fully interactive website that allows users to get information on their current medical needs and providing them steps towards assistance. 

## My Role and Contributions

For this project, I worked in a team of 4. My responsibilities were mainly the web-application's backend. My group and I had milestones in which we were to progress in accordingly. My contribution to the project are as follows: 
- Database: Using MongoDB, I set up the user's profiles, medical facilities
- Filter: Created a filter utilizing Javascript to filter in order based off of location, medical service, and insurance status.
- Data-Scraping: Through [health.hawaii.gov](https://health.hawaii.gov/ohca/medicare-facilities/) data was gathered into a js file based off of select information (location, services, insurance etc.) and later retrieval.


## Tools and Technologies
- Programming Language: Java Script, Html, CSS
- Platform: Github
- Testing: TestCafe



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







## Resources

[readme](https://github.com/jakapop1/jakapop1.github.io/blob/ae553bcbb5ff7d099db80edef2e9e1faf17228cf/Fishing%20Folder/README.md)


[fishingTournament.java](https://github.com/jakapop1/jakapop1.github.io/blob/ae553bcbb5ff7d099db80edef2e9e1faf17228cf/Fishing%20Folder/FishingTournament.java)


[cloned repository codebase](https://github.com/jakapop1/jakapop1.github.io/tree/ae553bcbb5ff7d099db80edef2e9e1faf17228cf/Fishing%20Folder)
