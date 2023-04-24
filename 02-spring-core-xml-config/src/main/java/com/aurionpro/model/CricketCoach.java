package com.aurionpro.model;

public class CricketCoach implements ICoach {

private IDiet diet;
	
	

	public CricketCoach(IDiet diet) {
	super();
	this.diet = diet;
}

	@Override
	public String getTraining() {
		return "3 hr training";
	}


	
	@Override
	public String getDietPlan() {
		return diet.getDietPlan();
	}

}
