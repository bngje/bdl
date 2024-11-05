/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package raportdigital;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.swing.JComboBox;



/**
 *
 * @author ASUS
 */
public class Dashboard extends javax.swing.JFrame {

    Connection con;
    Statement stm;
    ResultSet rs;
    private final String nip;
    private HashMap<String, Double[]> nilaiSiswa;

 
    public Dashboard(String nip) {
        this.nip = nip;
        initComponents();
        
        Dimension layar = Toolkit.getDefaultToolkit().getScreenSize();
        int x = layar.width / 2 - this.getSize().width / 2;
        int y = layar.height / 2 - this.getSize().height / 2;
        this.setLocation(x,y);
        nilaiSiswa = new HashMap<>();       
        
        try{
            con = DatabaseConnection.getConnection();
            con.setAutoCommit(false);
            stm = con.createStatement();            
        }catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error setting auto-commit" + e.getMessage());
        }
        
        tampilkankelas(nip, kelas);
    }
    private void tampilkankelas(String nip, JComboBox<String> kelas) {
    String sql = "SELECT kelas.id_kelas, kelas.nama_kelas FROM kelas " 
            + "JOIN pengajaran ON kelas.id_kelas = pengajaran.id_kelas "
            + "WHERE pengajaran.nip = ?";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, nip);
        ResultSet rs = stmt.executeQuery();
        
        kelas.removeAllItems(); // 'kelas' adalah nama ComboBox di 'dashboard.java'
        kelas.addItem("Pilih Kelas");

        while (rs.next()) {
            String namaKelas = rs.getString("nama_kelas");
            kelas.addItem(namaKelas);
        }
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
}
    
    private void loadSiswaData(String namaKelas) {
    String query = "SELECT siswa.nisn, siswa.nama_siswa, nilai.tugas, nilai.uts, nilai.uas, nilai.hasil_akhir, nilai.predikat "
                 + "FROM siswa "
                 + "INNER JOIN kelas ON siswa.id_kelas = kelas.id_kelas "
                 + "LEFT JOIN nilai ON siswa.nisn = nilai.nisn "
                 + "WHERE kelas.nama_kelas = ? ORDER BY siswa";

    try {
        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, namaKelas); // Set ID kelas dari ComboBox

        ResultSet rs = ps.executeQuery();
        DefaultTableModel model = (DefaultTableModel) siswaTable.getModel();
        model.setRowCount(0); // Hapus data lama di tabel

        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getString("nisn"),
                rs.getString("nama_siswa"),
                rs.getDouble("tugas"),
                rs.getDouble("uts"),
                rs.getDouble("uas"),
                rs.getDouble("hasil_akhir"),
                rs.getString("predikat")// Kosong untuk input nilai tugas, UTS, UAS
            });
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error fetching data: " + e.getMessage());
    }
}
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tugas = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        kelas = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        siswaTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        uas = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        insert = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        uploadcomit = new javax.swing.JButton();
        uts = new javax.swing.JTextField();
        resetrollback = new javax.swing.JButton();
        cari = new javax.swing.JTextField();
        searchbtn = new javax.swing.JButton();
        deleterow = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel1.setText("Input Nilai");

        jLabel2.setText("Tugas");

        tugas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tugasActionPerformed(evt);
            }
        });

        jLabel3.setText("UTS");

        kelas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kelasMouseClicked(evt);
            }
        });
        kelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kelasActionPerformed(evt);
            }
        });

        siswaTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nomor Induk", "Nama Siswa", "Tugas", "UTS", "UAS", "Nilai Akhir", "Predikat"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        siswaTable.getTableHeader().setReorderingAllowed(false);
        siswaTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                siswaTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(siswaTable);

        jLabel4.setText("UAS");

        jLabel5.setText("Kelas");

        insert.setText("Insert");
        insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertActionPerformed(evt);
            }
        });

        delete.setText("Delete Data");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        uploadcomit.setText("Upload");
        uploadcomit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadcomitActionPerformed(evt);
            }
        });

        resetrollback.setText("Reset All");
        resetrollback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetrollbackActionPerformed(evt);
            }
        });

        searchbtn.setText("Cari");
        searchbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbtnActionPerformed(evt);
            }
        });

        deleterow.setText("Delete");
        deleterow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleterowActionPerformed(evt);
            }
        });

        jLabel6.setText("Cari Nama");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(resetrollback)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(delete)
                        .addGap(18, 18, 18)
                        .addComponent(uploadcomit))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(132, 132, 132)
                                .addComponent(searchbtn)
                                .addGap(160, 160, 160))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(46, 46, 46)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cari)
                                            .addComponent(tugas)
                                            .addComponent(kelas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(uts, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(uas, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(insert)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleterow)))
                        .addGap(17, 17, 17))
                    .addComponent(jScrollPane1))
                .addGap(23, 23, 23))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(271, 271, 271))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(kelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tugas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(uas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(41, 41, 41))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(uts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(insert)
                                .addComponent(deleterow))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(searchbtn)
                                .addComponent(jLabel6)))))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(uploadcomit)
                    .addComponent(delete)
                    .addComponent(resetrollback))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void kelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kelasActionPerformed
        // TODO add your handling code here:
         if (nilaiSiswa.isEmpty()) {
        String selectedKelas = (String) kelas.getSelectedItem(); // Ambil objek Kelas yang dipilih
                if (selectedKelas != null && !selectedKelas.equals("Pilih Kelas")) {
                    loadSiswaData(selectedKelas);
                }
        }else {
        // Jika ada data yang belum di-upload
        JOptionPane.showMessageDialog(null, "Silakan upload data terlebih dahulu sebelum pindah kelas.");
    }
        
    }//GEN-LAST:event_kelasActionPerformed

    private void insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertActionPerformed
      // Ambil NISN dari baris yang dipilih
    int selectedRow = siswaTable.getSelectedRow();
    
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(null, "Silakan pilih siswa dari tabel.");
        return; // Keluar dari metode jika tidak ada siswa yang dipilih
    }
    
    try {
        Double nltugas = Double.parseDouble(tugas.getText());
        Double nluts = Double.parseDouble(uts.getText());
        Double nluas = Double.parseDouble(uas.getText());
        
        // Hitung nilai akhir dan predikat
        double hasil_akhir = (nltugas + nluts + nluas) / 3;
        String predikat = hitungPredikat(hasil_akhir);
        
        // Ambil NISN dari baris yang dipilih
        String nisn = siswaTable.getValueAt(selectedRow, 0).toString();
        
        // Masukkan nilai ke dalam HashMap
        nilaiSiswa.put(nisn, new Double[]{nltugas, nluts, nluas, hasil_akhir});
        
        // Set nilai di tabel
        DefaultTableModel model = (DefaultTableModel) siswaTable.getModel();
        model.setValueAt(nltugas, selectedRow, 2);
        model.setValueAt(nluts, selectedRow, 3);
        model.setValueAt(nluas, selectedRow, 4);
        model.setValueAt(hasil_akhir, selectedRow, 5);
        model.setValueAt(predikat, selectedRow, 6);
        
        // Kosongkan input setelah insert
        tugas.setText("");
        uts.setText("");
        uas.setText("");
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Input nilai tidak valid: " + e.getMessage());
    }
    }//GEN-LAST:event_insertActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
         int selectedRow = siswaTable.getSelectedRow(); // Mengambil baris yang dipilih
    
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(null, "Pilih baris yang ingin dihapus.");
        return; // Tidak ada baris yang dipilih, keluar dari method
    }
    
    try {
        // Mendapatkan nilai nomor induk (misalnya NISN) dari tabel
        String nomorInduk = siswaTable.getValueAt(selectedRow, 0).toString(); // Kolom pertama untuk nomor induk

        // Konfirmasi penghapusan
        int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus nilai siswa ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            // Jika user mengonfirmasi, lakukan penghapusan di database
            String deleteSQL = "DELETE FROM nilai WHERE nisn = ?";
            PreparedStatement ps = con.prepareStatement(deleteSQL);
            
            ps.setString(1, nomorInduk); // Set nomor induk (misalnya NISN) di query

            int rowsDeleted = ps.executeUpdate(); // Returns number of rows deleted
            
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Nilai berhasil dihapus.");

                // Kosongkan nilai-nilai di kolom terkait di JTable tanpa menghapus baris
                DefaultTableModel model = (DefaultTableModel) siswaTable.getModel();
                model.setValueAt(0, selectedRow, 2); // Kosongkan kolom tugas
                model.setValueAt(0, selectedRow, 3); // Kosongkan kolom UTS
                model.setValueAt(0, selectedRow, 4); // Kosongkan kolom UAS
                model.setValueAt(0, selectedRow, 5); // Kosongkan kolom nilai akhir
                model.setValueAt("", selectedRow, 6); // Kosongkan kolom predikat
                
            } else {
                JOptionPane.showMessageDialog(null, "Data tidak ditemukan atau gagal dihapus.");
            }
        }
        tugas.setText("");
        uts.setText("");
        uas.setText("");
        cari.setText("");
        
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error saat menghapus data: " + e.getMessage());
        e.printStackTrace();
    }
        
    }//GEN-LAST:event_deleteActionPerformed

    private void tugasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tugasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tugasActionPerformed

    private void uploadcomitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadcomitActionPerformed
       try {
        // Begin transaction
        con.setAutoCommit(false);
        
        String selectSQL = "SELECT COUNT(*) FROM nilai WHERE nisn = ? AND nip = ?";
        PreparedStatement psSelect = con.prepareStatement(selectSQL);

        // Prepare INSERT statement
        String insertSQL = "INSERT INTO nilai (nisn, nip, tugas, uts, uas, hasil_akhir, predikat) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement psInsert = con.prepareStatement(insertSQL);

        // Prepare UPDATE statement
        String updateSQL = "UPDATE nilai SET tugas = ?, uts = ?, uas = ?, hasil_akhir = ?, predikat = ? WHERE nisn = ? AND nip = ?";
        PreparedStatement psUpdate = con.prepareStatement(updateSQL);

        // Iterate through the HashMap and check for each data
        for (Map.Entry<String, Double[]> entry : nilaiSiswa.entrySet()) {
            String nisn = entry.getKey();
            Double[] nilai = entry.getValue();

            // Check if the record already exists
            psSelect.setString(1, nisn);
            psSelect.setString(2, nip);
            ResultSet rs = psSelect.executeQuery();
            
            if (rs.next() && rs.getInt(1) > 0) {
                // If record exists, execute UPDATE
                psUpdate.setDouble(1, nilai[0]); // Tugas
                psUpdate.setDouble(2, nilai[1]); // UTS
                psUpdate.setDouble(3, nilai[2]); // UAS
                psUpdate.setDouble(4, nilai[3]); // Hasil Akhir
                psUpdate.setString(5, hitungPredikat(nilai[3])); // Predikat
                psUpdate.setString(6, nisn); // NISN for WHERE clause
                psUpdate.setString(7, nip);  // NIP for WHERE clause
                
                psUpdate.addBatch();
            } else {
                // If record does not exist, execute INSERT
                psInsert.setString(1, nisn);
                psInsert.setString(2, nip);
                psInsert.setDouble(3, nilai[0]); // Tugas
                psInsert.setDouble(4, nilai[1]); // UTS
                psInsert.setDouble(5, nilai[2]); // UAS
                psInsert.setDouble(6, nilai[3]); // Hasil Akhir
                psInsert.setString(7, hitungPredikat(nilai[3])); // Predikat

                psInsert.addBatch();
            }
        }

        // Execute batch for both insert and update
        psInsert.executeBatch();
        psUpdate.executeBatch();

        // Commit transaction
        con.commit();
        JOptionPane.showMessageDialog(null, "Data berhasil di Upload.");

        // Clear HashMap after upload
        nilaiSiswa.clear();
        tugas.setText("");
        uts.setText("");
        uas.setText("");
        cari.setText("");
        
    } catch (SQLException e) {
        try {
            // Rollback if there's an error
            if (con != null) con.rollback();
            JOptionPane.showMessageDialog(null, "Data gagal di Upload: " + e.getMessage());
        } catch (SQLException rollbackEx) {
            rollbackEx.printStackTrace();
        }
    } finally {
        try {
            con.setAutoCommit(true); // Reset auto-commit
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }//GEN-LAST:event_uploadcomitActionPerformed

    private void resetrollbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetrollbackActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) siswaTable.getModel();
        for(int i = 0; i < model.getRowCount();i++){
            model.setValueAt(0,i,2);
            model.setValueAt(0,i,3);
            model.setValueAt(0,i,4);
            model.setValueAt(0,i,5);
            model.setValueAt("",i,6);
            nilaiSiswa.clear();            
        }
//        try{
//        con = DatabaseConnection.getConnection();
//        con.rollback();
//        JOptionPane.showMessageDialog(null,"Mereset semua perubahan.");
//        }catch(SQLException e){
//            e.getStackTrace();
//            JOptionPane.showMessageDialog(null,"Gagal mereset data: " + e.getMessage());
//        }
    }//GEN-LAST:event_resetrollbackActionPerformed

    private void siswaTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_siswaTableMouseClicked
        // TODO add your handling code here:
        int row = siswaTable.getSelectedRow();

        String tugasValue = siswaTable.getValueAt(row, 2).toString();
        String utsValue = siswaTable.getValueAt(row, 3).toString();
        String uasValue = siswaTable.getValueAt(row, 4).toString();

        if (tugasValue != null && !tugasValue.equals("0.0")) {
            tugas.setText(tugasValue);
        } else {
            tugas.setText("");
        }
        if (utsValue != null && !utsValue.equals("0.0")) {
            uts.setText(utsValue);
        } else {
            uts.setText("");
        }
        if (uasValue != null && !uasValue.equals("0.0")) {
            uas.setText(uasValue);
        } else {
            uas.setText("");
        }
    }//GEN-LAST:event_siswaTableMouseClicked

    private void searchbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbtnActionPerformed
        // TODO add your handling code here:
        this.cari();
    }//GEN-LAST:event_searchbtnActionPerformed

    private void deleterowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleterowActionPerformed
        // TODO add your handling code here:
        int barisTerpilih = siswaTable.getSelectedRow();
    
        if (barisTerpilih != -1) { // Jika ada baris yang dipilih
            // Mendapatkan DefaultTableModel dari JTable
            DefaultTableModel model = (DefaultTableModel) siswaTable.getModel();

            // Set kolom yang ingin dikosongkan (kolom 2, 3, 4, 5, dan 6 dalam contoh ini)
            model.setValueAt(0, barisTerpilih, 2); // Tugas
            model.setValueAt(0, barisTerpilih, 3); // UTS
            model.setValueAt(0, barisTerpilih, 4); // UAS
            model.setValueAt(0, barisTerpilih, 5); // Hasil Akhir
            model.setValueAt("", barisTerpilih, 6); // Predikat

            JOptionPane.showMessageDialog(null, "Data baris terpilih berhasil dikosongkan.");
        tugas.setText("");
        uts.setText("");
        uas.setText("");
        cari.setText("");
        } else {
            // Jika tidak ada baris yang dipilih
            JOptionPane.showMessageDialog(null, "Pilih baris yang ingin dikosongkan.");
        }
    }//GEN-LAST:event_deleterowActionPerformed

    private void kelasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kelasMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_kelasMouseClicked
    
    private String hitungPredikat(double hasil_akhir){
        if (hasil_akhir >= 93){
            return "A";
        }else if (hasil_akhir >= 85){
            return "B";
        }else if (hasil_akhir >= 79){
            return "C";
        }else{
            return "D";
        }
    }
    
    public void cari() {
         // Query dengan placeholder untuk pencarian nama siswa menggunakan LIKE
    String sql = "SELECT siswa.nisn, siswa.nama_siswa, nilai.tugas, nilai.uts,nilai.uas, nilai.hasil_akhir, nilai.predikat " 
               + "FROM siswa " 
               + "INNER JOIN kelas ON siswa.id_kelas = kelas.id_kelas " 
               + "LEFT JOIN nilai ON siswa.nisn = nilai.nisn " 
               + "WHERE siswa.nama_siswa ILIKE ?";

    try {
        // Gunakan PreparedStatement untuk menangani parameter
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, "%" + cari.getText() + "%"); // Menggunakan wildcard % di depan dan belakang input

        ResultSet rs = ps.executeQuery();
        DefaultTableModel tbl = (DefaultTableModel) siswaTable.getModel();
        tbl.setRowCount(0);
        // Tambahkan hasil pencarian ke tabel
        while (rs.next()) {
            Object tugas = rs.getObject("tugas") != null ? rs.getObject("tugas") : 0;
            Object uts = rs.getObject("uts") != null ? rs.getObject("uts") : 0;
            Object uas = rs.getObject("uas") != null ? rs.getObject("uas") : 0;
            Object hasilAkhir = rs.getObject("hasil_akhir") != null ? rs.getObject("hasil_akhir") : 0;
            String predikat = rs.getString("predikat") != null ? rs.getString("predikat") : "";

            tbl.addRow(new Object[]{
                rs.getString("nisn"),
                rs.getString("nama_siswa"),
                tugas,
                uts,
                uas,
                hasilAkhir,
                predikat
            });
        }

        // Set model ke siswaTable setelah data selesai dimuat
        siswaTable.setModel(tbl);

    } catch (SQLException ex) {
        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
        
    /**
     * @param args the command line arguments
     */
    public void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard(nip).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cari;
    private javax.swing.JButton delete;
    private javax.swing.JButton deleterow;
    private javax.swing.JButton insert;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> kelas;
    private javax.swing.JButton resetrollback;
    private javax.swing.JButton searchbtn;
    private javax.swing.JTable siswaTable;
    private javax.swing.JTextField tugas;
    private javax.swing.JTextField uas;
    private javax.swing.JButton uploadcomit;
    private javax.swing.JTextField uts;
    // End of variables declaration//GEN-END:variables
}
