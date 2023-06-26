package Assignment2.Twitter;

import java.util.*;
import java.util.HashMap;

import DesignPattern.ManagerUser;
import DesignPattern.Observer;
import DesignPattern.Subject;
import DesignPattern.Visitor;

//Our user class. Is an extension of the User Manager.
public class User extends ManagerUser implements Subject
{
    //HashMap to keep track of users
    private static HashMap<String, User> users = new HashMap<String, User>();
    //Feed for the user to view
    private Feed newsfeed;
    //Group the user is in.
    private String group;
    //List of followers, followings, and tweets posted.
    private ArrayList<String> following;
    private ArrayList<String> tweets;
    private ArrayList<Observer> followers;

    //Getters to show up to date feed, the group the user is in, as well as tweets.
    public Feed getFeed()
    {
        return newsfeed;
    }

    public String getGroup()
    {
        return group;
    }

    public ArrayList<String> getTweets()
    {
        return tweets;
    }

    //Error to be thrown if there is an unsupported operation.
    @Override
    public Object getUpdate(Observer obj)
    {
        throw new UnsupportedOperationException("");
    }

    //Gets the amount of users.
    public Collection getUsers()
    {
        return users.values();
    }

    //Checks to see if a user already exists.
    public static boolean exists(String uid)
    {
        return users.containsKey(uid);
    }

    //Adds a user to the current user's following list.
    public void follow(String id)
    {
        users.get(id).register(newsfeed);
        following.add(id);
        for (String s : users.get(id).getTweets())
        {
            newsfeed.update(s, users.get(id));
        }
    }

    //Allows user to join group.
    public void joinGroup(String id)
    {
        group = id;
    }

    //Allows the user to tweet. Will display the tweet to the user.
    public void tweet(String msg)
    {
        tweets.add(msg);
        notifyUser();
    }

    
    @Override
    public void register(Observer obj)
    {
        if (obj == null) {
            System.out.println("Null observer");
        }
        if (!followers.contains(obj))
        {
            followers.add(obj);
        }
    }

    //Notifies the user of tweets from the list of users being followed.
    @Override
    public void notifyUser()
    {
        //This for loop will obtain tweets from every account the user follows.
        for (Observer obs : followers)
        {
            obs.update(tweets.get(tweets.size() - 1), this);
        }
    }

    //Shows who is currently followed by the user.
    public boolean isFollowing(String id)
    {
        return following.contains(id);
    }

    @Override
    public void add(ManagerUser um)
    {
        System.out.println("Can't add to leaf.");
    }

    @Override
    public ArrayList<ManagerUser> getMembers()
    {
        return null;
    }

    public ArrayList<String> getFollowing()
    {
        return following;
    }

    public void setMembers() {}

    public void setFollowing() {}

    @Override
    public void accept(Visitor visit) 
    {
        visit.visit(this);
    }

    //Sets up what exactly a user is.
    public User(String id, String group)
    {
        
        if (!users.containsKey(id))
        {
            this.id = id;
            followers = new ArrayList<Observer>();
            following = new ArrayList<String>();
            tweets = new ArrayList<String>();
            this.group = group;
            newsfeed = new Feed();
            this.register(newsfeed);
            users.put(id, this);
        }
    }
}
