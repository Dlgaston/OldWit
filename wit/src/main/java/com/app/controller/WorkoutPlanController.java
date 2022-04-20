package com.app.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Exercise;
import com.app.entity.UserAccount;
import com.app.entity.WorkoutPlan;
import com.app.repository.ExerciseRepository;
import com.app.repository.UserAccountRepository;
import com.app.repository.WorkoutPlanRepository;
import com.app.service.ExerciseService;
import com.app.service.WorkoutPlanService;

@RestController
public class WorkoutPlanController {

	@Autowired
	ExerciseRepository exerciseRepository;
	@Autowired
	ExerciseService exerciseService;
	@Autowired
	WorkoutPlanRepository workoutPlanRepository;
	@Autowired
	WorkoutPlanService workoutPlanService;
	@Autowired
	UserAccountRepository userAccountRepository;

	@RequestMapping(value = "/admin/createworkout",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.POST)
	public void createWorkout() {
		workoutPlanService.FiveThreeOne();
	}
	@RequestMapping(value = "/getworkoutplan/{workout_id}",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.GET)
	public ResponseEntity<WorkoutPlan> getWorkoutPlan(@PathVariable ("workout_id") Long id) {
		return new ResponseEntity<> (workoutPlanRepository.findById(id).get(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/showallworkouts",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.GET)
	public ResponseEntity<List<WorkoutPlan>> getAllWorkoutPlans() {
		return new ResponseEntity<> (workoutPlanRepository.findAll(), HttpStatus.OK);
	}
		
	@RequestMapping(value = "/choosefivethreeone",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.POST)
	public  ResponseEntity<UserAccount>addFiveThreeOne(@RequestBody UserAccount account) {
		Optional<WorkoutPlan> getWorkout = workoutPlanRepository.findById(1L);
		if(getWorkout.isPresent()) {
			WorkoutPlan found = getWorkout.get();
			account.setPlan(found);
			account.setWorkoutStartDate(LocalDate.now());
			
			userAccountRepository.save(account);
		}
		return new ResponseEntity<>(account,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/choosefivebyfive",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.POST)
	public  ResponseEntity<UserAccount>addFiveByFive(@RequestBody UserAccount account) {
		Optional<WorkoutPlan> getWorkout = workoutPlanRepository.findById(2L);
		if(getWorkout.isPresent()) {
			WorkoutPlan found = getWorkout.get();
			account.setPlan(found);
			account.setWorkoutStartDate(LocalDate.now());
			
			userAccountRepository.save(account);
		}
		return new ResponseEntity<>(account,HttpStatus.OK);
	}
		
		
	@RequestMapping(value = "/getbeginnerworkouts",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.GET)
	public ResponseEntity<List<WorkoutPlan>> getBeginnerWorkouts() {
		return new ResponseEntity<> (workoutPlanRepository.findWorkoutByLevel("Beginner"), HttpStatus.OK);
	}
}
