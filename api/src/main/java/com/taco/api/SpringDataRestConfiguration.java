package com.taco.api;

import com.taco.domain.Taco;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;

@Configuration
@EnableAutoConfiguration
public class SpringDataRestConfiguration {

    @Bean
    public ResourceProcessor<PagedResources<Resource<Taco>>> tacoProssessor(EntityLinks links){
        return new ResourceProcessor<PagedResources<Resource<Taco>>>() {
            @Override
            public PagedResources<Resource<Taco>> process(PagedResources<Resource<Taco>> resources) {

                resources.add(
                        links.linkFor(Taco.class)
                                .slash("recent")
                                .withRel("recents"));

                return resources;
            }
        };

    }

}
