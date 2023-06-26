package DesignPattern;

import javax.swing.JOptionPane;

import Assignment2.Twitter.User;
import Assignment2.Twitter.UserGroup;

public class Visited implements Visitor
{
    @Override
    public void visit(User user)
    {
        JOptionPane.showMessageDialog(null, "User Total: " + user.getUsers().size());
    }

    @Override
    public void print(String msg)
    {
        System.out.println(msg);
    }

    @Override
    public void visit(UserGroup group)
    {
        throw new UnsupportedOperationException("");
    }
}
