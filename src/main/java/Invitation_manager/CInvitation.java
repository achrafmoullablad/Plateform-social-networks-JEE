package Invitation_manager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Ado.Cado;
import User_manager.User;
public class CInvitation implements Iinvitation{
	Cado ado=new Cado();
	@Override
	public int addinvitation(int idi,int ide) {
		ado.connect();
		String sql="INSERT INTO invitation(idi,ide) VALUES("+idi+","+ide+")";
		int nb = ado.MAJ(sql);
		ado.disconnect();
		return nb;
	}
	@Override
	public Invitation ShowInvit(int idi, int ide) {
		Invitation u=null;
		ado.connect();
		String sql="SELECT * FROM invitation WHERE idi='"+idi+"' AND ide='"+ide+"'";
		ResultSet rs=ado.select(sql);
		try {
			if(rs.next()) {
				u=new Invitation();
				u.setId(rs.getInt(1));
				u.setDate(rs.getDate(2));
				u.setStatus(rs.getInt(3));
				u.setIdi(rs.getInt(4));
				u.setIde(rs.getInt(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public List<Invitation> showAllInvitation(int idu) {
		List<Invitation> lu=new ArrayList<Invitation>();
		ResultSet rs=null;
		Invitation u=null;
		ado.connect();
		String sql="SELECT * FROM invitation where ide='"+idu+"' and status=0";
		rs=ado.select(sql);
		try {
			while(rs.next()) {
				u=new Invitation();
				u.setId(rs.getInt(1));
				u.setDate(rs.getDate(2));
				u.setStatus(rs.getInt(3));
				u.setIdi(rs.getInt(4));
				u.setIde(rs.getInt(5));
				lu.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lu;
	}
	@Override
	public int deleteInvitation(int idi, int ide) {
		ado.connect();
		String sql="DELETE FROM invitation WHERE idi='"+idi+"'AND ide='"+ide+"'";
		int nb = ado.MAJ(sql);
		ado.disconnect();
		return nb;
	}
	@Override
	public int AcceptAmie(int id) {
		ado.connect();
		String sql="UPDATE invitation SET status=1 WHERE id='"+id+"'";
		int nb = ado.MAJ(sql);
		ado.disconnect();
		return nb;
	}
	@Override
	public List<Invitation> ShowAmie(int id) {
		List<Invitation> lu=new ArrayList<Invitation>();
		ResultSet rs=null;
		Invitation u=null;
		ado.connect();
		String sql="SELECT * FROM invitation where idi='"+id+"'AND status=1";
		rs=ado.select(sql);
		try {
			while(rs.next()) {
				u=new Invitation();
				u.setId(rs.getInt(1));
				u.setDate(rs.getDate(2));
				u.setStatus(rs.getInt(3));
				u.setIdi(rs.getInt(4));
				u.setIde(rs.getInt(5));
				lu.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lu;
	}
	@Override
	public Invitation checkAcceptation(int idi, int ide) {
		Invitation u=null;
		ado.connect();
		String sql="SELECT * FROM invitation WHERE idi='"+idi+"' AND ide='"+ide+"'AND status=1";
		ResultSet rs=ado.select(sql);
		try {
			if(rs.next()) {
				u=new Invitation();
				u.setId(rs.getInt(1));
				u.setDate(rs.getDate(2));
				u.setStatus(rs.getInt(3));
				u.setIdi(rs.getInt(4));
				u.setIde(rs.getInt(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
	
	
}
