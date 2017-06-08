package ru.arkadiy.ubanktest.model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import ru.arkadiy.ubanktest.model.data.Item;

/**
 * Created by arkadiy.zakharov on 08.06.2017.
 */

public class ItemsGenerator {

    /**
     * Генерирует count объектов
     *
     * @param count - количество гинерируемых объектов
     * @return
     */
    public static List<Item> generateItems(int count) {
        final List<Item> results = new LinkedList<>();

        for (int i = 0; i < count; i++) {
            results.add(generateItem(i));
        }

        return results;
    }

    /**
     * Генерирует объект
     * @param index
     * @return
     */
    private static Item generateItem(int index) {
        StringBuilder title = new StringBuilder();
        for (int i = 0; i < index; i++) {
            title.append(i);
            title.append(" ");
        }

        Item item = new Item();
        item.setDate(new Date());
        item.setTitle(title.toString().trim());

        return item;
    }

}
