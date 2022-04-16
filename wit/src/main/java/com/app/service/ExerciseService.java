package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Exercise;
import com.app.repository.ExerciseRepository;
import com.app.repository.WorkoutPlanRepository;

@Service
public class ExerciseService {

	@Autowired
	ExerciseRepository exerciseRepository;
	@Autowired
	WorkoutPlanRepository workoutPlanRepository;

	public Exercise barbellBench() {
		Exercise barbellBench = new Exercise();
		barbellBench.setPushPullLegs("Push");
		barbellBench.setEquipmentOfExercise("Barbell");
		barbellBench.setCompound(true);
		barbellBench.setNameOfExercise("Barbell BenchPress");
		barbellBench.setAreaOfExercise("Chest");
		return barbellBench;
	}

	public Exercise barbellSquat() {
		Exercise barbellSquat = new Exercise();
		barbellSquat.setPushPullLegs("Legs");
		barbellSquat.setEquipmentOfExercise("Barbell");
		barbellSquat.setCompound(true);
		barbellSquat.setNameOfExercise("Barbell Squat");
		barbellSquat.setAreaOfExercise("Legs");
		return barbellSquat;
	}

	public Exercise deadlift() {
		Exercise deadlift = new Exercise();
		deadlift.setPushPullLegs("Legs");
		deadlift.setEquipmentOfExercise("Barbell");
		deadlift.setCompound(true);
		deadlift.setNameOfExercise("deadlift");
		deadlift.setAreaOfExercise("Legs");
		
		return deadlift;
	}

	public Exercise barbelloverHeadPress() {
		Exercise barbelloverHeadPress =  new Exercise();
		barbelloverHeadPress.setPushPullLegs("Push");
		barbelloverHeadPress.setEquipmentOfExercise("Barbell");
		barbelloverHeadPress.setCompound(true);
		barbelloverHeadPress.setNameOfExercise("Barbell OverHead Press");
		barbelloverHeadPress.setAreaOfExercise("Shoulders");
		
		return barbelloverHeadPress;
	}

	public Exercise powerClean() {
		Exercise powerClean  = new Exercise(); 
		powerClean.setPushPullLegs("Pull");
		powerClean.setEquipmentOfExercise("Barbell");
		powerClean.setCompound(true);
		powerClean.setNameOfExercise("powerClean");
		powerClean.setAreaOfExercise("Core");
		
		return powerClean;
	}
	
	public List<Exercise> fiveByFiveExercises() {
		Exercise barbellBench = barbellBench();
		
		Exercise barbellSquat = barbellSquat();
		
		Exercise deadlift = deadlift();
		
		Exercise barbelloverHeadPress =barbelloverHeadPress();
		
		List<Exercise> list = new ArrayList<Exercise>();

		list.add(barbellBench);
		list.add(barbellSquat);
		list.add(deadlift);
		list.add(barbelloverHeadPress);
		
		return list;
		
	}
	
	public List<Exercise> startingStrengthExercises() {
		Exercise barbellBench = barbellBench();
		
		Exercise barbellSquat = barbellSquat();
		
		Exercise deadlift = deadlift();
		
		Exercise barbelloverHeadPress =barbelloverHeadPress();
		
		Exercise powerClean = powerClean();
		
		List<Exercise> list = new ArrayList<Exercise>();

		list.add(barbellBench);
		list.add(barbellSquat);
		list.add(deadlift);
		list.add(barbelloverHeadPress);
		list.add(powerClean);
		return list;
	
}
	public List<Exercise> fiveThreeOneExercises() {
		Exercise barbellBench = barbellBench();
		
		Exercise barbellSquat = barbellSquat();
		
		Exercise deadlift = deadlift();
		
		Exercise barbelloverHeadPress =barbelloverHeadPress();
		
		List<Exercise> list = new ArrayList<Exercise>();

		list.add(barbellBench);
		list.add(barbellSquat);
		list.add(deadlift);
		list.add(barbelloverHeadPress);
		
		return list;
		
	}
	
}
