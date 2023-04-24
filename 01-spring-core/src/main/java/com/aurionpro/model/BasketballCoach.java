package com.aurionpro.model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class BasketballCoach implements ICoach {
	
IDiet diet;
	
	
	public BasketballCoach(@Qualifier(value="sportDiet")IDiet diet) {
		super();
		this.diet = diet;
	}


	@Override
	public String getTrainingDetails() {
		return "practice 3 throws"+  diet.getDietPlan();
	}

	@Override
	public String getDietPlan() {
		return diet.getDietPlan() ;
	}

}
