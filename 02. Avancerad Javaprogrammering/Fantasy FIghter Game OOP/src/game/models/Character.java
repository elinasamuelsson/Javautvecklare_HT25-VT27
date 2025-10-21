package game.models;

public abstract class Character {
    protected int HP;
    protected int MP;
    protected int ATK;
    protected int SPD;

    Character(int HP, int MP, int ATK, int SPD) {
        this.HP = HP;
        this.MP = MP;
        this.ATK = ATK;
        this.SPD = SPD;
    }

    protected int getHP() {
        return HP;
    }

    protected int getMP() {
        return MP;
    }

    protected int getATK() {
        return ATK;
    }

    protected int getSPD() {
        return SPD;
    }

    public void makeAttack() {}

    public void makeSpecialAttack() {}
}
