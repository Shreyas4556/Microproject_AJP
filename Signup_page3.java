import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class Signup_page3 extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JRadioButton acc1,acc2,acc3,acc4;
	private JCheckBox ser1,ser2,ser3,ser4,ser5,ser6,termsAndCondn;
	private JButton submit,cancel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup_page3 frame = new Signup_page3("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	String formNo;
	public Signup_page3(String fno) {
		this.formNo=fno;
		setTitle("Signup Page 3- Additional Details");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 800);
		setLocation(360,20);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230,225,220));
		setContentPane(contentPane);
		
//		Setting logo
		ImageIcon topl=new ImageIcon(Login_page.class.getResource("/Images/bank.png"));
		Image img1=topl.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon fortopl=new ImageIcon(img1);
		contentPane.setLayout(null);
		JLabel Top_logo = new JLabel(fortopl);
		Top_logo.setBounds(150, 10, 100, 100);
		contentPane.add(Top_logo);
		
//		Account Details
		JLabel AccountInfo_lab = new JLabel("Account Details");
		AccountInfo_lab.setFont(new Font("Raleway", Font.BOLD, 28));
		AccountInfo_lab.setBounds(300, 44, 237, 30);
		contentPane.add(AccountInfo_lab);	
		
//		Page no Label
		JLabel PageNo_lab = new JLabel("Page No: 3");
		PageNo_lab.setFont(new Font("Raleway", Font.PLAIN, 20));
		PageNo_lab.setBounds(300, 95, 120, 30);
		contentPane.add(PageNo_lab);
		
//		Form number
		JLabel FormNo_lab = new JLabel("Form No :"+fno);
		FormNo_lab.setFont(new Font("Raleway", Font.BOLD, 20));
		FormNo_lab.setBounds(640, 93, 150, 25);
		contentPane.add(FormNo_lab);
		
//		1. Account type label
		JLabel AccType_lab = new JLabel("Account Type :");
		AccType_lab.setFont(new Font("Raleway", Font.BOLD, 20));
		AccType_lab.setBounds(100, 160, 150, 30);
		contentPane.add(AccType_lab);
		
//		Account type radio buttons
		acc1=new JRadioButton("Saving Account");
		acc1.setFont(new Font("Raleway", Font.PLAIN, 16));
		acc1.setBackground(new Color(230,225,220));
		acc1.setBounds(320, 160, 150, 30);
		contentPane.add(acc1);
		
		acc2=new JRadioButton("Fixed Deposit Account");
		acc2.setFont(new Font("Raleway", Font.PLAIN, 16));
		acc2.setBackground(new Color(230,225,220));
		acc2.setBounds(520, 160, 200, 30);
		contentPane.add(acc2);
		
		acc3=new JRadioButton("Current Account");
		acc3.setFont(new Font("Raleway", Font.PLAIN, 16));
		acc3.setBackground(new Color(230,225,220));
		acc3.setBounds(320, 220, 150, 30);
		contentPane.add(acc3);
		
		acc4=new JRadioButton("Recurring Deposit Account");
		acc4.setFont(new Font("Raleway", Font.PLAIN, 16));
		acc4.setBackground(new Color(230,225,220));
		acc4.setBounds(520, 220, 220, 30);
		contentPane.add(acc4);
		
//		Grouping rediobuttons
		ButtonGroup grp=new ButtonGroup();
		grp.add(acc1);
		grp.add(acc2);
		grp.add(acc3);
		grp.add(acc4);
		
//		2. Card Number Label
		JLabel CardNo_lab = new JLabel("Card Number :");
		CardNo_lab.setFont(new Font("Raleway", Font.BOLD, 20));
		CardNo_lab.setBounds(100, 280, 150, 30);
		contentPane.add(CardNo_lab);
		
		JLabel CardNoInfo_lab = new JLabel("( Your 16-digit Card Number )");
		CardNoInfo_lab.setFont(new Font("Raleway", Font.BOLD, 12));
		CardNoInfo_lab.setBounds(100, 310, 200, 30);
		contentPane.add(CardNoInfo_lab);
		
		JLabel CardNo16dig_lab = new JLabel("XXXX-XXXX-XXXX-4556");
		CardNo16dig_lab.setFont(new Font("Raleway", Font.PLAIN, 16));
		CardNo16dig_lab.setBounds(320, 280, 200, 30);
		contentPane.add(CardNo16dig_lab);
		
		JLabel CardNo16digInfo_lab = new JLabel("( It would appear on ATM Card/Cheque Book and Statemants )");
		CardNo16digInfo_lab.setFont(new Font("Dialog", Font.PLAIN, 12));
		CardNo16digInfo_lab.setBounds(320, 310, 350, 30);
		contentPane.add(CardNo16digInfo_lab);
		
//		3. Pin Number
		JLabel PinNo_lab = new JLabel("PIN :");
		PinNo_lab.setFont(new Font("Raleway", Font.BOLD, 20));
		PinNo_lab.setBounds(100, 370, 150, 30);
		contentPane.add(PinNo_lab);
		JLabel PINDetails = new JLabel("( Your 4-digit password )");
		PINDetails.setFont(new Font("Raleway", Font.BOLD, 12));
		PINDetails.setBounds(100, 400, 200, 30);
		contentPane.add(PINDetails);
		
//		Pin display
		JLabel PinNoShow_lab = new JLabel("XXXX");
		PinNoShow_lab.setFont(new Font("Raleway", Font.PLAIN, 16));
		PinNoShow_lab.setBounds(320, 370, 150, 30);
		contentPane.add(PinNoShow_lab);
		
//		4. Services Required
		JLabel Services_lab = new JLabel("Services Required :");
		Services_lab.setFont(new Font("Raleway", Font.BOLD, 20));
		Services_lab.setBounds(100, 460, 200, 30);
		contentPane.add(Services_lab);
		
//		Checkboxes for Services Required
		ser1=new JCheckBox("ATM Card");
		ser1.setFont(new Font("Raleway", Font.PLAIN, 16));
		ser1.setBackground(new Color(230,225,220));
		ser1.setBounds(320, 460, 150, 30);
		contentPane.add(ser1);
		
		ser2=new JCheckBox("Internet Banking");
		ser2.setFont(new Font("Raleway", Font.PLAIN, 16));
		ser2.setBackground(new Color(230,225,220));
		ser2.setBounds(520, 460, 150, 30);
		contentPane.add(ser2);
		
		ser3=new JCheckBox("Mobile Banking");
		ser3.setFont(new Font("Raleway", Font.PLAIN, 16));
		ser3.setBackground(new Color(230,225,220));
		ser3.setBounds(320, 520, 150, 30);
		contentPane.add(ser3);
		
		ser4=new JCheckBox("E-mail Alert");
		ser4.setFont(new Font("Raleway", Font.PLAIN, 16));
		ser4.setBackground(new Color(230,225,220));
		ser4.setBounds(520, 520, 150, 30);
		contentPane.add(ser4);
		
		ser5=new JCheckBox("Cheque Book");
		ser5.setFont(new Font("Raleway", Font.PLAIN, 16));
		ser5.setBackground(new Color(230,225,220));
		ser5.setBounds(320, 580, 150, 30);
		contentPane.add(ser5);
		
		ser6=new JCheckBox("E-Statement");
		ser6.setFont(new Font("Raleway", Font.PLAIN, 16));
		ser6.setBackground(new Color(230,225,220));
		ser6.setBounds(520, 580, 150, 30);
		contentPane.add(ser6);
		
		termsAndCondn=new JCheckBox("I here by declares that the above entered details correct to the best of my knowledge",true);
		termsAndCondn.setFont(new Font("Raleway", Font.BOLD, 12));
		termsAndCondn.setBackground(new Color(230,225,220));
		termsAndCondn.setBounds(100, 620, 520, 30);
		contentPane.add(termsAndCondn);
		
//		5. Submit Button
		submit=new JButton("Submit");
		submit.addActionListener(this);
		submit.setBackground(new Color(0, 128, 128));
		submit.setForeground(new Color(255, 255, 255));
		submit.setFont(new Font("Raleway", Font.BOLD, 20));
		submit.setBounds(300,690,100,30);
		contentPane.add(submit);
		
		cancel=new JButton("Cancel");
		cancel.addActionListener(this);
		cancel.setBackground(new Color(0, 128, 128));
		cancel.setForeground(new Color(255, 255, 255));
		cancel.setFont(new Font("Raleway", Font.BOLD, 20));
		cancel.setBounds(450,690,100,30);
		contentPane.add(cancel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String Acc_Type,Services,cardNo,PIN_No;
		
//		1. Account Type
		Acc_Type="";
		if(acc1.isSelected()==true) {
			Acc_Type="Saving Account";
		}else if(acc2.isSelected()==true) {
			Acc_Type="Fixed Deposit Account";
		}else if(acc3.isSelected()==true) {
			Acc_Type="Current Account";
		}else if(acc4.isSelected()==true) {
			Acc_Type="Recurring Deposit Account";
		}
		
//		2. Card Number
		Random rand=new Random();
		long First_7=(rand.nextLong() % 90000000L)+1409963000000000L;
		cardNo=""+Math.abs(First_7);
		
//		3. PIN Number
		long First_3=(rand.nextLong()%9000L)+1000L;
		PIN_No=""+Math.abs(First_3);
		
//		4. Services Required
		Services="";
		if(ser1.isSelected()==true) {
			Services=Services+" ATM Card";
		}if(ser2.isSelected()==true) {
			Services=Services+" Internet Banking";
		}if(ser3.isSelected()==true) {
			Services=Services+" Mobile Banking";
		}if(ser4.isSelected()==true) {
			Services=Services+" E-mail Alert";
		}if(ser5.isSelected()==true) {
			Services=Services+" Cheque Book";
		}if(ser6.isSelected()==true) {
			Services=Services+" E-Statement";
		}
		
		int check=1;
		try {
			if(e.getSource()==submit) {
				if(Acc_Type.equals("")||cardNo.equals("")||PIN_No.equals("")||Services.equals("")) {
					JOptionPane.showMessageDialog(null,"Please Enter Full Details.");
					check=0;
				}
				else {
					if(check==1) {
						JDBCConn conn=new JDBCConn();
						String querry1="insert into SignUp3_Tab values('"+4223+"','"+Acc_Type+"','"+cardNo+"','"+PIN_No+"','"+Services+"')";
						String querry2="insert into Login_Tab values('"+4223+"','"+cardNo+"','"+PIN_No+"')";
						conn.stmt.executeUpdate(querry1);
						conn.stmt.executeUpdate(querry2);
						JOptionPane.showMessageDialog(null,"Card Number : "+cardNo+"\nPIN Number : "+PIN_No);
						Transaction ob=new Transaction(PIN_No);
						ob.show();
						dispose();
					}
				}
			}else if(e.getSource()==cancel) {
				System.exit(0);
			}
		}catch(Exception E) {
			E.printStackTrace();
		}
		
	}

}
