package game.models;

abstract class Character {
    protected int HP;
    protected int MP;
    protected int ATK;
    protected int SPEED;

    public void makeAttack() {
        System.out.println("default attack method");
    }

    public void makeSpecialAttack() {
        System.out.println("default special attack method");
    }

    public void takeDamage(int damage) {
        System.out.println("take damage method");
    }
}
