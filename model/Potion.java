package model;

public class Potion extends AuctionItem {
    private int hpRestore;
    private int manaRestore;

    public Potion(String name, double totalPrice, int totalQuantity, int hpRestore, int manaRestore) {
        super(name, totalPrice, totalQuantity, Category.POTION);
        this.hpRestore = hpRestore;
        this.manaRestore = manaRestore;
    }

    public int getHpRestore() {
        return hpRestore;
    }
    public int getManaRestore() {
        return manaRestore;
    }

    @Override
    public void displayInfo() {
        System.out.println("Nama: " + getName());
        System.out.println("Kategori: Potion");
        System.out.println("Total unit: " + getTotalQuantity());
        System.out.println("Total harga: " + getTotalPrice());
        System.out.println("Harga satuan: " + getUnitPrice());
        System.out.println("HP restore: " + hpRestore);
        System.out.println("Mana restore: " + manaRestore);
    }
}
