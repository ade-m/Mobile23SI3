package edu.uph.m23si3.aplikasipertama;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

import java.util.ArrayList;

import edu.uph.m23si3.aplikasipertama.adapter.MahasiswaAdapter;
import edu.uph.m23si3.aplikasipertama.model.Mahasiswa;
import io.realm.Realm;
import io.realm.RealmResults;

public class DashboardActivity extends AppCompatActivity {
    LinearLayout llyBtnProfil;
    TextView txvNama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dashboard);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        llyBtnProfil = findViewById(R.id.llyBtnProfil);
        llyBtnProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toProfil();
            }
        });

        txvNama = findViewById(R.id.txvNama);
        Realm realm = Realm.getDefaultInstance();
        final ArrayList<Mahasiswa> arrayList = new ArrayList<>();

        RealmResults<Mahasiswa> results = realm.where(Mahasiswa.class).findAll();
        if (results != null) {
            arrayList.addAll(realm.copyFromRealm(results));
        }

        MahasiswaAdapter numbersArrayAdapter = new MahasiswaAdapter(this, arrayList);
        ListView numbersListView = findViewById(R.id.lsvMahasiswa);
        numbersListView.setAdapter(numbersArrayAdapter);
        results.addChangeListener(mhs -> numbersArrayAdapter.notifyDataSetChanged());

    }
    public void toProfil(){
        Intent intent = new Intent(this, ProfilActivity.class);
        intent.putExtra("prodi","Sistem Informasi");
        startActivity(intent);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}