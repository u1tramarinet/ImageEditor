package com.u1tramarinet.imageeditor.ui.main;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.divider.MaterialDividerItemDecoration;
import com.u1tramarinet.imageeditor.R;
import com.u1tramarinet.imageeditor.ui.trimming.TrimmingFragment;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment {

    private final List<PageAdapter.PlaceHolder> fragmentList = new ArrayList<>();
    private MainViewModel viewModel;

    {
        fragmentList.add(new PageAdapter.PlaceHolder("トリミング", TrimmingFragment::newInstance));
    }

    public MainFragment() {
    }

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        viewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        PageAdapter adapter = new PageAdapter(fragmentList) {
            @Override
            public void onItemClick(@NonNull PlaceHolder placeHolder, int position) {
                viewModel.movePage(placeHolder.supplier.get());
            }
        };
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(
                new MaterialDividerItemDecoration(
                        requireContext(), MaterialDividerItemDecoration.VERTICAL));
    }
}