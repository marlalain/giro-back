package com.pauloelienay.giroback.controller;

import com.pauloelienay.giroback.business.PriorityBusiness;
import com.pauloelienay.giroback.model.Priority;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController @CrossOrigin
@Slf4j
@RequiredArgsConstructor @RequestMapping("/api/v1/priorities")
public class PriorityController {
	private final PriorityBusiness business;

	@GetMapping
	public ResponseEntity<Page<Priority>> findAll
		(@PageableDefault(sort = {"id"}) Pageable pageable) {
		return new ResponseEntity<>(business.findAll(pageable), HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<Priority> findById(@PathVariable Long id) {
		return new ResponseEntity<>(business.findById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Priority> save(@RequestBody Priority priority) {
		return new ResponseEntity<>(business.save(priority), HttpStatus.CREATED);
	}

	@PutMapping("{id}")
	public ResponseEntity<Priority> update(@PathVariable Long id, @RequestBody Priority priority) {
		return new ResponseEntity<>(business.update(id, priority), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		business.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
