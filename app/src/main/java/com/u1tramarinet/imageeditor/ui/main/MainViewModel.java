package com.u1tramarinet.imageeditor.ui.main;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.u1tramarinet.imageeditor.util.Event;

public class MainViewModel extends ViewModel {
    @NonNull
    private final MutableLiveData<Event<Fragment>> pageEventData = new MutableLiveData<>();

    public LiveData<Event<Fragment>> pageEvent() {
        return pageEventData;
    }

    public void movePage(@NonNull Fragment fragment) {
        pageEventData.postValue(new Event<>(fragment));
    }
}
