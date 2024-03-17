import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

public class Deposit extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton Back_btn_1,Deposit_btn;
	private JTextField Enter_amt_txt;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deposit frame = new Deposit("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	String pin;
	public Deposit(String PIN_No) {
		this.pin=PIN_No;
		setTitle("Deposit- Additional Details");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1550, 1080);
		setLocation(-5,0);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
//		Enter amount Label
		JLabel Enter_amt_lab = new JLabel("Enter Amount You Want To Deposit");
		Enter_amt_lab.setForeground(new Color(255, 255, 255));
		Enter_amt_lab.setFont(new Font("System", Font.BOLD, 18));
		Enter_amt_lab.setBounds(469, 180, 333, 35);
		contentPane.add(Enter_amt_lab);
		
//		TextField to enter amount
		Enter_amt_txt = new JTextField();
		Enter_amt_txt.setToolTipText("Enter Amount to Deposit");
		Enter_amt_txt.setFont(new Font("Raleway", Font.PLAIN, 16));
		Enter_amt_txt.setBackground(new Color(65,125,128));
		Enter_amt_txt.setForeground(new Color(255, 255, 255));
		Enter_amt_txt.setBounds(460, 230, 340, 25);
		contentPane.add(Enter_amt_txt);
		
//		Deposit Button
		Deposit_btn = new JButton("DEPOSIT");
		Deposit_btn.setBackground(new Color(0, 128, 128));
		Deposit_btn.setForeground(new Color(255, 255, 255));
		Deposit_btn.setFont(new Font("Raleway", Font.BOLD, 18));
		Deposit_btn.setBounds(700, 360, 120, 37);
		contentPane.add(Deposit_btn);
		Deposit_btn.addActionListener(this);
		
//		Back button
		Back_btn_1 = new JButton("BACK");
		Back_btn_1.setForeground(Color.WHITE);
		Back_btn_1.setFont(new Font("Dialog", Font.BOLD, 18));
		Back_btn_1.setBackground(new Color(0, 128, 128));
		Back_btn_1.setBounds(700, 411, 120, 37);
		Back_btn_1.addActionListener(this);
		contentPane.add(Back_btn_1);

//		ATM Image
		ImageIcon atm=new ImageIcon(Login_page.class.getResource("/Images/atm2.png"));
		Image img1=atm.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
		ImageIcon fortopl=new ImageIcon(img1);
		JLabel Top_logo = new JLabel(fortopl);
		Top_logo.setBounds(0, 0, 1550, 830);
		contentPane.add(Top_logo);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String amount="";
		amount=Enter_amt_txt.getText();
		Date date=new Date();
		if(e.getSource()==Deposit_btn) {
			if(amount.equals("")) {
				JOptionPane.showMessageDialog(null, "Plese Enter Amount You Want To Deposit.");
			}
			else{
				try {
					JDBCConn conn=new JDBCConn();
					conn.stmt.executeUpdate("insert into Transactions values('"+pin+"','"+date+"','Deposit','"+amount+"')");
					JOptionPane.showMessageDialog(null,"Rs. "+amount+" Deposited Successfully");
					Transaction ob1=new Transaction(pin);
					ob1.show();
					dispose();
				}catch(Exception E) {
					E.printStackTrace();
				}
			}
		}
		else if(e.getSource()==Back_btn_1) {
			Transaction ob1=new Transaction(pin);
			ob1.show();
			dispose();
		}
	}
}
