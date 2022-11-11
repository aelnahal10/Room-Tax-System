package RoomTaxSystem;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TaxSystem {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		File file = new File("C:\\Users\\abdal\\OneDrive\\Desktop\\rooms.txt");
		String[] arr = new String[12];
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			for (int i = 0; i < 12; i++) { // for loop for reading every lines in the file
				arr[i] = br.readLine();
			}
		} catch (IOException e) {
			// TOyDO Auto-generated catch block
			e.printStackTrace();
		}
		double customTax;
		double totalTax = 0;
		double totalIncome = 0;
		String ans;
		double defaultTax = 20;

		

			System.out.println("- - Room Tax System - -\r\n");
			System.out.println("Specify custom tax rate? Y/N");
			String choice = input.nextLine().toLowerCase();

			if (choice.equals("y")) {
				System.out.println("please specify custom tax rate" );
				customTax = input.nextDouble();
				for (int j = 0; j < arr.length; j++) {
					if(arr[j] != null && !arr[j].isBlank()&& ! arr[j].isEmpty()) {
						double bookings = Double.parseDouble(arr[j + 1].toString());
						double rPrice = Double.parseDouble(arr[j + 2].toString());
						double income = bookings * rPrice;
						double percentage = customTax/100;
						double tax = income * percentage;
						totalIncome += income;
						totalTax += tax;
						System.out.println(
								"Room Type: " + arr[j] +" " + "Bookings:" + arr[j + 1] + " "+ "income:" + income+" " + "Tax:" + tax);
						
						j+=2;
					}
					
					
				}
				//System.out.println("Total Income= "+ totalIncome);
				//System.out.println("Total Tax= "+totalTax);

			}

		}
	}
