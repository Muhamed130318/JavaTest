import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class World {
        HashMap<String, ArrayList<String>> locations;

        public World(){
            locations = new HashMap<>();

            locations.put("Village", new ArrayList<String>(Arrays.asList("Castle", "Merchant", "Home", "Forest")));
            locations.put("Forest", new ArrayList<String>(Arrays.asList("Village", "Cave", "Trade road", "Farm")));
            locations.put("Cave", new ArrayList<String>(Arrays.asList("Bear")));

        }

        public boolean hasLocation(String name){
            return locations.containsKey(name);
        }

        public ArrayList<String> getBuildings(String name){
            return locations.get(name);
        }
    }

