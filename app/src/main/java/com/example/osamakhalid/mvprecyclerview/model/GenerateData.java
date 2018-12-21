package com.example.osamakhalid.mvprecyclerview.model;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Osama Khalid on 12/19/2018.
 */

public class GenerateData {
    public static List<User> users = new ArrayList<User>();

    public static List<User> generateUserData(Context context) {
        for (int i = 0; i < 9; i++) {
            users.add(new User(context.getResources().getIdentifier("user", "drawable", context.getPackageName())
                    , "Osama", "osamak@gmail.com"));
        }
        users.add(new User(context.getResources().getIdentifier("user", "drawable", context.getPackageName())
                , "Osama", "osamak@yahoo.com"));
        return users;
    }

    public static User addUser(Context context) {
        return new User(context.getResources().getIdentifier("user", "drawable", context.getPackageName())
                , "Osama", "osamak@yahoo.com");
    }
}
