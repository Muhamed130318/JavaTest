import java.util.Scanner;

public class Battle {

    private Scanner scanner;
    private Enemy enemy;
    private World world;
    private Game game;
    Character main;
    private boolean enteredArea = false;
    public Battle(Game game){
        //bear = new Enemy(5, 20, "Bear");
        scanner = new Scanner(System.in);
        this.game = game;
        main = game.mainCharacter;
        this.world = game.world;
    }

    public void Cave(Enemy enemy){
        System.out.println("There is a " + enemy.name + " in the cave, are you sure you want to enter?");
        System.out.printf("Your current stats are:%n" + "HP " + main.getHp() + "%n" + "Armor rating " + main.getArmorRating() + "%n" + "Weapon damage " + main.getAtkDamage() + "%n");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("Yes")){
            enteredArea = true;
            fight(enemy, "Cave");
        }else {
            System.out.println("You back out of the cave slowly to not awaken the " + enemy.name);
            enteredArea = false;
            //ArrayList<String> currentEnemy = world.getBuildings(game.getLocation());
        }
    }

    public void fight(Enemy enemy, String location){
        System.out.printf("You are now fighting a " + enemy.name + "%n");
        while (true) {
            if (enemy.hp <= 0){
                System.out.println("The " + enemy.name + " has been defeated!");
                enemyDefeated(enemy.name, location);
                break;
            }
            System.out.printf("Would you like to attack or run?%n");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("attack")) {
                attackEnemy(enemy);
            }
        }
    }

    public void attackEnemy(Enemy enemy){
        System.out.println("You attacked the " + enemy.name + " for " + main.getAtkDamage() + " damage.");
        int attack = main.atkDamage;
        enemy.hp -= attack;
        System.out.println(enemy.name + " hp: " + enemy.hp);
    }

    public boolean isEnteredArea() {
        return enteredArea;
    }

    public void enemyDefeated(String name, String location){
        world.removeEntry(location, name);
    }
}
