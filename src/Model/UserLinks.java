package Model;

import java.util.ArrayList;
import java.util.UUID;

public class UserLinks {

	private String title;
	private String url;
	private UUID linkId;
	private String username;
	private int votecounter;
	private ArrayList<String> stringList= new ArrayList<String>();
	private ArrayList<String> unlikelist= new ArrayList<String>();
	private String voteBy;
	
	
	public String getTitle() {
		return title;
	}
	
	public  ArrayList<String> getStringList() {
		return stringList;
	}

	public void setStringList(ArrayList<String> stringList) {
		this.stringList = stringList;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public UUID getLinkId() {
		return linkId;
	}

	public void setLinkId(UUID linkId) {
		this.linkId = linkId;
	}

	public String getVoteBy() {
		return voteBy;
	}

	public void setVoteBy(String voteBy) {
		stringList.add(voteBy);
	}

	public int getVotecounter() {
		int count=stringList.size()-unlikelist.size();
		if(count<0)
		{
			return 0;
			
		}
		else
		{
			return count;
		}
	}

	public void setVotecounter(int votecounter) {
		this.votecounter = votecounter;
	}

	public ArrayList<String> getUnlikelist() {
		return unlikelist;
	}

	public void setUnlikelist(ArrayList<String> unlikelist) {
		this.unlikelist = unlikelist;
	}
	
	
	
}
