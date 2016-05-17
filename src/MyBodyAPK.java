import java.io.BufferedReader;                                                                                                                                                                                                                                // Import classes from library
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
 
                public MyBodyAPK() throws NumberFormatException, IOException {                                                                                     // Constructor of the Class. This has the executable functions which make up this program. The Functions are listed below.
                                this.readFile();                                                                                                                                                                                                                                                                  // Function which checks the existence of the logging database.
                                this.startMenu();                                                                                                                                                                                                                                                                             // Function which provides the startmenu text.
                                MBAlogin MBAlogin = new MBAlogin();                                                                                                                                                                                                 // Class > Handles login requests.
                                this.mainApp();                                                                                                                                                                                                                                                                                // Function which provides the BMI calculation and handles the closing of the program.
                }
 
                public static void main(String[] args) {                                                                                                                                                                     // This is were the Java Compiler / Virtual Machine starts executing this program.
                                try {
                                                MyBodyAPK start = new MyBodyAPK();                                                                                                                                                                                                // The only option of the 'main' is to start the constructor. See above for the constructor.
                                } catch (NumberFormatException e) {                                                                                                                                                                                    // This is an quick and dirty way to catch exceptions on expected input in the program.
                                                System.out.println("oops... it was not a number!");
                                } catch (IOException e) {                                                                                                                                                                                                                               // This is an quick and dirty way to catch exceptions on expected input  in the program.
                                                System.out.println("oops... something went wrong getting the numbers!");
                                }
                }
 
                public void readFile() throws IOException {                                                                                                                                                                          // Function. Check the existence of the database file
                                String filename = "bmi_db.txt";
                                File f = new File(filename);
                                if (!f.exists()) {                                                                                                                                                                                                                                                                   // If the file doesn't exist, a new file is created.
                                                f.createNewFile();                                                                                                                                                                                                                                          
                                }
                                FileWriter fw = new FileWriter(filename, true);                                                                                                                                                 // Prepares the file so that output can be written in the file.
                                BufferedWriter bw = new BufferedWriter(fw);
                                this.pw = new PrintWriter(bw);
                }
 
                public void startMenu() throws FileNotFoundException, IOException {                                                                   // Function to provide the start menu
                                try (BufferedReader br = new BufferedReader(new FileReader("StartMenu.txt"))) {                      // Look for a file named 'StartMenu.txt'
                                                String line = null;
                                                while ((line = br.readLine()) != null) {                                                                                                                                                      // As long as the file is not empty, the program prints every line available in the file
                                                                System.out.println(line);
                                                }
                                }
                }
 
                public void mainApp() throws NumberFormatException, IOException {                                                                  // Main function, provides the BMI calculation
 
                                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                                            // Look for user input
                                System.out.println("Please " + MyBodyAPK.uname + " insert your weight in kilograms");
                                double weight = Double.parseDouble(br.readLine());
                                System.out.println("Please " + MyBodyAPK.uname + " insert your length in centimeters");
                                double length = Double.parseDouble(br.readLine());
                                double BMI = this.calculateBMI(weight, length);                                                                                                                                                               // Call BMI function listed below, providing weight variable and lenght variable
                                try (FileWriter fw = new FileWriter("bmi_db.txt", true);                                                                                                // Write output of BMI function in the DataBase file.
                                                                BufferedWriter bw = new BufferedWriter(fw);
                                                                PrintWriter out = new PrintWriter(bw)) {
                                                out.println(MyBodyAPK.uname + "|" + weight + "|" + length + "|" + BMI);
                                } catch (IOException e) {
                                }
                                System.out.println("Debug info: Weight = " + weight + " Length = " + length);                     // Provide output to user on screen.
                                System.out.println("Your BMI = " + BMI);
                                System.out.println("");
                                System.out.println(" ------------------------ ");
                                System.out.println("");
                                System.out.println("Press 1 to calculate your BMI again, press 2 to logout, press any other number to exit the application");
                                BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));                                         // Look for input of user to either run the application again, logout or to exit the application
                                int response = Integer.parseInt(br1.readLine());
                                if (response == 1) {                                                                                                                                                                                                                                                         
                                                this.mainApp();
                                } else if (response == 2) {
                                                MyBodyAPK start3 = new MyBodyAPK();                                                                                                                                                                                             // Start the BMI function again to let user calculate BMI again
                                } else {
                                                System.exit(0);                                                                                                                                                                                                                                                                 // Exit the application
                                }
                               
                }
 
                public double calculateBMI(double weight, double length) {                                                                                                                        // BMI calculation
                                return Math.round((weight / ((length * length) / 10000)) * 100) / 100;                                                    // Calculates weight in kg / lenght in m ^2, rounded by 2 decimals.
                }

 
                public void writeFile(String appendText) throws IOException {                                                                                                   // Function to append text to a document
                                this.pw.println(appendText);
                }
}