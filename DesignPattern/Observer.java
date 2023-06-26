package DesignPattern;
//Setting up the observer interface. Used in UserView and Feed.
public interface Observer
{
    public void print(String print);
    public void update(String message, Subject subject);
    public void makeMsgInNewsFeed();
    public void updateUser(int user);
}
