package Assignment2.Twitter;

import java.util.ArrayList;
import java.util.HashMap;

import DesignPattern.ManagerUser;
import DesignPattern.Visitor;

//Class to set up groups for users.
public class UserGroup extends ManagerUser
{
    //Array list of what users are in the group.
    private ArrayList<ManagerUser> members;
    public static HashMap<String, UserGroup> groups = new HashMap<String, UserGroup>();

    //Creator for a new group. 
    public UserGroup(String id)
    {
        members = new ArrayList<ManagerUser>();
        this.id = id;
        groups.put(id, this);
    }

    //Will add new users to group.
    @Override
    public void add(ManagerUser um)
    {
        if (um.getMembers() == null)
        {
            members.add((User) um);
        }
        else
            members.add((UserGroup) um);
    }

    //Getter for the users in a group
    public ArrayList<ManagerUser> getMembers()
    {
        return members;
    }

    //Checks for whether or not a user exists in a group.
    public static boolean exists(String uid)
    {
        return groups.containsKey(uid);
    }

    //Allows you to find specific groups.
    public static UserGroup findGroup(String s)
    {
        return groups.get(s);
    }

    //Allows a visitor to visit the group.
    @Override
    public void accept(Visitor v)
    {
        v.visit(this);
    }
}
