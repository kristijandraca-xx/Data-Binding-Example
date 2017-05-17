package com.kristijandraca.databindingexample;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.kristijandraca.databindingexample.adapters.UsersAdapter;
import com.kristijandraca.databindingexample.databinding.ActivityMainBinding;
import com.kristijandraca.databindingexample.models.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements UsersAdapter.UserHandler {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        List<User> data = getSampleData();

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(new UsersAdapter(this, data, this));

    }

    /**
     * Method used to read sample data.json file from assets folder
     * @return array list of sample data
     */
    private List<User> getSampleData() {
        List<User> list = new ArrayList<>();
        try {
            JsonReader reader = new JsonReader(new BufferedReader(new InputStreamReader(getAssets().open("data.json"))));
            list = new Gson().fromJson(reader, new TypeToken<List<User>>(){}.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void onUserClick(User user) {
        startActivity(DetailsActivity.getDetailsIntent(this, user));
    }
}
