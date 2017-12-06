/**
 *
Problem statement:
	Write a loan calculator program that computes both monthly and total payments for a given loan amount, annual interest rate, and loan period.

Overall Plan
Tasks:
Get three input values: loanAmount, interestRate, and loanPeriod.
Compute the monthly and total payments.
Output the results.

Required Classes
LoanCalculator 
Loan 

Development Steps
We will develop this program in five steps:
1. Start with the main class LoanCalculator. Define a temporary placeholder Loan class.
2. Implement the input routine to accept three input values.
3. Implement the output routine to display the results.
4. Implement the computation routine to compute the monthly and total payments.
5. Finalize the program.

Step 1 Design
The methods of the LoanCalculator class 
Method	Visibility	Purpose
start	            public	  Starts the loan calcution. Calls other methods
computePayment		private		Give three parameters, compute the monthly and total payments
describeProgram		private		Displays a short description of a program
displayOutput			private		Displays the output
getInput					private		Gets three input values

Step 1 Test
In the testing phase, we run the program multiple times and
 verify that we get the following output
inside describeProgram 
inside getInput 
inside computePayment 
inside displayOutput 

Step 2 Design
Design the input routines
LoanCalculator will handle the user interaction of prompting and getting three input values
LoanCalculator calls the setAmount, setRate and setPeriod of a Loan object.

Step 2 Test
We run the program numerous times with different input values
Check the correctness of input values by echo printing

System.out.println("Loan Amount: $" 
                            + loan.getAmount());
System.out.println("Annual Interest Rate:" 
                            + loan.getRate() + "%");
System.out.println("Loan Period (years):" 
                            + loan.getPeriod());

Step 3 Design
We will implement the displayOutput method.
We will reuse the same design we adopted in Chapter 3 sample development.



Step 3 Test
We run the program numerous times with different input values and check the output display format.
Adjust the formatting as appropriate

Step 4 Design
Two methods getMonthlyPayment and getTotalPayment are defined for the Loan class
We will implement them so that they work independent of each other.
It is considered a poor design if the clients must call getMonthlyPayment before calling getTotalPayment.

Step 4 Test
We run the program numerous times with different types of input values and check the results.


Step 5: Finalize
We will implement the describeProgram method
We will format the monthly and total payments to two decimal places using DecimalFormat.

 */

package experiment02;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class Test03 {

	public static void main(String[] args) {
		LoanCalculator loanCalculator = new LoanCalculator();
		loanCalculator.start();
	}

}

class Loan {
	private double amount;
	private double rate;
	private int period;

	public Loan() {
		super();
	}

	public Loan(double amount, double rate, int period) {
		super();
		this.amount = amount;
		this.rate = rate;
		this.period = period;
	}

	public double getAmount() {
		return amount;
	}

	public double getRate() {
		return rate;
	}

	public int getPeriod() {
		return period;
	}

	public double getMonthlyPayment() {
		return (amount * rate / 100 / 12) / (1 - Math.pow(1 / (1 + rate / 100 / 12), period * 12));
	}

	public double getTotalPayment() {
		return getMonthlyPayment() * period * 12;
	}
}

// feature：computes both monthly and total payments for a given loan amount,
// annual interest rate, and loan period.
class LoanCalculator {
	private double loanAmount;// 贷款金额
	private double interestRate;// 利率
	private int loanPeriod;// 贷款期限
	private Loan loan;

	public LoanCalculator() {
		super();
		// Define a temporary placeholder Loan class.
		loan = new Loan();
	}

	// Starts the loan calcution. Calls other methods
	public void start() {
		describeProgram(); // Displays a short description of a program
		getInput(); // input routine to accept three input values.
		computePayment(); // output routine to display the results.
		displayOutput(); // computation routine to compute the monthly and total payments.
	}

	// Give three parameters, compute the monthly and total payments
	private void computePayment() {

	}

	// Displays a short description of a program
	private void describeProgram() {
		System.out.println("This program computes the monthly and total");
		System.out.println("payments for a given loan amount, annual ");
		System.out.println("interest rate, and loan period (# of years).");
		System.out.println("\n");
	}

	// Displays the output
	private void displayOutput() {
		DecimalFormat df = new DecimalFormat("0.00");

		System.out.println("Loan Amount: $" + loan.getAmount());
		System.out.println("Annual Interest Rate:" + loan.getRate() + "%");
		System.out.println("Loan Period (years): " + loan.getPeriod());

		System.out.println("Monthly payment is $ " + df.format(loan.getMonthlyPayment()));
		System.out.println("  TOTAL payment is $ " + df.format(loan.getTotalPayment()));
	}

	// Gets three input values
	private void getInput() {
		String inputStr;
		inputStr = JOptionPane.showInputDialog(null, "Loan Amount :");
		loanAmount = Double.parseDouble(inputStr);
		inputStr = JOptionPane.showInputDialog(null, "Annual Interest Rate :");
		interestRate = Double.parseDouble(inputStr);
		inputStr = JOptionPane.showInputDialog(null, "Loan Period - # of years:");
		loanPeriod = Integer.parseInt(inputStr);
		loan = new Loan(loanAmount, interestRate, loanPeriod);
	}

}
