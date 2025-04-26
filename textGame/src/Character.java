import java.util.HashMap;

public class Character {
    int hp;
    int atkDamage;
    int armorRating;
    HashMap<String, String> Armor;
    HashMap<String, String> Weapon;

    public Character(){
        hp = 100;
        Armor = new HashMap<>();
        Weapon = new HashMap<>();


        Armor.put("Head", "Leather");
        Armor.put("Torso", "Leather");
        Armor.put("Legs", "Leather");
        Armor.put("Feet", "Leather");
        Armor.put("Hands", "Leather");
        Armor.put("Shield", "Wooden");
        Weapon.put("Sword", "Iron");

        atkDamage = getAtkDamage();
        armorRating = getArmorRating();
    }

    public int getArmorRating(){

        int total = 0;

        for (String bodyPart : Armor.keySet()){
            String material = Armor.get(bodyPart);

            if (material.equals("Leather")){
                total += 5;
            } else if (material.equals("Iron")) {
                total += 7;
            }else {
                total += 10;
            }
        }
        return total;
    }

    public int getAtkDamage(){

        int total = 0;

        for (String weapon : Weapon.keySet()){
            String material = Weapon.get(weapon);

            if (material.equals("Wood")){
                total += 8;
            } else if (material.equals("Iron"))     {
                total += 11;
            } else if (material.equals("Silver")) {
                total += 14;
            }else {
                total += 19;
            }
        }
        return total;
    }

    public int getHp(){
        return hp;
    }

}
