package vtiger.genericUtils;

import java.util.Date;
import java.util.Random;

//Agar koi methods java ke package use kar rahe hai ...
// toh uske liye ye JAVA UTILITY banaya gaya hai

// Random Number aur System Date and time chahiye hoga
public class JavaUtility {
	
	public int generateRandomNumber(int limit)
	{
		Random ran = new Random();
		return ran.nextInt(limit);
	}
	
	public String generateSystemDateAndTime()
	{
		Date date = new Date();
		return date.toString().replace(" ", "_").replace(":", "_");
		
	}
	
	 

}
