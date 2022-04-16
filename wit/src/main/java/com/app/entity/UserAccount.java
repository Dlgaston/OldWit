package com.app.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "user_account")
public class UserAccount {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "first_name")
	private String first_Name;
	@Column(name = "last_name")
	private String last_Name;
	@Column(name = "age")
	private Integer age;
	@Column(name = "weight")
	private Double weight;
	@Column(name = "height")
	private Double height;
	@Column(name = "picture")
	private String picture;
	@Column(name = "username")
	private String username;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	@Column(name = "workout_start_date")
	private LocalDate workoutStartDate;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "workout_plan_id")
	private WorkoutPlan plan;

	public UserAccount() {

	}

	public UserAccount(Long id, String first_Name, String last_Name, Integer age, Double weight, Double height,
			String picture, String username, String email, String password, LocalDate workoutStartDate,
			WorkoutPlan plan) {
		super();
		this.id = id;
		this.first_Name = first_Name;
		this.last_Name = last_Name;
		this.age = age;
		this.weight = weight;
		this.height = height;
		this.picture = picture;
		this.username = username;
		this.email = email;
		this.password = password;
		this.workoutStartDate = workoutStartDate;
		this.plan = plan;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public String getFirst_Name() {
		return first_Name;
	}

	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}

	public String getLast_Name() {
		return last_Name;
	}

	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

	public WorkoutPlan getPlan() {
		return plan;
	}

	public void setPlan(WorkoutPlan plan) {
		this.plan = plan;
	}
	
	

	public LocalDate getWorkoutStartDate() {
		return workoutStartDate;
	}

	public void setWorkoutStartDate(LocalDate workoutStartDate) {
		this.workoutStartDate = workoutStartDate;
	}

	@Override
	public String toString() {
		return "UserAccount [first_Name=" + first_Name + ", last_Name=" + last_Name + ", age=" + age + ", weight="
				+ weight + ", height=" + height + ", username=" + username + ", email=" + email + "]";
	}

}
