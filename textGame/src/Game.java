import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private World world;
    private Scanner scanner;
    private String currentLocation;
    Enemy bear = new Enemy(5, 20, "Bear");
    private Battle battle;
    Character mainCharacter;


    public Game(){
        world = new World();
        scanner = new Scanner(System.in);
        currentLocation = "Village";
        battle = new Battle(this);
        mainCharacter = new Character();
    }


    private String input;

    public void start(){

        System.out.printf("You are currently in: " + currentLocation + "%n");

        while(true){
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")){
                System.out.println("Thank you for playing.");
                break;
            }else if (input.startsWith("go ")) {
                String newLocation;
                newLocation = input.substring(3);
                if (world.hasLocation(newLocation)){
                    if (newLocation.equalsIgnoreCase("Cave")){
                        battle.Cave(bear);
                        if (battle.isEnteredArea()){
                            currentLocation = newLocation;
                        }else {
                            System.out.println("You stay at " + currentLocation);
                        }
                    }
                    continue;
                }else {
                    System.out.println(newLocation + " does not exist.");
                }
            } else if (input.equalsIgnoreCase("Buildings")) {
                ArrayList<String> buildings = world.getBuildings(currentLocation);
                System.out.println("Buildings in " + currentLocation + ": " + String.join(", ", buildings));
            }else {
                System.out.printf("Command not recognized%nCommands you can use:%ngo (location): to change locations.%nBuildings: to list buildings in your current location.%n");
            }


        }

    }

    public String getLocation(){
        return currentLocation;
    }



}
