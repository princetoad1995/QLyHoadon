/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Hoadon;
import Model.Khachhang;
import Model.Mathang;
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
import javafx.util.Pair;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PRINCE D. TOAD
 */
public class ViewThongkeMathang extends javax.swing.JFrame {

    List<Pair<Mathang, Integer>> listSLMH;

    /**
     * Creates new form ViewThongkeMathang
     */
    public ViewThongkeMathang() {
        initComponents();

        listSLMH = new ArrayList();
        readHD();

        Collections.sort(listSLMH, new Comparator<Pair<Mathang, Integer>>() {

            @Override
            public int compare(Pair<Mathang, Integer> o1, Pair<Mathang, Integer> o2) {
                if (o1.getKey().getGiaban() * o1.getValue() < o2.getKey().getGiaban() * o2.getValue()) {
                    return 1;
                } else if (o1.getKey().getGiaban() * o1.getValue() > o2.getKey().getGiaban() * o2.getValue()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        DefaultTableModel defaultTableModel = (DefaultTableModel) tblTK.getModel();
        tblTK.setModel(defaultTableModel);

        for (Pair<Mathang, Integer> slmh : listSLMH) {
            int stt = 0;
            BigDecimal bigGiaban = new BigDecimal(slmh.getKey().getGiaban()*slmh.getValue());
            defaultTableModel.addRow(new Object[]{
                ++stt,
                slmh.getKey().getTenMH(),
                slmh.getValue(),
                bigGiaban
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
            while ((line = bufferedReader.readLine()) != null) {
                if (line.equals("")) {
                    check = false;
                }
                if (dem == 1) {
//                    hd.setMaHD(Integer.parseInt(line));
                }
                if (dem == 2) {
//                    Khachhang kh = new Khachhang();
//                    kh.setHoten(line);
//                    hd.setKhachhang(kh);
                }
                if (dem == 3) {
//                    hd.setNgaytao(line);
                }
                if (dem > 3) {

                    // split de chia 1 chuoi thanh cac mang con
                    if (line.split("\\s").length > 1) { // mang cac mat hang
                        String[] words = line.split("\\s");
                        Mathang mh = new Mathang();
                        mh.setTenMH(words[0]);
                        mh.setGiaban(Float.parseFloat(words[2])/Float.parseFloat(words[1]));
                        Pair<Mathang, Integer> slmh = new Pair<Mathang, Integer>(
                                mh, Integer.parseInt(words[1]));
                        listSLMH.add(slmh);
                        
                    } else {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblTK = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblTK.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Ten MH", "So luong ban", "Gia"
            }
        ));
        jScrollPane1.setViewportView(tblTK);

        jButton1.setText("Quay lai");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(258, 258, 258))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTK;
    // End of variables declaration//GEN-END:variables
}
