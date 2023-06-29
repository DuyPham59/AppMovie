package com.example.appmovie.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appmovie.Film;
import com.example.appmovie.R;
import com.example.appmovie.ui.home.HomeFragment;

import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.UserViewHolder>{

    private HomeFragment mContext;
    private List<Film> mListFilm;

    public FilmAdapter(HomeFragment mContext) {
        this.mContext = mContext;
    }

    public FilmAdapter(android.content.Context context) {
    }

    public void setData(List<Film> list){
        this.mListFilm = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_film, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        Film user = mListFilm.get(position);
        if (user == null){
            return;
        }
       holder.imgFilm.setImageResource(user.getResourceId());
        holder.Name.setText(user.getName());
    }

    @Override
    public int getItemCount() {
        if (mListFilm != null){
            return mListFilm.size();
        }
        return 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFilm;
        private TextView Name;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

         imgFilm = itemView.findViewById(R.id.img_film);
         Name = itemView.findViewById(R.id.tv_Name);
        }
    }
}
