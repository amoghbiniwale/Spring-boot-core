package com.aurionpro.model;

import org.springframework.stereotype.Component;

@Component
public class SportDiet implements IDiet {

	@Override
	public String getDietPlan() {
		return " take protines and reduce fats";
	}

}
