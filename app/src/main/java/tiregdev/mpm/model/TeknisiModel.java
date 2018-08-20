package tiregdev.mpm.model;

/**
 * Created by Muhammad63 on 10/5/2017.
 */

public class TeknisiModel {

    private String nama, kode, jabatan;
    private int img;

    public TeknisiModel(String nama, String kode, String jabatan, int img) {
        this.nama = nama;
        this.kode = kode;
        this.jabatan = jabatan;
        this.img = img;
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

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
