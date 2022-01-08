package Like_manager;
import java.util.Date;
public class Like {
	private int id;
	private int idu;
	private int idp;
	private Date date;
	private int type;
	public Like() {
	}
	public Like(int idu, int idp) {
		this.idu = idu;
		this.idp = idp;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Like [id=" + id + ", idu=" + idu + ", idp=" + idp + ", date=" + date + ", type=" + type + "]";
	}
}
