package com.kristijandraca.databindingexample.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kristijandraca.databindingexample.R;
import com.kristijandraca.databindingexample.models.User;

import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.ViewHolder> {

    private Context context;
    private List<User> list;
    private UserHandler listener;

    public UsersAdapter(Context context, List<User> list, UserHandler listener) {
        this.context = context;
        this.list = list;
        this.listener = listener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.item_user, parent, false);

        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final User item = list.get(position);

        holder.tvName.setText(String.format(context.getString(R.string.format_name), item.getFirstName(), item.getLastName()));
        holder.tvCompany.setText(item.getCompany() != null ? item.getCompany() : context.getString(R.string.unemployed));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onUserClick(item);
            }
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public interface UserHandler {
        void onUserClick(User item);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName, tvCompany;
        public ViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvCompany = (TextView) itemView.findViewById(R.id.tv_company);
        }
    }
}