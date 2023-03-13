package quanlykhachsan_v2;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.BevelBorder;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.ImageIcon;

public class viewMain extends JFrame {
	ModelHotel adapterMd;
	ControllerHotel adapterCtr;
	private JPanel contentPane;
	private JTextField txtTenKh;
	private JTextField txtQuoctich;
	private JTextField txtCmnd;
	private JTextField txtTuoi;
	private JTextField txtLienlac;
	private JTable tblPhongtrong;
	private JTable tblKh;
	private JTable tblNvDp;
	private JTable tblDSPD;
	
	private JLabel lblTongPhong;
	private JLabel lblTongPhongDat;
	private JLabel lblTongPhongTrong;
	private JLabel lblTongKhach;
	private JLabel lblTongKhachIn;
	private JLabel lblTongKhachCho;
	private JLabel lblTongNv;
	private JLabel lblNgay;
	private JComboBox comboBox;
	String chonGioitinh="1";
	String chonPhong=new String();
	String chonNhanvien=new String();
	String chonKhachhang="";
	int demHangTbKh;
	private JTabbedPane tabbedPane;
	private JPanel panel_9;
	private JToolBar toolBar;
	private JPanel panel_10;
	private JLabel lblNewLabel_6;
	private JLabel lblPhng;
	private JLabel lblNhnVin;
	private JLabel lblDchV;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewMain frame = new viewMain();
					frame.setExtendedState(JFrame.MAXIMIZED_VERT);
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
	public viewMain() {
		setTitle("ỨNG DỤNG QUẢN LÝ KHÁCH SẠN");
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				adapterMd=new ModelHotel();
				tblKh.setModel(adapterMd.loadKhachhang());
				adapterMd=new ModelHotel();
				tblPhongtrong.setModel(adapterMd.loadPhong("0"));
				adapterMd=new ModelHotel();
				tblNvDp.setModel(adapterMd.loadNhanVien());
				adapterMd=new ModelHotel();
				tblDSPD.setModel(adapterMd.loadDSDatPhong());	
				
				adapterCtr=new ControllerHotel();
			    lblTongPhong.setText(adapterCtr.demDong("tb_phong",adapterCtr.demPhong));
			    lblTongPhongTrong.setText(adapterCtr.demDong("tb_phong",adapterCtr.demPhongTrong));
			    lblTongPhongDat.setText(adapterCtr.demDong("tb_phong",adapterCtr.demPhongDat));
			    lblTongKhach.setText(adapterCtr.demDong("tb_khachhang",adapterCtr.demTongKh));
			    lblTongKhachIn.setText(adapterCtr.demDong("tb_khachhang",adapterCtr.demKhIn));
			    lblTongKhachCho.setText(adapterCtr.demDong("tb_khachhang",adapterCtr.demPhongTrong));
			    lblTongNv.setText(adapterCtr.demDong("tb_nhanvien",adapterCtr.demNv));
			    lblNgay.setText(adapterCtr.ngayHt);
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1378, 878);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setForeground(new Color(173, 216, 230));
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 102, 1372, 649);
		contentPane.add(tabbedPane);
		
		panel_9 = new JPanel();
		panel_9.setBackground(new Color(102, 102, 102));
		tabbedPane.addTab("Đăng Ký", null, panel_9, null);
		panel_9.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 0, 303, 610);
		panel_9.add(panel);
		panel.setBackground(new Color(153, 255, 102));
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Th\u00F4ng tin kh\u00E1ch h\u00E0ng:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
		panel.setLayout(null);
		
		txtTenKh = new JTextField();
		txtTenKh.setBounds(103, 40, 145, 20);
		panel.add(txtTenKh);
		txtTenKh.setColumns(10);
		
		txtCmnd = new JTextField();
		txtCmnd.setBounds(103, 92, 145, 20);
		panel.add(txtCmnd);
		txtCmnd.setColumns(10);
		
		txtQuoctich = new JTextField();
		txtQuoctich.setBounds(103, 196, 145, 20);
		panel.add(txtQuoctich);
		txtQuoctich.setColumns(10);
		
		txtTuoi = new JTextField();
		txtTuoi.setBounds(103, 248, 127, 20);
		panel.add(txtTuoi);
		txtTuoi.setColumns(10);
		
		txtLienlac = new JTextField();
		txtLienlac.setBounds(103, 306, 127, 20);
		panel.add(txtLienlac);
		txtLienlac.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Tên KH");
		lblNewLabel.setBounds(10, 40, 46, 20);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CMND/HC");
		lblNewLabel_1.setBounds(10, 92, 60, 20);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Quốc tịch");
		lblNewLabel_2.setBounds(10, 199, 60, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Tuổi");
		lblNewLabel_4.setBounds(10, 251, 59, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Liên lạc:");
		lblNewLabel_5.setBounds(10, 309, 83, 14);
		panel.add(lblNewLabel_5);
		
	    comboBox = new JComboBox();
	    comboBox.setBounds(103, 145, 145, 20);
	    panel.add(comboBox);
	    comboBox.addItemListener(new ItemListener() {
	    	public void itemStateChanged(ItemEvent e) {
	    		if(comboBox.getSelectedIndex()==0) chonGioitinh="1";
	    		else if(comboBox.getSelectedIndex()==1) chonGioitinh="0";
	    		//chonGioitinh=comboBox.getSelectedItem().toString();
	    	}
	    });
	    comboBox.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ"}));
	    
	    JLabel lblNewLabel_3 = new JLabel("Giới tính");
	    lblNewLabel_3.setBounds(10, 148, 52, 14);
	    panel.add(lblNewLabel_3);
	    
	    JButton btnThemkh = new JButton("Thêm KH");
	    btnThemkh.setBounds(28, 408, 107, 39);
	    panel.add(btnThemkh);
	    btnThemkh.setForeground(new Color(255, 255, 255));
	    btnThemkh.setBackground(new Color(0, 0, 102));
	    
	    JButton btnXoakh = new JButton("Xóa KH");
	    btnXoakh.setBounds(168, 408, 107, 39);
	    panel.add(btnXoakh);
	    btnXoakh.setForeground(new Color(255, 255, 255));
	    btnXoakh.setBackground(new Color(0, 0, 102));
	    
	    JButton btnBochon = new JButton("Bỏ chọn");
	    btnBochon.setBounds(103, 481, 107, 39);
	    panel.add(btnBochon);
	    btnBochon.setForeground(new Color(255, 255, 255));
	    btnBochon.setBackground(new Color(0, 0, 102));
	    btnBochon.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		tblPhongtrong.clearSelection();
	    		tblNvDp.clearSelection();
	    		tblKh.clearSelection();
	    	}
	    });
	    btnXoakh.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		if(chonKhachhang.equals(""))
	    		{
	    			JOptionPane.showMessageDialog(null,"Chưa chọn khách hàng");
	    		}
	    		else
	    		{
	    		adapterMd=new ModelHotel();
	    		adapterMd.XoaId("tb_khachhang","ma_kh",chonKhachhang);
	    		///adapterMd.X
	    		adapterMd=new ModelHotel();
	    		tblKh.setModel(adapterMd.loadKhachhang());
	    		//hiển thị lại tổng khách
	    		lblTongKhach.setText(adapterCtr.demDong("tb_khachhang",adapterCtr.demTongKh));
	    		// hiển thị khách chờ nhận phòng:
	    		lblTongKhachCho.setText(adapterCtr.demDong("tb_khachhang",adapterCtr.demKhCho));
	    		chonKhachhang="";
	    		}
	    	}
	    });
	    btnThemkh.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		//kiểm tra điều kiện, chèn vào bảng khách hàng, sau xóa textb
	    		if(txtTenKh.getText().toString().equals(""))
	    		{
	    			JOptionPane.showMessageDialog(null, "Kiểm tra lại tên");
	    		}
	    		else
	    		{
	    			adapterMd=new ModelHotel();
	    			adapterMd.ThemKhachHang(txtTenKh.getText().toString(),txtCmnd.getText().toString(),txtQuoctich.getText().toString(),chonGioitinh,txtTuoi.getText().toString(),txtLienlac.getText().toString(),"0");
	    		    tblKh.setModel(adapterMd.loadKhachhang());
	    		     
	    		    txtTenKh.setText("");
	    			txtCmnd.setText("");
	    			txtQuoctich.setText("");
	    			txtTuoi.setText("");
	    			txtLienlac.setText("");
	    			
	    			//hiển thị lại tổng khách
	    			lblTongKhach.setText(adapterCtr.demDong("tb_khachhang",adapterCtr.demTongKh));
	    			// hiển thị khách chờ nhận phòng:
	    			lblTongKhachCho.setText(adapterCtr.demDong("tb_khachhang",adapterCtr.demKhCho));
	    		}
	    		
	    	}
	    });
	    
	    JPanel panel_2 = new JPanel();
	    panel_2.setBounds(320, 0, 258, 321);
	    panel_9.add(panel_2);
	    panel_2.setBackground(new Color(204, 204, 204));
	    panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Danh s\u00E1ch kh\u00E1ch h\u00E0ng ch\u1EDD:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
	    panel_2.setLayout(new GridLayout(1, 0, 0, 0));
	    
	    JScrollPane scrollPane_1 = new JScrollPane();
	    scrollPane_1.setBackground(new Color(102, 0, 102));
	    panel_2.add(scrollPane_1);
	    
	    tblKh = new JTable();
	    tblKh.setForeground(new Color(0, 0, 0));
	    tblKh.setBackground(new Color(204, 204, 204));
	    tblKh.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent arg0) {
	    	chonKhachhang=tblKh.getModel().getValueAt(tblKh.getSelectedRow(),0).toString();
	    	}
	    });
	    scrollPane_1.setViewportView(tblKh);
	    
	    JPanel panel_3 = new JPanel();
	    panel_3.setBounds(572, 0, 270, 321);
	    panel_9.add(panel_3);
	    panel_3.setBackground(new Color(204, 204, 204));
	    panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Danh s\u00E1ch ph\u00F2ng tr\u1ED1ng:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
	    panel_3.setLayout(new GridLayout(1, 0, 0, 0));
	    
	    JScrollPane scrollPane_2 = new JScrollPane();
	    scrollPane_2.setBackground(new Color(204, 204, 204));
	    scrollPane_2.setForeground(new Color(0, 0, 0));
	    panel_3.add(scrollPane_2);
	    
	    tblPhongtrong = new JTable();
	    tblPhongtrong.setForeground(new Color(0, 0, 0));
	    tblPhongtrong.setBackground(new Color(204, 204, 204));
	    scrollPane_2.setViewportView(tblPhongtrong);
	    
	    JPanel panel_5 = new JPanel();
	    panel_5.setBounds(835, 0, 264, 321);
	    panel_9.add(panel_5);
	    panel_5.setBackground(new Color(204, 204, 204));
	    panel_5.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Nh\u00E2n vi\u00EAn ti\u1EBFp nh\u1EADn:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
	    panel_5.setLayout(new GridLayout(1, 0, 0, 0));
	    
	    JScrollPane scrollPane_3 = new JScrollPane();
	    scrollPane_3.setBackground(new Color(204, 204, 204));
	    scrollPane_3.setForeground(new Color(255, 255, 255));
	    panel_5.add(scrollPane_3);
	    
	    tblNvDp = new JTable();
	    tblNvDp.setBackground(new Color(204, 204, 204));
	    tblNvDp.setForeground(new Color(0, 0, 0));
	    tblNvDp.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	JOptionPane.showMessageDialog(null,"NV "+tblNvDp.getModel().getValueAt(tblNvDp.getSelectedRow(),1).toString()+" vừa được chọn.");
	    	}
	    });
	    scrollPane_3.setViewportView(tblNvDp);
	    
	    JPanel panel_7 = new JPanel();
	    panel_7.setBounds(320, 321, 779, 289);
	    panel_9.add(panel_7);
	    panel_7.setBackground(new Color(204, 204, 204));
	    panel_7.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Danh s\u00E1ch ph\u00F2ng \u0111\u00E3 \u0111\u1EB7t:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
	    panel_7.setLayout(new GridLayout(1, 0, 0, 0));
	    
	    JScrollPane scrollPane = new JScrollPane();
	    scrollPane.setBackground(new Color(102, 0, 102));
	    scrollPane.setForeground(new Color(255, 255, 255));
	    panel_7.add(scrollPane);
	    
	    tblDSPD = new JTable();
	    tblDSPD.setForeground(new Color(0, 0, 0));
	    tblDSPD.setBackground(new Color(204, 204, 204));
	    scrollPane.setViewportView(tblDSPD);
	    
	    JPanel panel_4 = new JPanel();
	    panel_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
	    panel_4.setBounds(1109, 105, 248, 353);
	    panel_9.add(panel_4);
	    panel_4.setBackground(new Color(255, 204, 204));
	    panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Th\u1ED1ng k\u00EA th\u00F4ng tin kh\u00E1ch s\u1EA1n:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
	    panel_4.setLayout(null);
	    
	    JLabel lblNewLabel_8 = new JLabel("Tổng số phòng:");
	    lblNewLabel_8.setForeground(new Color(0, 0, 51));
	    lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    lblNewLabel_8.setBounds(6, 23, 108, 28);
	    panel_4.add(lblNewLabel_8);
	    
	    lblTongPhong = new JLabel("loading...");
	    lblTongPhong.setBounds(149, 22, 121, 31);
	    lblTongPhong.setFont(new Font("Tahoma", Font.BOLD, 15));
	    panel_4.add(lblTongPhong);
	    
	    JLabel lblNewLabel_10 = new JLabel("Số phòng đã đặt:");
	    lblNewLabel_10.setForeground(new Color(0, 0, 51));
	    lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    lblNewLabel_10.setBounds(6, 62, 108, 28);
	    panel_4.add(lblNewLabel_10);
	    
	    lblTongPhongDat = new JLabel("loading...");
	    lblTongPhongDat.setBounds(149, 58, 121, 37);
	    lblTongPhongDat.setFont(new Font("Tahoma", Font.BOLD, 15));
	    panel_4.add(lblTongPhongDat);
	    
	    JLabel lblNewLabel_11 = new JLabel("Số phòng trống:");
	    lblNewLabel_11.setForeground(new Color(0, 0, 51));
	    lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    lblNewLabel_11.setBounds(6, 101, 108, 28);
	    panel_4.add(lblNewLabel_11);
	    
	    lblTongPhongTrong = new JLabel("loading...");
	    lblTongPhongTrong.setBounds(149, 97, 102, 37);
	    lblTongPhongTrong.setFont(new Font("Tahoma", Font.BOLD, 15));
	    panel_4.add(lblTongPhongTrong);
	    
	    JLabel lblNewLabel_13 = new JLabel("Tổng số khách hàng:");
	    lblNewLabel_13.setForeground(new Color(0, 0, 51));
	    lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    lblNewLabel_13.setBounds(6, 140, 133, 28);
	    panel_4.add(lblNewLabel_13);
	    
	    lblTongKhach = new JLabel("loading...");
	    lblTongKhach.setBounds(149, 138, 121, 32);
	    lblTongKhach.setFont(new Font("Tahoma", Font.BOLD, 15));
	    panel_4.add(lblTongKhach);
	    
	    JLabel lblNewLabel_18 = new JLabel("KH đã qua:");
	    lblNewLabel_18.setForeground(new Color(0, 0, 51));
	    lblNewLabel_18.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    lblNewLabel_18.setBounds(6, 179, 127, 28);
	    panel_4.add(lblNewLabel_18);
	    
	    lblTongKhachIn = new JLabel("loading...");
	    lblTongKhachIn.setBounds(149, 179, 121, 28);
	    lblTongKhachIn.setFont(new Font("Tahoma", Font.BOLD, 15));
	    panel_4.add(lblTongKhachIn);
	    
	    JLabel lblNewLabel_19 = new JLabel("KH đang chờ:");
	    lblNewLabel_19.setForeground(new Color(0, 0, 51));
	    lblNewLabel_19.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    lblNewLabel_19.setBounds(6, 218, 114, 28);
	    panel_4.add(lblNewLabel_19);
	    
	    lblTongKhachCho = new JLabel("loading...");
	    lblTongKhachCho.setBounds(149, 222, 95, 21);
	    lblTongKhachCho.setFont(new Font("Tahoma", Font.BOLD, 15));
	    panel_4.add(lblTongKhachCho);
	    
	    JLabel lblNewLabel_22 = new JLabel("Tổng số nhân viên:");
	    lblNewLabel_22.setForeground(new Color(0, 0, 51));
	    lblNewLabel_22.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    lblNewLabel_22.setBounds(6, 257, 121, 28);
	    panel_4.add(lblNewLabel_22);
	    
	    lblTongNv = new JLabel("loading...");
	    lblTongNv.setBounds(149, 261, 102, 21);
	    lblTongNv.setFont(new Font("Tahoma", Font.BOLD, 15));
	    panel_4.add(lblTongNv);
	    
	    JLabel lblNewLabel_20 = new JLabel("Ngày:");
	    lblNewLabel_20.setForeground(new Color(0, 0, 51));
	    lblNewLabel_20.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    lblNewLabel_20.setBounds(6, 296, 121, 24);
	    panel_4.add(lblNewLabel_20);
	    
	    lblNgay = new JLabel("........");
	    lblNgay.setBounds(149, 301, 121, 14);
	    lblNgay.setBackground(new Color(51, 0, 204));
	    lblNgay.setFont(new Font("Tahoma", Font.BOLD, 16));
	    panel_4.add(lblNgay);
	    
	    JButton btnLammoi = new JButton("Refresh");
	    btnLammoi.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    btnLammoi.setBounds(1154, 27, 165, 45);
	    panel_9.add(btnLammoi);
	    btnLammoi.setForeground(new Color(255, 255, 255));
	    btnLammoi.setBackground(new Color(0, 0, 102));
	    
	    JPanel panel_6 = new JPanel();
	    panel_6.setBackground(new Color(102, 102, 102));
	    panel_6.setBounds(1154, 471, 165, 119);
	    panel_9.add(panel_6);
	    panel_6.setLayout(null);
	    
	    JButton button = new JButton("<< HOÀN TÁC");
	    button.setForeground(new Color(255, 255, 255));
	    button.setBackground(new Color(0, 0, 102));
	    button.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		// lấy lại những khách hàng vừa đặt phòng
	    		adapterMd.hoantacKh(demHangTbKh);
	    		// xóa phòng,khách vừa thêm trong bảng khách nhận phòng dựa vào id lớn nhất của tb_hdtp
	    		adapterMd.hoantacKNP();
	    		// sửa lại phòng vừa đặt có tinhtrang=1 to tinhtrang=0 dựa vào id lớn nhất của tb_hdtp
	    		adapterMd.hoantacPhong();
	    		// xóa hợp đồng vừa thêm trong bảng tb_hdtp
	    		adapterMd.hoantacHd();
	    		
	    		// load lại khách hàng lên bảng khách hàng
	    		adapterMd=new ModelHotel();
	    		tblKh.setModel(adapterMd.loadKhachhang());
	    		// load lại phòng trống lên bảng phòng
	    		adapterMd=new ModelHotel();
	    		tblPhongtrong.setModel(adapterMd.loadPhong("0"));
	    		// load lại DSPD lên bảng DSPD
	    		adapterMd=new ModelHotel();
	    		tblDSPD.setModel(adapterMd.loadDSDatPhong());
	    		
	    		//hiển thị lại các phòng
	    		lblTongPhong.setText(adapterCtr.demDong("tb_phong",adapterCtr.demPhong));
	    	    lblTongPhongTrong.setText(adapterCtr.demDong("tb_phong",adapterCtr.demPhongTrong));
	    	    lblTongPhongDat.setText(adapterCtr.demDong("tb_phong",adapterCtr.demPhongDat));
	    		//hiển thị lại tổng khách
	    		lblTongKhach.setText(adapterCtr.demDong("tb_khachhang",adapterCtr.demTongKh));
	    		// hiển thị khách chờ nhận phòng:
	    		lblTongKhachCho.setText(adapterCtr.demDong("tb_khachhang",adapterCtr.demKhCho));
	    		// hiển thị lại khách đã đặt phòng
	    		lblTongKhachIn.setText(adapterCtr.demDong("tb_khachhang",adapterCtr.demKhIn));
	    	}
	    });
	    button.setFont(new Font("Tahoma", Font.BOLD, 12));
	    button.setBounds(10, 68, 145, 28);
	    panel_6.add(button);
	    
	    JButton button_1 = new JButton("ĐẶT PHÒNG >>");
	    button_1.setForeground(new Color(255, 255, 255));
	    button_1.setBackground(new Color(0, 0, 102));
	    button_1.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	    
	    	
	    if (JOptionPane.showConfirmDialog(null, "Bạn có muốn đặt phòng này!","Kiểm tra lại",
	    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)		
	    {
        try
    	{
    	if(tblKh.getRowCount()==0)
    	{
    		JOptionPane.showMessageDialog(null, "Chưa thêm khách hàng!");
    	}
    	else
    	{
        //đếm số dòng trong bảng khách hàng để trả lại số khách hàng nếu muốn hoàn tác
    		demHangTbKh=tblKh.getRowCount();
    	//lấy ra phòng chọn và nhân viên chọn chèn vào bảng khachnhanphong
    	chonPhong=tblPhongtrong.getModel().getValueAt(tblPhongtrong.getSelectedRow(),0).toString();
    	chonNhanvien=tblNvDp.getModel().getValueAt(tblNvDp.getSelectedRow(),0).toString();
    	adapterMd=new ModelHotel();
    	adapterMd.ThemKhachNhanPhong(chonPhong,"0");
    	//Insert ma_phong,ma_nv,ngay,gio đăt phog vào bảng hop dong thue phong
    	adapterMd.ThemHopDong(chonPhong,chonNhanvien);
    	// update khách hàng cột tinhtrang='0' thành tinhtrang='1' sau khi đặt phòng
    	adapterMd.updateKhachHang();
    	//update phòng được chọn tinhtrang=0 thành tinhtrang=1
    	adapterMd.updatePhong("1",chonPhong);
    	// Load lại ds khách hàng sau khi khách đã nhận phòng
    	adapterMd=new ModelHotel();
    	tblKh.setModel(adapterMd.loadKhachhang());
    	// load lại danh sách phòng trống sau khi đặt phòng
    	adapterMd=new ModelHotel();
    	tblPhongtrong.setModel(adapterMd.loadPhong("0"));
    	//load lại danh sách phòng đã đặt sau khi đặt phòng
    	adapterMd=new ModelHotel();
    	tblDSPD.setModel(adapterMd.loadDSDatPhong());	
    	
    	//hiển thị lại các phòng
    	lblTongPhong.setText(adapterCtr.demDong("tb_phong",adapterCtr.demPhong));
        lblTongPhongTrong.setText(adapterCtr.demDong("tb_phong",adapterCtr.demPhongTrong));
        lblTongPhongDat.setText(adapterCtr.demDong("tb_phong",adapterCtr.demPhongDat));
    	//hiển thị lại tổng khách
    	lblTongKhach.setText(adapterCtr.demDong("tb_khachhang",adapterCtr.demTongKh));
    	// hiển thị khách chờ nhận phòng:
    	lblTongKhachCho.setText(adapterCtr.demDong("tb_khachhang",adapterCtr.demKhCho));
    	// hiển thị lại khách đã đặt phòng
    	lblTongKhachIn.setText(adapterCtr.demDong("tb_khachhang",adapterCtr.demKhIn));
    	
    	chonPhong=new String();
    	}
    	}
    		catch(Exception ex)
    			{
    			JOptionPane.showMessageDialog(null,"Phải chọn Phòng và Nhân viên, kiểm tra lại!");
    		    }
                	
                }
                }
	    });
	    button_1.setFont(new Font("Tahoma", Font.BOLD, 12));
	    button_1.setBounds(10, 11, 145, 28);
	    panel_6.add(button_1);
	    btnLammoi.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		adapterMd=new ModelHotel();
	    		tblKh.setModel(adapterMd.loadKhachhang());
	    		adapterMd=new ModelHotel();
	    		tblPhongtrong.setModel(adapterMd.loadPhong("0"));
	    		adapterMd=new ModelHotel();
	    		tblNvDp.setModel(adapterMd.loadNhanVien());
	    		adapterMd=new ModelHotel();
	    		tblDSPD.setModel(adapterMd.loadDSDatPhong());	
	    		
	    		adapterCtr=new ControllerHotel();
	    	    lblTongPhong.setText(adapterCtr.demDong("tb_phong",adapterCtr.demPhong));
	    	    lblTongPhongTrong.setText(adapterCtr.demDong("tb_phong",adapterCtr.demPhongTrong));
	    	    lblTongPhongDat.setText(adapterCtr.demDong("tb_phong",adapterCtr.demPhongDat));
	    	    lblTongKhach.setText(adapterCtr.demDong("tb_khachhang",adapterCtr.demTongKh));
	    	    lblTongKhachIn.setText(adapterCtr.demDong("tb_khachhang",adapterCtr.demKhIn));
	    	    lblTongKhachCho.setText(adapterCtr.demDong("tb_khachhang",adapterCtr.demPhongTrong));
	    	    lblTongNv.setText(adapterCtr.demDong("tb_nhanvien",adapterCtr.demNv));
	    	    lblNgay.setText(adapterCtr.ngayHt);
	    	}
	    });
		
		toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 1372, 103);
		contentPane.add(toolBar);
		
		panel_10 = new JPanel();
		panel_10.setBackground(new Color(51, 204, 204));
		toolBar.add(panel_10);
		panel_10.setLayout(null);
		
		JButton btnNewButton_6 = new JButton("");
		btnNewButton_6.setIcon(new ImageIcon("Image/family.png"));
		btnNewButton_6.setBounds(10, 13, 72, 41);
		panel_10.add(btnNewButton_6);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		viewKhachHang kh=new viewKhachHang();
		kh.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		kh.setVisible(true);
		kh.setLocationRelativeTo(null);
			}
		});
		btnNewButton_6.setForeground(new Color(255, 255, 255));
		btnNewButton_6.setBackground(new Color(255, 153, 153));
		
		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.setIcon(new ImageIcon("Image/hotel.png"));
		btnNewButton_5.setBounds(102, 13, 72, 41);
		panel_10.add(btnNewButton_5);
		btnNewButton_5.setForeground(new Color(255, 255, 255));
		btnNewButton_5.setBackground(new Color(255, 153, 153));
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setIcon(new ImageIcon("Image/nhanvien.png"));
		btnNewButton_3.setBounds(205, 13, 72, 41);
		panel_10.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewNhanVien nv=new viewNhanVien();
				nv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				nv.setVisible(true);
				nv.setLocationRelativeTo(null);
			}
		});
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setBackground(new Color(255, 153, 153));
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.setIcon(new ImageIcon("Image/dichvu.png"));
		btnNewButton_4.setBounds(306, 13, 72, 41);
		panel_10.add(btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewDichVu dv=new viewDichVu();
				dv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				dv.setVisible(true);
				dv.setLocationRelativeTo(null);
			}
		});
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		btnNewButton_4.setBackground(new Color(255, 153, 153));
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon("Image/travel.png"));
		btnNewButton_2.setBounds(398, 13, 78, 41);
		panel_10.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewBienlai bl=new viewBienlai();
				bl.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				bl.setVisible(true);
				bl.setLocationRelativeTo(null);
			}
		});
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(255, 153, 153));
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon("Image/system.png"));
		btnNewButton_1.setBounds(1112, 13, 95, 43);
		panel_10.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewHeThong ht=new viewHeThong();
				ht.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				ht.setVisible(true);
				ht.setLocationRelativeTo(null);
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 0, 102));
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("Image/exit.png"));
		btnNewButton.setBounds(1244, 13, 89, 45);
		panel_10.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	 if (JOptionPane.showConfirmDialog(null, "Bạn có muốn đăng xuất!",null, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
	 {
		viewLogin lg=new viewLogin();
	//	lg.setWatatapsSample();
		lg.setVisible(true);
    	lg.setLocationRelativeTo(null);
    	dispose();
	 }	
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 102));
		
		lblNewLabel_6 = new JLabel("Khách Hàng");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(0, 65, 82, 14);
		panel_10.add(lblNewLabel_6);
		
		lblPhng = new JLabel("Phòng");
		lblPhng.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhng.setBounds(112, 65, 62, 14);
		panel_10.add(lblPhng);
		
		lblNhnVin = new JLabel("Nhân Viên");
		lblNhnVin.setHorizontalAlignment(SwingConstants.CENTER);
		lblNhnVin.setBounds(205, 65, 62, 14);
		panel_10.add(lblNhnVin);
		
		lblDchV = new JLabel("Dịch Vụ");
		lblDchV.setHorizontalAlignment(SwingConstants.CENTER);
		lblDchV.setBounds(306, 65, 62, 14);
		panel_10.add(lblDchV);
		
		JLabel lblTrPhng = new JLabel("Trả Phòng");
		lblTrPhng.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrPhng.setBounds(408, 65, 62, 14);
		panel_10.add(lblTrPhng);
		
		JLabel lbliMtKhu = new JLabel("Tài Khoản");
		lbliMtKhu.setHorizontalAlignment(SwingConstants.CENTER);
		lbliMtKhu.setBounds(1122, 67, 85, 14);
		panel_10.add(lbliMtKhu);
		
		JLabel lblngXut = new JLabel("Đăng Xuất");
		lblngXut.setHorizontalAlignment(SwingConstants.CENTER);
		lblngXut.setBounds(1254, 69, 62, 14);
		panel_10.add(lblngXut);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				viewPhong ph=new viewPhong();
				ph.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				ph.setVisible(true);
				ph.setLocationRelativeTo(null);
			}
		});
	}
}
