package DaoImpl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.UUID;

import Dao.LinksDao;
import Model.UserLinks;

public class LinksDaoImpl implements LinksDao {

	@Override
	public TreeMap getSortedmap(HashMap mymap) {
		// TODO Auto-generated method stub
		HashMap<String,Integer> buffer = new HashMap<String,Integer>();
        ValueComparator bvc =  new ValueComparator(buffer);
        TreeMap<String,Integer> sorted_map = new TreeMap<String,Integer>(bvc);

        Iterator it = mymap.keySet().iterator();
        UserLinks slb;
        UUID key;
		while(it.hasNext())
		{

		key = (UUID) it.next();

		String uuid = key.toString();


		slb = (UserLinks) mymap.get(key);

		buffer.put(uuid,slb.getVotecounter());

		}
        
        sorted_map.putAll(buffer);
        return sorted_map;
	}

	@Override
	public String likeLink(String linkid, String username,HashMap likemap) {
		// TODO Auto-generated method stub
		
		UUID id=UUID.fromString(linkid);
		UserLinks objBean=(UserLinks)likemap.get(id);
		
		if(objBean.getStringList().contains(username))
		{
			objBean.getStringList().remove(username);
			
			if(objBean.getUnlikelist().contains(username))
			{
				//objBean.getStringList().remove(username);
				objBean.getUnlikelist().remove(username);
				objBean.getStringList().add(username);
				
			}			
		}
		else if(objBean.getUnlikelist().contains(username))
		{
			objBean.getUnlikelist().remove(username);
			objBean.getStringList().add(username);
		}
		else
		{
			objBean.setVoteBy(username);
		}		
		
		return "Profile";
	}

	@Override
	public String disLikeLink(String linkid, String username, HashMap likemap) {
		
		UUID id=UUID.fromString(linkid);
		UserLinks objBean=(UserLinks)likemap.get(id);
		if(objBean.getStringList().contains(username))
		{
			if(objBean.getStringList().size() - objBean.getUnlikelist().size() > 1)
			{
				objBean.getStringList().remove(username);
				objBean.getUnlikelist().add(username);
			}
			else if(objBean.getStringList().size() - objBean.getUnlikelist().size() == 1)
			{
				objBean.getUnlikelist().add(username);
			}			
			else
			{
				objBean.getStringList().remove(username);
				objBean.getUnlikelist().remove(username);
				objBean.getStringList().add(username);
			}
		}
		else if(objBean.getUnlikelist().contains(username))
		{
			objBean.getUnlikelist().remove(username);
		}
		else
		{
			if(objBean.getStringList().size() > 0)
			{
				objBean.getUnlikelist().add(username);
			}
		}	
		
		return "Profile";
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
