# Fishing Game
## Grading
 * 100 points for the game code.
   * **Due Tuesday Dec 13 at noon**
 * 10 points for writing a thorough code review.
   * For code review, each group should have a `develop` branch that holds a *beta* version of your game.
   * **Code reviews will be done in class on the last day of class: Thurs Dec 8th. Attendance (in-person or virtual with cameras) is required. Your game should be somewhat working.**
   * Each group will be reviewing another group's project together and combine their feedback in the pull request.
 * 10 points for using code reviewer suggestions and/or responding to your reviews in your pull request.

### Group Contributions
 * Each group member should fill out the [Group Contribution Google form](https://forms.gle/yebpzvEx89kHUkER9) after the assignment is submitted.
 * If all contributions are roughly equal, each group member will recieve the same grade. If some members have not contributed equally, their grades will be adjusted accordingly.
 
 
 ## Instructions
 * Finish implementation of Fishable interface for I_a fish hierarchy.
 * Build a two player Fishing Tournament game/main method using your I_a object classes.
   * Two players will alternate turns on the same computer.
   * The players will catch fish and put them into a "sack" (an ArrayList, sorted in descending order by length)
   * After 12 turns each, the player with the three largest fish is the winner.

### Fishable I_a Implementation
All `Fishable` fish need to be subclasses of a `FishableI_a` subclass of `I_a`.  See image:
  
![heirarchy](https://user-images.githubusercontent.com/279775/165010522-62a8f40d-7a9e-4496-9bb8-0686a603844a.png)

I am providing you with a new `Fishable.java` interface and a new `FishableI_a.java` abstract subclass of the `I_a` superclass. I have also fully implemented `Fishable` in the `Moi` family of fish. These new files are included here in this repository. Use the `MoiLi_i.java` - `Moi.java` classes as an example.

* You will need to move your `Oama`, `Ohua`, and `Pua_ama` fish families into this repo and modify them as follows:
  * Remove `implements Fishable` if it was there before. (Leave `implements ColorChangeable` and `SexChangeable` as is)
  * Change `extends I_a` to `extends FishableI_a` in the baby fish classes `Oama`, `Ohua`, and `Pua_ama`. The other inheritance remains the same.
  * Add (or modify if you made before) the methods required by `Fishable`
     * `isLegalSize`
     * `isBait`
     * `isGameFish`
     * `isInSeason`
     * `getCatchMethods`
     * I suggest implementing most `Fishable` methods from the baby fish type and have it handle most of the Fishable requirements. See `MoiLi_i.java`. You may need to add overloaded methods to a fish type that becomes legal size if it isn't the smallest, depending on your implementation of the methods (see `MoiMana.java`).
#### Fishable Values for Fish Families
* `Pua_ama` mullet family:
   *  Legal size is 11 inches and above
   *  Season is open April - November, closed December - March
   *  IsGameFish returns true if legal size
   *  Is not bait
   *  No bag limit (number of fish you're allowed to catch). Use `Integer.MAX_VALUE` as the limit.
   *  Valid catch methods for legal size fish are: `"net", "pole"`   
* `Ohua`/`Uhu` fish family:
   *  Legal size is 12 inches and above
   *  Season is always open
   *  IsGameFish if legal size
   *  Is not bait
   *  No bag limit (number of fish you're allowed to catch). Use `Integer.MAX_VALUE` as the limit.
   *  Valid catch methods for legal size fish are: `"throw net", "spear", "pole"`   
* `Oama`/`Weke` fish family:
   *  No minimum legal size 
   *  Season is always open
   *  IsGameFish
   *  IsBait
   *  Bag limit is 50
   *  Valid catch methods for legal size fish are: `"net", "trap", "pole"`  

There are new JUnit test for all of the fish types in this repository.

### Fishing Tournament Phase 1 - Loko i'a (Fish Pond) Setup
  * The first thing that should happen in the Fishing Tournament is the Fish Pond (ArrayList) should be filled up with baby fish of all `Fishable` types, then it should loop for around 2 pretend years (24 months) so the fish can grow to be roughly legal size.
      * I have given you some of the code required for this in `FishingDriver.java`. After you have your `I_a` modified for `Fishable` as above, run the `FishingDriver` and examine the code.

### Fishing Tournament Phase 2 - Lawa i'a (Fishing)
 * In the second (main game play) phase of the game, the fishing tournament should last for a whole "year" (12 months)
 * The two players should alternate turns. Once both players have had a turn, the "month" will be over and change to the next "month". 
 * When the "month" changes, the fish in the pond should eat and grow once, like in the `FishingDriver.java` example. 
 * During each player's turn, they will get to attempt to catch a fish three times.
 * Each catch attempt will have three possible outcomes: No fish is hooked (random empty ArrayList location hit) or a fish is hooked (fish randomly picked from ArrayList pond) and is either caught or gets away.
    * If the fish is caught, the player will then need to decide whether or not to keep it.
       * If the fish is kept, the fish should be checked for legal size and legal month.
       * If the kept fish is legal, it should be added to the player's sack and removed from the pond.
       * If the kept fish is not legal, the player will be punished by having all of their fish confiscated (sack of fish emptied) 
 
 Example of game play:
 ```
Player 1, it is your turn! 
 * Choose:
   1. Cast out for a fish
   2. View sack of fish
   3. Throw back a fish in the sack.
   
   Choice: 1
    You have hooked a fish!
    You have caught a fish!
      Name: Uhu
      English name: Parrotfish
      Scientific name: Scarus Psittacus
      Length: 12.487740994862454
      Weight: 24.97548198972491
      Body color: blue-green
      Fin color: blue
      Sex: supermale
      
  * Do you want to keep this fish y/n? y
   You have kept your fish
   Your fish is legal and has been added to your sack
```
Other outcomes would be:
```
   You have kept your fish
   You kept an illegal fish!
   You got a ticket and all of your fish were confiscated!
```
or 
```
  Your fish got away!
```  
* The other options will list the sack of fish in order by length, longest first (like you did in Assignment 5). 
* The throw back option will list the sack of fish (with the index number too) then ask the player to enter the number of the fish they want to throw back. 
    * The throw back option should remove the chosen fish from the player's list and add it back to the fish pond list.
    * The idea behind this is that towards the end of the game, the pond might be getting pretty empty and a player might want to put some fish back in.


Regardless, each player should get to cast out for a fish three times before their turn is over. They can list and release fish as many times as they want in a turn.
 
### Game Phase 3 - Game Over
 * Once 12 "months" of turns have been taken, the two players' lists should be compared. The player with the largest three fish (sum of the three longest lengths) is the winner! 
* You probably will need to adjust how many fish are in the pond and how much they get to grow to make the game more or less challenging.
* 
## Assignment 5 Grading
----
- [x] **10/10** Code review for Group:   .
- [x] **10/10** Respond to Code review from Group:        .

- [x] **20/20** Fishable interface upgrade to I_a classes.
- [X] **10/10** Setup of fish pond
- [x] **10/10** Implementation of players (can be an object or something else)
- [x] **10/10** Alternating turns, three casts per turn
- [x] **10/10** Tracking of "months"/ fish eat/grow between.
- [x] **10/10** Implementation of illegal fish penalty
- [x] **10/10** Implementation of throwing back functionality
- [x] **10/10** Correct win/lose calculation.
- [x] **10/10** Comments, coding style, documentation.
