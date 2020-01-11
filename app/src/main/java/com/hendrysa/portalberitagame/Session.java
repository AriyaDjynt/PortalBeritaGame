package com.hendrysa.portalberitagame;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Session {

    private SharedPreferences prefs;

    public Session(Context cntx)
    {
        prefs = PreferenceManager.getDefaultSharedPreferences(cntx);
    }

    public void setLogin(String username, String user_id)
    {
        prefs.edit().putString("username", username).apply();
        prefs.edit().putString("user_id", user_id).apply();
    }

    public String getUsername()
    {
        String usename = prefs.getString("username","");
        return usename;
    }

    public String getUser_id()
    {
        String user_id = prefs.getString("user_id","");
        return user_id;
    }

    public Boolean getStatus()
    {
        if(!getUser_id().isEmpty())
        {
            return true;
        }
        return false;
    }

    public void logout()
    {
        prefs.edit().remove("username").apply();
        prefs.edit().putString("user_id", "").apply();
    }
}
