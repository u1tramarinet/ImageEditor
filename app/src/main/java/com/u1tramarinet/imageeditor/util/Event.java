package com.u1tramarinet.imageeditor.util;

import androidx.annotation.Nullable;

public class Event<T> {
    @Nullable
    private final T data;
    private boolean handled = false;

    public Event(@Nullable T data) {
        this.data = data;
    }

    public synchronized boolean isHandled() {
        return handled;
    }

    @Nullable
    public synchronized T get() {
        if (handled) {
            return null;
        }
        handled = true;
        return data;
    }
}
