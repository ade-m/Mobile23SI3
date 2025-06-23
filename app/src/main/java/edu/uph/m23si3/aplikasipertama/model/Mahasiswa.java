package edu.uph.m23si3.aplikasipertama.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Mahasiswa extends RealmObject {
    @PrimaryKey
    private  int studentID;
    private String nama,jenisKelamin,prodi,hobi;
    private Double nilaiBisnis,nilaiMobile;

    public Mahasiswa() {
    }

    public Mahasiswa(String hobi, String jenisKelamin, String nama, Double nilaiBisnis, Double nilaiMobile, String prodi, int studentID) {
        this.hobi = hobi;
        this.jenisKelamin = jenisKelamin;
        this.nama = nama;
        this.nilaiBisnis = nilaiBisnis;
        this.nilaiMobile = nilaiMobile;
        this.prodi = prodi;
        this.studentID = studentID;
    }

    public String getHobi() {
        return hobi;
    }

    public void setHobi(String hobi) {
        this.hobi = hobi;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Double getNilaiBisnis() {
        return nilaiBisnis;
    }

    public void setNilaiBisnis(Double nilaiBisnis) {
        this.nilaiBisnis = nilaiBisnis;
    }

    public Double getNilaiMobile() {
        return nilaiMobile;
    }

    public void setNilaiMobile(Double nilaiMobile) {
        this.nilaiMobile = nilaiMobile;
    }

    public String getProdi() {
        return prodi;
    }

    public void setProdi(String prodi) {
        this.prodi = prodi;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    @Override
    public String toString() {
        return "Mahasiswa{" +
                "hobi='" + hobi + '\'' +
                ", studentID='" + studentID + '\'' +
                ", nama='" + nama + '\'' +
                ", jenisKelamin='" + jenisKelamin + '\'' +
                ", prodi='" + prodi + '\'' +
                ", nilaiBisnis=" + nilaiBisnis +
                ", nilaiMobile=" + nilaiMobile +
                '}';
    }
}
