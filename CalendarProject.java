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
		if(y % 4 == 0){
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
		
		int startnumber = 4;

		System.out.print("| Sun | Mon | Tue | Wen | Thr | Fri | Sat |");
		System.out.println(" ");
		System.out.print("| ");
		int printCount = startnumber + numberOfDays;
		for (int i = 1; i <= startnumber ; i++ ) {
			System.out.print("    | ");
		}
		if (startnumber == 0){
		System.out.println(" ");
		System.out.print("| ");
		}

		for (int d = 1; d <= numberOfDays ; d++ ) {

			while(d < 10){
				System.out.print(" 0" + d + " | ");
				if ((startnumber + d) % 7 == 0) {
				System.out.println(" ");
				System.out.print("| ");
				}
				d++;
			}

			System.out.print(" " + d + " | ");

			if ((startnumber + d) % 7 == 0 && d < numberOfDays-1) {
				System.out.println(" ");
				System.out.print("| ");
			}
		}
		System.out.println(" ");
	}

}