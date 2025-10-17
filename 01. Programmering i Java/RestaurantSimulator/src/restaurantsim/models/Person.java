package restaurantsim.models;

public class Person {
    private String name;
    private double wallet = 0;

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWallet() {
        return wallet;
    }

    public void setWalletAdd(double wallet) {
        this.wallet += wallet;
    }

    public void setWalletSub(double wallet) {
        this.wallet -= wallet;
    }
}
