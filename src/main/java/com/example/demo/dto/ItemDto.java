package com.example.demo.dto;

import com.example.demo.models.Item;
import lombok.Data;

@Data
public class ItemDto {
    Long userId;
    String name;
    String description;

    public static ItemDto ofEntity(Item item){
        ItemDto itemDto = new ItemDto();
        itemDto.setName(item.getName());
        itemDto.setUserId(item.getUserId());
        itemDto.setDescription(item.getDescription());
        return itemDto;
    }
}
