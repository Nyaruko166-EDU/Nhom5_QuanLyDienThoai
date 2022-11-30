/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.fpt.it17326.nhom5.view;

import com.fpt.it17326.nhom5.domainmodel.Chip;
import com.fpt.it17326.nhom5.domainmodel.HangDienThoai;
import com.fpt.it17326.nhom5.domainmodel.MauSac;
import com.fpt.it17326.nhom5.domainmodel.Pin;
import com.fpt.it17326.nhom5.domainmodel.Ram;
import com.fpt.it17326.nhom5.domainmodel.Rom;
import com.fpt.it17326.nhom5.response.ChipResponse;
import com.fpt.it17326.nhom5.response.HangDienThoaiResponse;
import com.fpt.it17326.nhom5.response.MauSacResponse;
import com.fpt.it17326.nhom5.response.PinResponse;
import com.fpt.it17326.nhom5.response.RamResponse;
import com.fpt.it17326.nhom5.response.RomResponse;
import com.fpt.it17326.nhom5.response.SanPhamResponse;
import com.fpt.it17326.nhom5.service.ChipService;
import com.fpt.it17326.nhom5.service.HangDienThoaiService;
import com.fpt.it17326.nhom5.service.MauSacService;
import com.fpt.it17326.nhom5.service.PinService;
import com.fpt.it17326.nhom5.service.RamService;
import com.fpt.it17326.nhom5.service.RomService;
import com.fpt.it17326.nhom5.service.impl.ChipServiceImpl;
import com.fpt.it17326.nhom5.service.impl.HangDienThoaiServiceImpl;
import com.fpt.it17326.nhom5.service.impl.MauSacServiceImpl;
import com.fpt.it17326.nhom5.service.impl.PinServiceImpl;
import com.fpt.it17326.nhom5.service.impl.RamServiceImpl;
import com.fpt.it17326.nhom5.service.impl.RomServiceImpl;
import com.fpt.it17326.nhom5.util.Util;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author youngboizseetinh
 */
public class DemoDialog extends javax.swing.JDialog {

    private ChipService chipService;
    private RamService ramService;
    private RomService romService;
    private PinService pinService;
    private HangDienThoaiService hangDienThoaiService;
    private MauSacService mauSacService;

    /**
     * Creates new form DemoDialog
     */
    public DemoDialog(java.awt.Frame parent, boolean modal, String title, String[] headers, String ma, String ten) {
        super(parent, modal);
        initComponents();
        initService();
        if (headers != null) {
            setHeaderColumn(headers);
        }
        lblTitle.setText(title);
        lblMa.setText(ma);
        lblTen.setText(ten);
        loadData();
        setScreenCenter();
    }

    public void initService() {
        chipService = new ChipServiceImpl();
        ramService = new RamServiceImpl();
        romService = new RomServiceImpl();
        pinService = new PinServiceImpl();
        hangDienThoaiService = new HangDienThoaiServiceImpl();
        mauSacService = new MauSacServiceImpl();
    }

    public void loadData() {
        String txt = lblTitle.getText();
        if (txt.equalsIgnoreCase("chip")) {
            getAllChip();
        } else if (txt.equalsIgnoreCase("Ram")) {
            getAllRam();
        } else if (txt.equalsIgnoreCase("Rom")) {
            getAllRom();
        } else if (txt.equalsIgnoreCase("Pin")) {
            getAllPin();
        } else if (txt.equalsIgnoreCase("Hãng")) {
            getAllHangDT();
        } else if (txt.equalsIgnoreCase("Màu sắc")) {
            getAllMauSac();
        }
    }

    public void setHeaderColumn(String[] headers) {
        DefaultTableModel dtm = (DefaultTableModel) tblSetting.getModel();
        DefaultTableModel dtmLuuTru = (DefaultTableModel) tblLuuTru.getModel();
        dtm.setColumnIdentifiers(headers);
        dtmLuuTru.setColumnIdentifiers(headers);
    }

    public void setScreenCenter() {
        final Toolkit toolkit = Toolkit.getDefaultToolkit();
        final Dimension screenSize = toolkit.getScreenSize();
        final int x = (screenSize.width - this.getWidth()) / 2 - 100;
        final int y = (screenSize.height - this.getHeight()) / 2;
        this.setLocation(x, y);
        this.setVisible(true);
    }

    public void getAllChip() {
        List<ChipResponse> listChip = chipService.getAll();
        ArrayList<Object[]> rows = new ArrayList<>();
        for (ChipResponse chipResponse : listChip) {
            Object[] row = {chipResponse.getMaChip(), chipResponse.getTenChip(),};
            rows.add(row);
        }
        loadTableSPChiTiet(rows);
    }

    public void getAllRom() {
        List<RomResponse> listRom = romService.getAll();
        ArrayList<Object[]> rows = new ArrayList<>();
        for (RomResponse romResponse : listRom) {
            Object[] row = {romResponse.getMaRom(), romResponse.getTenRom(),};
            rows.add(row);
        }
        loadTableSPChiTiet(rows);
    }

    public void getAllRam() {
        List<RamResponse> listRam = ramService.getAll();
        ArrayList<Object[]> rows = new ArrayList<>();
        for (RamResponse ramResponse : listRam) {
            Object[] row = {ramResponse.getMaRam(), ramResponse.getDungLuong(),};
            rows.add(row);
        }
        loadTableSPChiTiet(rows);
    }

    public void getAllPin() {
        List<PinResponse> listPin = pinService.getAll();
        ArrayList<Object[]> rows = new ArrayList<>();
        for (PinResponse pinResponse : listPin) {
            Object[] row = {pinResponse.getMaPin(), pinResponse.getTenPin(),};
            rows.add(row);
        }
        loadTableSPChiTiet(rows);
    }

    public void getAllHangDT() {
        List<HangDienThoaiResponse> listHangDT = hangDienThoaiService.getAll();
        ArrayList<Object[]> rows = new ArrayList<>();
        for (HangDienThoaiResponse hangDienThoaiResponse : listHangDT) {
            Object[] row = {hangDienThoaiResponse.getMaHangDT(), hangDienThoaiResponse.getTenHang(),};
            rows.add(row);
        }
        loadTableSPChiTiet(rows);
    }

    public void getAllMauSac() {
        List<MauSacResponse> listMauSac = mauSacService.getAll();
        ArrayList<Object[]> rows = new ArrayList<>();
        for (MauSacResponse mauSacService : listMauSac) {
            Object[] data = {mauSacService.getMaMauSac(), mauSacService.getTenMauSac(),};
            rows.add(data);
        }
        loadTableSPChiTiet(rows);
    }

    public void loadTableSPChiTiet(ArrayList<Object[]> rows) {
        DefaultTableModel dtm = (DefaultTableModel) tblSetting.getModel();
        dtm.setRowCount(0);
        for (Object[] data : rows) {
            dtm.addRow(data);
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

        lblTitle = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        lblMa = new javax.swing.JLabel();
        lblTen = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSetting = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblLuuTru = new javax.swing.JTable();
        btnRestore = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        lblTitle.setText("Chip");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        lblMa.setText("Mã Chip");

        lblTen.setText("Tên Chip");

        btnThem.setIcon(new javax.swing.ImageIcon("D:\\Study\\FALL_2022\\PRO1041_DuAn1\\OnTap\\QuanLyDienThoaiNhom5\\Nhom5_QuanLyDienThoai\\images\\add.png")); // NOI18N
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setIcon(new javax.swing.ImageIcon("D:\\Study\\FALL_2022\\PRO1041_DuAn1\\OnTap\\QuanLyDienThoaiNhom5\\Nhom5_QuanLyDienThoai\\images\\update.png")); // NOI18N
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setIcon(new javax.swing.ImageIcon("D:\\Study\\FALL_2022\\PRO1041_DuAn1\\OnTap\\QuanLyDienThoaiNhom5\\Nhom5_QuanLyDienThoai\\images\\delete.png")); // NOI18N
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        tblSetting.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã", "Tên"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSetting.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSettingMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSetting);
        if (tblSetting.getColumnModel().getColumnCount() > 0) {
            tblSetting.getColumnModel().getColumn(0).setResizable(false);
            tblSetting.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTen, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMa, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMa)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTen)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSua)
                    .addComponent(btnThem)
                    .addComponent(btnXoa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Chi Tiết", jPanel1);

        jLabel1.setText("Tìm Kiếm");

        btnSearch.setIcon(new javax.swing.ImageIcon("D:\\Study\\FALL_2022\\PRO1041_DuAn1\\OnTap\\QuanLyDienThoaiNhom5\\Nhom5_QuanLyDienThoai\\images\\search.png")); // NOI18N
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        tblLuuTru.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Tên"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblLuuTru);
        if (tblLuuTru.getColumnModel().getColumnCount() > 0) {
            tblLuuTru.getColumnModel().getColumn(0).setResizable(false);
            tblLuuTru.getColumnModel().getColumn(1).setResizable(false);
        }

        btnRestore.setIcon(new javax.swing.ImageIcon("D:\\Study\\FALL_2022\\PRO1041_DuAn1\\OnTap\\QuanLyDienThoaiNhom5\\Nhom5_QuanLyDienThoai\\images\\restore.png")); // NOI18N
        btnRestore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestoreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRestore, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTimKiem))
                    .addComponent(btnRestore))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Lưu Trữ", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(199, 199, 199)
                .addComponent(lblTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void updateChip() {
        String ma = txtMa.getText();
        String ten = txtTen.getText();
        Chip chip = Chip.builder()
                .maChip(ma)
                .tenChip(ten)
                .deleted(false)
                .updatedAt(Util.getCurrentDate())
                .build();
        String result = chipService.update(chip);
        JOptionPane.showMessageDialog(this, result);
        if (result.contains("thành công")) {
            loadData();
        }
    }

    public void updateRam() {
        String ma = txtMa.getText();
        String ten = txtTen.getText();
        Ram ram = new Ram();
        ram.setMaRam(ma);
        ram.setDungLuong(ten);
        ram.setDeleted(false);
        ram.setUpdatedAt(Util.getCurrentDate());
        String result = ramService.update(ram);
        JOptionPane.showMessageDialog(this, result);
        if (result.contains("thành công")) {
            loadData();
        }
    }

    public void updateRom() {
        String ma = txtMa.getText();
        String ten = txtTen.getText();
        Rom rom = new Rom();
        rom.setMaRom(ma);
        rom.setTenRom(ten);
        rom.setDeleted(false);
        rom.setUpdatedAt(Util.getCurrentDate());
        String result = romService.update(rom);
        JOptionPane.showMessageDialog(this, result);
        if (result.contains("thành công")) {
            loadData();
        }
    }

    public void updateHang() {
        String ma = txtMa.getText();
        String ten = txtTen.getText();
        HangDienThoai hdt = new HangDienThoai();
        hdt.setMaHangDT(ma);
        hdt.setTenHang(ten);
        hdt.setDeleted(false);
        hdt.setUpdatedAt(Util.getCurrentDate());
        String result = hangDienThoaiService.update(hdt);
        JOptionPane.showMessageDialog(this, result);
        if (result.contains("thành công")) {
            loadData();
        }
    }

    public void updateMauSac() {
        String ma = txtMa.getText();
        String ten = txtTen.getText();
        MauSac ms = new MauSac();
        ms.setMaMauSac(ma);
        ms.setTenMauSac(ten);
        ms.setDeleted(false);
        ms.setUpdatedAt(Util.getCurrentDate());
        String result = mauSacService.update(ms);
        JOptionPane.showMessageDialog(this, result);
        if (result.contains("thành công")) {
            loadData();
        }
    }

    public void updatePin() {
        String ma = txtMa.getText();
        String ten = txtTen.getText();
        Pin pin = new Pin();
        pin.setMaPin(ma);
        pin.setTenPin(ten);
        pin.setDeleted(false);
        pin.setUpdatedAt(Util.getCurrentDate());
        String result = pinService.update(pin);
        JOptionPane.showMessageDialog(this, result);
        if (result.contains("thành công")) {
            loadData();
        }
    }

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        int row = tblSetting.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn 1 dòng trên bảng để sửa");
            return;
        }
        int option = JOptionPane.showConfirmDialog(this, "Xác nhận sửa", "Sửa dữ liệu", JOptionPane.OK_CANCEL_OPTION);
        if (option == 0) {
            if (lblTitle.getText().equalsIgnoreCase("Chip")) {
                updateChip();
            } else if (lblTitle.getText().equalsIgnoreCase("Ram")) {
                updateRam();
            } else if (lblTitle.getText().equalsIgnoreCase("Rom")) {
                updateRom();
            } else if (lblTitle.getText().equalsIgnoreCase("Màu sắc")) {
                updateMauSac();
            } else if (lblTitle.getText().equalsIgnoreCase("Hãng")) {
                updateHang();
            } else if (lblTitle.getText().equalsIgnoreCase("Pin")) {
                updatePin();
            }
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    public void addChip() {
        String ma = txtMa.getText();
        String ten = txtTen.getText();
        Chip chip = Chip.builder()
                .maChip(ma)
                .tenChip(ten)
                .deleted(false)
                .createdAt(Util.getCurrentDate())
                .build();
        String result = chipService.add(chip);
        JOptionPane.showMessageDialog(this, result);
        if (result.contains("thành công")) {
            loadData();
        }
    }

    public void addRam() {
        String ma = txtMa.getText();
        String ten = txtTen.getText();
        Ram ram = new Ram();
        ram.setMaRam(ma);
        ram.setDungLuong(ten);
        ram.setDeleted(false);
        ram.setCreatedAt(Util.getCurrentDate());
        String result = ramService.add(ram);
        JOptionPane.showMessageDialog(this, result);
        if (result.contains("thành công")) {
            loadData();
        }
    }

    public void addRom() {
        String ma = txtMa.getText();
        String ten = txtTen.getText();
        Rom rom = new Rom();
        rom.setMaRom(ma);
        rom.setTenRom(ten);
        rom.setDeleted(false);
        rom.setCreatedAt(Util.getCurrentDate());
        String result = romService.add(rom);
        JOptionPane.showMessageDialog(this, result);
        if (result.contains("thành công")) {
            loadData();
        }
    }

    public void addHang() {
        String ma = txtMa.getText();
        String ten = txtTen.getText();
        HangDienThoai hdt = new HangDienThoai();
        hdt.setMaHangDT(ma);
        hdt.setTenHang(ten);
        hdt.setDeleted(false);
        hdt.setCreatedAt(Util.getCurrentDate());
        String result = hangDienThoaiService.add(hdt);
        JOptionPane.showMessageDialog(this, result);
        if (result.contains("thành công")) {
            loadData();
        }
    }

    public void addMauSac() {
        String ma = txtMa.getText();
        String ten = txtTen.getText();
        MauSac ms = new MauSac();
        ms.setMaMauSac(ma);
        ms.setTenMauSac(ten);
        ms.setDeleted(false);
        ms.setCreatedAt(Util.getCurrentDate());
        String result = mauSacService.add(ms);
        JOptionPane.showMessageDialog(this, result);
        if (result.contains("thành công")) {
            loadData();
        }
    }

    public void addPin() {
        String ma = txtMa.getText();
        String ten = txtTen.getText();
        Pin pin = new Pin();
        pin.setMaPin(ma);
        pin.setTenPin(ten);
        pin.setDeleted(false);
        pin.setCreatedAt(Util.getCurrentDate());
        String result = pinService.add(pin);
        JOptionPane.showMessageDialog(this, result);
        if (result.contains("thành công")) {
            loadData();
        }
    }

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        int option = JOptionPane.showConfirmDialog(this, "Xác nhận thêm", "Thêm dữ liệu", JOptionPane.OK_CANCEL_OPTION);
        if (option == 0) {
            if (lblTitle.getText().equalsIgnoreCase("Chip")) {
                addChip();
            } else if (lblTitle.getText().equalsIgnoreCase("Ram")) {
                addRam();
            } else if (lblTitle.getText().equalsIgnoreCase("Rom")) {
                addRom();
            } else if (lblTitle.getText().equalsIgnoreCase("Màu sắc")) {
                addMauSac();
            } else if (lblTitle.getText().equalsIgnoreCase("Hãng")) {
                addHang();
            } else if (lblTitle.getText().equalsIgnoreCase("Pin")) {
                addPin();
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    public void deleteChip() {
        String ma = txtMa.getText();
        String ten = txtTen.getText();
        Chip chip = new Chip();
        chip.setMaChip(ma);
        chip.setTenChip(ten);
        chip.setDeleted(true);
        chip.setUpdatedAt(Util.getCurrentDate());
        String result = chipService.delete(chip);
        JOptionPane.showMessageDialog(this, result);
        if (result.contains("thành công")) {
            loadData();
        }
    }

    public void deleteRam() {
        String ma = txtMa.getText();
        String ten = txtTen.getText();
        Ram ram = new Ram();
        ram.setMaRam(ma);
        ram.setDungLuong(ten);
        ram.setDeleted(true);
        ram.setUpdatedAt(Util.getCurrentDate());
        String result = ramService.delete(ram);
        JOptionPane.showMessageDialog(this, result);
        if (result.contains("thành công")) {
            loadData();
        }
    }

    public void deleteRom() {
        String ma = txtMa.getText();
        String ten = txtTen.getText();
        Rom rom = new Rom();
        rom.setMaRom(ma);
        rom.setTenRom(ten);
        rom.setDeleted(true);
        rom.setUpdatedAt(Util.getCurrentDate());
        String result = romService.delete(rom);
        JOptionPane.showMessageDialog(this, result);
        if (result.contains("thành công")) {
            loadData();
        }
    }

    public void deleteHangDT() {
        String ma = txtMa.getText();
        String ten = txtTen.getText();
        HangDienThoai hdt = new HangDienThoai();
        hdt.setMaHangDT(ma);
        hdt.setTenHang(ten);
        hdt.setDeleted(true);
        hdt.setUpdatedAt(Util.getCurrentDate());
        String result = hangDienThoaiService.delete(hdt);
        JOptionPane.showMessageDialog(this, result);
        if (result.contains("thành công")) {
            loadData();
        }
    }

    public void deleteMauSac() {
        String ma = txtMa.getText();
        String ten = txtTen.getText();
        MauSac ms = new MauSac();
        ms.setMaMauSac(ma);
        ms.setTenMauSac(ten);
        ms.setDeleted(true);
        ms.setUpdatedAt(Util.getCurrentDate());
        String result = mauSacService.delete(ms);
        JOptionPane.showMessageDialog(this, result);
        if (result.contains("thành công")) {
            loadData();
        }
    }

    public void deletePin() {
        String ma = txtMa.getText();
        String ten = txtTen.getText();
        Pin pin = new Pin();
        pin.setMaPin(ma);
        pin.setTenPin(ten);
        pin.setDeleted(true);
        pin.setUpdatedAt(Util.getCurrentDate());
        String result = pinService.delete(pin);
        JOptionPane.showMessageDialog(this, result);
        if (result.contains("thành công")) {
            loadData();
        }
    }

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        int row = tblSetting.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn 1 dòng trên bảng để xóa");
            return;
        }
        int option = JOptionPane.showConfirmDialog(this, "Xác nhận xóa", "Xóa dữ liệu", JOptionPane.OK_CANCEL_OPTION);
        if (option == 0) {
            if (lblTitle.getText().equalsIgnoreCase("Chip")) {
                deleteChip();
            } else if (lblTitle.getText().equalsIgnoreCase("Ram")) {
                deleteRam();
            } else if (lblTitle.getText().equalsIgnoreCase("Rom")) {
                deleteRom();
            } else if (lblTitle.getText().equalsIgnoreCase("Màu sắc")) {
                deleteMauSac();
            } else if (lblTitle.getText().equalsIgnoreCase("Hãng")) {
                deleteHangDT();
            } else if (lblTitle.getText().equalsIgnoreCase("Pin")) {
                deletePin();
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tblSettingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSettingMouseClicked
        // TODO add your handling code here:
        DefaultTableModel dtm = (DefaultTableModel) tblSetting.getModel();
        int row = tblSetting.getSelectedRow();
        txtMa.setText(dtm.getValueAt(row, 0).toString());
        txtTen.setText(dtm.getValueAt(row, 1).toString());

    }//GEN-LAST:event_tblSettingMouseClicked

    private void btnRestoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestoreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRestoreActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSearchActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(DemoDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(DemoDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(DemoDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(DemoDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                DemoDialog dialog = new DemoDialog(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRestore;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblMa;
    private javax.swing.JLabel lblTen;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblLuuTru;
    private javax.swing.JTable tblSetting;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
