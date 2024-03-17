import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Change_PIN extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton ChangePin_btn,Back_btn;
	private JPasswordField Old_PIN;
	private JPasswordField New_PIN;
	private JLabel NewPIN_Lab_1;
	private JLabel ReNewPIN_Lab;
	private JPasswordField RePIN_;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Change_PIN frame = new Change_PIN("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	String pin;
	public Change_PIN(String p) {
		this.pin=p;
		setTitle("Change PIN Number");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1550, 1080);
		setLocation(-5,0);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
//		Change pin Label
		JLabel Data_Lab = new JLabel("Change your PIN Number");
		Data_Lab.setForeground(new Color(255, 255, 255));
		Data_Lab.setFont(new Font("System", Font.BOLD, 26));
		Data_Lab.setBounds(476, 155, 333, 35);
		contentPane.add(Data_Lab);
		
//		Old pin label
		JLabel OldPIN_Lab = new JLabel("Enter Old PIN :");
		OldPIN_Lab.setFont(new Font("Raleway", Font.PLAIN, 16));
		OldPIN_Lab.setForeground(Color.white);
		OldPIN_Lab.setBounds(432, 223, 136, 27);
		contentPane.add(OldPIN_Lab);
		
//		Old Pin Field
		Old_PIN = new JPasswordField();
		Old_PIN.setBounds(618, 223, 202, 27);
		Old_PIN.setToolTipText("Enter Old PIN.");
		Old_PIN.setFont(new Font("Raleway", Font.PLAIN, 16));
		Old_PIN.setBackground(new Color(65,125,128));
		Old_PIN.setForeground(new Color(255, 255, 255));
		contentPane.add(Old_PIN);

//		new pin label
		NewPIN_Lab_1 = new JLabel("Enter New PIN :");
		NewPIN_Lab_1.setForeground(Color.WHITE);
		NewPIN_Lab_1.setFont(new Font("Dialog", Font.PLAIN, 16));
		NewPIN_Lab_1.setBounds(432, 260, 136, 27);
		contentPane.add(NewPIN_Lab_1);
		
//		new pin field
		New_PIN = new JPasswordField();
		New_PIN.setToolTipText("Enter New PIN.");
		New_PIN.setForeground(Color.WHITE);
		New_PIN.setFont(new Font("Dialog", Font.PLAIN, 16));
		New_PIN.setBackground(new Color(65, 125, 128));
		New_PIN.setBounds(618, 260, 202, 27);
		contentPane.add(New_PIN);
		
//		Reenter pin label
		ReNewPIN_Lab = new JLabel("Re-Enter New PIN :");
		ReNewPIN_Lab.setForeground(Color.WHITE);
		ReNewPIN_Lab.setFont(new Font("Dialog", Font.PLAIN, 16));
		ReNewPIN_Lab.setBounds(432, 297, 140, 27);
		contentPane.add(ReNewPIN_Lab);
		
//		Re enter pin field
		RePIN_ = new JPasswordField();
		RePIN_.setToolTipText("Re-Enter New PIN.");
		RePIN_.setForeground(Color.WHITE);
		RePIN_.setFont(new Font("Dialog", Font.PLAIN, 16));
		RePIN_.setBackground(new Color(65, 125, 128));
		RePIN_.setBounds(618, 297, 202, 27);
		contentPane.add(RePIN_);
		
//		Deposit Button
		ChangePin_btn = new JButton("CHANGE PIN");
		ChangePin_btn.setBackground(new Color(0, 128, 128));
		ChangePin_btn.setForeground(new Color(255, 255, 255));
		ChangePin_btn.setFont(new Font("Raleway", Font.BOLD, 18));
		ChangePin_btn.setBounds(678, 360, 156, 37);
		contentPane.add(ChangePin_btn);
		ChangePin_btn.addActionListener(this);
		
//		Back button
		Back_btn = new JButton("Back");
		Back_btn.setForeground(Color.WHITE);
		Back_btn.setFont(new Font("Dialog", Font.BOLD, 18));
		Back_btn.setBackground(new Color(0, 128, 128));
		Back_btn.setBounds(678, 405, 156, 37);
		Back_btn.addActionListener(this);
		contentPane.add(Back_btn);
		
//		ATM Image
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
		String old,newp,renewp;
		old=Old_PIN.getText();
		newp=New_PIN.getText();
		renewp=RePIN_.getText();
		if(e.getSource()==Back_btn) {
			Transaction home=new Transaction(pin);
			home.show();
			dispose();
		}else if(e.getSource()==ChangePin_btn) {
			try {
				if(old.equals("") || newp.equals("") || renewp.equals("")){
					JOptionPane.showMessageDialog(null, "Please Enter Full Details");					
				}else if(!old.equals(pin)) {
					JOptionPane.showMessageDialog(null, "Please Enter Correct Old PIN Number");
				}else if(!newp.equals(renewp)) {
					JOptionPane.showMessageDialog(null, "Enter PIN Does Not Match To New PIN");
				}else {
					JDBCConn conn=new JDBCConn();
//					Querry to update Login Table
					String querry1="update Login_Tab set PIN_No='"+renewp+"' where PIN_NO='"+old+"'";
//					Querry to update Signup3 Table
					String querry2="update SignUp3_Tab set PIN_No='"+renewp+"' where PIN_NO='"+old+"'";
//					Querry to update Transaction Table
					String querry3="update Transactions set PIN_No='"+renewp+"' where PIN_NO='"+old+"'";
					
					conn.stmt.executeUpdate(querry1);
					conn.stmt.executeUpdate(querry2);
					conn.stmt.executeUpdate(querry3);
					JOptionPane.showMessageDialog(null, "PIN Changed Successfully");
					JOptionPane.showMessageDialog(null, "Your New PIN is :"+ renewp);
					Transaction home=new Transaction(renewp);
					home.show();
					dispose();
				}
			}catch(Exception E) {
				E.printStackTrace();
			}
		}
	}
}
