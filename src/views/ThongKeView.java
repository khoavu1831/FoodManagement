package views;

import controller.QuanLyThongKe;

public class ThongKeView {
    private QuanLyThongKe quanLyThongKe;

    public ThongKeView(QuanLyThongKe quanLyThongKe) {
        this.quanLyThongKe = quanLyThongKe;
    }

    public void showThongKe() {
        quanLyThongKe.xuatThongKe();
    }
    
}
