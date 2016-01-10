****Testing Documentation****

**User Input**

The game has been implemented in a way that it reads all user input char by char basis and parses that to a command. If the char is not specified to any single action it's discarded so meaning during game play no illegal action is possible. In main menu only few buttons are available. Thus it should be completely impossible for user to generate in normal situation, a command that would crash the game.

**Initializing map**

Game reads info from the initialization file. Initializator checks for file consistency and depending on the mistakes found on the file the map will either not start or it will start but gameplay might be affected and the player is warned. 

**End game dialogs**

For some reason the end game dialogs are not showing up properly on linux machines. Clicking the X on the corner does close the popup and allow the player to return to the main menu. Some linux UI:s dont show the X for popups like the one found on ElementaryOS and only way to get around the screen is to kill the game process and start again. OSX and Windows work properly.

**JUnit testing**

The tests are not that extensive but most important parts are tested. The way how the program processes data already gives pretty good cover for any mistakes that might come up from the datafile as the 
