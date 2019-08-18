package com.example.testretrofit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.RepoViewHolder> {
    private List<RetroRepo> repos;

    public RepoAdapter(List<RetroRepo> repos) {
        this.repos = repos;
    }

    @NonNull
    @Override
    public RepoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.activity_card, parent, false);
        return new RepoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RepoViewHolder holder, int position) {
        RetroRepo retroRepo = repos.get(position);
        holder.name.setText(retroRepo.getName());
        holder.language.setText(retroRepo.getLanguage());
    }

    @Override
    public int getItemCount(){
        return repos.size();
    }

    public class RepoViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView language;

        public RepoViewHolder(View v) {
            super(v);
            name = v.findViewById(R.id.name);
            language = v.findViewById(R.id.language);
        }
    }

}
