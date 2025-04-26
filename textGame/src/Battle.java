import java.util.Scanner;

public class Battle {

    private Scanner scanner;
    private Enemy enemy;
    private World world;
    private Game game;
    Character main = game.mainCharacter;
    private boolean enteredArea = false;
    public Battle(Game game){
        //bear = new Enemy(5, 20, "Bear");
        scanner = new Scanner(System.in);
        world = new World();
        this.game = game;
    }

    public void Cave(Enemy enemy){
        System.out.println("There is a " + enemy.name + " in the cave, are you sure you want to enter?");
        System.out.printf("Your current stats are:%n" + "HP " + main.getHp() + "%n" + "Armor rating " + main.getArmorRating() + "%n" + "Weapon damage " + main.getAtkDamage() + "%n");
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
        System.out.printf("You are now fighting a " + enemy.name + "%n");
        System.out.printf("Would you like to attack or run?%n");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("attack")){
            attackEnemy();
        }
    }

    public void attackEnemy(){
        int attack = main.atkDamage;
        enemy.hp -= attack;
    }

    public boolean isEnteredArea() {

        return enteredArea;
    }
}
