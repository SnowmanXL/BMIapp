import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	JComboBox<String> GenderSelect = new JComboBox<>(GenderList);
	
	//AdviseScreen Components
	JLabel BMIResultLabel = new JLabel("Your BMI Score is: ");
	JLabel BMIResult = new JLabel();
	JLabel AdviseResultLabel = new JLabel("Your risk of having hearth and vascular disease is: ");
	JLabel AdviseResult = new JLabel();
	JButton AnotherBMICalculation = new JButton("Redo BMI Calculation");
	JButton AdviseBackToMain = new JButton("Back to Main Menu");
	
	//Frame Layout
	CardLayout cl = new CardLayout();

	
	public ApplicationStructure() {
		//Setting Layout Master Window
		panelCont.setLayout(cl);
		panelCont.setPreferredSize(new Dimension(800, 300));
		
		//adding components to frames
		//StartMenu Frame
		StartMenu.add(Login);
		StartMenu.add(RegisterNewUser);
		
		//InlogScreen Frame
		InlogScreen.add(InlogNameLabel);
		InlogScreen.add(InlogName);
		InlogScreen.add(PasswordLabel);
		InlogScreen.add(Password);
		InlogScreen.add(LoginEnter);
		InlogScreen.add(BackToMainMenu);
		
		//RegisterScreen Frame
		RegisterScreen.add(InlogNameLabelReg);
		RegisterScreen.add(InlogNameReg);
		RegisterScreen.add(PasswordLabelReg);
		RegisterScreen.add(PasswordReg);
		RegisterScreen.add(RegisterEnterReg);
		RegisterScreen.add(BackToMainMenuReg);
		
		//MainMenu Frame
		MainMenu.add(MainBMICalculator);
		MainMenu.add(MainDashboard);
		MainMenu.add(MainSettings);
		MainMenu.add(MainLogout);
		
		//BMICalculation Frame
		BMIfillerScreen.add(BMIWeightLabel);
		WeigthField.setValue(WLMFormat);
		WeigthField.setColumns(20);
		BMIfillerScreen.add(WeigthField);
		BMIfillerScreen.add(BMILengthLabel);
		LengthField.setValue(WLMFormat);
		LengthField.setColumns(20);
		BMIfillerScreen.add(LengthField);
		BMIfillerScreen.add(BMIMiddleSpanLabel);
		MiddleSpanField.setValue(WLMFormat);
		MiddleSpanField.setColumns(20);
		BMIfillerScreen.add(MiddleSpanField);
		BMIfillerScreen.add(BMIage);
		BMIfillerScreen.add(AgeField);
		AgeField.setColumns(20);
		BMIfillerScreen.add(GenderSelect);
		BMIfillerScreen.add(BMIEnter);
		BMIfillerScreen.add(BMIBackToMain);
		
		//AdviseScreen
		AdviseScreen.add(BMIResultLabel);
		AdviseScreen.add(BMIResult);
		AdviseScreen.add(AdviseResultLabel);
		AdviseScreen.add(AdviseResult);
		AdviseScreen.add(AnotherBMICalculation);
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
				Gender = String.valueOf(GenderSelect.getSelectedItem());
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
		
		
		frame.add(panelCont);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new ApplicationStructure();
			}
		});
	}

}