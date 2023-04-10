import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JOptionPane;

public class Client {

	// field
	private static final String SERVER_IP = "localhost";
	private static final int SERVER_PORT = 4000;
	private static Socket socket;
	private static String id, password, seat;
	private static PrintWriter out, seatNum;
	private static BufferedReader in;
	private static int serverResponse;

	// 시간 추가
	private static String[] time = { "1시간", "2시간 30분", "4시간", "5시간 30분", "6시간" };
	private static String time_pick;
	private static int time_save;

	// constructor
	public Client(String id, String pw, String seat) throws IOException {

		this.id = id;
		this.password = pw;
		this.seat = seat;

		socket = new Socket(SERVER_IP, SERVER_PORT);

		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(socket.getOutputStream(), true);

		// 서버한테 클라이언트 아이디와 좌석번호 보내기
		out.println(this.id + " " + this.seat);

		time_save = Integer.parseInt(in.readLine()); // 서버한테 남은 시간을 받아옴


	}
	
	public static void start() throws IOException {
		if (time_save == 0) { // 데이타베이스에 남은 시간이 없으면 사용자한테 시간을 입력 받음

			// 시간추가 메서드 호출
			timeAdd();
		} else {

			JOptionPane.showInternalMessageDialog(null, "남은시간: " + time_save);
			user_Main userMain = new user_Main(seat, id, time_save); // usermain 화면을 실행
			serverResponse+=1;
			out.println("true"); // usermain 실행했다고 서버에 알림
		}
	}

	// 시간 추가 메서드
	public static int  timeAdd() throws IOException {

		time_pick = (String) JOptionPane.showInputDialog(null, "시간을 선택하세요", "I4 PC", JOptionPane.WARNING_MESSAGE, null,
				time, time[0]);
		out.println(seat + "번 자리 [id: " + id + "]가 " + time_pick + "을 결제했습니까?");
		// 실행 메서드 호출
		execute();
		return time_save;

	}
	
	
	public static boolean signin(String id,String pw, String name,String birth,String phone) throws IOException {
		out.println("signin"+" "+id+" "+pw+" "+name+" "+birth+" "+phone);
		String response = in.readLine();
		if(response.equals("완료")) return true;
		return false;
		
	}
	
	public static void close() throws IOException {

				System.out.println("client close");
				out.println("close");
				socket.close();
	}

	public static void exit(int time) throws IOException {

		if (time > 0) {
			out.println("남은시간" + " " + time);
			while(true) {
			String response = in.readLine();
			System.out.println(response+"dfhf");

			if (response.equals("insert")) {
				System.out.println("client close");
				out.println("close");
				socket.close();
				break;
				
			}
			}
		} else {
			System.out.println("client close");
			out.println("close");
			socket.close();
		}

	}

	// 결제 완료 여부 확인 메서드
	public static void execute() throws NumberFormatException, IOException {

		// 결제 완료시 0 미완료 1을 서버에서 받아옴
		serverResponse = serverResponse + (Integer.valueOf(in.readLine()) + 1);

		if (serverResponse == 1) { // 결제 완료시 usermain 실행
			timeSave(time_pick);
			user_Main userMain = new user_Main(seat, id, time_save);
			out.println("true"); // usermain 실행했다고 서버에 알림
		}
		if (serverResponse > 1) {
			timeSave(time_pick);
		}
	}

	public static void timeSave(String time_pick) {

		switch (time_pick) {
		case "1시간":
			time_save = 605;
			break;
		case "2시간 30분":
			time_save = 9000;
			break;
		case "4시간":
			time_save = 14400;
			break;
		case "5시간 30분":
			time_save = 19800;
			break;
		case "6시간":
			time_save = 21600;
			break;
		}

	}
	
	public boolean login() throws IOException {
		out.println("login: "+this.id+" "+this.password);
		String res= in.readLine();
		System.out.println(res+"djfhgfd");
		if(res.equals("true")) {
			return true;
		}
		return false;
		
	}

}
