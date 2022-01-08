package User_manager;
import java.time.LocalDateTime;
import java.util.List;
public interface Imuser {
	public int add_user(User u);
	public int modifier(String email,String password,int id);
	public int supprimer_user(int id);
	public User Authentifier(String email,String password);
	public User find_user_byid(int id);
	public User isAdmin();
	public List<User> ListUser();
}
