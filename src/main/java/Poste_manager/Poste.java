package Poste_manager;
import java.time.LocalDateTime;
public class Poste {
	private int id;
	private String contenu;
	private LocalDateTime date;
	private int iduser;
	public Poste() {}
	public Poste(String contenu, int iduser) {
		this.contenu = contenu;
		this.iduser = iduser;
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
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public int getIduser() {
		return iduser;
	}
	public void setIduser(int iduser) {
		this.iduser = iduser;
	}
	@Override
	public String toString() {
		return "Poste [id=" + id + ", contenu=" + contenu + ", date=" + date + ", iduser=" + iduser + "]";
	}
}
