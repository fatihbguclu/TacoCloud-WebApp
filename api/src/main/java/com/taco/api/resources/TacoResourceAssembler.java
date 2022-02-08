package com.taco.api.resources;

import com.taco.api.DesignTacoController;
import com.taco.domain.Taco;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class TacoResourceAssembler extends ResourceAssemblerSupport<Taco, TacoResource> {

    public TacoResourceAssembler() {
        super(DesignTacoController.class, TacoResource.class);
    }

    @Override
    public TacoResource toResource(Taco taco) {
        return createResourceWithId(taco.getId(),taco);
    }

    @Override
    public TacoResource instantiateResource(Taco taco){
        return new TacoResource(taco);
    }
}
