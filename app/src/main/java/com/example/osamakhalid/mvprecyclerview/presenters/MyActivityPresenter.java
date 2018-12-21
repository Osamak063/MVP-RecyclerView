package com.example.osamakhalid.mvprecyclerview.presenters;

import android.content.Context;

import com.example.osamakhalid.mvprecyclerview.model.GenerateData;
import com.example.osamakhalid.mvprecyclerview.model.User;
import com.example.osamakhalid.mvprecyclerview.ui.adapters.ListAdapter;
import com.example.osamakhalid.mvprecyclerview.ui.adapters.ListAdapter.ICallback;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Osama Khalid on 12/19/2018.
 */

public class MyActivityPresenter implements ICallback {
    private View view;
    private List<User> userList = new ArrayList<User>();
    private ListAdapter adapter;
    Context context;

    public MyActivityPresenter(View view, Context context) {
        this.view = view;
        userList = GenerateData.generateUserData(context);
        adapter = new ListAdapter(userList, this);
        this.context = context;
    }

    public ListAdapter getAdapter() {
        return adapter;
    }

    public void addUser() {
        userList.add(GenerateData.addUser(context));
        adapter.notifyDataSetChanged();
    }

    @Override
    public void invoke(String email) {
        if (email.contains("gmail")) {
            view.moveToNextActivity(email);
        } else
            view.invalidEmail();
    }

    public interface View {
        public void moveToNextActivity(String email);

        public void invalidEmail();
    }
}
