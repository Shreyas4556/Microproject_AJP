import java.awt.EventQueue;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Login_page extends JFrame implements ActionListener{

	public JPanel contentPane;
	private JTextField cardNo_txt;
	public JPasswordField pinNo_txt;
	public JButton signin_btn,clear_btn,signup_btn;
	
//	Regex
	String Card_reg="\\d{16}";
	String Pin_reg1="\\d{4}";
	String Pin_reg2="\\d{3}";
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_page frame = new Login_page();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}	

	public Login_page() {
		setTitle("ATM Simulation Syatem");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 500);
		setLocation(350,200);
		contentPane = new JPanel();
		setResizable(false);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
//		Top bank logo
		ImageIcon topl=new ImageIcon(Login_page.class.getResource("/Images/bank.png"));
		Image img1=topl.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon fortopl=new ImageIcon(img1);
		JLabel Top_logo = new JLabel(fortopl);
		Top_logo.setBounds(375, 10, 100, 100);
		contentPane.add(Top_logo);
		
//		Below image of card
		ImageIcon card=new ImageIcon(Login_page.class.getResource("/Images/card.png"));
		Image img3=card.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon forcard=new ImageIcon(img3);
		JLabel below = new JLabel(forcard);
		below.setBounds(630, 370, 100, 100);
		contentPane.add(below);
		
//		Welcome label
		JLabel welcome_lab = new JLabel("WEL-COME TO ATM");
		welcome_lab.setFont(new Font("AvantGarde", Font.BOLD, 38));
		welcome_lab.setForeground(new Color(255, 255, 255));
		welcome_lab.setBounds(240, 125, 382, 40);
		contentPane.add(welcome_lab);
		
//		Card no label
		JLabel cardNo = new JLabel("Card No :");
		cardNo.setFont(new Font("Ralway", Font.BOLD, 28));
		cardNo.setForeground(new Color(255, 255, 255));
		cardNo.setBounds(150, 190, 150, 30);
		contentPane.add(cardNo);
		
//		Card no textfield
		cardNo_txt = new JTextField();
		cardNo_txt.setToolTipText("Enter your card number");
		cardNo_txt.setBounds(325, 190, 337, 30);
		cardNo_txt.setFont(new Font("Arial", Font.BOLD, 18));
		contentPane.add(cardNo_txt);
		cardNo_txt.setColumns(20);
		
//		Pin no label
		JLabel pinNo = new JLabel("Pin No :");
		pinNo.setFont(new Font("Ralway", Font.BOLD, 28));
		pinNo.setForeground(new Color(255, 255, 255));
		pinNo.setBounds(150, 250, 150, 30);
		contentPane.add(pinNo);
		
//		Pin no password field
		pinNo_txt = new JPasswordField();
		pinNo_txt.setToolTipText("Enter yout password");
		pinNo_txt.setBounds(325, 250, 337, 30);
		pinNo_txt.setFont(new Font("Arial", Font.BOLD, 18));
		contentPane.add(pinNo_txt);
		
//		Sign in button
		signin_btn = new JButton("SignIn");
		
//		Added action listener
		signin_btn.addActionListener(this);
		signin_btn.setBackground(new Color(0, 128, 128));
		signin_btn.setForeground(new Color(255, 255, 255));
		signin_btn.setFont(new Font("Arial", Font.BOLD, 14));
		signin_btn.setBounds(297, 320, 128, 30);
		contentPane.add(signin_btn);
		
//		Clear button
		clear_btn = new JButton("Clear");
		
//		Added action listener
		clear_btn.addActionListener(this);
		clear_btn.setBackground(new Color(0, 128, 128));
		clear_btn.setForeground(new Color(255, 255, 255));
		clear_btn.setFont(new Font("Arial", Font.BOLD, 14));
		clear_btn.setBounds(472, 320, 135, 30);
		contentPane.add(clear_btn);
		
//		Sign up button
		signup_btn = new JButton("Sign Up");
		
//		Added action listener
		signup_btn.addActionListener(this);
		signup_btn.setBackground(new Color(0, 128, 128));
		signup_btn.setForeground(new Color(255, 255, 255));
		signup_btn.setFont(new Font("Arial", Font.BOLD, 14));
		signup_btn.setBounds(325, 370, 255, 30);
		contentPane.add(signup_btn);
		
//		Background image
		ImageIcon backimg=new ImageIcon(Login_page.class.getResource("/Images/backbg.png"));
		Image img2=backimg.getImage().getScaledInstance(850, 480, Image.SCALE_DEFAULT);
		ImageIcon forbackimg=new ImageIcon(img2);
		JLabel BackImg = new JLabel(forbackimg);		
		BackImg.setBounds(0, 0, 850, 480);
		contentPane.add(BackImg);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String cardno=cardNo_txt.getText();
		String PIN=pinNo_txt.getText();
		if(e.getSource()==signin_btn) {
			if(cardNo_txt.equals("") || pinNo_txt.equals("")) {
				JOptionPane.showMessageDialog(null, "Please Enter Full Details");
			}
			else if(cardno.matches(Card_reg) && (PIN.matches(Pin_reg1) || PIN.matches(Pin_reg2)) ) {			
				try {
					JDBCConn conn=new JDBCConn();
					String querry="select * from Login_Tab where Card_No='"+cardno+"' and PIN_No='"+PIN+"'";
					ResultSet resultset=conn.stmt.executeQuery(querry);
					if(resultset.next()) {
						dispose();
						Transaction ob=new Transaction(PIN);
						ob.show();
					}
					else {
						JOptionPane.showMessageDialog(null, "Incorrect Card Number and PIN");
					}
				}
				catch(Exception E) {
					E.printStackTrace();
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Please Enter Data in Proper Format");
			}
		}
		else if(e.getSource()==signup_btn) {
			Signup_page ob2=new Signup_page();
			ob2.show();
			dispose();
		}
		else if(e.getSource()==clear_btn) {
			cardNo_txt.setText("");
			pinNo_txt.setText("");
		}
	}
	
}
