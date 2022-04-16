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
@Table(name = "exercise")
public class Exercise {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "push_pull_legs")
	private String pushPullLegs;
	@Column(name = "area_of_exercise")
	private String areaOfExercise;
	@Column(name = " equipment_of_exercise")
	private String equipmentOfExercise;
	@Column(name = "exercise")
	private String exercise;
	@Column(name = "is_compound")
	private boolean isCompound;
	@Column(name = "name_of_exercise")
	private String nameOfExercise;
	@Transient
	private Double trainingMax;
	@Transient
	private Double weight;

	public Exercise() {

	}

	public Exercise(Long id, String pushPullLegs, String areaOfExercise, String equipmentOfExercise, String exercise,
			boolean isCompound, String nameOfExercise, Double trainingMax, Double weight) {
		super();
		this.id = id;
		this.pushPullLegs = pushPullLegs;
		this.areaOfExercise = areaOfExercise;
		this.equipmentOfExercise = equipmentOfExercise;
		this.exercise = exercise;
		this.isCompound = isCompound;
		this.nameOfExercise = nameOfExercise;
		this.trainingMax = trainingMax;
		this.weight = weight;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPushPullLegs() {
		return pushPullLegs;
	}

	public void setPushPullLegs(String pushPullLegs) {
		this.pushPullLegs = pushPullLegs;
	}

	public String getAreaOfExercise() {
		return areaOfExercise;
	}

	public void setAreaOfExercise(String areaOfExercise) {
		this.areaOfExercise = areaOfExercise;
	}

	public String getEquipmentOfExercise() {
		return equipmentOfExercise;
	}

	public void setEquipmentOfExercise(String equipmentOfExercise) {
		this.equipmentOfExercise = equipmentOfExercise;
	}

	public String getExercise() {
		return exercise;
	}

	public void setExercise(String exercise) {
		this.exercise = exercise;
	}

	public boolean getIsCompound() {
		return isCompound;
	}

	public void setCompound(boolean isCompound) {
		this.isCompound = isCompound;
	}


	public String getNameOfExercise() {
		return nameOfExercise;
	}

	public void setNameOfExercise(String nameOfExercise) {
		this.nameOfExercise = nameOfExercise;
	}

	public Double getTrainingMax() {
		return trainingMax;
	}

	public void setTrainingMax(Double trainingMax) {
		this.trainingMax = trainingMax;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Exercise [id=" + id + ", pushPullLegs=" + pushPullLegs + ", areaOfExercise=" + areaOfExercise
				+ ", equipmentOfExercise=" + equipmentOfExercise + ", exercise=" + exercise + ", isCompound="
				+ isCompound + ", nameOfExercise=" + nameOfExercise + ", trainingMax=" + trainingMax + ", weight="
				+ weight + "]";
	}

}
