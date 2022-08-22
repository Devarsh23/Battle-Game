# Project 2
## Player Battle

## 1.About/Overview
The given problem statement states that the gaming comapny jumpstastic game wants to design and make the model of the role playing game. They want the to design the two player game which will initially assign the random values to the players ability like strength, constitution, charisma, dexterity by rolling the four dice and discarding one as the output of the dice and taking sum of maximum three result to assign a value to the players basic four ability. This I have done in the model by using the roll dice function which is called when we need to initialize the players ability. Now, after possesing the basic ability the players enter the battle ground with the bare hands. Here, the player is given the ability to equip gears and equip weapon. The gear the player equip can affect player in a positive or a negative way. I have created the EquipGearHelper method tho help the player to equip gear from the available bag of gears. Similarly I have created the equipweapon to help the player to get the weapon from the available list of weapons. Now, the various updated values of the players ability is calculated on the basis of the temporaray effcet of the gears they have equip. I have done this by providing the method like geteffectivestrength and others. Now, after this the battle starts and the players take turns and ability values of the players are compared to decide what damage a player can do to other player. I have implemented this by using the attack function. Now the health is updated after eacha nd every round of the battle so when the health of the player goes less than zero than the game ends and we have a clear winner.

So, here I have tried to solve this problem by creating the set of required features (function) which would not ony help them to solve their problem of designing turn taking game but would also provide them the added functionality. I have designed and implemented this functionality considering the **Object Oriented Design** as a design paradigm. 
## 2. List of features
- rollDice() : I have given the functionality to create the player by assigning the values to their abilities with the help of rollDice Function. Here, the rollDice function generates and intializes the values of each and ability of the player. Here in rollDice function I have discarded the one output and selected the max 3 output from the available four output. Hence rollDice is used to generate random values.
- equippedGearHelper() : I have given the functionality to equip the player with the appropriate gears by using equippedGearHelper method. First we will make a bag of gears in arena from that bag we will assign the negative effcet 25% of the gears affecting the players abililty. From this the bag both the players will assigned the half gears. Now I have also provided the functionality that the player can not take illegal amount of the geras like he/she can take only one headgear and upto ten units of belts.
- equipWeapon() - I have created a functionality that will help the user to get one weapon from the available list of weapon. Every player can take only one weapon except katanas. If the first weapon is the katanas then the player will given the chance to choose the second weapon and if the second weapon is also katanas then the player can take both the katanas else it has to take only one weapon.
- I have also given various getters method which will help to identify the field values when the battle is going on.
- I have given the functionality which will determine which player will take the first turn based on the charisma values.
- I have given the functionality to start the battle which will monitor the rounds on the battle and output the info after each round about the abilities of the player.
- Other than this I have given the functionality to calculate the damage and the potential damage of the player.
- Also, I have provided the functionlaity to sort the gears equipped by the player in the sorted manner of top to bottom.
## 3. How to Run
- This project can be run by running the JAR file provided in the res folder.
## 4. How to use program
- I have created the Battle as the model of my class. So, all the functionality is housed in the model. So to use the program you need to instantiate the battle class. Here you will get the various method like fight, the method to determine the turn, the method to equip the player with the gears and weapon. And the helper method to get the and calculates the various abilities of the player.
- We have to pass the object of the random class in to parameter of the battle object this will help us to generate the random values as and when neede by the program.
- The Battle can be begin by calling the fight method on the battle object. 
- It is imporatnt to note that the battle can not begin before initializing the player with the gears, weapon and other required abilities.
- Hence the battle serves as the house of the model and you need to instantiate battle class in order to run the various functionality of the user.

  
## 5. Description Of Example
- The description of the output is provided in the DriverOutput.txt files in the res folder.
- line 1- The welcome message is printed on the line one.
- line 3 The description about the player one is provided. 
- line 5-11 the various abilities of the player one are printed.
- line 13 The description about player 2 is printed
- line 15- 21 the variuos abilities and the name of the player 2 is printed
- line 23 The description about the player 1 equippinig the gear is printed.
- line 25-39 The gear equipped by the player one are printed in the sorted manner in this lines. The description about each gear is also printed.
- line 41 The description about the player 2 equippinig the gear is printed 
- line 43- 58 The gear equipped by the player two are printed in the sorted manner in this lines. The description about each gear is also printed. 
- line 60 The player one request the weapon from the armory.
- line 61 prints the weapon the player one receive.
- line 63 The player two request the weapon from the armory.
- line 64 prints the weapon the player two receive.
- line 68 - 80 It displays the the abilities of both the players after equipping the gear.
- line 81 the battle begins.
- line 83 the player taking the first turn is printed
- line 85-91 the information about round 1 is ptinted
- line 93-99 the information about round 2 is printed
- line 101 - 107 the information about round 3 is printed
- line 109-115 the information about round 4 is printed
- line 116 the winner is printed
- line 118 the information about continuing the battle is printed.
- line 121 the Rematch between the players start.
- line 123 the rematch begins
- line 125 the infi if first chance printed.
- line 127-157 all the round info of rematch is printed
- line 158 the winner of rematch is printed.
- 
- Now the second example is given.
- line 165-173 the info about the player one is printed
- line 175-183 into about the player two is printed.
- line 185-201 The gear equipped by the player one are printed in the sorted manner in this lines. The description about each gear is also printed.
- line 200-216 The gear equipped by the player two are printed in the sorted manner in this lines. The description about each gear is also printed.
- line 221- 227 Description about both the players request the weapon form the armory and get the weapon.
- line 228-242 The info after equiping the gear is printed.
- line 243- 244 Info about who will take the first turn is printed.
- line 246-252 the information about round 1 is printed
- line 254-260 the information about round 2 is printed
- line 262-268 the information about round 3 is printed
- line 270-276 the information about round 4 is printed
- line 278-284 the information about round 5 is printed
- line 2485 the winner is printed.
- 
- New RUN run3
- Now we will walkthrough the third example which will end in a draw.
- line 293-367 both the player info are printed and their equipped gears are also printed along side the deatils of the ability after equipping the weapon is printed.
- line 367 the first turn info is printed.
- line 369- 642 the thirty round takes place and none of the players hit each other so the game end in a draw. 
- Hence We have walkthrough the entire example and discuss each aspect of it.
## 6. Design/Model Changes
- Introduced the enum classes of the ability and the belt sixe to represent the categorical features.
- Also introduced he battle model which will house the majority of the functionality in to.
- I have added the arena bag from which the player can draw the weapon and the gears.
## 7. Assumptions
- In the description, it is given that the player's ability is temporarily affected(positively or negatively) by the gear they use. So, here I am Assuming that the effect of the gear remains on the player's ability throughout the battle.  
- If both the players have same charisma then the player one will take the first line.
- The striking power, avoidance ability and effective health can not be negative.
- Also I have assumed certain range of the numbers in generating the random numbers.
## 8. Limitations
- There are no imitation in the project as it works according to the description given. The project completely runs and checks all the functionality which are mean to be provided in to the sanctuary. Also, the test case provided encourages that the code runs well under all circumstances.
## 9 Citations
- I have not used any major citation but I have seen some line of code on stack overflow. So the link for that code is : "https://stackoverflow.com/questions/17873384/how-to-deep-copy-a-list"




.








