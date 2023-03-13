package quanlykhachsan_v2;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.SystemColor;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.UIManager;

public class viewHoadon extends JFrame {

	private JPanel contentPane;
	private JTable table;
	ModelHotel adapterMd=new ModelHotel();
	ControllerHotel adapterCtr=new ControllerHotel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewHoadon frame = new viewHoadon();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public viewHoadon() {
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) { 
		//  lblphong.setText(adapterCtr.cellTb("ten_phong",adapterCtr.itemP(adapterCtr.Id())));
		   table.setModel(adapterMd.loadDvPhong(adapterCtr.Id("id","id_1")));
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 251);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(0, 0, 424, 224);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Danh s\u00E1ch d\u1ECBch v\u1EE5:", TitledBorder.LEADING, TitledBorder.TOP, null,new Color(0, 102, 255)));
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		scrollPane.setViewportView(table);
	}
}
