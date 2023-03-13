package quanlykhachsan_v2;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.SystemColor;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

public class viewDichVuChonPhong extends JFrame {

	private JPanel contentPane;
	private JTable tblchonphong;
	private String idp="";
	ModelHotel adapterMd=new ModelHotel();
	ControllerHotel adapterCtr=new ControllerHotel();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewDichVuChonPhong frame = new viewDichVuChonPhong();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public viewDichVuChonPhong() {
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
			tblchonphong.setModel(adapterMd.loadPhong("1"));
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 245, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBorder(new TitledBorder(null, "Ch\u1ECDn ph\u00F2ng thanh to\u00E1n sau:", TitledBorder.LEADING, TitledBorder.TOP, null,new Color(0, 102, 255)));
		panel.setBounds(0, 0, 239, 357);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		tblchonphong = new JTable();
		tblchonphong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
	if(adapterCtr.demDong("tb_hoadondv","where tinhtrang='0'").equals("0")) JOptionPane.showMessageDialog(null,"Không có dịch vụ được đặt!");
	else if(JOptionPane.showConfirmDialog(null, "Bạn có muốn thanh toán sau phòng "+tblchonphong.getModel().getValueAt(tblchonphong.getSelectedRow(),1).toString()+"","Kiểm tra lại",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
				{
				idp=tblchonphong.getModel().getValueAt(tblchonphong.getSelectedRow(),0).toString();	
				adapterCtr.dvThanhToanSau(idp);
	JOptionPane.showMessageDialog(null,"Đã chuyển hóa đơn vào phòng "+tblchonphong.getModel().getValueAt(tblchonphong.getSelectedRow(),1).toString()+"");
				}
			}
		});
		scrollPane.setViewportView(tblchonphong);
	}
}
