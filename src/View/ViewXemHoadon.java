/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Hoadon;
import Model.Mathang;
import java.math.BigDecimal;
import javafx.util.Pair;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PRINCE D. TOAD
 */
public class ViewXemHoadon extends javax.swing.JFrame {
    private DefaultTableModel defaultTableModel;
    private Hoadon hd;
    /**
     * Creates new form ViewXemHoadon
     */
    public ViewXemHoadon(Hoadon hd) {
        initComponents();
        
        this.hd = hd;
        txtMaHD.setText(String.valueOf(hd.getMaHD()));
        txtTenKH.setText(hd.getKhachhang().getHoten());
        txtNgaytao.setText(hd.getNgaytao());
        BigDecimal bigTongtien = new BigDecimal(hd.getTongTien());
        bigTongtien = bigTongtien.add(BigDecimal.ZERO);
        txtTongtien.setText(String.valueOf(bigTongtien));
        
        loadHD();
    }
    
    private void loadHD(){
        defaultTableModel = (DefaultTableModel) tblMH.getModel();
        tblMH.setModel(defaultTableModel);
        
        for(Pair<Mathang, Integer> slmh : hd.getListMH()){
            int stt = 0;
            BigDecimal bigTongTien = new BigDecimal(slmh.getValue()
                    *slmh.getKey().getGiaban());
            defaultTableModel.addRow(new Object[]{
                ++stt,
                slmh.getKey().getMaMH(),
                slmh.getKey().getTenMH(),
                slmh.getValue(),
                bigTongTien
            });
        }
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
        jLabel1 = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JLabel();
        txtTenKH = new javax.swing.JLabel();
        txtNgaytao = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMH = new javax.swing.JTable();
        txtTongtien = new javax.swing.JLabel();
        btnOK = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Chi tiet hoa don");

        txtMaHD.setText("ma hoa don");

        txtTenKH.setText("ten nguoi mua");

        txtNgaytao.setText("ngay tao hoa don");

        tblMH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Ma MH", "Ten MH", "So luong mua", "Gia tien"
            }
        ));
        jScrollPane1.setViewportView(tblMH);

        txtTongtien.setText("tong tien");

        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtTongtien)
                .addGap(284, 284, 284))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(270, 270, 270)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNgaytao)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtTenKH)
                                        .addComponent(txtMaHD)))
                                .addGap(31, 31, 31))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(btnOK)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(txtMaHD)
                .addGap(18, 18, 18)
                .addComponent(txtTenKH)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNgaytao)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(txtTongtien)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(btnOK)
                .addGap(30, 30, 30))
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

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnOKActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMH;
    private javax.swing.JLabel txtMaHD;
    private javax.swing.JLabel txtNgaytao;
    private javax.swing.JLabel txtTenKH;
    private javax.swing.JLabel txtTongtien;
    // End of variables declaration//GEN-END:variables
}
