/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raportdigital;

/**
 *
 * @author ASUS
 */
public class Kelas {
    private String idKelas;
    private String namaKelas;

    public Kelas(String idKelas, String namaKelas) {
        this.idKelas = idKelas;
        this.namaKelas = namaKelas;
    }

    public String getIdKelas() {
        return idKelas;
    }

    @Override
    public String toString() {
        return namaKelas; // Mengembalikan nama_kelas untuk ditampilkan di ComboBox
    }
    
}

