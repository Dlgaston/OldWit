package com.app.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToMany;


import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "workout_plan")
public class WorkoutPlan {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Exercise> workout;
	@Transient
	private Integer repetitions;
	@Transient
	private Integer exerciseSets;
	@Column(name = "number_of_weeks")
	private Integer numberOfWeeks;
	@Column(name = "name")
	private String name;
	@Column(name = "workout_level")
	private String workoutLevel;
	@Column(name = "days")
	private Integer days;
	@Column(name = "type_of_workout")
	private String typeOfWorkout;
	
	public WorkoutPlan() {

	}
	
	

	public WorkoutPlan(Long id, List<Exercise> workout, Integer repetitions, Integer exerciseSets,
			Integer numberOfWeeks, String name, String workoutLevel, Integer days, String typeOfWorkout) {
		super();
		this.id = id;
		this.workout = workout;
		this.repetitions = repetitions;
		this.exerciseSets = exerciseSets;
		this.numberOfWeeks = numberOfWeeks;
		this.name = name;
		this.workoutLevel = workoutLevel;
		this.days = days;
		this.typeOfWorkout = typeOfWorkout;
	}



	public String getWorkoutLevel() {
		return workoutLevel;
	}

	public void setWorkoutLevel(String workoutLevel) {
		this.workoutLevel = workoutLevel;
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Exercise> getWorkout() {
		return workout;
	}

	public void setWorkout(List<Exercise> workout) {
		this.workout = workout;
	}

	public Integer getRepetitions() {
		return repetitions;
	}

	public void setRepetitions(Integer repetitions) {
		this.repetitions = repetitions;
	}

	public Integer getExerciseSets() {
		return exerciseSets;
	}

	public void setExerciseSets(Integer exerciseSets) {
		this.exerciseSets = exerciseSets;
	}

	public Integer getNumberOfWeeks() {
		return numberOfWeeks;
	}

	public void setNumberOfWeeks(Integer numberOfWeeks) {
		this.numberOfWeeks = numberOfWeeks;
	}

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

	public String getTypeOfWorkout() {
		return typeOfWorkout;
	}

	public void setTypeOfWorkout(String typeOfWorkout) {
		this.typeOfWorkout = typeOfWorkout;
	}

	@Override
	public String toString() {
		return "WorkoutPlan [id=" + id + ", workout=" + workout + ", repetitions=" + repetitions + ", exerciseSets="
				+ exerciseSets + ", numberOfWeeks=" + numberOfWeeks + ", name=" + name + ", workoutLevel="
				+ workoutLevel + ", days=" + days + "]";
	}

}
