package model;

import java.util.*;

public class AuctionList <T extends AuctionItem> {
    private List<T> items;

    public AuctionList() {
        items = new ArrayList<>();
    }

    public void addItem(T item) {
        items.add(item);
    }
    public List<T> getItems() {
        return items;
    }
    public boolean isEmpty() {
        return items.isEmpty();
    }
}