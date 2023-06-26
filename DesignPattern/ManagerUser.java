package DesignPattern;

import java.util.*;

//Our composite design pattern. Is used in User and UserGroup.
public abstract class ManagerUser
{
    protected String id;
    
    public abstract void add(ManagerUser manage);

    public String getUserID()
    {
        return id;
    }

    @Override
    public String toString()
    {
        return id;
    }

    public abstract ArrayList<ManagerUser> getMembers();
    public abstract void accept(Visitor visit);
}
