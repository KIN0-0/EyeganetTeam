import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.io.IOException;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.sql.*;
import java.sql.SQLException;

public class loginUI extends DAO implements ActionListener {


   JFrame framelogin = new JFrame();
   JButton signupBtn = new JButton("회원가입");
   JButton loginBtn = new JButton("로그인");
   JTextField userIDField = new JTextField();
   JPasswordField userPasswordField = new JPasswordField();
   JLabel userIDLabel = new JLabel("ID: ");
   JLabel userPasswordLabel = new JLabel("Password: ");
   JLabel messageLabel = new JLabel();
   JPanel contentPane = new JPanel();
   JLabel loginLabel = new JLabel("Login");
   String seat;

   
	
   // 생성자
  public loginUI(String seatNum) {
	
	  this.seat = seatNum;
	  
	  
	   EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//LoginPage loginPage = new LoginPage();
					framelogin.setVisible(true);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
      userIDLabel.setBounds(100, 100, 75, 25);
      userPasswordLabel.setBounds(50, 150, 75, 25);

      messageLabel.setBounds(35, 250, 250, 35);
      messageLabel.setFont(new Font(null, Font.ITALIC, 25));

      loginLabel.setBounds(0, 36, 320, 35);
      loginLabel.setFont(new Font("KoPubWorld돋움체 Bold", Font.BOLD, 30));
      loginLabel.setForeground(Color.DARK_GRAY);
      loginLabel.setHorizontalAlignment(JLabel.CENTER);

      userIDField.setBounds(27, 95, 265, 38);
      userIDField.setBackground(Color.WHITE);

      userPasswordField.setBackground(Color.WHITE);
      userPasswordField.setBounds(27, 157, 265, 38);

      loginBtn.setFont(new Font("KoPubWorld돋움체 Medium", Font.PLAIN, 12));
      loginBtn.setBounds(48, 215, 100, 25);
      loginBtn.addActionListener(this);
      loginBtn.setFocusable(false);

      signupBtn.setFont(new Font("KoPubWorld돋움체 Medium", Font.PLAIN, 12));
      signupBtn.setBounds(174, 215, 100, 25);
      signupBtn.addActionListener(this);
      signupBtn.setFocusable(false);

      // 투명프레임
      framelogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      framelogin.setBounds(100, 100, 450, 450);

      framelogin.setSize(320, 320);
      // setVisible(true);
      // setLayout(null);
      framelogin.setResizable(false);
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      contentPane.setBackground(Color.WHITE);

      // contentPane.setLayout(new BorderLayout(0,0));
      contentPane.setLayout(null);
      // contentPane.setBackground(new Color(255,255,255,122));
      contentPane.add(userIDField);
      contentPane.add(userPasswordField);
      contentPane.add(messageLabel);
      // contentPane.add(userIDLabel);
      // contentPane.add(userPasswordLabel);
      contentPane.add(loginBtn);
      contentPane.add(signupBtn);
      contentPane.add(loginLabel);

      framelogin.setContentPane(contentPane);

      // add(contentPane);
      framelogin.setLocationRelativeTo(null);
 //     framelogin.setUndecorated(true);

  //    framelogin.setBackground(new Color(255, 255, 255, 225));
  //    framelogin.setShape(new RoundRectangle2D.Double(0, 0, framelogin.getWidth(), framelogin.getHeight(), 40, 40));

      Connect();
   }
  

//  	public static boolean isMember(String id,String pw) {
//  		try {
//  			String sql = "select * from Info where id=? and password=?";
//	  		pst = con.prepareStatement(sql);
//	  		pst.setString(1, id);
//	  		pst.setString(2, pw);
//	  		rs = pst.executeQuery();
//	  		if(rs.next()) {
//	  			return true;
//	  		}
//  		} finally {
//  			rs.close();
//  			pst.close();
//  		}
//  		catch(SQLException e1) {
//			e1.printStackTrace();
//		}
//  		
//		return false;
//  		
//  	}


   @Override
   public void actionPerformed(ActionEvent e) {
	   String id,password;
	   
	   id = userIDField.getText();
	   password = String.valueOf(userPasswordField.getPassword());

      if (e.getSource() == signupBtn) {
    	framelogin.dispose();
  		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registerUI registerPage = new registerUI(seat);
					registerPage.frame.setVisible(true);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
         
      }

      if (e.getSource() == loginBtn) {
    	  System.out.println("hiiiiii");
		try {
			Client client = new Client(id,password,seat);
			boolean response = client.login();
			if(response) {
				client.start();
				framelogin.dispose();
				
			}
			else  {
				JOptionPane.showMessageDialog(null, "아이디나 비밀번호가 일치하지 않습니다!");
				client.close();;
			}
			
	    	
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	  
    	  
//    	  try {
//		  String sql = "select * from Info where id=? and password=?";
//		  pst = con.prepareStatement(sql);
//		  pst.setString(1, id);
//		  pst.setString(2, password);
//		  rs = pst.executeQuery();
//		  
//		  if(rs.next()) {
//			  JOptionPane.showInternalMessageDialog(null,"성공적으로 로그인 되었습니다"); 
//			  
//			  try {
//				  framelogin.dispose();
//				Client client = new Client(id,password,seat);
//				
//			} catch (IOException e1) {
//				e1.printStackTrace();
//			}
//		  }
//		  else  JOptionPane.showMessageDialog(null, "아이디나 비밀번호가 일치하지 않습니다!");
	 
//	  }catch(SQLException e1) {
//			e1.printStackTrace();
//		}
    	  
      }

   }

}