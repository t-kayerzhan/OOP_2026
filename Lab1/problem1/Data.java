package problem1;

public class Data {
	
	private double sum;
	private double maxi;
	private int cnt;
	
	public Data() {
		sum = 0;
		maxi = Double.NEGATIVE_INFINITY;
		cnt = 0;
	}
	
	public void Add(double num) {
		sum += num;
		cnt++;
		if(maxi < num) maxi = num;
	}

	public double Avrg() {
		if(cnt == 0) return 0;
		return sum/cnt;
	}
	
	public double Max() {
		return maxi;
	}
	
}
