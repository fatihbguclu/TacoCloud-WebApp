package com.taco.data;

import com.taco.domain.Taco;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/*
    Extend PagingAndSortingRepository, we get findAll(Pageable pageable) and
    findAll(Sort sort) methods for paging and sorting.
    we can add our own methods that take Pageable and Sort as parameters,
*/

@Repository
public interface TacoRepository extends PagingAndSortingRepository<Taco, Long> {

}
