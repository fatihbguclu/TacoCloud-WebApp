package com.taco.kitchen;

import com.taco.kitchen.Ingredient;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Taco {
    private String name;
    private Date createdAt;

    private List<Ingredient> ingredients;
}
