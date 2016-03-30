package Dao;

import java.util.HashMap;
import java.util.TreeMap;

public interface LinksDao {
	public TreeMap getSortedmap(HashMap mymap); 
	
	public String likeLink(String linkid,String username,HashMap linkmap);
	
	public String disLikeLink(String linkid,String username,HashMap linkmap);
	
	
	
	
	
}
