/*
 Name: Christian Okyere
 Date: 02/19/2023
 Section: B
 File: Landscape.java
 Project: Conway's Game of Life
 Course: CS231
 */

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Landscape {

    /**
     * The underlying grid of Cells for Conway's Game
     */
    private Cell[][] landscape;

    /**
     * The original probability each individual Cell is alive
     */
    private double initialChance;

    /**
     * Constructs a Landscape of the specified number of rows and columns.
     * All Cells are initially dead.
     * 
     * @param rows    the number of rows in the Landscape
     * @param columns the number of columns in the Landscape
     */
    public Landscape(int rows, int columns) {
        landscape = new Cell[rows][columns];
        reset();
    }

    /**
     * Constructs a Landscape of the specified number of rows and columns.
     * Each Cell is initially alive with probability specified by chance.
     * 
     * @param rows    the number of rows in the Landscape
     * @param columns the number of columns in the Landscape
     * @param chance  the probability each individual Cell is initially alive
     */
    
    public Landscape(int rows, int columns, double chance) {
        landscape = new Cell[rows][columns];
        initialChance = chance;
        reset();
    }

    /**
     * Recreates the Landscape according to the specifications given
     * in its initial construction.
     */
    public void reset() {

        Random rand = new Random();
        for (int row = 0; row < this.getRows(); row++){
            for (int column = 0; column < this.getCols(); column++){
                landscape[row][column] = new Cell(rand.nextDouble() > initialChance);
            }
        }
    }

    /**
     * @return the number of rows in the Landscape
     */
    public int getRows() {
        return landscape.length;
    }

    /**
     * Returns the number of columns in the Landscape.
     * 
     * @return the number of columns in the Landscape
     */
    public int getCols() {
        return landscape[0].length;
    }

    /**
     * Returns the Cell specified the given row and column.
     * 
     * @param row the row of the desired Cell
     * @param col the column of the desired Cell
     * @return the Cell specified the given row and column
     */
    public Cell getCell(int row, int col) {
        return landscape[row][col];
    }

    /**
     * Returns a String representation of the Landscape.
     */
    public String toString() {

        String output = "";

        for (int row = 0; row < this.getRows(); row++) { 
            for (int column = 0; column < this.getCols(); column++) {
                output += this.landscape[row][column] + " ";
            }
            output += "\n";
        }
        return output;
    } 

    /**
     * Returns an ArrayList of the neighboring Cells to the specified location.
     * 
     * @param row the row of the specified Cell
     * @param col the column of the specified Cell
     * @return an ArrayList of the neighboring Cells to the specified location
     */
    public ArrayList<Cell> getNeighbors(int row, int col) {
        int i = -1;

        List <Integer> xList = new ArrayList<Integer>();
        List <Integer> yList = new ArrayList<Integer>();
        ArrayList <Cell> neighborCells = new ArrayList<Cell>();

        while (i < 2){
            xList.add(row + i);
            yList.add(col + i);
            i++;
        }

        for (int xval : xList){
            for (int yval : yList){
                if (xval < 0 || yval < 0 || xval >= landscape.length || yval >= landscape[0].length || (xval == row && yval == col)){
                    continue;
                } else{
                    neighborCells.add(getCell(xval, yval));
                }
            }
        }
        return neighborCells;
    }

    /**
     * Advances the current Landscape by one step. 
     */
    public void advance() {
        
        Cell[][] temp = new Cell[this.getRows()][this.getCols()];
        for (int row = 0; row < this.getRows(); row++) {
            for (int col = 0; col < this.getCols(); col++) {
                ArrayList<Cell> cellNeighbors = getNeighbors(row,col);
                temp[row][col] = new Cell(this.landscape[row][col].getAlive());
                temp[row][col].updateState(cellNeighbors);
            }
        }

        landscape = temp;
    }

    /**
     * Draws the Cell to the given Graphics object at the specified scale.
     * An alive Cell is drawn with a black color; a dead Cell is drawn gray.
     * 
     * @param g     the Graphics object on which to draw
     * @param scale the scale of the representation of this Cell
     */
    public void draw(Graphics g, int scale) {
        for (int x = 0; x < getRows(); x++) {
            for (int y = 0; y < getCols(); y++) {
                g.setColor(getCell(x, y).getAlive() ? Color.BLACK : Color.gray);
                g.fillOval(x * scale, y * scale, scale, scale);
            }
        }
    }

    public static void main(String[] args) {
    }
}
