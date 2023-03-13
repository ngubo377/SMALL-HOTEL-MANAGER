package quanlykhachsan_v2;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class viewKhachHang extends JFrame {
    ModelHotel adapterMd=new ModelHotel();
    ControllerHotel adapterCtr=new ControllerHotel();
	private JPanel contentPane;
	private JTextField txtTen;
	private JTextField txtCmnd;
	private JTextField txtQuoctich;
	private JTextField txtTuoi;
	private JTextField txtLienlac;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel txtlienlac;
	private JTable tblKh;
	private JTable tblPd;
	private JComboBox cmbGioitinh;
	private String chonGioitinh="1";
	private String chonPhong="";
	private String idKh="";
	private JLabel lblNewLabel_5;
	private JComboBox cmbQuoctich;
	private JPanel panel_3;
	private JPanel panel_4;
	private JTable tblTimKh;
	private JScrollPane scrollPane_2;
	private JComboBox cmbPhong;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblKhNam;
	private JLabel lblTongKh;
	private JLabel lblKhNu;
	private JLabel lblNewLabel_10;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewKhachHang frame = new viewKhachHang();
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
	public viewKhachHang() {
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				// JOptionPane.showMessageDialog(null,tenphong.get(0));
				adapterMd=new ModelHotel();
			    tblKh.setModel(adapterMd.loadAllKh());
			    adapterMd=new ModelHotel();
			    tblPd.setModel(adapterMd.loadPhong("1"));
			    
			    adapterMd=new ModelHotel();
			   cmbQuoctich.setModel(adapterMd.loadQuoctich());
			    adapterMd=new ModelHotel();
			   cmbPhong.setModel(adapterMd.loadPhongList());
			   
			   lblTongKh.setText(adapterCtr.demDong("tb_khachhang",adapterCtr.demTongKh));
			   lblKhNam.setText(adapterCtr.demDong("tb_khachhang",adapterCtr.demNamKh));
			   lblKhNu.setText(adapterCtr.demDong("tb_khachhang",adapterCtr.demNuKh));
			  
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 816, 552);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 153, 153));
		contentPane.setForeground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 204, 204));
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Danh s\u00E1ch kh\u00E1ch h\u00E0ng:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
		panel.setBounds(249, 54, 551, 253);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		tblKh = new JTable();
		tblKh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				idKh=tblKh.getModel().getValueAt(tblKh.getSelectedRow(),0).toString();
				txtTen.setText(tblKh.getModel().getValueAt(tblKh.getSelectedRow(),1).toString());
				txtCmnd.setText(tblKh.getModel().getValueAt(tblKh.getSelectedRow(),2).toString());
				txtQuoctich.setText(tblKh.getModel().getValueAt(tblKh.getSelectedRow(),3).toString());
				if(tblKh.getModel().getValueAt(tblKh.getSelectedRow(),4).toString().equals("1")) chonGioitinh="1";
				else chonGioitinh="0";
				txtTuoi.setText(tblKh.getModel().getValueAt(tblKh.getSelectedRow(),5).toString());
				txtLienlac.setText(tblKh.getModel().getValueAt(tblKh.getSelectedRow(),6).toString());
			}
		});
		scrollPane.setViewportView(tblKh);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(0, 0, 51));
		panel_1.setBackground(new Color(153, 204, 204));
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Th\u00F4ng tin kh\u00E1ch h\u00E0ng:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
		panel_1.setBounds(10, 54, 235, 462);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txtTen = new JTextField();
		txtTen.setBounds(105, 24, 120, 20);
		panel_1.add(txtTen);
		txtTen.setColumns(10);
		
		txtCmnd = new JTextField();
		txtCmnd.setBounds(105, 55, 120, 20);
		panel_1.add(txtCmnd);
		txtCmnd.setColumns(10);
		
		txtQuoctich = new JTextField();
		txtQuoctich.setBounds(105, 86, 120, 20);
		panel_1.add(txtQuoctich);
		txtQuoctich.setColumns(10);
		
		txtTuoi = new JTextField();
		txtTuoi.setBounds(105, 148, 120, 20);
		panel_1.add(txtTuoi);
		txtTuoi.setColumns(10);
		
		txtLienlac = new JTextField();
		txtLienlac.setBounds(105, 179, 120, 20);
		panel_1.add(txtLienlac);
		txtLienlac.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setForeground(new Color(0, 0, 51));
		panel_2.setBackground(SystemColor.inactiveCaption);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Danh s\u00E1ch ph\u00F2ng \u0111\u1EB7t:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
		panel_2.setBounds(10, 245, 209, 178);
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_2.add(scrollPane_1);
		
		tblPd = new JTable();
		tblPd.setForeground(new Color(0, 0, 0));
		tblPd.setBackground(new Color(204, 204, 204));
		tblPd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
		chonPhong=tblPd.getModel().getValueAt(tblPd.getSelectedRow(),0).toString();
		txtCmnd.setText(chonPhong);
			}
		});
		scrollPane_1.setViewportView(tblPd);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setForeground(new Color(255, 255, 255));
		btnSua.setBackground(new Color(0, 0, 102));
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			adapterMd.updateAllKh(idKh,txtTen.getText(),txtCmnd.getText(),txtQuoctich.getText(),chonGioitinh,txtTuoi.getText(),txtLienlac.getText());
			adapterMd=new ModelHotel();
			tblKh.setModel(adapterMd.loadAllKh());
			}
		});
		btnSua.setBounds(10, 210, 98, 23);
		panel_1.add(btnSua);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setForeground(new Color(255, 255, 255));
		btnXoa.setBackground(new Color(0, 0, 102));
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
if(JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa!","Kiểm tra lại",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) 
		        {
			if(idKh.equals("")) JOptionPane.showMessageDialog(null, "Chưa chọn KH!");
			else 
			{
			adapterMd.XoaId("tb_khachhang","ma_kh",idKh);
			adapterMd=new ModelHotel();
			
			tblKh.setModel(adapterMd.loadAllKh());
			
			lblTongKh.setText(adapterCtr.demDong("tb_khachhang",adapterCtr.demTongKh));
			lblKhNam.setText(adapterCtr.demDong("tb_khachhang",adapterCtr.demNamKh));
			lblKhNu.setText(adapterCtr.demDong("tb_khachhang",adapterCtr.demNuKh));
			}
			}
		}
		});
		btnXoa.setBounds(121, 210, 98, 23);
		panel_1.add(btnXoa);
		
		lblNewLabel = new JLabel("Tên KH:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 27, 85, 20);
		panel_1.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("CMND KH\r\n:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 58, 85, 14);
		panel_1.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Quốc Tịch KH:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(10, 89, 85, 14);
		panel_1.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Giới Tính KH:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(10, 120, 85, 14);
		panel_1.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Tuổi KH:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(10, 151, 85, 14);
		panel_1.add(lblNewLabel_4);
		
		txtlienlac = new JLabel("Liên Lạc KH:");
		txtlienlac.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtlienlac.setBounds(10, 182, 85, 14);
		panel_1.add(txtlienlac);
		
		JButton btnThemKh = new JButton("Thêm Kh vào Phòng");
		btnThemKh.setForeground(new Color(255, 255, 255));
		btnThemKh.setBackground(new Color(0, 0, 102));
		btnThemKh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(chonPhong.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Chưa chọn phòng!");
			}
			else
			{
			txtCmnd.setText(chonPhong);
				
			adapterMd.ThemKhachHang(txtTen.getText(),txtCmnd.getText(),txtQuoctich.getText(),chonGioitinh,txtTuoi.getText(),txtLienlac.getText(),"0");
			adapterMd.ThemKhachNhanPhong(chonPhong,"0");
			adapterMd.updateKhachHang();
			
			cmbQuoctich.setModel(adapterMd.loadQuoctich());
			cmbPhong.setModel(adapterMd.loadPhongList());
	
			adapterMd=new ModelHotel();
			tblKh.setModel(adapterMd.loadAllKh());	
			
			   lblTongKh.setText(adapterCtr.demDong("tb_khachhang",adapterCtr.demTongKh));
			   lblKhNam.setText(adapterCtr.demDong("tb_khachhang",adapterCtr.demNamKh));
			   lblKhNu.setText(adapterCtr.demDong("tb_khachhang",adapterCtr.demNuKh));
			}
			}
		});
		btnThemKh.setBounds(37, 428, 155, 23);
		panel_1.add(btnThemKh);
		
		cmbGioitinh = new JComboBox();
		cmbGioitinh.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
		if(cmbGioitinh.getSelectedIndex()==0) chonGioitinh="1";
		else if(cmbGioitinh.getSelectedIndex()==1) chonGioitinh="0";
			}
		});
		cmbGioitinh.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ"}));
		cmbGioitinh.setBounds(105, 117, 120, 20);
		panel_1.add(cmbGioitinh);
		
		lblNewLabel_5 = new JLabel("Tìm khách theo quốc tịch:");
		lblNewLabel_5.setForeground(new Color(0, 0, 102));
		lblNewLabel_5.setBounds(301, 318, 148, 14);
		contentPane.add(lblNewLabel_5);
		
		cmbQuoctich = new JComboBox();
		cmbQuoctich.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
			    adapterMd=new ModelHotel();
				tblTimKh.setModel(adapterMd.loadQuoctichKh(cmbQuoctich.getSelectedItem().toString()));
			}
		});
		cmbQuoctich.setBounds(450, 318, 158, 20);
		contentPane.add(cmbQuoctich);
		
		panel_3 = new JPanel();
		panel_3.setBounds(249, 343, 359, 173);
		contentPane.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 0, 0, 0));
		
		scrollPane_2 = new JScrollPane();
		panel_3.add(scrollPane_2);
		
		tblTimKh = new JTable();
		scrollPane_2.setViewportView(tblTimKh);
		
		panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Th\u1ED1ng k\u00EA:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(618, 318, 182, 196);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		lblNewLabel_7 = new JLabel("TSKH:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(6, 26, 70, 36);
		panel_4.add(lblNewLabel_7);
		
		lblTongKh = new JLabel("loading...");
		lblTongKh.setBounds(86, 21, 80, 47);
		lblTongKh.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_4.add(lblTongKh);
		
		lblNewLabel_9 = new JLabel("TSKH Nam:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_9.setBounds(6, 84, 70, 36);
		panel_4.add(lblNewLabel_9);
		
		lblKhNam = new JLabel("loading...");
		lblKhNam.setBounds(86, 74, 80, 57);
		lblKhNam.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_4.add(lblKhNam);
		
		lblNewLabel_8 = new JLabel("TSKH Nữ:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_8.setBounds(6, 143, 70, 36);
		panel_4.add(lblNewLabel_8);
		
		lblKhNu = new JLabel("loading...");
		lblKhNu.setBounds(86, 131, 80, 57);
		lblKhNu.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_4.add(lblKhNu);
		
		cmbPhong = new JComboBox();
		cmbPhong.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
		adapterMd=new ModelHotel();
		if(cmbPhong.getSelectedIndex()==0) tblKh.setModel(adapterMd.loadAllKh());
		else tblKh.setModel(adapterMd.loadTimPhong(cmbPhong.getSelectedItem().toString()));
			}
		});
		cmbPhong.setBounds(382, 26, 148, 20);
		contentPane.add(cmbPhong);
		
		lblNewLabel_6 = new JLabel("Tìm khách theo phòng:");
		lblNewLabel_6.setForeground(new Color(0, 0, 102));
		lblNewLabel_6.setBounds(249, 32, 136, 14);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_10 = new JLabel("THỐNG KÊ KHÁCH HÀNG");
		lblNewLabel_10.setForeground(new Color(0, 0, 128));
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_10.setBounds(10, 11, 294, 35);
		contentPane.add(lblNewLabel_10);
		
		JButton btnRf = new JButton("refresh");
		btnRf.setForeground(new Color(255, 255, 255));
		btnRf.setBackground(new Color(0, 0, 102));
		btnRf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				adapterMd=new ModelHotel();
			    tblKh.setModel(adapterMd.loadAllKh());
			    adapterMd=new ModelHotel();
			    tblPd.setModel(adapterMd.loadPhong("1"));
			    
			    adapterMd=new ModelHotel();
			   cmbQuoctich.setModel(adapterMd.loadQuoctich());
			    adapterMd=new ModelHotel();
			   cmbPhong.setModel(adapterMd.loadPhongList());
			   
			   lblTongKh.setText(adapterCtr.demDong("tb_khachhang",adapterCtr.demTongKh));
			   lblKhNam.setText(adapterCtr.demDong("tb_khachhang",adapterCtr.demNamKh));
			   lblKhNu.setText(adapterCtr.demDong("tb_khachhang",adapterCtr.demNuKh));
			}
		});
		btnRf.setBounds(702, 25, 89, 23);
		contentPane.add(btnRf);
	}
}
