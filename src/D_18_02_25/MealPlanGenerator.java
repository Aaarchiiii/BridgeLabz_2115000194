package D_18_02_25;
import java.util.*;
interface MealPlan{
    String getMealType();
    void displayMeal();
}
class VegetarianMeal implements MealPlan{
    @Override
    public String getMealType() {
        return "Vegetarian";
    }
    @Override
    public void displayMeal(){
        System.out.println("Vegetarian Meal: Onion Masala Dosa");
    }
}
class VeganMeal implements MealPlan{
    @Override
    public String getMealType() {
        return "Vegan";
    }
    @Override
    public void displayMeal(){
        System.out.println("Vegan Meal: Egg");
    }
}
class Meal<T extends MealPlan>{
    private T mealPlan;
    public Meal(T mealPlan){
        this.mealPlan = mealPlan;
    }
    public void displayMealPlan(){
        System.out.println("Meal Plan: "+mealPlan.getMealType());
        mealPlan.displayMeal();
    }
}
class MealPlanner{
    public static <T extends MealPlan> void generatePlan(T meal){
        System.out.println("Generate personalized meal plan");
        meal.displayMeal();
    }
}
public class MealPlanGenerator {
    public static void main(String[] args) {
        VegetarianMeal vegetarianMeal = new VegetarianMeal();
        VeganMeal veganMeal = new VeganMeal();
        Meal<VegetarianMeal> vegetarianMealPlan = new Meal<>(vegetarianMeal);
        Meal<VeganMeal> veganMealPlan = new Meal<>(veganMeal);
        vegetarianMealPlan.displayMealPlan();
        veganMealPlan.displayMealPlan();
        System.out.println("Generating..");
        MealPlanner.generatePlan(vegetarianMeal);
        MealPlanner.generatePlan(veganMeal);
    }
}
