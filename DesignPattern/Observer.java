package DesignPattern;
public interface Observer
{
    public void print(String print);
    public void update(String message, Subject subject);
    public void makeMsgInNewsFeed();
    public void updateUser(int user);
}
