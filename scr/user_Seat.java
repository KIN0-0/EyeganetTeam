import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class user_Seat implements ActionListener {

   private static JPanel contentPane;

   static JFrame jframe = new JFrame();
   
   private static JPanel seat_t = new JPanel();
   
//   private static JButton seat1 = new JButton("1");
//   JButton seat5;
//   JButton seat2;

   // JButton seat
   static JButton seat1 = new JButton("1");
   static JButton seat2 = new JButton("2");
   static JButton seat3 = new JButton("3");
   static JButton seat4 = new JButton("4");
   static JButton seat5 = new JButton("5");
   static JButton seat6 = new JButton("6");
   static JButton seat7 = new JButton("7");
   static JButton seat8 = new JButton("8");
   static JButton seat9 = new JButton("9");
   static JButton seat10 = new JButton("10");
   static JButton seat11 = new JButton("11");
   static JButton seat12 = new JButton("12");
   static JButton seat13 = new JButton("13");
   static JButton seat14 = new JButton("14");
   static JButton seat15 = new JButton("15");
   static JButton seat16 = new JButton("16");
   static JButton seat17 = new JButton("17");
   static JButton seat18 = new JButton("18");
   static JButton seat19 = new JButton("19");
   static JButton seat20 = new JButton("20");
   static JButton seat21 = new JButton("21");
   static JButton seat22 = new JButton("22");
   static JButton seat23 = new JButton("23");
   static JButton seat24 = new JButton("24");
   static JButton seat25 = new JButton("25");
   static JButton seat26 = new JButton("26");
   static JButton seat27 = new JButton("27");
   static JButton seat28 = new JButton("28");
   static JButton seat29 = new JButton("29");
   static JButton seat30 = new JButton("30");

   
   static Map<String,JButton> userbtnMap =new HashMap<>();
   
   private static ButtonGroup btnGroup;

   /**
    * Create the frame.
    */
   public user_Seat() {
      jframe.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\msa18\\OneDrive\\Desktop\\다운로드 (1).png"));
      jframe.setTitle("I4 PC Manage");
      jframe.getContentPane().setForeground(new Color(0, 0, 0));
      jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      jframe.setBounds(100, 100, 893, 561);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      contentPane.setLayout(new BorderLayout(0, 0));
      jframe.setContentPane(contentPane);

      JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
      contentPane.add(tabbedPane, BorderLayout.CENTER);

      seat_t.setForeground(SystemColor.activeCaption);
      seat_t.setBackground(SystemColor.inactiveCaption);
      tabbedPane.addTab("Seat", null, seat_t, null);

//      seat1.addActionListener(new ActionListener() {
//         public void actionPerformed(ActionEvent e) {
//         }
//      });
      btnGroup = new ButtonGroup();
      
      seat1.setBounds(42, 117, 60, 60);
      seat1.setForeground(SystemColor.activeCaption);
      seat1.setBackground(new Color(255, 255, 255));
      seat1.setHorizontalAlignment(SwingConstants.LEFT);
      seat1.setFont(new Font("굴림", Font.BOLD, 10));
      seat1.setVerticalAlignment(SwingConstants.TOP);
      seat1.setActionCommand("1");
      seat1.addActionListener(this);
      btnGroup.add(seat1);

//      seat5 = new JButton("5");
      seat5.setBackground(Color.WHITE);
      seat5.setForeground(SystemColor.activeCaption);
      seat5.setFont(new Font("굴림", Font.BOLD, 10));
      seat5.setBounds(102, 117, 60, 60);
      seat5.setVerticalAlignment(SwingConstants.TOP);
      seat5.setHorizontalAlignment(SwingConstants.LEFT);
      seat5.setActionCommand("5");
      seat5.addActionListener(this);
      btnGroup.add(seat5);

 //     seat2 = new JButton("2");
      seat2.setBackground(Color.WHITE);
      seat2.setForeground(SystemColor.activeCaption);
      seat2.setFont(new Font("굴림", Font.BOLD, 10));
      seat2.setVerticalAlignment(SwingConstants.TOP);
      seat2.setHorizontalAlignment(SwingConstants.LEADING);
      seat2.addActionListener(this);
//      seat2.addActionListener(new ActionListener() {
//         public void actionPerformed(ActionEvent e) {
//         }
//      });
      seat2.setBounds(42, 177, 60, 60);
      seat2.setActionCommand("2");
      btnGroup.add(seat2);

      
      seat6.setBackground(Color.WHITE);
      seat6.setForeground(SystemColor.activeCaption);
      seat6.setFont(new Font("굴림", Font.BOLD, 10));
      seat6.setVerticalAlignment(SwingConstants.TOP);
      seat6.setHorizontalAlignment(SwingConstants.LEADING);
      seat6.setBounds(102, 177, 60, 60);
      seat6.setActionCommand("6");
      seat6.addActionListener(this);
      btnGroup.add(seat6);

 //     JButton seat3 = new JButton("3");
      seat3.setBackground(Color.WHITE);
      seat3.setForeground(SystemColor.activeCaption);
      seat3.setFont(new Font("굴림", Font.BOLD, 10));
      seat3.setVerticalAlignment(SwingConstants.TOP);
      seat3.setHorizontalAlignment(SwingConstants.LEADING);
      seat3.setBounds(42, 236, 60, 60);
      seat3.setActionCommand("3");
      seat3.addActionListener(this);
      btnGroup.add(seat3);

  //    JButton seat7 = new JButton("7");
      seat7.setBackground(Color.WHITE);
      seat7.setForeground(SystemColor.activeCaption);
      seat7.setFont(new Font("굴림", Font.BOLD, 10));
      seat7.setVerticalAlignment(SwingConstants.TOP);
      seat7.setHorizontalAlignment(SwingConstants.LEADING);
      seat7.setBounds(102, 236, 60, 60);
      seat7.setActionCommand("7");
      seat7.addActionListener(this);
      btnGroup.add(seat7);

  //    JButton seat4 = new JButton("4");
      seat4.setBackground(Color.WHITE);
      seat4.setForeground(SystemColor.activeCaption);
      seat4.setFont(new Font("굴림", Font.BOLD, 10));
      seat4.setVerticalAlignment(SwingConstants.TOP);
      seat4.setHorizontalAlignment(SwingConstants.LEADING);
      seat4.setBounds(42, 297, 60, 60);
      seat4.setActionCommand("4");
      seat4.addActionListener(this);
      btnGroup.add(seat4);

  //    JButton seat8 = new JButton("8");
      seat8.setBackground(Color.WHITE);
      seat8.setForeground(SystemColor.activeCaption);
      seat8.setFont(new Font("굴림", Font.BOLD, 10));
      seat8.setVerticalAlignment(SwingConstants.TOP);
      seat8.setHorizontalAlignment(SwingConstants.LEADING);
      seat8.setBounds(102, 297, 60, 60);
      seat8.setActionCommand("8");
      seat8.addActionListener(this);
      btnGroup.add(seat8);

   //   JButton seat9 = new JButton("9");
      seat9.setBackground(Color.WHITE);
      seat9.setForeground(SystemColor.activeCaption);
      seat9.setFont(new Font("굴림", Font.BOLD, 10));
      seat9.setVerticalAlignment(SwingConstants.TOP);
      seat9.setHorizontalAlignment(SwingConstants.LEFT);
      seat9.setBounds(208, 117, 60, 60);
      seat9.setActionCommand("9");
      seat9.addActionListener(this);
      btnGroup.add(seat9);

   //   JButton seat10 = new JButton("10");
      seat10.setBackground(Color.WHITE);
      seat10.setForeground(SystemColor.activeCaption);
      seat10.setFont(new Font("굴림", Font.BOLD, 10));
      seat10.setVerticalAlignment(SwingConstants.TOP);
      seat10.setHorizontalAlignment(SwingConstants.LEFT);
      seat10.setBounds(208, 177, 60, 60);
      seat10.setActionCommand("10");
      seat10.addActionListener(this);
      btnGroup.add(seat10);

   //   JButton seat11 = new JButton("11");
      seat11.setBackground(Color.WHITE);
      seat11.setForeground(SystemColor.activeCaption);
      seat11.setFont(new Font("굴림", Font.BOLD, 10));
      seat11.setVerticalAlignment(SwingConstants.TOP);
      seat11.setHorizontalAlignment(SwingConstants.LEFT);
      seat11.setBounds(208, 236, 60, 60);
      seat11.setActionCommand("11");
      seat11.addActionListener(this);
      btnGroup.add(seat11);

   //   JButton seat12 = new JButton("12");
      seat12.setBackground(Color.WHITE);
      seat12.setForeground(SystemColor.activeCaption);
      seat12.setFont(new Font("굴림", Font.BOLD, 10));
      seat12.setVerticalAlignment(SwingConstants.TOP);
      seat12.setHorizontalAlignment(SwingConstants.LEFT);
      seat12.setBounds(208, 297, 60, 60);
      seat12.setActionCommand("12");
      seat12.addActionListener(this);
      btnGroup.add(seat12);

 //     JButton seat13 = new JButton("13");
      seat13.setBackground(Color.WHITE);
      seat13.setForeground(SystemColor.activeCaption);
      seat13.setFont(new Font("굴림", Font.BOLD, 10));
      seat13.setVerticalAlignment(SwingConstants.TOP);
      seat13.setHorizontalAlignment(SwingConstants.LEFT);
      seat13.setBounds(268, 117, 60, 60);
      seat13.setActionCommand("13");
      seat13.addActionListener(this);
      btnGroup.add(seat13);

   //   JButton seat14 = new JButton("14");
      seat14.setBackground(Color.WHITE);
      seat14.setForeground(SystemColor.activeCaption);
      seat14.setFont(new Font("굴림", Font.BOLD, 10));
      seat14.setVerticalAlignment(SwingConstants.TOP);
      seat14.setHorizontalAlignment(SwingConstants.LEFT);
      seat14.setBounds(268, 177, 60, 60);
      seat14.setActionCommand("14");
      seat14.addActionListener(this);
      btnGroup.add(seat14);

   //   JButton seat15 = new JButton("15");
      seat15.setBackground(Color.WHITE);
      seat15.setForeground(SystemColor.activeCaption);
      seat15.setFont(new Font("굴림", Font.BOLD, 10));
      seat15.setVerticalAlignment(SwingConstants.TOP);
      seat15.setHorizontalAlignment(SwingConstants.LEFT);
      seat15.setBounds(268, 236, 60, 60);
      seat15.setActionCommand("15");
      seat15.addActionListener(this);
      btnGroup.add(seat15);

 //     JButton seat16 = new JButton("16");
//      seat16.addActionListener(new ActionListener() {
//         public void actionPerformed(ActionEvent e) {
//         }
//      });
      seat16.setBackground(Color.WHITE);
      seat16.setForeground(SystemColor.activeCaption);
      seat16.setFont(new Font("굴림", Font.BOLD, 10));
      seat16.setVerticalAlignment(SwingConstants.TOP);
      seat16.setHorizontalAlignment(SwingConstants.LEFT);
      seat16.setBounds(268, 297, 60, 60);
      seat16.setActionCommand("16");
      seat16.addActionListener(this);
      btnGroup.add(seat16);

  //    JButton seat17 = new JButton("17");
      seat17.setBackground(Color.WHITE);
      seat17.setForeground(SystemColor.activeCaption);
      seat17.setFont(new Font("굴림", Font.BOLD, 10));
      seat17.setVerticalAlignment(SwingConstants.TOP);
      seat17.setHorizontalAlignment(SwingConstants.LEFT);
      seat17.setBounds(405, 117, 60, 60);
      seat17.setActionCommand("17");
      seat17.addActionListener(this);
      btnGroup.add(seat17);

   //   JButton seat18 = new JButton("18");
      seat18.setBackground(Color.WHITE);
      seat18.setForeground(SystemColor.activeCaption);
      seat18.setFont(new Font("굴림", Font.BOLD, 10));
      seat18.setVerticalAlignment(SwingConstants.TOP);
      seat18.setHorizontalAlignment(SwingConstants.LEFT);
      seat18.setBounds(464, 117, 60, 60);
      seat18.setActionCommand("18");
      seat18.addActionListener(this);
      btnGroup.add(seat18);

    //  JButton seat24 = new JButton("24");
      seat24.setBackground(Color.WHITE);
      seat24.setForeground(SystemColor.activeCaption);
      seat24.setFont(new Font("굴림", Font.BOLD, 10));
      seat24.setVerticalAlignment(SwingConstants.TOP);
      seat24.setHorizontalAlignment(SwingConstants.LEFT);
      seat24.setBounds(405, 177, 60, 60);
      seat24.setActionCommand("24");
      seat24.addActionListener(this);
      btnGroup.add(seat24);

   //   JButton seat19 = new JButton("19");
      seat19.setBackground(Color.WHITE);
      seat19.setForeground(SystemColor.activeCaption);
      seat19.setFont(new Font("굴림", Font.BOLD, 10));
      seat19.setVerticalAlignment(SwingConstants.TOP);
      seat19.setHorizontalAlignment(SwingConstants.LEFT);
      seat19.setBounds(523, 117, 60, 60);
      seat19.setActionCommand("19");
      seat19.addActionListener(this);
      btnGroup.add(seat19);

   //   JButton seat20 = new JButton("20");
      seat20.setBackground(Color.WHITE);
      seat20.setForeground(SystemColor.activeCaption);
      seat20.setFont(new Font("굴림", Font.BOLD, 10));
      seat20.setVerticalAlignment(SwingConstants.TOP);
      seat20.setHorizontalAlignment(SwingConstants.LEFT);
      seat20.setBounds(583, 117, 60, 60);
      seat20.setActionCommand("20");
      seat20.addActionListener(this);
      btnGroup.add(seat20);

   //   JButton seat25 = new JButton("25");
      seat25.setBackground(Color.WHITE);
      seat25.setForeground(SystemColor.activeCaption);
      seat25.setFont(new Font("굴림", Font.BOLD, 10));
      seat25.setVerticalAlignment(SwingConstants.TOP);
      seat25.setHorizontalAlignment(SwingConstants.LEFT);
      seat25.setBounds(464, 177, 60, 60);
      seat25.setActionCommand("25");
      seat25.addActionListener(this);
      btnGroup.add(seat25);

   //   JButton seat26 = new JButton("26");
      seat26.setBackground(Color.WHITE);
      seat26.setForeground(SystemColor.activeCaption);
      seat26.setFont(new Font("굴림", Font.BOLD, 10));
      seat26.setVerticalAlignment(SwingConstants.TOP);
      seat26.setHorizontalAlignment(SwingConstants.LEFT);
      seat26.setBounds(523, 177, 60, 60);
      seat26.setActionCommand("26");
      seat26.addActionListener(this);
      btnGroup.add(seat26);

 //     JButton seat27 = new JButton("27");
//      seat27.addActionListener(new ActionListener() {
//         public void actionPerformed(ActionEvent e) {
//         }
//      });
      seat27.setBackground(Color.WHITE);
      seat27.setForeground(SystemColor.activeCaption);
      seat27.setFont(new Font("굴림", Font.BOLD, 10));
      seat27.setVerticalAlignment(SwingConstants.TOP);
      seat27.setHorizontalAlignment(SwingConstants.LEFT);
      seat27.setBounds(583, 177, 60, 60);
      seat27.setActionCommand("27");
      seat27.addActionListener(this);
      btnGroup.add(seat27);

  //    JButton seat21 = new JButton("21");
      seat21.setBackground(Color.WHITE);
      seat21.setForeground(SystemColor.activeCaption);
      seat21.setFont(new Font("굴림", Font.BOLD, 10));
      seat21.setVerticalAlignment(SwingConstants.TOP);
      seat21.setHorizontalAlignment(SwingConstants.LEFT);
      seat21.setBounds(642, 117, 60, 60);
      seat21.setActionCommand("21");
      seat21.addActionListener(this);
      btnGroup.add(seat21);

  //    JButton seat28 = new JButton("28");
      seat28.setBackground(Color.WHITE);
      seat28.setForeground(SystemColor.activeCaption);
      seat28.setFont(new Font("굴림", Font.BOLD, 10));
      seat28.setVerticalAlignment(SwingConstants.TOP);
      seat28.setHorizontalAlignment(SwingConstants.LEFT);
      seat28.setBounds(642, 177, 60, 60);
      seat28.setActionCommand("28");
      seat28.addActionListener(this);
      btnGroup.add(seat28);

   //   JButton seat22 = new JButton("22");
      seat22.setBackground(Color.WHITE);
      seat22.setForeground(SystemColor.activeCaption);
      seat22.setFont(new Font("굴림", Font.BOLD, 10));
      seat22.setVerticalAlignment(SwingConstants.TOP);
      seat22.setHorizontalAlignment(SwingConstants.LEFT);
      seat22.setBounds(702, 117, 60, 60);
      seat22.setActionCommand("22");
      seat22.addActionListener(this);
      btnGroup.add(seat22);

    //  JButton seat29 = new JButton("29");
      seat29.setBackground(Color.WHITE);
      seat29.setForeground(SystemColor.activeCaption);
      seat29.setFont(new Font("굴림", Font.BOLD, 10));
      seat29.setVerticalAlignment(SwingConstants.TOP);
      seat29.setHorizontalAlignment(SwingConstants.LEFT);
      seat29.setBounds(702, 177, 60, 60);
      seat29.setActionCommand("29");
      seat29.addActionListener(this);
      btnGroup.add(seat29);

   //   JButton seat23 = new JButton("23");
      seat23.setBackground(Color.WHITE);
      seat23.setForeground(SystemColor.activeCaption);
      seat23.setFont(new Font("굴림", Font.BOLD, 10));
      seat23.setVerticalAlignment(SwingConstants.TOP);
      seat23.setHorizontalAlignment(SwingConstants.LEFT);
      seat23.setBounds(761, 117, 60, 60);
      seat23.setActionCommand("23");
      seat23.addActionListener(this);
      btnGroup.add(seat23);

   //   JButton seat30 = new JButton("30");
      seat30.setBackground(Color.WHITE);
      seat30.setForeground(SystemColor.activeCaption);
      seat30.setFont(new Font("굴림", Font.BOLD, 10));
      seat30.setVerticalAlignment(SwingConstants.TOP);
      seat30.setHorizontalAlignment(SwingConstants.LEFT);
      seat30.setBounds(761, 177, 60, 60);
      seat30.setActionCommand("30");
      seat30.addActionListener(this);
      btnGroup.add(seat30);
      
      JButton[] btn = new JButton[] {seat1,seat2,seat3,seat4,seat5,seat6,seat7,seat8,seat9,seat10,seat11,seat12,seat13,seat14,seat15,seat16,
    		  seat17,seat18,seat19,seat20,seat21,seat22,seat23,seat24,seat25,seat26,seat27,seat28,seat29,seat30};
      for(int i=0; i<btn.length; i++) {
    	  userbtnMap.put(Integer.toString(i+1), btn[i]);
      }
//      System.out.println(userbtnMap);
      
      seat_t.setLayout(null);
      seat_t.add(seat1);
      seat_t.add(seat5);
      seat_t.add(seat2);
      seat_t.add(seat6);
      seat_t.add(seat3);
      seat_t.add(seat7);
      seat_t.add(seat4);
      seat_t.add(seat8);
      seat_t.add(seat9);
      seat_t.add(seat10);
      seat_t.add(seat11);
      seat_t.add(seat12);
      seat_t.add(seat13);
      seat_t.add(seat14);
      seat_t.add(seat15);
      seat_t.add(seat16);
      seat_t.add(seat17);
      seat_t.add(seat18);
      seat_t.add(seat24);
      seat_t.add(seat19);
      seat_t.add(seat20);
      seat_t.add(seat25);
      seat_t.add(seat26);
      seat_t.add(seat27);
      seat_t.add(seat21);
      seat_t.add(seat28);
      seat_t.add(seat22);
      seat_t.add(seat29);
      seat_t.add(seat23);
      seat_t.add(seat30);
      
      System.out.println(btnGroup.getButtonCount());

//      String header[] = { "메뉴번호", "메뉴명", "가격", "분류" };
//      JButton btn = new JButton("버튼");
      
     
   }
   
   
   public static JButton btnIdentifier(String seat) {
	   
	   switch(seat) {
	   case "1": return seat1;
	   case "2": return seat2;
	   case "3": return seat3;
	   case "4": return seat4;
	   case "5": return seat5;
	   case "6": return seat6;
	   case "7": return seat7;
	   case "8": return seat8;
	   case "9": return seat9;
	   case "10": return seat10;
	   case "11": return seat11;
	   case "12": return seat12;
	   case "13": return seat13;
	   case "14": return seat14;
	   case "15": return seat15;
	   case "16": return seat16;
	   case "17": return seat17;
	   case "18": return seat18;
	   case "19": return seat19;
	   case "20": return seat20;
	   case "21": return seat21;
	   case "22": return seat22;
	   case "23": return seat23;
	   case "24": return seat24;
	   case "25": return seat25;
	   case "26": return seat26;
	   case "27": return seat27;
	   case "28": return seat28;
	   case "29": return seat29;
	   case "30": return seat30;

	   
	   }
	return null;
	   
   }
   
   @Override
   public void actionPerformed(ActionEvent e) {
//	   System.out.println(e.paramString());
//	   System.out.println(btnGroup.getButtonCount());
//	   ButtonModel b = btnGroup.getSelection();
	  String seatNum;
//	   seatNum = b.getActionCommand();
////	   Class<? extends ActionEvent> b = e.getClass();//btnGroup.getSelection();
//	   System.out.println(b);
////	   if(seatNum.equals("1")) JOptionPane.showInternalMessageDialog(null, "hi");
//	   System.out.println(seatNum);
	   
	   
//	   if(b!= null) {
//		   seatNum = b.getActionCommand();
//		   LoginPage loginPage = new LoginPage(seatNum);
//	   }
//	   if(e.getSource()==btnGroup) {
////		   seatNum = btnGroup.getSelection().getActionCommand();
////		   jframe.dispose();
//		   LoginPage loginPage = new LoginPage(seatNum);
//	   }
//      if (e.getSource() == seat1) {
//    	  seatNum = seat1.getActionCommand();
////    	 jframe.dispose();
//    	  seat1.setEnabled(false);
//         LoginPage loginPage = new LoginPage(seatNum);
//      }
//      if (e.getSource() == seat2) {
//    	  seatNum = seat2.getActionCommand();
////    	 jframe.dispose();
//         LoginPage loginPage = new LoginPage(seatNum);
//      }
//      
//      if (e.getSource() == seat5) {
//    	  seatNum = seat5.getActionCommand();
////    	 jframe.dispose();
//         LoginPage loginPage = new LoginPage(seatNum);
//      }
      
      
      if (e.getSource() == seat1) {
          seatNum = seat1.getActionCommand();
          seat1.setEnabled(false);
          loginUI loginPage = new loginUI(seatNum);
       }
       
       if (e.getSource() == seat2) {
          seatNum = seat2.getActionCommand();
          seat2.setEnabled(false);
          loginUI loginPage = new loginUI(seatNum);
       }
       
       if (e.getSource() == seat3) {
          seatNum = seat3.getActionCommand();
          seat3.setEnabled(false);
          loginUI loginPage = new loginUI(seatNum);
       }
       
       if (e.getSource() == seat4) {
          seatNum = seat4.getActionCommand();
          seat4.setEnabled(false);
          loginUI loginPage = new loginUI(seatNum);
       }
       
       if (e.getSource() == seat5) {
          seatNum = seat5.getActionCommand();
          seat5.setEnabled(false);
          loginUI loginPage = new loginUI(seatNum);
       }
       
       if (e.getSource() == seat6) {
          seatNum = seat6.getActionCommand();
          seat6.setEnabled(false);
          loginUI loginPage = new loginUI(seatNum);
       }
       
       if (e.getSource() == seat7) {
          seatNum = seat7.getActionCommand();
          seat7.setEnabled(false);
          loginUI loginPage = new loginUI(seatNum);
       }
       
       if (e.getSource() == seat8) {
          seatNum = seat8.getActionCommand();
          seat8.setEnabled(false);
          loginUI loginPage = new loginUI(seatNum);
       }
       
       if (e.getSource() == seat9) {
          seatNum = seat9.getActionCommand();
          seat9.setEnabled(false);
          loginUI loginPage = new loginUI(seatNum);
       }
       
       if (e.getSource() == seat10) {
          seatNum = seat10.getActionCommand();
          seat10.setEnabled(false);
          loginUI loginPage = new loginUI(seatNum);
       }

       if (e.getSource() == seat11) {
          seatNum = seat11.getActionCommand();
          seat11.setEnabled(false);
          loginUI loginPage = new loginUI(seatNum);
       }
       
       if (e.getSource() == seat12) {
          seatNum = seat12.getActionCommand();
          seat12.setEnabled(false);
          loginUI loginPage = new loginUI(seatNum);
       }
       
       if (e.getSource() == seat13) {
          seatNum = seat13.getActionCommand();
          seat13.setEnabled(false);
          loginUI loginPage = new loginUI(seatNum);
       }
       
       if (e.getSource() == seat14) {
          seatNum = seat14.getActionCommand();
          seat14.setEnabled(false);
          loginUI loginPage = new loginUI(seatNum);
       }
       
       if (e.getSource() == seat15) {
          seatNum = seat15.getActionCommand();
          seat15.setEnabled(false);
          loginUI loginPage = new loginUI(seatNum);
       }
       
       if (e.getSource() == seat16) {
          seatNum = seat16.getActionCommand();
          seat16.setEnabled(false);
          loginUI loginPage = new loginUI(seatNum);
       }
       
       if (e.getSource() == seat17) {
          seatNum = seat17.getActionCommand();
          seat17.setEnabled(false);
          loginUI loginPage = new loginUI(seatNum);
       }
       
       if (e.getSource() == seat18) {
          seatNum = seat18.getActionCommand();
          seat18.setEnabled(false);
          loginUI loginPage = new loginUI(seatNum);
       }
       
       if (e.getSource() == seat19) {
          seatNum = seat19.getActionCommand();
          seat19.setEnabled(false);
          loginUI loginPage = new loginUI(seatNum);
       }
       
       if (e.getSource() == seat20) {
          seatNum = seat20.getActionCommand();
          seat20.setEnabled(false);
          loginUI loginPage = new loginUI(seatNum);
       }
       
       if (e.getSource() == seat21) {
          seatNum = seat21.getActionCommand();
          seat21.setEnabled(false);
          loginUI loginPage = new loginUI(seatNum);
       }
       
       if (e.getSource() == seat22) {
          seatNum = seat22.getActionCommand();
          seat22.setEnabled(false);
          loginUI loginPage = new loginUI(seatNum);
       }
       
       if (e.getSource() == seat23) {
          seatNum = seat23.getActionCommand();
          seat23.setEnabled(false);
          loginUI loginPage = new loginUI(seatNum);
       }
       
       if (e.getSource() == seat24) {
          seatNum = seat24.getActionCommand();
          seat24.setEnabled(false);
          loginUI loginPage = new loginUI(seatNum);
       }
       
       if (e.getSource() == seat25) {
          seatNum = seat25.getActionCommand();
          seat25.setEnabled(false);
          loginUI loginPage = new loginUI(seatNum);
       }
       
       if (e.getSource() == seat26) {
          seatNum = seat26.getActionCommand();
          seat26.setEnabled(false);
          loginUI loginPage = new loginUI(seatNum);
       }
       
       if (e.getSource() == seat27) {
          seatNum = seat27.getActionCommand();
          seat27.setEnabled(false);
          loginUI loginPage = new loginUI(seatNum);
       }
       
       if (e.getSource() == seat28) {
          seatNum = seat28.getActionCommand();
          seat28.setEnabled(false);
          loginUI loginPage = new loginUI(seatNum);
       }
       
       if (e.getSource() == seat29) {
          seatNum = seat29.getActionCommand();
          seat29.setEnabled(false);
          loginUI loginPage = new loginUI(seatNum);
       }
       
       if (e.getSource() == seat30) {
          seatNum = seat30.getActionCommand();
          seat30.setEnabled(false);
          loginUI loginPage = new loginUI(seatNum);
       }
       

   }
}