public class HW1_EatSleepDrink {


    /**
     * 3 points
     *
     * Compute net hourly pay including tips. Tips are given proportionate to hourly rate.
     *
     * Note: We are ignoring taxes in this assignment.
     *
     * @param hourlyPayRate  Base pay rate per hour
     * @param tipRate  Average tip rate (not percentage) from customers. Example: If your tip rate is 20% this
     *                 value will be 0.2
     * @return Net pay including hourly rate and tips
     */
    public static double netHourlyPayRate(double hourlyPayRate, double tipRate){
    	
        return hourlyPayRate + hourlyPayRate * tipRate;
        
    }


    /**
     * 4 points
     *
     * Compute the total weekly cost for food and drinks given their individual daily costs. Use a full 7 day week for
     * computations (not a 5 day work week).
     *
     * @param dailyFoodCost  Total cost of food for a single day
     * @param dailyBeverageCost  Total cost of drinks for a single day
     * @return Total cost of food and drinks for a 7 day week
     */
    public static double totalWeeklyCost(double dailyFoodCost, double dailyBeverageCost){
    	
        return dailyFoodCost * 7 + dailyBeverageCost * 7;
        
    }
    

    /**
     * 3 points
     *
     * Compute the total number of hours needed to earn an A in all courses for a given amount of credit hours.
     * Assume it's necessary to spend 1 hour/week in class and 2 hours/week outside of class for each credit hour
     * registered to earn A's in all courses for a semester.
     *
     * @param creditHours  Number of credit hours registered
     * @return Total number of hours spent on courses in a single week
     */
    public static double weeklyEducationTime(int creditHours){
    	
        return creditHours * 3;
    }


    /**
     * 10 points
     *
     * Can you afford to eat, sleep, and drink each week while still performing well in your classes and having the
     * free time you desire? Make computations based on a single 7 day week (168 hours) and determine if there is
     * enough time in the week to do everything. You will need to earn cash at your job (given pay and tip rate)
     * to earn enough money to afford food and drink for the week. To avoid becoming robots who only work and study, 
     * also factor in the number of hours spent sleeping and chilling which includes everything that isn't work or school.
     *
     * Note: You can, and should, call the previous 3 functions to help you complete this function and reduce clutter.
     *
     * @param hourlyPayRate  Base pay rate per hour
     * @param tipRate  Average tip rate (not percentage) from customers. Example: If your tip rate is 20% this
     *                 parameter will be 0.2
     * @param dailyFoodCost  Total cost of food for a single day
     * @param dailyBeverageCost  Total cost of drinks for a single day
     * @param creditHours  Number of credit hours registered
     * @param dailySleepAndChill  hours spent each day sleeping or chilling (anything that's not work or school)
     * @return true if it's possible to afford a week with this lifestyle, false otherwise
     */
    public static boolean canEatSleepDrink(double hourlyPayRate, double tipRate, double dailyFoodCost,
                                           double dailyBeverageCost, int creditHours, int dailySleepAndChill){
    	
    	double weeklySchoolHours = weeklyEducationTime(creditHours);
    	
    	double weeklyCost = totalWeeklyCost(dailyFoodCost, dailyBeverageCost);
    	
    	double weeklySleepAndChill = dailySleepAndChill * 7;
    	
    	double weeklyPay = (168 - weeklySchoolHours - weeklySleepAndChill) * netHourlyPayRate(hourlyPayRate, tipRate);
    	
    	if(weeklyPay >= weeklyCost){
    		return true;
    	}else{
    		return false;
    	}
    }


    /**
     * 10 points
     *
     * Can you afford to eat, sleep, and drink each week while still performing well in your classes and getting the
     * sleep and free time you desire? For this function you must also factor in the amount of cash at the beginning 
     * of the week as well as the cash needed for random purchases throughout the week.
     *
     * @param hourlyPayRate  Base pay rate per hour
     * @param tipRate  Average tip rate (not percentage) from customers. Example: If your tip rate is 20% this
     *                 parameter will be 0.2
     * @param dailyFoodCost  Total cost of food for a single day
     * @param dailyBeverageCost  Total cost of drinks for a single day
     * @param creditHours  Number of credit hours registered
     * @param dailySleepAndChill  hours spent each day sleeping or chilling (anything that's not work or school)
     * @param startingCash          Amount of cash at the beginning of the week
     * @param randomSpending        Amount of cash needed for random purchases throughout the week
     * @return true if it's possible to afford a week with this lifestyle, false otherwise
     */
    public static boolean canEatSleepDrink(double hourlyPayRate, double tipRate, double dailyFoodCost,
                                           double dailyBeverageCost, int creditHours, int dailySleepAndChill,
                                           double startingCash, double randomSpending){

    	double weeklySchoolHours = weeklyEducationTime(creditHours);
    	double weeklyCost = totalWeeklyCost(dailyFoodCost, dailyBeverageCost);
    	double weeklySleepAndChill = dailySleepAndChill * 7;
    	double weeklyPay = (168 - weeklySchoolHours - weeklySleepAndChill) * netHourlyPayRate(hourlyPayRate, tipRate);
    	
    	double totalIncome = weeklyPay + startingCash;
    	double totalCost = weeklyCost + randomSpending;
    	
       if(totalIncome >= totalCost){
    	   return true;
       }else{
    	  return false; 
       }
    }

    /**
     * 10 points
     *
     * Return the maximum number of credits hours that can be taken with an A while maintaining the desired lifestyle. 
     * The criteria are the same as the previous function except the number of credit hours is not given. Compute and 
     * return the maximum number of credit hours that can be taken while maintaining this lifestyle.
     *
     * @param hourlyPayRate  Base pay rate per hour
     * @param tipRate  Average tip rate (not percentage) from customers. Example: If your tip rate is 20% this
     *                 parameter will be 0.2
     * @param dailyFoodCost  Total cost of food for a single day
     * @param dailyBeverageCost  Total cost of drinks for a single day
     * @param dailySleepAndChill  hours spent each day sleeping or chilling (anything that's not work or school)
     * @param startingCash          Amount of cash at the beginning of the week
     * @param randomSpending        Amount of cash needed for random purchases throughout the week
     * @return the maximum number of credits that can be taken while earning an A and maintaining the given lifestyle
     */
    public static int maximumCredits(double hourlyPayRate, double tipRate, double dailyFoodCost,
                                     double dailyBeverageCost, int dailySleepAndChill,
                                     double startingCash, double randomSpending){
    	
    	double weeklyCost = (totalWeeklyCost(dailyFoodCost, dailyBeverageCost) + randomSpending) - startingCash;
    	double weeklySleepAndChill = dailySleepAndChill * 7;
    	double payRate = netHourlyPayRate(hourlyPayRate, tipRate);

    	double hoursToWork = weeklyCost/payRate;
    	double hoursForSchool = 168 - weeklySleepAndChill - hoursToWork;
    	
    	double creditHours = hoursForSchool/3;
    	
    	
    	//we wait to cast to an int until the end to avoid rounding errors.
    	return (int) creditHours;
    }


    /**
     * Challenge Question
     * Bonus: 10 points
     *
     * Return the best possible semester grade given the following chart of time multipliers. The multiplier
     * is the number of hours spent outside of class per week per credit hour. This multiplier does not include the 
     * 1 hour/week spent in class for each credit hour.
     *
     * Multiplier | Grade
     *   >= 2.0   |  A
     *   >= 1.75  |  A-
     *   >= 1.5   |  B+
     *   >= 1.25  |  B
     *   >= 1.0   |  B-
     *   >= 0.75  |  C+
     *   >= 0.5   |  C
     *   >= 0.25  |  C-
     *   >= 0.1   |  D
     *   < 0.1    |  F
     *
     * Note: depending on the types of courses taken this chart may not be exactly accurate, but we will assume these
     * numbers are true for this function.
     *
     * @param hourlyPayRate  Base pay rate per hour
     * @param tipRate  Average tip rate (not percentage) from customers. Example: If your tip rate is 20% this
     *                 parameter will be 0.2
     * @param dailyFoodCost  Total cost of food for a single day
     * @param dailyBeverageCost  Total cost of drinks for a single day
     * @param creditHours  Number of credit hours registered
     * @param dailySleepAndChill  hours spent each day sleeping or chilling (anything that's not work or school)
     * @param startingCash          Amount of cash at the beginning of the week
     * @param randomSpending        Amount of cash needed for random purchases throughout the week
     * @return The highest grade possible for the given number of credits and lifestyle choices
     */
    public static String maximumGrade(double hourlyPayRate, double tipRate, double dailyFoodCost,
                                      double dailyBeverageCost, int creditHours, int dailySleepAndChill,
                                      double startingCash, double randomSpending){
    	
    	double weeklyCost = (totalWeeklyCost(dailyFoodCost, dailyBeverageCost) + randomSpending) - startingCash;
    	double weeklySleepAndChill = dailySleepAndChill * 7;
    	double payRate = netHourlyPayRate(hourlyPayRate, tipRate);

    	double hoursToWork = weeklyCost/payRate;
    	double hoursForSchool = 168 - weeklySleepAndChill - hoursToWork;
    	
    	double  outsideMultiplier = (hoursForSchool - creditHours) / creditHours;
    	
    
    	
    	if(outsideMultiplier >= 2.00){
    		return "A";
    	}
    	else if(outsideMultiplier >= 1.75){
    		return "A-";
    	}
    	else if(outsideMultiplier >= 1.5){
    		return "B+";
    	}
    	else if(outsideMultiplier >= 1.25){
    		return "B";
    	}
    	else if(outsideMultiplier >= 1.0){
    		return "B-";
    	}
    	else if(outsideMultiplier >= 0.75){
    		return "C+";
    	}
    	else if(outsideMultiplier >= 0.5){
    		return "C";
    	}
    	else if(outsideMultiplier >= 0.25){
    		return "C-";
    	}
    	else if(outsideMultiplier >= 0.10){
    		return "D";
    	}
    	else if(outsideMultiplier < 0.10){
    		return "F";
    	}

        return "you should never get here";
    }


    public static void main(String[] args) {


    }

}