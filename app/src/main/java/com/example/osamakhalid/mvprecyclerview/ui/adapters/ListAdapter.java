package com.example.osamakhalid.mvprecyclerview.ui.adapters;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.osamakhalid.mvprecyclerview.R;
import com.example.osamakhalid.mvprecyclerview.model.User;
import com.example.osamakhalid.mvprecyclerview.presenters.MyActivityPresenter;

import java.util.List;

/**
 * Created by Osama Khalid on 12/19/2018.
 */

public class ListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<User> users;
    MyActivityPresenter presenter;

    public ListAdapter(List<User> users, MyActivityPresenter presenter) {
        this.users = users;
        this.presenter = presenter;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.users_list_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        User user = users.get(position);
        ((MyViewHolder) holder).email.setText(user.getEmail());
        ((MyViewHolder) holder).name.setText(user.getName());
        ((MyViewHolder) holder).img.setImageResource(user.getPhotoId());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView img;
        TextView name, email;

        public MyViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.photo);
            name = itemView.findViewById(R.id.name);
            email = itemView.findViewById(R.id.email);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            presenter.invoke(users.get(getAdapterPosition()).getEmail());
        }
    }

    public interface ICallback {
        public void invoke(String email);
    }
}
