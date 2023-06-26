package DesignPattern;

import A2.Twitter.UserGroup;
import A2.Twitter.User;

public interface Visitor
{
    public void visit(User user);
    public void print(String testMessage); 
    public void visit(UserGroup group);
}

    