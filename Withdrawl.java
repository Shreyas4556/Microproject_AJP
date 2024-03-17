import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton Back_btn,Withdraw_btn;
	private JTextField Enter_amt_txt;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Withdrawl frame = new Withdrawl("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	String pin;
	public Withdrawl(String p) {
		this.pin=p;
		setTitle("Deposit- Additional Details");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1550, 1080);
		setLocation(-5,0);
		setResizable(false);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		JLabel Data_Lab = new JLabel("Maximum Withdrawal is Rs.10000");
		Data_Lab.setForeground(new Color(255, 255, 255));
		Data_Lab.setFont(new Font("System", Font.BOLD, 20));
		Data_Lab.setBounds(469, 180, 333, 35);
		contentPane.add(Data_Lab);

		//Enter amount Label
		JLabel Enter_amt_lab = new JLabel("Please Enter Your Amount:");
		Enter_amt_lab.setForeground(new Color(255, 255, 255));
		Enter_amt_lab.setFont(new Font("System", Font.BOLD, 20));
		Enter_amt_lab.setBounds(494, 225, 281, 35);
		contentPane.add(Enter_amt_lab);
		
		//TextField to enter amount
		Enter_amt_txt = new JTextField();
		Enter_amt_txt.setToolTipText("Enter Withdrawal Amount");
		Enter_amt_txt.setFont(new Font("Raleway", Font.PLAIN, 16));
		Enter_amt_txt.setBackground(new Color(65,125,128));
		Enter_amt_txt.setForeground(new Color(255, 255, 255));
		Enter_amt_txt.setBounds(462, 282, 340, 25);
		contentPane.add(Enter_amt_txt);

		//Deposit Button
		Withdraw_btn = new JButton("WITHDRAW");
		Withdraw_btn.setBackground(new Color(0, 128, 128));
		Withdraw_btn.setForeground(new Color(255, 255, 255));
		Withdraw_btn.setFont(new Font("Raleway", Font.BOLD, 18));
		Withdraw_btn.setBounds(715, 357, 146, 37);
		contentPane.add(Withdraw_btn);
		Withdraw_btn.addActionListener(this);

		//Back button
		Back_btn = new JButton("BACK");
		Back_btn.setForeground(Color.WHITE);
		Back_btn.setFont(new Font("Dialog", Font.BOLD, 18));
		Back_btn.setBackground(new Color(0, 128, 128));
		Back_btn.setBounds(715, 404, 146, 37);
		Back_btn.addActionListener(this);
		contentPane.add(Back_btn);

		//ATM Image
		ImageIcon atm=new ImageIcon(Login_page.class.getResource("/Images/atm2.png"));
		Image img1=atm.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
		ImageIcon fortopl=new ImageIcon(img1);
		JLabel Top_logo = new JLabel(fortopl);
		Top_logo.setToolTipText("");
		Top_logo.setBounds(10, -12, 1550, 830);
		contentPane.add(Top_logo);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int check=1;
		try {
		String amt=Enter_amt_txt.getText();
		Date date=new Date();
		int balance=0;
		if(e.getSource()==Withdraw_btn) {
			if(amt.equals("")) {
				JOptionPane.showMessageDialog(null,"Please Enter The Amount You Want To Withdrawl.");
			}else {
				JDBCConn conn=new JDBCConn();
				ResultSet resultset=conn.stmt.executeQuery("select * from Transactions where PIN_No='"+pin+"'");
				while(resultset.next()) {
					if(resultset.getString("Type").equals("Deposit")) {
						String bal="";
						balance+=Integer.parseInt(resultset.getString("Amount"));
					}else {
						balance-=Integer.parseInt(resultset.getString("Amount"));
					}
				}
				try {
					if(balance < Integer.parseInt(amt)) {
						JOptionPane.showMessageDialog(null,"Insufficient Balance");
						check=0;
					}
					if(check==1) {
						conn.stmt.executeUpdate("insert into Transactions values('"+pin+"','"+date+"','Withdrawl','"+amt+"')");
						JOptionPane.showMessageDialog(null,"Rs. "+amt+" Debited Sucessfully");
						Transaction ob1=new Transaction(pin);
						ob1.show();
						dispose();
					}
				}catch(Exception a) {
					a.printStackTrace();
				}
			}
		}
		}catch(Exception E) {
			E.printStackTrace();
		}
//		Back Button
		if(e.getSource()==Back_btn){
			Transaction home=new Transaction(pin);
			home.show();
			dispose();
		}
	}
}
