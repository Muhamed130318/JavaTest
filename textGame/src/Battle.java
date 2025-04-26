import java.util.Scanner;

public class Battle {

    private Scanner scanner;
    private Enemy enemy;
    private World world;
    private Game game;
    private boolean enteredArea = false;
    public Battle(Game game){
        //bear = new Enemy(5, 20, "Bear");
        scanner = new Scanner(System.in);
        world = new World();
        this.game = game;
    }

    public void Cave(Enemy enemy){
        System.out.println("There is a " + enemy.name + " in the cave, are you sure you want to enter?");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("Yes")){
            enteredArea = true;
            fight(enemy);
        }else {
            System.out.println("You back out of the cave slowly to not awaken the " + enemy.name);
            enteredArea = false;
            //ArrayList<String> currentEnemy = world.getBuildings(game.getLocation());
        }
    }

    public void fight(Enemy enemy){
        System.out.println("You are now fighting a " + enemy.name);
    }

    public boolean isEnteredArea() {
        return enteredArea;
    }
}
