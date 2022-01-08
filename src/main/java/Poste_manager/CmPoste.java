package Poste_manager;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import Ado.Cado;
public class CmPoste implements ImPoste{
	@Override
	public int add_poste(Poste p) {
		Cado ado=new Cado();
		ado.connect();
		String sql="INSERT INTO poste(id,contenu,iduser) VALUES(null,'"+p.getContenu()+"','"+p.getIduser()+"')";
		int nb = ado.MAJ(sql);
		ado.disconnect();
		return nb;
	}
	@Override
	public int modify_contenu(String contenu, int iduser) {
		Cado ado=new Cado();
		ado.connect();
		String sql="UPDATE poste SET contenu='"+contenu+"'WHERE iduser='"+iduser+"'";
		int nb = ado.MAJ(sql);
		ado.disconnect();
		return nb;
	}
	@Override
	public int supprimer_poste(int id) {
		Cado ado=new Cado();
		ado.connect();
		String sql="DELETE FROM poste WHERE id='"+id+"'";
		int nb = ado.MAJ(sql);
		ado.disconnect();
		return nb;
	}
	@Override
	public Poste find_poste_byiduser(int iduser) {
		Poste p=null;
		ResultSet rs=null;
		Cado ado=new Cado();
		ado.connect();
		String sql="SELECT * FROM poste WHERE iduser='"+iduser+"'";
		rs=ado.select(sql);
		try {
			if (rs.next()) {
				p=new Poste(rs.getString(2),rs.getInt(4));
				p.setId(rs.getInt(1));
				DateTimeFormatter formater=DateTimeFormatter.RFC_1123_DATE_TIME;
				LocalDateTime d=LocalDateTime.parse(rs.getDate(3).toGMTString(),formater);
				p.setDate(d);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}
	@Override
	public List<Poste> List_poste(int id) {
		List<Poste> lp=new ArrayList<Poste>();
		Poste p=null;
		ResultSet rs=null;
		Cado ado=new Cado();
		ado.connect();
		String sql="SELECT * FROM poste WHERE iduser='"+id+"'";
		rs=ado.select(sql);
		try {
			while(rs.next()) {
				p=new Poste(rs.getString(2),rs.getInt(4));
				p.setId(rs.getInt(1));
				DateTimeFormatter formater=DateTimeFormatter.RFC_1123_DATE_TIME;
				LocalDateTime d=LocalDateTime.parse(rs.getDate(3).toGMTString(),formater);
				p.setDate(d);
				lp.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lp;
	}
	@Override
	public List<Poste> getPostFriend(int idp, int idi) {
		List<Poste> lp=new ArrayList<Poste>();
		Poste p=null;
		ResultSet rs=null;
		Cado ado=new Cado();
		ado.connect();
		String sql="select * from poste p,invitation i where p.iduser=i.ide AND i.status=1";
		rs=ado.select(sql);
		try {
			while(rs.next()) {
				p=new Poste(rs.getString(2),rs.getInt(4));
				p.setId(rs.getInt(1));
				DateTimeFormatter formater=DateTimeFormatter.RFC_1123_DATE_TIME;
				LocalDateTime d=LocalDateTime.parse(rs.getDate(3).toGMTString(),formater);
				p.setDate(d);
				lp.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lp;
	}
	
}
