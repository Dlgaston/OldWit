package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.entity.Exercise;
import com.app.repository.ExerciseRepository;
import com.app.service.ExerciseService;

@Controller
public class ExerciseController {
	@Autowired
	ExerciseService exerciseService;
	@Autowired
	ExerciseRepository exerciseRepository;

	@RequestMapping(value = "/admin/add_exercise", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<Exercise> addExercise(@RequestBody Exercise exercise) {
		try {
			exerciseRepository.save(exercise);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}
}