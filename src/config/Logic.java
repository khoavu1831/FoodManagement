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
}
