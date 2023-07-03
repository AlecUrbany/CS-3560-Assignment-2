package DesignPattern;

import javax.swing.JOptionPane;

import Assignment2.Twitter.UserGroup;
import Assignment2.Twitter.User;

public class VisitID implements Visitor 
{

    @Override
    public void visit(User user) 
    {
        if (user.checkUserID(user))
        {
            JOptionPane.showMessageDialog(null, "Users Verified. All names are good to go!");
        } else {
            JOptionPane.showMessageDialog(null, "no");
        }
    }

    @Override
    public void print(String testMessage) {}

    @Override
    public void visit(UserGroup group) {}
}
