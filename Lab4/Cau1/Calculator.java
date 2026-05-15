package Lab4.Cau1;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Calculator extends JFrame {
    
    private JLabel lbHienThi;
    private double kq = 0; 
    private String phepToan = ""; 
    private boolean isNewInput = true; 

    public Calculator() {
        setTitle("Calculator Pro");
        setSize(360, 520); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        getContentPane().setBackground(new Color(32, 32, 32));
        setLayout(new BorderLayout(10, 10)); 

        lbHienThi = new JLabel("0");
        lbHienThi.setFont(new Font("Segoe UI", Font.BOLD, 48)); 
        lbHienThi.setForeground(Color.WHITE);
        lbHienThi.setHorizontalAlignment(SwingConstants.RIGHT);
        lbHienThi.setBorder(new EmptyBorder(30, 20, 20, 20)); 
        add(lbHienThi, BorderLayout.NORTH);
        JPanel panelButtons = new JPanel();
        panelButtons.setLayout(new GridLayout(4, 4, 8, 8)); 
        panelButtons.setBackground(new Color(32, 32, 32)); 
        panelButtons.setBorder(new EmptyBorder(10, 20, 30, 20)); 

        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "X",
            "1", "2", "3", "-",
            "C", "0", "=", "+"
        };

        Font btnFont = new Font("Segoe UI", Font.BOLD, 22);
        for (String label : buttonLabels) {
            JButton btn = new JButton(label);
            btn.setFont(btnFont);
            btn.setFocusPainted(false); 
            btn.setBorderPainted(false); 
            btn.setOpaque(true); 
            if (label.matches("[0-9]")) {
                btn.setBackground(new Color(64, 64, 64)); 
                btn.setForeground(Color.WHITE);
            } else if (label.equals("C")) {
                btn.setBackground(new Color(230, 74, 25)); 
                btn.setForeground(Color.WHITE);
            } else if (label.equals("=")) {
                btn.setBackground(new Color(25, 118, 210)); 
                btn.setForeground(Color.WHITE);
            } else {
                btn.setBackground(new Color(255, 149, 0)); 
                btn.setForeground(Color.WHITE);
            }
            btn.addActionListener(e -> xuLySuKien(label));
            panelButtons.add(btn);
        }

        add(panelButtons, BorderLayout.CENTER);
    }
    private void xuLySuKien(String command) {
        switch (command) {
            case "C": 
                lbHienThi.setText("0");
                kq = 0;
                phepToan = "";
                isNewInput = true;
                break;
                
            case "=": 
                tinhToan();
                phepToan = ""; 
                isNewInput = true; 
                break;
                
            case "+": case "-": case "X": case "/": 
                tinhToan(); 
                phepToan = command; 
                isNewInput = true;
                break;
                
            default: 
                if (isNewInput) {
                    lbHienThi.setText(command); 
                    isNewInput = false;
                } else {
                    String gtri = lbHienThi.getText();
                    if (gtri.length() < 12) { 
                        if (gtri.equals("0")) {
                            lbHienThi.setText(command); 
                        } else {
                            lbHienThi.setText(gtri + command); 
                        }
                    }
                }
                break;
        }
    }
    private void tinhToan() {
        double soHienTai;
        try {
            soHienTai = Double.parseDouble(lbHienThi.getText());
        } catch (NumberFormatException e) {
            return; 
        }

        if (phepToan.equals("")) {
            kq = soHienTai;
        } else {
            if (phepToan.equals("+")) kq = kq + soHienTai;
            if (phepToan.equals("-")) kq = kq - soHienTai;
            if (phepToan.equals("X")) kq = kq * soHienTai;
            if (phepToan.equals("/")) {
                if (soHienTai != 0) {
                    kq = kq / soHienTai;
                } else {
                    lbHienThi.setText("Lỗi"); 
                    isNewInput = true;
                    phepToan = "";
                    return;
                }
            }
        }
        
        if (kq == (long) kq) {
            lbHienThi.setText(String.format("%d", (long) kq));
        } else {
            lbHienThi.setText(String.valueOf(kq));
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Calculator calc = new Calculator();
            calc.setVisible(true);
        });
    }
}