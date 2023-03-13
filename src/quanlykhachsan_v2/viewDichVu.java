package quanlykhachsan_v2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.GridLayout;
import java.awt.SystemColor;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.table.DefaultTableModel;

public class viewDichVu extends JFrame {
    ModelHotel adapterMd=new ModelHotel();
    ControllerHotel adapterCtr=new ControllerHotel();
	private JPanel contentPane;
	private JTextField txtTenKh;
	private JTable tblDv;
	private JTable tblDvDat;
	private JTable tblTt;
	private JTextField txtTenDv;
	private JTextField txtGiaDv;
	private JComboBox cmbNhanvien;
	private JLabel lblTime;
	private JLabel lblNv;
	private JLabel lblSldv;
	private JLabel lblTongtien;
	private String chonDichvu;
	private String chonDvvD;
	private JTextField txtDcKh;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewDichVu frame = new viewDichVu();
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
	public viewDichVu() {
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
		    adapterMd=new ModelHotel();
		    tblDv.setModel(adapterMd.loadDichVu());
		    
		    adapterMd=new ModelHotel();
		    tblDvDat.setModel(adapterMd.loadHdDv());
		    cmbNhanvien.setModel(adapterMd.loadNhanvienCmb());     
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 834, 657);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 153, 204));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setBackground(new Color(153, 153, 153));
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Nh\u1EADp d\u1ECBch v\u1EE5:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
		panel.setBounds(10, 459, 232, 147);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("T\u00EAn Dv:");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(10, 24, 80, 28);
		panel.add(lblNewLabel);
		
		txtTenDv = new JTextField();
		txtTenDv.setBounds(100, 24, 122, 28);
		panel.add(txtTenDv);
		txtTenDv.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Giá Dv/1000đ");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(10, 90, 80, 30);
		panel.add(lblNewLabel_1);
		
		txtGiaDv = new JTextField();
		txtGiaDv.setBounds(100, 91, 122, 28);
		panel.add(txtGiaDv);
		txtGiaDv.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setForeground(new Color(0, 0, 51));
		panel_2.setBackground(new Color(153, 153, 153));
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Danh s\u00E1ch d\u1ECBch v\u1EE5 v\u1EEBa \u0111\u1EB7t:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
		panel_2.setBounds(351, 46, 458, 139);
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		panel_2.add(scrollPane_2);
		
		tblDvDat = new JTable();
		tblDvDat.setBackground(new Color(204, 204, 204));
		tblDvDat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
		chonDvvD=tblDvDat.getModel().getValueAt(tblDvDat.getSelectedRow(),0).toString();
			}
		});
		scrollPane_2.setViewportView(tblDvDat);
		
		JButton btnThemDv = new JButton("Th\u00EAm Dv");
		btnThemDv.setForeground(new Color(255, 255, 255));
		btnThemDv.setBackground(new Color(0, 0, 102));
		btnThemDv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		if (JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn thêm!","Kiểm tra lại",
				        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					adapterMd.ThemDichVu(txtTenDv.getText().toString(),txtGiaDv.getText().toString());
					adapterMd=new ModelHotel();
					tblDv.setModel(adapterMd.loadDichVu());
				}
			}}
		);
		btnThemDv.setBounds(20, 425, 97, 23);
		contentPane.add(btnThemDv);
		
		JButton btnXoaDv = new JButton("X\u00F3a Dv");
		btnXoaDv.setForeground(new Color(255, 255, 255));
		btnXoaDv.setBackground(new Color(0, 0, 102));
		btnXoaDv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dialogButton = JOptionPane.YES_NO_OPTION;
		        JOptionPane.showConfirmDialog (null, "Kiểm tra lại các mặt hàng chưa thanh toán trc khi xóa!","Cẩn thận!",dialogButton);
		        if(dialogButton == JOptionPane.YES_OPTION){
			adapterMd.XoaId("tb_dichvu","ma_dv",chonDichvu);
			adapterMd=new ModelHotel();
			tblDv.setModel(adapterMd.loadDichVu());
			}
			}
		});
		btnXoaDv.setBounds(129, 425, 100, 23);
		contentPane.add(btnXoaDv);
		
		JList list_1 = new JList();
		list_1.setBounds(369, 221, 1, 1);
		contentPane.add(list_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(0, 0, 51));
		panel_1.setBackground(SystemColor.inactiveCaption);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Danh s\u00E1ch d\u1ECBch v\u1EE5:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
		panel_1.setBounds(10, 46, 232, 368);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane);
		
		tblDv = new JTable();
		tblDv.setBackground(new Color(204, 204, 204));
		tblDv.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		tblDv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				chonDichvu=tblDv.getModel().getValueAt(tblDv.getSelectedRow(),0).toString();
			}
		});
		scrollPane.setViewportView(tblDv);
		
		JPanel panel_3 = new JPanel();
		panel_3.setForeground(new Color(0, 0, 0));
		panel_3.setBackground(new Color(153, 153, 153));
		panel_3.setBorder(new LineBorder(Color.BLUE));
		panel_3.setBounds(268, 228, 541, 311);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel label = new JLabel("H\u00D3A \u0110\u01A0N D\u1ECACH V\u1EE4");
		label.setForeground(new Color(0, 0, 51));
		label.setBounds(199, 11, 141, 23);
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_3.add(label);
		
		JLabel lblngb = new JLabel("Ông/bà:");
		lblngb.setForeground(new Color(0, 0, 0));
		lblngb.setBounds(46, 60, 54, 14);
		panel_3.add(lblngb);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(46, 85, 452, 131);
		panel_3.add(panel_4);
		panel_4.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane_3 = new JScrollPane();
		panel_4.add(scrollPane_3);
		
		tblTt = new JTable();
		scrollPane_3.setViewportView(tblTt);
		
		JLabel newLabel = new JLabel("Tổng tiền:");
		newLabel.setForeground(new Color(0, 0, 0));
		newLabel.setBounds(303, 277, 74, 23);
		panel_3.add(newLabel);
		
		lblTongtien = new JLabel("100");
		lblTongtien.setForeground(new Color(0, 0, 0));
		lblTongtien.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTongtien.setBounds(387, 275, 144, 23);
		panel_3.add(lblTongtien);
		
		JLabel lblKhchSnTrn = new JLabel("Khách sạn Trần Quốc");
		lblKhchSnTrn.setForeground(new Color(0, 0, 0));
		lblKhchSnTrn.setBounds(209, 32, 131, 14);
		panel_3.add(lblKhchSnTrn);
		
		txtTenKh = new JTextField();
		txtTenKh.setBounds(110, 57, 165, 20);
		panel_3.add(txtTenKh);
		txtTenKh.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Th\u1EDDi gian TT:");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setBounds(10, 227, 83, 14);
		panel_3.add(lblNewLabel_2);
		
		lblTime = new JLabel("");
		lblTime.setBounds(129, 227, 190, 14);
		panel_3.add(lblTime);
		
		JLabel lblNewLabel_3 = new JLabel("Số lượng dv:");
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_3.setBounds(303, 252, 74, 14);
		panel_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Địa chỉ:");
		lblNewLabel_4.setForeground(new Color(0, 0, 0));
		lblNewLabel_4.setBounds(292, 60, 48, 14);
		panel_3.add(lblNewLabel_4);
		
		txtDcKh = new JTextField();
		txtDcKh.setBounds(350, 57, 148, 20);
		panel_3.add(txtDcKh);
		txtDcKh.setColumns(10);
		
		lblSldv = new JLabel("...");
		lblSldv.setForeground(new Color(0, 0, 0));
		lblSldv.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSldv.setBounds(387, 250, 111, 14);
		panel_3.add(lblSldv);
		
		JLabel lblNewLabel_6 = new JLabel("Người lập phiếu:");
		lblNewLabel_6.setForeground(new Color(0, 0, 0));
		lblNewLabel_6.setBounds(10, 252, 109, 14);
		panel_3.add(lblNewLabel_6);
		
		cmbNhanvien = new JComboBox();
		cmbNhanvien.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(cmbNhanvien.getSelectedIndex()==0) lblNv.setText("");
				else lblNv.setText(cmbNhanvien.getSelectedItem().toString());		
			}
		});
		cmbNhanvien.setBounds(129, 249, 117, 20);
		panel_3.add(cmbNhanvien);
		
		lblNv = new JLabel("");
		lblNv.setBounds(39, 281, 153, 14);
		panel_3.add(lblNv);
		
		JButton btnXemHd = new JButton("Xem H\u00F3a \u0110\u01A1n");
		btnXemHd.setForeground(new Color(255, 255, 255));
		btnXemHd.setBackground(new Color(0, 0, 102));
		btnXemHd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			  adapterMd=new ModelHotel();
			  tblTt.setModel(adapterMd.loadTtDv());
			
			  lblTime.setText(adapterCtr.gioHt+" "+adapterCtr.ngayHt);
			  lblSldv.setText(adapterCtr.demDong("tb_hoadondv",adapterCtr.demHddv));
		      lblTongtien.setText(adapterCtr.demTien(adapterCtr.demtien1)+".000đ");
			}
		});
		btnXemHd.setBounds(478, 196, 128, 23);
		contentPane.add(btnXemHd);
		
		JButton btnDatDv = new JButton("\u0110\u1EB7t Dv >>");
		btnDatDv.setForeground(new Color(255, 255, 255));
        btnDatDv.setBackground(new Color(0, 0, 102));
		btnDatDv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		adapterMd.ThemHoaDonDv(chonDichvu,adapterCtr.gioHt,adapterCtr.ngayHt);
		adapterMd=new ModelHotel();
		tblDvDat.setModel(adapterMd.loadHdDv());
			}
		});
		btnDatDv.setBounds(252, 91, 89, 23);
		contentPane.add(btnDatDv);
		
		JButton btnXuat = new JButton("Xuất HĐ/thanh toán");
		btnXuat.setForeground(new Color(255, 255, 255));
		btnXuat.setBackground(new Color(0, 0, 102));
		btnXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	    
		if(txtTenKh.getText().equals("")) 
		{
if(JOptionPane.showConfirmDialog(null, "Chưa nhập tên kh, bạn có muốn in k","Kiểm tra lại",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
			{
			 lblSldv.setText("");
	         lblTongtien.setText("");
	         lblTime.setText("");
	         adapterMd.XoaHddv();
	         tblDvDat.setModel(adapterMd.loadHdDv());
	         JOptionPane.showMessageDialog(null, "Đã in!");
			}
		}
		else
		{
//if(JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa!","Kiểm tra lại",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
            {
	         lblTime.setText("");
	         lblSldv.setText("");
	         lblTongtien.setText("");
			 adapterMd.XoaHddv();
	         tblDvDat.setModel(adapterMd.loadHdDv());
	         JOptionPane.showMessageDialog(null, "Đã in!");
            }
		}
			}
		});
		btnXuat.setBounds(366, 550, 164, 56);
		contentPane.add(btnXuat);
		
		JButton btnNewButton = new JButton("<< H\u1EE7y dv");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 102));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		adapterMd.XoaId("tb_hoadondv","ma_hddv",chonDvvD);
		adapterMd=new ModelHotel();
		tblDvDat.setModel(adapterMd.loadHdDv());
			}
		});
		btnNewButton.setBounds(252, 125, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnthanhtoansau = new JButton("Thanh toán sau");
		btnthanhtoansau.setForeground(new Color(255, 255, 255));
		btnthanhtoansau.setBackground(new Color(0, 0, 102));
		btnthanhtoansau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			adapterMd=new ModelHotel();
			tblDvDat.setModel(adapterMd.loadHdDv());
			viewDichVuChonPhong chonphong=new viewDichVuChonPhong();
			chonphong.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			chonphong.setVisible(true);
			chonphong.setLocationRelativeTo(null);
			}
		});
		btnthanhtoansau.setBounds(553, 550, 164, 56);
		contentPane.add(btnthanhtoansau);
		
		JLabel lblNewLabel_5 = new JLabel("DỊCH VỤ");
		lblNewLabel_5.setForeground(new Color(0, 0, 128));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setBounds(10, 11, 294, 35);
		contentPane.add(lblNewLabel_5);
		
		JButton btnRf = new JButton("Refresh");
		btnRf.setForeground(new Color(255, 255, 255));
        btnRf.setBackground(new Color(0, 0, 102));
		btnRf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRf.setBounds(720, 12, 89, 23);
		contentPane.add(btnRf);
	}
}
