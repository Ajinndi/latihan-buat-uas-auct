package model;

public class Armor extends AuctionItem {
    private int defenseValue;
    private ArmorType type;

    public Armor(String name, double totalPrice, int defenseValue, ArmorType type) {
        super(name, totalPrice, 1, Category.ARMOR);
        this.defenseValue = defenseValue;
        this.type = type;
    }

    public int getDefenseValue() {
        return defenseValue;
    }
    public ArmorType getType() {
        return type;
    }

    @Override
    public void displayInfo() {
        System.out.println("Nama: " + getName());
        System.out.println("Kategori: Armor");
        System.out.println("Total unit: " + getTotalQuantity());
        System.out.println("Total harga: " + getTotalPrice());
        System.out.println("Defense value: " + defenseValue);
        System.out.println("Type: " + type);
        System.out.println();
    }
}
