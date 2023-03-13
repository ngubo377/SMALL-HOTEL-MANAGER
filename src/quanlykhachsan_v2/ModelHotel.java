package quanlykhachsan_v2;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;

public class ModelHotel {
	String chuoikn = "jdbc:sqlserver://TRANQUOC-PC:1433;databaseName=hotel;integratedSecurity=true";
	DefaultTableModel tbModel=new DefaultTableModel();
	DefaultComboBoxModel cmbModel=new DefaultComboBoxModel();
	private Connection con;
	DateFormat ngay = new SimpleDateFormat("dd-MM-yyyy");
	DateFormat gio= new SimpleDateFormat("HH:mm");
	Calendar cal = Calendar.getInstance();
	String Id(String tb,String ma)
	{
	    int id1=0,id2=0;
		String id = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(chuoikn);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from "+tb+"");
				while(rs.next())
				{
					id = new String();
					id = rs.getString(ma);
					id1=Integer.parseInt(id);
					if(id1>=id2)
					{
						id2=id1;
					}
				}
				id=String.valueOf(id2+1);
				return id;
			}
			catch(Exception ex){
				JOptionPane.showMessageDialog(null, "lỗi id: " + ex.toString());
				return null;
			}
	}
	void hoantacHd()
	{		  
  try 
{
	 int maxHd=Integer.parseInt(Id("tb_hdtp","ma_hd"))-1;
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	Connection connection = DriverManager.getConnection(chuoikn);
	PreparedStatement st = connection.prepareStatement("delete from tb_hdtp where ma_hd='"+maxHd+"'");
	st.executeUpdate();						    				
	} catch (Exception e) {
   JOptionPane.showMessageDialog(null, "Lỗi khi xóa khách hàng khỏi phòng!" + e.toString());
} 
	}
	void hoantacKNP()
	{  
try 
	{
	int maxHd=Integer.parseInt(Id("tb_hdtp","ma_hd"))-1;
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	Connection connection = DriverManager.getConnection(chuoikn);
	PreparedStatement st = connection.prepareStatement("delete from tb_khachnhanphong where ma_phong in (select ma_phong from tb_hdtp where ma_hd = N'"+maxHd+"')");
	st.executeUpdate();						    				
	} catch (Exception e) 
     {
    JOptionPane.showMessageDialog(null, "Lỗi khi xóa khách hàng khỏi phòng!" + e.toString());
     }
	}
	void hoantacPhong()
	{
		int maxHd=Integer.parseInt(Id("tb_hdtp","ma_hd"))-1;
	     try 
	     {  
	  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	Connection connection = DriverManager.getConnection(chuoikn);
PreparedStatement st = connection.prepareStatement("update tb_phong set tinhtrang='0' where ma_phong in (select ma_phong from tb_hdtp where ma_hd =N'"+maxHd+"')");
	st.executeUpdate();							    				
		} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Lỗi khi update phòng!" + e.toString());
			} 
	}
	void hoantacKh(int demDong)
	{
		try
		{
		//lấy ra số cuối băng id Id() tăng 1 -1
		int cuoi=(Integer.parseInt(Id("tb_khachhang","ma_kh"))-1);
		int dau=1;
	    dau=cuoi-demDong;
	    for(int i=dau;i<=cuoi;i++)
	    {
	    	String j="";
	       j=String.valueOf(i);
	       updateMaKhto0(j);
	    }
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Lỗi khi hoàn tác khách hàng");
		}
	}
	void ThemKhachHang(String ten_kh,String cmnd_kh,String quoctich_kh,String gioitinh_kh,String tuoi_kh,String sdt_kh,String tt)
	{		
	try{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		con = DriverManager.getConnection(chuoikn);
		Statement st = con.createStatement();
	int i = st.executeUpdate("insert into tb_khachhang  values(N'"+Id("tb_khachhang","ma_kh")+"',N'"+ten_kh+"',N'" +cmnd_kh+"',N'" +quoctich_kh+"',N'" +gioitinh_kh+"',N'" +tuoi_kh+"',N'" +sdt_kh+"',N'"+tt+"')");	 
	if(i>0) JOptionPane.showMessageDialog(null, "Đã thêm khách hàng");
	}catch(Exception ex)
	{
		JOptionPane.showMessageDialog(null, "Lỗi khi thêm khách hàng!" + ex.toString());
	}
	}
	void ThemPhong(String ten_phong,String loai_phong,String gia_phong,String chuthich)
	{
			try{
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				con = DriverManager.getConnection(chuoikn);
				Statement st = con.createStatement();
				int i = st.executeUpdate("insert into tb_phong  values(N'"+Id("tb_phong","ma_phong")+"',N'" +ten_phong+"',N'" +loai_phong+"',N'" +gia_phong+"',N'" +chuthich+"',N'0')");
			//	if(i>0&&tinhtrang==1) JOptionPane.showMessageDialog(null, "Phòng đã được đặt");
				if(i>0) JOptionPane.showMessageDialog(null, "Đã thêm phòng");
			}catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null, "Lỗi khi thêm khách hàng!" + ex.toString());
			}
	}
	
	void ThemTinNhan(String noidung,String user)
	{
			try{
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				con = DriverManager.getConnection(chuoikn);
				Statement st = con.createStatement();
				st.executeUpdate("insert into tb_tinnhan  values(N'"+Id("tb_tinnhan","ma_tn")+"',N'"+noidung+"',N'"+user+"',N'"+gio.format(cal.getTime())+" "+ngay.format(cal.getTime())+"')");
			
			}catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null,"Lỗi tin nhắn! "+ex.toString());
			}
	}
	
	void ThemDichVu(String ten_dv,String gia_dv)
	{
			try{
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				con = DriverManager.getConnection(chuoikn);
				Statement st = con.createStatement();
				int i = st.executeUpdate("insert into tb_dichvu  values(N'"+Id("tb_dichvu","ma_dv")+"',N'" +ten_dv+"',N'" +gia_dv+"')");
				if(i>0) JOptionPane.showMessageDialog(null, "Đã thêm dịch vụ");
			}catch(Exception ex)
			{
				//ex.printStackTrace();
				JOptionPane.showMessageDialog(null, "Nhập sai tiền, phải nhập số /1000đ");
			}
	}
	
	void ThemHopDong(String ma_phong,String ma_nv)
	{
		try{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		con = DriverManager.getConnection(chuoikn);
		Statement st = con.createStatement();
		int i = st.executeUpdate("insert into tb_hdtp  values(N'"+Id("tb_hdtp","ma_hd")+"',N'"+ma_phong+"',N'"+ma_nv+"',N'"+ngay.format(cal.getTime())+"',N'"+gio.format(cal.getTime())+"')");
		if(i>0) JOptionPane.showMessageDialog(null, "Phòng đã được đặt");
		  }catch(Exception ex)
			{
				//ex.printStackTrace();
				JOptionPane.showMessageDialog(null, "Lỗi khi thêm hợp đồng " + ex.toString());
			}
	}
	
void ThemKhachNhanPhong(String ma_phong,String tt)
	{
			try{
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				con = DriverManager.getConnection(chuoikn);
				Statement st = con.createStatement();
				st.executeUpdate("insert into tb_khachnhanphong select ma_kh,ma_phong from tb_phong,tb_khachhang where tb_khachhang.tinhtrang=N'"+tt+"' and tb_phong.ma_phong='"+ma_phong+"'");
			}catch(Exception ex)
			{

				JOptionPane.showMessageDialog(null, "Lỗi khi thêm khách hàng nhận phòng " + ex.toString());
			}
	}
void Them(String ma_phong,String tt)
{
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(chuoikn);
			Statement st = con.createStatement();
			st.executeUpdate("insert into tb_khachnhanphong select ma_kh,ma_phong from tb_phong,tb_khachhang where tb_khachhang.tinhtrang=N'"+tt+"' and tb_phong.ma_phong='"+ma_phong+"'");
		}catch(Exception ex)
		{

			JOptionPane.showMessageDialog(null, "Lỗi khi thêm khách hàng nhận phòng " + ex.toString());
		}
}
	void ThemHoaDonDv(String ma_dv,String giodv,String ngaydv)
	{
			try{
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				con = DriverManager.getConnection(chuoikn);
				Statement st = con.createStatement();
			    st.executeUpdate("insert into tb_hoadondv  values(N'"+Id("tb_hoadondv","ma_hddv")+"',N'"+ma_dv+"',N'" +giodv+"',N'" +ngaydv+"',N'0')");
			}catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null, "Lỗi khi đặt dịch vụ" + ex.toString());
			}
	}
void ThemBienLai(String ma_hopdong,String ma_hddv)
	{
			try{
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				con = DriverManager.getConnection(chuoikn);
				Statement st = con.createStatement();
				int i = st.executeUpdate("insert into tb_bienlai  values(N'"+Id("tb_bienlai","ma_bl")+"',N'"+ma_hopdong+"',N'"+ma_hddv+"')");
				if(i>0) JOptionPane.showMessageDialog(null, "Biên lai đã được thêm");
			}catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null, "Lỗi khi thêm biên lai!" + ex.toString());
			}
	}
  void ThemNhanVien(String ten_nv,String chucvu_nv,String luong_nv,String namsinh_nv,String gioitinh_nv,String chuthich_nv)
	{
			try{
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				con = DriverManager.getConnection(chuoikn);
				Statement st = con.createStatement();
int i = st.executeUpdate("insert into tb_nhanvien  values(N'"+Id("tb_nhanvien","ma_nv")+"',N'"+ten_nv+"',N'"+chucvu_nv+"',N'"+luong_nv+"',N'"+namsinh_nv+"',N'"+gioitinh_nv+"',N'"+chuthich_nv+"')");
				if(i>0) JOptionPane.showMessageDialog(null, "Nhân viên đã được thêm");
			}catch(Exception ex)
			{
				//ex.printStackTrace();
				JOptionPane.showMessageDialog(null, "Lỗi khi thêm nhân viên!" + ex.toString());
			}
	}
  void ThemUser(String taikhoan,String matkhau,String hoten)
	{
			try{
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				con = DriverManager.getConnection(chuoikn);
				Statement st = con.createStatement();
				int i = st.executeUpdate("insert into tb_login  values(N'"+Id("tb_login","ma_tk")+"',N'"+taikhoan+"',N'"+matkhau+"',N'"+hoten+"',N'0')");
				if(i>0) JOptionPane.showMessageDialog(null, "Đã thêm người dùng");
			}catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null, "lỗi thêm người dùng!" + ex.toString());
			}
	}
    void updateMaKhto0(String makh)
	{
	     try 
	     {  
	    	 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection connection = DriverManager.getConnection(chuoikn);
			        PreparedStatement st = connection.prepareStatement("update tb_khachhang set tinhtrang='0' where tinhtrang='1' and ma_kh=N'"+makh+"'");
			st.executeUpdate();			
				//JOptionPane.showMessageDialog(null, "Ðã trả phòng!","Thông báo: ",JOptionPane.YES_NO_CANCEL_OPTION);				    				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Lỗi khi update khách hàng!" + e.toString());
			} 
	}
	void updateMatkhau(String matkhaumoi,String ma_tk)
	{
	     try 
	     {  
	    	 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection connection = DriverManager.getConnection(chuoikn);
				Statement st=connection.createStatement();
		       int i=st.executeUpdate("update tb_login set matkhau=N'"+matkhaumoi+"' where ma_tk='"+ma_tk+"'");		
		       if(i>0) JOptionPane.showMessageDialog(null, "Đã đổi mật khẩu!");
		} catch (Exception e) {
				JOptionPane.showMessageDialog(null,"Lỗi mật khẩu!" + e.toString());
			} 
	}
	
	void updateKhachHang()
	{
	     try 
	     {  
	   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	  Connection connection = DriverManager.getConnection(chuoikn);
	  PreparedStatement st = connection.prepareStatement("update tb_khachhang set tinhtrang='1' where tinhtrang='0'");
			st.executeUpdate();			
				//JOptionPane.showMessageDialog(null, "Ðã trả phòng!","Thông báo: ",JOptionPane.YES_NO_CANCEL_OPTION);				    				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Lỗi khi update khách hàng!" + e.toString());
			} 
	}
	void updateAllKh(String ma_kh,String ten,String cmnd,String quoctich,String gioitinh,String tuoi,String sdt)
	{
	     try 
	     {  
	    	 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection connection = DriverManager.getConnection(chuoikn);
PreparedStatement st = connection.prepareStatement("update tb_khachhang set ten_kh=N'"+ten+"', cmnd_kh=N'"+cmnd+"', quoctich_kh=N'"+quoctich+"', gioitinh_kh=N'"+gioitinh+"', tuoi_kh=N'"+tuoi+"', sdt_kh=N'"+sdt+"' where ma_kh='"+ma_kh+"'");
			st.executeUpdate();			
				//JOptionPane.showMessageDialog(null, "Ðã trả phòng!","Thông báo: ",JOptionPane.YES_NO_CANCEL_OPTION);				    				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Lỗi khi update khách hàng!" + e.toString());
			} 
	}
	void updatePhong(String tt,String chonPhong)
	{
	     try 
	     {  
	    	 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection connection = DriverManager.getConnection(chuoikn);
			        PreparedStatement st = connection.prepareStatement("update tb_phong set tinhtrang='"+tt+"' where ma_phong="+chonPhong+"");
			st.executeUpdate();			
				//JOptionPane.showMessageDialog(null, "Ðã trả phòng!","Thông báo: ",JOptionPane.YES_NO_CANCEL_OPTION);				    				
		} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Lỗi khi update phòng!" + e.toString());
			} 
	}
	void updateHDDV(String mot,String ko)
	{
	     try 
	     {  
	     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		 Connection connection = DriverManager.getConnection(chuoikn);
	     PreparedStatement st = connection.prepareStatement("update tb_hoadondv set tinhtrang=N'"+mot+"' where tinhtrang=N'"+ko+"'");
	     st.executeUpdate();						    				
		} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Lỗi khi update HDDV!" + e.toString());
			} 
	}
	void updateHopDongInHDon(String ma_hd)
	{
	     try 
	     {  
	     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		 Connection connection = DriverManager.getConnection(chuoikn);
	     PreparedStatement st = connection.prepareStatement("update tb_hoadondv set ma_hd=N'"+ma_hd+"' where tinhtrang=N'1'");
	     st.executeUpdate();						    				
		} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Lỗi khi update dịch vụ!" + e.toString());
			} 
	}
	public void XoaHddv()
	{
		  try 
		     {  
		    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			    Connection connection = DriverManager.getConnection(chuoikn);
				PreparedStatement st = connection.prepareStatement("delete from tb_hoadondv where tinhtrang='0'");
				st.executeUpdate();			
				//JOptionPane.showMessageDialog(null, "Ðã xóa","Thông báo: ",JOptionPane.YES_NO_CANCEL_OPTION);				    				
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Lỗi khi xóa!" + e.toString());
		    } 
	}
	//trả phòng 3 xóa khách hàng
	public void XoaKhTp(String maphong)
	{
		  try 
		     {  
		    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			    Connection connection = DriverManager.getConnection(chuoikn);
				PreparedStatement st = connection.prepareStatement("delete from tb_khachhang where ma_kh in (select tb_khachhang.ma_kh from tb_khachhang,tb_khachnhanphong,tb_phong where tb_khachhang.ma_kh=tb_khachnhanphong.ma_kh and tb_khachnhanphong.ma_phong=tb_phong.ma_phong and tb_phong.ma_phong=N'"+maphong+"')");
				st.executeUpdate();							    				
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Lỗi khi xóa. XoaKhTp!" + e.toString());
		    } 
	} 
	//trả phòng 4 xóa khachnhanphong
	public void XoaKnpTp(String maphong)
	{
		  try 
		     {  
		    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			    Connection connection = DriverManager.getConnection(chuoikn);
				PreparedStatement st = connection.prepareStatement("delete from tb_khachnhanphong where ma_kh in (select tb_khachnhanphong.ma_kh from tb_khachnhanphong,tb_phong where tb_khachnhanphong.ma_phong=tb_phong.ma_phong and tb_phong.ma_phong=N'"+maphong+"')");
				st.executeUpdate();							    				
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Lỗi khi xóa. XoaKnpTp!" + e.toString());
		    } 
	} 
	//trả phòng 1
	public void XoaHddvTp(String maphong)
	{
		  try 
		     {  
		    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			    Connection connection = DriverManager.getConnection(chuoikn);
				PreparedStatement st = connection.prepareStatement("delete from tb_hoadondv where ma_hddv in (select tb_bienlai.ma_hddv from tb_bienlai,tb_hdtp,tb_phong where tb_bienlai.ma_hd=tb_hdtp.ma_hd and tb_hdtp.ma_phong=tb_phong.ma_phong and tb_phong.ma_phong='"+maphong+"')");
				st.executeUpdate();							    				
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Lỗi khi xóa. XoaHddvTp!" + e.toString());
		    } 
	} 
	//trả phòng 2 xóa biên lai
	public void XoaBlTp(String maphong)
	{
		  try 
		     {  
		    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			    Connection connection = DriverManager.getConnection(chuoikn);
				PreparedStatement st = connection.prepareStatement("delete from tb_bienlai where ma_hddv in (select tb_bienlai.ma_hddv from tb_bienlai,tb_hdtp,tb_phong where tb_bienlai.ma_hd=tb_hdtp.ma_hd and tb_hdtp.ma_phong=tb_phong.ma_phong and tb_phong.ma_phong='"+maphong+"')");
				st.executeUpdate();							    				
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Lỗi khi xóa. XoaBlTp!" + e.toString());
		    } 
	} 
	//trả phòng 5 xóa hdtp
	public void XoaHdTp(String maphong)
	{
		  try 
		     {  
		    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			    Connection connection = DriverManager.getConnection(chuoikn);
				PreparedStatement st = connection.prepareStatement("delete from tb_hdtp where ma_phong in (select tb_hdtp.ma_phong from tb_hdtp, tb_phong where tb_hdtp.ma_phong=tb_phong.ma_phong and tb_phong.ma_phong=N'"+maphong+"')");
				st.executeUpdate();							    				
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Lỗi khi xóa. XoaBlTp!" + e.toString());
		    } 
	}
	void XoaId(String table,String id1,String id2)
	{
	  try 
	     {  
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		    Connection connection = DriverManager.getConnection(chuoikn);
			PreparedStatement st = connection.prepareStatement("delete from "+table+" where "+id1+"=N'"+id2+"'");
			st.executeUpdate();			
				JOptionPane.showMessageDialog(null, "Ðã xóa","Thông báo: ",JOptionPane.YES_NO_CANCEL_OPTION);				    				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Lỗi khi xóa!" + e.toString());
	    } 
	}
	public void XoaTn(JTextArea txtOutput)
	{
if(JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa tất cả tin nhắn! ","Kiểm tra lại!",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
      {
		  try 
		     {  
		    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			    Connection connection = DriverManager.getConnection(chuoikn);
				PreparedStatement st = connection.prepareStatement("delete from tb_tinnhan");
				st.executeUpdate();		
				JOptionPane.showMessageDialog(null, "Ðã xóa","Thông báo: ",JOptionPane.YES_NO_CANCEL_OPTION);	
				txtOutput.setText("");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Lỗi khi xóa!" + e.toString());
		    } 
	  }
   }
	/// lOAD tất cả kh
	public DefaultTableModel loadAllKh()
	{
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection(chuoikn);
		Statement st = con.createStatement();
ResultSet rs = st.executeQuery("select DISTINCT tb_khachhang.ma_kh,ten_kh,cmnd_kh,quoctich_kh,case when gioitinh_kh=1 then N'Nam' else N'Nữ' end as gioitinh_kh,tuoi_kh,sdt_kh,tb_phong.ten_phong from tb_khachhang,tb_khachnhanphong,tb_phong where tb_khachhang.ma_kh=tb_khachnhanphong.ma_kh and tb_phong.ma_phong=tb_khachnhanphong.ma_phong order by ma_kh asc");
			String[] tieudecot = {"ID","Tên KH","CMND","Quốc tịch","Giới tính","Tuổi","Liên lạc","Phòng"};
			ArrayList<String[]> dulieubang = new ArrayList<String[]>();
			while(rs.next())
			{
				String[] dong = new String[8];
				dong[0] = rs.getString("ma_kh");
				dong[1] = rs.getString("ten_kh");
				dong[2] = rs.getString("cmnd_kh");
				dong[3] = rs.getString("quoctich_kh");
				dong[4] = rs.getString("gioitinh_kh");
				dong[5] = rs.getString("tuoi_kh");
				dong[6] = rs.getString("sdt_kh");
				//dong[6] = rs.getString("tinhtrang");
				dong[7] = rs.getString("ten_phong");
				dulieubang.add(dong);
			}
			//
			String[][] data = new String[dulieubang.size()][8];
			for(int i=0; i<dulieubang.size(); i++)
			{
				data[i]=dulieubang.get(i);
			}
			tbModel.setDataVector(data,tieudecot);
			return tbModel;
		}
		catch(Exception ex){
			JOptionPane.showMessageDialog(null, "Lỗi khi load Kh " + ex.toString());
			return null;
		}
		}
    ///tìm kiếm quốc tịch
	public DefaultTableModel loadQuoctichKh(String quoctich)
	{
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection(chuoikn);
		Statement st = con.createStatement();
ResultSet rs = st.executeQuery("select DISTINCT tb_khachhang.ma_kh,ten_kh,quoctich_kh,case when gioitinh_kh=1 then N'Nam' else N'Nữ' end as gioitinh_kh,tuoi_kh,tb_phong.ten_phong from tb_khachhang,tb_khachnhanphong,tb_phong where tb_khachhang.ma_kh=tb_khachnhanphong.ma_kh and tb_phong.ma_phong=tb_khachnhanphong.ma_phong and quoctich_kh=N'"+quoctich+"' order by ma_kh asc");
			String[] tieudecot = {"Tên KH","Quốc tịch","Giới tính","Phòng"};
			ArrayList<String[]> dulieubang = new ArrayList<String[]>();
			while(rs.next())
			{
				String[] dong = new String[4];
				dong[0] = rs.getString("ten_kh");
				dong[1] = rs.getString("quoctich_kh");
				dong[2] = rs.getString("gioitinh_kh");
				dong[3] = rs.getString("ten_phong");
				dulieubang.add(dong);
			}
			String[][] data = new String[dulieubang.size()][4];
			for(int i=0; i<dulieubang.size(); i++)
			{
				data[i]=dulieubang.get(i);
			}
			tbModel.setDataVector(data,tieudecot);
			return tbModel;
		}
		catch(Exception ex){
			JOptionPane.showMessageDialog(null, "Báo l?i: " + ex.toString());
			return null;
		}
	}
	//tìm kiếm phòng
	public DefaultTableModel loadTimPhong(String phong)
	{
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(chuoikn);
			Statement st = con.createStatement();
	ResultSet rs = st.executeQuery("select DISTINCT tb_khachhang.ma_kh,ten_kh,cmnd_kh,quoctich_kh,case when gioitinh_kh=1 then N'Nam' else N'Nữ' end as gioitinh_kh,tuoi_kh,sdt_kh,tb_phong.ten_phong from tb_khachhang,tb_khachnhanphong,tb_phong where tb_khachhang.ma_kh=tb_khachnhanphong.ma_kh and tb_phong.ma_phong=tb_khachnhanphong.ma_phong and ten_phong=N'"+phong+"' order by ma_kh asc");
				String[] tieudecot = {"ID","Tên KH","CMND","Quốc tịch","Giới tính","Tuổi","Liên lạc","Phòng"};
				ArrayList<String[]> dulieubang = new ArrayList<String[]>();
				while(rs.next())
				{
					String[] dong = new String[8];
					dong[0] = rs.getString("ma_kh");
					dong[1] = rs.getString("ten_kh");
					dong[2] = rs.getString("cmnd_kh");
					dong[3] = rs.getString("quoctich_kh");
					dong[4] = rs.getString("gioitinh_kh");
					dong[5] = rs.getString("tuoi_kh");
					dong[6] = rs.getString("sdt_kh");
					//dong[6] = rs.getString("tinhtrang");
					dong[7] = rs.getString("ten_phong");
					dulieubang.add(dong);
				}
				//
				String[][] data = new String[dulieubang.size()][8];
				for(int i=0; i<dulieubang.size(); i++)
				{
					data[i]=dulieubang.get(i);
				}
				tbModel.setDataVector(data,tieudecot);
				return tbModel;
			}
			catch(Exception ex){
				JOptionPane.showMessageDialog(null, "Báo l?i: " + ex.toString());
				return null;
			}
		}
	/**
	 * @wbp.parser.entryPoint
	 */
	public DefaultTableModel loadKhachhang()
	{
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection(chuoikn);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select ma_kh,ten_kh,case when gioitinh_kh=1 then N'Nam' else N'Nữ' end as gioitinh_kh from tb_khachhang where tinhtrang='0' order by ma_kh asc");//load du lieu len JTable
			String[] tieudecot = {"Mã KH","Tên KH","Giới tính"};
			ArrayList<String[]> dulieubang = new ArrayList<String[]>();
			while(rs.next())
			{
				String[] dong = new String[3];
				dong[0] = rs.getString("ma_kh");
				dong[1] = rs.getString("ten_kh");
				dong[2] = rs.getString("gioitinh_kh");
				dulieubang.add(dong);
			}
			String[][] data = new String[dulieubang.size()][3];
			for(int i=0; i<dulieubang.size(); i++)
			{
				data[i]=dulieubang.get(i);
			}
			tbModel.setDataVector(data,tieudecot);
			return tbModel;
		}
		catch(Exception ex){
			JOptionPane.showMessageDialog(null, "Báo l?i: " + ex.toString());
			return null;
		}
	} 
	//LOAD PHÒNG tt=0:phòng trống, tt=1 phòng đã đặt
	public DefaultTableModel loadPhong(String tt)
	{
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection(chuoikn);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select ma_phong,ten_phong,case loai_phong when 1 then N'phòng đơn' when 2 then N'phòng đôi' when 3 then N'phòng ba' else N'Phòng Vip' end as loai_phong from tb_phong where tinhtrang=N'"+tt+"' order by ma_phong asc");
		String[] tieudecot = {"Mã Phòng","Tên Phòng","Loại Phòng"};
		ArrayList<String[]> dulieubang = new ArrayList<String[]>();
		while(rs.next())
		{
		String[] dong = new String[3];
		dong[0] = rs.getString("ma_phong");
		dong[1] = rs.getString("ten_phong");
		dong[2] = rs.getString("loai_phong");
		dulieubang.add(dong);
		}
		String[][] data = new String[dulieubang.size()][3];
		for(int i=0; i<dulieubang.size(); i++)
		{
		data[i]=dulieubang.get(i);
		}
		tbModel.setDataVector(data,tieudecot);
		return tbModel;
	}
	catch(Exception ex){
		JOptionPane.showMessageDialog(null, "Báo l?i: " + ex.toString());
		return null;
	}
	}
	//nếu i=1 thì load danh sách phòng đặt else load danh sách phòng trống else load tất cả
	/*public DefaultTableModel timKiemPhong(int j)
	{
	String where="";
	if(j==0) where="where tinhtrang=N'0'";
	else if(j==1) where="where tinhtrang=N'1'";
	else if(j==2) where="where loai_phong=N'1'";
	else if(j==3) where="where loai_phong=N'2'";
	else if(j==4) where="where loai_phong=N'3'";
	else if(j==5) where="where loai_phong=N'4'";
	else where="";
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection(chuoikn);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select ma_phong,ten_phong,case loai_phong when 1 then N'phòng đơn' when 2 then N'phòng đôi' when 3 then N'phòng ba' else N'Phòng Vip' end as loai_phong,gia_phong,chuthich,case when tinhtrang=1 then N'Phòng đã đặt' else N'Phòng trống' end as tinhtrang from tb_phong "+where+" order by ma_phong asc");//load du lieu len JTable
		//	rs = st.executeQuery("select MaNganh from Nganh");
			String[] tieudecot = {"Mã Phòng","Tên Phòng","Loại Phòng","Giá Phòng","Tình trạng","Chú thích"};
			ArrayList<String[]> dulieubang = new ArrayList<String[]>();
			while(rs.next())
			{
				String[] dong = new String[6];
				dong[0] = rs.getString("ma_phong");
				dong[1] = rs.getString("ten_phong");
				dong[2] = rs.getString("loai_phong");
				dong[3]=rs.getString("gia_phong");
				dong[4]=rs.getString("tinhtrang");
				dong[5]=rs.getString("chuthich");
				dulieubang.add(dong);
			}
			//
			String[][] data = new String[dulieubang.size()][6];
			for(int i=0; i<dulieubang.size(); i++)
			{
				data[i]=dulieubang.get(i);
			}
			tbModel.setDataVector(data,tieudecot);
			return tbModel;
		}
		catch(Exception ex){
			JOptionPane.showMessageDialog(null, "Báo lỗi: " + ex.toString());
			return null;
		}
	}*/
	public DefaultTableModel loadAllNv()
	{
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection(chuoikn);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select ma_nv,ten_nv,chucvu_nv,luong_nv,namsinh_nv,case when gioitinh_nv=1 then N'Nam' else N'Nữ' end as gioitinh_nv,chuthich_nv from tb_nhanvien order by ma_nv asc");
			String[] tieudecot = {"Mã NV","Tên NV","Chức vụ","Lương","Năm sinh","Giới tính","Chú thích"};
			ArrayList<String[]> dulieubang = new ArrayList<String[]>();
			while(rs.next())
			{
				String[] dong = new String[7];
				dong[0] = rs.getString("ma_nv");
				dong[1] = rs.getString("ten_nv");
				dong[2] = rs.getString("chucvu_nv");
				dong[3] = rs.getString("luong_nv");
				dong[4] = rs.getString("namsinh_nv");
				dong[5] = rs.getString("gioitinh_nv");
				dong[6] = rs.getString("chuthich_nv");
				dulieubang.add(dong);
			}
			String[][] data = new String[dulieubang.size()][7];
			for(int i=0; i<dulieubang.size(); i++)
			{
				data[i]=dulieubang.get(i);
			}
			tbModel.setDataVector(data,tieudecot);
			return tbModel;
	}
	catch(Exception ex){
		JOptionPane.showMessageDialog(null, "Lỗi khi load Nv"+ex.toString());
		return null;
	}
	}
	// LOAD NHÂN VIEN
	public DefaultTableModel loadNhanVien()
	{
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection(chuoikn);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from tb_nhanvien order by ma_nv asc");
			String[] tieudecot = {"Mã NV","Tên NV","Chức vụ"};
			ArrayList<String[]> dulieubang = new ArrayList<String[]>();
			while(rs.next())
			{
				String[] dong = new String[3];
				dong[0] = rs.getString("ma_nv");
				dong[1] = rs.getString("ten_nv");
				dong[2] = rs.getString("chucvu_nv");
				dulieubang.add(dong);
			}
			String[][] data = new String[dulieubang.size()][3];
			for(int i=0; i<dulieubang.size(); i++)
			{
				data[i]=dulieubang.get(i);
			}
			tbModel.setDataVector(data,tieudecot);
			return tbModel;
		}
		catch(Exception ex){
			JOptionPane.showMessageDialog(null, "Báo l?i: " + ex.toString());
			return null;
		}
	} 
	public DefaultTableModel loadDSDatPhong()
	{
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection(chuoikn);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select ten_phong,loai_phong,gia_phong,tb_hdtp.ngay_dp,tb_hdtp.gio_dp from tb_phong,tb_hdtp where tb_phong.tinhtrang='1' and tb_phong.ma_phong=tb_hdtp.ma_phong order by ma_nv asc");//load du lieu len JTable
		//	rs = st.executeQuery("select MaNganh from Nganh");
			String[] tieudecot = {"Tên Phòng","Loại Phòng","Giá Phòng","Ngày Đặt Phòng","Giờ Đặt Phòng"};
			ArrayList<String[]> dulieubang = new ArrayList<String[]>();
			while(rs.next())
			{
				String[] dong = new String[5];
				dong[0] = rs.getString("ten_phong");
				dong[1] = rs.getString("loai_phong");
				dong[2] = rs.getString("gia_phong");
				dong[3] = rs.getString("ngay_dp");
				dong[4] = rs.getString ("gio_dp");
				dulieubang.add(dong);
			}
			//
			String[][] data = new String[dulieubang.size()][5];
			for(int i=0; i<dulieubang.size(); i++)
			{
				data[i]=dulieubang.get(i);
			}
			tbModel.setDataVector(data,tieudecot);
			return tbModel;
		}
		catch(Exception ex){
			JOptionPane.showMessageDialog(null, "Lỗi khi load phòng! " + ex.toString());
			return null;
		}
	}
	public DefaultTableModel loadDichVu()
	{
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection(chuoikn);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from tb_dichvu order by ma_dv asc");
			String[] tieudecot = {"ID","Tên Dv","Giá Dv"};
			ArrayList<String[]> dulieubang = new ArrayList<String[]>();
			while(rs.next())
			{
				String[] dong = new String[3];
				dong[0] = rs.getString("ma_dv");
				dong[1] = rs.getString("ten_dv");
				dong[2] = rs.getString("gia_dv");
				dulieubang.add(dong);
			}
			//
			String[][] data = new String[dulieubang.size()][3];
			for(int i=0; i<dulieubang.size(); i++)
			{
				data[i]=dulieubang.get(i);
			}
			tbModel.setDataVector(data,tieudecot);
			return tbModel;
		}
		catch(Exception ex){
			JOptionPane.showMessageDialog(null, "Lỗi khi load dich vụ! " + ex.toString());
			return null;
		}	
	}

	public DefaultTableModel loadDvPhong(String maphong)
	{
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection(chuoikn);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select tb_dichvu.ma_dv,tb_dichvu.ten_dv,tb_dichvu.gia_dv,tb_hoadondv.gio_hddv,tb_hoadondv.ngay_hddv,tb_phong.ten_phong from tb_dichvu,tb_hoadondv,tb_hdtp,tb_bienlai,tb_phong where tb_dichvu.ma_dv=tb_hoadondv.ma_dv and tb_hoadondv.ma_hddv=tb_bienlai.ma_hddv and tb_bienlai.ma_hd=tb_hdtp.ma_hd and tb_phong.ma_phong=tb_hdtp.ma_phong and tb_phong.ma_phong=N'"+maphong+"' order by ma_dv asc");
			String[] tieudecot = {"Tên Dv","Giá Dv","Thời gian đặt","Ngày đặt","Tên phòng"};
			ArrayList<String[]> dulieubang = new ArrayList<String[]>();
			while(rs.next())
			{
				String[] dong = new String[5];
				dong[0] = rs.getString("ten_dv");
				dong[1] = rs.getString("gia_dv");
				dong[2] = rs.getString("gio_hddv");
				dong[3] = rs.getString("ngay_hddv");
				dong[4] = rs.getString("ten_phong");
				dulieubang.add(dong);
			}
			//
			String[][] data = new String[dulieubang.size()][5];
			for(int i=0; i<dulieubang.size(); i++)
			{
				data[i]=dulieubang.get(i);
			}
			tbModel.setDataVector(data,tieudecot);
			return tbModel;
		}
		catch(Exception ex){
			JOptionPane.showMessageDialog(null, "Lỗi khi load dich vụ! " + ex.toString());
			return null;
		}	
	}
	public DefaultTableModel loadTtDv()
	{
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection(chuoikn);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select tb_dichvu.ten_dv,gio_hddv,tb_dichvu.gia_dv from tb_hoadondv, tb_dichvu where tb_dichvu.ma_dv=tb_hoadondv.ma_dv and tinhtrang=0 order by ma_hddv asc");
			String[] tieudecot = {"Dịch vụ","Giá*1000đ","Thời gian đặt"};
			ArrayList<String[]> dulieubang = new ArrayList<String[]>();
			while(rs.next())
			{
				String[] dong = new String[3];
				dong[0] = rs.getString("ten_dv");
				dong[1] = rs.getString("gia_dv");
				dong[2] = rs.getString("gio_hddv");
				dulieubang.add(dong);
			}
			//
			String[][] data = new String[dulieubang.size()][3];
			for(int i=0; i<dulieubang.size(); i++)
			{
				data[i]=dulieubang.get(i);
			}
			tbModel.setDataVector(data,tieudecot);
			return tbModel;
		}
		catch(Exception ex){
			JOptionPane.showMessageDialog(null, "Lỗi khi load dich vụ! " + ex.toString());
			return null;
		}
	}
	public DefaultTableModel loadHdDv()
	{
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection(chuoikn);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select ma_hddv,tb_dichvu.ten_dv,gio_hddv,ngay_hddv from tb_hoadondv, tb_dichvu where tb_dichvu.ma_dv=tb_hoadondv.ma_dv and tinhtrang=0 order by ma_hddv asc");
			String[] tieudecot = {"ID","Tên Dv","Tgian đặt","Ngày đặt"};
			ArrayList<String[]> dulieubang = new ArrayList<String[]>();
			while(rs.next())
			{
				String[] dong = new String[4];
				dong[0] = rs.getString("ma_hddv");
				dong[1] = rs.getString("ten_dv");
				dong[2] = rs.getString("gio_hddv");
				dong[3] = rs.getString("ngay_hddv");
				dulieubang.add(dong);
			}
			//
			String[][] data = new String[dulieubang.size()][4];
			for(int i=0; i<dulieubang.size(); i++)
			{
				data[i]=dulieubang.get(i);
			}
			tbModel.setDataVector(data,tieudecot);
			return tbModel;
		}
		catch(Exception ex){
			JOptionPane.showMessageDialog(null, "Lỗi khi load dich vụ! " + ex.toString());
			return null;
		}
	}
	public DefaultTableModel loadUser()
	{
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection(chuoikn);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from tb_login order by ma_tk asc");
			String[] tieudecot = {"Id","Tên","Tên Tk","Mật khẩu!"};
			ArrayList<String[]> dulieubang = new ArrayList<String[]>();
			int j=0;
			while(rs.next())
			{
				j++;
				if(j==1);
				else
				{
				String[] dong = new String[4];
				dong[0] = rs.getString("ma_tk");
				dong[1] = rs.getString("ten_tk");
				dong[2] = rs.getString("taikhoan");
				dong[3] = rs.getString("matkhau");
				dulieubang.add(dong);
				}
			}
			//
			String[][] data = new String[dulieubang.size()][4];
			for(int i=0; i<dulieubang.size(); i++)
			{
				data[i]=dulieubang.get(i);
			}
			tbModel.setDataVector(data,tieudecot);
			return tbModel;
		}
		catch(Exception ex){
			JOptionPane.showMessageDialog(null, "Lỗi load user" + ex.toString());
			return null;
		}	
	}
	public DefaultComboBoxModel loadQuoctich()
	{ 
		cmbModel=new DefaultComboBoxModel();
		cmbModel.addElement("chọn quốc tịch");
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(chuoikn);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select DISTINCT quoctich_kh from tb_khachhang");
			while(rs.next()){
				cmbModel.addElement(rs.getString("quoctich_kh"));
			}
			return cmbModel;
	}
		catch(Exception e)
		{
			return null;
		}
	}
	public DefaultComboBoxModel loadPhongList()
	{ 
		cmbModel=new DefaultComboBoxModel();
		cmbModel.addElement("chọn phòng:");
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(chuoikn);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select ten_phong from tb_phong, tb_hdtp where tb_hdtp.ma_phong=tb_phong.ma_phong");
			while(rs.next()){
				cmbModel.addElement(rs.getString("ten_phong"));
			}
			return cmbModel;
	}
		catch(Exception e)
		{
			return null;
		}
	}
	public DefaultComboBoxModel loadUserList()
	{ 
		cmbModel=new DefaultComboBoxModel();
		cmbModel.addElement("chọn User:");
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(chuoikn);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select ten_tk from tb_login");
			while(rs.next()){
				cmbModel.addElement(rs.getString("ten_tk"));
			}
			return cmbModel;
	}
		catch(Exception e)
		{
			return null;
		}
	}
	public DefaultComboBoxModel loadNhanvienCmb()
	{ 
		cmbModel=new DefaultComboBoxModel();
		cmbModel.addElement("chọn nv:");
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(chuoikn);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select ten_nv from tb_nhanvien");
			while(rs.next()){
				cmbModel.addElement(rs.getString("ten_nv"));
			}
			return cmbModel;
	}
		catch(Exception e)
		{
			return null;
		}
	}
}

