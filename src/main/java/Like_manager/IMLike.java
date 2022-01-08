package Like_manager;
import java.util.List;
public interface IMLike {
	public int addLike(Like l);
	public List<Like> getAllLikePost(int idp);
	public Like getLike(int idu,int idp);
	public int removeLike(int idp,int idu);
}
