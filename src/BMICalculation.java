
public class BMICalculation {
	
	public static int GenderScore;
	public static int MassMean;
	public static double BMI;
	public static String Risk;

		public BMICalculation(double weight, double length, double MiddleSpan, String Gender) {	
			
			BMI = this.calculateBMI(weight, length);	
			
			//Calculate  BMI Category test
			
			if (BMI <= 18.5) {
				MassMean = 1;
			} else if (BMI > 18.5 && BMI <= 25){
				MassMean = 2;
			} else if (BMI > 25 && BMI <= 30){
				MassMean = 3;
			} else if (BMI > 30 && BMI <= 35){
				MassMean = 4;
			} else if (BMI > 35 ){
				MassMean = 5;
			} 			
			
			//Calculate Gender Score
			if (Gender.equals("man" ) || Gender.equals("Man")) {
				if (MiddleSpan < 102) {
					GenderScore = 1;
				} else if (MiddleSpan >= 102) {
					GenderScore = 2;
				}
			} else if (Gender.equals("Woman" ) || Gender.equals("woman")) {
				if (MiddleSpan < 88) {
					GenderScore = 1;
				} else if (MiddleSpan >= 88) {
					GenderScore = 2;
				}
			}
			
			//Calculate Risk Category
			int sum = MassMean + GenderScore;
			
			System.out.println("Debug: " + sum + " " + MassMean + " " + GenderScore);
			
			if (sum == 2 || sum == 3 || sum == 4 && MassMean == 2) {
				Risk = "Geen verhoogd risico";
			} else if (sum == 4 && MassMean == 3) { 
				Risk = "Verhoogd risico";
			}	else if (sum == 5) { 
				Risk = "Hoog risico";
			}	else if (sum == 6 || sum == 7) { 
				Risk = "Zeer hoog risico";
			}
		}
			public double calculateBMI(double weight, double length) {
				return Math.round((weight / ((length * length) / 10000)) * 100) / 100;
			}

	public static void main(String[] args) {
		

	}

}
