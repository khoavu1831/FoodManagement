package config;

import java.util.List;

import models.Interface;

public class Logic {
    public static <T extends Interface> boolean isDuplicateID(String id, List<T> danhSach) {
        if (id == null || danhSach == null) {
            return false;
        }
        for (T item : danhSach) {
            if (item.getId() != null && item.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public static <T extends Interface> String autoCreateID(String haiKiTuDinhDanh, List<T> danhSach) {
        int maxNum = 0;

        for (T item : danhSach) {
            String id = item.getId();
            if (id != null && id.startsWith(haiKiTuDinhDanh)) {
                try {
                    String numPart = id.substring(haiKiTuDinhDanh.length());
                    int num = Integer.parseInt(numPart);
                    maxNum = Math.max(maxNum, num);
                } catch (NumberFormatException e) {
                    continue;
                }
            }
        }
        maxNum++;
        return String.format("%s%03d", haiKiTuDinhDanh, maxNum);
    }

}
