package quanlykhachsan_v2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.GridLayout;
import java.awt.SystemColor;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.UIManager;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class viewPhong extends JFrame {
	String chuoikn = "jdbc:sqlserver://TRANQUOC-PC:1433; databaseName=hotel;integratedSecurity=true";
	ModelHotel adapterMd = new ModelHotel();
	ControllerHotel adapterCtr = new ControllerHotel();
	private JPanel contentPane;
	private JTextField txtTen;
	private JTextField txtGia;
	private JTextField txtNote;
	private JTable tblPhong;
	private JLabel lblTongPhong;
	private JLabel lblPhongTrong;
	private JLabel lblPhongDat;
	private JLabel lblPhongDon;
	private JLabel lblPhongDoi;
	private JLabel lblPhongBa;
	private JLabel lblPhongVip;
	private JComboBox cmbLp;
	private JComboBox comboBox;
	private String chonloaiphong;
	private String id;
	String namephong = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewPhong frame = new viewPhong();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public viewPhong() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				adapterCtr = new ControllerHotel();
				tblPhong.setModel(adapterCtr.timKiemPhong(6));

				lblTongPhong.setText(adapterCtr.demDong("tb_phong", adapterCtr.demPhong));
				lblPhongTrong.setText(adapterCtr.demDong("tb_phong", adapterCtr.demPhongTrong));
				lblPhongDat.setText(adapterCtr.demDong("tb_phong", adapterCtr.demPhongDat));
				lblPhongDon.setText(adapterCtr.demDong("tb_phong", adapterCtr.demPhongDon));
				lblPhongDoi.setText(adapterCtr.demDong("tb_phong", adapterCtr.demPhongDoi));
				lblPhongBa.setText(adapterCtr.demDong("tb_phong", adapterCtr.demPhongBa));
				lblPhongVip.setText(adapterCtr.demDong("tb_phong", adapterCtr.demPhongVip));
			}
		});
		setBounds(100, 100, 730, 484);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 102, 102));
		contentPane.setForeground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(0, 0, 51));
		panel_1.setBackground(SystemColor.inactiveCaption);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Th\u00F4ng tin ph\u00F2ng:",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
		panel_1.setBounds(167, 52, 547, 393);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JButton btnXoa = new JButton("X\u00F3a");
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXoa.setForeground(new Color(255, 255, 255));
		btnXoa.setBackground(new Color(0, 0, 102));
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String quyen = adapterCtr.cellTb("tinhtrang", adapterCtr.itemLogin(adapterCtr.Id("id_1", "id")));
				if (!quyen.equals("1")) {
					JOptionPane.showMessageDialog(null, "Bạn không được sử dụng chức năng này!");
					return;
				}
				//trương hợp phòng đang có người dùng mà chúng ta xóa thì không được
				
				if(namephong.equals("Phòng đã đặt")){
					JOptionPane.showMessageDialog(null, "xin lỗi phòng này đang dùng");
					return;
				}
				if (JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa!", "Kiểm tra lại",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					if (id.equals(""))
						JOptionPane.showMessageDialog(null, "Chưa chọn phòng!");
					else {
						adapterMd.XoaId("tb_phong", "ma_phong", id);
						adapterCtr = new ControllerHotel();
						tblPhong.setModel(adapterCtr.timKiemPhong(6));

						lblTongPhong.setText(adapterCtr.demDong("tb_phong", adapterCtr.demPhong));
						lblPhongTrong.setText(adapterCtr.demDong("tb_phong", adapterCtr.demPhongTrong));
						lblPhongDat.setText(adapterCtr.demDong("tb_phong", adapterCtr.demPhongDat));
						lblPhongDon.setText(adapterCtr.demDong("tb_phong", adapterCtr.demPhongDon));
						lblPhongDoi.setText(adapterCtr.demDong("tb_phong", adapterCtr.demPhongDoi));
						lblPhongBa.setText(adapterCtr.demDong("tb_phong", adapterCtr.demPhongBa));
						lblPhongVip.setText(adapterCtr.demDong("tb_phong", adapterCtr.demPhongVip));
					}
				}
			}
		});
		btnXoa.setBounds(135, 96, 91, 23);
		panel_1.add(btnXoa);

		JPanel panel_2 = new JPanel();
		panel_2.setForeground(new Color(0, 0, 51));
		panel_2.setBackground(SystemColor.inactiveCaption);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Danh s\u00E1ch ph\u00F2ng:",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
		panel_2.setBounds(10, 130, 527, 263);
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane);

		tblPhong = new JTable();
		tblPhong.setForeground(new Color(0, 0, 0));
		tblPhong.setBackground(new Color(204, 204, 204));
		tblPhong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				namephong=tblPhong.getValueAt(tblPhong.getSelectedRow(), 4).toString();
				id = tblPhong.getModel().getValueAt(tblPhong.getSelectedRow(), 0).toString();
				txtTen.setText(tblPhong.getModel().getValueAt(tblPhong.getSelectedRow(), 1).toString());
			}
		});
		scrollPane.setViewportView(tblPhong);

		JButton btnThem = new JButton("Th\u00EAm ");
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThem.setForeground(new Color(255, 255, 255));
		btnThem.setBackground(new Color(0, 0, 102));
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String quyen = adapterCtr.cellTb("tinhtrang", adapterCtr.itemLogin(adapterCtr.Id("id_1", "id")));
				if (!quyen.equals("1"))
					JOptionPane.showMessageDialog(null, "Bạn không được sử dụng chức năng này!");
				else if (txtTen.getText().toString().equals("") || chonloaiphong.equals("--selected--")
						|| txtGia.getText().toString().equals("")) {
					JOptionPane.showMessageDialog(null, "Kiểm tra lại!");
				} else {
					adapterMd.ThemPhong(txtTen.getText().toString(), chonloaiphong, txtGia.getText().toString(),
							txtNote.getText().toString());
					adapterCtr = new ControllerHotel();
					// load lên tất cả dữ liêu phòng
					tblPhong.setModel(adapterCtr.timKiemPhong(6));
					// setText lên label thông báo!
					lblTongPhong.setText(adapterCtr.demDong("tb_phong", adapterCtr.demPhong));
					lblPhongTrong.setText(adapterCtr.demDong("tb_phong", adapterCtr.demPhongTrong));
					lblPhongDat.setText(adapterCtr.demDong("tb_phong", adapterCtr.demPhongDat));
					lblPhongDon.setText(adapterCtr.demDong("tb_phong", adapterCtr.demPhongDon));
					lblPhongDoi.setText(adapterCtr.demDong("tb_phong", adapterCtr.demPhongDoi));
					lblPhongBa.setText(adapterCtr.demDong("tb_phong", adapterCtr.demPhongBa));
					lblPhongVip.setText(adapterCtr.demDong("tb_phong", adapterCtr.demPhongVip));
				}
			}
		});
		btnThem.setBounds(21, 96, 91, 23);
		panel_1.add(btnThem);

		txtTen = new JTextField();
		txtTen.setBounds(86, 26, 140, 20);
		panel_1.add(txtTen);
		txtTen.setColumns(10);

		JLabel lblNewLabel = new JLabel("T\u00EAn Ph\u00F2ng");
		lblNewLabel.setBounds(10, 29, 67, 14);
		panel_1.add(lblNewLabel);

		cmbLp = new JComboBox();
		cmbLp.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (cmbLp.getSelectedItem().toString().equals("phòng đơn"))
					chonloaiphong = "1";
				else if (cmbLp.getSelectedItem().toString().equals("phòng đôi"))
					chonloaiphong = "2";
				else if (cmbLp.getSelectedItem().toString().equals("phòng ba"))
					chonloaiphong = "3";
				else if (cmbLp.getSelectedItem().toString().equals("phòng Vip"))
					chonloaiphong = "4";
			}
		});
		cmbLp.setModel(new DefaultComboBoxModel(
				new String[] { "--selected--", "phòng đơn", "phòng đôi", "phòng ba", "phòng Vip" }));
		cmbLp.setBounds(361, 26, 161, 20);
		panel_1.add(cmbLp);

		JLabel lblNewLabel_2 = new JLabel("Lo\u1EA1i ph\u00F2ng");
		lblNewLabel_2.setBounds(252, 29, 99, 14);
		panel_1.add(lblNewLabel_2);

		txtNote = new JTextField();
		txtNote.setBounds(86, 57, 140, 20);
		panel_1.add(txtNote);
		txtNote.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Ch\u00FA th\u00EDch");
		lblNewLabel_4.setBounds(10, 60, 67, 14);
		panel_1.add(lblNewLabel_4);

		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 51));
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "T\u00ECm ki\u1EBFm ph\u00F2ng:",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
		panel.setBounds(340, 88, 182, 47);
		panel_1.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));

		comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				// load tất cả
				if (comboBox.getSelectedIndex() == 0)
					tblPhong.setModel(adapterCtr.timKiemPhong(6));
				// load phong tình trạng =0
				else if (comboBox.getSelectedIndex() == 1)
					tblPhong.setModel(adapterCtr.timKiemPhong(0));
				// load phòng tìnhtrang=1
				else if (comboBox.getSelectedIndex() == 2)
					tblPhong.setModel(adapterCtr.timKiemPhong(1));
				// load phòng loại phòng = phòng đơn
				else if (comboBox.getSelectedIndex() == 3)
					tblPhong.setModel(adapterCtr.timKiemPhong(2));
				// load phòng loại phòng = phòng đôi
				else if (comboBox.getSelectedIndex() == 4)
					tblPhong.setModel(adapterCtr.timKiemPhong(3));
				// load phòng loại phòng = phòng ba
				else if (comboBox.getSelectedIndex() == 5)
					tblPhong.setModel(adapterCtr.timKiemPhong(4));
				// load phòng loai phòng = phòng vip
				else if (comboBox.getSelectedIndex() == 6)
					tblPhong.setModel(adapterCtr.timKiemPhong(5));
			}
		});
		panel.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "---Phòng---", "Phòng trống", "Phòng đã đặt",
				"Phòng đơn", "Phòng đôi", "Phòng ba", "Phòng vip" }));

		txtGia = new JTextField();
		txtGia.setBounds(361, 57, 161, 20);
		panel_1.add(txtGia);
		txtGia.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Giá Phòng*1000đ");
		lblNewLabel_1.setBounds(252, 60, 99, 14);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_3 = new JLabel("H\u1EC6 TH\u1ED0NG PH\u00D2NG\r\n");
		lblNewLabel_3.setForeground(new Color(0, 0, 128));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_3.setBounds(10, 11, 195, 31);
		contentPane.add(lblNewLabel_3);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 204, 204));
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Th\u1ED1ng k\u00EA ph\u00F2ng:",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 51)));
		panel_3.setBounds(10, 52, 147, 393);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel_5 = new JLabel("Tổng phòng:");
		lblNewLabel_5.setForeground(new Color(0, 0, 51));
		lblNewLabel_5.setBounds(6, 18, 82, 52);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_3.add(lblNewLabel_5);

		lblTongPhong = new JLabel("loading...");
		lblTongPhong.setBounds(88, 19, 59, 52);
		panel_3.add(lblTongPhong);

		JLabel lblNewLabel_12 = new JLabel("Phòng trống:\r\n");
		lblNewLabel_12.setForeground(new Color(0, 0, 51));
		lblNewLabel_12.setBounds(6, 71, 82, 52);
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_3.add(lblNewLabel_12);

		lblPhongTrong = new JLabel("loading...");
		lblPhongTrong.setBounds(88, 71, 82, 52);
		panel_3.add(lblPhongTrong);

		JLabel lblNewLabel_17 = new JLabel("Phòng đã đặt:");
		lblNewLabel_17.setForeground(new Color(0, 0, 51));
		lblNewLabel_17.setBounds(6, 123, 82, 52);
		lblNewLabel_17.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_3.add(lblNewLabel_17);

		lblPhongDat = new JLabel("loading...");
		lblPhongDat.setBounds(88, 123, 82, 52);
		panel_3.add(lblPhongDat);

		JLabel lblNewLabel_15 = new JLabel("Phòng đơn:");
		lblNewLabel_15.setForeground(new Color(0, 0, 51));
		lblNewLabel_15.setBounds(6, 175, 82, 52);
		lblNewLabel_15.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_3.add(lblNewLabel_15);

		lblPhongDon = new JLabel("loading...");
		lblPhongDon.setBounds(88, 175, 82, 52);
		panel_3.add(lblPhongDon);

		JLabel lblNewLabel_14 = new JLabel("Phòng đôi:");
		lblNewLabel_14.setForeground(new Color(0, 0, 51));
		lblNewLabel_14.setBounds(6, 227, 82, 52);
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_3.add(lblNewLabel_14);

		lblPhongDoi = new JLabel("loading...");
		lblPhongDoi.setBounds(88, 227, 82, 52);
		panel_3.add(lblPhongDoi);

		JLabel lblNewLabel_10 = new JLabel("Phòng 3:");
		lblNewLabel_10.setForeground(new Color(0, 0, 51));
		lblNewLabel_10.setBounds(6, 279, 82, 52);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_3.add(lblNewLabel_10);

		lblPhongBa = new JLabel("loading...");
		lblPhongBa.setBounds(88, 279, 82, 52);
		panel_3.add(lblPhongBa);

		JLabel lblNewLabel_7 = new JLabel("Phòng Vip:\r\n");
		lblNewLabel_7.setForeground(new Color(0, 0, 51));
		lblNewLabel_7.setBounds(6, 331, 82, 52);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_3.add(lblNewLabel_7);

		lblPhongVip = new JLabel("loading...");
		lblPhongVip.setBounds(88, 331, 82, 52);
		panel_3.add(lblPhongVip);

		JButton btnRf = new JButton("Refresh");
		btnRf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRf.setForeground(new Color(255, 255, 255));
		btnRf.setBackground(new Color(0, 0, 102));
		btnRf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adapterCtr = new ControllerHotel();
				tblPhong.setModel(adapterCtr.timKiemPhong(6));

				lblTongPhong.setText(adapterCtr.demDong("tb_phong", adapterCtr.demPhong));
				lblPhongTrong.setText(adapterCtr.demDong("tb_phong", adapterCtr.demPhongTrong));
				lblPhongDat.setText(adapterCtr.demDong("tb_phong", adapterCtr.demPhongDat));
				lblPhongDon.setText(adapterCtr.demDong("tb_phong", adapterCtr.demPhongDon));
				lblPhongDoi.setText(adapterCtr.demDong("tb_phong", adapterCtr.demPhongDoi));
				lblPhongBa.setText(adapterCtr.demDong("tb_phong", adapterCtr.demPhongBa));
				lblPhongVip.setText(adapterCtr.demDong("tb_phong", adapterCtr.demPhongVip));
			}
		});
		btnRf.setBounds(625, 11, 89, 30);
		contentPane.add(btnRf);
	}
}
