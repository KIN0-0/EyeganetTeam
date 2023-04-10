
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server extends DAO {

	private static final int PORT = 4000;
	private static ArrayList<ClientHandler> clients = new ArrayList<>();
	private static ExecutorService pool = Executors.newFixedThreadPool(30);
	private static Socket client;

	public static void main(String[] args) throws IOException {

		ServerSocket listener = new ServerSocket(PORT);

		// 메니저 ui 실
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin_Seat frame = new admin_Seat();
					frame.mngFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		// 여러 클라이언트 연결할 수 있게 반복문 사용
		while (true) {
			System.out.println("[SERVER] Wating for client connection...");
			client = listener.accept();
			System.out.println("[SERVER] Connected to client!");
			ClientHandler clientThread = new ClientHandler(client); // 연결된 클라이언트를 핸들러에서 관리

			pool.execute(clientThread); // 핸들러 스레드 실행
			clients.add(clientThread);

		}

	}

}
