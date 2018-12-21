package com.example.osamakhalid.mvprecyclerview.ui.activities;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.osamakhalid.mvprecyclerview.R;
import com.example.osamakhalid.mvprecyclerview.presenters.MyActivityPresenter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, MyActivityPresenter.View {
    RecyclerView recyclerView;
    MyActivityPresenter presenter;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        fab = findViewById(R.id.fab);
        presenter = new MyActivityPresenter(this, this);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(presenter.getAdapter());
        fab.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        presenter.addUser();
    }

    @Override
    public void moveToNextActivity(String email) {
        Intent i = new Intent(MainActivity.this, SecondActivity.class);
        i.putExtra("email", email);
        startActivity(i);
    }

    @Override
    public void invalidEmail() {
        Toast.makeText(getApplicationContext(), "Invalid Email", Toast.LENGTH_SHORT).show();
    }
}
