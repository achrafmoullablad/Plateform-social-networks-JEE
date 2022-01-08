package User_manager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Ado.Cado;
public class Cmuser implements Imuser{
	Cado ado=new Cado();
	@Override
	public int add_user(User u) {
		ado.connect();
		String sql="INSERT INTO users VALUES(null,'"+u.getEmail()+"','"+u.getPassword()+"','"+u.getRole()+"')";
		int nb = ado.MAJ(sql);
		ado.disconnect();
		return nb;
	}
	@Override
	public int modifier(String email,String password,int id) {
		ado.connect();
		String sql="UPDATE users SET email='"+email+"',password='"+password+"',role='user' WHERE id='"+id+"'";
		int nb = ado.MAJ(sql);
		ado.disconnect();
		return nb;
	}
	@Override
	public int supprimer_user(int id) {
		ado.connect();
		String sql="DELETE FROM users WHERE id='"+id+"'";
		int nb = ado.MAJ(sql);
		ado.disconnect();
		return nb;
	}
	@Override
	public User Authentifier(String email, String password) {
		User u=null;
		ado.connect();
		String sql="SELECT * FROM users WHERE email='"+email+"' AND password='"+password+"'";
		ResultSet rs=ado.select(sql);
		try {
			if(rs.next()) {
				u=new User(rs.getString(2),rs.getString(3),rs.getString(4));
				u.setId(rs.getInt(1));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
	
	@Override
	public User find_user_byid(int id) {
		ResultSet rs=null;
		User u=null;
		ado.connect();
		String sql="SELECT * FROM users WHERE id='"+id+"'";
		rs=ado.select(sql);
		try {
			if(rs.next()) {
				u=new User(rs.getString(2),rs.getString(3),rs.getString(4));
				u.setId(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
	@Override
	public List<User> ListUser() {
		List<User> lu=new ArrayList<User>();
		ResultSet rs=null;
		User u=null;
		ado.connect();
		String sql="SELECT * FROM users";
		rs=ado.select(sql);
		try {
			while(rs.next()) {
				u=new User(rs.getString(2),rs.getString(3),rs.getString(4));
				u.setId(rs.getInt(1));
				lu.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lu;
	}
	@Override
	public User isAdmin() {
		ResultSet rs=null;
		User u=null;
		ado.connect();
		String sql="SELECT * FROM users WHERE Role='Administrator' ";
		rs=ado.select(sql);
		try {
			if(rs.next()) {
				u=new User(rs.getString(2),rs.getString(3),rs.getString(4));
				u.setId(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
}
