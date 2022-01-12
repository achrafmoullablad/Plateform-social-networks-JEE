package Comment_manager;
import java.util.List;

public interface IMComment {
	public int addComment(Comment c);
	public int modifiyContenu(int idu,String contenu);
	public List<Comment> getAllCommentByPoste(int idp); 
}