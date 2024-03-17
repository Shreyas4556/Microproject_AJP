import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;
import javax.swing.*;

public class Fast_Cash extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton FastCash_100,FastCash_200,FastCash_5000,FastCash_500,FastCash_1000,FastCash_10000,Back_Btn;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fast_Cash frame = new Fast_Cash("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	String pin;
	public Fast_Cash(String p) {
		this.pin=p;
		setTitle("Fast Cash");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1550, 1080);
		setLocation(-5,0);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);

		JLabel Data_Lab = new JLabel("Select Withdrawl Amount");
		Data_Lab.setForeground(new Color(255, 255, 255));
		Data_Lab.setFont(new Font("System", Font.BOLD, 26));
		Data_Lab.setBounds(477, 178, 333, 35);
		contentPane.add(Data_Lab);
		
//		Deosit Button
		FastCash_100 = new JButton("Rs. 100");
		FastCash_100.setBackground(new Color(0, 128, 128));
		FastCash_100.setForeground(new Color(255, 255, 255));
		FastCash_100.setFont(new Font("Raleway", Font.BOLD, 17));
		FastCash_100.setBounds(413, 259, 173, 35);
		contentPane.add(FastCash_100);
		
//		Cash Withdraw button
		FastCash_200 = new JButton("Rs. 500");
		FastCash_200.setForeground(Color.WHITE);
		FastCash_200.setFont(new Font("Dialog", Font.BOLD, 17));
		FastCash_200.setBackground(new Color(0, 128, 128));
		FastCash_200.setBounds(694, 259, 173, 35);
		contentPane.add(FastCash_200);
		
//		PIN Change Button
		FastCash_5000 = new JButton("Rs. 5000");
		FastCash_5000.setForeground(Color.WHITE);
		FastCash_5000.setFont(new Font("Dialog", Font.BOLD, 17));
		FastCash_5000.setBackground(new Color(0, 128, 128));
		FastCash_5000.setBounds(413, 349, 173, 35);
		contentPane.add(FastCash_5000);
		
//		Fast Cash Button
		FastCash_500 = new JButton("Rs. 1000");
		FastCash_500.setForeground(Color.WHITE);
		FastCash_500.setFont(new Font("Dialog", Font.BOLD, 17));
		FastCash_500.setBackground(new Color(0, 128, 128));
		FastCash_500.setBounds(413, 304, 173, 35);
		contentPane.add(FastCash_500);
		
//		Mini Statement Button
		FastCash_1000 = new JButton("Rs. 2000");
		FastCash_1000.setForeground(Color.WHITE);
		FastCash_1000.setFont(new Font("Dialog", Font.BOLD, 17));
		FastCash_1000.setBackground(new Color(0, 128, 128));
		FastCash_1000.setBounds(694, 304, 173, 35);
		contentPane.add(FastCash_1000);
		
//		Check Balance Button
		FastCash_10000 =new JButton("Rs. 10000");
		FastCash_10000.setForeground(Color.WHITE);
		FastCash_10000.setFont(new Font("Dialog", Font.BOLD, 17));
		FastCash_10000.setBackground(new Color(0, 128, 128));
		FastCash_10000.setBounds(694, 349, 173, 35);
		contentPane.add(FastCash_10000);
		
//		Exit button
		Back_Btn = new JButton("Back");
		Back_Btn.setForeground(Color.WHITE);
		Back_Btn.setFont(new Font("Dialog", Font.BOLD, 17));
		Back_Btn.setBackground(Color.red);
		Back_Btn.setBounds(694, 394, 173, 35);
		contentPane.add(Back_Btn);
		
//		ATM Image
		ImageIcon atm=new ImageIcon(Login_page.class.getResource("/Images/atm2.png"));
		Image img1=atm.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
		ImageIcon fortopl=new ImageIcon(img1);
		JLabel Top_logo = new JLabel(fortopl);
		Top_logo.setToolTipText("");
		Top_logo.setBounds(10, -12, 1550, 830);
		contentPane.add(Top_logo);
		
//		Regestering buttons
		FastCash_100.addActionListener(this);
		FastCash_200.addActionListener(this);
		FastCash_5000.addActionListener(this);
		FastCash_500.addActionListener(this);
		FastCash_1000.addActionListener(this);
		FastCash_10000.addActionListener(this);
		Back_Btn.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int check=1;
//		back button
		if(e.getSource()==Back_Btn) {
			Transaction ob1=new Transaction(pin);
			ob1.show();
			dispose();
		}
		else {
			String amount=((JButton)e.getSource()).getText().substring(4);
			Date date=new Date();
			JDBCConn conn=new JDBCConn();
			try {
				int balance=0;
				ResultSet rset=conn.stmt.executeQuery("select * from Transactions where PIN_No='"+pin+"'");
				while(rset.next()) {
					if(rset.getString("Type").equals("Deposit")) {
						balance+=Integer.parseInt(rset.getString("Amount"));
					}else {
						balance-=Integer.parseInt(rset.getString("Amount"));
					}
				}
				String num="17";
				if(e.getSource()!=Back_Btn && balance<Integer.parseInt(amount)) {
					JOptionPane.showMessageDialog(null, "Insufficient balance");
					check=0;
				}
				if(check==1) {
					conn.stmt.executeUpdate("insert into Transactions values('"+pin+"','"+date+"','Withdrawl','"+amount+"')");
					JOptionPane.showMessageDialog(null,"Rs. "+amount+" Debited Sucessfully");
					Transaction ob1=new Transaction(pin);
					ob1.show();
					dispose();
				}
			}catch(Exception E) {
				E.printStackTrace();
			}			
		}
	}
}
