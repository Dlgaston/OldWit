package com.app.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Exercise;
import com.app.entity.UserAccount;
import com.app.entity.WorkoutPlan;
import com.app.repository.ExerciseRepository;

import com.app.repository.WorkoutPlanRepository;

@Service
public class WorkoutPlanService {

	@Autowired
	ExerciseRepository exerciseRepository;
	@Autowired
	ExerciseService exerciseService;
	@Autowired
	WorkoutPlanRepository workoutPlanRepository;
	
	public void FivebyFive() {
		WorkoutPlan fiveByFive = new WorkoutPlan();
		fiveByFive.setNumberOfWeeks(4);
		fiveByFive.setDays(4);
		fiveByFive.setName("Five by Five");
		fiveByFive.setWorkoutLevel("Beginner");
		fiveByFive.setTypeOfWorkout("Strength");
		fiveByFive.setWorkout(exerciseService.fiveByFiveExercises());
		
		workoutPlanRepository.save(fiveByFive);
	}
	
	
//	public void StartingStrength() {
//		WorkoutPlan plan = new WorkoutPlan();
//		plan.setName("Starting Strength");
//		plan.setTypeOfWorkout("Strength");
//		plan.setWorkoutLevel("Beginner");
//		plan.setDays(3);
//		plan.setNumberOfWeeks(12);
//		plan.setWorkout(exerciseService.startingStrengthExercises());
//		workoutPlanRepository.save(plan);
//		
//
//	}
//	
//	
	public void FiveThreeOne() {
		WorkoutPlan plan = new WorkoutPlan();
		plan.setName("Five Three One ");
		plan.setTypeOfWorkout("Strength");
		plan.setWorkoutLevel("Beginner");
		plan.setDays(4);
		plan.setNumberOfWeeks(4);
		plan.setWorkout(exerciseService.fiveThreeOneExercises());
		workoutPlanRepository.save(plan);

	}
	
	

}
