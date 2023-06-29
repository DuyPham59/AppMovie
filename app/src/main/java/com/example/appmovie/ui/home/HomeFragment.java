package com.example.appmovie.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appmovie.Film;
import com.example.appmovie.ForgotPasswordActivity;
import com.example.appmovie.WacthTheMovie;
import com.example.appmovie.adapter.FilmAdapter;
import com.example.appmovie.R;
import com.example.appmovie.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private RecyclerView rcvFilm;
    private FilmAdapter filmAdapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rcvFilm = view.findViewById(R.id.rcv_film);
        filmAdapter = new FilmAdapter(view.getContext());
        filmAdapter.setData(getListFilm());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext(), RecyclerView.VERTICAL, false);
        rcvFilm.setLayoutManager(linearLayoutManager);
        rcvFilm.setAdapter(filmAdapter);
    }
    private List<Film> getListFilm(){
        List<Film> list = new ArrayList<>();
        int[] img = {R.drawable.thor, R.drawable.spiderman, R.drawable.doremon};
        String[] name = {"Thor", "Spiderman", "Doraemon"};
        for (int i=0; i<3; i++){
            list.add(new Film(img[i], name[i]));
        }
        return list;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}