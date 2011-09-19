package com.ChewieLouie.Topical;

public class Post {
	public enum Status { NEW, FOLLOWING_AND_NOT_CHANGED, FOLLOWING_AND_HAS_CHANGED };
	public String text = "";
	public Status status = Status.NEW;
	public String ID = "";

	public Post( String t )
	{
		text = t;
	}

	public Post( String t, Status s )
	{
		text = t;
		status = s;
	}
}
