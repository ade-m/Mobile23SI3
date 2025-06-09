package edu.uph.m23si3.aplikasipertama;

import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProfilActivity extends AppCompatActivity {
    EditText edtNama,edtProdi,edtBisnis,edtMobile;
    Button btnSubmit;
    TextView txvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profil);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edtNama = findViewById(R.id.edtNama);
        edtProdi = findViewById(R.id.edtProdi);
        btnSubmit = findViewById(R.id.btnSumbit);
        txvHasil = findViewById(R.id.txvHasil);
        edtMobile = findViewById(R.id.edtMobile);
        edtBisnis = findViewById(R.id.edtBisnis);

        edtNama.setText(getIntent().getStringExtra("nama").toString());
        edtProdi.setText(getIntent().getStringExtra("prodi").toString());

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String nama = edtNama.getText().toString();
                String prodi = edtProdi.getText().toString();
                String fakultas = "Fakultas Teknologi Informasi";
                int nilaimobile=Integer.parseInt(edtMobile.getText().toString());
                int nilaibisnis=Integer.parseInt(edtBisnis.getText().toString());
                txvHasil.setText(toUpperCase(nama) + "\n Program Studi " + toUpperCase(prodi)
                        +"\n"+ toUpperCase(cekFakultas(prodi))+"\n IPK "+String.valueOf(hitungIPK(nilaibisnis,nilaimobile)));

                edtNama.setText("");
                edtProdi.setText("");
            }
        });
    }

    public double hitungIPK(int nilaiBisnis,int nilaiMobile){
        return (((getbobot(nilaiBisnis)*3)+(getbobot(nilaiMobile)*3))/6);
    }
    public double getbobot(int nilai){
        if(nilai>=90)
            return 4.0;
        else if(nilai>=80 && nilai<90)
            return 3.5;
        else if(nilai>=70 && nilai<80)
            return 3.0;
        else if(nilai>=60 && nilai<70)
            return 2.5;
        else if(nilai>=50 && nilai<60)
            return 2.0;
        else
            return 0.0;
    }
    public String cekFakultas(String prodi){
        if(prodi.toLowerCase().equals("sistem informasi") ||
                prodi.equals("si"))
            return "Fakultas Teknologi Informasi";
        else if (prodi.toLowerCase().equals("informatika")) {
            return "Fakultas Teknologi Informasi";
        }
        else if (prodi.toLowerCase().equals("akuntansi") ||
                prodi.toLowerCase().equals("manajemen")||
                prodi.toLowerCase().equals("perhotelan")) {
            return "Fakultas Ekonomi dan Bisnis";
        }
        else if (prodi.toLowerCase().equals("hukum")) {
            return "Fakultas Hukum";
        }
        else
            return "Fakultas Tidak Ditemukan";
    }

    public String toUpperCase(String str){
        return  str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public void bersihkanForm(){
        edtNama.setText("");
        edtProdi.setText("");
        edtBisnis.setText("");
        edtMobile.setText("");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_profil, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection.
        if(item.getItemId()==R.id.mBersihkanForm){
            bersihkanForm();
            return true;
        }else if(item.getItemId()==R.id.mPengaturan){

            return true;
        }
        else
            return super.onOptionsItemSelected(item);
    }
}