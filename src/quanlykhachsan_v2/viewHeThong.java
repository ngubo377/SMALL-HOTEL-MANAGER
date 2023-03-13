package quanlykhachsan_v2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JPasswordField;
import javax.swing.UIManager;

public class viewHeThong extends JFrame {
    ModelHotel adapterMd=new ModelHotel();
    ControllerHotel adapterCtr=new ControllerHotel();
	private JPanel contentPane;
	private JTextField txtTentk;
	private JTextField txtQuyen;
	private JPasswordField pfMkm;
	private JPasswordField pfXacnhan;
	private JPasswordField pfMkcu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewHeThong frame = new viewHeThong();
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
	public viewHeThong() {
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				
	   txtTentk.setText(adapterCtr.cellTb("ten_tk",adapterCtr.itemLogin(adapterCtr.Id("id_1","id"))));
	   String quyen=adapterCtr.cellTb("tinhtrang",adapterCtr.itemLogin(adapterCtr.Id("id_1","id")));
	   if(quyen.equals("1")) txtQuyen.setText("Quản trị viên");
	   else txtQuyen.setText("Thành viên");
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 399, 350);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 204, 0));
		contentPane.setForeground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 204, 204));
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Th\u00F4ng tin t\u00E0i kho\u1EA3n:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
		panel_2.setBounds(10, 11, 373, 121);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("T\u00EAn user:");
		lblNewLabel.setBounds(10, 24, 68, 14);
		panel_2.add(lblNewLabel);
		
		txtTentk = new JTextField();
		txtTentk.setEditable(false);
		txtTentk.setBounds(100, 21, 233, 20);
		panel_2.add(txtTentk);
		txtTentk.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Quy\u1EC1n user:");
		lblNewLabel_1.setBounds(10, 59, 68, 14);
		panel_2.add(lblNewLabel_1);
		
		txtQuyen = new JTextField();
		txtQuyen.setEditable(false);
		txtQuyen.setBounds(100, 56, 233, 20);
		panel_2.add(txtQuyen);
		txtQuyen.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Th\u00EAm t\u00E0i kho\u1EA3n");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 0, 102));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	String quyen=adapterCtr.cellTb("tinhtrang",adapterCtr.itemLogin(adapterCtr.Id("id_1","id")));
	if(!quyen.equals("1")) JOptionPane.showMessageDialog(null,"Bạn không được sử dụng chức năng này!");
	else
	{
	viewUser user=new viewUser();
	user.setVisible(true);
	user.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	user.setLocationRelativeTo(null);
	}
			}
		});
		btnNewButton_1.setBounds(150, 87, 129, 23);
		panel_2.add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 204, 204));
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u0110\u1ED5i m\u1EADt kh\u1EA9u:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
		panel.setBounds(10, 138, 373, 172);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Đổi mật khẩu!");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 102));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
	  String mkc=adapterCtr.cellTb("matkhau",adapterCtr.itemLogin(adapterCtr.Id("id_1","id")));
	  if(!String.valueOf(pfMkcu.getPassword()).equals(mkc)) JOptionPane.showMessageDialog(null, "Nhập sai mật khẩu cũ!");
	  else if(String.valueOf(pfMkm.getPassword()).equals("")||String.valueOf(pfXacnhan.getPassword()).equals(""))
		  JOptionPane.showMessageDialog(null,"Nhập đầy đủ, nhập lại!");
	  else if(!String.valueOf(pfMkm.getPassword()).equals(String.valueOf(pfXacnhan.getPassword())))
	  {
		  JOptionPane.showMessageDialog(null, "Xác nhận sai!");
		  pfMkm.setText("");
		  pfXacnhan.setText("");
	  }
	  else
	  {
		  adapterMd.updateMatkhau(String.valueOf(pfMkm.getPassword()),adapterCtr.Id("id_1","id"));
	  }
			}
		});
		btnNewButton.setBounds(182, 132, 129, 29);
		panel.add(btnNewButton);
		
		pfMkm = new JPasswordField();
		pfMkm.setBounds(133, 67, 204, 23);
		panel.add(pfMkm);
		
		pfXacnhan = new JPasswordField();
		pfXacnhan.setBounds(133, 101, 204, 20);
		panel.add(pfXacnhan);
		
		pfMkcu = new JPasswordField();
		pfMkcu.setBounds(133, 31, 204, 20);
		panel.add(pfMkcu);
		
		JLabel lblNewLabel_4 = new JLabel("Mật khẩu cũ:");
		lblNewLabel_4.setBounds(11, 34, 93, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Mật khẩu mới:");
		lblNewLabel_5.setBounds(11, 73, 93, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Xác nhận:");
		lblNewLabel_6.setBounds(11, 104, 93, 14);
		panel.add(lblNewLabel_6);
	}
}
