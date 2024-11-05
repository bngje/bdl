/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package raportdigital;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author ASUS
 */
public class Siswa extends javax.swing.JFrame {
private final Connection Connection;

    /**
     * Creates new form Siswa
     */
    public Siswa() throws SQLException {
        this.Connection = DatabaseConnection.getConnection();
        initComponents();
        id_auto();
        nomorinduk.setEditable(false);
        kelas.requestFocus();
        comboboxkelas(kelas);
        tampilkansiswa(siswaTable);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unch ecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nomorinduk = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nama = new javax.swing.JTextField();
        tempatlahir = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tanggallahir = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        alamatt = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jeniskelamin = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        siswaTable = new javax.swing.JTable();
        Insertbtn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        kelas = new javax.swing.JComboBox<>();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        clear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Input Siswa");

        jLabel2.setText("Nomor Induk");

        nomorinduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomorindukActionPerformed(evt);
            }
        });

        jLabel3.setText("Nama Siswa");

        jLabel4.setText("Tempat Lahir");

        nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaActionPerformed(evt);
            }
        });

        tempatlahir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tempatlahirActionPerformed(evt);
            }
        });

        jLabel5.setText("Tanggal Lahir");

        jLabel6.setText("Alamat");

        alamatt.setColumns(20);
        alamatt.setRows(5);
        jScrollPane1.setViewportView(alamatt);

        jLabel7.setText("Jenis Kelamin");

        jeniskelamin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "L", "P" }));

        siswaTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        siswaTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                siswaTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(siswaTable);

        Insertbtn.setText("Insert");
        Insertbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertbtnActionPerformed(evt);
            }
        });

        jLabel8.setText("Kelas");

        kelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kelasActionPerformed(evt);
            }
        });

        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        clear.setText("Clear");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(45, 45, 45)
                                .addComponent(tanggallahir, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(47, 47, 47)
                                .addComponent(tempatlahir, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(nomorinduk)
                                    .addComponent(nama)
                                    .addComponent(kelas, javax.swing.GroupLayout.Alignment.TRAILING, 0, 147, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(78, 78, 78))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(45, 45, 45)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(clear)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addComponent(jeniskelamin, 0, 147, Short.MAX_VALUE)))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Insertbtn)
                                .addGap(18, 18, 18)
                                .addComponent(update)
                                .addGap(18, 18, 18)
                                .addComponent(delete)))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(nomorinduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(kelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tempatlahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(tanggallahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jeniskelamin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Insertbtn)
                        .addComponent(update)
                        .addComponent(delete))
                    .addComponent(clear))
                .addGap(31, 31, 31))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void InsertbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertbtnActionPerformed
        // TODO add your handling code here:        
        try {
        String nomor = nomorinduk.getText();
        String namaKelas = (String) kelas.getSelectedItem(); // Ambil nama_kelas dari ComboBox
        String namaa = nama.getText();
        String tempat = tempatlahir.getText();
        Date tanggall = tanggallahir.getDate();
        String alamat = alamatt.getText();
        String jk = (String) jeniskelamin.getSelectedItem();

        Connection connection = DatabaseConnection.getConnection();

        // Query untuk mengambil id_kelas berdasarkan nama_kelas
        String queryKelas = "SELECT id_kelas FROM kelas WHERE nama_kelas = ?";
        PreparedStatement psKelas = connection.prepareStatement(queryKelas);
        psKelas.setString(1, namaKelas);
        ResultSet rsKelas = psKelas.executeQuery();
        String idKelas = ""; // Menggunakan tipe data String

        if (rsKelas.next()) {
            idKelas = rsKelas.getString("id_kelas"); // Ambil id_kelas sebagai String
        } else {
            // Jika id_kelas tidak ditemukan, beri peringatan dan hentikan proses
            JOptionPane.showMessageDialog(null, "Kelas tidak ditemukan!");
            return;
        }

        // Query untuk memasukkan data siswa
        String query = "INSERT INTO siswa (nisn, id_kelas, nama_siswa, tempat_lahir, tanggal_lahir, alamat, jenis_kelamin_siswa) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, nomor);
        ps.setString(2, idKelas); // Masukkan id_kelas
        ps.setString(3, namaa);
        ps.setString(4, tempat);
        ps.setDate(5, new java.sql.Date(tanggall.getTime())); // Ubah ke java.sql.Date
        ps.setString(6, alamat);
        ps.setString(7, jk);

        ps.executeUpdate();
        
        tampilkansiswa(siswaTable);
        nama.setText("");
        tempatlahir.setText("");
        Date date = null;
        tanggallahir.setDate(date);
        alamatt.setText("");
        this.id_auto();

        JOptionPane.showMessageDialog(null, "Data berhasil disimpan!");
        tampilkansiswa(siswaTable);
    } catch(SQLException e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
    }//GEN-LAST:event_InsertbtnActionPerformed

    private void namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaActionPerformed

    private void tempatlahirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tempatlahirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tempatlahirActionPerformed

    private void nomorindukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomorindukActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_nomorindukActionPerformed

    private void kelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kelasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kelasActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        try {
            String nisnn = !nomorinduk.getText().trim().isEmpty() ? nomorinduk.getText().trim() : siswaTable.getValueAt(siswaTable.getSelectedRow(), 0).toString();
            String sql = "delete from siswa where nisn = ?";
            PreparedStatement ps = Connection.prepareStatement(sql);
            ps.setString(1, nisnn);
            ps.execute();
            tampilkansiswa(siswaTable);
            nama.setText("");
            tempatlahir.setText("");
            Date date = null;
            tanggallahir.setDate(date);
            alamatt.setText("");
            
            this.id_auto();

            JOptionPane.showMessageDialog(this, "Data behasil dihapus");
        } catch (SQLException | ArrayIndexOutOfBoundsException ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
        String nisnn = nomorinduk.getText();
        String kelass = (String) kelas.getSelectedItem();
        String namaa = nama.getText();
        String tempatlahirr = tempatlahir.getText();
        Date tanggall = tanggallahir.getDate();
        String alamat = alamatt.getText();
        String jk = (String) jeniskelamin.getSelectedItem();
        try {
            final String sql = "Update siswa set id_kelas= ?, nama_siswa= ?, tempat_lahir= ?, tanggal_lahir= ?, alamat= ?, jenis_kelamin_siswa= ? where nisn= ?";
            final PreparedStatement pst = Connection.prepareStatement(sql);

            pst.setString(1, kelass);
            pst.setString(2, namaa);
            pst.setString(3, tempatlahirr);
            pst.setDate(4, (java.sql.Date) tanggall);
            pst.setString(5, alamat);
            pst.setString(6, jk);
            pst.setString(7, nisnn);
            pst.executeUpdate();

            this.id_auto();

            JOptionPane.showMessageDialog(this, "Berhasil Memperbarui");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal Memperbarui, karena:" + e.getMessage());
        }
    }//GEN-LAST:event_updateActionPerformed

    private void siswaTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_siswaTableMouseClicked
        // TODO add your handling code here:
        int row = siswaTable.getSelectedRow();
        nomorinduk.setText(siswaTable.getValueAt(row, 0).toString());
        kelas.setSelectedItem(siswaTable.getValueAt(row, 1).toString());
        nama.setText(siswaTable.getValueAt(row, 2).toString());
        tempatlahir.setText(siswaTable.getValueAt(row, 3).toString());
        
        try {
        String tanggal = siswaTable.getValueAt(row, 4).toString(); // Mendapatkan nilai tanggal
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Format tanggal (sesuaikan dengan format di database)
        Date date = dateFormat.parse(tanggal); // Parsing String menjadi Date
        tanggallahir.setDate(date); // Set nilai ke JDateChooser
        } catch (ParseException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error parsing tanggal lahir: " + e.getMessage());
        }
        
        alamatt.setText(siswaTable.getValueAt(row, 5).toString());
        jeniskelamin.setSelectedItem(siswaTable.getValueAt(row, 6).toString());
    }//GEN-LAST:event_siswaTableMouseClicked

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        // TODO add your handling code here:
        tampilkansiswa(siswaTable);
        nama.setText("");
        tempatlahir.setText("");
        Date date = null;
        tanggallahir.setDate(date);
        alamatt.setText("");
        this.id_auto();
    }//GEN-LAST:event_clearActionPerformed
    
    public final void id_auto() {
        try {
            final Statement stat = Connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            final String sql = "select max (cast(substring(nisn, 2,4)as integer)) as no from siswa";
            final ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                if (rs.getInt("no") == 0) {
                    nomorinduk.setText("S0001");
                } else {
                    int set_id = rs.getInt("no") + 1;
                    String no = String.valueOf(set_id);
                    while (no.length() < 4) {
                        no = "0" + no;
                    }
                    nomorinduk.setText("S" + no);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Siswa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void comboboxkelas(JComboBox<String> kelas) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            connection = DatabaseConnection.getConnection();
            String query = "SELECT * FROM kelas";
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery(); // Menjalankan query dan mendapatkan ResultSet
            kelas.removeAllItems(); // 'kelas' adalah nama ComboBox di 'dashboard.java'
            while (rs.next()) {
                String namaKelas = rs.getString("nama_kelas");
                kelas.addItem(namaKelas);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    
    private void tampilkansiswa(JTable tablesiswa){
        try{
        String sql = "Select siswa.nisn, kelas.nama_kelas, siswa    .nama_siswa, siswa.tempat_lahir, siswa.tanggal_lahir, siswa.alamat, siswa.jenis_kelamin_siswa "
                   + "From siswa "
                   + "Join kelas on siswa.id_kelas = kelas.id_kelas order by nisn";
        PreparedStatement pst = Connection.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        
        DefaultTableModel model = new DefaultTableModel();
        
        model.addColumn("Nomor Induk");
        model.addColumn("Kelas");
        model.addColumn("Nama Siswa");
        model.addColumn("Tempat Lahir");
        model.addColumn("Tanggal Lahir");
        model.addColumn("Alamat");
        model.addColumn("Jenis Kelamin");
        
        while (rs.next()){
            Object[] rowData = new Object[7];
            rowData[0] = rs.getString("nisn");
            rowData[1] = rs.getString("nama_kelas");
            rowData[2] = rs.getString("nama_siswa");
            rowData[3] = rs.getString("tempat_lahir");
            rowData[4] = rs.getString("tanggal_lahir");
            rowData[5] = rs.getString("alamat");
            rowData[6] = rs.getString("jenis_kelamin_siswa");
            
            model.addRow(rowData);
        }
        siswaTable.setModel(model);
        }
        catch(SQLException e){
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "ERROR" + e.getMessage());
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Siswa().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Siswa.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Insertbtn;
    private javax.swing.JTextArea alamatt;
    private javax.swing.JButton clear;
    private javax.swing.JButton delete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> jeniskelamin;
    private javax.swing.JComboBox<String> kelas;
    private javax.swing.JTextField nama;
    private javax.swing.JTextField nomorinduk;
    private javax.swing.JTable siswaTable;
    private com.toedter.calendar.JDateChooser tanggallahir;
    private javax.swing.JTextField tempatlahir;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
