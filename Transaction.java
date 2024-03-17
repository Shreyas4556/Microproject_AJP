import java.awt.*;
import java.awt.EventQueue;
import java.awt.event.*;
import javax.swing.*;

public class Transaction extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton Deposit_Btn,Withdraw_Btn,PINCh_Btn,FastCash_Btn,MiniStmt_Btn,CheckBal_Btn,Exit_Btn;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Transaction frame = new Transaction("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	String pin;
	public Transaction(String pin) {
		this.pin=pin;
		setTitle("Transaction Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1550, 1080);
		setLocation(-5,0);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230,225,220));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
//		Label Select transaction
		JLabel Enter_amt_lab = new JLabel("Please Select Your Transaction.");
		Enter_amt_lab.setForeground(new Color(255, 255, 255));
		Enter_amt_lab.setFont(new Font("System", Font.BOLD, 22));
		Enter_amt_lab.setBounds(460, 166, 350, 35);
		contentPane.add(Enter_amt_lab);

//		Deosit Button
		Deposit_Btn = new JButton("Deposit");
		Deposit_Btn.setBackground(new Color(0, 128, 128));
		Deposit_Btn.setForeground(new Color(255, 255, 255));
		Deposit_Btn.setFont(new Font("Raleway", Font.BOLD, 17));
		Deposit_Btn.setBounds(402, 270, 173, 35);
		contentPane.add(Deposit_Btn);
		
//		Cash Withdraw button
		Withdraw_Btn = new JButton("Cash Withdraw");
		Withdraw_Btn.setForeground(Color.WHITE);
		Withdraw_Btn.setFont(new Font("Dialog", Font.BOLD, 17));
		Withdraw_Btn.setBackground(new Color(0, 128, 128));
		Withdraw_Btn.setBounds(684, 270, 173, 35);
		contentPane.add(Withdraw_Btn);
		
//		PIN Change Button
		PINCh_Btn = new JButton("PIN Change");
		PINCh_Btn.setForeground(Color.WHITE);
		PINCh_Btn.setFont(new Font("Dialog", Font.BOLD, 17));
		PINCh_Btn.setBackground(new Color(0, 128, 128));
		PINCh_Btn.setBounds(402, 360, 173, 35);
		contentPane.add(PINCh_Btn);
		
//		Fast Cash Button
		FastCash_Btn = new JButton("Fast Cash");
		FastCash_Btn.setForeground(Color.WHITE);
		FastCash_Btn.setFont(new Font("Dialog", Font.BOLD, 17));
		FastCash_Btn.setBackground(new Color(0, 128, 128));
		FastCash_Btn.setBounds(402, 315, 173, 35);
		contentPane.add(FastCash_Btn);
		
//		Mini Statement Button
		MiniStmt_Btn = new JButton("Mini Statement");
		MiniStmt_Btn.setForeground(Color.WHITE);
		MiniStmt_Btn.setFont(new Font("Dialog", Font.BOLD, 17));
		MiniStmt_Btn.setBackground(new Color(0, 128, 128));
		MiniStmt_Btn.setBounds(684, 315, 173, 35);
		contentPane.add(MiniStmt_Btn);
		
//		Check Balance Button
		CheckBal_Btn =new JButton("Balance Enquiry");
		CheckBal_Btn.setForeground(Color.WHITE);
		CheckBal_Btn.setFont(new Font("Dialog", Font.BOLD, 17));
		CheckBal_Btn.setBackground(new Color(0, 128, 128));
		CheckBal_Btn.setBounds(684, 360, 173, 35);
		contentPane.add(CheckBal_Btn);
		
//		Exit button
		Exit_Btn = new JButton("Exit");
		Exit_Btn.setForeground(Color.WHITE);
		Exit_Btn.setFont(new Font("Dialog", Font.BOLD, 17));
		Exit_Btn.setBackground(Color.red);
		Exit_Btn.setBounds(684, 410, 173, 35);
		contentPane.add(Exit_Btn);
		
//		ATM Image
		ImageIcon atm=new ImageIcon(Login_page.class.getResource("/Images/atm2.png"));
		Image img1=atm.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
		ImageIcon fortopl=new ImageIcon(img1);
		JLabel Top_logo = new JLabel(fortopl);
		Top_logo.setBounds(0, 0, 1550, 830);
		contentPane.add(Top_logo);
		
//		Regestering buttons
		Deposit_Btn.addActionListener(this);
		Withdraw_Btn.addActionListener(this);
		PINCh_Btn.addActionListener(this);
		FastCash_Btn.addActionListener(this);
		MiniStmt_Btn.addActionListener(this);
		CheckBal_Btn.addActionListener(this);
		Exit_Btn.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==Deposit_Btn) {
			Deposit ob1=new Deposit(pin);
			ob1.show();
			this.dispose();
		}else if(e.getSource()==Withdraw_Btn) {
			Withdrawl ob2=new Withdrawl(pin);
			ob2.show();
			dispose();
		}else if(e.getSource()==PINCh_Btn) {
			Change_PIN ob3=new Change_PIN(pin);
			ob3.show();
			dispose();
		}else if(e.getSource()==FastCash_Btn) {
			Fast_Cash ob4=new Fast_Cash(pin);
			ob4.show();
			dispose();
			
		}else if(e.getSource()==MiniStmt_Btn) {
			Mini_Stmt ob5=new Mini_Stmt(pin);
			ob5.show();
			dispose();
		}else if(e.getSource()==CheckBal_Btn) {
			Balance_Enquiry ob6=new Balance_Enquiry(pin);
			ob6.show();
			dispose();
		}else if(e.getSource()==Exit_Btn) {
			System.exit(0);
		}
	}
}
