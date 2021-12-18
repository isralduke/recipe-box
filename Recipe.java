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
public class Recipe {
    
    // set variables
    private String                recipeName;
    private int                   recipeServings;
    private ArrayList<Ingredient> recipeIngredients = new ArrayList<>();
    private double                recipeTotalCalories;
    private String                recipeInstructions;
    
    
    
    // creating the methods for recipeName, set and get 
    /**
     * @param recipeName This sets the recipe’s name
     */
    public void setRecipeName(String recipeName){
        this.recipeName = recipeName;
    }
    /**
     * @return recipeName This gets the recipe’s name
     */
    public String getRecipeName(){
        return recipeName;
    }
    
    
    
    // creating the methods for recipeServings, set and get
    /**
     * @param recipeServings This sets the Recipe’s servings amount
     */
    public void setRecipeServings(int recipeServings){
        this.recipeServings = recipeServings;
    }
    /**
     * @return recipeServings This gets the Ingredient’s amount
     */
    public int getRecipeServings(){
        return recipeServings;
    }
    
    
    
    // creating the methods for recipeIngredients, set and get
    /**
     * @param recipeIngredients This puts the Recipe’s ingredients into the Recipe
     */
    public void setRecipeIngredients(ArrayList<Ingredient> recipeIngredients){
        this.recipeIngredients = recipeIngredients;
    }
    /**
     * @return recipeIngredients This gets all of the Recipe’s ingredients
     */
    public ArrayList<Ingredient> getRecipeIngredients(){
        return recipeIngredients;
    }
    
    
    
    // creating the methods for recipeTotalCalories, set and get
    /**
     * @param recipeTotalCalories This sets the Recipe’s total calories from all Ingredients
     */
    public void setRecipeTotalCalories(int recipeTotalCalories){
        this.recipeTotalCalories = recipeTotalCalories;
    }
    /**
     * @return recipeTotalCalories This gets the Recipe’s total calories from all Ingredients
     */
    public double getRecipeTotalCalories(){
        return recipeTotalCalories;
    }
    
    
    
    // writing the instructions for the, set and get 
    /**
     * @param recipeInstructions This sets the recipe’s instructions
     */
    public void setRecipeInstructions(String recipeInstructions){
        this.recipeInstructions = recipeInstructions;
    }
    /**
     * @return recipeInstructions This gets the recipe’s instructions
     */
    public String getRecipeInstructions(){
        return recipeInstructions;
    }
    
    
    
    // this is the constructor, which creates the class
    public Recipe(){
        this.recipeName          = "";
        this.recipeServings      = 0;
        this.recipeIngredients   = new ArrayList<>();
        this.recipeTotalCalories = 0;
        this.recipeInstructions  = "";
    }
    // this is overloading the constructor, not making an instance
    public Recipe(String recipeName, int recipeServings, ArrayList<Ingredient> recipeIngredients, double recipeTotalCalories, String recipeInstructions){
        this.recipeName          = recipeName;
        this.recipeServings      = recipeServings;
        this.recipeIngredients   = recipeIngredients;
        this.recipeTotalCalories = recipeTotalCalories;
        this.recipeInstructions  = recipeInstructions;
    }
    
    
    
    // this adds instructions to the Recipe
    public void recipeInstructions(){
        String recipeInstruction = "";
        System.out.println("Enter instructions for the Recipe. ");
        Scanner scnr = new Scanner(System.in);
        recipeInstruction = scnr.nextLine();
        setRecipeInstructions(recipeInstruction);
        
    }
    
    
    
    // this will print the recipe when it’s time
    public void recipePrinter() {
        
        double recipeServingCalories = recipeTotalCalories / recipeServings;
        
        System.out.println("");
        System.out.println("Recipe Name: " + recipeName);
        System.out.println("Recipe Servings: " + recipeServings);
        System.out.println("Recipe Calories: " + recipeTotalCalories);
        System.out.println("Recipe Ingredients: ");
        // using a for loop to list the ingredients
        for (int i = 0; i < recipeIngredients.size(); i++) {  
            recipeIngredients.get(i);
            System.out.println((i+1) + ". " + recipeIngredients.get(i).getIngredientName() + ": " + recipeIngredients.get(i).getIngredientTotalCalories() + " calories.");
        }
        System.out.println("Instructions: " + recipeInstructions);
    }
    
    
    
    // create a new recipe
    public Recipe addRecipe() {
        
        boolean recipeAddMoreIngredients = true;
        Scanner scnr                     = new Scanner(System.in);
        Ingredient newIngredient         = new Ingredient();
        
        // ask the user for recipe name
        System.out.println("What’s the name of the Recipe you want to add?");
        recipeName = scnr.nextLine();
        setRecipeName(recipeName);
        
        // ask the user for recipe’s servings
        System.out.println("How many servings are in " + recipeName + "?");
        recipeServings = scnr.nextInt();
        setRecipeServings(recipeServings);
        
        // ask the user to enter ingredients
        System.out.println("Enter an Ingredient for " + recipeName + ". ");
        do {
            recipeIngredients.add(newIngredient.addIngredient());
            System.out.println("Do you want to enter another Ingredient for " + recipeName + "?");
            System.out.println("Enter 'y' for Yes and 'n' for no.");
            String response;
            response = scnr.next();
            if( response.equalsIgnoreCase("n") ){
                recipeAddMoreIngredients = false;
            }
        }
        while(recipeAddMoreIngredients);
        
        // get the total calories from each ingredient and add those together
        for ( int k = 0; k < recipeIngredients.size(); k++ ){
            Ingredient kCurrentIngredient          = recipeIngredients.get(k);
            double     kCurrentIngredientCalories  = kCurrentIngredient.getIngredientTotalCalories();
            recipeTotalCalories                   += kCurrentIngredientCalories;
        }
        // print a message to the user about the total calories in the recipe        
        System.out.println(recipeName + " has " + recipeTotalCalories + " total calories, from all of the Ingredients.");
        
        
        // ask the user for instructions
        recipeInstructions();
        
        
        // Make a new recipe   
        Recipe newRecipe = new Recipe(getRecipeName(), getRecipeServings(), getRecipeIngredients(), 
                getRecipeTotalCalories(), getRecipeInstructions() );
        return newRecipe;
    }
}
