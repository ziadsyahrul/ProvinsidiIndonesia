package com.ziadsyahrul.provinsidiindonesia;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    //TODO 1 Membuat variable
    Context context;
    int[] gambarProvinsi;
    String[] namaProvinsi,detailProvinsi;

    public Adapter(Context context, int[] gambarProvinsi, String[] namaProvinsi, String[] detailProvinsi) {
        this.context = context;
        this.gambarProvinsi = gambarProvinsi;
        this.namaProvinsi = namaProvinsi;
        this.detailProvinsi = detailProvinsi;

    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_provinsi, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder viewHolder, final int i) {
        viewHolder.txtNama.setText(namaProvinsi[i]);
        Glide.with(context).load(gambarProvinsi[i]).into(viewHolder.imgLogo);

        //TODO Membuat onClickListener
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(context, DetailActivity.class);
                pindah.putExtra("np", namaProvinsi[i]);
                pindah.putExtra("dp", detailProvinsi[i]);
                pindah.putExtra("gp", gambarProvinsi[i]);
                context.startActivity(pindah);
            }
        });
    }

    @Override
    public int getItemCount() {
        return gambarProvinsi.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgLogo;
        TextView txtNama;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgLogo = itemView.findViewById(R.id.imgList);
            txtNama = itemView.findViewById(R.id.txtListTitle);
        }
    }
}
