package com.example.task5;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InboxControllerTest {

    @Test
    public void getItemsTest() {

        InboxController inboxController = new InboxController();

        assertTrue(inboxController.getItems().isEmpty());
    }

    @Test
    public void postItem() {

        InboxController inboxController = new InboxController();
        long id = 123;
        String status = "completed";
        Item item = new Item(id, status);

        inboxController.postItem(id, item);
        List<Item> items = inboxController.getItems();
        assertEquals(items.size(),1);
        assertEquals(items.get(0), item);
    }

}
