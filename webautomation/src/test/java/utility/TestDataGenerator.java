package utility;

import java.util.Random;

public class TestDataGenerator {

	 private static Random random = new Random();

	    private static String[] firstNames = {
	            "James", "Michael", "Daniel", "David", "Robert",
	            "Emma", "Sophia", "Olivia", "Isabella", "Charlotte"
	    };

	    private static String[] lastNames = {
	            "Smith", "Johnson", "Brown", "Miller", "Wilson",
	            "Taylor", "Anderson", "Thomas", "White", "Walker"
	    };

	    // Random Full Name
	    public static String getFullName() {

	        String firstName = firstNames[random.nextInt(firstNames.length)];
	        String lastName = lastNames[random.nextInt(lastNames.length)];

	        return firstName + " " + lastName;
	    }

	    // Email based on Full Name
	    public static String getEmail(String fullName) {

	        return fullName.toLowerCase()
	                       .replace(" ", ".")
	                + random.nextInt(1000)
	                + "@gmail.com";
	    }

	    // Spain Mobile Number
	    public static String getSpainMobileNumber() {

	        long number = 600000000L
	                + (long)(random.nextDouble() * 99999999L);

	        return String.valueOf(number);
	    }

	    // 7-digit Employee ID starting with 1 or 2
	    public static String getEmployeeId() {

	        int firstDigit = random.nextBoolean() ? 1 : 2;

	        int remainingDigits = random.nextInt(1_000_000);

	        return firstDigit + String.format("%06d", remainingDigits);
	    }
	
}
