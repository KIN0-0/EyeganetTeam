import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalTime;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class user_Main implements ActionListener {

	// field
	private static String seat, id;
	private int time_save, time;
	private Timer timer;
	private LocalTime timeNow = LocalTime.now();
	private static JButton seatId;
	// Frame
	private static JFrame userMainframe;
	// Panel
	private static JPanel contentPane, panel1, panel2, panel3;
	// Button
	private static JButton Button_food, Button_order, Button_timeAdd, Button_end;
	// JLabel
	private JLabel seat_num, user_id, time_out, time_start;
	

	static LocalTime of(int hour, int min, int sec) {
		return null;
	}

	// Timer method
	public void timer_m(Integer time_save, JLabel label) {
		time = time_save;
		timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LocalTime sunnyTime = LocalTime.ofSecondOfDay(time);
				label.setText("남은시간: " + sunnyTime);
				time--;

				// 시간이 10분 남았을 때 사용자한테 알림
				if (time == 600) {
					JOptionPane.showInternalMessageDialog(null, "시간이 10분만 남았습니다!");
				}
				if (time == -1) { // 0초 되면 이벤트 호출
					timer.stop();
					try {
						userMainframe.dispose();
						seatId = user_Seat.userbtnMap.get(seat);
						seatId.setEnabled(true);
						Client.exit(time); // client close
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		timer.start();
	}

	public user_Main(String seat, String id, int time_save) {

		this.seat = seat;
		this.id = id;
		this.time_save = time_save;

		// Frame 메서드 호출
		userMain_frm();

		timer_m(this.time_save, time_start);

	}

	public void userMain_frm() {

		// Frame
		userMainframe = new JFrame();
		userMainframe.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		userMainframe.setResizable(false);

		userMainframe.setBounds(100, 100, 419, 202);
		userMainframe.setVisible(true);

		// Panel
		panel1 = new JPanel();
		panel1.setLayout(null);
		panel1.setBackground(SystemColor.inactiveCaption);
		panel1.setBounds(0, 0, 419, 174);
		panel1.setVisible(true);

		panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setBackground(Color.WHITE);
		panel2.setBounds(12, 13, 392, 103);
		panel2.setVisible(true);

		panel3 = new JPanel();
		panel3.setLayout(null);
		panel3.setBackground(Color.WHITE);
		panel3.setBounds(247, 0, 145, 103);
		panel3.setForeground(Color.WHITE);
		panel3.setVisible(false);

		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		// JLabel
		seat_num = new JLabel("no." + seat);
		seat_num.setBounds(8, 8, 44, 16);
		seat_num.setFont(new Font("KoPubWorld돋움체 Bold", Font.BOLD, 15));
		seat_num.setForeground(Color.BLACK);
		seat_num.setBackground(Color.WHITE);

		user_id = new JLabel("ID:" + id);
		user_id.setBounds(8, 34, 145, 16);
		user_id.setFont(new Font("KoPubWorld돋움체 Medium", Font.PLAIN, 13));
		user_id.setForeground(Color.BLACK);
		seat_num.setBackground(Color.WHITE);

		time_start = new JLabel();
		time_start.setBounds(8, 77, 145, 16);
		time_start.setFont(new Font("KoPubWorld돋움체 Medium", Font.PLAIN, 13));
		time_start.setForeground(Color.BLACK);
		time_start.setBackground(Color.WHITE);

		// Button

		// 먹거리 주문 버튼
		Button_food = new JButton("먹거리 주문");
		Button_food.setFont(new Font("KoPubWorld돋움체 Medium", Font.BOLD, 9));
		Button_food.setBounds(12, 140, 84, 23);
		Button_food.setFocusable(false);
		Button_food.addActionListener(this);
		Button_food.setBackground(Color.WHITE);

		// 문의 버튼
		Button_order = new JButton("문의");
		Button_order.setFont(new Font("KoPubWorld돋움체 Medium", Font.BOLD, 9));
		Button_order.setBounds(108, 140, 84, 23);
		Button_order.setFocusable(false);
		Button_order.addActionListener(this);
		Button_order.setBackground(Color.WHITE);

		// 시간 추가 버튼
		Button_timeAdd = new JButton("시간 추가");
		Button_timeAdd.setFont(new Font("KoPubWorld돋움체 Medium", Font.BOLD, 9));
		Button_timeAdd.setBounds(204, 140, 84, 23);
		Button_timeAdd.setFocusable(false);
		Button_timeAdd.addActionListener(this);
		Button_timeAdd.setBackground(Color.WHITE);

		// 종료 버튼
		Button_end = new JButton("종료");
		Button_end.setFont(new Font("KoPubWorld돋움체 Medium", Font.BOLD, 9));
		Button_end.setBounds(300, 139, 84, 23);
		Button_end.setFocusable(false);
		Button_end.addActionListener(this);
		Button_end.setBackground(Color.WHITE);

		// Add
		panel1.add(Button_food);
		panel1.add(Button_order);
		panel1.add(Button_timeAdd);
		panel1.add(Button_end);

		panel2.add(seat_num);
		panel2.add(user_id);
		panel2.add(time_start);

		panel2.add(panel3);
		panel1.add(panel2);
		contentPane.add(panel1);
		userMainframe.setContentPane(contentPane);
	}

	@Override
	public void actionPerformed(ActionEvent e) { // 이벤트 처리할 장소

		if (e.getSource() == Button_food) { // 먹거리 주문 클릭 시
			menuUI mf = new menuUI();
			mf.setVisible(true);
		}

		if (e.getSource() == Button_order) { // 문의 클릭 시

		}

		if (e.getSource() == Button_end) { // 상세 요금 클릭 시
			
			int response = JOptionPane.showConfirmDialog(null,"종료하시겠습니까?", "종", JOptionPane.YES_NO_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null);
			if(response == 0) {
			timer.stop();
			try {
				userMainframe.dispose();
				seatId = user_Seat.userbtnMap.get(seat);
				seatId.setEnabled(true);
				Client.exit(time); // client close
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			}
		}

		if (e.getSource() == Button_timeAdd) {
			try {
				int addTime = Client.timeAdd();
				time = time+ addTime;
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}

		}
	}
}