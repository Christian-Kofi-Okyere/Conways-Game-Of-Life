/*
 Name: Christian Okyere
 File: LifeSimulation.java
 Project: Conway's Game of Life
 */

public class LifeSimulation {
    static int rows; // defaut rows value
    static int columns; // default columns value
    static float chance;  // default chance value
    static int scale;  // default scale value
    

    public static void main(String[] args) throws InterruptedException{

        if (args.length >= 1) {  // command line argument for the int rows 
            rows = Integer.parseInt(args[0]);
        }
        if (args.length >= 2) {  // command line argument for the int columns
            columns = Integer.parseInt(args[1]);
        }
        if (args.length >= 3) {  // command line argument for the float chance
            chance = Float.parseFloat(args[2]);
        }
        if (args.length >= 4) {  // command line argument for the int scale
            scale = Integer.parseInt(args[3]);
        }
            
        // creates a new object of type Landscape
        Landscape scape = new Landscape(rows, columns,chance);
        // creates a new object of type LandscapeDisplay
        LandscapeDisplay display = new LandscapeDisplay(scape, scale);
        

        // endless loop that keeps track of scale, rows and columns 
        // it calls the advance method, repaint method, and runs the game endlessly
        // the sleep method makes the drawing sleep for 250ms before redrawing
        while (true){
            for (int t = 0; t < scale; t++) {
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < columns; j++) {
                        scape.advance();
                        display.repaint();
                        Thread.sleep(250);
                    }
                }
            }
            
        }
    }
    
}

