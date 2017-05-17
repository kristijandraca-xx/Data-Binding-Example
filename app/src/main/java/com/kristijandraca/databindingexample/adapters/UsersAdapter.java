package com.kristijandraca.databindingexample.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kristijandraca.databindingexample.BR;
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
        holder.binding.setVariable(BR.user, item);
        holder.binding.setVariable(BR.handler, listener);
        holder.binding.executePendingBindings();
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public interface UserHandler {
        void onUserClick(User item);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private ViewDataBinding binding;

        ViewHolder(View v) {
            super(v);
            binding = DataBindingUtil.bind(v);
        }
    }
}