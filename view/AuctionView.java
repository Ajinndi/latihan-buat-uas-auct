package view;

import controller.AuctionController;
import model.Armor;
import model.ArmorType;
import model.AuctionItem;
import model.AuctionList;
import model.Category;
import model.Potion;
import model.Weapon;
import model.WeaponType;
import util.CLIUtil;
import exception.EmptyInputException;
import exception.EmptyListException;
import exception.InvalidNumberException;

public class AuctionView {
    private AuctionController controller;

    public AuctionView() {
        controller = new AuctionController();
    }

    private String inputString(String message) {
        while (true) {
            try {
                return CLIUtil.readString(message);
            } catch (EmptyInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int inputInt(String message) {
        while (true) {
            try {
                return CLIUtil.readInt(message);
            } catch (EmptyInputException | InvalidNumberException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private double inputDouble(String message) {
        while (true) {
            try {
                return CLIUtil.readDouble(message);
            } catch (EmptyInputException | InvalidNumberException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int inputPositiveInt(String message) {
        while (true) {
            int value = inputInt(message);
            if (value > 0) return value;
            System.out.println("Angka harus lebih dri 0.");
        }
    }

    private int inputNonNegativeInt(String message) {
        while (true) {
            int value = inputInt(message);
            if (value >= 0) return value;
            System.out.println("Angka tidak blh negatif.");
        }
    }

    private double inputPositiveDouble (String message) {
        while (true) {
            double value = inputDouble(message);
            if (Double.isFinite(value) && value > 0) return value;
            System.out.println("Harga harus lebih dri 0.");
        }
    }

    public void showMenu() {
        int choice;
        do {
            System.out.println();
            System.out.println("Game auction system:");
            System.out.println();
            System.out.println("1. Tambah barang lelang");
            System.out.println("2. Tampilkan berdasarkan total harga");
            System.out.println("3. Tampilkan berdasarkan harga satuan");
            System.out.println("0. Keluar");
            System.out.println();
            choice = inputInt("Pilih menu: ");

            switch (choice) {
                case 1:
                    addItemMenu();
                    break;
                case 2:
                    controller.sortByTotalPrice();
                    break;
                case 3:
                    controller.sortByUnitPrice();
                    break;
                case 0:
                    System.out.println("Selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak ada.");
                    break;
            }
        } while ( choice != 0);
    }

    public void addItemMenu() {
        System.out.println();
        System.out.println("Tambah barang lelang:");
        System.out.println("1. Potion");
        System.out.println("2. Weapon");
        System.out.println("3. Armor");

        int category = inputInt("Pilih kategori: ");

        switch (category) {
            case 1:
                addPotion();
                break;
            case 2:
                addWeapon();
                break;
            case 3:
                addArmor();
                break;
            default:
                System.out.println("Kategori tidak ada.");
                break;
        }
    }

    private void addPotion() {
        System.out.println();
        System.out.println("Tambah potion:");
        String name = inputString("Nama potion: ");
        int quantity = inputPositiveInt("Jumlah unit: ");
        double totalPrice = inputPositiveDouble("Total harga: ");
        int hpRestore = inputNonNegativeInt("HP restore value: ");
        int manaRestore = inputNonNegativeInt("Mana restore value: ");

        Potion potion = new Potion(name, totalPrice, quantity, hpRestore, manaRestore);

        controller.addPotion(potion);
        System.out.println("Potion berhasil ditambahkan.");
    }

    private void addWeapon() {
        System.out.println();
        System.out.println("Tambah weapon:");
        System.out.println();
        String name = inputString("Nama weapon: ");
        double totalPrice = inputPositiveDouble("Harga weapon: ");
        int attackValue = inputNonNegativeInt("Attack value: ");

        System.out.println("Tipe weapon:");
        System.out.println("1. Sword");
        System.out.println("2. Axe");
        System.out.println("3. Spear");
        System.out.println("4. Bow");

        int choice = inputInt("Pilih tipe: ");
        WeaponType type;

        switch (choice) {
            case 1:
                type = WeaponType.SWORD;
                break;
            case 2:
                type = WeaponType.AXE;
                break;
            case 3:
                type = WeaponType.SPEAR;
                break;
            case 4:
                type = WeaponType.BOW;
                break;
            default:
                System.out.println("Tipe tidak ada.");
                return;
        }

        Weapon weapon = new Weapon(name, totalPrice, attackValue, type);

        controller.addWeapon(weapon);
        System.out.println("Weapon berhasil ditambahkan.");
    }

    private void addArmor() {
        System.out.println();
        System.out.println("Tambah armor:");
        System.out.println();
        String name = inputString("Nama armor: ");
        double totalPrice = inputPositiveDouble("Harga armor: ");
        int defenseValue = inputNonNegativeInt("Defense value: ");

        System.out.println("Tipe armor:");
        System.out.println("1. Heavy");
        System.out.println("2. Medium");
        System.out.println("3. Light");

        int choice = inputInt("Pilih tipe: ");
        ArmorType type;

        switch (choice) {
            case 1:
                type = ArmorType.HEAVY;
                break;
            case 2:
                type = ArmorType.MEDIUM;
                break;
            case 3:
                type = ArmorType.LIGHT;
                break;
            default:
                System.out.println("Tipe tidak ada.");
                return;
        }

        Armor armor = new Armor(name, totalPrice, defenseValue, type);

        controller.addArmor(armor);
        System.out.println("Armor berhasil ditambahkan.");
    }
}
