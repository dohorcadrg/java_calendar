/*********************
*	Glory Legaspi,   *
*		CS227		 *	
*	SPRING 2018      *
**********************/

import java.util.Scanner;

public class CalendarProject{

//Variables Needed
static Scanner scan = new Scanner(System.in);
static int year;
static int month;
static String monthName;
static boolean isItLeap;
static int numberOfDays;
static int SOLARDAYS = 365;
static int LEAPDAYS = 366;
static int yearCounting;
static int leapYearCount;
static int solarYearCount;
static int daysCountBeforeYear;
static int daysPassedInYear;
static int weekStart;

	
	public static void main(String[] args) {
		System.out.println("Enter a year (Example: 1892)");
		year = scan.nextInt();
		System.out.println("Enter a month in numeric value (Example: 1 for Janurary, 12 for December)");
		month = scan.nextInt();
		System.out.println();
		calcCalander();
		System.out.println("This is this calendar for: ");
		System.out.println();
		System.out.println(monthName + " " + year);
		printCalander();
		System.out.println();
	}

	//Check if year entered is a leap year
	static boolean calcisItLeap(int y){
		if(y % 4 == 0){
			return true;
		}
		else{
			return false;
		}
	}

	//Calculate what month is entered based on number value and the number of days in that month
	static int calcnumberOfDays(int m){
		int days;
		switch (m){
			case 1:
			monthName = "Janurary";
			days = 31;
			break;
			case 2:
			monthName = "Feburary";
			if (!(isItLeap)) {
				days = 28;
			}
			else{
				days = 29;
			}
			break;
			case 3:
			monthName = "March";
			days = 31;
			break;
			case 4:
			monthName = "April";
			days = 30;
			break;
			case 5:
			monthName = "May";
			days = 30;
			break;
			case 6:
			monthName = "June";
			days = 30;
			break;
			case 7:
			monthName = "July";
			days = 31;
			break;
			case 8:
			monthName = "Agust";
			days = 31;
			break;
			case 9:
			monthName = "September";
			days = 30;
			break;
			case 10:
			monthName = "October";
			days = 31;
			break;
			case 11:
			monthName = "November";
			days = 30;
			break;
			case 12:
			monthName = "December";
			days = 31;
			break;
			default:
			days = 0;
			break;
		}
		return days;
	}

	//Calculate what day the month starts on
	static void calcDayOfWeek(){
		yearCounting = year - 1;
		leapYearCount = yearCounting / 4;
		solarYearCount = yearCounting - leapYearCount;
		daysCountBeforeYear = (leapYearCount * LEAPDAYS) + (solarYearCount * SOLARDAYS);
		daysPassedInYear = 0;
		for (int mnt = 0; mnt < month ; mnt++ ) {
			switch (mnt){
				case 1:
				case 3:
				case 7:
				case 8:
				case 10:
				case 12:
				daysPassedInYear += 31;
				break;
				case 4:
				case 5:
				case 6:
				case 9:
				case 11:
				daysPassedInYear += 30;
				break;
				case 2:
				if (!(isItLeap)) {
				daysPassedInYear += 28;
				}
				else{
				daysPassedInYear += 29;
				}
				break;
				default:
				break;
			}
		}
		weekStart = (daysCountBeforeYear + daysPassedInYear) % 7;
	}

	//Shotcut function to calculate math needed for calander
	static void calcCalander(){
		isItLeap = calcisItLeap(year);
		numberOfDays = calcnumberOfDays(month);
		calcDayOfWeek();
	}

	static void printCalander(){
		//BEGIN PRINTING OUT CALANDER
		System.out.print("| Sun | Mon | Tue | Wed | Thr | Fri | Sat |");
		makeNewLineAndMarkIt();
		int printCount = weekStart + numberOfDays;
		//PRINT EMPTY DAYS BEFORE THE DAY STARTS
		if (weekStart > 0){
			for (int i = 1; i <= weekStart ; i++ ) {
				makeEmptyLine();
			}
		}
		//START PRINTING CALANDER DAYS
		for (int d = 1; d <= numberOfDays ; d++ ) {
			
			while(d < 10){
			//DAYS LESS THAN 10 HAVE + 0 BEFORE IT TO MAKE IT 01,02 , ETC..
				System.out.print(" 0" + d + " | ");
				if ((weekStart + d) % 7 == 0) {
					makeNewLineAndMarkIt();
				}
				d++; 
			}

			//WEHN DAY PRINTED OUT IS GREATER THAN 10, PRINT AS NORMAL
			System.out.print(" " + d + " | ");
			
			//WHEN THE ROW OF DAYS IS OVER 7 AND WHEN IT IS NOT THE LAST LINE
			if ((weekStart + d) % 7 == 0 && d <= numberOfDays-1) {
				makeNewLineAndMarkIt();
				//Go To Next Line
			}
		}

		//WHEN PRINTING THE CALANDER DAYS IS DONE AND THE LAST DAY DOES'NT END ON SATURDAY, PRINT OUT EMPTY LINES TO COMPLETE ROW
			if (printCount % 7 != 0) {
				for (int fc = printCount; fc % 7 != 0; fc++) {
					makeEmptyLine();
				}
			}
		//Print next line
		System.out.println();
	}

	//Shortcute functions for printing lines
	static void makeNewLineAndMarkIt(){
		System.out.println();
		System.out.print("| ");
	}

	static void makeEmptyLine(){
		System.out.print("    | ");
	}

}