package tiregdev.mpm.model;

/**
 * Created by Muhammad63 on 10/7/2017.
 */

public class Teknisi {
    private String nama, kode, umur, status, jabatan, rating, jadwal, biaya, history;

    public Teknisi(String nama, String kode, String umur, String status, String jabatan, String rating, String jadwal, String biaya, String history) {
        this.nama = nama;
        this.kode = kode;
        this.umur = umur;
        this.status = status;
        this.jabatan = jabatan;
        this.rating = rating;
        this.jadwal = jadwal;
        this.biaya = biaya;
        this.history = history;
    }
    public Teknisi(){

    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getUmur() {
        return umur;
    }

    public void setUmur(String umur) {
        this.umur = umur;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getJadwal() {
        return jadwal;
    }

    public void setJadwal(String jadwal) {
        this.jadwal = jadwal;
    }

    public String getBiaya() {
        return biaya;
    }

    public void setBiaya(String biaya) {
        this.biaya = biaya;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }
}
