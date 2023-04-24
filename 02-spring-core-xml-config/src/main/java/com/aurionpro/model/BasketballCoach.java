package com.aurionpro.model;

public class BasketballCoach implements ICoach {

	private IDiet diet;

	public BasketballCoach(IDiet diet) {
		super();
		this.diet = diet;
	}

	@Override
	public String getTraining() {
		return "take 3 throws";
	}

	@Override
	public String getDietPlan() {
		return diet.getDietPlan();
	}

}
