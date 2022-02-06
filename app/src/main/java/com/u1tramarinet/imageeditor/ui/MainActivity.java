package com.u1tramarinet.imageeditor.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.u1tramarinet.imageeditor.R;
import com.u1tramarinet.imageeditor.ui.main.MainFragment;
import com.u1tramarinet.imageeditor.ui.main.MainViewModel;
import com.u1tramarinet.imageeditor.util.Event;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainViewModel viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        viewModel.pageEvent().observe(this, this::replaceFragmentFromEvent);
        replaceFragment(MainFragment.newInstance(), false);
    }

    private void replaceFragmentFromEvent(@NonNull Event<Fragment> event) {
        if (event.isHandled()) {
            return;
        }
        Fragment fragment = event.get();
        if (fragment == null) {
            return;
        }
        replaceFragment(fragment, true);
    }

    private void replaceFragment(@NonNull Fragment fragment, boolean addToBackStack) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragment);
        if (addToBackStack) {
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }
}