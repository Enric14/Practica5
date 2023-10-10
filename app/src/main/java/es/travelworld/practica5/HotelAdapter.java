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

    Context mContext;
    List<HotelResult> hotelResults;

    public HotelAdapter (Context mContext, List<HotelResult> hotelResults) {
        this.hotelResults = hotelResults;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public HotelAdapter.RVHolderRetrofit onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.rv_hotel_item, parent, false);
        return new RVHolderRetrofit(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HotelAdapter.RVHolderRetrofit holder, int position) {
        holder.textView.setText(hotelResults.get(position).getName());
        Glide.with(mContext).
                load(hotelResults.get(position).getSrpDesktop()).placeholder(R.drawable.hotel_img).
                error(R.drawable.no_resultados_img).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return hotelResults.size();
    }

    public class RVHolderRetrofit extends RecyclerView.ViewHolder{
        TextView textView;
        ImageView imageView;
        public RVHolderRetrofit(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.iv_Information);
            imageView = itemView.findViewById(R.id.iv_Image);
        }
    }
}
