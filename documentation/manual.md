This is the usermanual for KumpulaTD

When launching the game, you are presented with available maps in the menu as well as quitting the game.

If map files are not found, message is shown and you are returned to the main menu. Otherwise the map will start.

Numbers from 1 to 9 are used to select tower, up to the number of locations on the map.

On the right panel there is shown bunch of interesting information as well as how to buy, sell and upgrade different towers. First press number key to select tower and then press desired button to get effect. If player doesn't have sufficient funds, nothing will happen.

Game ends when enemies reach finishline in sufficient quantity that is specified on the map.

To create a new map, you need suitable .png image that is ~800 pixels wide and ~700 pixels tall. Height can be variable but then user needs to resize the frame to suit the map size. Put it in src/main/resources folder.

Then add the map to the maplist.txt found in src/main/resources folder.

Then you need to create the file that has to match excatly what you put on the maplist.txt file. Get the idea from existing maps.

Format for the file is, center column is the one that has to be included in text file. Look for extra guidance from existing files.

| Row | Contents | Comments |
|------|--------|-------|
| 1 | path/to/map/image | Background Image location |
| 2 | xxx,yyy,xxx,yyy | Spawnpoint locations |
| 3 | xxx,yyy | Goal location |
| 4 | xxx,yyy,xxx,yyy | Points for pathfinding |
| 5 | xxx,yyy,xxx,yyy | Towerlocations |
| 6 | int | Amount of lives |
| 7 | int | Amount of money |
