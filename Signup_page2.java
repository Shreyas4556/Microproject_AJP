import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Signup_page2 extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JComboBox Religion_combo,Category_combo,Income_combo,Education_combo,Occupation_combo;
	private JTextField panNo_txt,AadharNo_txt;
	private JRadioButton yes,no,acc_yes,acc_no;
	private JButton Next_btn;
	
//	Regex Prepration
//	1. Pan no
	String Pan_reg="\\d{10}";
	String Aadhar_reg="\\d{12}";

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup_page2 frame = new Signup_page2("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public String formno;

	public Signup_page2(String Form_no) {
		formno=Form_no;
		setTitle("Signup Page 2- Additional Details");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 800);
		setLocation(360,20);
		setResizable(false);

//		Content pane
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setBackground(new Color(230,225,220));
		
//		Setting logo
		ImageIcon topl=new ImageIcon(Login_page.class.getResource("/Images/bank.png"));
		Image img1=topl.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon fortopl=new ImageIcon(img1);
		contentPane.setLayout(null);
		JLabel Top_logo = new JLabel(fortopl);
		Top_logo.setBounds(150, 10, 100, 100);
		contentPane.add(Top_logo);

//		Additional Details Label
		JLabel AdditionalInfo_lab = new JLabel("Additional Details");
		AdditionalInfo_lab.setFont(new Font("Raleway", Font.BOLD, 28));
		AdditionalInfo_lab.setBounds(300, 34, 237, 30);
		contentPane.add(AdditionalInfo_lab);
		
//		Page no Label
		JLabel PageNo_lab = new JLabel("Page No: 2");
		PageNo_lab.setFont(new Font("Raleway", Font.PLAIN, 20));
		PageNo_lab.setBounds(300, 90, 120, 30);
		contentPane.add(PageNo_lab);
		
//		Form No Label
		JLabel FormNo_lab = new JLabel("Form No :"+Form_no);
		FormNo_lab.setFont(new Font("Raleway", Font.BOLD, 20));
		FormNo_lab.setBounds(640, 93, 150, 25);
		contentPane.add(FormNo_lab);
		
//		1. Religion Label
		JLabel Religion_lab = new JLabel("Religion :");
		Religion_lab.setFont(new Font("Raleway", Font.BOLD, 20));
		Religion_lab.setBounds(100, 160, 100, 30);
		contentPane.add(Religion_lab);
		
//		Religion Combobox
		String religion[]= {"Select Here","Hindu","Muslim","Sikh","Cristian","Other"};
		Religion_combo = new JComboBox(religion);
		Religion_combo.setToolTipText("Select Religion");
		Religion_combo.setFont(new Font("Raleway", Font.PLAIN, 16));
		Religion_combo.setBackground(new Color(230,225,220));
		Religion_combo.setBounds(300, 160, 395, 30);
		contentPane.add(Religion_combo);
		
//		2. Category Label
		JLabel Category_lab = new JLabel("Category :");
		Category_lab.setFont(new Font("Raleway", Font.BOLD, 20));
		Category_lab.setBounds(100, 220, 100, 30);
		contentPane.add(Category_lab);
		
//		Category combobox
		String category[]= {"Select Here","General","OBC","SC","ST","Other"};
		Category_combo = new JComboBox(category);
		Category_combo.setToolTipText("Select Religion Category");
		Category_combo.setFont(new Font("Raleway", Font.PLAIN, 16));
		Category_combo.setBackground(new Color(230,225,220));
		Category_combo.setBounds(300, 220, 395, 30);
		contentPane.add(Category_combo);
		
//		3. Income Label
		JLabel Income_lab = new JLabel("Income :");
		Income_lab.setFont(new Font("Raleway", Font.BOLD, 20));
		Income_lab.setBounds(100, 280, 100, 30);
		contentPane.add(Income_lab);
		
//		Income combobox
		String income[]= {"Select Here","Null","<1,50,000","<2,50,000","<5,00,000","upto 10,00,000","Above 10,00,000"};
		Income_combo = new JComboBox(income);
		Income_combo.setToolTipText("Select Your Income");
		Income_combo.setFont(new Font("Raleway", Font.PLAIN, 16));
		Income_combo.setBackground(new Color(230,225,220));
		Income_combo.setBounds(300, 280, 395, 30);
		contentPane.add(Income_combo);
		
//		4. Education Label
		JLabel Education_lab = new JLabel("Education :");
		Education_lab.setFont(new Font("Raleway", Font.BOLD, 20));
		Education_lab.setBounds(100, 340, 120, 30);
		contentPane.add(Education_lab);
		
//		Education combobox
		String Education[]= {"Select Here","Non-Graduate","Graduate","Post-Graduate","Doctrate","Other"};
		Education_combo = new JComboBox(Education);
		Education_combo.setToolTipText("Select Your Education");
		Education_combo.setFont(new Font("Raleway", Font.PLAIN, 16));
		Education_combo.setBackground(new Color(230,225,220));
		Education_combo.setBounds(300, 340, 395, 30);
		contentPane.add(Education_combo);
		
//		5. Occupation Label
		JLabel Occupation_lab = new JLabel("Occupation :");
		Occupation_lab.setFont(new Font("Raleway", Font.BOLD, 20));
		Occupation_lab.setBounds(100, 400, 120, 30);
		contentPane.add(Occupation_lab);
		
//		Occupation combobox
		String Occupation[]= {"Select Here","Salaried","Self-Employeed","Business","Student","Retired","Other"};
		Occupation_combo = new JComboBox(Occupation);
		Occupation_combo.setToolTipText("Select Your Occpation");
		Occupation_combo.setFont(new Font("Raleway", Font.PLAIN, 16));
		Occupation_combo.setBackground(new Color(230,225,220));
		Occupation_combo.setBounds(300, 400, 395, 30);
		contentPane.add(Occupation_combo);
		
//		6. Pan Number
		JLabel panNo_lab = new JLabel("PAN No :");
		panNo_lab.setFont(new Font("Raleway", Font.BOLD, 20));
		panNo_lab.setBounds(100, 460, 120, 30);
		contentPane.add(panNo_lab);
		
//		PAN No textfield
		panNo_txt= new JTextField(20);
		panNo_txt.setToolTipText("Enter 10 digit PAN Number");
		panNo_txt.setFont(new Font("Raleway", Font.PLAIN, 16));
		panNo_txt.setBounds(300, 460, 395, 30);
		contentPane.add(panNo_txt);
		
//		7. Aadhar No Label
		JLabel AadharNo_lab = new JLabel("Aadhar No :");
		AadharNo_lab.setFont(new Font("Raleway", Font.BOLD, 20));
		AadharNo_lab.setBounds(100, 520, 120, 30);
		contentPane.add(AadharNo_lab);
		
//		Aadhar No textfield
		AadharNo_txt= new JTextField(20);
		AadharNo_txt.setToolTipText("Enter 12 digit Aadhar number");
		AadharNo_txt.setFont(new Font("Raleway", Font.PLAIN, 16));
		AadharNo_txt.setBounds(300, 520, 395, 30);
		contentPane.add(AadharNo_txt);
		
//		8. Senior citizen Label
		JLabel Citizen_lab = new JLabel("Senior Citizen :");
		Citizen_lab.setFont(new Font("Raleway", Font.BOLD, 20));
		Citizen_lab.setBounds(100, 580, 150, 30);
		contentPane.add(Citizen_lab);
		
//		Yes or no radio button
		yes=new JRadioButton("Yes");
		yes.setFont(new Font("Raleway", Font.PLAIN, 16));
		yes.setBackground(new Color(230,225,220));
		yes.setBounds(322, 581, 100, 30);
		contentPane.add(yes);
		
		no=new JRadioButton("No");
		no.setFont(new Font("Raleway", Font.PLAIN, 16));
		no.setBackground(new Color(230,225,220));
		no.setBounds(474, 581, 100, 30);
		contentPane.add(no);
		
//		Making only on selection
		ButtonGroup grp=new ButtonGroup();
		grp.add(yes);
		grp.add(no);
		
//		9. Existing account Label
		JLabel ExAcc_lab = new JLabel("Existing Account :");
		ExAcc_lab.setFont(new Font("Raleway", Font.BOLD, 20));
		ExAcc_lab.setBounds(100, 640, 180, 30);
		contentPane.add(ExAcc_lab);
		
//		Yes or no radio button
		acc_yes=new JRadioButton("Yes");
		acc_yes.setFont(new Font("Raleway", Font.PLAIN, 16));
		acc_yes.setBackground(new Color(230,225,220));
		acc_yes.setBounds(322, 641, 100, 30);
		contentPane.add(acc_yes);
		
		acc_no=new JRadioButton("No");
		acc_no.setFont(new Font("Raleway", Font.PLAIN, 16));
		acc_no.setBackground(new Color(230,225,220));
		acc_no.setBounds(474, 641, 100, 30);
		contentPane.add(acc_no);
		
//		Making only on selection
		ButtonGroup acc_grp=new ButtonGroup();
		acc_grp.add(acc_yes);
		acc_grp.add(acc_no);
		
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
		String Religion,Category,Income,Education,Occupation,PAN,Aadhar,Senior_Citizen,Ex_Acc;
//		1. Religion
		Religion="";
		if(Religion_combo.getSelectedIndex()==0) {
			Religion="";
		}else if(Religion_combo.getSelectedIndex()==1) {
			Religion="Hindu";
		}else if(Religion_combo.getSelectedIndex()==2) {
			Religion="Muslim";
		}else if(Religion_combo.getSelectedIndex()==3) {
			Religion="Sikh";
		}else if(Religion_combo.getSelectedIndex()==4) {
			Religion="Cristian";
		}else if(Religion_combo.getSelectedIndex()==5) {
			Religion="Other";
		}
		
//		2. category
		Category="";
		if(Category_combo.getSelectedIndex()==0) {
			Category="";
		}else if(Category_combo.getSelectedIndex()==1) {
			Category="General";
		}else if(Category_combo.getSelectedIndex()==2) {
			Category="OBC";
		}else if(Category_combo.getSelectedIndex()==3) {
			Category="SC";
		}else if(Category_combo.getSelectedIndex()==4) {
			Category="ST";
		}else if(Category_combo.getSelectedIndex()==5) {
			Category="Other";
		}
		
//		3. income
		Income="";
		if(Income_combo.getSelectedIndex()==0) {
			Income="";
		}else if(Income_combo.getSelectedIndex()==1) {
			Income="Null";
		}else if(Income_combo.getSelectedIndex()==2) {
			Income="<1,50,000";
		}else if(Income_combo.getSelectedIndex()==3) {
			Income="<2,50,000";
		}else if(Income_combo.getSelectedIndex()==4) {
			Income="<5,00,000";
		}else if(Income_combo.getSelectedIndex()==5) {
			Income="upto 10,00,000";
		}else if(Income_combo.getSelectedIndex()==6) {
			Income="Above 10,00,000";
		}
		
//		4. Education
		Education="";
		if(Education_combo.getSelectedIndex()==0) {
			Education="";
		}else if(Education_combo.getSelectedIndex()==1) {
			Education="Non-Graduate";
		}else if(Education_combo.getSelectedIndex()==2) {
			Education="Graduate";
		}else if(Education_combo.getSelectedIndex()==3) {
			Education="Post-Graduate";
		}else if(Education_combo.getSelectedIndex()==4) {
			Education="Doctrate";
		}else if(Education_combo.getSelectedIndex()==5) {
			Education="Other";
		}
		
//		5. Occupation
		Occupation="";
		if(Occupation_combo.getSelectedIndex()==0) {
			Occupation="";
		}else if(Occupation_combo.getSelectedIndex()==1) {
			Occupation="Salaried";
		}else if(Occupation_combo.getSelectedIndex()==2) {
			Occupation="Self-Employeed";
		}else if(Occupation_combo.getSelectedIndex()==3) {
			Occupation="Business";
		}else if(Occupation_combo.getSelectedIndex()==4) {
			Occupation="Student";
		}else if(Occupation_combo.getSelectedIndex()==5) {
			Occupation="Retired";
		}else if(Occupation_combo.getSelectedIndex()==5) {
			Occupation="Other";
		}
		
//		6. PAN Number
		PAN=panNo_txt.getText();
		
//		7. Aadhar Number
		Aadhar=AadharNo_txt.getText();
		
//		8. Senior Citizen
		Senior_Citizen="";
		if(yes.isSelected()==true) {
			Senior_Citizen="Yes";
		}else {
			Senior_Citizen="No";
		}

//		9. Existance Account
		Ex_Acc="";
		if(acc_yes.isSelected()==true) {
			Ex_Acc="Yes";
		}else {
			Ex_Acc="No";
		}
		
		int check=1;
//		Validation
		if(Religion.equals("")||Category.equals("")||Income.equals("")||Education.equals("")||Occupation.equals("")||PAN.equals("")||Aadhar.equals("") ||Senior_Citizen.equals("")||Ex_Acc.equals("")) {
			JOptionPane.showMessageDialog(null,"Please Enter Your Full Details.");
			check=0;
		}
		else {
//		1. PAN Number Validation
			if(PAN.matches(Pan_reg)==false) {
				JOptionPane.showMessageDialog(null,"Please Enter Valid PAN Number.");
				check=0;
			}
//		2. Aadher number validation
			if(Aadhar.matches(Aadhar_reg)==false) {
				JOptionPane.showMessageDialog(null,"Please Enter Valid Aadhar Number.");
				check=0;
			}
		}
		
//		Insertion
		try{
			if(check==1) {
				JDBCConn conn=new JDBCConn();
				String querry="insert into SignUp2_Tab values('"+formno+"','"+Religion+"','"+Category+"','"+Income+"','"+Education+"','"+Occupation+"','"+PAN+"','"+Aadhar+"','"+Senior_Citizen+"','"+Ex_Acc+"')";
				conn.stmt.executeUpdate(querry);
				JOptionPane.showMessageDialog(null,"Data Saved Sucessfully.");
				Signup_page3 ob=new Signup_page3(formno);
				ob.show();
				dispose();
			}
		}catch(Exception E) {
			E.printStackTrace();
		}
	}
}
