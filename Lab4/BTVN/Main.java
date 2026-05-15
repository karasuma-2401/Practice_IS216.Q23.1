package Lab4.BTVN;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class Main extends JFrame {

    private final String[] COLS = { "Mã sách", "Tên sách", "Tác giả", "NXB", "Giá" };
    private final DSSach dsSach = new DSSach();
    private DefaultTableModel tableModel;
    private JTable table;

    private JTextField tfMa, tfTen, tfGia, tfTacGia, tfNxb;
    private JButton btThem, btXoa, btSua, btLuu, btTim, btClear, btThoat;

    public Main() {
        super("Chương trình quản lý sách");
        initComponents();
        initEvents();
        initMockData();
        syncTable();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(800, 500));
        pack();
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        setLayout(new BorderLayout(10, 10));

        JLabel lbTitle = new JLabel("Thông tin sách", JLabel.CENTER);
        lbTitle.setFont(new Font("Arial", Font.BOLD, 24));
        add(lbTitle, BorderLayout.NORTH);

        JPanel pnForm = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        tfMa = new JTextField(20);
        tfTen = new JTextField(20);
        tfGia = new JTextField(20);
        tfTacGia = new JTextField(20);
        tfNxb = new JTextField(20);

        gbc.gridx = 0; gbc.gridy = 0; pnForm.add(new JLabel("Mã sách"), gbc);
        gbc.gridx = 1; pnForm.add(tfMa, gbc);
        gbc.gridx = 2; pnForm.add(new JLabel("Tác giả"), gbc);
        gbc.gridx = 3; pnForm.add(tfTacGia, gbc);

        gbc.gridx = 0; gbc.gridy = 1; pnForm.add(new JLabel("Tên sách"), gbc);
        gbc.gridx = 1; pnForm.add(tfTen, gbc);
        gbc.gridx = 2; pnForm.add(new JLabel("Nhà xuất bản"), gbc);
        gbc.gridx = 3; pnForm.add(tfNxb, gbc);

        gbc.gridx = 0; gbc.gridy = 2; pnForm.add(new JLabel("Giá"), gbc);
        gbc.gridx = 1; pnForm.add(tfGia, gbc);

        tableModel = new DefaultTableModel(COLS, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table = new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane spTable = new JScrollPane(table);
        spTable.setPreferredSize(new Dimension(750, 250));

        JPanel pnCenter = new JPanel(new BorderLayout(10, 10));
        pnCenter.add(pnForm, BorderLayout.NORTH);
        pnCenter.add(spTable, BorderLayout.CENTER);
        add(pnCenter, BorderLayout.CENTER);

        JPanel pnButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        btThem = new JButton("Thêm");
        btXoa = new JButton("Xóa");
        btSua = new JButton("Sửa");
        btLuu = new JButton("Lưu");
        btTim = new JButton("Tìm");
        btClear = new JButton("Clear");
        btThoat = new JButton("Thoát");

        pnButtons.add(btThem);
        pnButtons.add(btXoa);
        pnButtons.add(btSua);
        pnButtons.add(btLuu);
        pnButtons.add(btTim);
        pnButtons.add(btClear);
        pnButtons.add(btThoat);
        add(pnButtons, BorderLayout.SOUTH);
    }

    private void initEvents() {
        btThem.addActionListener(e -> onThem());
        btXoa.addActionListener(e -> onXoa());
        btSua.addActionListener(e -> onSua());
        btLuu.addActionListener(e -> onLuu());
        btTim.addActionListener(e -> onTim());
        btClear.addActionListener(e -> onClear());
        btThoat.addActionListener(e -> System.exit(0));

        table.getSelectionModel().addListSelectionListener(e -> {
            int row = table.getSelectedRow();
            if (row != -1) {
                fillForm(row);
            }
        });
    }

    private void onThem() {
        String ma = tfMa.getText().trim();
        String ten = tfTen.getText().trim();
        String tg = tfTacGia.getText().trim();
        String nxb = tfNxb.getText().trim();
        String giaStr = tfGia.getText().trim();

        if (ma.isEmpty() || ten.isEmpty() || tg.isEmpty() || nxb.isEmpty() || giaStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!");
            return;
        }

        try {
            double gia = Double.parseDouble(giaStr);
            Sach s = new Sach(ma, ten, tg, nxb, gia);
            if (dsSach.themSach(s)) {
                syncTable();
                onClear();
            } else {
                JOptionPane.showMessageDialog(this, "Mã sách đã tồn tại!");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Giá phải là số!");
        }
    }

    private void onXoa() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sách cần xóa!");
            return;
        }
        String ma = tableModel.getValueAt(row, 0).toString();
        if (dsSach.xoaSach(ma)) {
            syncTable();
            onClear();
        }
    }

    private void onSua() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sách cần sửa!");
            return;
        }
        tfMa.setEditable(false);
    }

    private void onLuu() {
        String ma = tfMa.getText().trim();
        String ten = tfTen.getText().trim();
        String tg = tfTacGia.getText().trim();
        String nxb = tfNxb.getText().trim();
        String giaStr = tfGia.getText().trim();

        if (ma.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không có mã sách để cập nhật!");
            return;
        }

        try {
            double gia = Double.parseDouble(giaStr);
            Sach s = new Sach(ma, ten, tg, nxb, gia);
            if (dsSach.capNhatSach(ma, s)) {
                syncTable();
                tfMa.setEditable(true);
                onClear();
            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy mã sách để cập nhật!");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Giá phải là số!");
        }
    }

    private void onTim() {
        String ma = JOptionPane.showInputDialog(this, "Nhập mã sách cần tìm:");
        if (ma != null && !ma.trim().isEmpty()) {
            int index = dsSach.timSach(ma.trim());
            if (index != -1) {
                table.setRowSelectionInterval(index, index);
                table.scrollRectToVisible(table.getCellRect(index, 0, true));
            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy sách có mã " + ma);
            }
        }
    }

    private void onClear() {
        tfMa.setText("");
        tfTen.setText("");
        tfTacGia.setText("");
        tfNxb.setText("");
        tfGia.setText("");
        tfMa.setEditable(true);
        table.clearSelection();
    }

    private void fillForm(int row) {
        tfMa.setText(tableModel.getValueAt(row, 0).toString());
        tfTen.setText(tableModel.getValueAt(row, 1).toString());
        tfTacGia.setText(tableModel.getValueAt(row, 2).toString());
        tfNxb.setText(tableModel.getValueAt(row, 3).toString());
        tfGia.setText(tableModel.getValueAt(row, 4).toString());
    }

    private void syncTable() {
        tableModel.setRowCount(0);
        for (Sach s : dsSach.getDs()) {
            tableModel.addRow(new Object[] {
                s.getMaSach(), s.getTenSach(), s.getTacGia(), s.getNxb(), s.getGia()
            });
        }
    }

    private void initMockData() {
        dsSach.themSach(new Sach("MS01", "ABC", "Nguyễn A", "XYZ", 100000));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }
}
