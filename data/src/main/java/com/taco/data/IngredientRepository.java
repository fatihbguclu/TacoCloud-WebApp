package com.taco.data;

import com.taco.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

// @CrossOrigin annotation on a repository interface
// enables CORS access to all operations on the repository resource.
// server will automatically insert the header Access Control Allow Origin
// into the response with the value of *.
@CrossOrigin(origins = "*")
@Repository
public interface IngredientRepository extends CrudRepository<Ingredient,String> {

}
