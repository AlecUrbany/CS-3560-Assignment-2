package Assignment2.Twitter;

import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import DesignPattern.Observer;
import DesignPattern.Subject;

//Class to display the user's feed.
public class Feed implements Observer, Subject
{
	Date currentDate;
	//Setting up the feed, as well as list of followers.
	ArrayList<String> feed;
	ArrayList<Observer> followers;

	//Will print whatever is needed
	@Override
	public void print(String print)
	{
		System.out.println(print);
	}

	//Updates the list of users.
	@Override
	public void updateUser(int user)
	{
		return;
	}

	//Our feed is made up of an array list containing messaged, as well as a list of the followings.
	//This is so we can display messages from other accounts that we follow.
	public Feed()
	{
		feed = new ArrayList<String>();
		followers = new ArrayList<Observer>();
	}

	//Prints out the user's message, as well as their name.
	@Override
	public void update(String msg, Subject subject)
	{
		Long tweetTime = System.currentTimeMillis();
		//Converting milliseconds to a readable date
		currentDate = new Date(tweetTime);
		User user = (User) subject;
		feed.add(user.getUserID() + ": " + msg + " | " + currentDate);
		notifyUser();
	}

	//Updates the feed.
	public ArrayList<String> getFeed()
	{
		return feed;
	}

	@Override
	public void register(Observer object)
	{
		if (object == null)
		{
			System.out.println("Invalid");
		}
		if (!followers.contains(object))
		{
			followers.add(object);
		}
	}

	//Tool used to notify user of other account's tweets (provided that the user follows the other accounts).
	@Override
	public void notifyUser()
	{
		for (Observer observer : followers)
		{
			observer.update(null, this);
		}
	}

	@Override
	public Object getUpdate(Observer obj)
	{
		throw new UnsupportedOperationException("");
	}

	@Override
	public void makeMsgInNewsFeed()
	{
		return;
	}

	public Date getTweetDate()
	{
		return currentDate;
	}
}
