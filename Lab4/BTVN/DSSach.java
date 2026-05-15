package Lab4.BTVN;

import java.util.ArrayList;

public class DSSach {
    private ArrayList<Sach> ds;

    public DSSach() {
        this.ds = new ArrayList<>();
    }

    public boolean themSach(Sach s) {
        for (Sach item : ds) {
            if (item.getMaSach().equalsIgnoreCase(s.getMaSach())) {
                return false;
            }
        }
        ds.add(s);
        return true;
    }

    public Sach getSach(int i) {
        if (i >= 0 && i < ds.size()) {
            return ds.get(i);
        }
        return null;
    }

    public boolean xoaSach(String ma) {
        for (int i = 0; i < ds.size(); i++) {
            if (ds.get(i).getMaSach().equalsIgnoreCase(ma)) {
                ds.remove(i);
                return true;
            }
        }
        return false;
    }

    public int timSach(String ma) {
        for (int i = 0; i < ds.size(); i++) {
            if (ds.get(i).getMaSach().equalsIgnoreCase(ma)) {
                return i;
            }
        }
        return -1;
    }

    public boolean capNhatSach(String ma, Sach s) {
        int index = timSach(ma);
        if (index != -1) {
            ds.set(index, s);
            return true;
        }
        return false;
    }

    public int tongSoSach() {
        return ds.size();
    }

    public ArrayList<Sach> getDs() {
        return ds;
    }
}
