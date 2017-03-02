public class PS2_ControlFlow {


    static void Q1(){
        // print all integers from 1 to 30 (including 1 and 30)
    	for (int i = 1; i < 31; i++) {
			System.out.println(i);
		}

    }


    static void Q2(){
        // print all integers from 0 to 29 (including 0 and 29)
    	for (int i = 0; i < 30; i++) {
			System.out.println(i);
		}


    }


    static void Q3(){
        // print all integers from 200 to 230 (including 200 and 230)
    	for (int i = 0; i < 31; i++) {
			System.out.println(i + 200);
		}

    }


    static void Q4(){
        // print the numbers 40 through 50, then the numbers 70 through 80 (including 40, 50, 70, and 80)
    	for (int i = 40; i < 51; i++) {
			System.out.println(i);
		}
    	for (int i = 70; i < 81; i++) {
			System.out.println(i);
		}
    }


    static void Q5(){
        // print the numbers 100 through 120, then the numbers 60 through 70 (including 100, 120, 60, and 70)
    	for (int i = 100; i < 121; i++) {
			System.out.println(i);
		}
    	for (int i = 60; i < 71; i++) {
			System.out.println(i);
		}
    }


    static void Q6(){
        // print the decreasing integers from 35 to 0 (including 35 and 0)
    	for (int i = 35; i > -1; i--) {
			System.out.println(i);
		}

    }


    static void Q7(){
        // print all even integers between 1 and 50 (including 50)
    	for (int i = 2; i < 51; i = i +2) {
			System.out.println(i);
		}
    }


    static void Q8(){
        // print all odd integers between 1 and 50 (including 1)
    	for (int i = 1; i < 51; i = i +2) {
			System.out.println(i);
		}
    }


    static void Q9(){
        // print all negative integers between -25 and 100 (including -25)
    	for (int i = -25; i < 0; i++) {
			System.out.println(i);
		}
    }


    static void Q10(){
        // print all multiples of 10 between 1 and 200 (including 200)
        // in other words, count by tens up to 200
    	for (int i = 10; i < 201; i = i + 10) {
			System.out.println(i);
		}
    }


    static void Q11(){
        // print each integer between 50 and 53 5 times each (including 50 and 53)
    	for (int i = 50; i < 54; i++) {
    		for (int j = 0; j < 5; j++) {
    			System.out.println(i);
    		}
		}
    }


    static void Q12(){
        // print the integers from 1 to 20 (including 1 and 20) except if the number is even print "even" instead
        // of the number
    	for (int i = 1; i < 21; i++) {
    		if(i%2 == 0){
			System.out.println("even");
    		}
    		else{
    		System.out.println(i);
    		}
		}
    }


    static void Q13(){
        // print the integers from 1 to 20 (including 1 and 20) except if the number is even print "even" instead
        // of the number and if the number is odd print "odd" instead of the number
    	for (int i = 1; i < 21; i++) {
    		if(i%2 == 0){
			System.out.println("even");
    		}
    		else{
    		System.out.println("odd");
    		}
		}
    }


    static void Q14(){
        // print the integers from -10 to 25 (including -10 and 25) except if the number is negative print "<0"
        // instead of the number, if the number is positive print ">0" instead of the number, and if the number is 0
        // print "=0" instead of 0.
    	for (int i = -10; i < 26; i++) {
    		if(i < 0){
			System.out.println("<0");
    		}else if(i == 0){
    		System.out.println("=0");
    		}else{
    		System.out.println(">0");
    		}
		}
    }


    static void Q15(){
        // print the numbers from 1 to 40 (including 1 and 40) except if the number is even print "even" instead
        // of the number and if the number is greater than 25 print ">25" instead of the number. For numbers that
        // are both even and greater than 25 print "even>25"
    	for (int i = 1; i < 41; i++) {
    		if(i%2 == 1 && i <= 25){
    		System.out.println(i);
    		}
    		if(i%2 == 0 && i <= 25){
    		System.out.println("even");
    		}
    		if(i%2 == 1 && i > 25){
    		System.out.println(">25");
    		}
    		if(i%2 == 0 && i > 25){
    		System.out.println("even>25");
    		}
		}
    }


}
