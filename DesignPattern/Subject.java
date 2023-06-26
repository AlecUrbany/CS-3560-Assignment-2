package DesignPattern;

public interface Subject
{
    public void register(Observer object); 
    public void notifyUser(); 
    public Object getUpdate(Observer object); 
}
