
import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLException;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

public class ClientHandler extends DAO implements Runnable {

	// field
	private static Socket client;
	private static BufferedReader in;
	private static PrintWriter out;
	private static String id, seatNum;
	private static StringTokenizer st;
	private static JButton seatbtn;
	int remainTime;

	public ClientHandler(Socket clientSocket) throws IOException {

		this.client = clientSocket;
		in = new BufferedReader(new InputStreamReader(client.getInputStream()));
		out = new PrintWriter(client.getOutputStream(), true);
		st = new StringTokenizer(in.readLine());

		this.id = st.nextToken();
		this.seatNum = st.nextToken();
		this.seatbtn = admin_Seat.mngbtnMap.get(seatNum); // 버튼번호로 버튼을 찾기

		// 사용자 남은 시간이 있는지 확인
		try {
			String sql = "select * from Info where id=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				remainTime = rs.getInt("remainTime");
				out.println(remainTime); // 남은 시간을 클라이언트한테 보내기
			}

		} catch (SQLException e1) {

			e1.printStackTrace();
		}
	}

	@Override
	public void run() {

		try {

			while (true) {
				String request = in.readLine(); // 클라이언트 요청 받기
				
				LineBorder redB = new LineBorder(Color.RED,3);

				// 결제 요청을 서버가 확인
				if (request.contains("결제")) {
					int serverResponse = JOptionPane.showConfirmDialog(null, request, "결제", JOptionPane.YES_NO_OPTION,
							JOptionPane.INFORMATION_MESSAGE, null);
					out.println(serverResponse);
				}

				// 클라이언트가 메인 화면을 실행했으면 메니저 화면 샤용자 자리 비활성화
				if (request.equals("true")) {
					seatbtn.setText(id+"\n"+remainTime);
					seatbtn.setBorder(redB);
					//seatbtn.setEnabled(false);
				}

				// 클라이언트가 닫히면 메니저 화면 사용자 자리 다시 활성화
				if (request.equals("close")) {
					seatbtn.setText(seatNum);
					seatbtn.setBackground(Color.WHITE);
					//seatbtn.setEnabled(true);
				}

				if (request.contains("남은시간")) {
					System.out.println("hi");
					st = new StringTokenizer(request);
					st.nextToken();
//					System.out.println(extra);
					int timeRemain = Integer.parseInt(st.nextToken());
					System.out.println(timeRemain);
					try {
						String sql = "update Info set remainTime=?  where id=?";
						pst = con.prepareStatement(sql);
						pst.setInt(1, timeRemain);
						pst.setString(2, id);
						pst.executeUpdate();
						System.out.println("hihddjhffg");
						out.println("insert");
					} catch (SQLException e1) {

						e1.printStackTrace();
					}

				}
				
				if(request.contains("login")) {
					
					st = new StringTokenizer(request);
					st.nextToken();
					String id = st.nextToken();
					System.out.println(id);
					String pw = st.nextToken();
					System.out.println(pw);
					
					try {
						String sql = "select * from Info where id=? and password=?";
						pst = con.prepareStatement(sql);
						pst.setString(1, id);
						pst.setString(2, pw);
						rs = pst.executeQuery();
						if(rs.next()) {
							System.out.println(pw);
							out.println("true");
						}
					} catch (SQLException e1) {

						e1.printStackTrace();
					}
				}
				
				if(request.contains("signin")) {
					System.out.println(request);
					st = new StringTokenizer(request);
					st.nextToken();
					String id = st.nextToken();
					String pw = st.nextToken();
					String name = st.nextToken();
					String birth = st.nextToken();
					String phone = st.nextToken();
					
					try {
						String sql = "insert into Info(id,password,name,birth,phone) values(?,?,?,?,?)";
						System.out.println("랴효ㅛㅗㅗ");
						pst = con.prepareStatement(sql);
						pst.setString(1, id);
						pst.setString(2, pw);
						pst.setString(3, name);
						pst.setString(4, birth);
						pst.setString(5, phone);
						pst.executeUpdate();
						out.println("완료");						
					} catch (SQLException e1) {

						e1.printStackTrace();
					}
				}
			}

		} catch (IOException e) {
			System.out.println("IO exception in client handler!");
			System.out.println(e.getStackTrace());
		} finally {
			out.close();
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
