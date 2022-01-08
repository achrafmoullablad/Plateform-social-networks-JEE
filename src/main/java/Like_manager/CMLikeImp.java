package Like_manager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Ado.Cado;
public class CMLikeImp implements IMLike{
	Cado dao;
	public CMLikeImp() {
		dao=new Cado();
	}
	@Override
	public int addLike(Like l) {
		dao.connect();
		String sql="INSERT INTO tablike(idu,idp) VALUES('"+l.getIdu()+"','"+l.getIdp()+"')";
		int nb=dao.MAJ(sql);
		dao.disconnect();
		return nb;
	}
	@Override
	public List<Like> getAllLikePost(int idp) {
		Like l=null;
		List<Like> ls=new ArrayList<Like>();
		dao.connect();
		String sql="SELECT * FROM tablike WHERE idp='"+idp+"'";
		ResultSet rs = dao.select(sql);
		try {
			while(rs.next()) {
				l=new Like(rs.getInt(2), rs.getInt(3));
				l.setId(rs.getInt(1));
				l.setDate(rs.getDate(4));
				l.setType(rs.getInt(5));
				ls.add(l);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dao.disconnect();
		return ls;
	}
	@Override
	public int removeLike(int idp,int idu) {
		dao.connect();
		String sql="DELETE FROM tablike WHERE idu='"+idu+"'AND idp='"+idp+"'";
		int nb=dao.MAJ(sql);
		dao.disconnect();
		return nb;
	}
	@Override
	public Like getLike(int idu, int idp) {
		Like l=null;
		dao.connect();
		String sql="SELECT * FROM tablike WHERE idu='"+idu+"'AND idp='"+idp+"'";
		ResultSet rs = dao.select(sql);
		try {
			while(rs.next()) {
				l=new Like(rs.getInt(2), rs.getInt(3));
				l.setId(rs.getInt(1));
				l.setDate(rs.getDate(4));
				l.setType(rs.getInt(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dao.disconnect();
		return l;
	}
}
