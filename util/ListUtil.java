package util;

import java.util.*;

import model.AuctionItem;
import exception.EmptyListException;

public class ListUtil {
    public static <T extends AuctionItem> void sortAndPrint (List<T> items, Comparator<T> comparator, String title) throws EmptyListException {
        if (items.isEmpty()) throw new EmptyListException("Daftar " + title + " masih kosong.");
        
        List<T> sortedItems = new ArrayList<>(items);
        Collections.sort(sortedItems, comparator);

        System.out.println();
        System.out.println(title);
        System.out.println();
        for (int i = 0; i < sortedItems.size(); i++) {
            T item = sortedItems.get(i);
            System.out.println("Barang ke-" + (i + 1));
            item.displayInfo();
        }
    }
}
