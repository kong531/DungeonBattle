//Owner: Kong Lee
//File for the player stats

package Assets;

public class Player {
    // Stats for player character
    public int health;
    public int damage;
    public String weapon;
    public String playerClass;

    // Base value for player
    public Player() {
        health = 100;
        damage = 50;
        weapon = "Long Sword";
        playerClass = "Warrior";
    }

    // Sets the player's character stats
    public Player(int health, int damage, String weapon, String playerClass) {
        this.health = health;
        this.damage = damage;
        this.weapon = weapon;
        this.playerClass = playerClass;
    }

    // Getter and setter for health
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    // Getter and setter for attack damage
    public int getDamage() {
        return damage;
    }

    public void setDamage(int attackDmg) {
        this.damage = attackDmg;
    }

    // Getter and setter for weapon
    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    // Getter and setter for player class
    public String getPlayerClass() {
        return playerClass;
    }

    public void setPlayerClass(String playerClass) {
        this.playerClass = playerClass;
    }

    @Override
    public String toString() {

        // Outputs player info to the Gui
        String playerInfo = "[Player's Status]"
                + "\n------------------------------\n"
                + "\nHealth points: " + this.health
                + "\nWeapon type: " + this.weapon
                + "\nAttack power: " + this.damage
                + "\nClass: " + this.playerClass;

        return playerInfo;
    }
}
