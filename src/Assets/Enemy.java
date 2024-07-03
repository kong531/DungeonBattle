//Owner: Kong Lee
//File for enemy stats

package Assets;

public class Enemy {

    public int health;
    public int damage;
    public String weapon;
    public String enemyClass;

    public Enemy() {
        health = 200;
        weapon = "Club";
        damage = 10;
        enemyClass = "Ogre";
    }

    public Enemy(int health, int damage, String weapon, String enemyClass) {
        this.health = health;
        this.damage = damage;
        this.weapon = weapon;
        this.enemyClass = enemyClass;
    }

    // Getter and setter for health
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    // Getter and setter for damage
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    // Getter and setter for weapon
    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    // Getter and setter for enemy class
    public String getEnenmyClass() {
        return enemyClass;
    }

    public void setEnemyClass(String enemyClass) {
        this.enemyClass = enemyClass;
    }

    @Override
    public String toString() {

        // Outputs player info to the Gui
        String enemyInfo = "[Enemy's Status]"
                + "\n------------------------------\n"
                + "\nHealth points: " + this.health
                + "\nWeapon type: " + this.weapon
                + "\nAttack power: " + this.damage
                + "\nClass: " + this.enemyClass;

        return enemyInfo;
    }
}
