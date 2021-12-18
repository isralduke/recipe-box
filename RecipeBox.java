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
public class RecipeBox {
    
    // set variables
    private ArrayList<Recipe> recipeList;
    
    
    // recipe list, set and get
    /**
     * @param recipeList This sets the list of Recipes
     */
    public void setRecipeList(ArrayList<Recipe> recipeList) {
        this.recipeList = recipeList;
    }
    /**
     * @return recipeList This gets the list of Recipes
     */
    public ArrayList<Recipe> getRecipeList() {
        return recipeList;
    }
    
    
    // RecipeBox Constructor and overload
    public RecipeBox() {
        this.recipeList = new ArrayList();
    }
    public RecipeBox(ArrayList<Recipe> recipeList){
        this.recipeList = recipeList;
    }
    
    
    // RecipeBox print all recipe names
    public void recipeNamesPrintAll(){
        System.out.println("");
        System.out.println("Here’s the names of all the Recipes you have created.");
        if ( recipeList.size() == 0 ){
            System.out.println("No Recipes. You should add one now.");
        }
        else {
            for( int i = 0; i < recipeList.size(); i++ ) {
                System.out.println((i + 1) + ". " + recipeList.get(i).getRecipeName());
            }
        }
        System.out.println("");
    }
    
    
    // RecipeBox print the recipe details
    public void recipePrintAllDetails(String recipeSelection) {
        for( int i = 0; i < recipeList.size(); i++ ){
            if( recipeList.get(i).getRecipeName().equals(recipeSelection)){
                recipeList.get(i).recipePrinter();
            }
        }
        System.out.println("");
    }
    
    
    // add a new Recipe
    public void recipeAdder(){
        recipeList.add(new Recipe().addRecipe());
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        RecipeBox recipeVault      = new RecipeBox();
        boolean recipeVaultRunning = true;
        Scanner menuScanner        = new Scanner(System.in);

        
        while( recipeVaultRunning ){
            
            System.out.println("");
            System.out.println("What do you want to do? Enter its number.");
            System.out.println("1. Add a Recipe");
            System.out.println("2. Print all Recipe names");
            System.out.println("3. Print a specific Recipe");
            System.out.println("4. Delete a specific Recipe");
            
            int menuScannerInput = menuScanner.nextInt();
            
            if ( menuScannerInput == 1){
                recipeVault.recipeAdder();
            }
            else if ( menuScannerInput == 2){
                recipeVault.recipeNamesPrintAll();
            }
            else if ( menuScannerInput == 3){
                recipeVault.recipeNamesPrintAll();
                System.out.println("Which Recipe do you want to print? Enter the Recipe’s name.");
                String recipeSelection = menuScanner.next();
                recipeVault.recipePrintAllDetails(recipeSelection);
            }
            else if ( menuScannerInput == 4 ){
                recipeVault.recipeNamesPrintAll();
                System.out.println("Which Recipe do you want to delete? Enter the Recipe’s number.");
                int recipeSelection = menuScanner.nextInt();
                recipeSelection = recipeSelection - 1;
                recipeVault.recipeList.remove(recipeSelection);
            }
            else {
                System.out.println("");
                System.out.println("What do you want to do? Enter its number.");
                System.out.println("1. Add a Recipe");
                System.out.println("2. Print all Recipe names");
                System.out.println("3. Print a specific Recipe");
                System.out.println("4. Delete a specific Recipe");
            }   
        }   
    }
}
