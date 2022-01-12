package Comment_manager;

import java.util.Date;

public class Comment {
	private int id;
	private String contenu;
	private Date date;
	private int idu;
	private int idp;
	public Comment() {
	}
	public Comment(String contenu, int idu, int idp) {
		this.contenu = contenu;
		this.idu = idu;
		this.idp = idp;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getIdu() {
		return idu;
	}
	public void setIdu(int idu) {
		this.idu = idu;
	}
	public int getIdp() {
		return idp;
	}
	public void setIdp(int idp) {
		this.idp = idp;
	}
	@Override
	public String toString() {
		return "Comment [id=" + id + ", contenu=" + contenu + ", date=" + date + ", idu=" + idu + ", idp=" + idp + "]";
	}
}
