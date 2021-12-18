/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recipebox;
import java.util.ArrayList;
import java.util.Scanner;

/**
*
* @author isral Duke, isral.duke@snhu.edu
*/
public class Ingredient {

    // set variables
    private String  ingredientName           ;
    private float   ingredientCups           ;
    private double  ingredientCaloriesPerCup ;
    private double  ingredientTotalCalories  ;


    // ingredient name 
    /**
     * @param ingredientName this sets the ingredient’s name
     */
    public void setIngredientName(String ingredientName){
        this.ingredientName = ingredientName;
    }
    /**
     * @return the ingredientName
     */
    public String getIngredientName(){
        return ingredientName;
    }


    // ingredient cups
    /**
     * @param ingredientCups This sets the Ingredient’s amount
     */
    public void setIngredientCups(float ingredientCups){
        this.ingredientCups = ingredientCups;
    }
    /**
     * @return ingredientAmount This gets the Ingredient’s amount
     */
    public float getIngredientCups(){
        return ingredientCups;
    }


    // ingredient calories per cups
    /**
     * @param ingredientCaloriesPerCup This sets the Ingredient’s calories per cup
     */
    public void setIngredientCaloriesPerCup(double ingredientCaloriesPerCup){
        this.ingredientCaloriesPerCup = ingredientCaloriesPerCup;
    }
    /**
     * @return ingredientCaloriesPerCup This gets the Ingredient’s calories per cup
     */
    // changed to double from int to stop netbeans from pestering me about lossy conversions
    public double getIngredientCaloriesPerCup(){
        return ingredientCaloriesPerCup;
    }


    // assign the calculation for the total number of calories
    /**
     * @param ingredientTotalCalories This sets the Ingredient’s total calories
     */
    public void setIngredientTotalCalories(double ingredientTotalCalories){
        this.ingredientTotalCalories = ingredientCaloriesPerCup * ingredientCups;
    }
    /**
     * @return ingredientTotalCalories This gets the Ingredient’s total calories
     */
    public double getIngredientTotalCalories(){
        return ingredientTotalCalories;
    }


    // Ingredient Constructor and overload
    public Ingredient(){
        this.ingredientName           = "";
        this.ingredientCups           = 0;
        this.ingredientCaloriesPerCup = 0;
        this.ingredientTotalCalories  = 0;
    }
    public Ingredient(String ingredientName, float ingredientCups, double ingredientCaloriesPerCup, double ingredientTotalCalories){
        this.ingredientName           = ingredientName;
        this.ingredientCups           = ingredientCups;
        this.ingredientCaloriesPerCup = ingredientCaloriesPerCup;
        this.ingredientTotalCalories  = ingredientTotalCalories;
    }


    // create a new ingredient
    //public static void main(String[] args){
    public Ingredient addIngredient() {
        
        Scanner scnr = new Scanner(System.in);

        // ask the user for ingredient name
        System.out.println("What’s the name of the Ingredient you want to add?");
        ingredientName = scnr.nextLine();
        setIngredientName(ingredientName);

        // ask the user for the number of cups
        System.out.println("How many cups of " + ingredientName + " will you need?");
        ingredientCups = scnr.nextFloat();
        setIngredientCups(ingredientCups);

        // ask the user how many calories are in each cup of the ingredient
        System.out.println("How many calories does " + ingredientName + " have in each cup?");
        ingredientCaloriesPerCup = scnr.nextFloat();
        setIngredientCaloriesPerCup(ingredientCaloriesPerCup);

        // caluclate the calories in the ingredient and amount of cups
        setIngredientTotalCalories( getIngredientCups() * getIngredientCaloriesPerCup() );

        // print a message to the user about the calories in the ingredient and the total calories for the summed units of measurement
        System.out.println(ingredientName + " has " + ingredientCaloriesPerCup + " calories per cup. You’re using " + ingredientCups + " cups of " + ingredientName + ", so your use of " + ingredientName + " will include a total of " + ingredientTotalCalories + " calories for the recipe.");

        Ingredient newIngredient = new Ingredient(getIngredientName(), getIngredientCups(), getIngredientCaloriesPerCup(), getIngredientTotalCalories());
        return newIngredient;
    }
}

