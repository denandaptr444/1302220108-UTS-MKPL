package lib;

public class TaxFunction {

	private static final int BASIC_NON_TAXABLE = 54000000;
	private static final int MARRIED_ADDITION = 4500000;
	private static final int CHILD_ADDITION = 1500000;
	private static final int MAX_CHILDREN = 3;
	private static final double TAX_RATE = 0.05;


	public static int calculateTax(
		int monthlySalary,
		int otherMonthlyIncome,
		int numberOfMonthWorking,
		int deductible,
		boolean isMarried,
		int numberOfChildren
	) {

		if (numberOfMonthWorking > 12) {
			System.err.println("More than 12 months working per year");
		}

		if (numberOfChildren > MAX_CHILDREN) {
			numberOfChildren = MAX_CHILDREN;
		}

		int nonTaxableIncome = BASIC_NON_TAXABLE;

		if (isMarried) {
			nonTaxableIncome += MARRIED_ADDITION + (numberOfChildren * CHILD_ADDITION);
		}

		int annualIncome = (monthlySalary + otherMonthlyIncome) * numberOfMonthWorking;
		int taxableIncome = annualIncome - deductible - nonTaxableIncome;
		int tax = (int) Math.round(TAX_RATE * taxableIncome);

		return Math.max(tax, 0);
	}
}
