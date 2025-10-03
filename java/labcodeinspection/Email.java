package labcodeinspection;

import java.util.Locale;

/**
 * Email class to generate user email and password 
 * based on first name, last name, and department.
 */
public class Email {

    /** First name of the user */
    private final String firstName;
    /** Last name of the user */
    private final String lastName;
    /** Generated password for the email account */
    private String password;
    /** Department of the user */
    private String department;
    /** Length of the generated password */
    private static final int PSSWD_LENGTH = 8;
    /** Generated email address */
    private String emailAddress;

    /**
     * Constructor for Email class.
     *
     * @param firstName User's first name
     * @param lastName User's last name
     */
    public Email(final String firstName, final String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Display email information using logger.
     */
    public void showInfo() {
		// Using System.out for console output as required by application
		// PMD SystemPrintln rule suppressed for necessary console interaction
		System.out.println("\nFIRST NAME= " + firstName + "\nLAST NAME= " + lastName); // NOPMD
		System.out.println("DEPARMENT= " + department + "\nEMAIL= " + emailAddress + "\nPASSWORD= " + password); // NOPMD
    }

    /**
     * Set department based on choice.
     * @param depChoice Integer representing department
     */
    public void setDepartment(final int depChoice) {
        switch (depChoice) {
            case 1:
                this.department = "sales";
                break;
            case 2:
                this.department = "dev";
                break;
            case 3:
                this.department = "acct";
                break;
            default:
            	this.department = "unknown";
            	break;
        }
    }

    /**
     * Generate a random password of specified length.
     * @param length Length of the password to generate
     * @return Randomly generated password
     */
	private String randomPassword(final int length) {
		final String set = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890#$&@*";
		final char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			final int rand = (int) (Math.random() * set.length());
			password[i] = set.charAt(rand);
		}
		return new String(password);
	}

    /**
     * Generate email address and password.
     */
    public void generateEmail() {
        this.password = this.randomPassword(PSSWD_LENGTH);        
		this.emailAddress = this.firstName.toLowerCase(Locale.getDefault()) + this.lastName.toLowerCase(Locale.getDefault()) 
			+ "@" + this.department + ".espol.edu.ec";
    }
}