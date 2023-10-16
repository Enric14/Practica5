package es.travelworld.practica5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.RVHolderRetrofit> {

    private Context context;
    private List<HotelResult> hotelResults;

    public HotelAdapter (Context context, List<HotelResult> hotelResults) {
        this.hotelResults = hotelResults;
        this.context = context;
    }

    @NonNull
    @Override
    public HotelAdapter.RVHolderRetrofit onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_hotel_item, parent, false);
        return new RVHolderRetrofit(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HotelAdapter.RVHolderRetrofit holder, int position) {
        holder.textView.setText(hotelResults.get(position).getName());
        Glide.with(context).
                load(hotelResults.get(position).getSrpDesktop()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return hotelResults.size();
    }

    public class RVHolderRetrofit extends RecyclerView.ViewHolder{
        private TextView textView;
        private ImageView imageView;
        public RVHolderRetrofit(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.iv_Information);
            imageView = itemView.findViewById(R.id.iv_Image);
        }
    }
}
