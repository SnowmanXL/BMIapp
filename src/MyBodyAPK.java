
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class MyBodyAPK {
	private PrintWriter pw;
	public int uresponse = 0;
	public static String uname;
	public static String password;
	public static String StartMenu = "StartMenu.txt";
	public static String MainMenu = "MainMenu.txt";
	public static int GenderScore;
	public static int MassMean;

	public MyBodyAPK() throws NumberFormatException, IOException {
		this.readFile();
		this.DispMenuText(StartMenu);
		this.loginprocedure();
		this.DispMenuText(MainMenu);
		this.MainMenu();
	}

	public static void main(String[] args) {
		try {
			MyBodyAPK start = new MyBodyAPK();
		} catch (NumberFormatException e) {
			System.out.println("oops... it was not a number!");
		} catch (IOException e) {
			System.out.println("oops... something went wrong getting the numbers!");
		}
	}

	public void readFile() throws IOException {
		String filename = "bmi_db.txt";
		File f = new File(filename);
		if (!f.exists()) {
			f.createNewFile();
		}
		FileWriter fw = new FileWriter(filename, true);
		BufferedWriter bw = new BufferedWriter(fw);
		this.pw = new PrintWriter(bw);
	}

	public void DispMenuText(String FileName) throws FileNotFoundException, IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(FileName))) {
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		}
	}

	public void loginprocedure() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int uresponse = Integer.parseInt(br.readLine());

		if (uresponse == 1) {
			System.out.println("");
			System.out.println("Please insert your username:");
			BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
			MyBodyAPK.uname = br1.readLine();

			System.out.println("Please insert your password:");
			BufferedReader br11 = new BufferedReader(new InputStreamReader(System.in));
			MyBodyAPK.password = br11.readLine();

			new PwValidator();

			System.out.println(PwValidator.resptruecount);
			if (PwValidator.SQLresponse == true && PwValidator.resptruecount == 1) {

				System.out.println("Welcome " + uname);
			} else {
				System.out.println("Your password and / or username are incorrect please try again");
				System.out.println("Press 1 to login with a username, press 2 to login anonymous");
				this.loginprocedure();
			}

		} else if (uresponse == 2) {
			System.out.println("Please insert your desired username:");
			BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
			MyBodyAPK.uname = br2.readLine();

			System.out.println("Please insert your desired password:");
			BufferedReader br22 = new BufferedReader(new InputStreamReader(System.in));
			MyBodyAPK.password = br22.readLine();

			new NewUser(MyBodyAPK.uname, MyBodyAPK.password);
			new MyBodyAPK();

		} else { // catch not viable input and let user return to start menu
			System.out.println("Please choose between 1 or 2");
			this.loginprocedure();
		}

	}

	public void MainMenu() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int uresponse = Integer.parseInt(br.readLine());

		if (uresponse == 1) {
			this.BMIcalculation();
		} else if (uresponse == 2) {
			// Dashboard Functionality
		} else if (uresponse == 3) {
			// Settings Functionality
		} else if (uresponse == 4) {
			new MyBodyAPK();
		}

	}

	public void BMIcalculation() throws NumberFormatException, IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please " + MyBodyAPK.uname + " insert your weight in kilograms");
		double weight = Double.parseDouble(br.readLine());
		System.out.println("Please " + MyBodyAPK.uname + " insert your length in centimeters");
		double length = Double.parseDouble(br.readLine());
		double BMI = this.calculateBMI(weight, length);
		try (FileWriter fw = new FileWriter("bmi_db.txt", true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw)) {
			out.println(MyBodyAPK.uname + "|" + weight + "|" + length + "|" + BMI);
		} catch (IOException e) {
		}
		System.out.println("Debug info: Weight = " + weight + " Length = " + length);
		System.out.println("Your BMI = " + BMI);
		System.out.println("");
		System.out.println(" ------------------------ ");
		
		
		
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
		
		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please " + MyBodyAPK.uname + " insert your middlespan in centimeters");
		double MiddleSpan = Double.parseDouble(br2.readLine());
		
		BufferedReader br4 = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please " + MyBodyAPK.uname + " insert your gender (Man or Woman)");
		String gender = br4.readLine();
		
		
		if (gender.equals("man" ) || gender.equals("Man")) {
			if (MiddleSpan < 102) {
				GenderScore = 1;
			} else if (MiddleSpan >= 102) {
				GenderScore = 2;
			}
		} else if (gender.equals("Woman" ) || gender.equals("woman")) {
			if (MiddleSpan < 88) {
				GenderScore = 1;
			} else if (MiddleSpan >= 88) {
				GenderScore = 2;
			}
		}
			
		int sum = MassMean + GenderScore;
		
		if (sum == 2 || sum == 3 || sum == 4 && MassMean == 2) {
			System.out.println("Geen verhoogd risico");
		} else if (sum == 4 && MassMean == 3) { 
			System.out.println("Verhoogd risico");
		}	else if (sum == 5) { 
			System.out.println("Hoog risico");
		}	else if (sum == 6 || sum == 7) { 
			System.out.println("Zeer hoog risico");
		}

		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("Press 1 to calculate your BMI again, press 2 go back to the main menu");
		
		BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
		int response = Integer.parseInt(br3.readLine());
		if (response == 1) {
			this.BMIcalculation();
		} else if (response == 2) {
			MyBodyAPK start3 = new MyBodyAPK();
		} else {
			this.MainMenu();
		}
	

	}

	public double calculateBMI(double weight, double length) {
		return Math.round((weight / ((length * length) / 10000)) * 100) / 100;
	}

	public void writeFile(String appendText) throws IOException {
		this.pw.println(appendText);
	}

}
