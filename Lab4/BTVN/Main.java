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

    private static final String[] COLS = { "Mã sách", "Tên sách", "Tác giả", "NXB", "Giá" };

    private final DSSach dsSach = new DSSach();
    private final DefaultTableModel tableModel = new DefaultTableModel(COLS, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    private final JTextField tfMa = new JTextField(12);
    private final JTextField tfTen = new JTextField(12);
    private final JTextField tfGia = new JTextField(12);
    private final JTextField tfTacGia = new JTextField(12);
    private final JTextField tfNxb = new JTextField(12);
    private final JTable table = new JTable(tableModel);

    public Main() {
        super("Chương trình quản lý sách");
        dsSach.ds = new ArrayList<>();
        initMockData();

        JLabel header = new JLabel("Thông tin sách", JLabel.CENTER);
        header.setFont(new Font(header.getFont().getName(), Font.BOLD, 18));

        JPanel form = buildFormPanel();

        table.setFillsViewportHeight(true);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scroll = new JScrollPane(table);

        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 8));
        JButton btThem = new JButton("Thêm");
        JButton btXoa = new JButton("Xóa");
        JButton btSua = new JButton("Sửa");
        JButton btLuu = new JButton("Lưu");
        JButton btTim = new JButton("Tìm");
        JButton btClear = new JButton("Clear");
        JButton btThoat = new JButton("Thoát");
        buttons.add(btThem);
        buttons.add(btXoa);
        buttons.add(btSua);
        buttons.add(btLuu);
        buttons.add(btTim);
        buttons.add(btClear);
        buttons.add(btThoat);

        btThem.addActionListener(e -> onThem());
        btXoa.addActionListener(e -> onXoa());
        btSua.addActionListener(e -> onSua());
        btLuu.addActionListener(e -> onLuu());
        btTim.addActionListener(e -> onTim());
        btClear.addActionListener(e -> onClear());
        btThoat.addActionListener(e -> System.exit(0));

        JPanel center = new JPanel(new BorderLayout(8, 8));
        center.add(form, BorderLayout.NORTH);
        center.add(scroll, BorderLayout.CENTER);

        add(header, BorderLayout.NORTH);
        add(center, BorderLayout.CENTER);
        add(buttons, BorderLayout.SOUTH);

        syncTableFromDs();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(640, 420));
        pack();
        setLocationRelativeTo(null);
    }

    private JPanel buildFormPanel() {
        JPanel p = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(4, 6, 4, 6);
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.HORIZONTAL;

        c.gridx = 0;
        c.gridy = 0;
        p.add(new JLabel("Mã sách:"), c);
        c.gridx = 1;
        p.add(tfMa, c);
        c.gridx = 2;
        p.add(new JLabel("Tên sách:"), c);
        c.gridx = 3;
        p.add(tfTen, c);

        c.gridx = 0;
        c.gridy = 1;
        p.add(new JLabel("Giá:"), c);
        c.gridx = 1;
        p.add(tfGia, c);
        c.gridx = 2;
        p.add(new JLabel("Tác giả:"), c);
        c.gridx = 3;
        p.add(tfTacGia, c);

        c.gridx = 0;
        c.gridy = 2;
        p.add(new JLabel("Nhà xuất bản:"), c);
        c.gridx = 1;
        c.gridwidth = 3;
        p.add(tfNxb, c);
        c.gridwidth = 1;

        return p;
    }

    private void initMockData() {
        themSachNoiBo("MS01", "ABC", 100000, "Nguyễn A", "XYZ");
        themSachNoiBo("MS02", "Lập trình Java", 250000, "Trần B", "Kim Đồng");
        themSachNoiBo("MS03", "Cấu trúc dữ liệu", 180000, "Lê C", "Giáo dục");
        themSachNoiBo("MS04", "Cơ sở dữ liệu", 220000, "Phạm D", "Statistical");
        themSachNoiBo("MS05", "Mạng máy tính", 195000, "Hoàng E", "BKHN");
    }

    private void themSachNoiBo(String ma, String ten, double gia, String tg, String nxb) {
        Sach s = new Sach();
        s.maSach = ma;
        s.tenSach = ten;
        s.gia = gia;
        s.tacGia = tg;
        s.nxb = nxb;
        dsSach.ds.add(s);
    }

    private void syncTableFromDs() {
        tableModel.setRowCount(0);
        for (Sach s : dsSach.ds) {
            tableModel.addRow(new Object[] { s.maSach, s.tenSach, s.tacGia, s.nxb, s.gia });
        }
    }

    private Sach tiepXuLyNhap(boolean kiemTraTrungMa, Integer boQuaChiSoDong) {
        String ma = tfMa.getText() != null ? tfMa.getText().trim() : "";
        String ten = tfTen.getText() != null ? tfTen.getText().trim() : "";
        String tg = tfTacGia.getText() != null ? tfTacGia.getText().trim() : "";
        String nxb = tfNxb.getText() != null ? tfNxb.getText().trim() : "";
        String giaStr = tfGia.getText() != null ? tfGia.getText().trim() : "";

        if (ma.isEmpty() || ten.isEmpty() || tg.isEmpty() || nxb.isEmpty() || giaStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống bất kỳ ô nào.", "Lỗi",
                    JOptionPane.WARNING_MESSAGE);
            return null;
        }

        double gia;
        try {
            gia = Double.parseDouble(giaStr);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Giá phải là số hợp lệ.", "Lỗi",
                    JOptionPane.WARNING_MESSAGE);
            return null;
        }

        if (gia <= 0) {
            JOptionPane.showMessageDialog(this, "Giá phải lớn hơn 0 (không âm, không bằng 0).", "Lỗi",
                    JOptionPane.WARNING_MESSAGE);
            return null;
        }

        if (kiemTraTrungMa && maTrung(ma, boQuaChiSoDong)) {
            JOptionPane.showMessageDialog(this, "Mã sách đã tồn tại.", "Lỗi",
                    JOptionPane.WARNING_MESSAGE);
            return null;
        }

        Sach s = new Sach();
        s.maSach = ma;
        s.tenSach = ten;
        s.gia = gia;
        s.tacGia = tg;
        s.nxb = nxb;
        return s;
    }

    private boolean maTrung(String ma, Integer boQuaChiSoDong) {
        for (int i = 0; i < dsSach.ds.size(); i++) {
            if (boQuaChiSoDong != null && i == boQuaChiSoDong) {
                continue;
            }
            if (dsSach.ds.get(i).maSach.equals(ma)) {
                return true;
            }
        }
        return false;
    }

    private void dienFormTuDong(int row) {
        Sach s = dsSach.ds.get(row);
        tfMa.setText(s.maSach);
        tfTen.setText(s.tenSach);
        tfGia.setText(String.valueOf(s.gia));
        tfTacGia.setText(s.tacGia);
        tfNxb.setText(s.nxb);
    }

    private void onThem() {
        Sach s = tiepXuLyNhap(true, null);
        if (s == null) {
            return;
        }
        dsSach.ds.add(s);
        syncTableFromDs();
        int last = tableModel.getRowCount() - 1;
        table.getSelectionModel().setSelectionInterval(last, last);
    }

    private void onXoa() {
        int row = table.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Chọn một dòng để xóa.", "Thông báo",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        dienFormTuDong(row);
        if (tiepXuLyNhap(false, row) == null) {
            return;
        }
        dsSach.ds.remove(row);
        syncTableFromDs();
        clearFields();
    }

    private void onSua() {
        int row = table.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Chọn một dòng để sửa.", "Thông báo",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        dienFormTuDong(row);
        if (tiepXuLyNhap(false, row) == null) {
            return;
        }
    }

    private void onLuu() {
        int row = table.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Chọn một dòng đang sửa rồi bấm Lưu.", "Thông báo",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        Sach s = tiepXuLyNhap(true, row);
        if (s == null) {
            return;
        }
        dsSach.ds.set(row, s);
        syncTableFromDs();
        table.getSelectionModel().setSelectionInterval(row, row);
    }

    private void onTim() {
        Sach s = tiepXuLyNhap(false, null);
        if (s == null) {
            return;
        }
        for (int i = 0; i < dsSach.ds.size(); i++) {
            if (dsSach.ds.get(i).maSach.equals(s.maSach)) {
                table.getSelectionModel().setSelectionInterval(i, i);
                table.scrollRectToVisible(table.getCellRect(i, 0, true));
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Không tìm thấy mã: " + s.maSach, "Kết quả",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void onClear() {
        clearFields();
        table.clearSelection();
    }

    private void clearFields() {
        tfMa.setText("");
        tfTen.setText("");
        tfGia.setText("");
        tfTacGia.setText("");
        tfNxb.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main().setVisible(true));
    }
}
