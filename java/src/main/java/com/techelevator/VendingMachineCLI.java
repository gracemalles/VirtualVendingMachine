package com.techelevator;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


import com.techelevator.Logger.VendingMachineLogger;
import com.techelevator.model.Products;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE,
									MAIN_MENU_EXIT};


	private Menu menu;
	CSVLoader csv = new CSVLoader(); //List

	VendingMachineLogger myLogger = new VendingMachineLogger("src\\main\\java\\com\\techelevator\\Logger\\logFile.txt");





	public VendingMachineCLI(Menu menu) throws FileNotFoundException {
		this.menu = menu;
	}

	public void run() {
		boolean shouldLoop = true;
		while (shouldLoop) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				printMenu();


			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				purchaseMenu();


			} else if (choice.equals(MAIN_MENU_EXIT)) {
				shouldLoop = false;
				try {
					myLogger.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

		public void printMenu() {

				for(Products products : csv.getProductList()){
					System.out.println(products.getCode() + " | "
							+ (products.getName()) + " | " + (products.getPrice()) +
							" | " + (products.getType()) + " | "
							+ (products.getQuantity()));
				}

		}
		public BigDecimal purchaseMenu() {
		final String FEED_MONEY = "Feed Money";
		final String SELECT_PRODUCT = "Select Product";
		final String FINISH_TRANSACTION = "Finish Transaction";

		final String[] PURCHASE_MENU_OPTIONS = {FEED_MONEY, SELECT_PRODUCT, FINISH_TRANSACTION};


		BigDecimal currentTotal = new BigDecimal("0.00");
			System.out.println("\nCurrent Money Provided: $" + currentTotal);
		boolean shouldLoop = true;
		while (shouldLoop) {
			String choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
			switch (choice) {
				case FEED_MONEY:
					boolean shouldRepeat = true;
					while (shouldRepeat) {
						System.out.println("Insert money in $1, $2, $5, or $10 increments");
							Scanner moneyScanner = new Scanner(System.in);
							try {
								String paymentAmountString = moneyScanner.nextLine();
								BigDecimal paymentAmount = BigDecimal.valueOf(Double.valueOf(paymentAmountString)); // need to correct variable to be cumulative
								currentTotal = paymentAmount.add(currentTotal);
								myLogger.write(LocalDateTime.now() + ": " + "FEED MONEY: " + currentTotal + " " + currentTotal);
								myLogger.flush();

								System.out.println("\nCurrent Money Provided: $" + currentTotal);

								System.out.println("Would you like to insert more money? (Y/N)");
								String moreMoney = moneyScanner.nextLine().toLowerCase();
								if (moreMoney.equals("Y")) {
									shouldRepeat = true;
								} else {
									shouldRepeat = false;
								}
							} catch (Exception e){
								System.out.println("Please enter a valid selection !");
							}
					}

					break;
				case SELECT_PRODUCT:
					boolean shouldRepeatPurchaseMenu = true;
					while (shouldRepeatPurchaseMenu) {
						printMenu();
						System.out.println("Please select an item code: (example: D4)");
						Scanner inputScanner = new Scanner(System.in);  // should we put Scanner in broader scope and use same for money and purchase code?
						String purchaseCode = inputScanner.nextLine().toLowerCase();                    // changed code input to NOT be case sensitive (line 109 as well)
						if (!purchaseCode.contains("A") && !purchaseCode.contains("B") && !purchaseCode.contains("C")
								&& !purchaseCode.contains("D") && !purchaseCode.contains("1") && !purchaseCode.contains("2")
						&& !purchaseCode.contains("3") && !purchaseCode.contains("4")){
							System.out.println("Invalid Entry.");
							shouldRepeatPurchaseMenu = false;
						}

						for (Products products : csv.getProductList()) {
							if (products.getCode().toLowerCase().equals(purchaseCode.toLowerCase())) {
								if (products.getPrice().compareTo(currentTotal) > 0) {
									System.out.println("Insufficient funds. Please insert more money.");
									shouldRepeatPurchaseMenu = false;
								} else if (products.getQuantity() < 1) {
									System.out.println("SOLD OUT");
									shouldRepeatPurchaseMenu = false;
								} else {
									products.updateQuantity();
									System.out.println(products.getName() + "| Price: $" + products.getPrice()
											+ "| Balance: $" + currentTotal.subtract(products.getPrice()) + "\n"
											+ products.getMessage() + "\n");

									LocalDateTime current = LocalDateTime.now();
									//current.getDayOfWeek();
									myLogger.write(LocalDateTime.now() + ": " + products.getName() + " " + currentTotal + " " + (currentTotal.subtract(products.getPrice())));
									myLogger.flush();

									currentTotal = (currentTotal.subtract(products.getPrice()));

									shouldRepeatPurchaseMenu = false;
								}
							}

						}
					}


					break;
				case FINISH_TRANSACTION:
					BigDecimal remainingBalanceInCents = currentTotal.multiply(new BigDecimal("100"));
					int remainingBalanceInt = remainingBalanceInCents.intValue();
					int quarter, dime, nickel;

					quarter = remainingBalanceInt/25;
					remainingBalanceInt= remainingBalanceInt - quarter*25;
					dime = remainingBalanceInt/10;
					remainingBalanceInt = remainingBalanceInt - dime*10;
					nickel = remainingBalanceInt/5;
					remainingBalanceInt = remainingBalanceInt - nickel*5;

					System.out.println(quarter + " quarters");
					System.out.println(dime + " dimes");
					System.out.println(nickel + " nickels");

					System.out.println("Your change is $" + currentTotal + "\n" +
					"Thank you for your patronage!");

					myLogger.write(LocalDateTime.now() + ": " + "GIVE CHANGE: $" + currentTotal + " $0.00");
					myLogger.flush();

					currentTotal = new BigDecimal("0.00");
					shouldLoop = false;
					break;

			}	}

		return null;
		}


	public static void main(String[] args) throws FileNotFoundException {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();


	}
}
