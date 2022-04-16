package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.app.entity.WorkoutPlan;

public interface WorkoutPlanRepository extends JpaRepository<WorkoutPlan, Long> {
	
	@Query("SELECT S FROM WorkoutPlan S WHERE S.typeOfWorkout = ?1")
	public List<WorkoutPlan> findWorkoutByType(String typeOfWorkout);
	
	@Query("SELECT S FROM WorkoutPlan S WHERE S.workoutLevel = ?1")
	public List<WorkoutPlan> findWorkoutByLevel(String workoutLevel);
	
	@Query("SELECT S FROM WorkoutPlan S WHERE S.days = ?1")
	public List<WorkoutPlan> findWorkoutByDays(Integer days);

}
