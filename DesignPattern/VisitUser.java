package DesignPattern;

import javax.swing.JOptionPane;

import A2.Twitter.UserGroup;
import A2.Twitter.User;

public class VisitUser implements Visitor
{
    private int visits;
    private int number;

    @Override
    public void visit(UserGroup userGroup)
    {
        throw new UnsupportedOperationException("Invalid");
    }

    private void setVisit(int numberOfVisits)
    {
        this.visits = numberOfVisits;
    }

    private int getNumberOfVisits()
    {
        return this.getNumberOfVisits();
    }

    @Override
    public void print(String msg)
    {
        System.out.println(msg);
    }

    @Override
    public void visit(User user)
    {
        int count = 0;
        for (Object object : user.getUsers())
        {
            User userGroup = (User) object;
            count += userGroup.getTweets().size();
        }
        JOptionPane.showMessageDialog(null, "Messages Total: " + count);
    }
}
