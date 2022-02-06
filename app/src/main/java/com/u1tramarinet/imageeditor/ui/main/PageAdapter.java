package com.u1tramarinet.imageeditor.ui.main;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.u1tramarinet.imageeditor.databinding.ListItemPageBinding;

import java.util.List;
import java.util.function.Supplier;

public abstract class PageAdapter extends RecyclerView.Adapter<PageAdapter.ViewHolder> {

    @NonNull
    private final List<PlaceHolder> values;

    public PageAdapter(@NonNull List<PlaceHolder> items) {
        values = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ListItemPageBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        PlaceHolder placeHolder = values.get(position);
        holder.item = placeHolder;
        holder.pageTitle.setText(values.get(position).title);
        holder.root.setOnClickListener(view -> onItemClick(placeHolder, holder.getAbsoluteAdapterPosition()));
    }

    @Override
    public int getItemCount() {
        return values.size();
    }

    public abstract void onItemClick(@NonNull PlaceHolder placeHolder, int position);

    @SuppressWarnings("InnerClassMayBeStatic")
    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View root;
        public final TextView pageTitle;
        public PlaceHolder item;

        public ViewHolder(ListItemPageBinding binding) {
            super(binding.getRoot());
            root = binding.getRoot();
            pageTitle = binding.pageTitle;
        }

        @NonNull
        @Override
        public String toString() {
            return super.toString() + " '" + pageTitle.getText() + "'";
        }
    }

    public static class PlaceHolder {
        @NonNull
        public final String title;
        @NonNull
        public final Supplier<Fragment> supplier;

        public PlaceHolder(@NonNull String title, @NonNull Supplier<Fragment> supplier) {
            this.title = title;
            this.supplier = supplier;
        }

        @NonNull
        @Override
        public String toString() {
            return title;
        }
    }
}