package Poste_manager;
import java.util.List;
public interface ImPoste {
	public int add_poste(Poste p);
	public int modify_contenu(String contenu,int iduser);
	public int supprimer_poste(int id);
	public Poste find_poste_byiduser(int iduser);
	public List<Poste> List_poste(int id);
	public List<Poste> getPostFriend(int idp,int idi);
}
