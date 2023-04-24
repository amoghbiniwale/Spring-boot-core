package com.aurionpro.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aurionpro.model.BasketballCoach;
import com.aurionpro.model.CricketCoach;
import com.aurionpro.model.ICoach;
public class CoachTest {

	public static void main(String[] args) {
		 ClassPathXmlApplicationContext context = new  ClassPathXmlApplicationContext("com/aurionpro/model/applicationContext.xml"); //copu qualified name
		 ICoach coach=(ICoach)context.getBean("cricketCoach",CricketCoach.class);
		 ICoach coach3=(ICoach)context.getBean("cricketCoach",CricketCoach.class);
		 System.out.println(coach == coach3);
		 System.out.println(coach.getTraining());
		 context.close();
		 
		// System.out.println(coach.getDietPlan());
		 
//		 BasketballCoach coach1=(BasketballCoach)context.getBean("basketBallCoach",BasketballCoach.class);
//		 System.out.println(coach1.getTraining());
//		 System.out.println("coach name is: "+coach1.getName());
//		 System.out.println("coach email is: "+coach1.getEmail());
//		 
//		 CricketCoach coach2=(CricketCoach)context.getBean("cricketCoach",CricketCoach.class);
//		 System.out.println(coach2.getTraining());
//		 System.out.println("coach name is: "+coach2.getName());
//		 System.out.println("coach email is: "+coach2.getEmail());
//		 
		// System.out.println(coach1.getDietPlan());
		 
		 
		 
	}

}
///02-spring-core-xml-config/src/main/java/com/aurionpro/model/applicationContext.xml