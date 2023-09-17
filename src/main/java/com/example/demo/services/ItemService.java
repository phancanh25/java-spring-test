package com.example.demo.services;

import com.example.demo.dto.ItemDto;
import com.example.demo.models.Item;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class ItemService {
    public Item createItem(ItemDto itemDto) {
        Item item = new Item();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            //read all data from exist file to a list object
            List<Item> myList = objectMapper.readValue(new File("item.json"), new TypeReference<List<Item>>() {});
            // Genereate unique ID from UUID in positive space
            long val = -1;
            do {
                val = UUID.randomUUID().getMostSignificantBits();
            } while (val < 0);
            item.setId(val);
            item.setName(itemDto.getName());
            item.setDescription(itemDto.getDescription());
            item.setUserId(itemDto.getUserId());
            myList.add(item);
            // Suppose the current User always has an ID of 1
            //write it back
            objectMapper.writeValue(new File("item.json"), myList);
        } catch (IOException e) {
            // log something meaningful
            e.getStackTrace();
        }
        return item;
    }

    public List<ItemDto> getItem(Long userId){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            //read all data from exist file to a list object
            List<Item> myList = objectMapper.readValue(new File("item.json"), new TypeReference<List<Item>>() {});
            List<Item> items = myList.stream().filter(item -> item.getUserId().equals(userId)).toList();
            List<ItemDto> itemDtos = items.stream().map(item -> ItemDto.ofEntity(item)).toList();
            if(itemDtos.isEmpty()){
                return null;
            }
            else{
                return itemDtos;
            }
        } catch (IOException e) {
            // log something meaningful
            e.getStackTrace();
        }
        return null;
    }
}
