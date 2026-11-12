package model;

public class Weapon extends AuctionItem {
    private int attackValue;
    private WeaponType type;

    public Weapon(String name, double totalPrice, int attackValue, WeaponType type) {
        super(name, totalPrice, 1, Category.WEAPON);
        this.attackValue = attackValue;
        this.type = type;
    }

    public int getAttackValue() {
        return attackValue;
    }
    public WeaponType getWeaponType() {
        return type;
    }

    @Override
    public void displayInfo() {
        System.out.println("Nama: " + getName());
        System.out.println("Kategori: Weapon");
        System.out.println("Total unit: " + getTotalQuantity());
        System.out.println("Total harga: " + getTotalPrice());
        System.out.println("Attack value: " + attackValue);
        System.out.println("Type: " + type);
    }
}
