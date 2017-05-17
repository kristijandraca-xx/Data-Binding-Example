package com.kristijandraca.databindingexample;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.kristijandraca.databindingexample.databinding.ActivityDetailsBinding;
import com.kristijandraca.databindingexample.models.User;

public class DetailsActivity extends AppCompatActivity {
    private static final String ARG_USER = "arg_user";

    @NonNull
    public static Intent getDetailsIntent(Context context, User user) {
        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra(ARG_USER, user);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDetailsBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_details);

        User user = getIntent().getExtras().getParcelable(ARG_USER);
        binding.setVariable(BR.user, user);
    }
}