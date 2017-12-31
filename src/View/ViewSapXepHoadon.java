/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Hoadon;
import Model.Khachhang;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PRINCE D. TOAD
 */
public class ViewSapXepHoadon extends javax.swing.JFrame {

    private List<Hoadon> listHD;

    /**
     * Creates new form ViewSapXepHoadon
     */
    public ViewSapXepHoadon() {
        initComponents();

        listHD = new ArrayList<>();
        listHD = readHD();
        
        // sap xep tien hoa don giam dan
        Collections.sort(listHD, new Comparator<Hoadon>() {
            @Override
            public int compare(Hoadon o1, Hoadon o2) {
                if (o1.getTongTien() < o2.getTongTien()) {
                    return 1;
                } else if (o1.getTongTien() > o2.getTongTien()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        
        loadListHD();
    }

    private void loadListHD() {
        DefaultTableModel defaultTableModel = (DefaultTableModel) tblHD.getModel();
        tblHD.setModel(defaultTableModel);

        for (Hoadon hd : listHD) {
            int stt = 0;
            BigDecimal bigTongTien = new BigDecimal(hd.getTongTien());
            defaultTableModel.addRow(new Object[]{
                ++stt,
                hd.getMaHD(),
                hd.getKhachhang().getHoten(),
                bigTongTien
            });
        }

    }

    private List<Hoadon> readHD() {
        List<Hoadon> listHD = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(new File("HD.INP"));
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            int dem = 1;
            boolean check = true;
            Hoadon hd = new Hoadon();
            while ((line = bufferedReader.readLine()) != null) {
                if (line.equals("")) {
                    check = false;
                }
                if (dem == 1) {
                    hd.setMaHD(Integer.parseInt(line));
                }
                if (dem == 2) {
                    Khachhang kh = new Khachhang();
                    kh.setHoten(line);
                    hd.setKhachhang(kh);
                }
                if (dem == 3) {
                    hd.setNgaytao(line);
                }
                if (dem > 3) {
                    // split de chia 1 chuoi thanh cac mang con
                    if (line.split("\\s").length == 1) { // gia tien cuoi cung la mang 1 phan tu
                        hd.setTongTien(Float.parseFloat(line));
                        listHD.add(hd);
                        hd = new Hoadon();
                        dem = 0;
                    }
                }
                dem++;
            }

            fileReader.close();
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ViewMenu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ViewMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listHD;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHD = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Ma HD", "Ten KH", "Tong tien"
            }
        ));
        jScrollPane1.setViewportView(tblHD);

        jButton1.setText("Quay lai");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(253, 253, 253)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jButton1)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblHD;
    // End of variables declaration//GEN-END:variables
}
