package org.example;

import java.util.ArrayList;
import java.util.List;

public class SachService {
    List<Sach> list = new ArrayList<>();
    public Sach sach = new Sach("id1", "sach 1", "tac gia 1", 2007, 34f);

    public void sua(Sach newSach){
        if(newSach.getNamXuatBan() < 1990 || newSach.getNamXuatBan() > 2025){
            throw new IllegalArgumentException("Nam xuat ban tu 1990 - 2025");
        }
        if(newSach.getMaSach().isBlank() || newSach.getTacGia().isBlank() || newSach.getTenSach().isBlank()){
            throw new IllegalArgumentException("Khong duoc de trong truong nhap");
        }
        sach.setMaSach(newSach.getMaSach());
        sach.setTacGia(newSach.getTacGia());
        sach.setTenSach(newSach.getTenSach());
        sach.setNamXuatBan(newSach.getNamXuatBan());
        sach.setGia(newSach.getGia());
    }
}
