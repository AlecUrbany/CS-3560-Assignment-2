package Assignment2.Twitter;
import java.io.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.JOptionPane;
import DesignPattern.Visitor;

//This class implements the Visitor interface, and will calculate whether or not a tweet is positive.
public class PosVisitor implements Visitor
{
    //This is to make sure groups are visited
    @Override
    public void visit(UserGroup group) {}

    
    @Override
    public void print(String Msg)
    {
        System.out.println(Msg);
    }

    @Override
    public void visit(User user)
    {

        ArrayList<String> words = new ArrayList<String>(Arrays.asList("good", "great", "excellent", "happy", "kind", "epic", "awesome", "nice", "cool", "swag", "drip", "coolio", "sweet", "radical", "best", "radiant", "lit", "fabulous", "based"));
        double count = 0;
        double countTotal = 0;
        for (Object obj : user.getUsers())
        {
            User use = (User) obj;
            for (String str : use.getTweets())
            {
                for (String word : words)
                {
                    if (str.toLowerCase().contains(word))
                    {
                        countTotal++;
                    }
                }
                count += str.split(" ").length;
            }
        }
        JOptionPane.showMessageDialog(null, "Positive Percentage: " + (countTotal/count)*100 + "%");
    }
}
