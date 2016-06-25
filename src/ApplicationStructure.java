import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;



public class ApplicationStructure {
	//Global Variables
	public static String InlogNameStr;
	public static String InlogPasswordStr;
	public static int Weight;
	public static int Length;
	public static int MiddleSpan;
	public static String Gender;
	public static int Age;
	
	
	// Application Panes
	JFrame frame = new JFrame("BMIapp");
	JPanel panelCont = new JPanel();
	JPanel StartMenu = new JPanel();
	JPanel InlogScreen = new JPanel();
	JPanel RegisterScreen = new JPanel();
	JPanel MainMenu = new JPanel();
	JPanel ConfigScreen = new JPanel();
	JPanel DashScreen = new JPanel();
	JPanel BMIfillerScreen = new JPanel();
	JPanel AdviseScreen = new JPanel();
	
	//StartMenu Components
	JButton Login = new JButton("Login");
	JButton RegisterNewUser = new JButton("Register a new user");
	
	

	
	
	//InlogScreen Components
	JButton BackToMainMenu = new JButton("Back to Start Menu");
	JButton LoginEnter = new JButton("Enter");
	JLabel InlogNameLabel = new JLabel("InlogNaam");
	JLabel PasswordLabel = new JLabel("Password");
	protected JTextField InlogName = new JTextField(20);
	protected JPasswordField Password = new JPasswordField(20);
	
	//RegisterScreen Components
	JButton BackToMainMenuReg = new JButton("Back to Start Menu");
	JButton RegisterEnterReg = new JButton("Registeer");
	JLabel InlogNameLabelReg = new JLabel("InlogNaam");
	JLabel PasswordLabelReg = new JLabel("Password");
	protected JTextField InlogNameReg = new JTextField(20);
	protected JPasswordField PasswordReg = new JPasswordField(20);
	
	//MainMenu Components
	JButton MainBMICalculator = new JButton("Calculate my BMI");
	JButton MainDashboard = new JButton("My Dashboard");
	JButton MainSettings = new JButton("Settings");
	JButton MainLogout = new JButton("Logout");
	
	//BMIFillerScreen Components
	private NumberFormat WLMFormat;
	JButton BMIBackToMain = new JButton("Back to Main Menu");
	JButton BMIEnter =  new JButton("Calculate");
	JFormattedTextField WeigthField = new JFormattedTextField(WLMFormat);
	JFormattedTextField LengthField = new JFormattedTextField(WLMFormat);
	JFormattedTextField MiddleSpanField = new JFormattedTextField();
	JFormattedTextField AgeField = new JFormattedTextField();
	JLabel BMIWeightLabel = new JLabel("Please insert your weight in kilograms");
	JLabel BMILengthLabel = new JLabel("Please insert your length in centimeters");
	JLabel BMIMiddleSpanLabel = new JLabel("Please insert your middlespan in centimeters");
	JLabel BMIage = new JLabel("Please insert your age in years");
	String[] GenderList = new String[] {"Man", "Woman"};
	//JComboBox<String> GenderSelect = new JComboBox<>(GenderList);
	
	//AdviseScreen Components
	JLabel BMIResultLabel = new JLabel("Your BMI Score is: ");
	JLabel BMIResult = new JLabel();
	JLabel AdviseResultLabel = new JLabel("Your risk of having hearth and vascular disease is: ");
	JTextField AdviseResult = new JTextField();
	JButton AnotherBMICalculation = new JButton("Redo BMI Calculation");
	JButton AdviseBackToMain = new JButton("Back to Main Menu");
	
	//Frame Layout
	CardLayout cl = new CardLayout();

	
	public ApplicationStructure() throws IOException {
		//Setting Layout Master Window
		panelCont.setLayout(cl);
		panelCont.setPreferredSize(new Dimension(450, 300));
		StartMenu.setLayout(null);
		Login.setBounds(136, 11, 166, 23);
		
		//adding components to frames
		//StartMenu Frame
		BufferedImage myPicture = ImageIO.read(new File("C:\\Users\\Wilfred\\Documents\\workspace\\Health.jpg"));
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		picLabel.setBounds(0, 0, 450, 300);
		
		StartMenu.add(Login);
		RegisterNewUser.setBounds(136, 45, 166, 23);
		StartMenu.add(RegisterNewUser);
		InlogScreen.setLayout(null);
		InlogNameLabel.setBounds(41, 39, 77, 14);
		StartMenu.add(picLabel);
		
		//InlogScreen Frame
		InlogScreen.add(InlogNameLabel);
		InlogName.setBounds(128, 36, 166, 20);
		InlogScreen.add(InlogName);
		PasswordLabel.setBounds(41, 70, 77, 14);
		InlogScreen.add(PasswordLabel);
		Password.setBounds(128, 67, 166, 20);
		InlogScreen.add(Password);
		LoginEnter.setBounds(41, 95, 166, 23);
		InlogScreen.add(LoginEnter);
		BackToMainMenu.setBounds(41, 129, 166, 23);
		InlogScreen.add(BackToMainMenu);
		RegisterScreen.setLayout(null);
		InlogNameLabelReg.setBounds(38, 45, 87, 14);
		
		//RegisterScreen Frame
		RegisterScreen.add(InlogNameLabelReg);
		InlogNameReg.setBounds(135, 42, 166, 20);
		RegisterScreen.add(InlogNameReg);
		PasswordLabelReg.setBounds(38, 79, 87, 14);
		RegisterScreen.add(PasswordLabelReg);
		PasswordReg.setBounds(135, 76, 166, 20);
		RegisterScreen.add(PasswordReg);
		RegisterEnterReg.setBounds(38, 113, 152, 23);
		RegisterScreen.add(RegisterEnterReg);
		BackToMainMenuReg.setBounds(38, 147, 152, 23);
		RegisterScreen.add(BackToMainMenuReg);
		MainMenu.setLayout(null);
		MainBMICalculator.setBounds(134, 74, 176, 23);
		
		//MainMenu Frame
		MainMenu.add(MainBMICalculator);
		MainDashboard.setBounds(134, 109, 176, 23);
		MainMenu.add(MainDashboard);
		MainSettings.setBounds(134, 143, 176, 23);
		MainMenu.add(MainSettings);
		MainLogout.setBounds(134, 180, 176, 23);
		MainMenu.add(MainLogout);
		BMIfillerScreen.setLayout(null);
		BMIWeightLabel.setBounds(10, 70, 293, 14);
		
		//BMICalculation Frame
		BMIfillerScreen.add(BMIWeightLabel);
		WeigthField.setBounds(313, 67, 85, 20);
		WeigthField.setValue(WLMFormat);
		WeigthField.setColumns(20);
		BMIfillerScreen.add(WeigthField);
		BMILengthLabel.setBounds(10, 95, 293, 14);
		BMIfillerScreen.add(BMILengthLabel);
		LengthField.setBounds(313, 92, 85, 20);
		LengthField.setValue(WLMFormat);
		LengthField.setColumns(20);
		BMIfillerScreen.add(LengthField);
		BMIMiddleSpanLabel.setBounds(10, 120, 293, 14);
		BMIfillerScreen.add(BMIMiddleSpanLabel);
		MiddleSpanField.setBounds(313, 117, 85, 20);
		MiddleSpanField.setValue(WLMFormat);
		MiddleSpanField.setColumns(20);
		BMIfillerScreen.add(MiddleSpanField);
		BMIage.setBounds(10, 145, 293, 14);
		BMIfillerScreen.add(BMIage);
		AgeField.setBounds(313, 142, 85, 20);
		BMIfillerScreen.add(AgeField);
		AgeField.setColumns(20);
		BMIEnter.setBounds(10, 217, 166, 23);
		//BMIfillerScreen.add(GenderSelect);
		BMIfillerScreen.add(BMIEnter);
		BMIBackToMain.setBounds(10, 251, 166, 23);
		BMIfillerScreen.add(BMIBackToMain);
		AdviseScreen.setBackground(Color.WHITE);
		AdviseScreen.setLayout(null);
		BMIResultLabel.setBounds(10, 33, 107, 14);
		
		//AdviseScreen
		AdviseScreen.add(BMIResultLabel);
		BMIResult.setBounds(110, 33, 135, 14);
		AdviseScreen.add(BMIResult);
		AdviseResultLabel.setBounds(10, 58, 430, 14);
		AdviseScreen.add(AdviseResultLabel);
		AdviseResult.setEditable(false);
		AdviseResult.setBounds(10, 83, 430, 65);
		AdviseScreen.add(AdviseResult);
		AnotherBMICalculation.setBounds(10, 182, 170, 23);
		AdviseScreen.add(AnotherBMICalculation);
		AdviseBackToMain.setBounds(10, 159, 170, 23);
		AdviseScreen.add(AdviseBackToMain);
		
		//Setting Visuals of frames
		StartMenu.setBackground(Color.WHITE);
		InlogScreen.setBackground(Color.WHITE);
		RegisterScreen.setBackground(Color.WHITE);
		MainMenu.setBackground(Color.WHITE);
		BMIfillerScreen.setBackground(Color.WHITE);
		
		//Add Frames to WindowList
		panelCont.add(StartMenu, "1");
		panelCont.add(InlogScreen, "2");
		panelCont.add(RegisterScreen, "3");
		panelCont.add(MainMenu, "4");
		panelCont.add(BMIfillerScreen, "5");
		panelCont.add(AdviseScreen, "6");
		
		final JComboBox<String> genderselect = new JComboBox<String>();
		genderselect.setEditable(true);
		genderselect.setBounds(313, 173, 85, 20);
		genderselect.addItem("Man");
		genderselect.addItem("Woman");
		BMIfillerScreen.add(genderselect);
		
		
		//Start on StartMenu
		cl.show(panelCont, "1");
		
		
		//##########################################
		// ActionButtons
		//##########################################
		
		//Login Page Connection and actions
		Login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panelCont, "2");
			}
		});
		
		LoginEnter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				InlogNameStr =  InlogName.getText();
				InlogPasswordStr = String.valueOf(Password.getPassword());
				new PwValidator();
				if (PwValidator.SQLresponse == true && PwValidator.resptruecount == 1) {
					cl.show(panelCont, "4");		// Update to point to MainMenu --> Done
				} else { 
					System.exit(0);					// Update to give an error
				}
				
			}
		});
		
		BackToMainMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panelCont, "1");
			}
		});
		
		//Register Page Connection and actions
		RegisterNewUser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panelCont, "3");
			}
		});
		
		RegisterEnterReg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				InlogNameStr =  InlogNameReg.getText();
				InlogPasswordStr = String.valueOf(PasswordReg.getPassword());
				new NewUser(InlogNameStr, InlogPasswordStr);
				cl.show(panelCont, "1");
				
			}
		});
		
		BackToMainMenuReg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panelCont, "1");
			}
		});
		
		//MainMenu Page Connection and actions
		MainBMICalculator.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panelCont, "5");
			}
		});
		
		//BMICalculator Connection and actions
		BMIEnter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Debugging");
				Weight = Integer.parseInt(WeigthField.getText());
				Length = Integer.parseInt(LengthField.getText());
				MiddleSpan = Integer.parseInt(MiddleSpanField.getText());
				Object gender_select = genderselect.getSelectedItem();
				Gender = (String) genderselect.getSelectedItem();
				
				//Gender = String.valueOf(GenderSelect.getSelectedItem());
				
				Age = Integer.parseInt(AgeField.getText());
				
				System.out.println( " Debug: " + Weight + " " + Length + " "  + MiddleSpan + " "  + Gender + " " );
				new BMICalculation(Weight, Length, MiddleSpan, Gender);
				
				System.out.println(BMICalculation.BMI + " " + BMICalculation.Risk + " ");
				
				//AdviseResult.setText(BMICalculation.Risk);
				BMIResult.setText(String.valueOf(BMICalculation.BMI));
				
				new AdviseFetch();
				AdviseResult.setText(AdviseFetch.Advise);
				
				cl.show(panelCont, "6");
			}
		});
		
		BMIBackToMain.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panelCont, "4");
			}
		});
		
		//AdviseScreen Connection and actions
		AnotherBMICalculation.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panelCont, "5");
			}
		});
		
		AdviseBackToMain.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panelCont, "4");
			}
		});
		
		
		frame.getContentPane().add(panelCont);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
	}

	public static void main(String[] args) throws IOException {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					new ApplicationStructure();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
}