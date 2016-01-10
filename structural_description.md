The program is structured around 2 elements. GameView and Game. Window is initial class that is passed and used up by GameView after choosing map. 

GameView handles all drawing of the game. It also takes care of looping through a timer that calls paint() on the frame. On each paint, update on Game is called and it does all the required calculations including moving objects, creating new objects and handling user input. Game then passes that information to GameView and it renders the picture.

The Game class calls other classes to do the calculations, often static. It also loads up most of the sprites on startup.

GameView passes the information to Drawer class that does the actual drawing with static classes.

UI has also some messagebox classes that can be called to create warning and information messages.
