package com.pauloelienay.giroback.business;

import com.pauloelienay.giroback.exception.EntityNotFoundException;
import com.pauloelienay.giroback.model.Priority;
import com.pauloelienay.giroback.repository.PriorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PriorityBusiness {
	@Autowired
	private PriorityRepository repository;

	public Page<Priority> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public Priority findById(Long id) {
		return repository.findById(id)
			.orElseThrow(() -> new EntityNotFoundException("Priority not found."));
	}

	public void deleteById(Long id) {
		findById(id);
		repository.deleteById(id);
	}

	public Priority save(Priority priority) {
		return repository.save(priority);
	}

	public Priority update(Long id, Priority priority) {
		findById(id);
		priority.setId(id);
		return repository.save(priority);
	}
}
