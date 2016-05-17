
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MBAlogin {

	public MBAlogin() throws NumberFormatException, IOException {

		this.MBAloginRoute();
	}

	public static void main(String[] args) { try {
					MBAlogin starta = new MBAlogin(); 
		} catch (NumberFormatException e) { // Quick and dirty way to handle
											// unexpected input given by the
											// user
			System.out.println("oops... it was not a number!");
		} catch (IOException e) {
			System.out.println("oops... something went wrong getting the numbers!");
		}
	}

	public void MBAloginRoute() throws NumberFormatException, IOException { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		int uresponse = Integer.parseInt(br.readLine()); 

		if (uresponse == 1) { // use input (integer) to decide what the user
								// wants
			System.out.println("");
			System.out.println("Please insert your username:");
			BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in)); 
			
			MyBodyAPK.uname = br1.readLine();

			try (BufferedReader br2 = new BufferedReader(new FileReader("users.txt"))) { 
				
				String line = null;
				int found = 0;
				while ((line = br2.readLine()) != null) {
					if (line.equals(MyBodyAPK.uname)) {
						// Fill variable with the username, if the username
						// exists this username is then used to log in the
						// database
						found++;
					}
				}
				if (found == 1) { // Give error if username does not exists, and
									// return to StartMenu
					System.out.println("Username " + MyBodyAPK.uname + " has been found, login succesfull");
				} else {
					System.out.println("Username " + MyBodyAPK.uname + " has not been found, login not succesfull");
					System.out.println("Please press 1 to login with username, press 2 to login anonymously");
					this.MBAloginRoute();
				}

			}

		} else if (uresponse == 2) { // Provide option to use the application
										// anonymously
			System.out.println("");
			System.out.println("You will be using MyBodyAPK anonimously");
			MyBodyAPK.uname = "Anonimous";
		} else { // catch not viable input and let user return to start menu
			System.out.println("Please choose between 1 or 2");
			this.MBAloginRoute();
		}

	}
}
