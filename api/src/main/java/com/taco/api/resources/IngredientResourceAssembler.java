package com.taco.api.resources;

import com.taco.api.IngredientController;
import com.taco.domain.Ingredient;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class IngredientResourceAssembler extends ResourceAssemblerSupport<Ingredient,IngredientResource> {

    public IngredientResourceAssembler() {
        super(IngredientController.class, IngredientResource.class);
    }

    @Override
    public IngredientResource toResource(Ingredient ingredient) {
        return createResourceWithId(ingredient.getId(),ingredient);
    }

    public IngredientResource instantiateResource(Ingredient ingredient){
        return new IngredientResource(ingredient);
    }
}
