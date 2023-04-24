package com.aurionpro.model;

public class BasketballCoach implements ICoach {

	private String name;
	private String email;
	private IDiet diet;

	public BasketballCoach() {
		System.out.println("done for today");
	}

	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public IDiet getDiet() {

		return diet;

	}

	public void setDiet(IDiet diet) {
		this.diet = diet;
		System.out.println("inside setter of basketball");
	}

	@Override
	public String getTraining() {
		System.out.println(this.name);
		System.out.println(this.email);
		return "take 3 throws";
	}


	@Override
	public String toString() {
		return "BasketballCoach [name=" + name + ", email=" + email + ", diet=" + diet + "]";
	}

	
//	@Override
//	public String getDietPlan() {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public String getDietPlan() {
//		return diet.getDietPlan();
//	}

}
