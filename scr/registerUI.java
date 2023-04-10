
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.sql.SQLException;

import java.sql.*;

public class registerUI extends DAO implements ActionListener {

//	RegisterCheck rgtCheck = new RegisterCheck();
	// JFrame
	JFrame frame = new JFrame();

	// Panel
	JPanel contentPane = new JPanel();

	// Label
	JLabel registerLabel;

	// TextField
	JTextField IDField, PasswordField, PWConfirmField, FullNameField, phoneField, verificationField, dateofbirthField;

	// Hint
	TextHint idHint, pwHint, pwcheckHint, nameHint, phoneHint, verificationHint, dateofbirthHint;

	// Button
	JButton checkBtn, verificationBtn, registerBtn;

	// RadioButton
//	JRadioButton femalebtn, malebtn;

	// ButtonGroup
	ButtonGroup radio;

	String seat;

	public registerUI(String seat) {

		this.seat = seat;
		// 획원가입 Text
		registerLabel = new JLabel("회원가입");
		registerLabel.setHorizontalAlignment(JLabel.CENTER);
		registerLabel.setBounds(0, 50, 400, 35);
		registerLabel.setFont(new Font("KoPubWorld돋움체 Bold", Font.PLAIN, 25));

		// 입력 TextField
		IDField = new JTextField();
		idHint = new TextHint(IDField, "아이디");
		IDField.setBounds(90, 100, 220, 35);

		PasswordField = new JTextField();
		pwHint = new TextHint(PasswordField, "비밀번호");
		PasswordField.setBounds(90, 144, 220, 35);

		PWConfirmField = new JTextField();
		pwcheckHint = new TextHint(PWConfirmField, "비밀번호 확인");
		PWConfirmField.setBounds(90, 193, 220, 35);

		FullNameField = new JTextField();
		nameHint = new TextHint(FullNameField, "성명");
		FullNameField.setBounds(90, 242, 220, 35);

		phoneField = new JTextField();
		phoneHint = new TextHint(phoneField, "휴대전화번호('-'제외)");
		phoneField.setBounds(90, 291, 220, 35);

		verificationField = new JTextField();
		verificationHint = new TextHint(verificationField, "인증번호 입력");
		verificationField.setBounds(90, 339, 220, 35);

		dateofbirthField = new JTextField();
		dateofbirthHint = new TextHint(dateofbirthField, "생년월일(8자리 입력)");
		dateofbirthField.setBounds(90, 384, 100, 35);

		// Button
		checkBtn = new JButton("중복확인");
		checkBtn.setFont(new Font("KoPubWorld돋움체 Medium", Font.PLAIN, 9));
		checkBtn.setBounds(310, 100, 67, 25);
		checkBtn.addActionListener(this);

		verificationBtn = new JButton("인증번호");
		verificationBtn.setFont(new Font("KoPubWorld돋움체 Medium", Font.PLAIN, 9));
		verificationBtn.setBounds(310, 297, 67, 25);
		verificationBtn.addActionListener(this);

		registerBtn = new JButton("회원가입");
		registerBtn.setFont(new Font("KoPubWorld돋움체 Medium", Font.PLAIN, 9));
		registerBtn.setBounds(166, 430, 67, 25);
		registerBtn.addActionListener(this);

		// RadioButton
//		femalebtn = new JRadioButton("여성");
//		femalebtn.setBounds(206, 384, 50, 25);
//		femalebtn.addActionListener(this);
//
//		malebtn = new JRadioButton("남성");
//		malebtn.setBounds(260, 384, 60, 25);
//		malebtn.addActionListener(this);
//
//		radio = new ButtonGroup();
//		radio.add(femalebtn);
//		radio.add(malebtn);

		contentPane.setLayout(null);

		contentPane.add(dateofbirthField);
		contentPane.add(FullNameField);
		contentPane.add(IDField);
		contentPane.add(PWConfirmField);
		contentPane.add(PasswordField);
		contentPane.add(phoneField);
		contentPane.add(verificationField);
		contentPane.add(checkBtn);
//		contentPane.add(femalebtn);
//		contentPane.add(malebtn);
		contentPane.add(registerLabel);
		contentPane.add(registerBtn);
		contentPane.add(verificationBtn);

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 450);

		frame.setSize(400, 550);
		frame.setResizable(false);
		frame.setContentPane(contentPane);
		frame.setLocationRelativeTo(null);
		frame.setUndecorated(true);
		frame.setBackground(new Color(255, 255, 255, 30));
		frame.setShape(new RoundRectangle2D.Double(0, 0, frame.getWidth(), frame.getHeight(), 40, 40));

		Connect();

	}

//	PreparedStatement pst;

//	
//	public void gender() {
//		femalebtn.addActionListener(new ActionListener() {	
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				if (e.getSource() == femalebtn) gender="w";
//				else gender = "m";
//			}
//			
//		});
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String id, password, passwordcheck, name, birth, phone;

		id = IDField.getText();
		password = PasswordField.getText();
		passwordcheck = PWConfirmField.getText();
		name = FullNameField.getText();
		birth = dateofbirthField.getText();
		phone = phoneField.getText();

		if (e.getSource() == registerBtn) {

			boolean bool = false;
//			비밀번호 확인 
			if (!password.equals("비밀번호") && !passwordcheck.equals("비밀번호 확인") && !passwordcheck.equals(password)) {
				JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다!");
				PWConfirmField.setText("");
				System.out.println("pw");
				bool = true;
			}

			// 입력 안되는 정보가 없는지 확인 
			if (id.equals("아이디")) {
				IDField.getText();
				JOptionPane.showMessageDialog(null, "아이디를 입력해주세요!");

			}
			if (password.equals("비밀번호")) {
				JOptionPane.showMessageDialog(null, "비밀번호를 입력해주세요!");

			}
			if (passwordcheck.equals("비밀번호 확인")) {
				JOptionPane.showMessageDialog(null, "비밀번호 확인을 입력해주세요!");

			}

			if (name.equals("성명")) {
				JOptionPane.showMessageDialog(null, "이름을 입력해주세요!");

			}
			if (phone.equals("휴대전화번호('-'제외)")) {
				JOptionPane.showMessageDialog(null, "전화번호를 입력해주세요!");

			}
//			if(phone.equals("인증번호 입력")) {
//				JOptionPane.showMessageDialog(null, "인증번호를 입력해주세요!");
//			}
			if (birth.equals("생년월일(8자리 입력)")) {
				JOptionPane.showMessageDialog(null, "생년월일을 입력해주세요!");

			}

			if (!bool) {
				// pst = con.prepareStatement("insert into Info values(?,?,?,?,?)");
				// pst.setString(1, id);
				// pst.setString(2, password);
				// pst.setString(3, name);
				// pst.setString(4, birth);
				//// pst.setString(5, gender);
				// pst.setString(5, phone);
				// pst.executeUpdate();
				try {
					Client client = new Client(id, password, seat);
					boolean rec = client.signin(id, password, name, birth, phone);
					System.out.println(rec);
					if (rec) {
						System.out.println("ㅎㅎㅎㅎㅎㅎㅎㅎ");
						JOptionPane.showMessageDialog(null, "회원가입 성공");

						IDField.setText("");
						PasswordField.setText("");
						PWConfirmField.setText("");
						FullNameField.setText("");
						dateofbirthField.setText("");
						phoneField.setText("");

						IDField.requestFocus();
						frame.dispose();
						EventQueue.invokeLater(new Runnable() {
							private String seat;

							public void run() {
								try {
									loginUI loginPage = new loginUI(this.seat);
									loginPage.framelogin.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
						Client.close();
					}
				} catch (IOException e2) {
					e2.printStackTrace();
				}

				
			}

//				finally {
//
//		            //사용순서와 반대로 close 함
//		            if (pst != null) {
//		                try {
//		                    pst.close();
//		                } catch (SQLException e1) {
//		                    e1.printStackTrace();
//		                }
//		            }
//
//		            if (con != null) {
//		                try {
//		                    con.close();
//		                } catch (SQLException e1) {
//		                    e1.printStackTrace();
//		                }
//		            }
//		        }
		}

	}

}
