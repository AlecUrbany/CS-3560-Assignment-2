package DesignPattern;

import Assignment2.Twitter.User;
import Assignment2.Twitter.UserGroup;

//Setting up the Visitor interface. This establishes the functions without defining them.
//This would be the Visitor design pattern.
public interface Visitor
{
	public void visit(User user);
	public void print(String testMessage); 
	public void visit(UserGroup group);
}

    