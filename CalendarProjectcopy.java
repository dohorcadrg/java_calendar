import java.util.Scanner;

public class CalendarProject{
static Scanner scan = new Scanner(System.in);
static int year;
static int month;
static String monthName;
static boolean isItLeap;
static int numberOfDays;
	
	public static void main(String[] args) {
		System.out.println("Enter a year (Example: 1892)");
		year = scan.nextInt();
		System.out.println("Enter a month in numeric value (Example: 1 for Janurary, 12 for December)");
		month = scan.nextInt();
		isItLeap = calcisItLeap(year);
		numberOfDays = calcnumberOfDays(month);
		System.out.println("Is it a leap year? " + isItLeap);
		System.out.println("How many days? " + numberOfDays);
		System.out.println("What month? " + monthName);
		calcDayOfWeek();

	}


	static boolean calcisItLeap(int y){
		if(y % 400 == 0){
			return true;
		}
		else{
			return false;
		}
	}


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

	static void calcDayOfWeek(){
		int SOLARDAYS = 365;
		int LEAPDAYS = 366;
		int yearCounting = year - 1;
		int leapYearCount = yearCounting / 4;
		int solarYearCount = yearCounting - leapYearCount;
		int daysCountBeforeYear = (leapYearCount * LEAPDAYS) + (solarYearCount * SOLARDAYS);
		int daysPassedInYear = 0;
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
		int weekStart = (daysCountBeforeYear + daysPassedInYear) % 7;

		System.out.print("| Sun | Mon | Tue | Wen | Thr | Fri | Sat |");
		System.out.println();
		System.out.print("| ");
		
		int printCount = weekStart + numberOfDays;
		if (weekStart > 0){
			for (int i = 1; i <= weekStart ; i++ ) {
				System.out.print("    | ");
			}
		}

		for (int d = 1; d <= numberOfDays ; d++ ) {

			while(d < 10){
				System.out.print(" 0" + d + " | ");
					if ((weekStart + d) % 7 == 0) {
					System.out.println();
					System.out.print("| ");
					}
					d++;
			}

			System.out.print(" " + d + " | ");

			if ((weekStart + d) % 7 == 0 && d < numberOfDays-1) {
				System.out.println();
				System.out.print("| ");
			}
		}

		System.out.println(" ");
	}

}