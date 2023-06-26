package DesignPattern;

import javax.swing.JOptionPane;

import A2.Twitter.UserGroup;
import A2.Twitter.User;

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
