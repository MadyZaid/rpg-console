# rpg-console
A console based role play game in java.

## Run Instructions - 
- This is a gradle project.
- Clone the repo - 
```
git clone https://github.com/rbadolia/rpg-console.git
```

- After cloning the repo, go to the folder and run below command in terminal -
```
./gradlew clean build
```

- Go to /build/libs folder - 
```
cd build/libs
```

- Run below command -
```
java -jar rpg-console-1.0-SNAPSHOT.jar
```

- This will start the game.


## Playing Instructions -
 
* Select an option from the main menu. You can do the following -
1. Start a new game (this will take you to the play arena)
1. Load a saved game (this will load a last saved game)
1. Leave the game (You can exit the game if you want)

- Start new game will take you to the realm selection menu. Select a **realm** you are interested to play in.
- You will be taken to the welcome menu where you can **enter player details** - 
1. Enter a name of the player
1. Tell why you want to play this game
1. Divide bonus skill points into three characteristics - 
     1. Bonus Health (This will add to the base health),  
     1. Bonus Damage (This will add to the damage you cause to an enemy) 
     1. Bonus Damage Variation (This will add to the random damage calculation factor)
     1. My personal choice for above options can be 1, 2, 2
* You will be shown the player statistics and a map of the realm. Have a careful look and start exploring. To move in the map simply use **A(Left)S(Down)D(Right)W(Up)**.
* When you reach to an enemy location, you will be shown its statistics. Have a careful look and decide whether you want to fight or not.
* You can go back to the **map** and **explore** other enemies.
* If you choose to fight, then the attacks will happen between player and the enemy. Based on health stats one will win or lose. You can always flee the player from the fight but that will cause a penalty.
* If you feel that player health is gone down, you can go to a **medic** and get some health from him. The medic can be used only once.
* Player's **experience levels** will keep increasing as long as he is defeating the enemies and progressing. Every **level up in the experience** make the player more damageable.
* Once player defeats all enemies, the game will end.
* You can exit from the game anytime by pressing wrong options 5 times or choose an exit option from the menu. 
* You can also **save** the state of the game and later reload the game from here.

## Customizations - 
* This game is configurable and you can control it via settings defined in **application.properties**.
* The new realms can be made with new enemy character. This can be done in **SerializationRealmConfigurationGenerator** class and a call to main of this class will serialize the realm configuration. This configuration will be loaded at runtime in the world based on user selection.
 
 
## TO DO - 
1. Write unit tests for all the layers. Currently, I have focused mainly on Domain. Code coverage for the domain is 100% except for exception class.
2. See how can we write BDD test cases for this console game app.
3. Generate Xml docs in the whole project.
4. Move all messages to common location so that later they can be consolidated for localization support.


## Design - 
## World
![World](https://github.com/rbadolia/rpg-console/blob/master/Design/World.png)

## Character
![Character](https://github.com/rbadolia/rpg-console/blob/master/Design/Character.png)

## Player
![Player](https://github.com/rbadolia/rpg-console/blob/master/Design/Player.png)

## Enemy
![Enemy](https://github.com/rbadolia/rpg-console/blob/master/Design/Enemy.png)

## Medic
![Medic](https://github.com/rbadolia/rpg-console/blob/master/Design/Medic.png)

## GameController
![GameController](https://github.com/rbadolia/rpg-console/blob/master/Design/GameController.png)

## Exploration Controller
![ExplorationController](https://github.com/rbadolia/rpg-console/blob/master/Design/ExplorationController.png)

## FightController
![ExplorationController](https://github.com/rbadolia/rpg-console/blob/master/Design/ExplorationController.png)
