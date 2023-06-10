# Conways-Game-Of-Life

## Background<br>
Conway's Game of Life is a popular cellular automaton devised by mathematician John Horton Conway in 1970.<br>

1. Rules: The game is played on a grid of cells, which can be either "alive" or "dead." Each cell interacts with its eight neighboring cells based on three simple rules:
   - Any live cell with fewer than two live neighbors dies (underpopulation).
   - Any live cell with two or three live neighbors survives to the next generation.
   - Any live cell with more than three live neighbors dies (overpopulation).
   - Any dead cell with exactly three live neighbors becomes alive (reproduction).

2. Patterns: The game starts with an initial configuration of live and dead cells. As the game progresses, the cells evolve based on the rules. Different patterns can emerge, including stable formations, oscillators that repeat their pattern, and glider patterns that move across the grid.

## Simulation of Conway's Game of Life 

This project is a simulation of Conway’s Game of Life. 
To make this game, I created some various class files: Cell Class, Landscape Class, LifeSimulation Class and the Extension Class. I used a two dimensional grid of cells to make a
landscape. 

* The Cell Class contains methods that are used to designate the properties of each cell. It determines whether a cell is dead/alive (its initial stages). It has an arraylist method that stores the neighboring cells and the number in that list determines if a cell surrounded by that neighbor is dead/alive.
* The Landscape Class has an object that draws the overall landscape of the game with some
specified parameters like rows and columns.<br>
* The LifeSimulation Class uses the command line arguments to let the user specify their preferred number of rows, columns, scale and chance.<br>
* The Extension Class uses GUI to control when the game begins.

This project helps to understand the concept of object-oriented programming, multiple methods (static and non-static), variables, loops and dynamic arrays in java.


## Installation <br>
To use this blackjack simulator, simply clone this repository to your local machine:
git clone https://github.com/Christian-Kofi-Okyere/Conways-Game-Of-Life

## Usage<br>
To run the game simulator, simply execute the LandscapeDisplay class.<br>
-> javac LandscapeDisplay.java -> java LandscapeDisplay<br>
This runs a simulation of the game and generates the results in an interface showing the movements of various cells.

## Contributing<br>
Contributions to this project are welcome. To contribute, simply fork this repository, make your changes, and submit a pull request.
