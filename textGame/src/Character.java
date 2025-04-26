import java.util.HashMap;

public class Character {
    int hp;
    HashMap<String, String> Armor;

    public Character(int hp){
        hp = 100;
        Armor = new HashMap<>();

        Armor.put("Head", "Leather helmet");
        Armor.put("Torso", "Leather jack");
        Armor.put("Legs", "Leather leggings");
        Armor.put("Feet", "Leather shoes");
        Armor.put("Hands", "Leather gloves");
        Armor.put("Shield", "Wooden shield");
    }


}
