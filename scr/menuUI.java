import java.awt.EventQueue; 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.Panel;
import javax.swing.AbstractCellEditor;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Component;
import java.awt.SystemColor;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JTextPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class menuUI extends JFrame {
	private JPanel contentPane;
	private JTextField txtFieldOrderMessage;
	static JTable orderTable;
	static DefaultTableModel model = new DefaultTableModel(new Object[][] {}, //테이블 값 
			new String[] {
					"상품 이름", "가격", "수량"
				}) ;
	static int len;
	static int price;
	static JLabel totalPrice;
	
	
	menu_Comp menu = new menu_Comp();
	
	public static void main(String[] args) {
		try {
			menuUI m = new menuUI();
			m.setVisible(true);
			//menu.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
}
	
	public menuUI() {
		setResizable(false);
		setBackground(Color.WHITE);
		setTitle("먹거리 주문");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.WHITE);
		setBounds(100, 100, 893, 672);

		JMenuBar menuBar = new JMenuBar();
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(30, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("신상품");
		lblNewLabel_4.setBounds(10, 10, 67, 25);
		lblNewLabel_4.setForeground(Color.BLACK);
		lblNewLabel_4.setBackground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("굴림", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_4);

		JPanel orderListPane = new JPanel();
		orderListPane.setBounds(667, 180, 198, 339);
		orderListPane.setBorder(null);
		orderListPane.setBackground(Color.WHITE);
		contentPane.add(orderListPane);
		orderListPane.setLayout(null);

		JPanel totalPane = new JPanel();
		totalPane.setBorder(new LineBorder(SystemColor.inactiveCaption, 2));
		totalPane.setBackground(Color.WHITE);
		totalPane.setBounds(12, 290, 177, 39);
		orderListPane.add(totalPane);
		totalPane.setLayout(null);

		JLabel totalPriceNotice = new JLabel("총 금액 :");
		totalPriceNotice.setBounds(30, 7, 60, 26);
		totalPane.add(totalPriceNotice);
		totalPriceNotice.setFont(new Font("굴림", Font.PLAIN, 15));
		
		JScrollPane orderListlPane = new JScrollPane();
		orderListlPane.setBounds(0, 0, 198, 245);
		orderListlPane.getViewport().setBackground(Color.WHITE);
		orderListPane.add(orderListlPane);
		
		orderTable = new JTable();
		orderTable.setBackground(Color.WHITE);
		orderTable.setRowHeight(23);
		orderTable.setShowVerticalLines(false);
		orderTable.setShowHorizontalLines(false);
		//테이블 편집 못 하도록
		orderTable.getTableHeader().setReorderingAllowed(false);
		orderTable.getTableHeader().setResizingAllowed(false);
		orderTable.setModel(model);
		orderTable.getColumnModel().getColumn(0).setPreferredWidth(100);
		orderTable.getColumnModel().getColumn(0).setMinWidth(16);
		orderTable.getColumnModel().getColumn(1).setPreferredWidth(60);
		orderTable.getColumnModel().getColumn(2).setPreferredWidth(40);
		orderListlPane.setViewportView(orderTable);
		
		totalPrice = new JLabel("");
		totalPrice.setFont(new Font("굴림", Font.PLAIN, 15));
		totalPrice.setBounds(90, 7, 60, 26);
		totalPane.add(totalPrice);
		len = orderTable.getRowCount();
		price = 0;
		for(int i=0; i<len; i++) {
			price += (int) orderTable.getValueAt(i, 1) *(int) orderTable.getValueAt(i, 2);	//상품 가격 *  수량
		}
		totalPrice.setText(Integer.toString(price));
		
		//orderTable 내역 선택 시 해당 내역 삭제 버튼
			JButton delBtn = new JButton("삭제");
			delBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int n = orderTable.getSelectedRow();
					DefaultTableModel tm = (DefaultTableModel)orderTable.getModel();
					if(n>=0 && n<orderTable.getRowCount()) {
						tm.removeRow(n);
						len = orderTable.getRowCount();
						price = 0;
						for(int i=0; i<len; i++) {
							price += (int) orderTable.getValueAt(i, 1) *(int) orderTable.getValueAt(i, 2);	//상품 가격 *  수량
						}
						totalPrice.setText(Integer.toString(price));
					}
				}
			});
			delBtn.setBackground(Color.WHITE);
			delBtn.setBounds(102, 254, 70, 26);
			orderListPane.add(delBtn);
				
		//수량 증가하는 버튼
		JButton addBtn = new JButton("▲");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int n = orderTable.getSelectedRow();
					int v = (int) orderTable.getValueAt(n, 2);
					v++;
					orderTable.setValueAt(v, n, 2);
					len = orderTable.getRowCount();
					price = 0;
					for(int i=0; i<len; i++) {
						price += (int) orderTable.getValueAt(i, 1) *(int) orderTable.getValueAt(i, 2);	//상품 가격 *  수량
					}
					totalPrice.setText(Integer.toString(price));
				} catch(Exception e1) {
					
				}
			}
		});
		addBtn.setBackground(Color.WHITE);
		addBtn.setBounds(29, 254, 58, 12);
		orderListPane.add(addBtn);
		
		//수량 감소하는 버튼
		JButton rmvBtn = new JButton("▼");
		rmvBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int n = orderTable.getSelectedRow();
					int v = (int) orderTable.getValueAt(n, 2);
					if(v<=1) {}
					else 
						v--;
					orderTable.setValueAt(v, n, 2);	
					len = orderTable.getRowCount();
					price = 0;
					for(int i=0; i<len; i++) {
						price += (int) orderTable.getValueAt(i, 1) *(int) orderTable.getValueAt(i, 2);	//상품 가격 *  수량
					}
					totalPrice.setText(Integer.toString(price));
				} catch(Exception e1) {
				}
			}
		});
		rmvBtn.setBackground(Color.WHITE);
		rmvBtn.setBounds(29, 268, 58, 12);
		orderListPane.add(rmvBtn);	
		
		JPanel orderPay = new JPanel();
		orderPay.setBounds(670, 529, 195, 94);
		orderPay.setBorder(null);
		orderPay.setBackground(Color.WHITE);
		contentPane.add(orderPay);
		orderPay.setLayout(null);

		JRadioButton rdbtnCash = new JRadioButton("현금");
		boolean a = false;
		rdbtnCash.setSelected(a);	//선택 안 된 상태
		rdbtnCash.setBackground(Color.WHITE);
		rdbtnCash.setBounds(5, 14, 50, 20);
		orderPay.add(rdbtnCash);

		JRadioButton rdbtnCard = new JRadioButton("카드");
		rdbtnCard.setBackground(Color.WHITE);
		rdbtnCard.setFont(new Font("굴림", Font.PLAIN, 11));
		rdbtnCard.setBounds(135, 13, 47, 23);
		orderPay.add(rdbtnCard);

		JComboBox cbBoxCash = new JComboBox();
		cbBoxCash.setFont(new Font("굴림", Font.PLAIN, 11));
		cbBoxCash.setBackground(Color.WHITE);
		cbBoxCash.setModel(new DefaultComboBoxModel(new String[] {"50,000원", "10,000원", "5,000원", "1,000원", "금액에 맞게"}));
		cbBoxCash.setToolTipText("");
		cbBoxCash.setBounds(56, 13, 73, 21);
		orderPay.add(cbBoxCash);
		
		// 결제수단 선택 시 라디오 그룹으로 묶어 중복 산텍 블가하게 함
		ButtonGroup radioGroup;
		radioGroup = new ButtonGroup();
		radioGroup.add(rdbtnCash);
		radioGroup.add(rdbtnCard);

		txtFieldOrderMessage = new JTextField();
		txtFieldOrderMessage.setBackground(Color.WHITE);
		txtFieldOrderMessage.setForeground(Color.LIGHT_GRAY);
		txtFieldOrderMessage.setFont(new Font("굴림", Font.PLAIN, 11));
		txtFieldOrderMessage.setText("주문시 요청사항 입력");
		txtFieldOrderMessage.setBounds(8, 50, 115, 24);
		orderPay.add(txtFieldOrderMessage);
		txtFieldOrderMessage.setColumns(10);
		
		JButton btnOrder = new JButton("주문");
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tm = (DefaultTableModel) orderTable.getModel();
				int len = orderTable.getRowCount();
				if (len >= 1) {	// JTable에 행이 하나라도 있다면 + TODO : + 조건문에 라디오버튼(현큼/카드) 하나라도 눌렸는지도 추가
					// TODO : 관리자에게 pop-up 알림 전송
					// TODO : 주문내역을 orders table에 insert하기
//					OrderNotice o = new OrderNotice();
//					add(o);
					price = 0;//가격 초기화
					tm.setNumRows(0); // 테이블 초기화
					totalPrice.setText(Integer.toString(price));
				} 
			}
		});
		btnOrder.setBackground(Color.WHITE);
		btnOrder.setFont(new Font("Gulim", Font.PLAIN, 12));
		btnOrder.setBounds(128, 49, 59, 25);
		orderPay.add(btnOrder);
		
	    //메뉴 분류 탭 생성
	    JTabbedPane Menu = new JTabbedPane(JTabbedPane.TOP);
	    Menu.setBorder(null);
	    Menu.setBackground(Color.WHITE);
	    Menu.setBounds(10, 159, 645, 464);
	    contentPane.add(Menu);
	    
	    
	    
	    JScrollPane allScrollPane = new JScrollPane();
	    Menu.addTab("전체 보기", null, allScrollPane, null);
	    JPanel all = new JPanel();
	    all.setBackground(Color.WHITE);
	    allScrollPane.setViewportView(all);
	    all.setLayout(new GridLayout(3, 5));
	    for(int i=0;i<menu.list.size();i++) {
	    all.add(menu.setMenu(i));
	    }
	    
	    
	    JScrollPane mealScrollPane = new JScrollPane();
	    Menu.addTab("식사류", null, mealScrollPane, null);
	    JPanel meal = new JPanel();
	    meal.setBackground(Color.WHITE);
	    mealScrollPane.setViewportView(meal);
	    meal.setLayout(new GridLayout(3, 5));
	    for(int i=0;i<menu.list.size();i++) {
	    	if(menu.list.get(i).getCategory().equals("식사류")) {
		    meal.add(menu.setMenu(i));
	    	}
		    }
	    
	    JScrollPane rameonScrollPane = new JScrollPane();
	    Menu.addTab("라면류", null,rameonScrollPane, null);
	    JPanel rameon = new JPanel();
	    mealScrollPane.setViewportView(rameon);
	    
	    JScrollPane snackScrollPane = new JScrollPane();
	    Menu.addTab("간식류", null, snackScrollPane, null);
	    JPanel snack = new JPanel();
	    mealScrollPane.setViewportView(snack);
	    
	    JScrollPane bevScrollPane = new JScrollPane();
	    Menu.addTab("음료류", null, bevScrollPane, null);
	    JPanel bev = new JPanel();
	    mealScrollPane.setViewportView(bev);
	    
	    JScrollPane toppingScrollPane = new JScrollPane();
	    Menu.addTab("토핑", null, toppingScrollPane, null);
	    JPanel topping = new JPanel();
	    mealScrollPane.setViewportView(topping);
	    
	    //JPanel panel = new JPanel();
	    //panel.setBackground(SystemColor.inactiveCaption);
	    //panel.setBounds(12, 35, 853, 114);
	    //contentPane.add(panel);
	    //panel.setLayout(new GridLayout(1, 0, 0, 0));
	}

}
