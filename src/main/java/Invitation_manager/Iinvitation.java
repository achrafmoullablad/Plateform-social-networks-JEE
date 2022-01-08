package Invitation_manager;
import java.util.List;
public interface Iinvitation {
	public int addinvitation(int idi,int ide);
	public Invitation ShowInvit(int idi,int ide);
	public List<Invitation> showAllInvitation(int idu);
	public int deleteInvitation(int idi,int ide);
	public int AcceptAmie(int id);
	public List<Invitation> ShowAmie(int id);
	public Invitation checkAcceptation(int idi,int ide);
}