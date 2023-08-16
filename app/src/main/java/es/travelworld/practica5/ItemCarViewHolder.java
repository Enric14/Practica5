package es.travelworld.practica5;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import es.travelworld.practica5.databinding.ItemListCarBinding;

public class ItemCarViewHolder extends RecyclerView.ViewHolder {

    private final ItemListCarBinding binding;
    private final CarAdapter.OnCarItem listener;

    public ItemCarViewHolder(@NonNull ItemListCarBinding binding, CarAdapter.OnCarItem listener) {
        super(binding.getRoot());
        this.binding = binding;
        this.listener = listener;
    }

    public void bind(Car itemCar) {
        binding.itemLayoutListcarTittle.setText(itemCar.getNameCar());
        binding.itemlayoutListenerBackground.setBackgroundColor(ContextCompat.getColor(itemView.getContext(),itemCar.getFeatureCar().getColorRes()));
        binding.itemLayoutListcarImg.setImageDrawable(ContextCompat.getDrawable(itemView.getContext(),itemCar.getFeatureCar().getImgCar()));
        binding.itemLayoutListcarPrice.setText(itemCar.getPrice());

    }
}
