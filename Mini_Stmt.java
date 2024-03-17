import java.awt.event.*;
import java.sql.ResultSet;
import java.awt.*;
import javax.swing.*;

public class Mini_Stmt extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton Btn;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mini_Stmt frame = new Mini_Stmt("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	String pin;
	public Mini_Stmt(String p) {
		this.pin=p;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 600);
		setLocation(20,20);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(227,225,225));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel dateTime=new JLabel("");
		dateTime.setFont(new Font("System",Font.PLAIN,16));
		dateTime.setBounds(21,147,443,243);
		contentPane.add(dateTime);
		
		JLabel ATMName=new JLabel("SSS Online ATM");
		ATMName.setFont(new Font("System",Font.BOLD,22));
		ATMName.setBounds(156,10,180,40);
		contentPane.add(ATMName);
		
		JLabel card=new JLabel("Card Number : xxxxxxxxxxxx");
		card.setFont(new Font("System",Font.PLAIN,16));
		card.setBounds(35,82,281,25);
		contentPane.add(card);
		
		JLabel Amount_Lab = new JLabel();
		Amount_Lab.setFont(new Font("System",Font.PLAIN,16));
		Amount_Lab.setBounds(35, 418, 317, 33);
		contentPane.add(Amount_Lab);
		Amount_Lab.setText("Your Current Balance is Rs. :");
		try {
			JDBCConn conn=new JDBCConn();
			ResultSet rset=conn.stmt.executeQuery("select * from Login_Tab where PIN_No = '"+pin+"'");
			String cardno=card.getText();
			while(rset.next()) {
				card.setText(cardno+rset.getString(2).substring(12));
				
			}
		}catch(Exception E) {
			E.printStackTrace();
		}
		
		try {
			int balance=0;
			JDBCConn conn=new JDBCConn();
			ResultSet rset=conn.stmt.executeQuery("select * from Transactions where PIN_No='"+pin+"'");
			while(rset.next()) {
				dateTime.setText(dateTime.getText()+"<html>"+rset.getString("Date_Time")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rset.getString("Type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rset.getString("Amount")+"<br><br><html>");
				
				if(rset.getString("Type").equals("Deposit")) {
					balance+=Integer.parseInt(rset.getString("Amount"));
				}else {
					balance-=Integer.parseInt(rset.getString("Amount"));
				}
			}
			
//			Displaying Current amount
			String amt=Amount_Lab.getText();
			Amount_Lab.setText(amt+balance);
		}catch(Exception e) {
			e.printStackTrace();
		}
//		Exit button
		Btn=new JButton("Exit");
		Btn.setBackground(new Color(0, 128, 128));
		Btn.setForeground(new Color(255, 255, 255));
		Btn.setFont(new Font("Raleway", Font.BOLD, 18));
		Btn.setBounds(60,489,100,33);
		Btn.addActionListener(this);
		contentPane.add(Btn);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Transaction home=new Transaction(pin);
		home.show();
		dispose();
	}
}
