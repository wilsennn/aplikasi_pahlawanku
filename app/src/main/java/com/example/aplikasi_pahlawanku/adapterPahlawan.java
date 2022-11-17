package george.if3b.aplikasi_pahlawan;


import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AdapaterCard  extends RecyclerView.Adapter<AdapaterCard.ClassViewHolder>{
    private ArrayList<george.if3b.aplikasi_pahlawan.ModelPahlawan> dataPahlawan;

    public AdapaterCard(ArrayList<george.if3b.aplikasi_pahlawan.ModelPahlawan> dataPahlawan) {
        this.dataPahlawan = dataPahlawan;
    }

    @NonNull
    @Override
    public ClassViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);

        return new ClassViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ClassViewHolder holder, int position) {
        george.if3b.aplikasi_pahlawan.ModelPahlawan pahlawan = dataPahlawan.get(position);
        holder.tvNama.setText(pahlawan.getNama());
        holder.tvTentang.setText(pahlawan.getTentang());

        Glide
                .with(holder.itemView.getContext())
                .load(pahlawan.getFoto())
                .centerCrop()
                .into(holder.ivFoto);
    }

    @Override
    public int getItemCount() {
        return dataPahlawan.size();
    }

    public  class ClassViewHolder extends RecyclerView.ViewHolder{
        ImageView ivFoto;
        TextView tvNama, tvTentang;

        public ClassViewHolder(@NonNull View itemView) {
            super(itemView);
            ivFoto = itemView.findViewById(R.id.iv_foto);
            tvNama = itemView.findViewById(R.id.tv_nama);
            tvTentang = itemView.findViewById(R.id.tv_tentang);

        }
    }

}
