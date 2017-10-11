package tiregdev.mpm.Model;

/**
 * Created by Muhammad63 on 10/6/2017.
 */

public class item_maintenance {

    private String nama, status;

    public item_maintenance(String nama, String status) {
        this.nama = nama;
        this.status = status;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
