package edu.uph.m23si3.aplikasipertama.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import edu.uph.m23si3.aplikasipertama.R;
import edu.uph.m23si3.aplikasipertama.model.Mahasiswa;
import io.realm.Realm;

public class MahasiswaAdapter extends ArrayAdapter<Mahasiswa> {
    public MahasiswaAdapter(@NonNull Context context, ArrayList<Mahasiswa> arrayList) {

        // pass the context and arrayList for the super
        // constructor of the ArrayAdapter class
        super(context, 0, arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // convertView which is recyclable view
        View currentItemView = convertView;

        // of the recyclable view is null then inflate the custom layout for the same
        if (currentItemView == null) {
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.layoutmahasiiswa, parent,
                    false);
        }

        // get the position of the view from the ArrayAdapter
        Mahasiswa currentNumberPosition = getItem(position);

        // then according to the position of the view assign the desired image for the same
        ImageView numbersImage = currentItemView.findViewById(R.id.imvUser);
        assert currentNumberPosition != null;
        if(currentNumberPosition.getJenisKelamin().equals("Wanita")){
            numbersImage.setImageResource(R.drawable.user3);
        }
        else  numbersImage.setImageResource(R.drawable.user2);
        //numbersImage.setImageResource(currentNumberPosition.getNumbersImageId());

        // then according to the position of the view assign the desired TextView 1 for the same
        TextView textView1 = currentItemView.findViewById(R.id.txvNama);
        textView1.setText(currentNumberPosition.getNama());

        // then according to the position of the view assign the desired TextView 2 for the same
        TextView textView2 = currentItemView.findViewById(R.id.txvProdi);
        textView2.setText(currentNumberPosition.getProdi());

        ImageView imvdelete = currentItemView.findViewById(R.id.imvDelete);
        imvdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteMahasiswa(currentNumberPosition.getStudentID());
            }
        });

        // then return the recyclable view
        return currentItemView;
    }
    private void deleteMahasiswa(long id) {
        Realm realm = Realm.getDefaultInstance();
        Mahasiswa mhs = realm.where(Mahasiswa.class).equalTo("studentID", id).findFirst();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                mhs.deleteFromRealm();
                remove(mhs);
                notifyDataSetChanged();
            }
        });
    }
}
