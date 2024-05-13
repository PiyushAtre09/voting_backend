package com.app.entities;

public class Candidates {
	private String name;
	private String party;
	private int votes;
	public Candidates(String name, String party, int votes) {
		super();
		this.name = name;
		this.party = party;
		this.votes = votes;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParty() {
		return party;
	}
	public void setParty(String party) {
		this.party = party;
	}
	public int getVotes() {
		return votes;
	}
	public void setVotes(int votes) {
		this.votes = votes;
	}

}
