package es.travelworld.practica5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import es.travelworld.practica5.databinding.ItemListCarBinding;

public class CarAdapter extends RecyclerView.Adapter<ItemCarViewHolder> {

    private final List<Car> items;
    private OnCarItem listener;
    interface OnCarItem {
        void onStartClick(Car itemSelected);
        void onCarClick(Car itemSelected);
    }

    public CarAdapter(List<Car> listCar, OnCarItem listener) {
        this.items = listCar;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ItemCarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemCarViewHolder(ItemListCarBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false), listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemCarViewHolder holder, int position) {
        holder.itemView.setOnClickListener(view -> listener.onCarClick(items.get(position)));
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
