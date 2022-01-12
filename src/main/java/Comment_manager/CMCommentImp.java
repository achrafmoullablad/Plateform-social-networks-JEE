package Comment_manager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Ado.Cado;

public class CMCommentImp implements IMComment{
	Cado dao;
	public CMCommentImp() {
		this.dao=new Cado();
	}
	@Override
	public int addComment(Comment c) {
		dao.connect();
		String sql="INSERT INTO commentaire(idu,idp,contenu) VALUES('"+c.getIdu()+"','"+c.getIdp()+"','"+c.getContenu()+"')";
		int nb=dao.MAJ(sql);
		dao.disconnect();
		return nb;
	}
	@Override
	public int modifiyContenu(int idu, String contenu) {
		dao.connect();
		String sql="UPDATE commentaire set contenu='"+contenu+"'WHERE idu='"+idu+"'";
		int nb=dao.MAJ(sql);
		dao.disconnect();
		return nb;
	}
	@Override
	public List<Comment> getAllCommentByPoste(int idp) {
		List<Comment> lc=new ArrayList<Comment>();
		Comment c=null;
		dao.connect();
		String sql="SELECT * FROM commentaire WHERE idp='"+idp+"'";
		ResultSet rs = dao.select(sql);
		try {
			while(rs.next()) {
				c=new Comment();
				c.setId(rs.getInt(1));
				c.setIdu(rs.getInt(2));
				c.setIdp(rs.getInt(3));
				c.setContenu(rs.getString(4));
				c.setDate(rs.getDate(5));
				lc.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dao.disconnect();
		return lc;
	}
}