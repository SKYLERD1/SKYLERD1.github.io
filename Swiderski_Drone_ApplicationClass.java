/*
Author Name: Skyler Swiderski
Date: 08/28/2019
Program Name: Swiderski_Drone
Purpose: In this particular file, it provides the ability to control the drone. 
	This is an application class.
*/

package week01_drone;

import java.util.Scanner;

public class Swiderski_Drone_ApplicationClass {
	public static Scanner input = new Scanner(System.in); // Scanner object
	public static String userInput; // Converts the scanner input data into a string variable

	public static void main(String[] args) {
		int menuChoice; // Variable that controls the menu system

		Swiderski_Drone_ServiceClass user_Drone = new Swiderski_Drone_ServiceClass(); // Creates the drone object using
																						// the default constructor.
		System.out.println("Welcome to Swiderski Drone Manager!");
		System.out.println(displayMenu()); // Calls the displayMenu method; to display the Menu.
		menuChoice = getMenuInput(); // Calls the getMenuInput method and sets a new value for the menuChoice
										// variable using the result of the getMenuInput method.

		do {
			if (menuChoice == 1) {
				boolean goodInput = false; // Variable used for the do/while loop, to make it keeps running until the
											// input is "good".
				double droneUpNum = 0; // Sets the double value to 0; initializes it.

				do {
					try {
						System.out.println("This control allows the drone to move up.");
						System.out.println("How high would you like the drone to go: ");
						userInput = input.nextLine();
						droneUpNum = Double.parseDouble(userInput);
						goodInput = true;
					} catch (NumberFormatException ex) {
						System.out.println("Enter only decimal numbers.");
					}
				} while (goodInput == false); // This do/while loop will check if the input is a double type.

				user_Drone.setY_Loc(droneUpNum); // The drone object is updated to have it's y coordinate/position
													// number += of the double variable's value.

				System.out.print(displayMenu()); // Calls back the displayMenu method.
				menuChoice = getMenuInput(); // Calls back the getMenuInput method.
			}

			if (menuChoice == 2) {
				boolean goodInput = false; // Variable used for the do/while loop, to make it keeps running until the
											// input is "good".
				double droneDownNum = 0; // Sets the double value to 0; initializes it.

				do {
					try {
						System.out.println("This control allows the drone to move down.");
						System.out.println("How low would you like the drone to go: ");
						userInput = input.nextLine();
						droneDownNum = Double.parseDouble(userInput);
						goodInput = true;
					} catch (NumberFormatException ex) {
						System.out.println("Enter only decimal numbers.");
					}
				} while (goodInput == false); // This do/while loop will check if the input is a double type.

				user_Drone.setY_Loc(-droneDownNum); // Since down is on the y index (and down is on the south side of a
													// typical graph). The numbers are negative.

				System.out.print(displayMenu()); // Calls back the displayMenu method.
				menuChoice = getMenuInput(); // Calls back the getMenuInput method.
			}

			if (menuChoice == 3) {
				boolean goodInput = false; // Variable used for the do/while loop, to make it keeps running until the
											// input is "good".
				double droneForwardNum = 0; // Sets the double value to 0; initializes it.

				do {
					try {
						System.out.println("This control allows the drone to move forward.");
						System.out.println("How much do you want the drone to move forward: ");
						userInput = input.nextLine();
						droneForwardNum = Double.parseDouble(userInput);
						goodInput = true;
					} catch (NumberFormatException ex) {
						System.out.println("Enter only decimal numbers.");
					}
				} while (goodInput == false); // This do/while loop will check if the input is a double type.

				user_Drone.setZ_Loc(droneForwardNum);

				System.out.print(displayMenu());
				menuChoice = getMenuInput();
			}

			if (menuChoice == 4) {
				boolean goodInput = false; // Variable used for the do/while loop, to make it keeps running until the
											// input is "good".
				double droneBackwardNum = 0; // Sets the double value to 0; initializes it.

				do {
					try {
						System.out.println("This control allows the drone to move backward.");
						System.out.println("How much do you want the drone to move backward: ");
						userInput = input.nextLine();
						droneBackwardNum = Double.parseDouble(userInput);
						goodInput = true;
					} catch (NumberFormatException ex) {
						System.out.println("Enter only decimal numbers.");
					}
				} while (goodInput == false); // This do/while loop will check if the input is a double type.

				user_Drone.setZ_Loc(-droneBackwardNum); // Since down is on the z index (and backward is on the south
														// side of a typical graph). The numbers are negative.

				System.out.print(displayMenu());
				menuChoice = getMenuInput();
			}

			if (menuChoice == 5) {
				boolean goodInput = false; // Variable used for the do/while loop, to make it keeps running until the
											// input is "good".
				double droneLeftNum = 0; // Sets the double value to 0; initializes it.

				do {
					try {
						System.out.println("This control allows the drone to move up.");
						System.out.println("How high would you like the drone to go: ");
						userInput = input.nextLine();
						droneLeftNum = Double.parseDouble(userInput);
						goodInput = true;
					} catch (NumberFormatException ex) {
						System.out.println("Enter only decimal numbers.");
					}
				} while (goodInput == false); // This do/while loop will check if the input is a double type.

				user_Drone.setX_Loc(droneLeftNum);

				System.out.print(displayMenu());
				menuChoice = getMenuInput();
			}

			if (menuChoice == 6) {
				boolean goodInput = false; // Variable used for the do/while loop, to make it keeps running until the
											// input is "good".
				double droneRightNum = 0; // Sets the double value to 0; initializes it.

				do {
					try {
						System.out.println("This control allows the drone to move up.");
						System.out.println("How high would you like the drone to go: ");
						userInput = input.nextLine();
						droneRightNum = Double.parseDouble(userInput);
						goodInput = true;
					} catch (NumberFormatException ex) {
						System.out.println("Enter only decimal numbers.");
					}
				} while (goodInput == false); // This do/while loop will check if the input is a double type.

				user_Drone.setX_Loc(-droneRightNum); // Since down is on the x index (and right is on the left side of a
														// typical graph). The numbers are negative.

				System.out.print(displayMenu());
				menuChoice = getMenuInput();
			}

			if (menuChoice == 7) {
				System.out.println(user_Drone.getXYZ_Loc());

				System.out.print(displayMenu());
				menuChoice = getMenuInput();
			}

			if (menuChoice == 8) {
				break;
			}
		} while (menuChoice != 8);

		System.out.println("Thank you for using the Swiderski Drone Manager");
		System.exit(0);
	}

	/**
	 * This method returns the textual representation of the drone control menu.
	 * 
	 * @return menuSystem The textual representation of the menu.
	 */
	public static String displayMenu() {
		String menuSystem = "\n" + "---------| Menu System |---------" + "\n" + "1. Move Drone Up" + "\n"
				+ "2. Move Drone Down" + "\n" + "3. Move Drone Forward" + "\n" + "4. Move Drone Backward" + "\n"
				+ "5. Move Drone Left" + "\n" + "6. Move Drone Right" + "\n" + "7. Display X, Y, and Z Location" + "\n"
				+ "8. Exit System" + "\n" + "---------------------------------" + "\n";

		return menuSystem;
	}

	/**
	 * This method returns the menu option thate the user wants to access. The
	 * method checks the input if it is the correct type.
	 * 
	 * @return menuInput The numeric input of the user.
	 */
	public static int getMenuInput() {
		boolean goodInput = false;
		int menuInput = 0;

		do {
			System.out.println("Menu Option: ");
			userInput = input.nextLine();
			try {
				menuInput = Integer.parseInt(userInput);
			} catch (NumberFormatException | NullPointerException nfe) {
				System.out.println("User Input not numeric or is not an integer. Please retype input.");
			}
			if ((menuInput < 1) || (menuInput > 8)) {
				System.out.println("User Input does not fall in the range of the menu options. Pleas retype input.");
			} else {
				goodInput = true;
			}
		} while (goodInput == false);

		return menuInput;
	}
}