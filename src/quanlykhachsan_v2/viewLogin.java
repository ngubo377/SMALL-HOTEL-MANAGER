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

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JPasswordField;

public class viewLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txttk;
	ControllerHotel adapterCtr=new ControllerHotel();
	private JButton btnNewButton;
	private JLabel lblNewLabel;
	private JLabel lblpass;
	private JPanel panel;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton_1;
	private JPasswordField pfMk;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewLogin frame = new viewLogin();
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
	public viewLogin() {
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
		    
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 275, 228);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 51, 102));
		contentPane.setForeground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 153, 153));
		panel.setBounds(10, 11, 247, 178);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txttk = new JTextField();
		txttk.setBounds(74, 35, 163, 20);
		panel.add(txttk);
		txttk.setColumns(10);
		
		lblNewLabel = new JLabel("Tài khoản:");
		lblNewLabel.setForeground(new Color(0, 0, 153));
		lblNewLabel.setBounds(7, 38, 70, 14);
		panel.add(lblNewLabel);
		                                                                                                                                                                                              
		lblpass = new JLabel("Mật khẩu:");
		lblpass.setForeground(new Color(0, 0, 153));
		lblpass.setBounds(7, 69, 70, 14);
		panel.add(lblpass);
		
		btnNewButton = new JButton("Login");
		btnNewButton.setBounds(7, 108, 107, 23);
		panel.add(btnNewButton);
		
		lblNewLabel_1 = new JLabel("ĐĂNG NHẬP");
		lblNewLabel_1.setForeground(new Color(0, 0, 153));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(74, 4, 107, 23);
		panel.add(lblNewLabel_1);
		
		btnNewButton_1 = new JButton("Đóng!");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 0, 102));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setBounds(51, 142, 139, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Làm mới");
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(0, 0, 102));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		txttk.setText("");pfMk.setText("");
			}
		});
		btnNewButton_2.setBounds(124, 108, 113, 23);
		panel.add(btnNewButton_2);
		
		pfMk = new JPasswordField();
		pfMk.setBounds(74, 66, 163, 20);
		panel.add(pfMk);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 102));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		if(txttk.getText().equals("")||String.valueOf(pfMk.getPassword()).equals("")) JOptionPane.showMessageDialog(null,"Nhập đầy đủ!!!");
		else if(adapterCtr.demDong("tb_login",adapterCtr.demTaikhoan(txttk.getText(),String.valueOf(pfMk.getPassword()))).equals("0"))
		JOptionPane.showMessageDialog(null,"Nhập sai tài khoản hoặc mật khẩu");
		else if(!adapterCtr.demDong("tb_login",adapterCtr.demTaikhoan(txttk.getText(),String.valueOf(pfMk.getPassword()))).equals("0"))
		{
		String tk=txttk.getText();
		String mk=String.valueOf(pfMk.getPassword());
		String matk=adapterCtr.ma_tk(tk,mk);
		adapterCtr.luuid("*",matk);
		viewMain main=new viewMain();
		main.setVisible(true);
    	main.setLocationRelativeTo(null);
    	JOptionPane.showMessageDialog(null,"Chào "+adapterCtr.cellTb("ten_tk",adapterCtr.itemLogin(adapterCtr.Id("id_1","id")))+"!",null,JOptionPane.INFORMATION_MESSAGE);
    	dispose();
		}
			}
		});
	}
}
