package com.ziadsyahrul.provinsidiindonesia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Adapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecycleActivity extends AppCompatActivity {

    //TODO 1 mengenerate butterknife untuk recycleview
    @BindView(R.id.my_recycler_view)
    RecyclerView myRecyclerView;

    //TODO 2 membuat variable array untuk menampung data nama,detail dan gambar dari String Array pada
    String[] namaProvinsi;
    String[] detailProvinsi;
    int[] gambarProvinsi;

    com.ziadsyahrul.provinsidiindonesia.Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);
        ButterKnife.bind(this);

        //TODO 3 Mengisi variable array dari folder -> Strings,drawable
        namaProvinsi = getResources().getStringArray(R.array.provinsi_name);
        detailProvinsi = getResources().getStringArray(R.array.detail_provinsi);
        gambarProvinsi = new int[]{R.drawable.aceh, R.drawable.sumatera_utara, R.drawable.sumatera_barat, R.drawable.riau, R.drawable.jambi, R.drawable.sumatera_selatan, R.drawable.bengkulu, R.drawable.lampung, R.drawable.kepulauan_bangka_belitung,R.drawable.kepulauan_riau,R.drawable.banten,R.drawable.dki_jakarta,R.drawable.jawa_barat,R.drawable.di_yogyakarta,R.drawable.jawa_tengah,R.drawable.jawa_timur,R.drawable.ntt,R.drawable.ntb,R.drawable.kalimantan_barat,R.drawable.kalimantan_tengah,R.drawable.kalimantan_selatan,R.drawable.kalimantan_timur,R.drawable.kalimantan_utara,R.drawable.gorontalo,R.drawable.sulawesi_utara,R.drawable.sulawesi_tengah,R.drawable.sulawesi_barat,R.drawable.sulawesi_selatan,R.drawable.sulawesi_tenggara,R.drawable.maluku,R.drawable.maluku_utara,R.drawable.papua,R.drawable.papua_barat};

        //TODO 4 Membuat object adpater dan mengirim data nama,detail dan gambar ke adapter
        adapter = new com.ziadsyahrul.provinsidiindonesia.Adapter(RecycleActivity.this, gambarProvinsi, namaProvinsi, detailProvinsi);
        //TODO 5 Mensetting recyclerview dan mengeset recycleview dengan adapter
        myRecyclerView.setHasFixedSize(true);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(RecycleActivity.this));
        myRecyclerView.setAdapter((RecyclerView.Adapter) adapter);

    }
}