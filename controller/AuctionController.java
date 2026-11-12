package controller;

import java.util.*;

import model.Armor;
import model.ArmorType;
import model.AuctionItem;
import model.AuctionList;
import model.Category;
import model.Potion;
import model.Weapon;
import model.WeaponType;
import util.ListUtil;
import exception.EmptyListException;

public class AuctionController {
    private AuctionList<Potion> potions;
    private AuctionList<Weapon> weapons;
    private AuctionList<Armor> armors;

    public AuctionController() {
        potions = new AuctionList<>();
        weapons = new AuctionList<>();
        armors = new AuctionList<>();
    }

    public void addPotion(Potion potion) {
        potions.addItem(potion);
    }
    public void addWeapon(Weapon weapon) {
        weapons.addItem(weapon);
    }
    public void addArmor(Armor armor) {
        armors.addItem(armor);
    }

    public void sortByTotalPrice() {
        System.out.println();
        System.out.println("Sorting berdasarkan total harga:");
        System.out.println();

        try {
            ListUtil.sortAndPrint(potions.getItems(), new Comparator<Potion>() {
                @Override
                public int compare(Potion p1, Potion p2) {
                    return Double.compare(p1.getTotalPrice(), p2.getTotalPrice());
                }
            }, "POTION");
        } catch (EmptyListException e) {
            System.out.println(e.getMessage());
        }

        try {
            ListUtil.sortAndPrint(weapons.getItems(), new Comparator<Weapon>() {
                @Override
                public int compare(Weapon w1, Weapon w2) {
                    return Double.compare(w1.getTotalPrice(), w2.getTotalPrice());
                }
            }, "WEAPON");
        } catch (EmptyListException e) {
            System.out.println(e.getMessage());
        }

        try {
            ListUtil.sortAndPrint(armors.getItems(), new Comparator<Armor>() {
                @Override
                public int compare(Armor a1, Armor a2) {
                    return Double.compare(a1.getTotalPrice(), a2.getTotalPrice());
                }
            }, "ARMOR");
        } catch (EmptyListException e) {
            System.out.println(e.getMessage());
        }
    }

    public void sortByUnitPrice() {
        System.out.println();
        System.out.println("Sorting berdasarkan harga satuan:");
        System.out.println();

        try {
            ListUtil.sortAndPrint(potions.getItems(), new Comparator<Potion>() {
                @Override
                public int compare(Potion p1, Potion p2) {
                    return Double.compare(p1.getUnitPrice(), p2.getUnitPrice());
                }
            }, "POTION");
        } catch (EmptyListException e) {
            System.out.println(e.getMessage());
        }

        try {
            ListUtil.sortAndPrint(weapons.getItems(), new Comparator<Weapon>() {
                @Override
                public int compare(Weapon w1, Weapon w2) {
                    return Double.compare(w1.getUnitPrice(), w2.getUnitPrice());
                }
            }, "WEAPON");
        } catch (EmptyListException e) {
            System.out.println(e.getMessage());
        }

        try {
            ListUtil.sortAndPrint(armors.getItems(), new Comparator<Armor>() {
                @Override
                public int compare(Armor a1, Armor a2) {
                    return Double.compare(a1.getUnitPrice(), a2.getUnitPrice());
                }
            }, "ARMOR");
        } catch (EmptyListException e) {
            System.out.println(e.getMessage());
        }
    }
}
