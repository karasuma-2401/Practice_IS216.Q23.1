import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class ToolbarDemo extends javax.swing.JFrame {

    public ToolbarDemo() {
        initComponents();
        setLocationRelativeTo(null);
    }
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btnOpen    = new javax.swing.JButton();
        btnSave    = new javax.swing.JButton();
        btnPrint   = new javax.swing.JButton();
        btnFax     = new javax.swing.JButton();
        btnFacebook= new javax.swing.JButton();
        btnMonitor = new javax.swing.JButton();
        btnHand    = new javax.swing.JButton();
        btnSearch  = new javax.swing.JButton();
        btnSelect  = new javax.swing.JButton();
        btnImage   = new javax.swing.JButton();
        btnCamera  = new javax.swing.JButton();
        btnRMS     = new javax.swing.JButton();
        btnEdit    = new javax.swing.JButton();
        btnOK      = new javax.swing.JButton();
        lblTitle   = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Basic");
        setResizable(false);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        // ===== Open =====
        btnOpen.setText("📂");
        btnOpen.setToolTipText("Open");
        btnOpen.setFocusable(false);
        btnOpen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOpen.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenActionPerformed(evt);
            }
        });
        jToolBar1.add(btnOpen);

        // ===== Save =====
        btnSave.setText("💾");
        btnSave.setToolTipText("Save");
        btnSave.setFocusable(false);
        btnSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSave.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSave);

        // ===== Print =====
        btnPrint.setText("🖨️");
        btnPrint.setToolTipText("Print");
        btnPrint.setFocusable(false);
        btnPrint.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPrint.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });
        jToolBar1.add(btnPrint);

        // ===== Fax =====
        btnFax.setText("📠");
        btnFax.setToolTipText("Fax");
        btnFax.setFocusable(false);
        btnFax.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFax.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnFax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFaxActionPerformed(evt);
            }
        });
        jToolBar1.add(btnFax);

        jToolBar1.addSeparator();

        // ===== Facebook =====
        btnFacebook.setText("🌐");
        btnFacebook.setToolTipText("Facebook");
        btnFacebook.setFocusable(false);
        btnFacebook.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFacebook.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnFacebook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFacebookActionPerformed(evt);
            }
        });
        jToolBar1.add(btnFacebook);

        // ===== Monitor =====
        btnMonitor.setText("🖥️");
        btnMonitor.setToolTipText("Monitor");
        btnMonitor.setFocusable(false);
        btnMonitor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMonitor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMonitor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMonitorActionPerformed(evt);
            }
        });
        jToolBar1.add(btnMonitor);

        // ===== Hand =====
        btnHand.setText("✋");
        btnHand.setToolTipText("Hand Tool");
        btnHand.setFocusable(false);
        btnHand.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHand.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnHand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHandActionPerformed(evt);
            }
        });
        jToolBar1.add(btnHand);

        // ===== Search =====
        btnSearch.setText("🔍");
        btnSearch.setToolTipText("Search");
        btnSearch.setFocusable(false);
        btnSearch.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSearch.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSearch);

        jToolBar1.addSeparator();

        // ===== Select =====
        btnSelect.setText("↖️");
        btnSelect.setToolTipText("Select");
        btnSelect.setFocusable(false);
        btnSelect.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSelect.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSelect);

        // ===== Image =====
        btnImage.setText("🖼️");
        btnImage.setToolTipText("Image");
        btnImage.setFocusable(false);
        btnImage.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnImage.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImageActionPerformed(evt);
            }
        });
        jToolBar1.add(btnImage);

        // ===== Camera =====
        btnCamera.setText("📷");
        btnCamera.setToolTipText("Camera");
        btnCamera.setFocusable(false);
        btnCamera.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCamera.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCamera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCameraActionPerformed(evt);
            }
        });
        jToolBar1.add(btnCamera);

        // ===== RMS =====
        btnRMS.setText("🔒");
        btnRMS.setToolTipText("RMS");
        btnRMS.setFocusable(false);
        btnRMS.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRMS.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRMS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRMSActionPerformed(evt);
            }
        });
        jToolBar1.add(btnRMS);

        // ===== Edit =====
        btnEdit.setText("✏️");
        btnEdit.setToolTipText("Edit");
        btnEdit.setFocusable(false);
        btnEdit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEdit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jToolBar1.add(btnEdit);

        // ===== OK =====
        btnOK.setText("✅");
        btnOK.setToolTipText("OK");
        btnOK.setFocusable(false);
        btnOK.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOK.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });
        jToolBar1.add(btnOK);

        // ===== Label =====
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Bài 3: Tạo JToolBar và xử lý sự kiện");
        lblTitle.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 16));

        // ===== Layout (chuẩn GroupLayout do NetBeans sinh) =====
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE,
                        600, Short.MAX_VALUE)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE,
                            javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jToolBar1,
                            javax.swing.GroupLayout.PREFERRED_SIZE,
                            javax.swing.GroupLayout.DEFAULT_SIZE,
                            javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                            80, Short.MAX_VALUE)
                    .addComponent(lblTitle)
                    .addGap(80, 80, 80))
        );

        pack();
    }
    // </editor-fold>

    // ===== CÁC METHOD XỬ LÝ SỰ KIỆN (phần mình tự viết trong NetBeans) =====

    private void btnOpenActionPerformed(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(this, "Bạn vừa click: Open\nChức năng: Mở file", "Open", JOptionPane.INFORMATION_MESSAGE);
    }

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(this, "Bạn vừa click: Save\nChức năng: Lưu file", "Save", JOptionPane.INFORMATION_MESSAGE);
    }

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(this, "Bạn vừa click: Print\nChức năng: In tài liệu", "Print", JOptionPane.INFORMATION_MESSAGE);
    }

    private void btnFaxActionPerformed(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(this, "Bạn vừa click: Fax\nChức năng: Gửi Fax", "Fax", JOptionPane.INFORMATION_MESSAGE);
    }

    private void btnFacebookActionPerformed(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(this, "Bạn vừa click: Facebook\nChức năng: Mở Facebook", "Facebook", JOptionPane.INFORMATION_MESSAGE);
    }

    private void btnMonitorActionPerformed(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(this, "Bạn vừa click: Monitor\nChức năng: Hiển thị màn hình", "Monitor", JOptionPane.INFORMATION_MESSAGE);
    }

    private void btnHandActionPerformed(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(this, "Bạn vừa click: Hand\nChức năng: Công cụ tay", "Hand Tool", JOptionPane.INFORMATION_MESSAGE);
    }

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(this, "Bạn vừa click: Search\nChức năng: Tìm kiếm", "Search", JOptionPane.INFORMATION_MESSAGE);
    }

    private void btnSelectActionPerformed(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(this, "Bạn vừa click: Select\nChức năng: Chọn vùng", "Select", JOptionPane.INFORMATION_MESSAGE);
    }

    private void btnImageActionPerformed(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(this, "Bạn vừa click: Image\nChức năng: Chèn ảnh", "Image", JOptionPane.INFORMATION_MESSAGE);
    }

    private void btnCameraActionPerformed(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(this, "Bạn vừa click: Camera\nChức năng: Chụp ảnh", "Camera", JOptionPane.INFORMATION_MESSAGE);
    }

    private void btnRMSActionPerformed(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(this, "Bạn vừa click: RMS\nChức năng: Bảo mật RMS", "RMS", JOptionPane.INFORMATION_MESSAGE);
    }

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(this, "Bạn vừa click: Edit\nChức năng: Chỉnh sửa", "Edit", JOptionPane.INFORMATION_MESSAGE);
    }

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(this, "Bạn vừa click: OK\nChức năng: Xác nhận", "OK", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ToolbarDemo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnCamera;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnFacebook;
    private javax.swing.JButton btnFax;
    private javax.swing.JButton btnHand;
    private javax.swing.JButton btnImage;
    private javax.swing.JButton btnMonitor;
    private javax.swing.JButton btnOK;
    private javax.swing.JButton btnOpen;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnRMS;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSelect;
    private javax.swing.JLabel  lblTitle;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration
}