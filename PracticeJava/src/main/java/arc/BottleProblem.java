package arc;

public class BottleProblem {

	public int totalBottles = 0;
	public int remainder = 0;

	public void calculateTotalBottles(int drinkCounts, int exchangeBase) {
		totalBottles += drinkCounts;
		int emptyBottlesCanbeDrinkOut = drinkCounts;
		int totalEmptyBottles = emptyBottlesCanbeDrinkOut + this.remainder;
		int countsCanBeChange = totalEmptyBottles / exchangeBase;
		if(countsCanBeChange > 0) {
			this.remainder = 0;
			int remainder = totalEmptyBottles % exchangeBase;
			this.remainder = remainder;
			this.calculateTotalBottles(countsCanBeChange, exchangeBase);
		} else {
			int remainder = totalEmptyBottles % exchangeBase;
			this.remainder = remainder;
		}

	}

	public int getTotalBottles() {
		return totalBottles;
	}

	public void setTotalBottles(int totalBottles) {
		this.totalBottles = totalBottles;
	}

	public int getRemainder() {
		return remainder;
	}

	public void setRemainder(int remainder) {
		this.remainder = remainder;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BottleProblem bp = new BottleProblem();
		bp.calculateTotalBottles(1000, 2);
		System.out.println(bp.getTotalBottles());
		System.out.println(bp.getRemainder());
	}

}
