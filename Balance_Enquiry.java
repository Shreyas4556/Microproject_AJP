import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;

public class Balance_Enquiry extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JLabel AmtShow_lab;
	private JButton Withdraw_btn,Back_btn;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Balance_Enquiry frame = new Balance_Enquiry("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	String pin;
	public Balance_Enquiry(String p) {
		this.pin=p;
		setTitle("Balance Enquiry");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1550, 1080);
		setLocation(-5,0);
		setResizable(false);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Data_Lab = new JLabel("Your Current Balance Is :");
		Data_Lab.setForeground(new Color(255, 255, 255));
		Data_Lab.setFont(new Font("System", Font.BOLD, 20));
		Data_Lab.setBounds(469, 180, 333, 35);
		contentPane.add(Data_Lab);

		//Enter amount Label
		AmtShow_lab = new JLabel("");
		AmtShow_lab.setForeground(new Color(255, 255, 255));
		AmtShow_lab.setFont(new Font("System", Font.BOLD, 20));
		AmtShow_lab.setBounds(494, 225, 281, 35);
		contentPane.add(AmtShow_lab);
		
		//Back button
		Back_btn = new JButton("BACK");
		Back_btn.setForeground(Color.WHITE);
		Back_btn.setFont(new Font("Dialog", Font.BOLD, 18));
		Back_btn.setBackground(new Color(0, 128, 128));
		Back_btn.setBounds(715, 357, 146, 37);
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
		
		int balance=0;
		try {
			JDBCConn conn=new JDBCConn();
			ResultSet resultset=conn.stmt.executeQuery("select * from Transactions where PIN_No='"+pin+"'");
			while(resultset.next()) {
				if(resultset.getString("Type").equals("Deposit")) {
					balance+=Integer.parseInt(resultset.getString("Amount"));
				}else {
					balance-=Integer.parseInt(resultset.getString("Amount"));
				}
			}
			AmtShow_lab.setText(""+balance);
			Transaction ob=new Transaction(pin);
			ob.show();
			dispose();
		}catch(Exception E) {
			E.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==Back_btn) {
		Transaction home2=new Transaction(pin);
		home2.show();
		dispose();
		}
	}

}
