package Assignment2.Twitter;

import java.util.ArrayList;

import DesignPattern.Observer;
import DesignPattern.Subject;

public class Feed implements Observer, Subject
{
    ArrayList<String> feed;
    ArrayList<Observer> followers;

    @Override
    public void print(String print)
    {
        System.out.println(print);
    }

    @Override
    public void updateUser(int user)
    {
        return;
    }

    public Feed()
    {
        feed = new ArrayList<String>();
        followers = new ArrayList<Observer>();
    }

    @Override
    public void update(String msg, Subject subject)
    {
        User user = (User) subject;
        feed.add(user.getUserID() + ": " + msg);
        notifyUser();
    }

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
}
