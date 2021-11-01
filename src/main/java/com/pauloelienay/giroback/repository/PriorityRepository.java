package com.pauloelienay.giroback.repository;

import com.pauloelienay.giroback.model.Priority;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriorityRepository extends PagingAndSortingRepository<Priority, Long> {}
