import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser; //package for calander
import java.util.Random;
import java.awt.event.*;

public class Signup_page extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JDateChooser DOB_cal;
	private JTextField Name_txt,FName_txt,Email_txt,City_txt,PinCode_txt,State_txt;
	private JRadioButton Male_radioBtn,Female_radioBtn,OtherGen_radioBtn;
	private JTextArea Address_txt;
	private JButton Next_btn;
	private JComboBox MaritalComboBox;

//	Regex Prepration
//	1. UserName and Father's Name
	String Name_reg="\\p{Upper}(\\p{Lower}+\\s?) \\p{Upper}(\\p{Lower}+\\s?) \\p{Upper}(\\p{Lower}+\\s?)";
//	2. Email 
	String Email_reg="^[a-zA-z0-9_+&*-]+(?:\\."+"a-zA-Z0-9_+&*-]+)*@"+"(?:[a-zA-Z0-9-]+\\.)[a-zA-Z]{2,7}$";
//	3. Pin Code 
	String PIN_reg="\\d{6}";
//	Creating random form number automatically
	Random rand=new Random();
	long dig4=(rand.nextLong(10000)%9000L)+1000L;
	String formno=""+Math.abs(dig4);
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup_page frame = new Signup_page();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Signup_page() {
		setTitle("Signup Page 1- personal Details");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 800);
		setLocation(360,20);
		setResizable(false);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setBackground(new Color(230,225,220));
		
//		top bank logo
		ImageIcon topl=new ImageIcon(Login_page.class.getResource("/Images/bank.png"));
		Image img1=topl.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon fortopl=new ImageIcon(img1);
		contentPane.setLayout(null);
		JLabel Top_logo = new JLabel(fortopl);
		Top_logo.setBounds(25, 10, 100, 100);
		contentPane.add(Top_logo);
		
//		Application form number label
		JLabel Title_lab = new JLabel("Application Form Number : "+formno);
		Title_lab.setBounds(161, 20, 600, 40);
		Title_lab.setFont(new Font("Raleway",Font.BOLD,38));
		contentPane.add(Title_lab);
		
//		Page No label
		JLabel PageNo_lab = new JLabel("Page No: 1");
		PageNo_lab.setBounds(161, 80, 122, 30);
		PageNo_lab.setFont(new Font("Raleway", Font.PLAIN, 20));
		contentPane.add(PageNo_lab);
		
//		Personal Details label
		JLabel Personal_info_lab = new JLabel("Personal Details");
		Personal_info_lab.setBounds(318, 105, 174, 30);
//		Personal_info_lab.setForeground(UIManager.getColor("CheckBox.focus"));
		Personal_info_lab.setFont(new Font("Raleway",Font.BOLD,22));
		contentPane.add(Personal_info_lab);
		
//		Start Collecting data
//		1. Name Label
		JLabel Name_lab = new JLabel("Name :");
		Name_lab.setBounds(100, 160, 100, 30);
		Name_lab.setFont(new Font("Raleway",Font.BOLD,20));
		contentPane.add(Name_lab);
		
//		Name TextField
		Name_txt = new JTextField();
		Name_txt.setToolTipText("Enter your full name");
		Name_txt.setBounds(300, 160, 400, 30);
		Name_txt.setFont(new Font("Raleway",Font.PLAIN,16));
		contentPane.add(Name_txt);
		Name_txt.setColumns(20);
		
//		2. Fathers Name Label
		JLabel FName_lab = new JLabel("Father's Name :");
		FName_lab.setBounds(100, 210, 165, 30);
		FName_lab.setFont(new Font("Raleway",Font.BOLD,20));
		contentPane.add(FName_lab);
		
//		Name TextField
		FName_txt = new JTextField();
		FName_txt.setToolTipText("Enter your father's full name");
		FName_txt.setBounds(300, 210, 400, 30);
		FName_txt.setFont(new Font("Raleway",Font.PLAIN,16));
		contentPane.add(FName_txt);
		FName_txt.setColumns(20);
		
//		3. Gender Label
		JLabel Gender_lab = new JLabel("Gender :");
		Gender_lab.setBounds(100, 260, 100, 30);
		Gender_lab.setFont(new Font("Raleway",Font.BOLD,20));
		contentPane.add(Gender_lab);
		
//		Male Female Others Gendera Radio buttons creation
		Male_radioBtn = new JRadioButton("Male");
		Male_radioBtn.setBounds(300, 260, 100, 30);
		Male_radioBtn.setFont(new Font("Raleway",Font.PLAIN,16));
		Male_radioBtn.setBackground(new Color(230,225,220));
		contentPane.add(Male_radioBtn);
		
		Female_radioBtn = new JRadioButton("Female");
		Female_radioBtn.setBounds(444, 260, 100, 30);
		Female_radioBtn.setFont(new Font("Raleway",Font.PLAIN,16));
		Female_radioBtn.setBackground(new Color(230,225,220));
		contentPane.add(Female_radioBtn);
		
		OtherGen_radioBtn = new JRadioButton("Others");
		OtherGen_radioBtn.setBounds(597, 260, 100, 30);
		OtherGen_radioBtn.setFont(new Font("Raleway",Font.PLAIN,16));
		OtherGen_radioBtn.setBackground(new Color(230,225,220));
		contentPane.add(OtherGen_radioBtn);
		
//		Making group of radio buttons for allowing single selection
		ButtonGroup gen=new ButtonGroup();
		gen.add(Male_radioBtn);
		gen.add(Female_radioBtn);
		gen.add(OtherGen_radioBtn);
		
//		4. Date Of Birth Label
		JLabel DOB_lab = new JLabel("Date Of Birth :");
		DOB_lab.setBounds(100, 310, 146, 30);
		DOB_lab.setFont(new Font("Raleway",Font.BOLD,20));
		contentPane.add(DOB_lab);
		
//		Date of birth calender creation
		DOB_cal = new JDateChooser();
		DOB_cal.setToolTipText("Enter/select your valid date of birth");
		DOB_cal.setBounds(300, 310, 400, 30);
		DOB_cal.setForeground(new Color(105,105,105));
		contentPane.add(DOB_cal);
		
//		5. Email Address Label
		JLabel Email_lab = new JLabel("Email Address :");
		Email_lab.setBounds(100, 360, 155, 30);
		Email_lab.setFont(new Font("Raleway", Font.BOLD, 20));
		contentPane.add(Email_lab);
		
//		Email TextField
		Email_txt = new JTextField();
		Email_txt.setToolTipText("Enter your valid E-mail Address");
		Email_txt.setBounds(300, 360, 400, 30);
		Email_txt.setFont(new Font("Raleway", Font.PLAIN, 16));
		Email_txt.setColumns(20);
		contentPane.add(Email_txt);
		
//		6. Marital Status label
		JLabel MarridStatus_lab = new JLabel("Marital Status :");
		MarridStatus_lab.setBounds(100, 410, 155, 30);
		MarridStatus_lab.setFont(new Font("Raleway", Font.BOLD, 20));
		contentPane.add(MarridStatus_lab);
		
//		Combobox for marital status
		String arrOfMarried[]= {"Select here","Married","Unmarried","Other"};  //Array of options
		MaritalComboBox = new JComboBox(arrOfMarried);
		MaritalComboBox.setToolTipText("Secelct your Marital status");
		MaritalComboBox.setBounds(300, 410, 400, 30);
		MaritalComboBox.setFont(new Font("Raleway", Font.PLAIN, 16));
		contentPane.add(MaritalComboBox);
		
//		7. Address Label
		JLabel Address_lab = new JLabel("Address :");
		Address_lab.setBounds(100, 460, 100, 30);
		Address_lab.setFont(new Font("Raleway", Font.BOLD, 20));
		contentPane.add(Address_lab);
		
//		TextArea for address with scrollpane
		Address_txt = new JTextArea();
		Address_txt.setToolTipText("Enter your living address");
		Address_txt.setFont(new Font("Raleway", Font.PLAIN, 16));
		int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
		JScrollPane sp=new JScrollPane(v,h);
		sp.setBounds(300, 460, 400, 60);
		sp.setViewportView(Address_txt);
		contentPane.add(sp);
		
//		8. City Label
		JLabel City_lab = new JLabel("City Name  :");
		City_lab.setFont(new Font("Raleway", Font.BOLD, 20));
		City_lab.setBounds(100, 540, 122, 30);
		contentPane.add(City_lab);
		
//		TextField For city
		City_txt = new JTextField();
		City_txt.setToolTipText("Enter your city name");
		City_txt.setFont(new Font("Raleway", Font.PLAIN, 16));
		City_txt.setColumns(20);
		City_txt.setBounds(300, 540, 400, 30);
		contentPane.add(City_txt);
		
//		9. Pin code label
		JLabel PinCode_lab = new JLabel("Pin Code :");
		PinCode_lab.setFont(new Font("Raleway", Font.BOLD, 20));
		PinCode_lab.setBounds(100, 590, 105, 30);
		contentPane.add(PinCode_lab);
		
//		pin code textfield
		PinCode_txt = new JTextField();
		PinCode_txt.setToolTipText("Enter your city pin code");
		PinCode_txt.setFont(new Font("Raleway", Font.PLAIN, 16));
		PinCode_txt.setColumns(20);
		PinCode_txt.setBounds(300, 590, 400, 30);
		contentPane.add(PinCode_txt);
		
//		10. State Label
		JLabel  State_lab = new JLabel("State :");
		State_lab.setFont(new Font("Raleway", Font.BOLD, 20));
		State_lab.setBounds(100, 640, 82, 30);
		contentPane.add(State_lab);
		
//		State TextField
		State_txt = new JTextField();
		State_txt.setToolTipText("Enter your state");
		State_txt.setFont(new Font("Raleway", Font.PLAIN, 16));
		State_txt.setColumns(20);
		State_txt.setBounds(300, 640, 400, 30);
		contentPane.add(State_txt);
		
		
//		Next button
		Next_btn = new JButton("Next");
		Next_btn.setToolTipText("Click here to go next page");
		
//		Added action listener
		Next_btn.addActionListener(this);
		Next_btn.setBackground(new Color(0, 128, 128));
		Next_btn.setForeground(new Color(255, 255, 255));
		Next_btn.setFont(new Font("Raleway", Font.BOLD, 20));
		Next_btn.setBounds(600,690,95,30);
		contentPane.add(Next_btn);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String Form_no=formno;		//getting Form number
		String userName=Name_txt.getText();		//getting User Name
		String FName=FName_txt.getText();		//getting father's name
		
//		getting date of birth from calander
		String DOB=((JTextField)DOB_cal.getDateEditor().getUiComponent()).getText();
		
//		Getting gender from radiobutton
		String Gender="";
		if(Male_radioBtn.isSelected()) {
			Gender="Male";
		}
		else if(Female_radioBtn.isSelected()) {
			Gender="Female";
		}
		else if(OtherGen_radioBtn.isSelected()) {
			Gender="Others";
		}
		
//		Getting marital status
		String marrage="";
		if(MaritalComboBox.getSelectedIndex()==1) {
			marrage="Married";
		}else if(MaritalComboBox.getSelectedIndex()==2){
			marrage="Unmarried";
		}else if(MaritalComboBox.getSelectedIndex()==3) {
			marrage="Other";
		}
		
		String address=Address_txt.getText();		//getting address
		String email=Email_txt.getText();		//getting email
		String City=City_txt.getText();		//getting city name
		String pincode=PinCode_txt.getText();		//getting pincode
		String State=State_txt.getText();		//getting state name
		
		int check=1;
//		1. User name validation
		if(userName.equals("") || FName.equals("") || DOB.equals("") || Gender.equals("") || email.equals("") || marrage.equals("") || address.equals("") || City.equals("") || pincode.equals("") || State.equals("")) {
			JOptionPane.showMessageDialog(null,"Please Enter Your Full Details.");
			check=0;
		}else {
			if(userName.matches(Name_reg)==false) {
				JOptionPane.showMessageDialog(null,"Please Enter Your Full Name In Proper Format.");
				check=0;
			}
//		2. Father's Name Validation
			if(FName.matches(Name_reg)==false) {
				JOptionPane.showMessageDialog(null,"Please Enter Your Father's Full Name In Proper Format.");
				check=0;
			}
//		3. Email Validation
			if(email.matches(Email_reg)==false) {
				JOptionPane.showMessageDialog(null,"Please Enter Valid E-mail ID.");
				check=0;
			}
//		4. PinCode Validation
			if(pincode.matches(PIN_reg)==false) {
				JOptionPane.showMessageDialog(null,"Please Enter Valid PIN Code.");
				check=0;
			}
		}
		try {
			if(check==1) {
				JDBCConn conn=new JDBCConn();
				String querry="insert into SignUp_Tab values('"+Form_no+"','"+userName+"','"+FName+"','"+DOB+"','"+Gender+"','"+email+"','"+marrage+"','"+address+"','"+City+"','"+pincode+"','"+State+"')";
				conn.stmt.executeUpdate(querry);
				JOptionPane.showMessageDialog(null,"Data Saved Sucessfully.");
				Signup_page2 ob=new Signup_page2(Form_no);
				ob.show();
				dispose();
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}