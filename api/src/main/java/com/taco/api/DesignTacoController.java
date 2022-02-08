package com.taco.api;

import com.taco.data.TacoRepository;
import com.taco.domain.Taco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.EntityLinks;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/design", produces = "application/json")
@CrossOrigin(origins = "*")
public class DesignTacoController {

    private final TacoRepository tacoRepository;

    @Autowired
    private final EntityLinks entityLinks;

    public DesignTacoController(TacoRepository tacoRepository, EntityLinks entityLinks) {
        this.tacoRepository = tacoRepository;
        this.entityLinks = entityLinks;
    }

    @GetMapping("/recent")
    public Iterable<Taco> recentTacos(){
        PageRequest pageRequest = PageRequest.of(
                0,12, Sort.by("createdAt").descending());

        return tacoRepository.findAll(pageRequest).getContent();
    }

    @GetMapping("/{id}")
    public Taco tacoById(@PathVariable Long id){

        Optional<Taco> optionalTaco = tacoRepository.findById(id);

        return optionalTaco.orElse(null);
    }

    @PostMapping(consumes = "application/json")
    public Taco postTaco(@RequestBody Taco taco){
        return tacoRepository.save(taco);
    }

}






