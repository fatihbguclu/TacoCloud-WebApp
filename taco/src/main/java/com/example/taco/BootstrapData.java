package com.example.taco;

import com.taco.data.IngredientRepository;
import com.taco.data.TacoRepository;
import com.taco.data.UserRepository;
import com.taco.domain.Ingredient;
import com.taco.domain.Taco;
import com.taco.domain.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Component
@ComponentScan({"com.taco.data"})
@EnableJpaRepositories({"com.taco.data"})
@EntityScan({"com.taco.domain"})
public class BootstrapData implements CommandLineRunner {

    private final IngredientRepository ingredientRepository;
    private final TacoRepository tacoRepository;
    private final UserRepository userRepository;
    //private final PasswordEncoder encoder;

    public BootstrapData(IngredientRepository ingredientRepository, TacoRepository tacoRepository, UserRepository userRepository) {
        this.ingredientRepository = ingredientRepository;
        this.tacoRepository = tacoRepository;
        this.userRepository = userRepository;
        //this.encoder = encoder;
    }

    @Override
    public void run(String... args) throws Exception {
        ingredientAndTacoData();
        userData();
    }

    private void ingredientAndTacoData(){
        Ingredient flourTortilla = new Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP);
        Ingredient cornTortilla = new Ingredient("COTO", "Corn Tortilla", Ingredient.Type.WRAP);
        Ingredient groundBeef = new Ingredient("GRBF", "Ground Beef", Ingredient.Type.PROTEIN);
        Ingredient carnitas = new Ingredient("CARN", "Carnitas", Ingredient.Type.PROTEIN);
        Ingredient tomatoes = new Ingredient("TMTO", "Diced Tomatoes", Ingredient.Type.VEGGIES);
        Ingredient lettuce = new Ingredient("LETC", "Lettuce", Ingredient.Type.VEGGIES);
        Ingredient cheddar = new Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE);
        Ingredient jack = new Ingredient("JACK", "Monterrey Jack", Ingredient.Type.CHEESE);
        Ingredient salsa = new Ingredient("SLSA", "Salsa", Ingredient.Type.SAUCE);
        Ingredient sourCream = new Ingredient("SRCR", "Sour Cream", Ingredient.Type.SAUCE);
        ingredientRepository.save(flourTortilla);
        ingredientRepository.save(cornTortilla);
        ingredientRepository.save(groundBeef);
        ingredientRepository.save(carnitas);
        ingredientRepository.save(tomatoes);
        ingredientRepository.save(lettuce);
        ingredientRepository.save(cheddar);
        ingredientRepository.save(jack);
        ingredientRepository.save(salsa);
        ingredientRepository.save(sourCream);

        //Tacos
        Taco taco1 = new Taco();
        taco1.setName("Carnivore");
        taco1.setIngredients(Arrays.asList(flourTortilla, groundBeef, carnitas, sourCream, salsa, cheddar));
        tacoRepository.save(taco1);

        Taco taco2 = new Taco();
        taco2.setName("Bovine Bounty");
        taco2.setIngredients(Arrays.asList(cornTortilla, groundBeef, cheddar, jack, sourCream));
        tacoRepository.save(taco2);

        Taco taco3 = new Taco();
        taco3.setName("Veg-Out");
        taco3.setIngredients(Arrays.asList(flourTortilla, cornTortilla, tomatoes, lettuce, salsa));
        tacoRepository.save(taco3);
    }



    private void userData(){
        //Users
        userRepository.save(new User(1L,"Fatih","pass","Fatih Buyukguclu",
                "Any Street","Any City", "AA", "111111","111-111-1111"));


    }




}
