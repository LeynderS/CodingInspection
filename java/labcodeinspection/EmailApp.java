package labcodeinspection;

import java.util.Scanner;

/**
 * Main class to handle email generation application.
 */
public final class EmailApp {
	
	/**
	 * Private constructor to prevent instantiation of this utility class.
	 */
	private EmailApp() {
		// Utility class - prevent instantiation
	}

    /**
     * Entry point of the email generation application.
     * @param args Command line arguments
     */
	public static void main(final String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			// Using System.out for console interaction as required by application
			// PMD SystemPrintln rule suppressed for necessary console interaction
			System.out.print("Enter your first name: "); // NOPMD
			final String firstName = scanner.nextLine();

			System.out.print("Enter your last name: "); // NOPMD
			final String lastName = scanner.nextLine();

			System.out.print("\nDEPARTMENT CODE\n1. for sales\n2. for Development\n3. for accounting\nEnter code: "); // NOPMD

			final int depChoice = scanner.nextInt();
			scanner.close();

			final Email email = new Email(firstName, lastName);
			email.setDepartment(depChoice);
			email.generateEmail();
			email.showInfo();
		}
	}
}