package com.example.demo.controllers;

import com.example.demo.dto.ItemDto;
import com.example.demo.models.Item;
import com.example.demo.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("item")
public class ItemController {
    @Autowired
    ItemService itemService;
    @PostMapping
    public Item createItem(@RequestBody ItemDto itemDto){
        return itemService.createItem(itemDto);
    }

    @GetMapping("/get-item/{id}")
    public List<ItemDto> getItem(@PathVariable Long id){
        return itemService.getItem(id);
    }
}
