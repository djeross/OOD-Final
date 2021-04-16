package presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import business.*;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.text.MaskFormatter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;
import javax.swing.border.BevelBorder;
import com.toedter.calendar.JDateChooser;
import javax.swing.JList;
import javax.swing.JFormattedTextField;
import javax.swing.JCheckBox;
import java.awt.Rectangle;
import java.awt.Toolkit;
import com.toedter.calendar.JCalendar;
import javax.swing.JSplitPane;
import javax.swing.JLayeredPane;
import javax.swing.JSeparator;
public class TRKGUI {

	private JFrame frmResourceSchedulingApp;
	private final ButtonGroup options_buttonGroup = new ButtonGroup();
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_id_3;
	private TrkAPP app;
	private JTextField wrapusername;
	private JTextField wrappassword;
	private JTable ScheduleEquipmentTable;
	private JTextField txtpnInvalidCredentialsEntered;
	private DefaultListModel<String> listModel = new DefaultListModel<String>();
	private DefaultListModel<String> listModel1 = new DefaultListModel<String>();
	private DefaultListModel<String> listModel2 = new DefaultListModel<String>();
	private DefaultListModel<String> modifyeqplistModel = new DefaultListModel<String>();
	JList<String> resourcelist = new JList<String>(listModel);
	private JTable addPrelimTable;
	private static int end = 100;
	private JTextField search;
	private JTable dInventoryTable;
	private JTable schedule_table;
	private JTable event_table;
	JTable inventorytable = new JTable();
	private JTable viewInvtable;
	private JTextField search_2;
	private JTable sInventoryTable;
	
	private Image saveicon =new ImageIcon(TRKGUI.class.getResource("/media/diskette.png")).getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
	private Image updateicon =new ImageIcon(TRKGUI.class.getResource("/media/update.png")).getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
	private Image backicon =new ImageIcon(TRKGUI.class.getResource("/media/previous.png")).getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
	private Image selecticon =new ImageIcon(TRKGUI.class.getResource("/media/selection.png")).getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
	private Image unlock =new ImageIcon(TRKGUI.class.getResource("/media/unlock.png")).getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
	private Image keyicon =new ImageIcon(TRKGUI.class.getResource("/media/key.png")).getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
	private Image addplus =new ImageIcon(TRKGUI.class.getResource("/media/add.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image arrowrevicon = new ImageIcon(TRKGUI.class.getResource("/media/arrowsrev.png")).getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
	private Image arrowicon = new ImageIcon(TRKGUI.class.getResource("/media/arrows.png")).getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
	private Image idsearchicon = new ImageIcon(TRKGUI.class.getResource("/media/searchid.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image namesearchicon = new ImageIcon(TRKGUI.class.getResource("/media/searchname.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image deleteiconsmall =new ImageIcon(TRKGUI.class.getResource("/media/delete.png")).getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
	private Image stockicon =new ImageIcon(TRKGUI.class.getResource("/media/stock.png")).getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
	private Image scheduleicon =new ImageIcon(TRKGUI.class.getResource("/media/schedule.png")).getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
	private Image trkicon =new ImageIcon(TRKGUI.class.getResource("/media/trklogo.jpg")).getImage().getScaledInstance(22, 22, Image.SCALE_SMOOTH);
	private Image viewicon = new ImageIcon(TRKGUI.class.getResource("/media/eye.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image returnicon = new ImageIcon(TRKGUI.class.getResource("/media/returnbox.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private JTable eventidscheduletable;
	private JTextField displaystartime;
	private JTextField displayendtime;
	private JTextField displayLocation;
	private JTextField displayEndDate;
	private JTextField displayStartDate;
	private final JTable return_equipment_table = new JTable();
	private final JPanel mS4_1_1_1 = new JPanel();
	private final JLabel ms_Label_2_1_1 = new JLabel("Location");
	private final JLabel ms_Label_3_1_1 = new JLabel("Start Date");
	private final JLabel s_Label_id_1_1_1 = new JLabel("End Date ");
	private final JLabel ms_Label_4_1_1 = new JLabel("Start Time");
	private final JTextField aStartDate = new JTextField();
	private final JLabel ms_Label_5_1_1 = new JLabel("End Time");
	private final JTextField aEndTime = new JTextField();
	private final JTextField aLocation = new JTextField();
	private final JTextField aEndDate = new JTextField();
	private final JTextField aStartTime = new JTextField();
	private final JLabel lblNewLabel_20_1 = new JLabel("");
	private final JScrollPane scrollPane_12_1 = new JScrollPane();
	private final JList list_1 = new JList(listModel2);
	private final JButton aRSelect_btn = new JButton("Select", null);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					try {
					    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
					        if ("Nimbus".equals(info.getName())) {
					            UIManager.setLookAndFeel(info.getClassName());
					            break;
					        }
					    }
					} catch (Exception e) {
					    // If Nimbus is not available, you can set the GUI to another look and feel.
					}
					TRKGUI window = new TRKGUI(new TrkAPP());
					window.frmResourceSchedulingApp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws MalformedURLException 
	 */
	public TRKGUI(TrkAPP app) throws ParseException, MalformedURLException, IOException {
		this.app=app;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws MalformedURLException 
	 */
	private void initialize() throws ParseException, MalformedURLException, IOException {
		frmResourceSchedulingApp = new JFrame();
		frmResourceSchedulingApp.setIconImage(Toolkit.getDefaultToolkit().getImage(TRKGUI.class.getResource("/media/trklogo.jpg")));
		frmResourceSchedulingApp.setTitle("Resource Scheduling App");
		frmResourceSchedulingApp.setBounds(250, 40, 1000, 700);
		frmResourceSchedulingApp.setResizable(false);
		frmResourceSchedulingApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MaskFormatter timemask=new MaskFormatter("##:##");
		timemask.setPlaceholderCharacter('_');
		
		
		JPanel panel = new JPanel();
		frmResourceSchedulingApp.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new CardLayout(0, 0));
		
		/**
		 * The contents of the login card/page
		 */
		JPanel login_panel = new JPanel();
		panel.add(login_panel, "login");
		login_panel.setLayout(null);
		
		JPanel l4 = new JPanel();
		l4.setBorder(new LineBorder(Color.WHITE, 2));
		l4.setBounds(232, 56, 506, 534);
		login_panel.add(l4);
		
		JLabel Username_Label = new JLabel("Username:");
		Username_Label.setBounds(94, 152, 116, 31);
		Username_Label.setFont(new Font("Modern No. 20", Font.BOLD, 25));
		
		JLabel Password_Label = new JLabel("Password:");
		Password_Label.setBounds(104, 236, 107, 27);
		Password_Label.setFont(new Font("Modern No. 20", Font.BOLD, 25));
		
		//image
		
		JButton login_button = new JButton("Login",new ImageIcon(unlock));
		login_button.setFocusable(false);
		login_button.setIconTextGap(15);
		login_button.setBackground(Color.BLACK);
		login_button.setForeground(Color.WHITE);
		login_button.setBounds(192, 310, 136, 45);
		login_button.setVerticalTextPosition(SwingConstants.CENTER);
		login_button.setHorizontalTextPosition(SwingConstants.LEFT);
		login_button.setFont(new Font("Tahoma", Font.BOLD, 18));
		l4.setLayout(null);
		
		
		
		JTextField Username_Field = new JTextField();
		Username_Field.setBorder(null);
		Username_Field.setBounds(222, 151, 145, 31);
		Username_Field.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Username_Field.setColumns(15);
		l4.add(Username_Field);
		
		
		JPasswordField password_Field = new JPasswordField();
		password_Field.setBorder(null);
		password_Field.setBounds(223, 233, 147, 31);
		password_Field.setFont(new Font("Tahoma", Font.PLAIN, 14));
		password_Field.setColumns(15);
		l4.add(password_Field);
		JLabel keyiconlabel = new JLabel("");
		keyiconlabel.setIcon(new ImageIcon(keyicon));
		keyiconlabel.setBounds(378, 238, 28, 24);
		l4.add(keyiconlabel);
		l4.add(Username_Label);
		l4.add(Password_Label);
		l4.add(login_button);
		//image
		JLabel usericonlabel = new JLabel("");
		Image useicon =new ImageIcon(TRKGUI.class.getResource("/media/user.png")).getImage().getScaledInstance(28, 28, Image.SCALE_SMOOTH);
		usericonlabel.setIcon(new ImageIcon(useicon));
		usericonlabel.setBounds(378, 156, 28, 24);
		l4.add(usericonlabel);
		
		wrapusername = new JTextField();
		wrapusername.setSelectionColor(Color.BLACK);
		wrapusername.setBackground(Color.WHITE);
		wrapusername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		wrapusername.setEditable(false);
		wrapusername.setBounds(220, 149, 186, 35);
		l4.add(wrapusername);
		wrapusername.setColumns(10);
		
		wrappassword = new JTextField();
		wrappassword.setSelectionColor(Color.BLACK);
		wrappassword.setBackground(Color.WHITE);
		wrappassword.setEditable(false);
		wrappassword.setColumns(10);
		wrappassword.setBounds(221, 231, 186, 35);
		l4.add(wrappassword);
		
		JLabel lblNewLabel_1 = new JLabel("LOGIN");
		lblNewLabel_1.setFont(new Font("Modern No. 20", Font.PLAIN, 58));
		lblNewLabel_1.setBounds(166, 23, 186, 62);
		l4.add(lblNewLabel_1);
		
		
		JPanel l5 = new JPanel();
		l5.setBounds(0, 517, 994, 164);
		login_panel.add(l5);
		l5.setBackground(new Color(0, 0, 0));
		l5.setLayout(null);
		
		JLabel lblNewLabel_18 = new JLabel("Copyright \u00A9 Group 6 Inc.");
		lblNewLabel_18.setForeground(Color.WHITE);
		lblNewLabel_18.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_18.setBounds(10, 92, 203, 25);
		l5.add(lblNewLabel_18);
		
		JPanel l1 = new JPanel();
		l1.setBackground(Color.BLACK);
		l1.setBounds(0, 0, 994, 158);
		FlowLayout fl_l1 = (FlowLayout) l1.getLayout();
		fl_l1.setVgap(70);
		login_panel.add(l1);
		
		
		
		
		JPanel l2 = new JPanel();
		l2.setBackground(new Color(184, 134, 11));
		l2.setBounds(0, 158, 240, 360);
		login_panel.add(l2);
		l2.setLayout(null);
		
		
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setBounds(0, 0, 234, 360);
		l2.add(lblNewLabel_11);
		
		Image party1 =new ImageIcon(TRKGUI.class.getResource("/media/partyimage.jpg")).getImage().getScaledInstance(259, 360, Image.SCALE_SMOOTH);
		lblNewLabel_11.setIcon(new ImageIcon(party1));
		
		
		
		JPanel l3 = new JPanel();
		l3.setBackground(new Color(184, 134, 11));
		l3.setBounds(738, 158, 256, 360);
		login_panel.add(l3);
		l3.setLayout(null);
		
		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setBounds(0, 0, 256, 360);
		l3.add(lblNewLabel_12);
		Image party2 =new ImageIcon(TRKGUI.class.getResource("/media/partyimage.jpg")).getImage().getScaledInstance(256, 360, Image.SCALE_SMOOTH);
		lblNewLabel_12.setIcon(new ImageIcon(party2));
		
		JPanel options_panel2 = new JPanel();
		panel.add(options_panel2, "name_255827648248700");
		options_panel2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_1.getLayout();
		flowLayout_2.setHgap(100);
		flowLayout_2.setVgap(100);
		options_panel2.add(panel_1, BorderLayout.WEST);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_2.getLayout();
		flowLayout_3.setHgap(100);
		options_panel2.add(panel_2, BorderLayout.EAST);
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setVgap(50);
		flowLayout.setHgap(50);
		options_panel2.add(panel_3, BorderLayout.NORTH);
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_4.getLayout();
		flowLayout_1.setVgap(50);
		options_panel2.add(panel_4, BorderLayout.SOUTH);
		
		JPanel panel_5 = new JPanel();
		options_panel2.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.Y_AXIS));
		
		JPanel options_1 = new JPanel();
		panel_5.add(options_1);
		options_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton schedule_button_1 = new JButton("Schedule Equipment");
		schedule_button_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		options_1.add(schedule_button_1);
		
		JButton search_button_1 = new JButton("Search");
		search_button_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		options_1.add(search_button_1);
		
		JButton viewSch_button_1 = new JButton("View Schedule");
		viewSch_button_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		options_1.add(viewSch_button_1);

		JPanel OwnerMenu = new JPanel();
		panel.add(OwnerMenu, "options");
		OwnerMenu.setLayout(null);
		
		JPanel options = new JPanel();
		options.setBounds(54, 100, 888, 490);
		
		JButton addEqu_button = new JButton("Add Equipment",new ImageIcon(addplus));
		addEqu_button.setFocusable(false);
		addEqu_button.setIconTextGap(20);
		addEqu_button.setBounds(10, 44, 237, 53);
		addEqu_button.setFont(new Font("Tahoma", Font.BOLD, 16));
		addEqu_button.setVerticalTextPosition(SwingConstants.CENTER);
		addEqu_button.setHorizontalTextPosition(SwingConstants.LEFT);
		options_buttonGroup.add(addEqu_button);
		
		Image modicon =new ImageIcon(TRKGUI.class.getResource("/media/modifyeq.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		JButton modEqu_button = new JButton("Modify Equipment",new ImageIcon(modicon));
		modEqu_button.setFocusable(false);
		modEqu_button.setBounds(10, 134, 237, 53);
		modEqu_button.setFont(new Font("Tahoma", Font.BOLD, 16));
		modEqu_button.setIconTextGap(20);
		modEqu_button.setVerticalTextPosition(SwingConstants.CENTER);
		modEqu_button.setHorizontalTextPosition(SwingConstants.LEFT);
		options_buttonGroup.add(modEqu_button);
		
		Image deleteicon =new ImageIcon(TRKGUI.class.getResource("/media/delete.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		JButton delEqu_button = new JButton("Delete Equipment",new ImageIcon(deleteicon));
		delEqu_button.setFocusable(false);
		delEqu_button.setBounds(10, 316, 237, 53);
		delEqu_button.setFont(new Font("Tahoma", Font.BOLD, 16));
		delEqu_button.setVerticalTextPosition(SwingConstants.CENTER);
		delEqu_button.setHorizontalTextPosition(SwingConstants.LEFT);
		options_buttonGroup.add(delEqu_button);
		
		Image schedule_eqp =new ImageIcon(TRKGUI.class.getResource("/media/schedule_eqp.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		JButton schedule_button = new JButton("Schedule Equipment", new ImageIcon(schedule_eqp));
		schedule_button.setFocusable(false);
		schedule_button.setBounds(290, 44, 302, 53);
		schedule_button.setFont(new Font("Tahoma", Font.BOLD, 16));
		schedule_button.setVerticalTextPosition(SwingConstants.CENTER);
		schedule_button.setHorizontalTextPosition(SwingConstants.LEFT);
		schedule_button.setIconTextGap(20);
		options_buttonGroup.add(schedule_button);
		
		Image mods =new ImageIcon(TRKGUI.class.getResource("/media/modifys.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		JButton modSch_button = new JButton("Modify Schedule", new ImageIcon(mods));
		modSch_button.setFocusable(false);
		modSch_button.setBounds(290, 134, 302, 53);
		modSch_button.setFont(new Font("Tahoma", Font.BOLD, 16));
		modSch_button.setVerticalTextPosition(SwingConstants.CENTER);
		modSch_button.setHorizontalTextPosition(SwingConstants.LEFT);
		modSch_button.setIconTextGap(20);
		options_buttonGroup.add(modSch_button);
		
		Image searchicon = new ImageIcon(TRKGUI.class.getResource("/media/search.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		JButton search_button = new JButton("Search",new ImageIcon(searchicon));
		search_button.setFocusable(false);
		search_button.setBounds(10, 225, 237, 53);
		search_button.setFont(new Font("Tahoma", Font.BOLD, 16));
		search_button.setIconTextGap(20);
		search_button.setVerticalTextPosition(SwingConstants.CENTER);
		search_button.setHorizontalTextPosition(SwingConstants.LEFT);
		options_buttonGroup.add(search_button);
		
		Image viewschicon = new ImageIcon(TRKGUI.class.getResource("/media/view.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		JButton viewSch_button = new JButton("View Schedule Details", new ImageIcon(viewschicon));
		viewSch_button.setFocusable(false);
		viewSch_button.setBounds(290, 225, 302, 53);
		viewSch_button.setFont(new Font("Tahoma", Font.BOLD, 16));
		viewSch_button.setIconTextGap(20);
		viewSch_button.setVerticalTextPosition(SwingConstants.CENTER);
		viewSch_button.setHorizontalTextPosition(SwingConstants.LEFT);
		options_buttonGroup.add(viewSch_button);
		
		OwnerMenu.add(options);
		options.setLayout(null);
		
		Image allschicon = new ImageIcon(TRKGUI.class.getResource("/media/allschedule.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		JButton all_schedule_btn = new JButton("View All Schedules",new ImageIcon(allschicon));
		all_schedule_btn.setFocusable(false);
		all_schedule_btn.setFont(new Font("Tahoma", Font.BOLD, 16));
		all_schedule_btn.setBounds(290, 407, 302, 53);
		all_schedule_btn.setIconTextGap(20);
		all_schedule_btn.setVerticalTextPosition(SwingConstants.CENTER);
		all_schedule_btn.setHorizontalTextPosition(SwingConstants.LEFT);
		options.add(all_schedule_btn);
		options_buttonGroup.add(all_schedule_btn);
		
		
		JPanel view_Inventory_panel = new JPanel();
		panel.add(view_Inventory_panel, "name_55314809243000");
		view_Inventory_panel.setLayout(null);
		
		
		viewInvtable = new JTable();
		viewInvtable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Equipment ID", "Equipment Name", "Total Quantity", "Remaining Quantity"
			}
		));
		viewInvtable.setRowHeight(23);
		JTableHeader viewInvtableHeader =viewInvtable.getTableHeader();
		viewInvtableHeader.setFont(new Font("Tahoma", Font.BOLD, 16));
		viewInvtable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Image invicon = new ImageIcon(TRKGUI.class.getResource("/media/inventory.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		JButton view_inv_button = new JButton("View Inventory", new ImageIcon(invicon));
		
		view_inv_button.setFocusable(false);
		view_inv_button.setFont(new Font("Tahoma", Font.BOLD, 16));
		view_inv_button.setBounds(10, 407, 237, 53);
		view_inv_button.setIconTextGap(20);
		view_inv_button.setVerticalTextPosition(SwingConstants.CENTER);
		view_inv_button.setHorizontalTextPosition(SwingConstants.LEFT);
		options.add(view_inv_button);
		options_buttonGroup.add(view_inv_button);
		
		Image reporticon = new ImageIcon(TRKGUI.class.getResource("/media/report.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		JButton Gen_Report_Button = new JButton("Generate Report",new ImageIcon(reporticon));
		Gen_Report_Button.setEnabled(false);
		Gen_Report_Button.setFocusable(false);
		Gen_Report_Button.setFont(new Font("Tahoma", Font.BOLD, 16));
		Gen_Report_Button.setBounds(641, 44, 237, 53);
		Gen_Report_Button.setIconTextGap(20);
		Gen_Report_Button.setVerticalTextPosition(SwingConstants.CENTER);
		Gen_Report_Button.setHorizontalTextPosition(SwingConstants.LEFT);
		options.add(Gen_Report_Button);
		options_buttonGroup.add(Gen_Report_Button);
		
		Image deliveryicon = new ImageIcon(TRKGUI.class.getResource("/media/delivery.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		JButton accept_eqp_button = new JButton("Accept Returned Equipment",new ImageIcon(deliveryicon));
		accept_eqp_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		accept_eqp_button.setEnabled(true);
		accept_eqp_button.setFocusable(false);
		accept_eqp_button.setFont(new Font("Tahoma", Font.BOLD, 16));
		accept_eqp_button.setBounds(290, 316, 302, 53);
		accept_eqp_button.setIconTextGap(10);
		accept_eqp_button.setVerticalTextPosition(SwingConstants.CENTER);
		accept_eqp_button.setHorizontalTextPosition(SwingConstants.LEFT);
		options_buttonGroup.add(accept_eqp_button);
		
		
		
		options.add(accept_eqp_button);
		options.add(addEqu_button);
		options.add(modEqu_button);
		options.add(delEqu_button);
		options.add(search_button);
		options.add(schedule_button);
		options.add(modSch_button);
		options.add(viewSch_button);
		
		JLabel Equipment_Management_Border = new JLabel("");
		Equipment_Management_Border.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Equipment Management", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		Equipment_Management_Border.setBounds(0, 0, 256, 479);
		options.add(Equipment_Management_Border);
		
		JLabel Schedule_Management_Border = new JLabel("");
		Schedule_Management_Border.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Schedule Management", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		Schedule_Management_Border.setBounds(275, 0, 335, 479);
		options.add(Schedule_Management_Border);
		
		JLabel Report_Management_Border = new JLabel("");
		Report_Management_Border.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Report Management", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		Report_Management_Border.setBounds(632, 0, 256, 479);
		options.add(Report_Management_Border);
		
		/**
		 * Options Panel
		 */
		JPanel o1 = new JPanel();
		o1.setBounds(0, 100, 55, 449);
		FlowLayout fl_o1 = (FlowLayout) o1.getLayout();
		fl_o1.setHgap(100);
		fl_o1.setVgap(100);
		OwnerMenu.add(o1);
		
		JPanel o2 = new JPanel();
		o2.setBounds(0, 0, 994, 100);
		OwnerMenu.add(o2);
		o2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MENU");
		lblNewLabel.setBounds(395, 24, 196, 51);
		lblNewLabel.setFont(new Font("Modern No. 20", Font.BOLD, 64));
		o2.add(lblNewLabel);
		
		JPanel o3 = new JPanel();
		o3.setBounds(0, 590, 994, 81);
		FlowLayout fl_o3 = (FlowLayout) o3.getLayout();
		fl_o3.setVgap(50);
		fl_o3.setHgap(50);
		OwnerMenu.add(o3);
		
		JPanel o4 = new JPanel();
		o4.setBounds(939, 100, 55, 449);
		FlowLayout fl_o4 = (FlowLayout) o4.getLayout();
		fl_o4.setVgap(100);
		fl_o4.setHgap(100);
		OwnerMenu.add(o4);
		
		/**
		 * Add Equipment Panel
		 */
		JPanel add_equipment_panel = new JPanel();
		panel.add(add_equipment_panel);
		add_equipment_panel.setLayout(new BorderLayout(0, 0));
		
		JPanel a1 = new JPanel();
		FlowLayout fl_a1 = (FlowLayout) a1.getLayout();
		fl_a1.setHgap(20);
		fl_a1.setVgap(20);
		add_equipment_panel.add(a1, BorderLayout.NORTH);
		
		JLabel a_Label = new JLabel("Add Equipment");
		a_Label.setFont(new Font("Modern No. 20", Font.BOLD, 60));
		a1.add(a_Label);
		
		JPanel a4 = new JPanel();
		add_equipment_panel.add(a4, BorderLayout.CENTER);
		
		JPanel a4_1 = new JPanel();
		a4_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		a4_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Add new equipment to list", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		a4_1.setBounds(93, 74, 809, 300);
		
		JLabel aLabel_1 = new JLabel("Name");
		aLabel_1.setBounds(44, 71, 53, 22);
		aLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JTextField addEquipNameField = new JTextField();
		addEquipNameField.setBounds(121, 66, 224, 33);
		addEquipNameField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		addEquipNameField.setColumns(15);
		
		JLabel aLabel_2 = new JLabel("Quantity");
		aLabel_2.setBounds(44, 135, 78, 22);
		aLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JTextField addEquipQtyField = new JTextField();
		addEquipQtyField.setBounds(121, 131, 224, 33);
		addEquipQtyField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		addEquipQtyField.setColumns(5);
		
		JButton aSave = new JButton("Save",new ImageIcon(saveicon));
		aSave.setIconTextGap(10);
		aSave.setVerticalTextPosition(SwingConstants.CENTER);
		aSave.setHorizontalTextPosition(SwingConstants.LEFT);
		aSave.setBounds(145, 410, 113, 40);
		aSave.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JButton aBack = new JButton("Back", new ImageIcon(backicon));
		aBack.setBounds(725, 410, 103, 40);
		aBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		aBack.setIconTextGap(10);
		aBack.setVerticalTextPosition(SwingConstants.CENTER);
		aBack.setHorizontalTextPosition(SwingConstants.LEFT);
		a4.setLayout(null);
		a4_1.setLayout(null);
		a4_1.add(aLabel_1);
		a4_1.add(addEquipNameField);
		a4_1.add(aLabel_2);
		a4_1.add(addEquipQtyField);
		a4.add(a4_1);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(447, 53, 329, 174);
		a4_1.add(scrollPane_5);
		
		addPrelimTable = new JTable();
		addPrelimTable.setFont(new Font("Tahoma", Font.PLAIN, 11));
		addPrelimTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Equipment Name", "Quantity"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		addPrelimTable.setRowHeight(20);
		JTableHeader addPrelimTableHeader =addPrelimTable.getTableHeader();
		addPrelimTableHeader.setFont(new Font("Tahoma", Font.BOLD, 16));
		addPrelimTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane_5.setViewportView(addPrelimTable);
		
		JButton addToListBtn = new JButton("Add to List",new ImageIcon(arrowicon));
		addToListBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		addToListBtn.setBounds(254, 204, 137, 40);
		addToListBtn.setIconTextGap(10);
		addToListBtn.setVerticalTextPosition(SwingConstants.CENTER);
		addToListBtn.setHorizontalTextPosition(SwingConstants.LEFT);
		a4_1.add(addToListBtn);
		
		addToListBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (addEquipNameField.getText().isBlank() || addEquipQtyField.getText().isBlank()) {
					
					JOptionPane.showMessageDialog(null, "Please fill out all fields.", "System Warning",JOptionPane.WARNING_MESSAGE);
					
				} else if (app.isValidQty(addEquipQtyField.getText()) == false) {
					JOptionPane.showMessageDialog(null, "Please enter a number for the equipment quantity.", "System Warning",JOptionPane.WARNING_MESSAGE);
				} else {
					
					DefaultTableModel model = (DefaultTableModel) addPrelimTable.getModel();
					model.addRow(new Object[] {addEquipNameField.getText(), Integer.parseInt(addEquipQtyField.getText())});
					addEquipNameField.setText("");
					addEquipQtyField.setText("");
					
				}
			}
		});
		
		JButton removeFromListBtn = new JButton("Remove from List",new ImageIcon(arrowrevicon));
		removeFromListBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		removeFromListBtn.setBounds(44, 204, 187, 40);
		removeFromListBtn.setIconTextGap(10);
		removeFromListBtn.setVerticalTextPosition(SwingConstants.CENTER);
		removeFromListBtn.setHorizontalTextPosition(SwingConstants.LEFT);
		a4_1.add(removeFromListBtn);
		a4.add(aSave);
		a4.add(aBack);
		
		removeFromListBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) addPrelimTable.getModel();
				
				if (addPrelimTable.getSelectedRows().length == 0) {
					
					JOptionPane.showMessageDialog(null, "Please select a record from the table.", "System Warning",JOptionPane.WARNING_MESSAGE);
					
				} else {
					
					int numRows = addPrelimTable.getSelectedRows().length;
					for(int i=0; i<numRows ; i++ ) {

					    model.removeRow(addPrelimTable.getSelectedRow());
					}
					
				}
				
				
			}
		});
		
		aSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) addPrelimTable.getModel();
				
				if (model.getRowCount() == 0) {
					
					JOptionPane.showMessageDialog(null, "Please add at least one new equipment to table.", "System Warning",JOptionPane.WARNING_MESSAGE);
					
				} else {
				
					ArrayList<String> names = new ArrayList<String>();
					ArrayList<String> quantities = new ArrayList<String>();
			        for (int count = 0; count < model.getRowCount(); count++){
			              names.add(model.getValueAt(count, 0).toString());
			              quantities.add(model.getValueAt(count, 1).toString());
			        }
			        
			        System.out.println(names);
			        System.out.println(quantities);
			        
			        for (int count = 0; count < names.size(); count++){
			        
			        	String equipName = names.get(count);
			        	int equipQty = Integer.parseInt(quantities.get(count));
			        	
				        //Beginning of Generate ID Section
				        
				        String first;
						first = equipName.substring(0, 3).toLowerCase();
						String id = first + '#' + end;
						end += 1;
						
						//End of Generate ID Section
						
						app.callAddEquipment(id, equipName, equipQty, equipQty);
						
			        }	
			        
			        JOptionPane.showMessageDialog(null,"Equipment was successfully added.","Success",JOptionPane.INFORMATION_MESSAGE);
			        
			        model.setRowCount(0);
						
				}
			}
		});
		
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Add Equipment to Inventory", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		lblNewLabel_2.setBounds(48, 11, 897, 484);
		a4.add(lblNewLabel_2);
		
		/**
		 * Modify Equipment Panel
		 */
		JPanel modify_equipment_panel = new JPanel();
		panel.add(modify_equipment_panel);
		modify_equipment_panel.setLayout(new BorderLayout(0, 0));
		
		JPanel mE1 = new JPanel();
		FlowLayout fl_mE1 = (FlowLayout) mE1.getLayout();
		fl_mE1.setVgap(15);
		modify_equipment_panel.add(mE1, BorderLayout.NORTH);
		
		JLabel mE_Label_1 = new JLabel("Modify Equipment Information");
		mE_Label_1.setFont(new Font("Modern No. 20", Font.BOLD, 60));
		mE1.add(mE_Label_1);
		
		JPanel mE2 = new JPanel();
		mE2.setBounds(new Rectangle(0, 0, 100, 0));
		modify_equipment_panel.add(mE2, BorderLayout.WEST);
		mE2.setLayout(null);
		
		JPanel mE3 = new JPanel();
		modify_equipment_panel.add(mE3, BorderLayout.EAST);
		mE3.setLayout(null);
		
		JPanel mE4 = new JPanel();
		modify_equipment_panel.add(mE4, BorderLayout.CENTER);
		JCheckBox chckbxNewCheckBox = new JCheckBox("Enable Name Editing");
		JButton modify_equipment_save_btn = new JButton("Update",new ImageIcon(updateicon));
		JTextField changecurrentname = new JTextField();
		JTextField change_current_total_quantity_field = new JTextField();
		JTextField change_remaining_quantity_field = new JTextField();
		JList modifyeqlist = new JList(listModel);
		JTextArea Displaycurrenttotalquantity = new JTextArea();
		JTextArea Displayremainingquantity = new JTextArea();
		JTextArea Displaycurrentname = new JTextArea();
		modify_equipment_save_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(modifyeqlist.isSelectionEmpty()==false) {
					String name;String total;String remaining;String id;String response;
					id=modifyeqlist.getSelectedValue().toString();
					if(chckbxNewCheckBox.isSelected()) {
						name=changecurrentname.getText();
						total=change_current_total_quantity_field.getText();
						remaining=change_remaining_quantity_field.getText();
						app.callModifyEquipment(id,name, total, remaining);
						JOptionPane.showMessageDialog(null,"Equipment Succesfully Modified","Success",JOptionPane.INFORMATION_MESSAGE);
						changecurrentname.setText("");
						change_current_total_quantity_field.setText("");
						change_remaining_quantity_field.setText("");
						Displaycurrentname.setText("");
						Displayremainingquantity.setText("");
						Displaycurrenttotalquantity.setText("");
						reloadIdList();
					}else{
						name=Displaycurrentname.getText();
						total=change_current_total_quantity_field.getText();
						remaining=change_remaining_quantity_field.getText();
						app.callModifyEquipment(id,name, total, remaining);
						JOptionPane.showMessageDialog(null,"Equipment Succesfully Modified","Success",JOptionPane.INFORMATION_MESSAGE);
						change_current_total_quantity_field.setText("");
						change_remaining_quantity_field.setText("");
						changecurrentname.setText("");
						Displaycurrentname.setText("");
						Displayremainingquantity.setText("");
						Displaycurrenttotalquantity.setText("");
						reloadIdList();
					}
				}else {
					JOptionPane.showMessageDialog(null,"Please select ID from list","Warning",JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		modify_equipment_save_btn.setBounds(143, 473, 120, 40);
		modify_equipment_save_btn.setIconTextGap(10);
		modify_equipment_save_btn.setVerticalTextPosition(SwingConstants.CENTER);
		modify_equipment_save_btn.setHorizontalTextPosition(SwingConstants.LEFT);
		modify_equipment_save_btn.setFont(new Font("Tahoma", Font.PLAIN, 15));
				
		JButton modify_equipment_back_btn = new JButton("Back",new ImageIcon(backicon));
		modify_equipment_back_btn.setBounds(765, 473, 101, 40);
		modify_equipment_back_btn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		modify_equipment_back_btn.setIconTextGap(10);
		modify_equipment_back_btn.setVerticalTextPosition(SwingConstants.CENTER);
		modify_equipment_back_btn.setHorizontalTextPosition(SwingConstants.LEFT);
		mE4.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("Remaining Quantity");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_8.setBounds(143, 397, 170, 34);
		mE4.add(lblNewLabel_8);
		
		JLabel lblNewLabel_6 = new JLabel("Equipment Name");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_6.setBounds(143, 268, 148, 24);
		mE4.add(lblNewLabel_6);
		
		
		
		Displaycurrentname.setFont(new Font("Monospaced", Font.PLAIN, 14));
		Displaycurrentname.setEditable(false);
		
		
		Displaycurrenttotalquantity.setFont(new Font("Monospaced", Font.PLAIN, 14));
		Displaycurrenttotalquantity.setEditable(false);
		Displaycurrenttotalquantity.setBounds(311, 345, 148, 30);
		mE4.add(Displaycurrenttotalquantity);
		
		
		Displayremainingquantity.setFont(new Font("Monospaced", Font.PLAIN, 14));
		Displayremainingquantity.setEditable(false);
		Displayremainingquantity.setBounds(311, 403, 148, 30);
		mE4.add(Displayremainingquantity);
		
		
		JButton select_modify_equ_btn = new JButton("Select",new ImageIcon(selecticon));
		select_modify_equ_btn.setIconTextGap(10);
		select_modify_equ_btn.setVerticalTextPosition(SwingConstants.CENTER);
		select_modify_equ_btn.setHorizontalTextPosition(SwingConstants.LEFT);
		
		select_modify_equ_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String id =modifyeqlist.getSelectedValue().toString();
				ArrayList<Object[]> result=app.callGetEquipmentByID(id);
				for(Object[] r: result) {
					Displaycurrentname.setText(r[1].toString());
					Displayremainingquantity.setText(r[2].toString());
					Displaycurrenttotalquantity.setText(r[3].toString());
				}
			}
		});
		select_modify_equ_btn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		select_modify_equ_btn.setBounds(348, 109, 111, 40);
		mE4.add(select_modify_equ_btn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(135, 61, 192, 148);
		mE4.add(scrollPane);
		
		modifyeqlist.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setViewportView(modifyeqlist);
		mE4.add(modify_equipment_save_btn);
		mE4.add(modify_equipment_back_btn);
		
		JLabel lblNewLabel_7 = new JLabel("Total Quantiy");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_7.setBounds(143, 350, 113, 25);
		mE4.add(lblNewLabel_7);
		
		JScrollPane scrollPane_8 = new JScrollPane();
		scrollPane_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollPane_8.setBorder(null);
		scrollPane_8.setBounds(311, 263, 148, 44);
		mE4.add(scrollPane_8);
		scrollPane_8.setViewportView(Displaycurrentname);
	
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_9.setBorder(new TitledBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Current Equipment Details", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		lblNewLabel_9.setBounds(131, 245, 342, 201);
		mE4.add(lblNewLabel_9);
		
		JLabel lblNewLabel_8_1 = new JLabel("Remaining Quantity");
		lblNewLabel_8_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_8_1.setBounds(537, 397, 170, 34);
		mE4.add(lblNewLabel_8_1);
		
		JLabel lblNewLabel_6_1 = new JLabel("Equipment Name");
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_6_1.setBounds(537, 268, 148, 24);
		mE4.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_7_1 = new JLabel("Total Quantiy");
		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_7_1.setBounds(537, 350, 113, 25);
		mE4.add(lblNewLabel_7_1);
		
		change_current_total_quantity_field.setFont(new Font("Tahoma", Font.PLAIN, 14));
		change_current_total_quantity_field.setBounds(707, 345, 146, 30);
		mE4.add(change_current_total_quantity_field);
		
		
		change_remaining_quantity_field.setFont(new Font("Tahoma", Font.PLAIN, 14));
		change_remaining_quantity_field.setBounds(707, 398, 146, 30);
		mE4.add(change_remaining_quantity_field);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBorder(new TitledBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Select Equipment from list to modify", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		lblNewLabel_5.setBounds(119, 39, 387, 182);
		mE4.add(lblNewLabel_5);
		
		
		chckbxNewCheckBox.setFocusable(false);
		chckbxNewCheckBox.setBounds(701, 314, 152, 23);
		mE4.add(chckbxNewCheckBox);
		
		JScrollPane scrollPane_10 = new JScrollPane();
		scrollPane_10.setEnabled(false);
		scrollPane_10.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane_10.setBounds(705, 263, 148, 44);
		mE4.add(scrollPane_10);
		
		
		changecurrentname.setEnabled(false);
		changecurrentname.setBackground(new Color(240, 240, 240));
		scrollPane_10.setViewportView(changecurrentname);
		changecurrentname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_9_1 = new JLabel("");
		lblNewLabel_9_1.setBorder(new TitledBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Enter new information here", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		lblNewLabel_9_1.setBounds(525, 245, 342, 201);
		mE4.add(lblNewLabel_9_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBorder(new TitledBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Modify the total and remaining quantity of a resource", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		lblNewLabel_3.setBounds(72, 11, 852, 512);
		mE4.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		lblNewLabel_4.setBounds(115, 232, 770, 230);
		mE4.add(lblNewLabel_4);
		
		/**
		 * Delete Equipment Panel
		 */
		JPanel delete_equipment_panel = new JPanel();
		panel.add(delete_equipment_panel);
		delete_equipment_panel.setLayout(new BorderLayout(0, 0));
		
		JPanel d1 = new JPanel();
		delete_equipment_panel.add(d1, BorderLayout.NORTH);
		
		JPanel d2 = new JPanel();
		delete_equipment_panel.add(d2, BorderLayout.WEST);
		d2.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 5));
		
		JPanel d3 = new JPanel();
		FlowLayout fl_d3 = (FlowLayout) d3.getLayout();
		fl_d3.setHgap(50);
		delete_equipment_panel.add(d3, BorderLayout.EAST);
		
		JPanel d4 = new JPanel();
		d4.setBounds(194, 33, 1, 1);
		d4.setLayout(null);
		delete_equipment_panel.add(d4);
		
		JLabel d_Label_1 = new JLabel("Delete Equipment");
		d_Label_1.setBounds(155, 11, 499, 57);
		d_Label_1.setFont(new Font("Modern No. 20", Font.BOLD, 60));
		d4.add(d_Label_1);
		JPanel d5 = new JPanel();
		d5.setBounds(0, 139, 788, 443);
		d5.setLayout(null);
		d5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		d5.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Delete equipment from Inventory", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		d4.add(d5);
		
		JButton dDelete = new JButton("Delete",new ImageIcon(deleteiconsmall));
		dDelete.setIconTextGap(10);
		dDelete.setVerticalTextPosition(SwingConstants.CENTER);
		dDelete.setHorizontalTextPosition(SwingConstants.LEFT);
		dDelete.setBounds(30, 366, 110, 40);
		d5.add(dDelete);
		dDelete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton dBack = new JButton("Back",new ImageIcon(backicon));
		dBack.setBounds(639, 366, 104, 40);
		d5.add(dBack);
		dBack.setIconTextGap(10);
		dBack.setVerticalTextPosition(SwingConstants.CENTER);
		dBack.setHorizontalTextPosition(SwingConstants.LEFT);
		dBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		search = new JTextField();
		search.setFont(new Font("Tahoma", Font.PLAIN, 14));
		search.setBounds(41, 130, 265, 32);
		d5.add(search);
		search.setColumns(10);
		
		JLabel searchLabel = new JLabel("Search");
		searchLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		searchLabel.setBounds(40, 82, 71, 20);
		d5.add(searchLabel);
		
		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane_6.setBounds(410, 91, 340, 158);
		d5.add(scrollPane_6);
		
		dInventoryTable = new JTable();
		dInventoryTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Equipment ID", "Name"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		dInventoryTable.setRowHeight(23);
		JTableHeader dInventoryTableHeader =dInventoryTable.getTableHeader();
		dInventoryTableHeader.setFont(new Font("Tahoma", Font.BOLD, 16));
		dInventoryTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane_6.setViewportView(dInventoryTable);
		
		JButton searchByNameBtn = new JButton("By Name",new ImageIcon(namesearchicon));
		searchByNameBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		searchByNameBtn.setBounds(177, 185, 129, 40);
		searchByNameBtn.setIconTextGap(10);
		searchByNameBtn.setVerticalTextPosition(SwingConstants.CENTER);
		searchByNameBtn.setHorizontalTextPosition(SwingConstants.LEFT);
		d5.add(searchByNameBtn);
		
		JButton searchByIDBtn = new JButton("By ID",new ImageIcon(idsearchicon));
		searchByIDBtn.setIconTextGap(10);
		searchByIDBtn.setVerticalTextPosition(SwingConstants.CENTER);
		searchByIDBtn.setHorizontalTextPosition(SwingConstants.LEFT);
		searchByIDBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		searchByIDBtn.setBounds(40, 185, 126, 40);
		d5.add(searchByIDBtn);
		d4.add(d5);
		
		JLabel lblNewLabel_14 = new JLabel("");
		lblNewLabel_14.setBorder(new TitledBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Select Item form table for deletion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		lblNewLabel_14.setBounds(393, 58, 373, 212);
		d5.add(lblNewLabel_14);
		
		JLabel lblNewLabel_17 = new JLabel("");
		lblNewLabel_17.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		lblNewLabel_17.setBounds(21, 65, 308, 205);
		d5.add(lblNewLabel_17);
		/////////////////////////////////////////////////////////////d4.add(d_Label_1);
		

		
		searchByIDBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model = (DefaultTableModel) dInventoryTable.getModel();
				String id = search.getText();
				if (id.isBlank()) {
					JOptionPane.showMessageDialog(null, "Please enter an equipment ID number.", "System Warning",JOptionPane.WARNING_MESSAGE);
				} else {
					model.setRowCount(0);
					ArrayList<Object[]> equipment = app.callGetEquipmentByID(id);
					for(Object[]pair: equipment) {
						model.addRow(new Object[] {pair[0], pair[1]});
					}
				}
			}
		});
		
		searchByNameBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DefaultTableModel model = (DefaultTableModel) dInventoryTable.getModel();
				String name = search.getText();
				if (name.isBlank()) {
					JOptionPane.showMessageDialog(null, "Please enter an equipment name.", "System Warning",JOptionPane.WARNING_MESSAGE);
				} else {
					model.setRowCount(0);
					ArrayList<Object[]> equipment = app.callGetEquipmentByName(name);
					for(Object[]pair: equipment) {
						model.addRow(new Object[] {pair[0], pair[1]});
					}	
				}
			}
		});
		
		dDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DefaultTableModel model = (DefaultTableModel) dInventoryTable.getModel();
				
				if (dInventoryTable.getSelectedRows().length == 0) {
					
					JOptionPane.showMessageDialog(null, "Please select an equipment record from the table.", "System Warning",JOptionPane.WARNING_MESSAGE);
					
				} else {
					
					search.setText("");
					
					int column = 0;
					int row = dInventoryTable.getSelectedRow();
					String value = dInventoryTable.getModel().getValueAt(row, column).toString();
					
					System.out.println(value);
					
					int numRows = dInventoryTable.getSelectedRows().length;
					for(int i=0; i<numRows ; i++ ) {
						
					    model.removeRow(dInventoryTable.getSelectedRow());
					}
					
					JOptionPane.showMessageDialog(null,"Equipment was successfully deleted.","System Message",JOptionPane.INFORMATION_MESSAGE);
					
					app.callDeleteEquipment(value);
					
				}
				
			}
		});
		
		/**
		 * Schedule Equipment Panel
		 */
		JPanel schedule_panel = new JPanel();
		panel.add(schedule_panel);
		schedule_panel.setLayout(null);
		
		JPanel s1 = new JPanel();
		s1.setBounds(0, 0, 994, 75);
		schedule_panel.add(s1);
		
		JLabel s_Label_1 = new JLabel("Schedule Equipment ");
		s_Label_1.setFont(new Font("Modern No. 20", Font.BOLD, 60));
		s1.add(s_Label_1);
		
		JPanel s4 = new JPanel();
		s4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		s4.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Schdedule quipment for events", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		s4.setBounds(21, 86, 936, 555);
		schedule_panel.add(s4);
		
		JButton sSchedule = new JButton("Schedule",new ImageIcon(scheduleicon));
		sSchedule.setIconTextGap(10);
		sSchedule.setVerticalTextPosition(SwingConstants.CENTER);
		sSchedule.setHorizontalTextPosition(SwingConstants.LEFT);
		sSchedule.setFocusable(false);
		sSchedule.setToolTipText("Schedule equipment in with with scheduling details entered");
		sSchedule.setBounds(60, 478, 131, 40);
		sSchedule.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		
		JButton sBack = new JButton("Back");
		sBack.setFocusable(false);
		sBack.setToolTipText("Return to main menu.");
		sBack.setBounds(804, 461, 88, 31);
		sBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		s4.setLayout(null);
		s4.add(sSchedule);
		
		JPanel panel_20 = new JPanel();
		panel_20.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_20.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Add equipment to list", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_20.setBounds(29, 178, 874, 269);
		s4.add(panel_20);
		panel_20.setLayout(null);
		
		JLabel s_Label_id = new JLabel("Equipment ID ");
		s_Label_id.setBounds(29, 37, 116, 17);
		panel_20.add(s_Label_id);
		s_Label_id.setHorizontalAlignment(SwingConstants.RIGHT);
		s_Label_id.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JTextField quantityInputTextField = new JTextField();
		quantityInputTextField.setBounds(159, 206, 112, 31);
		panel_20.add(quantityInputTextField);
		quantityInputTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		quantityInputTextField.setColumns(10);
		
		JLabel s_Label_7 = new JLabel("Quantity");
		s_Label_7.setBounds(49, 213, 89, 17);
		panel_20.add(s_Label_7);
		s_Label_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		s_Label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane_4.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_4.setBounds(508, 33, 331, 204);
		panel_20.add(scrollPane_4);
		
		
		//######################################Schedule Resource Table E###################################################//
		ScheduleEquipmentTable = new JTable();
		ScheduleEquipmentTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane_4.setViewportView(ScheduleEquipmentTable);
		ScheduleEquipmentTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Equipment ID", "Quantity"
			}
		)	{
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] {
				String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		ScheduleEquipmentTable.setRowHeight(20);
		JTableHeader ScheduleEquipmentTableHeader =ScheduleEquipmentTable.getTableHeader();
	    ScheduleEquipmentTableHeader.setFont(new Font("Tahoma", Font.BOLD, 16));
		ScheduleEquipmentTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		//######################################Schedule Resource Table End########################################//
		
		
		
		//######################################Resource List #####################################################//
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_2.setBounds(156, 33, 163, 162);
		panel_20.add(scrollPane_2);
		resourcelist.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane_2.setViewportView(resourcelist);
		resourcelist.setVisibleRowCount(1);
		
		//######################################Resource List End#################################################//
		
		
		
		JButton addtolistBTN = new JButton("Add to List",new ImageIcon(arrowicon));
		addtolistBTN.setFocusable(false);
		addtolistBTN.setToolTipText("Add equipment to list of equipment to be scheduled.");
		addtolistBTN.setBounds(355, 95, 125, 35);
		addtolistBTN.setIconTextGap(5);
		addtolistBTN.setHorizontalTextPosition(SwingConstants.LEFT);
		addtolistBTN.setVerticalTextPosition(SwingConstants.CENTER);
		addtolistBTN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_20.add(addtolistBTN);
		addtolistBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model= (DefaultTableModel)ScheduleEquipmentTable.getModel();
				if(resourcelist.isSelectionEmpty()==false){
					String selectItem = resourcelist.getSelectedValue().toString();
					try {
					    int intValue = Integer.parseInt(quantityInputTextField.getText());
					    model.addRow(new Object[]{selectItem,intValue});
					    quantityInputTextField.setText("");
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(null,"Quantity must be a whole number.","System Warning",JOptionPane.WARNING_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(null,"Equipment Id cannot be empty.","System Warning",JOptionPane.WARNING_MESSAGE);
				}
					
			}
		});
		
		
		
		JButton removeBTN = new JButton("Remove",new ImageIcon(arrowrevicon));
		removeBTN.setIconTextGap(5);
		removeBTN.setHorizontalTextPosition(SwingConstants.LEFT);
		removeBTN.setVerticalTextPosition(SwingConstants.CENTER);
		removeBTN.setFocusable(false);
		removeBTN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model= (DefaultTableModel)ScheduleEquipmentTable.getModel();
				if(ScheduleEquipmentTable.getSelectionModel().isSelectionEmpty()==false){
					if (model.getRowCount()>0) {
						model.removeRow(ScheduleEquipmentTable.getSelectedRow());
						JOptionPane.showMessageDialog(null,"Row was deleted","System Message",JOptionPane.INFORMATION_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(null,"Select row from table to delete","System Message",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		removeBTN.setToolTipText("Select row in table and click delete to delete equipment from list.");
		removeBTN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		removeBTN.setBounds(355, 137, 125, 35);
		panel_20.add(removeBTN);
		
		

		
		JLabel s_Label_5 = new JLabel("Start Time [24 hr] [hh:mm]");
		s_Label_5.setBounds(520, 88, 243, 17);
		s4.add(s_Label_5);
		s_Label_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		s_Label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JFormattedTextField startTimeTextField = new JFormattedTextField(timemask);
		startTimeTextField.setBounds(773, 81, 86, 31);
		s4.add(startTimeTextField);
		startTimeTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		startTimeTextField.setColumns(10);
		
		JLabel s_Label_2 = new JLabel("EventID");
		s_Label_2.setBounds(34, 39, 70, 17);
		s4.add(s_Label_2);
		s_Label_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		s_Label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JTextField eventIDTextField = new JTextField();
		eventIDTextField.setBounds(114, 32, 126, 31);
		s4.add(eventIDTextField);
		eventIDTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		eventIDTextField.setColumns(10);
		
		JLabel s_Label_3 = new JLabel("Location");
		s_Label_3.setBounds(34, 88, 70, 17);
		s4.add(s_Label_3);
		s_Label_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		s_Label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(109, 79, 229, 40);
		s4.add(scrollPane_3);
		
		JTextPane locationTextField = new JTextPane();
		scrollPane_3.setViewportView(locationTextField);
		locationTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel s_Label_6 = new JLabel("End Time [24 hr] [hh:mm]");
		s_Label_6.setBounds(551, 137, 212, 17);
		s4.add(s_Label_6);
		s_Label_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		s_Label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JFormattedTextField endTimeTextField = new JFormattedTextField(timemask);
		endTimeTextField.setBounds(775, 130, 86, 31);
		s4.add(endTimeTextField);
		endTimeTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		endTimeTextField.setColumns(10);
		
		JLabel s_Label_4 = new JLabel("Start Date ");
		s_Label_4.setBounds(10, 137, 97, 17);
		s4.add(s_Label_4);
		s_Label_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		s_Label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JButton viewSchInvButton = new JButton("Inventory",new ImageIcon(stockicon));
		viewSchInvButton.setIconTextGap(10);
		viewSchInvButton.setVerticalTextPosition(SwingConstants.CENTER);
		viewSchInvButton.setHorizontalTextPosition(SwingConstants.LEFT);
		viewSchInvButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==viewSchInvButton) {
					new PopUpWindowDisplay(app.loadResourceList());
				}
			}
		});
		viewSchInvButton.setFocusable(false);
		viewSchInvButton.setToolTipText("Show a list of all resources;name id remaining quantity");
		viewSchInvButton.setBounds(218, 478, 131, 40);
		s4.add(viewSchInvButton);
		viewSchInvButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JDateChooser schedulestartdateChooser = new JDateChooser();
		schedulestartdateChooser.setBounds(107, 130, 128, 31);
		schedulestartdateChooser.setDateFormatString("yyyy-MM-dd");
		s4.add(schedulestartdateChooser);
		
		JButton scheduleBackbtn = new JButton("Back", new ImageIcon(backicon));
		scheduleBackbtn.setIconTextGap(10);
		scheduleBackbtn.setVerticalTextPosition(SwingConstants.CENTER);
		scheduleBackbtn.setHorizontalTextPosition(SwingConstants.LEFT);
		scheduleBackbtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scheduleBackbtn.setBounds(772, 478, 97, 40);
		s4.add(scheduleBackbtn);
		
		JDateChooser scheduleenddateChooser = new JDateChooser();
		scheduleenddateChooser.setBounds(776, 32, 128, 31);
		scheduleenddateChooser.setDateFormatString("yyyy-MM-dd");
		s4.add(scheduleenddateChooser);
		
		JLabel s_Label_4_2 = new JLabel("End Date ");
		s_Label_4_2.setHorizontalAlignment(SwingConstants.RIGHT);
		s_Label_4_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		s_Label_4_2.setBounds(668, 39, 97, 17);
		s4.add(s_Label_4_2);
		
		/**
		 * Modify Schedule Panel -
		 */
		JPanel modify_schedule_panel = new JPanel();
		panel.add(modify_schedule_panel, "name_178420640145900");
		modify_schedule_panel.setLayout(null);
		
		JPanel mS1 = new JPanel();
		mS1.setBounds(0, 0, 994, 68);
		modify_schedule_panel.add(mS1);
		
		JLabel mS_Label_1 = new JLabel("Modify Equipment Schedule ");
		mS_Label_1.setFont(new Font("Modern No. 20", Font.BOLD, 60));
		mS1.add(mS_Label_1);
		
		JPanel mS4 = new JPanel();
		mS4.setBounds(0, 69, 994, 602);
		modify_schedule_panel.add(mS4);
		
		JPanel mS4_1 = new JPanel();
		mS4_1.setBorder(new TitledBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Enter new scheduling deatals", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		mS4_1.setBounds(371, 206, 257, 340);
		
		JButton mSsave = new JButton("Save",new ImageIcon(updateicon));
		mSsave.setIconTextGap(10);
		mSsave.setVerticalTextPosition(SwingConstants.CENTER);
		mSsave.setHorizontalTextPosition(SwingConstants.LEFT);
		
		
		mSsave.setBounds(668, 499, 113, 40);
		mSsave.setFont(new Font("Tahoma", Font.PLAIN, 14));
				
		JButton mSback = new JButton("Back",new ImageIcon(backicon));
		mSback.setIconTextGap(10);
		mSback.setVerticalTextPosition(SwingConstants.CENTER);
		mSback.setHorizontalTextPosition(SwingConstants.LEFT);
		
		mSback.setBounds(803, 499, 113, 40);
		mSback.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mS4_1.setLayout(null);
		
		JLabel ms_Label_2 = new JLabel("Location");
		ms_Label_2.setBounds(10, 21, 74, 21);
		ms_Label_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		ms_Label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		mS4_1.add(ms_Label_2);
		
		JLabel ms_Label_3 = new JLabel("Start Date [yyyy-mm-dd] ");
		ms_Label_3.setBounds(10, 85, 211, 21);
		ms_Label_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		ms_Label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		mS4_1.add(ms_Label_3);
		
		JDateChooser newstartdate = new JDateChooser();
		newstartdate.setBounds(10, 111, 235, 30);
		mS4_1.add(newstartdate);
		
		JLabel s_Label_id_1 = new JLabel("End Date [yyyy-mm-dd]");
		s_Label_id_1.setBounds(10, 149, 194, 21);
		s_Label_id_1.setHorizontalAlignment(SwingConstants.RIGHT);
		s_Label_id_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		mS4_1.add(s_Label_id_1);
		
		JDateChooser newenddate = new JDateChooser();
		newenddate.setBounds(10, 176, 235, 30);
		mS4_1.add(newenddate);
		
		JLabel ms_Label_4 = new JLabel("Start Time [24 hr] [hh:mm]");
		ms_Label_4.setBounds(10, 212, 226, 21);
		ms_Label_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		ms_Label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		mS4_1.add(ms_Label_4);
		
		JTextField newstarttime = new JTextField();
		newstarttime.setBounds(10, 238, 235, 31);
		newstarttime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		newstarttime.setColumns(10);
		mS4_1.add(newstarttime);
		
		JLabel ms_Label_5 = new JLabel("End Time [24 hr] [hh:mm]");
		ms_Label_5.setBounds(10, 274, 214, 21);
		ms_Label_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		ms_Label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		mS4_1.add(ms_Label_5);
		
		JTextField newendtime = new JTextField();
		newendtime.setBounds(10, 298, 235, 31);
		newendtime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		newendtime.setColumns(10);
		mS4_1.add(newendtime);
		mS4.setLayout(null);
		mS4.add(mSsave);
		mS4.add(mSback);
		mS4.add(mS4_1);
		
		JTextField newlocation = new JTextField();
		newlocation.setBounds(12, 49, 233, 31);
		mS4_1.add(newlocation);
		newlocation.setFont(new Font("Tahoma", Font.PLAIN, 14));
		newlocation.setColumns(10);
		
		JScrollPane scrollPane_11 = new JScrollPane();
		scrollPane_11.setBounds(648, 221, 285, 266);
		mS4.add(scrollPane_11);
		
		eventidscheduletable = new JTable();
		eventidscheduletable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Equipment ID", "Quantity"
			}
		));
		scrollPane_11.setViewportView(eventidscheduletable);
		eventidscheduletable.setRowHeight(20);
		JTableHeader eventidscheduletableheader =eventidscheduletable.getTableHeader();
		eventidscheduletableheader.setFont(new Font("Tahoma", Font.BOLD, 16));
		eventidscheduletableheader.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JPanel mS4_1_1 = new JPanel();
		mS4_1_1.setLayout(null);
		mS4_1_1.setBorder(new TitledBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Current scheduling deatals", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		mS4_1_1.setBounds(61, 206, 257, 340);
		mS4.add(mS4_1_1);
		
		JLabel ms_Label_2_1 = new JLabel("Current Location");
		ms_Label_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		ms_Label_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		ms_Label_2_1.setBounds(10, 21, 138, 21);
		mS4_1_1.add(ms_Label_2_1);
		
		JLabel ms_Label_3_1 = new JLabel("Current Start Date");
		ms_Label_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		ms_Label_3_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		ms_Label_3_1.setBounds(10, 85, 154, 21);
		mS4_1_1.add(ms_Label_3_1);
		
		JLabel s_Label_id_1_1 = new JLabel("Current End Date ");
		s_Label_id_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		s_Label_id_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		s_Label_id_1_1.setBounds(10, 149, 146, 21);
		mS4_1_1.add(s_Label_id_1_1);
		
		JLabel ms_Label_4_1 = new JLabel("Current Start Time");
		ms_Label_4_1.setHorizontalAlignment(SwingConstants.RIGHT);
		ms_Label_4_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		ms_Label_4_1.setBounds(10, 212, 154, 21);
		mS4_1_1.add(ms_Label_4_1);
		
		displaystartime = new JTextField();
		displaystartime.setEditable(false);
		displaystartime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		displaystartime.setColumns(10);
		displaystartime.setBounds(10, 238, 235, 31);
		mS4_1_1.add(displaystartime);
		
		JLabel ms_Label_5_1 = new JLabel("Current End Time");
		ms_Label_5_1.setHorizontalAlignment(SwingConstants.RIGHT);
		ms_Label_5_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		ms_Label_5_1.setBounds(10, 274, 146, 21);
		mS4_1_1.add(ms_Label_5_1);
		
		displayendtime = new JTextField();
		displayendtime.setEditable(false);
		displayendtime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		displayendtime.setColumns(10);
		displayendtime.setBounds(10, 298, 235, 31);
		mS4_1_1.add(displayendtime);
		
		displayLocation = new JTextField();
		displayLocation.setEditable(false);
		displayLocation.setFont(new Font("Tahoma", Font.PLAIN, 14));
		displayLocation.setColumns(10);
		displayLocation.setBounds(12, 49, 233, 31);
		mS4_1_1.add(displayLocation);
		
		displayEndDate = new JTextField();
		displayEndDate.setEditable(false);
		displayEndDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		displayEndDate.setBounds(10, 176, 235, 31);
		mS4_1_1.add(displayEndDate);
		displayEndDate.setColumns(10);
		
		displayStartDate = new JTextField();
		displayStartDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		displayStartDate.setEditable(false);
		displayStartDate.setColumns(10);
		displayStartDate.setBounds(10, 111, 235, 31);
		mS4_1_1.add(displayStartDate);
		
		JLabel lblNewLabel_19 = new JLabel("");
		lblNewLabel_19.setBounds(41, 191, 911, 373);
		mS4.add(lblNewLabel_19);
		lblNewLabel_19.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(342, 206, 7, 340);
		mS4.add(separator);
		
		JScrollPane scrollPane_12 = new JScrollPane();
		scrollPane_12.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_12.setBounds(53, 31, 265, 136);
		mS4.add(scrollPane_12);
		
		JList modScheduleLst = new JList(listModel1);
		scrollPane_12.setViewportView(modScheduleLst);
		
		JButton mSelectBtn = new JButton("Select",new ImageIcon(selecticon));
		mSelectBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		mSelectBtn.setBounds(335, 83, 105, 40);
		mSelectBtn.setIconTextGap(10);
		mSelectBtn.setVerticalTextPosition(SwingConstants.CENTER);
		mSelectBtn.setHorizontalTextPosition(SwingConstants.LEFT);
		mS4.add(mSelectBtn);
		
		JLabel lblNewLabel_20 = new JLabel("");
		lblNewLabel_20.setBorder(new TitledBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Select Event Schedule List", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		lblNewLabel_20.setBounds(41, 11, 416, 169);
		mS4.add(lblNewLabel_20);
		
		JPanel search_panel = new JPanel();
		panel.add(search_panel, "name_178648497614900");
		
		mSelectBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.print("clicked");
				String id = modScheduleLst.getSelectedValue().toString();
				ArrayList<Object[]> result = app.callViewSchedule(id);
				ArrayList<Object[]> result2 = app.callGetScheduledEquipment(id);
				
				DefaultTableModel model = (DefaultTableModel) eventidscheduletable.getModel();
				model.setRowCount(0);
				
				for(Object[]pair : result2) {
					model.addRow(new Object[] {pair[1], pair[3]});
				}
				
				for(Object[] r: result) {
					displayLocation.setText(r[1].toString());
					displayStartDate.setText(r[2].toString());
					displayEndDate.setText((String) r[3]);
					displaystartime.setText(r[4].toString());
					displayendtime.setText(r[5].toString());
				}
			}
		});
		
		mSsave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(modScheduleLst.isSelectionEmpty()==false) {
					
					DefaultTableModel model = (DefaultTableModel) eventidscheduletable.getModel();
					
					String currentlocation, current_start_date, current_end_date, current_start_time, current_end_time;
					String new_location, new_start_date, new_end_date, new_start_time, new_end_time, id, response;
					
					ArrayList<Object> currentInfo = new ArrayList<Object>();
					ArrayList<Object> newInfo = new ArrayList<Object>();
					ArrayList<Object[]> itemRequests = new ArrayList<Object[]>();
					
					id = modScheduleLst.getSelectedValue().toString();
					
					currentlocation = displayLocation.getText();
					current_start_date = displayStartDate.getText();
					current_end_date = displayEndDate.getText();
					current_start_time = displaystartime.getText();
					current_end_time = displayendtime.getText();
					
					currentInfo.addAll(Arrays.asList(currentlocation, current_start_date, current_end_date, current_start_time, current_end_time));
					
					new_location = newlocation.getText();
					new_start_date = newstartdate.getDateFormatString();
					new_end_date = newenddate.getDateFormatString();
					new_start_time = newstarttime.getText();
					new_end_time = newendtime.getText();
					
					newInfo.addAll(Arrays.asList(new_location, new_start_date, new_end_date, new_start_time, new_end_time));
					
					for (int count = 0; count < model.getRowCount(); count++){
			              itemRequests.add(new Object[] {model.getValueAt(count, 0).toString(), model.getValueAt(count, 1).toString()});
			        }
					
					
					app.callModifySchedule(id, currentInfo, newInfo, itemRequests);
					
					displayLocation.setText("");
					displayStartDate.setText("");
					displayEndDate.setText("");
					displaystartime.setText("");
					displayendtime.setText("");
					
					newlocation.setText("");
					newstartdate.setDateFormatString("");
					newenddate.setDateFormatString("");
					newstarttime.setText("");
					newendtime.setText("");
					
					JOptionPane.showMessageDialog(null,"Schedule Succesfully Modified","Success",JOptionPane.INFORMATION_MESSAGE);
					reloadEventIds();
					
				} else {
					JOptionPane.showMessageDialog(null,"Please select an event ID from list","Warning",JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		
		
		/**
		 * Search Panel
		 */
		search_panel.setLayout(null);
		JPanel sr1 = new JPanel();
		sr1.setBounds(0, 0, 994, 104);
		search_panel.add(sr1);
		
		JLabel lblNewLabel_15 = new JLabel("Search Inventory");
		lblNewLabel_15.setFont(new Font("Modern No. 20", Font.BOLD, 60));
		sr1.add(lblNewLabel_15);
		
		JPanel sr2 = new JPanel();
		sr2.setBounds(0, 104, 24, 567);
		search_panel.add(sr2);
		GroupLayout gl_sr2 = new GroupLayout(sr2);
		gl_sr2.setHorizontalGroup(
			gl_sr2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 58, Short.MAX_VALUE)
		);
		gl_sr2.setVerticalGroup(
			gl_sr2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 312, Short.MAX_VALUE)
		);
		sr2.setLayout(gl_sr2);
		
		JPanel sr3 = new JPanel();
		sr3.setBounds(964, 88, 30, 583);
		search_panel.add(sr3);
		GroupLayout gl_sr3 = new GroupLayout(sr3);
		gl_sr3.setHorizontalGroup(
			gl_sr3.createParallelGroup(Alignment.LEADING)
				.addGap(0, 161, Short.MAX_VALUE)
		);
		gl_sr3.setVerticalGroup(
			gl_sr3.createParallelGroup(Alignment.LEADING)
				.addGap(0, 312, Short.MAX_VALUE)
		);
		sr3.setLayout(gl_sr3);
		
		JPanel d5_2 = new JPanel();
		d5_2.setBounds(28, 104, 934, 490);
		d5_2.setLayout(null);
		d5_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		d5_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Search for equipment in inventroy", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		search_panel.add(d5_2);
		
		JButton searchBack = new JButton("Back",new ImageIcon(backicon));
		searchBack.setIconTextGap(10);
		searchBack.setVerticalTextPosition(SwingConstants.CENTER);
		searchBack.setHorizontalTextPosition(SwingConstants.LEFT);
		searchBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		searchBack.setBounds(25, 427, 104, 40);
		d5_2.add(searchBack);
		
		search_2 = new JTextField();
		search_2.setColumns(10);
		search_2.setBounds(30, 114, 261, 32);
		d5_2.add(search_2);
		
		JLabel searchLabel_2 = new JLabel("Search");
		searchLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		searchLabel_2.setBounds(31, 76, 71, 14);
		d5_2.add(searchLabel_2);
		
		JScrollPane scrollPane_6_3 = new JScrollPane();
		scrollPane_6_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		scrollPane_6_3.setBounds(321, 63, 592, 292);
		d5_2.add(scrollPane_6_3);
		
		sInventoryTable = new JTable();
		sInventoryTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"Equipment ID", "Equipment Name", "Total Quantity", "Remaining Quantity"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		sInventoryTable.setRowHeight(23);
		sInventoryTable.getColumnModel().getColumn(0).setMinWidth(10);
		sInventoryTable.getColumnModel().getColumn(0).setPreferredWidth(14);
		sInventoryTable.getColumnModel().getColumn(1).setMinWidth(10);
		sInventoryTable.getColumnModel().getColumn(1).setPreferredWidth(24);
		sInventoryTable.getColumnModel().getColumn(2).setMinWidth(10);
		sInventoryTable.getColumnModel().getColumn(2).setPreferredWidth(14);
		sInventoryTable.getColumnModel().getColumn(3).setMinWidth(10);
		sInventoryTable.getColumnModel().getColumn(3).setPreferredWidth(35);
		
		JTableHeader sInventoryTableHeader =sInventoryTable.getTableHeader();
		sInventoryTableHeader.setFont(new Font("Tahoma", Font.BOLD, 15));
		sInventoryTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane_6_3.setViewportView(sInventoryTable);
		
		JButton searchByNameBtn_2 = new JButton("By Name",new ImageIcon(namesearchicon));
		searchByNameBtn_2.setIconTextGap(10);
		searchByNameBtn_2.setVerticalTextPosition(SwingConstants.CENTER);
		searchByNameBtn_2.setHorizontalTextPosition(SwingConstants.LEFT);
		searchByNameBtn_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		searchByNameBtn_2.setBounds(156, 181, 135, 40);
		d5_2.add(searchByNameBtn_2);
		
		JButton searchByIDBtn_2 = new JButton("By ID",new ImageIcon(idsearchicon));
		searchByIDBtn_2.setIconTextGap(10);
		searchByIDBtn_2.setVerticalTextPosition(SwingConstants.CENTER);
		searchByIDBtn_2.setHorizontalTextPosition(SwingConstants.LEFT);
		searchByIDBtn_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		searchByIDBtn_2.setBounds(30, 181, 121, 40);
		d5_2.add(searchByIDBtn_2);
		
		JLabel lblNewLabel_16 = new JLabel("");
		lblNewLabel_16.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		lblNewLabel_16.setBounds(20, 63, 281, 190);
		d5_2.add(lblNewLabel_16);
		
		searchByIDBtn_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model = (DefaultTableModel) sInventoryTable.getModel();
				String id = search_2.getText();
				if (id.isBlank()) {
					JOptionPane.showMessageDialog(null, "Please enter an equipment ID number.", "System Warning",JOptionPane.WARNING_MESSAGE);
				} else {
					model.setRowCount(0);
					ArrayList<Object[]> equipment = app.callGetEquipmentByID(id);
					for(Object[]pair: equipment) {
						model.addRow(new Object[] {pair[0], pair[1], pair[2], pair[3]});
					}
				}
			}
		});
		
		searchByNameBtn_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DefaultTableModel model = (DefaultTableModel) sInventoryTable.getModel();
				String name = search_2.getText();
				if (name.isBlank()) {
					JOptionPane.showMessageDialog(null, "Please enter an equipment name.", "System Warning",JOptionPane.WARNING_MESSAGE);
				} else {
					model.setRowCount(0);
					ArrayList<Object[]> equipment = app.callGetEquipmentByName(name);
					for(Object[]pair: equipment) {
						model.addRow(new Object[] {pair[0], pair[1], pair[2], pair[3]});
					}	
				}
			}
		});
		
		/**
		 * View Schedule Panel owner
		 */
		JPanel view_equipment_schedules_panel = new JPanel();
		panel.add(view_equipment_schedules_panel, "name_592190169200400");
		
		JPanel vas_1 = new JPanel();
		view_equipment_schedules_panel.add(vas_1);
		
		JPanel vas_2 = new JPanel();
		vas_2.setLayout(null);
		vas_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		vas_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "View All Scheduled Equipment", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JButton vASBack_1 = new JButton("Back", new ImageIcon(backicon));
		vASBack_1.setIconTextGap(10);
		vASBack_1.setVerticalTextPosition(SwingConstants.CENTER);
		vASBack_1.setHorizontalTextPosition(SwingConstants.LEFT);
		vASBack_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		vASBack_1.setBounds(42, 397, 100, 40);
		vas_2.add(vASBack_1);
		
		JLabel schedule_searchLabel_1 = new JLabel("Scheduled Equipment List");
		schedule_searchLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		schedule_searchLabel_1.setBounds(42, 68, 209, 20);
		vas_2.add(schedule_searchLabel_1);
		
		JScrollPane scrollPane_6_1 = new JScrollPane();
		scrollPane_6_1.setBounds(296, 57, 489, 354);
		vas_2.add(scrollPane_6_1);
		
		schedule_table = new JTable();
		schedule_table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Event ID", "Location", "Start Date", "End Date", "Start Time", "End Time"
			}
		));
		schedule_table.setRowHeight(23);
		scrollPane_6_1.setViewportView(schedule_table);
		JTableHeader schedule_tableHeader =schedule_table.getTableHeader();
		schedule_tableHeader.setFont(new Font("Tahoma", Font.BOLD, 16));
		schedule_table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		
		JButton vaSearchByEquipmentIDBtn_1 = new JButton("View", new ImageIcon(viewicon));
		vaSearchByEquipmentIDBtn_1.setIconTextGap(10);
		vaSearchByEquipmentIDBtn_1.setVerticalTextPosition(SwingConstants.CENTER);
		vaSearchByEquipmentIDBtn_1.setHorizontalTextPosition(SwingConstants.LEFT);
		vaSearchByEquipmentIDBtn_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		vaSearchByEquipmentIDBtn_1.setBounds(42, 296, 107, 40);
		vas_2.add(vaSearchByEquipmentIDBtn_1);
		
		
		DefaultTableModel model_schedule = (DefaultTableModel) schedule_table.getModel();
		
		
		JLabel vs_Label_1_1 = new JLabel("Equipment Schedules");
		vs_Label_1_1.setFont(new Font("Modern No. 20", Font.BOLD, 52));
		GroupLayout gl_vas_1 = new GroupLayout(vas_1);
		gl_vas_1.setHorizontalGroup(
			gl_vas_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_vas_1.createSequentialGroup()
					.addContainerGap(204, Short.MAX_VALUE)
					.addComponent(vs_Label_1_1)
					.addGap(188))
				.addGroup(Alignment.LEADING, gl_vas_1.createSequentialGroup()
					.addGap(24)
					.addComponent(vas_2, GroupLayout.PREFERRED_SIZE, 819, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(26, Short.MAX_VALUE))
		);
		gl_vas_1.setVerticalGroup(
			gl_vas_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_vas_1.createSequentialGroup()
					.addGap(23)
					.addComponent(vs_Label_1_1)
					.addGap(32)
					.addComponent(vas_2, GroupLayout.PREFERRED_SIZE, 460, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(90, Short.MAX_VALUE))
		);
		
		JScrollPane eq_scrollPane = new JScrollPane();
		eq_scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		eq_scrollPane.setBounds(36, 114, 174, 158);
		vas_2.add(eq_scrollPane);
		
		JList eq_list = new JList(listModel);
		eq_list.setVisibleRowCount(1);
		eq_list.setFont(new Font("Tahoma", Font.PLAIN, 14));
		eq_scrollPane.setViewportView(eq_list);
		vas_1.setLayout(gl_vas_1);
		
		//////////////
		/**
		 * view all schedule
		 * 
		 */
		
		JPanel view_all_schedule_panel = new JPanel();
		panel.add(view_all_schedule_panel, "name_191323147392800");
		view_all_schedule_panel.setLayout(new BorderLayout(0, 0));
		
		JPanel vas_1_1 = new JPanel();
		view_all_schedule_panel.add(vas_1_1, BorderLayout.NORTH);
		
		JPanel vas_2_1 = new JPanel();
		vas_2_1.setLayout(null);
		vas_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		vas_2_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "View All Scheduled Equipment", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JButton vASBack_1_1 = new JButton("Back", new ImageIcon(backicon));
		vASBack_1_1.setIconTextGap(10);
		vASBack_1_1.setVerticalTextPosition(SwingConstants.CENTER);
		vASBack_1_1.setHorizontalTextPosition(SwingConstants.LEFT);
		
		vASBack_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		vASBack_1_1.setBounds(57, 426, 108, 40);
		vas_2_1.add(vASBack_1_1);
		
		JLabel vs_Label_1_1_1 = new JLabel("View All Schedules");
		vs_Label_1_1_1.setFont(new Font("Modern No. 20", Font.BOLD, 60));
		GroupLayout gl_vas_1_1 = new GroupLayout(vas_1_1);
		gl_vas_1_1.setHorizontalGroup(
			gl_vas_1_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_vas_1_1.createSequentialGroup()
					.addGroup(gl_vas_1_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_vas_1_1.createSequentialGroup()
							.addGap(248)
							.addComponent(vs_Label_1_1_1))
						.addGroup(gl_vas_1_1.createSequentialGroup()
							.addGap(81)
							.addComponent(vas_2_1, GroupLayout.PREFERRED_SIZE, 817, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(96, Short.MAX_VALUE))
		);
		gl_vas_1_1.setVerticalGroup(
			gl_vas_1_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_vas_1_1.createSequentialGroup()
					.addGap(23)
					.addComponent(vs_Label_1_1_1)
					.addGap(18)
					.addComponent(vas_2_1, GroupLayout.PREFERRED_SIZE, 499, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(65, Short.MAX_VALUE))
		);
		
		JScrollPane scrollPane_7 = new JScrollPane();
		scrollPane_7.setBounds(31, 33, 735, 382);
		vas_2_1.add(scrollPane_7);
		
		event_table = new JTable();
		event_table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Event ID", "Location", "Start Date", "End Date", "Start Time", "End Time"
			}
		));
		event_table.setRowHeight(23);
		JTableHeader event_tableHeader =event_table.getTableHeader();
		event_tableHeader.setFont(new Font("Tahoma", Font.BOLD, 16));
		event_table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane_7.setViewportView(event_table);
		vas_1_1.setLayout(gl_vas_1_1);
		
		DefaultTableModel event_schedule = (DefaultTableModel) event_table.getModel();
		
		
		
		
		
		JPanel worker_view_schedule_panel_ = new JPanel();
		panel.add(worker_view_schedule_panel_, "name_263145308522499");
		worker_view_schedule_panel_.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6 = new JPanel();
		worker_view_schedule_panel_.add(panel_6, BorderLayout.NORTH);
		
		JLabel lblNewLabel_17_1 = new JLabel("View Equipment Schedule");
		lblNewLabel_17_1.setFont(new Font("Segoe Script", Font.PLAIN, 30));
		panel_6.add(lblNewLabel_17_1);
		
		JPanel panel_7 = new JPanel();
		FlowLayout flowLayout_6 = (FlowLayout) panel_7.getLayout();
		flowLayout_6.setHgap(50);
		worker_view_schedule_panel_.add(panel_7, BorderLayout.WEST);
		
		JPanel panel_8 = new JPanel();
		FlowLayout flowLayout_7 = (FlowLayout) panel_8.getLayout();
		flowLayout_7.setHgap(50);
		worker_view_schedule_panel_.add(panel_8, BorderLayout.EAST);
		
		JPanel panel_9 = new JPanel();
		worker_view_schedule_panel_.add(panel_9, BorderLayout.CENTER);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JButton vsView_1 = new JButton("View");
		vsView_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton vsBack_1 = new JButton("Back");
		vsBack_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JPanel panel_19 = new JPanel();
		GroupLayout gl_panel_9 = new GroupLayout(panel_9);
		gl_panel_9.setHorizontalGroup(
			gl_panel_9.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_9.createSequentialGroup()
					.addGroup(gl_panel_9.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_9.createSequentialGroup()
							.addGap(23)
							.addComponent(panel_19, GroupLayout.PREFERRED_SIZE, 449, GroupLayout.PREFERRED_SIZE)
							.addGap(140)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_9.createSequentialGroup()
							.addGap(127)
							.addComponent(vsView_1)
							.addGap(94)
							.addComponent(vsBack_1)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_9.setVerticalGroup(
			gl_panel_9.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_9.createSequentialGroup()
					.addGroup(gl_panel_9.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_9.createSequentialGroup()
							.addGap(23)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_9.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_19, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE)))
					.addGap(30)
					.addGroup(gl_panel_9.createParallelGroup(Alignment.BASELINE)
						.addComponent(vsView_1)
						.addComponent(vsBack_1))
					.addContainerGap(105, Short.MAX_VALUE))
		);
		
		JLabel vs_Label_2_1 = new JLabel("Equipment ID:");
		vs_Label_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField_13 = new JTextField();
		textField_13.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_13.setColumns(10);
		
		JTextArea vstextArea_1 = new JTextArea();
		vstextArea_1.setRows(10);
		vstextArea_1.setEditable(false);
		vstextArea_1.setColumns(50);
		GroupLayout gl_panel_19 = new GroupLayout(panel_19);
		gl_panel_19.setHorizontalGroup(
			gl_panel_19.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_19.createSequentialGroup()
					.addGroup(gl_panel_19.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_19.createSequentialGroup()
							.addGap(127)
							.addComponent(vs_Label_2_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_19.createSequentialGroup()
							.addGap(26)
							.addComponent(vstextArea_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(147, Short.MAX_VALUE))
		);
		gl_panel_19.setVerticalGroup(
			gl_panel_19.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_19.createSequentialGroup()
					.addGroup(gl_panel_19.createParallelGroup(Alignment.BASELINE)
						.addComponent(vs_Label_2_1)
						.addComponent(textField_13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(vstextArea_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(100, Short.MAX_VALUE))
		);
		panel_19.setLayout(gl_panel_19);
		panel_9.setLayout(gl_panel_9);
		
		JPanel worker_schedule_equipment_panel = new JPanel();
		panel.add(worker_schedule_equipment_panel, "name_263458545026600");
		worker_schedule_equipment_panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_10 = new JPanel();
		worker_schedule_equipment_panel.add(panel_10, BorderLayout.NORTH);
		
		JLabel s_Label_1_1 = new JLabel("Schedule Equipment ");
		s_Label_1_1.setFont(new Font("Segoe Script", Font.PLAIN, 30));
		panel_10.add(s_Label_1_1);
		
		JPanel panel_11 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel_11.getLayout();
		flowLayout_4.setHgap(50);
		worker_schedule_equipment_panel.add(panel_11, BorderLayout.WEST);
		
		JPanel panel_12 = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) panel_12.getLayout();
		flowLayout_5.setHgap(50);
		worker_schedule_equipment_panel.add(panel_12, BorderLayout.EAST);
		
		JPanel panel_13 = new JPanel();
		worker_schedule_equipment_panel.add(panel_13, BorderLayout.CENTER);
		
		JPanel panel_18 = new JPanel();
		panel_18.setLayout(new BoxLayout(panel_18, BoxLayout.Y_AXIS));
		
		JLabel s_Label_id_2 = new JLabel("Equipment ID: ");
		s_Label_id_2.setHorizontalAlignment(SwingConstants.RIGHT);
		s_Label_id_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_18.add(s_Label_id_2);
		
		textField_id_3 = new JTextField();
		textField_id_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_id_3.setColumns(10);
		panel_18.add(textField_id_3);
		
		JLabel s_Label_2_1 = new JLabel("EventID: ");
		s_Label_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		s_Label_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_18.add(s_Label_2_1);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_6.setColumns(10);
		panel_18.add(textField_6);
		
		JLabel s_Label_3_1 = new JLabel("Location:");
		s_Label_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		s_Label_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_18.add(s_Label_3_1);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_7.setColumns(10);
		panel_18.add(textField_7);
		
		JLabel s_Label_4_1 = new JLabel("Date [yyyy-mm-dd]: ");
		s_Label_4_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		s_Label_4_1.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_18.add(s_Label_4_1);
		
		textField_9 = new JTextField();
		textField_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_9.setColumns(10);
		panel_18.add(textField_9);
		
		JLabel s_Label_5_1 = new JLabel("Start Time [24 hr] [hh:mm]:");
		s_Label_5_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		s_Label_5_1.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_18.add(s_Label_5_1);
		
		textField_10 = new JTextField();
		textField_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_10.setColumns(10);
		panel_18.add(textField_10);
		
		JLabel s_Label_6_1 = new JLabel("End Time [24 hr] [hh:mm]:");
		s_Label_6_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		s_Label_6_1.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_18.add(s_Label_6_1);
		
		textField_11 = new JTextField();
		textField_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_11.setColumns(10);
		panel_18.add(textField_11);
		
		JLabel s_Label_7_1 = new JLabel("Quantity:");
		s_Label_7_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		s_Label_7_1.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_18.add(s_Label_7_1);
		
		textField_12 = new JTextField();
		textField_12.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_12.setColumns(10);
		panel_18.add(textField_12);
		
		JButton sSchedule_1 = new JButton("Schedule");
		sSchedule_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton sBack_1 = new JButton("Back");
		sBack_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GroupLayout gl_panel_13 = new GroupLayout(panel_13);
		gl_panel_13.setHorizontalGroup(
			gl_panel_13.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_13.createSequentialGroup()
					.addGap(126)
					.addGroup(gl_panel_13.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_13.createSequentialGroup()
							.addComponent(sSchedule_1)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(sBack_1))
						.addComponent(panel_18, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(126, Short.MAX_VALUE))
		);
		gl_panel_13.setVerticalGroup(
			gl_panel_13.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_13.createSequentialGroup()
					.addGap(5)
					.addComponent(panel_18, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(41)
					.addGroup(gl_panel_13.createParallelGroup(Alignment.BASELINE)
						.addComponent(sSchedule_1)
						.addComponent(sBack_1))
					.addContainerGap(137, Short.MAX_VALUE))
		);
		panel_13.setLayout(gl_panel_13);
		
		JPanel worker_search_panel = new JPanel();
		panel.add(worker_search_panel, "name_263510153674900");
		worker_search_panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_14 = new JPanel();
		worker_search_panel.add(panel_14, BorderLayout.NORTH);
		
		JLabel lblNewLabel_15_1 = new JLabel("View Equipment");
		lblNewLabel_15_1.setFont(new Font("Segoe Script", Font.PLAIN, 30));
		panel_14.add(lblNewLabel_15_1);
		
		JPanel panel_15 = new JPanel();
		FlowLayout flowLayout_8 = (FlowLayout) panel_15.getLayout();
		flowLayout_8.setHgap(50);
		worker_search_panel.add(panel_15, BorderLayout.WEST);
		
		JPanel panel_16 = new JPanel();
		FlowLayout flowLayout_9 = (FlowLayout) panel_16.getLayout();
		flowLayout_9.setHgap(50);
		worker_search_panel.add(panel_16, BorderLayout.EAST);
		
		JPanel panel_17 = new JPanel();
		worker_search_panel.add(panel_17, BorderLayout.CENTER);
		
		JPanel panel_19_1 = new JPanel();
		
		JLabel vs_Label_2_1_1 = new JLabel("Equipment ID:");
		vs_Label_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField_14 = new JTextField();
		textField_14.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_14.setColumns(10);
		
		JTextArea srtextArea_1 = new JTextArea();
		srtextArea_1.setRows(10);
		srtextArea_1.setEditable(false);
		srtextArea_1.setColumns(50);
		GroupLayout gl_panel_19_1 = new GroupLayout(panel_19_1);
		gl_panel_19_1.setHorizontalGroup(
			gl_panel_19_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 449, Short.MAX_VALUE)
				.addGroup(gl_panel_19_1.createSequentialGroup()
					.addGroup(gl_panel_19_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_19_1.createSequentialGroup()
							.addGap(127)
							.addComponent(vs_Label_2_1_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_14, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_19_1.createSequentialGroup()
							.addGap(26)
							.addComponent(srtextArea_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		gl_panel_19_1.setVerticalGroup(
			gl_panel_19_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 226, Short.MAX_VALUE)
				.addGroup(gl_panel_19_1.createSequentialGroup()
					.addGroup(gl_panel_19_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(vs_Label_2_1_1)
						.addComponent(textField_14, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(srtextArea_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(13, Short.MAX_VALUE))
		);
		panel_19_1.setLayout(gl_panel_19_1);
		
		JButton srSearch_1 = new JButton("Search");
		srSearch_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton srBack_1 = new JButton("Back");
		srBack_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		srBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GroupLayout gl_panel_17 = new GroupLayout(panel_17);
		gl_panel_17.setHorizontalGroup(
			gl_panel_17.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_17.createSequentialGroup()
					.addGroup(gl_panel_17.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_17.createSequentialGroup()
							.addGap(23)
							.addComponent(panel_19_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_17.createSequentialGroup()
							.addGap(156)
							.addComponent(srSearch_1)
							.addGap(69)
							.addComponent(srBack_1)))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		gl_panel_17.setVerticalGroup(
			gl_panel_17.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_17.createSequentialGroup()
					.addGap(5)
					.addComponent(panel_19_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addGroup(gl_panel_17.createParallelGroup(Alignment.BASELINE)
						.addComponent(srBack_1)
						.addComponent(srSearch_1))
					.addGap(110))
		);
		panel_17.setLayout(gl_panel_17);
		
		
		
		JLabel lblNewLabel_10 = new JLabel("Equipment Inventory");
		lblNewLabel_10.setBounds(215, 11, 555, 63);
		lblNewLabel_10.setFont(new Font("Modern No. 20", Font.BOLD, 60));
		view_Inventory_panel.add(lblNewLabel_10);
		
		JScrollPane scrollPane_9 = new JScrollPane();
		scrollPane_9.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_9.setBounds(96, 117, 790, 427);
		view_Inventory_panel.add(scrollPane_9);
		
		
		scrollPane_9.setViewportView(viewInvtable);
		viewInvtable.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton viewinvbackbtn = new JButton("Back",new ImageIcon(backicon));
		viewinvbackbtn.setIconTextGap(10);
		viewinvbackbtn.setVerticalTextPosition(SwingConstants.CENTER);
		viewinvbackbtn.setHorizontalTextPosition(SwingConstants.LEFT);
		viewinvbackbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				OwnerMenu.show();
				options_panel2.hide();
				login_panel.hide();	
				add_equipment_panel.hide();
				modify_equipment_panel.hide();
				delete_equipment_panel.hide();
				schedule_panel.hide();
				modify_schedule_panel.hide();
				search_panel.hide();
				view_equipment_schedules_panel.hide();
				worker_schedule_equipment_panel.hide();
				worker_view_schedule_panel_.hide();
				worker_search_panel.hide();
				view_Inventory_panel.hide();
				
			}
		});
		viewinvbackbtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		viewinvbackbtn.setBounds(132, 555, 112, 40);
		view_Inventory_panel.add(viewinvbackbtn);
		
		JLabel lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.setBorder(new TitledBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "View All Equipment ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		lblNewLabel_13.setBounds(69, 90, 846, 523);
		view_Inventory_panel.add(lblNewLabel_13);
		
		JPanel return_equipment_panel = new JPanel();
		panel.add(return_equipment_panel, "name_1031140317101900");
		return_equipment_panel.setLayout(new BorderLayout(0, 0));
		
		JPanel aR1 = new JPanel();
		return_equipment_panel.add(aR1, BorderLayout.NORTH);
		
		JLabel aR_Label_1_1 = new JLabel("Accept Returned Equipment");
		aR_Label_1_1.setFont(new Font("Modern No. 20", Font.BOLD, 60));
		aR1.add(aR_Label_1_1);
		
		JPanel aR2_1 = new JPanel();
		aR2_1.setLayout(null);
		return_equipment_panel.add(aR2_1, BorderLayout.CENTER);
		
		JButton return_equipment_btn = new JButton("Return", new ImageIcon(returnicon));
		return_equipment_btn.setVerticalTextPosition(SwingConstants.CENTER);
		return_equipment_btn.setIconTextGap(10);
		return_equipment_btn.setHorizontalTextPosition(SwingConstants.LEFT);
		return_equipment_btn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		return_equipment_btn.setBounds(100, 491, 120, 40);
		aR2_1.add(return_equipment_btn);
		
		JButton return_equipment_back_btn = new JButton("Back", new ImageIcon(backicon));
		return_equipment_back_btn.setVerticalTextPosition(SwingConstants.CENTER);
		return_equipment_back_btn.setIconTextGap(10);
		return_equipment_back_btn.setHorizontalTextPosition(SwingConstants.LEFT);
		return_equipment_back_btn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		return_equipment_back_btn.setBounds(790, 491, 101, 40);
		aR2_1.add(return_equipment_back_btn);
		mS4_1_1_1.setLayout(null);
		mS4_1_1_1.setBorder(new TitledBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Scheduling Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		mS4_1_1_1.setBounds(100, 224, 794, 256);
		
		aR2_1.add(mS4_1_1_1);
		ms_Label_2_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		ms_Label_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		ms_Label_2_1_1.setBounds(10, 32, 86, 21);
		
		mS4_1_1_1.add(ms_Label_2_1_1);
		ms_Label_3_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		ms_Label_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		ms_Label_3_1_1.setBounds(10, 100, 94, 21);
		
		mS4_1_1_1.add(ms_Label_3_1_1);
		s_Label_id_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		s_Label_id_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		s_Label_id_1_1_1.setBounds(10, 175, 86, 21);
		
		mS4_1_1_1.add(s_Label_id_1_1_1);
		ms_Label_4_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		ms_Label_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		ms_Label_4_1_1.setBounds(225, 32, 154, 21);
		
		mS4_1_1_1.add(ms_Label_4_1_1);
		aStartDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		aStartDate.setEditable(false);
		aStartDate.setColumns(10);
		aStartDate.setBounds(10, 123, 196, 31);
		
		mS4_1_1_1.add(aStartDate);
		ms_Label_5_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		ms_Label_5_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		ms_Label_5_1_1.setBounds(225, 100, 146, 21);
		
		mS4_1_1_1.add(ms_Label_5_1_1);
		aEndTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		aEndTime.setEditable(false);
		aEndTime.setColumns(10);
		aEndTime.setBounds(225, 123, 196, 31);
		
		mS4_1_1_1.add(aEndTime);
		aLocation.setFont(new Font("Tahoma", Font.PLAIN, 14));
		aLocation.setEditable(false);
		aLocation.setColumns(10);
		aLocation.setBounds(10, 54, 196, 31);
		
		mS4_1_1_1.add(aLocation);
		aEndDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		aEndDate.setEditable(false);
		aEndDate.setColumns(10);
		aEndDate.setBounds(10, 202, 196, 31);
		
		mS4_1_1_1.add(aEndDate);
		aStartTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		aStartTime.setEditable(false);
		aStartTime.setColumns(10);
		aStartTime.setBounds(225, 54, 196, 31);
		
		mS4_1_1_1.add(aStartTime);
		
		JScrollPane scrollPane_13 = new JScrollPane();
		scrollPane_13.setBounds(438, 32, 346, 187);
		mS4_1_1_1.add(scrollPane_13);
		return_equipment_table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Equipment ID", "Equipment Name", "Quantity"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		scrollPane_13.setViewportView(return_equipment_table);
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setBorder(new TitledBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Accept Returned Equipment", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		lblNewLabel_3_1.setBounds(60, 11, 885, 536);
		aR2_1.add(lblNewLabel_3_1);
		lblNewLabel_20_1.setBorder(new TitledBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Select Event Schedule List", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		lblNewLabel_20_1.setBounds(100, 37, 416, 176);
		
		aR2_1.add(lblNewLabel_20_1);
		scrollPane_12_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_12_1.setBounds(111, 60, 265, 136);
		
		aR2_1.add(scrollPane_12_1);
		
		scrollPane_12_1.setViewportView(list_1);
		aRSelect_btn.setVerticalTextPosition(SwingConstants.CENTER);
		aRSelect_btn.setIconTextGap(10);
		aRSelect_btn.setHorizontalTextPosition(SwingConstants.LEFT);
		aRSelect_btn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		aRSelect_btn.setBounds(397, 110, 105, 40);
		
		aR2_1.add(aRSelect_btn);
		
		aRSelect_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.print("clicked");
				String id = list_1.getSelectedValue().toString();
				ArrayList<Object[]> result = app.callViewSchedule(id);
				ArrayList<Object[]> result2 = app.callGetScheduledEquipment(id);
				
				DefaultTableModel model = (DefaultTableModel) return_equipment_table.getModel();
				
				
				for(Object[] r : result2) {
					model.addRow(new Object[] {r[1], r[2], r[3]});
				}
				
				for(Object[] r: result) {
					aLocation.setText(r[1].toString());
					aStartDate.setText(r[2].toString());
					aEndDate.setText((String) r[3]);
					aStartTime.setText(r[4].toString());
					aEndTime.setText(r[5].toString());
				}
			}
		});
		
		return_equipment_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(list_1.isSelectionEmpty() == false) {
					
					DefaultTableModel model = (DefaultTableModel) return_equipment_table.getModel();
					
					String id = list_1.getSelectedValue().toString();
					ArrayList<Object[]> result2 = app.callGetScheduledEquipment(id);
					
					app.callReturnEquipment(id, result2);
					
					JOptionPane.showMessageDialog(null,"Equipment Succesfully Returned","Success",JOptionPane.INFORMATION_MESSAGE);
					
					aLocation.setText("");
					aStartDate.setText("");
					aEndDate.setText("");
					aStartTime.setText("");
					aEndTime.setText("");
					
					reloadEventIds();
					
					
					model.setRowCount(0);
					
				} else {
					
					JOptionPane.showMessageDialog(null,"Please select an Event ID from list","Warning",JOptionPane.WARNING_MESSAGE);
					
				}
				
				
				
			}
		});
		
		/**
		 * Action listener to allow user authentication for login
		 */
		login_button.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				/**
				 * test for password: 12345    and user name: user
				 */
				txtpnInvalidCredentialsEntered = new JTextField();
				txtpnInvalidCredentialsEntered.setEditable(false);
				txtpnInvalidCredentialsEntered.setBackground(UIManager.getColor("Panel.background"));
				txtpnInvalidCredentialsEntered.setForeground(Color.RED);
				txtpnInvalidCredentialsEntered.setText("Invalid credentials entered.");
				txtpnInvalidCredentialsEntered.setBounds(187, 380, 155, 20);
				txtpnInvalidCredentialsEntered.setBorder(null);
				l4.add(txtpnInvalidCredentialsEntered);
				
				String p ="";
				for (int i = 0; i < password_Field.getPassword().length; i++) {
					p += password_Field.getPassword()[i];
				}
				
				if (Username_Field.getText().compareTo("user") == 0) {
					if (p.compareTo("12345")==0) {
						OwnerMenu.show();
						login_panel.hide();	
						txtpnInvalidCredentialsEntered.hide();
						
					}
					else {
						txtpnInvalidCredentialsEntered.setText("Invalid credentials entered.");
						txtpnInvalidCredentialsEntered.show();
						l4.setBorder(new LineBorder(Color.RED,2));
					}
				}
				else if (Username_Field.getText().compareTo("emp") == 0) {
					if (p.compareTo("0000")==0) {
						options_panel2.show();
						login_panel.hide();	
						txtpnInvalidCredentialsEntered.hide();
					}
					else {
						txtpnInvalidCredentialsEntered.setText("Invalid credentials entered.");
						txtpnInvalidCredentialsEntered.show();
						l4.setBorder(new LineBorder(Color.RED,2));
					}
				}
				else {
					txtpnInvalidCredentialsEntered.setText("Invalid credentials entered.");
					l4.setBorder(new LineBorder(Color.RED,2));
				}
			}
		});
					
		/**
		 * Action listener for the owner view
		 */
		
		vASBack_1_1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				OwnerMenu.show();
				options_panel2.hide();
				login_panel.hide();	
				add_equipment_panel.hide();
				modify_equipment_panel.hide();
				delete_equipment_panel.hide();
				schedule_panel.hide();
				modify_schedule_panel.hide();
				search_panel.hide();
				view_equipment_schedules_panel.hide();
				view_equipment_schedules_panel.hide();
				view_Inventory_panel.hide();
				view_Inventory_panel.hide();
				view_all_schedule_panel.hide();
				return_equipment_panel.hide();
				vASBack_1_1.hide();
				//schedule_panel_1.hide();
				//search_panel_1.hide();
				event_schedule.setRowCount(0);
			}
		});
		
		addEqu_button.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				//xxxxx
				OwnerMenu.hide();
				options_panel2.hide();
				login_panel.hide();	
				add_equipment_panel.show();
				modify_equipment_panel.hide();
				delete_equipment_panel.hide();
				schedule_panel.hide();
				modify_schedule_panel.hide();
				search_panel.hide();
				view_equipment_schedules_panel.hide();
				worker_view_schedule_panel_.hide();
				worker_search_panel.hide();
				worker_schedule_equipment_panel.hide();
				view_Inventory_panel.hide();
				view_all_schedule_panel.hide();
				return_equipment_panel.hide();
			}
		});
		
		modEqu_button.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				listModel.clear();
				reloadIdList();
				OwnerMenu.hide();
				options_panel2.hide();
				login_panel.hide();	
				add_equipment_panel.hide();
				modify_equipment_panel.show();
				delete_equipment_panel.hide();
				schedule_panel.hide();
				modify_schedule_panel.hide();
				search_panel.hide();
				view_equipment_schedules_panel.hide();
				worker_view_schedule_panel_.hide();
				worker_search_panel.hide();
				worker_schedule_equipment_panel.hide();
				view_Inventory_panel.hide();
				view_all_schedule_panel.hide();
				return_equipment_panel.hide();
			}
		});
		
		delEqu_button.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel dmodel = (DefaultTableModel) dInventoryTable.getModel();
				dmodel.setRowCount(0);
				ArrayList<Object[]> allEquipment = app.loadResourceList();
				for(Object[]pair:allEquipment) {
					dmodel.addRow(new Object[] {pair[0], pair[1]});
				}
				
				OwnerMenu.hide();
				options_panel2.hide();
				login_panel.hide();	
				add_equipment_panel.hide();
				modify_equipment_panel.hide();
				delete_equipment_panel.show();
				schedule_panel.hide();
				modify_schedule_panel.hide();
				search_panel.hide();
				view_equipment_schedules_panel.hide();
				worker_view_schedule_panel_.hide();
				worker_search_panel.hide();
				worker_schedule_equipment_panel.hide();
				view_Inventory_panel.hide();
				view_all_schedule_panel.hide();
				return_equipment_panel.hide();
			}
		});
		
		schedule_button.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				reloadIdList();
				OwnerMenu.hide();
				options_panel2.hide();
				login_panel.hide();	
				add_equipment_panel.hide();
				modify_equipment_panel.hide();
				delete_equipment_panel.hide();
				schedule_panel.show();
				modify_schedule_panel.hide();
				search_panel.hide();
				view_equipment_schedules_panel.hide();
				worker_view_schedule_panel_.hide();
				worker_search_panel.hide();
				worker_schedule_equipment_panel.hide();
				view_Inventory_panel.hide();
				view_all_schedule_panel.hide();
				return_equipment_panel.hide();
			}
		});
		
		modSch_button.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				listModel1.clear();
				 reloadPendingScheduledEventIds();
				
				OwnerMenu.hide();
				options_panel2.hide();
				login_panel.hide();	
				add_equipment_panel.hide();
				modify_equipment_panel.hide();
				delete_equipment_panel.hide();
				schedule_panel.hide();
				modify_schedule_panel.show();
				search_panel.hide();
				view_equipment_schedules_panel.hide();
				worker_view_schedule_panel_.hide();
				worker_search_panel.hide();
				worker_schedule_equipment_panel.hide();
				view_Inventory_panel.hide();
				view_all_schedule_panel.hide();
				return_equipment_panel.hide();
			}
		});
		
		search_button.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel dmodel = (DefaultTableModel) sInventoryTable.getModel();
				dmodel.setRowCount(0);
				ArrayList<Object[]> allEquipment = app.loadResourceList();
				for(Object[]pair:allEquipment) {
					dmodel.addRow(new Object[] {pair[0], pair[1], pair[2], pair[3]});
				}
				OwnerMenu.hide();
				options_panel2.hide();
				login_panel.hide();	
				add_equipment_panel.hide();
				modify_equipment_panel.hide();
				delete_equipment_panel.hide();
				schedule_panel.hide();
				modify_schedule_panel.hide();
				search_panel.show();
				view_equipment_schedules_panel.hide();
				worker_view_schedule_panel_.hide();
				worker_search_panel.hide();
				worker_schedule_equipment_panel.hide();
				view_Inventory_panel.hide();
				view_all_schedule_panel.hide();
				return_equipment_panel.hide();
			}
		});
		
		viewSch_button.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				reloadContainsIdList();
				OwnerMenu.hide();
				options_panel2.hide();
				login_panel.hide();	
				add_equipment_panel.hide();
				modify_equipment_panel.hide();
				delete_equipment_panel.hide();
				schedule_panel.hide();
				modify_schedule_panel.hide();
				search_panel.hide();
				view_equipment_schedules_panel.show();
				worker_view_schedule_panel_.hide();
				worker_search_panel.hide();
				worker_schedule_equipment_panel.hide();
				view_Inventory_panel.hide();
				view_all_schedule_panel.hide();
				return_equipment_panel.hide();
			}
		});
		
		all_schedule_btn.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				view_Inventory_panel.hide();
				event_schedule.setRowCount(0);
				vASBack_1_1.show();
				OwnerMenu.hide();
				options_panel2.hide();
				login_panel.hide();	
				add_equipment_panel.hide();
				modify_equipment_panel.hide();
				delete_equipment_panel.hide();
				schedule_panel.hide();
				modify_schedule_panel.hide();
				search_panel.hide();
				view_equipment_schedules_panel.hide();
				worker_view_schedule_panel_.hide();
				worker_search_panel.hide();
				worker_schedule_equipment_panel.hide();
				view_all_schedule_panel.show();
				return_equipment_panel.hide();
				ArrayList<Object[]> allSchedules= app.callViewAllSchedules();
				
				for(Object[] schedule: allSchedules) {
					event_schedule.addRow(new Object[] {schedule[0],schedule[1],schedule[2],schedule[3],schedule[4], schedule[5]});
				}
			}
		});
		
		
		schedule_button_1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				OwnerMenu.hide();
				options_panel2.hide();
				login_panel.hide();	
				add_equipment_panel.hide();
				modify_equipment_panel.hide();
				delete_equipment_panel.hide();
				schedule_panel.hide();
				modify_schedule_panel.hide();
				search_panel.hide();
				search_panel.hide();
				view_equipment_schedules_panel.hide();
				worker_schedule_equipment_panel.show();
				worker_view_schedule_panel_.hide();
				worker_search_panel.hide();
				view_Inventory_panel.hide();
				view_Inventory_panel.hide();
				view_all_schedule_panel.hide();
				return_equipment_panel.hide();
			}
		});
		
		search_button_1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				OwnerMenu.hide();
				options_panel2.hide();
				login_panel.hide();	
				add_equipment_panel.hide();
				modify_equipment_panel.hide();
				delete_equipment_panel.hide();
				schedule_panel.hide();
				modify_schedule_panel.hide();
				search_panel.hide();
				worker_schedule_equipment_panel.hide();
				worker_view_schedule_panel_.hide();
				view_Inventory_panel.hide();
				worker_search_panel.show();
				view_Inventory_panel.hide();
				return_equipment_panel.hide();
			}
		});
		
		viewSch_button_1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				reloadIdList();
				OwnerMenu.hide();
				options_panel2.hide();
				login_panel.hide();	
				add_equipment_panel.hide();
				modify_equipment_panel.hide();
				view_Inventory_panel.hide();
				delete_equipment_panel.hide();
				schedule_panel.hide();
				modify_schedule_panel.hide();
				search_panel.hide();
				view_equipment_schedules_panel.hide();
				worker_view_schedule_panel_.show();
				worker_search_panel.hide();
				worker_schedule_equipment_panel.hide();
				view_Inventory_panel.hide();
				return_equipment_panel.hide();
			}
		});		
		
		accept_eqp_button.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				
				listModel2.clear();
				reloadEventIds();
				
				OwnerMenu.hide();
				options_panel2.hide();
				login_panel.hide();	
				add_equipment_panel.hide();
				modify_equipment_panel.hide();
				delete_equipment_panel.hide();
				schedule_panel.hide();
				modify_schedule_panel.hide();
				search_panel.hide();
				view_equipment_schedules_panel.hide();
				worker_view_schedule_panel_.hide();
				worker_search_panel.hide();
				worker_schedule_equipment_panel.hide();
				view_Inventory_panel.hide();
				view_all_schedule_panel.hide();
				return_equipment_panel.show();
			}
		});
		
		
		/**
		 * Action listeners for the back buttons on each option panel
		 */		
		aBack.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				OwnerMenu.show();
				options_panel2.hide();
				login_panel.hide();	
				add_equipment_panel.hide();
				modify_equipment_panel.hide();
				delete_equipment_panel.hide();
				schedule_panel.hide();
				modify_schedule_panel.hide();
				search_panel.hide();
				view_equipment_schedules_panel.hide();
				worker_schedule_equipment_panel.hide();
				worker_view_schedule_panel_.hide();
				worker_search_panel.hide();
				view_Inventory_panel.hide();
				view_all_schedule_panel.hide();
				return_equipment_panel.hide();
			}
		});
		
		modify_equipment_back_btn.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				OwnerMenu.show();
				options_panel2.hide();
				login_panel.hide();	
				add_equipment_panel.hide();
				modify_equipment_panel.hide();
				delete_equipment_panel.hide();
				schedule_panel.hide();
				modify_schedule_panel.hide();
				search_panel.hide();
				view_equipment_schedules_panel.hide();
				worker_schedule_equipment_panel.hide();
				worker_view_schedule_panel_.hide();
				worker_search_panel.hide();
				view_Inventory_panel.hide();
				view_all_schedule_panel.hide();
				return_equipment_panel.hide();
			}
		});
		
		dBack.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				OwnerMenu.show();
				options_panel2.hide();
				login_panel.hide();	
				add_equipment_panel.hide();
				modify_equipment_panel.hide();
				delete_equipment_panel.hide();
				schedule_panel.hide();
				modify_schedule_panel.hide();
				search_panel.hide();
				view_equipment_schedules_panel.hide();
				worker_schedule_equipment_panel.hide();
				worker_view_schedule_panel_.hide();
				worker_search_panel.hide();
				view_Inventory_panel.hide();
				view_all_schedule_panel.hide();
				return_equipment_panel.hide();
			}
		});
		
		scheduleBackbtn.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				OwnerMenu.show();
				options_panel2.hide();
				login_panel.hide();	
				add_equipment_panel.hide();
				modify_equipment_panel.hide();
				delete_equipment_panel.hide();
				schedule_panel.hide();
				modify_schedule_panel.hide();
				search_panel.hide();
				view_equipment_schedules_panel.hide();
				worker_schedule_equipment_panel.hide();
				worker_view_schedule_panel_.hide();
				worker_search_panel.hide();
				eventIDTextField.setText("");
				locationTextField.setText("");
				((JTextField)schedulestartdateChooser.getDateEditor().getUiComponent()).setText("");
				startTimeTextField.setText("");
				endTimeTextField.setText("");
				quantityInputTextField.setText("");
				DefaultTableModel model= (DefaultTableModel)ScheduleEquipmentTable.getModel();
				model.setRowCount(0);
				view_Inventory_panel.hide();
				return_equipment_panel.hide();
			}
		});
		searchBack.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				OwnerMenu.show();
				options_panel2.hide();
				login_panel.hide();	
				add_equipment_panel.hide();
				modify_equipment_panel.hide();
				delete_equipment_panel.hide();
				schedule_panel.hide();
				modify_schedule_panel.hide();
				search_panel.hide();
				view_equipment_schedules_panel.hide();
				worker_schedule_equipment_panel.hide();
				worker_view_schedule_panel_.hide();
				worker_search_panel.hide();
				search_2.setText("");
				return_equipment_panel.hide();
			}
		});
		
		mSback.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				OwnerMenu.show();
				options_panel2.hide();
				login_panel.hide();	
				add_equipment_panel.hide();
				modify_equipment_panel.hide();
				delete_equipment_panel.hide();
				schedule_panel.hide();
				modify_schedule_panel.hide();
				search_panel.hide();
				view_equipment_schedules_panel.hide();
				worker_schedule_equipment_panel.hide();
				worker_view_schedule_panel_.hide();
				worker_search_panel.hide();
				newlocation.setText("");
				newstarttime.setText("");
				newendtime.setText("");
				view_Inventory_panel.hide();
				view_all_schedule_panel.hide();
				return_equipment_panel.hide();
			}
		});
		
		vASBack_1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				OwnerMenu.show();
				options_panel2.hide();
				login_panel.hide();	
				add_equipment_panel.hide();
				modify_equipment_panel.hide();
				delete_equipment_panel.hide();
				schedule_panel.hide();
				modify_schedule_panel.hide();
				search_panel.hide();
				view_equipment_schedules_panel.hide();
				worker_schedule_equipment_panel.hide();
				worker_view_schedule_panel_.hide();
				worker_search_panel.hide();
				view_Inventory_panel.hide();
				view_all_schedule_panel.hide();
				return_equipment_panel.hide();
			}
		});
				
		vsBack_1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				OwnerMenu.hide();
				options_panel2.show();
				login_panel.hide();	
				add_equipment_panel.hide();
				modify_equipment_panel.hide();
				delete_equipment_panel.hide();
				schedule_panel.hide();
				modify_schedule_panel.hide();
				search_panel.hide();
				view_equipment_schedules_panel.hide();
				worker_schedule_equipment_panel.hide();
				worker_view_schedule_panel_.hide();
				worker_search_panel.hide();
				textField_13.setText("");
				vstextArea_1.setText("");
				view_Inventory_panel.hide();
				view_all_schedule_panel.hide();
				return_equipment_panel.hide();
			}
		});
		
		srBack_1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				OwnerMenu.hide();
				options_panel2.show();
				login_panel.hide();	
				add_equipment_panel.hide();
				modify_equipment_panel.hide();
				delete_equipment_panel.hide();
				schedule_panel.hide();
				modify_schedule_panel.hide();
				search_panel.hide();
				view_equipment_schedules_panel.hide();
				worker_schedule_equipment_panel.hide();
				worker_view_schedule_panel_.hide();
				view_Inventory_panel.hide();
				worker_search_panel.hide();
				textField_14.setText("");
				srtextArea_1.setText("");
				view_all_schedule_panel.hide();
				return_equipment_panel.hide();
			}
		});
		
		sBack_1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				OwnerMenu.hide();
				options_panel2.show();
				login_panel.hide();	
				add_equipment_panel.hide();
				modify_equipment_panel.hide();
				delete_equipment_panel.hide();
				schedule_panel.hide();
				modify_schedule_panel.hide();
				search_panel.hide();
				view_equipment_schedules_panel.hide();
				worker_schedule_equipment_panel.hide();
				worker_view_schedule_panel_.hide();
				worker_search_panel.hide();
				view_Inventory_panel.hide();
				textField_id_3.setText("");
				textField_6.setText("");
				textField_7.setText("");
				textField_9.setText("");
				textField_10.setText("");
				textField_11.setText("");
				textField_12.setText("");
				view_all_schedule_panel.hide();
				return_equipment_panel.hide();
			}
		});
		
		return_equipment_back_btn.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				OwnerMenu.show();
				options_panel2.hide();
				login_panel.hide();	
				add_equipment_panel.hide();
				modify_equipment_panel.hide();
				delete_equipment_panel.hide();
				schedule_panel.hide();
				modify_schedule_panel.hide();
				search_panel.hide();
				view_equipment_schedules_panel.hide();
				worker_schedule_equipment_panel.hide();
				worker_view_schedule_panel_.hide();
				worker_search_panel.hide();
				view_Inventory_panel.hide();
				view_all_schedule_panel.hide();
				return_equipment_panel.hide();
			}
		});
		
		chckbxNewCheckBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (chckbxNewCheckBox.isSelected()){
					changecurrentname.setEnabled(true);
					scrollPane_10.setEnabled(true);
					changecurrentname.setBackground(Color.WHITE);
				}else{
					changecurrentname.setEnabled(false);
					scrollPane_10.setEnabled(false);
					changecurrentname.setBackground(new Color(240, 240, 240));
				}
				
			}
		});
		
		
		
		
		/**
		 * Action listeners for the save/schedule buttons on each option panel
		 */	
		
		/*
		//add equipment 
		aSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nme = atextField_1.getText();
				int quantity =  Integer.parseInt(atextField_2.getText());
				String genericid= nme.substring(0,3)+"#"+app.genStr();
				atextArea.setText(genericid);
				app.delay();
				app.addNewEquipment(genericid, nme, quantity);
				//atextField_1.setText("");
				//atextField_2.setText("");
				//atextArea.setText("");
				
			}
		});
		
		//modify equipment quantity
		mESave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id = mEtextField_1.getText();
				int new_quantity = Integer.parseInt(mEtextField_2.getText());
				app.equipmentModifier(id, new_quantity, new_quantity);
			}
		});
		
		//delete equipment
		dDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id = dtextField.getText();
				app.equipmentRemover(id);
				dtextArea.setText("Equipment with id: "+id+" deleted");
			}
		});
		
		*/
		//schedule equipment
		

		sSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<String[]> list = new ArrayList<String[]>();
				String eventid = eventIDTextField.getText();
				String location = locationTextField.getText();
				String sdate = ((JTextField)schedulestartdateChooser.getDateEditor().getUiComponent()).getText();
				String edate = ((JTextField)scheduleenddateChooser.getDateEditor().getUiComponent()).getText();
				String s_time = startTimeTextField.getText();
				String e_time = endTimeTextField.getText();
				//int quantity = Integer.parseInt(quantityInputTextField.getText());
				if ((eventid.isBlank()||location.isBlank()||sdate.isBlank()||edate.isBlank()||s_time.isBlank()||e_time.isBlank())==false) {
					DefaultTableModel model= (DefaultTableModel)ScheduleEquipmentTable.getModel();
					if(model.getRowCount()>0){
					    for (int i = 0; model.getRowCount() > i; i++){
					    	String[] pairs = {(String)model.getValueAt(i, 0), model.getValueAt(i, 1).toString()};
					    	list.add(pairs);
					    }
					    String response=app.callScheduleEquipment(eventid, location, sdate, edate, s_time, e_time, list);
					    if (response.equals("success")){
					    	JOptionPane.showMessageDialog(null,"Equiment was successfully scheduled.","Success",JOptionPane.INFORMATION_MESSAGE);
					    	eventIDTextField.setText("");
					    	locationTextField.setText("");
					    	((JTextField)schedulestartdateChooser.getDateEditor().getUiComponent()).setText("");
					    	((JTextField)scheduleenddateChooser.getDateEditor().getUiComponent()).setText("");
					    	startTimeTextField.setText("");
					    	endTimeTextField.setText("");
					    	model.setRowCount(0);
					    }
					    else {
					    	JOptionPane.showMessageDialog(null,response,"Scheduling Error",JOptionPane.WARNING_MESSAGE);
					    }
					}
					else {
						JOptionPane.showMessageDialog(null,"List of Equipment cannot be empty.","System Warning",JOptionPane.WARNING_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(null,"Please ensure that scheduling details are filled in.","System Warning",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		                                           	
		
		vaSearchByEquipmentIDBtn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (eq_list.isSelectionEmpty()==false) {
					String eqID = eq_list.getSelectedValue().toString();
					if((eqID.isBlank())==false){
						while(model_schedule.getRowCount() > 0){
							model_schedule.setRowCount(0);
						}
						ArrayList<Object[]> allEquipmentSchedules = app.callViewAllEquipmentSchedules(eqID);
						for(int x = 0; x < allEquipmentSchedules.size(); x++) {
							model_schedule.addRow(allEquipmentSchedules.get(x));
						}
					}
					else {
						JOptionPane.showMessageDialog(null,"Equipment Id cannot be empty.","System Warning",JOptionPane.WARNING_MESSAGE);
					}	
				}
				else {
					JOptionPane.showMessageDialog(null,"Please select item from list.","System Warning",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		view_inv_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model= (DefaultTableModel)viewInvtable.getModel();
				model.setRowCount(0);
				for(Object[]record:app.loadResourceList()){
					model.addRow(new Object[]{record[0].toString(),record[1].toString(),record[2].toString(),record[3].toString()});
				}
				view_Inventory_panel.show();
				OwnerMenu.hide();
				options_panel2.hide();
				login_panel.hide();	
				add_equipment_panel.hide();
				modify_equipment_panel.hide();
				delete_equipment_panel.hide();
				schedule_panel.hide();
				modify_schedule_panel.hide();
				search_panel.hide();
				view_equipment_schedules_panel.hide();
				worker_schedule_equipment_panel.hide();
				worker_view_schedule_panel_.hide();
				worker_search_panel.hide();
				view_all_schedule_panel.hide();
				

			}
		});
		
		/***************************************************************
		
		//modify schedule
		mSsave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id = textField_id_2.getText();
				String eventid = textField.getText();
				String location = textField_1.getText();
				String date = textField_2.getText();
				String s_time = textField_3.getText();
				String e_time = textField_4.getText();
				int quantity = Integer.parseInt(textField_5.getText());
				app.scheduleModifier(eventid, location, date, s_time, e_time, id, quantity);
			}
		});
		
		
		//search
		srSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id = textField_8.getText();
				textArea_2.setText(app.equipmentInfoViewer(id));
			}
		});
		
		//view schedule
		vsView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id = vstextField.getText();
				vstextArea.setText(app.schedule_Viewer(id));
			}
		});	
		
		//schedule equipment - employee view
		sSchedule_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id = textField_id_3.getText();
				String eventid = textField_6.getText();
				String location = textField_7.getText();
				String date = textField_9.getText();
				String s_time = textField_10.getText();
				String e_time = textField_11.getText();
				int quantity = Integer.parseInt(textField_12.getText());
				app.equipmentScheduler(eventid, location, date, s_time, e_time, id, quantity);
			}
		});
		
		//view schedule - employee view
		vsView_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id = textField_13.getText();
				vstextArea_1.setText(app.schedule_Viewer(id));
			}
		});		
		
		//search - employee view
		srSearch_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id = textField_14.getText();
				srtextArea_1.setText(app.equipmentInfoViewer(id));
			}
		});
		
		
		******************************************************/
	
		
	}
	public void reloadIdList(){
		listModel.clear();
		ArrayList<String>list=null;
		list=app.loadIDs();
		for(String id:list){
			listModel.addElement(id);
		}
	}
	
	public void reloadEventIds() {
		listModel2.clear();
		ArrayList<Object[]>list1=null;
		list1=app.callViewScheduledSchedules();
		for(Object[] l:list1){
			listModel2.addElement(l[0].toString());
		}
	}
	
	public void reloadPendingScheduledEventIds() {
		listModel1.clear();
		ArrayList<Object[]>list2=null;
		list2=app.callPendingAndScheduledSchedules();
		for(Object[] l:list2){
			listModel1.addElement(l[0].toString());
		}
	}
	
	public void reloadContainsIdList(){
		listModel.clear();
		ArrayList<String>list=null;
		list=app.loadContainsIDs();
		for(String id:list){
			listModel.addElement(id);
		}
	}
}
	