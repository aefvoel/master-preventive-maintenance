package tiregdev.mpm.model;

/**
 * Created by Muhammad63 on 10/6/2017.
 */

public class PerawatanUnit {
    private String nama, alamat, email, telepon, jenisUnit, serialNumber, jamKerja, startBooking, finishBooking, noOrder, tglSubmit, status, jumlahOil, jumlahOilFilter, totalPart, totalBiaya;

    public PerawatanUnit(String nama, String alamat, String email, String telepon, String jenisUnit, String serialNumber, String jamKerja, String startBooking, String finishBooking, String noOrder, String tglSubmit, String status, String jumlahOil, String jumlahOilFilter, String totalPart, String totalBiaya) {
        this.nama = nama;
        this.alamat = alamat;
        this.email = email;
        this.telepon = telepon;
        this.jenisUnit = jenisUnit;
        this.serialNumber = serialNumber;
        this.jamKerja = jamKerja;
        this.startBooking = startBooking;
        this.finishBooking = finishBooking;
        this.noOrder = noOrder;
        this.tglSubmit = tglSubmit;
        this.status = status;
        this.jumlahOil = jumlahOil;
        this.jumlahOilFilter = jumlahOilFilter;
        this.totalPart = totalPart;
        this.totalBiaya = totalBiaya;
    }

    public PerawatanUnit() {

    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public String getJenisUnit() {
        return jenisUnit;
    }

    public void setJenisUnit(String jenisUnit) {
        this.jenisUnit = jenisUnit;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getJamKerja() {
        return jamKerja;
    }

    public void setJamKerja(String jamKerja) {
        this.jamKerja = jamKerja;
    }

    public String getStartBooking() {
        return startBooking;
    }

    public void setStartBooking(String startBooking) {
        this.startBooking = startBooking;
    }

    public String getFinishBooking() {
        return finishBooking;
    }

    public void setFinishBooking(String finishBooking) {
        this.finishBooking = finishBooking;
    }

    public String getNoOrder() {
        return noOrder;
    }

    public void setNoOrder(String noOrder) {
        this.noOrder = noOrder;
    }

    public String getTglSubmit() {
        return tglSubmit;
    }

    public void setTglSubmit(String tglSubmit) {
        this.tglSubmit = tglSubmit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getJumlahOil() {
        return jumlahOil;
    }

    public void setJumlahOil(String jumlahOil) {
        this.jumlahOil = jumlahOil;
    }

    public String getJumlahOilFilter() {
        return jumlahOilFilter;
    }

    public void setJumlahOilFilter(String jumlahOilFilter) {
        this.jumlahOilFilter = jumlahOilFilter;
    }

    public String getTotalPart() {
        return totalPart;
    }

    public void setTotalPart(String totalPart) {
        this.totalPart = totalPart;
    }

    public String getTotalBiaya() {
        return totalBiaya;
    }

    public void setTotalBiaya(String totalBiaya) {
        this.totalBiaya = totalBiaya;
    }
}
