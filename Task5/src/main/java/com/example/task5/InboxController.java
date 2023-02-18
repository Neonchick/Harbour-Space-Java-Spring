package com.example.task5;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/inbox")
@RestController
public class InboxController {

    private List<Item> items = new ArrayList<>();

    @GetMapping("/items")
    public Object getItems() {
        return items;
    }

    @PostMapping("/items/{id}")
    public String postItem(@PathVariable("id") Long id, @RequestBody Item item) {
        items.add(item);
        return "OK";
    }

}
