import java.sql.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.event.*;
import koneksi.koneksi_db;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Acer
 */
public class DataSepatu extends javax.swing.JFrame {
   DefaultTableModel model = new DefaultTableModel();
    Toko toko;
    List record = new ArrayList();
    int baris;
    
    public DataSepatu() {
        initComponents();
        koneksi_db.getConnection();
        toko = new Data_TokoImpl();
        bedit.setEnabled(true);
        bdelete.setEnabled(true);
        bsave.setEnabled(true);
        bexit.setEnabled(true);
        isiFile();
        isi_data();
        lihat_data_tabel();
        kosongkan_data();
    }
     public void isi_data() {
        try {
            record = toko.getAll();
            Object isi[][] = new Object[record.size()][6];
            int x = 0;
            for (Iterator it = record.iterator(); it.hasNext();) {
                Data d = (Data) it.next();
                isi[x][0] = d.getKode();
                isi[x][1] = d.getWarna();
                isi[x][2] = d.getUkuran();
                isi[x][3] = d.getMerk();
                isi[x][4] = d.getJumlah();
                isi[x][5] = d.getHarga();
                x++;
            }
            String file[] = {"Kode", "Warna", "Ukuran", "Merk", "Jumlah", "Harga"};
            tbl_sepatu.setModel(new DefaultTableModel(isi, file));
            jScrollPane2.setViewportView(tbl_sepatu);
        } catch (SQLException t) {
            Logger.getLogger(DataSepatu.class.getName()).log(Level.SEVERE, null, t);
        }
    }

    public void lihat_data_tabel() {    

        tbl_sepatu.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                baris = tbl_sepatu.getSelectedRow();
                if (baris != -1) {
                    isiFile();
                }
            }
        });
    }

    public void isiFile() {
        Data d = (Data) record.get(baris);
        txtkd.setText(d.getKode());
        txtwar.setText(d.getWarna());
        txtuk.setText(d.getUkuran());
        txtme.setText(d.getMerk());
        txtjum.setText(String.valueOf(d.getJumlah()));
        txthar.setText(String.valueOf(d.getHarga()));
    }

    public void kosongkan_data() {
        txtkd.setText("");
        txtwar.setText("");
        txtuk.setText("");
        txtme.setText("");
        txtjum.setText("");
        txthar.setText("");
        txtttl.setText("");
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtttl = new javax.swing.JTextField();
        txtme = new javax.swing.JTextField();
        txtjum = new javax.swing.JTextField();
        txthar = new javax.swing.JTextField();
        txtkd = new javax.swing.JTextField();
        txtwar = new javax.swing.JTextField();
        txtuk = new javax.swing.JTextField();
        bpro = new javax.swing.JButton();
        bnew = new javax.swing.JButton();
        bsave = new javax.swing.JButton();
        bedit = new javax.swing.JButton();
        bdelete = new javax.swing.JButton();
        bexit = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_sepatu = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Yulia Shoes Store");

        jLabel2.setText("Kode");

        jLabel3.setText("Warna");

        jLabel4.setText("Ukuran");

        jLabel5.setText("Merk");

        jLabel6.setText("Jumlah");

        jLabel7.setText("Harga");

        jLabel8.setText("Total");

        bpro.setText("Proccess");
        bpro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bproActionPerformed(evt);
            }
        });

        bnew.setText("New");
        bnew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnewActionPerformed(evt);
            }
        });

        bsave.setText("Save");
        bsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsaveActionPerformed(evt);
            }
        });

        bedit.setText("Update");
        bedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beditActionPerformed(evt);
            }
        });

        bdelete.setText("Delete");
        bdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdeleteActionPerformed(evt);
            }
        });

        bexit.setText("Exit");
        bexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bexitActionPerformed(evt);
            }
        });

        tbl_sepatu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_sepatu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_sepatuMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_sepatu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bnew)
                                .addGap(18, 18, 18)
                                .addComponent(bsave)
                                .addGap(18, 18, 18)
                                .addComponent(bedit)
                                .addGap(18, 18, 18)
                                .addComponent(bdelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bexit)))
                        .addGap(50, 50, 50))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(271, 271, 271)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(20, 20, 20))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtwar)
                            .addComponent(txtuk)
                            .addComponent(txtkd, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(78, 78, 78)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(22, 22, 22)
                                .addComponent(txthar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtme, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txtjum, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bpro)
                            .addComponent(txtttl, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(65, 65, 65))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(txtkd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtwar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtuk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(txtme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtjum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(txthar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(txtttl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(bpro)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bexit)
                    .addComponent(bdelete)
                    .addComponent(bedit)
                    .addComponent(bsave)
                    .addComponent(bnew))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(298, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bnewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnewActionPerformed
        // TODO add your handling code here:
         kosongkan_data();
    }//GEN-LAST:event_bnewActionPerformed

    private void bsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsaveActionPerformed
        // TODO add your handling code here:
          try{
           com.mysql.jdbc.Statement statement = (com.mysql.jdbc.Statement)koneksi_db.getConnection().createStatement();
           statement.executeUpdate("insert into tbl_sepatu VALUES('"+txtkd.getText()+"','"+txtwar.getText()+"','"+txtuk.getText()+"','"+txtjum.getText()+"','"+txthar.getText()+"')");
           JOptionPane.showMessageDialog(null, "Data Berhasil disimpan");
           isiFile();
           isi_data();
           lihat_data_tabel();
       }catch (SQLException t){
           JOptionPane.showMessageDialog(null, "Data Gagal disimpan");
       }
    }//GEN-LAST:event_bsaveActionPerformed

    private void beditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beditActionPerformed
        // TODO add your handling code here:
        try {
            Data d = new Data();

            if (txtkd.getText().equals("") && txtwar.getText().equals("") && txtuk.getText().equals("") && txtme.getText().equals("") && txtjum.getText().equals("") && txthar.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "silahkan isi data yang akan diubah");
            } else {
                txtkd.setText(d.getKode());
                txtwar.setText(d.getWarna());
                txtuk.setText(d.getUkuran());
                txtme.setText(d.getMerk());
                txtjum.setText(String.valueOf(d.getJumlah()));
                txthar.setText(String.valueOf(d.getHarga()));
                isiFile();
                isi_data();
                kosongkan_data();
                JOptionPane.showMessageDialog(this, "data berhasil diubah");
            }
        }catch (Exception t) {
          JOptionPane.showMessageDialog(this, "data gagal diubah");
        }
    }//GEN-LAST:event_beditActionPerformed

    private void bdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdeleteActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            String kd = txtkd.getText();
            if (kd.equals("")) {
                JOptionPane.showMessageDialog(null, "Silahkan pilih yang akan dihapus");
            } else {
                toko.delete(String.valueOf(kd));
                isi_data();
                JOptionPane.showMessageDialog(this, "data berhasil dihapus");
                isiFile();
                kosongkan_data();
            }
        } catch (SQLException t) {
            JOptionPane.showMessageDialog(this, "data gagal dihapus");
        }
    }//GEN-LAST:event_bdeleteActionPerformed

    private void bexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bexitActionPerformed
        // TODO add your handling code here:
          if (JOptionPane.showConfirmDialog(null, "Yakin ingin keluar?", "Yakin?",
                JOptionPane.YES_NO_OPTION)
                 == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_bexitActionPerformed

    private void bproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bproActionPerformed
        // TODO add your handling code here:
         int Harga=Integer.parseInt(txthar.getText());
         int Jumlah=Integer.parseInt(txtjum.getText());
         int Total=Harga*Jumlah;
        txtttl.setText(""+ Total);
    }//GEN-LAST:event_bproActionPerformed

    private void tbl_sepatuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_sepatuMouseClicked
        // TODO add your handling code here:
         bedit.setEnabled(true);
         bdelete.setEnabled(true);
         bsave.setEnabled(true);
         bexit.setEnabled(true);
         bnew.setEnabled(false);
    }//GEN-LAST:event_tbl_sepatuMouseClicked

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
            java.util.logging.Logger.getLogger(DataSepatu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataSepatu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataSepatu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataSepatu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataSepatu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bdelete;
    private javax.swing.JButton bedit;
    private javax.swing.JButton bexit;
    private javax.swing.JButton bnew;
    private javax.swing.JButton bpro;
    private javax.swing.JButton bsave;
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
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tbl_sepatu;
    private javax.swing.JTextField txthar;
    private javax.swing.JTextField txtjum;
    private javax.swing.JTextField txtkd;
    private javax.swing.JTextField txtme;
    private javax.swing.JTextField txtttl;
    private javax.swing.JTextField txtuk;
    private javax.swing.JTextField txtwar;
    // End of variables declaration//GEN-END:variables
}