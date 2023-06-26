package A2.Twitter;

import java.util.ArrayList;
import java.util.HashMap;

import DesignPattern.ManagerUser;
import DesignPattern.Visitor;

public class UserGroup extends ManagerUser
{
    private ArrayList<ManagerUser> members;
    public static HashMap<String, UserGroup> groups = new HashMap<String, UserGroup>();

    public UserGroup(String id)
    {
        members = new ArrayList<ManagerUser>();
        this.id = id;
        groups.put(id, this);
    }

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

    public ArrayList<ManagerUser> getMembers()
    {
        return members;
    }

    public static boolean exists(String uid)
    {
        return groups.containsKey(uid);
    }

    public static UserGroup findGroup(String s)
    {
        return groups.get(s);
    }

    @Override
    public void accept(Visitor v)
    {
        v.visit(this);
    }
}
