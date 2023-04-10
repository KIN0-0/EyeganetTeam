

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO {

//	public static void main(String[] args) {
		
	
		public static Connection con;
		public static PreparedStatement pst;
		public static ResultSet rs;
		
		protected void Connect() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/test";
				
				con = DriverManager.getConnection(url,"root","als1tn2!@");
			System.out.println("sucsses");
			}
			catch(ClassNotFoundException e) {
				System.out.println("드라이버 로딩 실패");
			}
			catch(SQLException e){
	            System.out.println("에러: " + e);
	        }
	        
	        }
		
		ArrayList<menu_DTO> loading() { //DB메뉴 데이터 가져오기
			ArrayList<menu_DTO> list = new ArrayList<menu_DTO>();
			
			try {
				String sql = "select * from menu";
				pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery(); 
				
			
				while(rs.next()) {
				menu_DTO mdto = new menu_DTO();
				
				mdto.setMenuid(rs.getString("menu_id"));
				mdto.setMenu(rs.getString("menu"));
				mdto.setPrice(rs.getInt("price"));
				mdto.setCategory(rs.getString("category"));
				mdto.setImage(rs.getString("image"));
				
				list.add(mdto);
				}
			}catch(Exception e) {
			}
			
			return list;
		}
		}
		



//}
