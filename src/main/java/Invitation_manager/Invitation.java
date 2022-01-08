package Invitation_manager;
import java.util.Date;
public class Invitation {
	private int id;
	private Date date;
	private int status;
	private int idi;
	private int ide;
	public Invitation() {
	}
	public Invitation(int idi, int ide) {
		this.idi = idi;
		this.ide = ide;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getIdi() {
		return idi;
	}
	public void setIdi(int idi) {
		this.idi = idi;
	}
	public int getIde() {
		return ide;
	}
	public void setIde(int ide) {
		this.ide = ide;
	}
	@Override
	public String toString() {
		return "Invitation [id=" + id + ", date=" + date + ", status=" + status + ", idi=" + idi + ", ide=" + ide + "]";
	}
}
