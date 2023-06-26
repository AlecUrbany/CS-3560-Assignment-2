package DesignPattern;
//Subject design pattern. Is a part of the observer pattern.
public interface Subject
{
    public void register(Observer object); 
    public void notifyUser(); 
    public Object getUpdate(Observer object); 
}
