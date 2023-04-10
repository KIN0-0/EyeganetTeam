import java.awt.EventQueue;
import java.sql.*;

public class Client_main {

	public static void main(String[] args) {
		
		
//		m_frm frm = new m_frm();
		//객체 생성 
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					LoginPage loginPage = new LoginPage();
//					loginPage.framelogin.setVisible(true);
//				}catch(Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
		
		
	     EventQueue.invokeLater(new Runnable() {
	         public void run() {
	            try {	            
// 				u_frm 객체 생성
	              user_Seat u_frm = new user_Seat();	                 
              u_frm.jframe.setVisible(true);
	            } catch (Exception e) {
	               e.printStackTrace();
	            }
         }
      });

//		
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					RegisterPage registerPage = new RegisterPage(idandPasswords.getLoginInfo());
//					registerPage.setVisible(true);
//				}catch(Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
		
		


//		RegisterCheck res = new RegisterCheck();
//		res.registerCheck("pi");
		
	}

}
