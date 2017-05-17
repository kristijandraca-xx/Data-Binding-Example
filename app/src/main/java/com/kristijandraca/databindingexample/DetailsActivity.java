package com.kristijandraca.databindingexample;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

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
        setContentView(R.layout.activity_details);

        TextView tvName = (TextView) findViewById(R.id.tv_name);
        TextView tvType = (TextView) findViewById(R.id.tv_type);
        TextView tvBalance = (TextView) findViewById(R.id.tv_balance);

        User user = getIntent().getExtras().getParcelable(ARG_USER);

        tvName.setText(String.format(getString(R.string.format_name_with_age), user.getFirstName(), user.getLastName(), user.getAge()));
        tvType.setText(user.isPremium() ? getString(R.string.type_premium) : getString(R.string.type_regular));
        tvBalance.setText(String.format(getString(R.string.format_balance), user.getBalance()));
        tvBalance.setTextColor(ContextCompat.getColor(this, user.getBalance() > 0 ? R.color.balance_positive : R.color.balance_negative));
    }
}
