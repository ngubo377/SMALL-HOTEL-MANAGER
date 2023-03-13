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
import javax.swing.border.TitledBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;

public class viewUser extends JFrame {
	private JTextField txtten;
	private JTextField txttaikhoan;
	private JTextField txtmatkhau;
	private JTable table;
	private String chonuser;
    ModelHotel adapterMd=new ModelHotel();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewUser frame = new viewUser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public viewUser() {
		getContentPane().setBackground(new Color(153, 204, 204));
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
			table.setModel(adapterMd.loadUser());
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 352);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Danh s\u00E1ch ng\u01B0\u1EDDi d\u00F9ng:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(new Color(153, 204, 0));
		panel.setBounds(10, 11, 378, 291);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		table = new JTable();
		table.setForeground(new Color(0, 0, 0));
		table.setBackground(new Color(204, 204, 204));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
		chonuser=table.getModel().getValueAt(table.getSelectedRow(),0).toString();
			}
		});
		scrollPane.setViewportView(table);
		
		txtten = new JTextField();
		txtten.setBounds(489, 88, 175, 20);
		getContentPane().add(txtten);
		txtten.setColumns(10);
		
		txttaikhoan = new JTextField();
		txttaikhoan.setBounds(489, 141, 175, 20);
		getContentPane().add(txttaikhoan);
		txttaikhoan.setColumns(10);
		
		txtmatkhau = new JTextField();
		txtmatkhau.setBounds(489, 186, 175, 20);
		getContentPane().add(txtmatkhau);
		txtmatkhau.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Tên tài khoản:");
		lblNewLabel.setBounds(398, 141, 88, 20);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("M\u1EADt kh\u1EA9u:");
		lblNewLabel_1.setBounds(398, 189, 68, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("H\u1ECD t\u00EAn:");
		lblNewLabel_2.setBounds(398, 88, 68, 20);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Add/Remove User");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(465, 35, 148, 27);
		getContentPane().add(lblNewLabel_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(450, 227, 175, 43);
		getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnthem = new JButton("Add");
		btnthem.setForeground(new Color(255, 255, 255));
		btnthem.setBackground(new Color(0, 0, 102));
		btnthem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		adapterMd.ThemUser(txttaikhoan.getText(),txtmatkhau.getText(),txtten.getText());
		table.setModel(adapterMd.loadUser());
			}
		});
		panel_1.add(btnthem);
		
		JButton btnxoa = new JButton("Remove");
		btnxoa.setForeground(new Color(255, 255, 255));
		btnxoa.setBackground(new Color(0, 0, 102));
		btnxoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	if(JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa "+table.getModel().getValueAt(table.getSelectedRow(),1).toString()+"","Kiểm tra lại",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
	{
		adapterMd.XoaId("tb_login","ma_tk",chonuser);
		table.setModel(adapterMd.loadUser());
	}
			}
		});
		panel_1.add(btnxoa);
	}
}
