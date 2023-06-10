/*
 Name: Christian Okyere
 File: Cell.java
 Project: Conway's Game of Life
 */

import java.util.ArrayList;

public class Cell {

    /**
     * The status of the Cell.
     */
    private boolean alive;

    /**
     * Constructs a dead cell.
     */
    public Cell() {
        this.alive = false;
    }

    /**
     * Constructs a cell with the specified status.
     * 
     * @param status a boolean to specify if the Cell is initially alive
     */
    public Cell(boolean status) {
        if (status == true){
            this.alive = true;
        } else {
            this.alive = false;
        }
    }

    /**
     * Returns whether the cell is currently alive.
     * 
     * @return whether the cell is currently alive
     */
    public boolean getAlive() {
        return (this.alive == true);
    }

    /**
     * Sets the current status of the cell to the specified status.
     * 
     * @param status a boolean to specify if the Cell is alive or dead
     */
    public void setAlive(boolean status) {
        this.alive = status;
    }

    /**
     * Updates the state of the Cell.
     * 
     * If this Cell is alive and if there are 2 or 3 alive neighbors,
     * this Cell stays alive. Otherwise, it dies.
     * 
     * If this Cell is dead and there are 3 alive neighbors,
     * this Cell comes back to life. Otherwise, it stays dead.
     * 
     * @param neighbors An ArrayList of Cells
     */
    public void updateState(ArrayList<Cell> neighbors) {
        
        int countAlive = 0; // to keep track of those alive
        for (Cell neighbor : neighbors){
            if (neighbor.getAlive() == true) {
                countAlive++;
            }
        }
        if (this.getAlive() == true) {  
            if (countAlive == 2 || countAlive == 3 ){
                this.alive = true;
            } else {
                this.alive = false;
            }
        }else if(this.getAlive() == false){
            if (countAlive == 3){
                this.alive = true;
            }
        }
    }

    /**
     * Returns a String representation of this Cell.
     * 
     * @return 1 if this Cell is alive, otherwise 0.
     */
    public String toString() {
        String output = "";
        
        if (this.getAlive() == true){
            output += 1;
        }else{
            output += 0;
        }
        return output;
    }
    public static void main(String[] args) {
        
    }
}
