package quanlykhachsan_v2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.SystemColor;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Font;
import javax.swing.UIManager;

public class viewNhanVien extends JFrame {
    ModelHotel adapterMd=new ModelHotel();
    ControllerHotel adapterCtr=new ControllerHotel();
	private JPanel contentPane;
	private JTextField txtTenNv;
	private JTextField txtChucvu;
	private JTextField txtLuong;
	private JTextField txtNamsinh;
	private JLabel lblTongNv;
	private JLabel lblTogNam;
	private JLabel lblTogNu;
	private JTable tblNv;
	private JTextField txtChuthich;
	private JComboBox comboBox;
	String IdNv="";
	String chonGioitinh=new String();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewNhanVien frame = new viewNhanVien();
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
	public viewNhanVien() {
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				adapterMd=new ModelHotel();
				tblNv.setModel(adapterMd.loadAllNv());
				
			    lblTongNv.setText(adapterCtr.demDong("tb_nhanvien",adapterCtr.demNv));
			    lblTogNam.setText(adapterCtr.demDong("tb_nhanvien",adapterCtr.demNvNam));
			    lblTogNu.setText(adapterCtr.demDong("tb_nhanvien",adapterCtr.demNvNu));
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 836, 460);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 51, 102));
		contentPane.setForeground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 51));
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Danh s\u00E1ch Nv:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
		panel.setBounds(240, 68, 569, 350);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		tblNv = new JTable();
		tblNv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			IdNv=tblNv.getModel().getValueAt(tblNv.getSelectedRow(),0).toString();
			txtTenNv.setText(tblNv.getModel().getValueAt(tblNv.getSelectedRow(),1).toString());
			txtChucvu.setText(tblNv.getModel().getValueAt(tblNv.getSelectedRow(),2).toString());
			txtLuong.setText(tblNv.getModel().getValueAt(tblNv.getSelectedRow(),3).toString());
			txtNamsinh.setText(tblNv.getModel().getValueAt(tblNv.getSelectedRow(),4).toString());
			txtChuthich.setText(tblNv.getModel().getValueAt(tblNv.getSelectedRow(),6).toString());
			}
		});
		scrollPane.setViewportView(tblNv);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(0, 0, 51));
		panel_1.setBackground(new Color(255, 204, 204));
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Th\u1ED1ng k\u00EA NV:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
		panel_1.setBounds(10, 284, 220, 134);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("T\u1ED5ng Nv:");
		lblNewLabel_7.setBounds(41, 18, 74, 39);
		panel_1.add(lblNewLabel_7);
		
		lblTongNv = new JLabel("loading...");
		lblTongNv.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTongNv.setBounds(136, 16, 74, 39);
		panel_1.add(lblTongNv);
		
		JLabel lblNewLabel_10 = new JLabel("T\u1ED5ng nam:");
		lblNewLabel_10.setBounds(41, 57, 74, 39);
		panel_1.add(lblNewLabel_10);
		
		lblTogNam = new JLabel("loading...");
		lblTogNam.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTogNam.setBounds(136, 55, 74, 39);
		panel_1.add(lblTogNam);
		
		JLabel lblNewLabel_6 = new JLabel("T\u1ED5ng n\u1EEF:");
		lblNewLabel_6.setBounds(41, 96, 74, 39);
		panel_1.add(lblNewLabel_6);
		
		lblTogNu = new JLabel("loading...");
		lblTogNu.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTogNu.setBounds(136, 94, 74, 39);
		panel_1.add(lblTogNu);
		
		JPanel panel_2 = new JPanel();
		panel_2.setForeground(new Color(0, 0, 51));
		panel_2.setBackground(new Color(255, 204, 204));
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Th\u00F4ng tin nh\u00E2n vi\u00EAn:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
		panel_2.setBounds(10, 11, 220, 262);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("T\u00EAn NV");
		lblNewLabel.setBounds(10, 36, 65, 14);
		panel_2.add(lblNewLabel);
		
		txtTenNv = new JTextField();
		txtTenNv.setBounds(85, 33, 124, 20);
		panel_2.add(txtTenNv);
		txtTenNv.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Ch\u1EE9c v\u1EE5");
		lblNewLabel_1.setBounds(10, 67, 65, 14);
		panel_2.add(lblNewLabel_1);
		
		txtChucvu = new JTextField();
		txtChucvu.setBounds(85, 64, 124, 20);
		panel_2.add(txtChucvu);
		txtChucvu.setColumns(10);
		
		txtLuong = new JTextField();
		txtLuong.setBounds(85, 95, 124, 20);
		panel_2.add(txtLuong);
		txtLuong.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("L\u01B0\u01A1ng");
		lblNewLabel_2.setBounds(10, 98, 65, 14);
		panel_2.add(lblNewLabel_2);
		
		txtNamsinh = new JTextField();
		txtNamsinh.setBounds(85, 126, 124, 20);
		panel_2.add(txtNamsinh);
		txtNamsinh.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("N\u0103m sinh");
		lblNewLabel_3.setBounds(10, 129, 65, 14);
		panel_2.add(lblNewLabel_3);
		
		comboBox = new JComboBox();
		comboBox.setBounds(85, 157, 124, 20);
		panel_2.add(comboBox);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(comboBox.getSelectedIndex()==0) chonGioitinh="chưa rõ";
				else if(comboBox.getSelectedIndex()==1) chonGioitinh="1";
				else if(comboBox.getSelectedIndex()==2) chonGioitinh="0";
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"--Chọn--", "Nam", "Nữ"}));
		
		JLabel lblNewLabel_4 = new JLabel("Gi\u1EDBi t\u00EDnh");
		lblNewLabel_4.setBounds(10, 160, 65, 14);
		panel_2.add(lblNewLabel_4);
		
		txtChuthich = new JTextField();
		txtChuthich.setBounds(85, 188, 124, 20);
		panel_2.add(txtChuthich);
		txtChuthich.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Ch\u00FA th\u00EDch");
		lblNewLabel_5.setBounds(10, 191, 65, 14);
		panel_2.add(lblNewLabel_5);
		
		JButton btnXoa = new JButton("X\u00F3a");
		btnXoa.setForeground(new Color(255, 255, 255));
		btnXoa.setBackground(new Color(0, 0, 102));
		btnXoa.setBounds(117, 219, 81, 35);
		panel_2.add(btnXoa);
		
		JButton btnThem = new JButton("Th\u00EAm");
		btnThem.setForeground(new Color(255, 255, 255));
		btnThem.setBackground(new Color(0, 0, 102));
		btnThem.setBounds(20, 219, 81, 35);
		panel_2.add(btnThem);
		
		JLabel lblNewLabel_8 = new JLabel("QUẢN LÝ NHÂN VIÊN");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_8.setForeground(new Color(0, 0, 128));
		lblNewLabel_8.setBounds(240, 22, 294, 35);
		contentPane.add(lblNewLabel_8);
		
		JButton btnRf = new JButton("Refresh");
		btnRf.setForeground(new Color(255, 255, 255));
		btnRf.setBackground(new Color(0, 0, 102));
		btnRf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adapterMd=new ModelHotel();
				tblNv.setModel(adapterMd.loadAllNv());
				
			    lblTongNv.setText(adapterCtr.demDong("tb_nhanvien",adapterCtr.demNv));
			    lblTogNam.setText(adapterCtr.demDong("tb_nhanvien",adapterCtr.demNvNam));
			    lblTogNu.setText(adapterCtr.demDong("tb_nhanvien",adapterCtr.demNvNu));
			}
		});
		btnRf.setBounds(721, 34, 89, 23);
		contentPane.add(btnRf);
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String quyen=adapterCtr.cellTb("tinhtrang",adapterCtr.itemLogin(adapterCtr.Id("id_1","id")));
				if(!quyen.equals("1")) {JOptionPane.showMessageDialog(null,"Bạn không được sử dụng chức năng này!");
				return;
				}
		if(txtTenNv.getText().equals("")) JOptionPane.showMessageDialog(null, "Kiểm tra lại tên");
		else if(chonGioitinh.equals("1")||chonGioitinh.equals("0")) 
		{
			  adapterMd.ThemNhanVien(txtTenNv.getText(),txtChucvu.getText(),txtLuong.getText(),txtNamsinh.getText(),chonGioitinh,txtChuthich.getText());
			  adapterMd=new ModelHotel();
			  tblNv.setModel(adapterMd.loadAllNv());
			  
			  lblTongNv.setText(adapterCtr.demDong("tb_nhanvien",adapterCtr.demNv));
			  lblTogNam.setText(adapterCtr.demDong("tb_nhanvien",adapterCtr.demNvNam));
			  lblTogNu.setText(adapterCtr.demDong("tb_nhanvien",adapterCtr.demNvNu));
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Chưa chọn giới tính");
		}
			}
		});
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String quyen=adapterCtr.cellTb("tinhtrang",adapterCtr.itemLogin(adapterCtr.Id("id_1","id")));
				if(!quyen.equals("1")) {JOptionPane.showMessageDialog(null,"Bạn không được sử dụng chức năng này!");
				return;
				}
				if(IdNv.equals(""))
				{
	      JOptionPane.showMessageDialog(null, "Chưa chọn nhân viên");
				}
				else 
				{
		   adapterMd.XoaId("tb_nhanvien","ma_nv",IdNv);
		   tblNv.setModel(adapterMd.loadAllNv());
		   
		    lblTongNv.setText(adapterCtr.demDong("tb_nhanvien",adapterCtr.demNv));
		    lblTogNam.setText(adapterCtr.demDong("tb_nhanvien",adapterCtr.demNvNam));
		    lblTogNu.setText(adapterCtr.demDong("tb_nhanvien",adapterCtr.demNvNu));
				}
			}
		});
	}
}
