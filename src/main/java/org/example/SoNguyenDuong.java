package org.example;

public class SoNguyenDuong {
    public String kiemTraSoNguyenDuong(Float number){
        if(number % 1 != 0){
            throw new IllegalArgumentException("Khong phai so nguyen");
        }
        if(number == null){
            throw new IllegalArgumentException("Khong duoc null");
        }
        if(number < 0 || number > 100){
            throw new IllegalArgumentException("So tu 1 - 100");
        }
        return "So nguyen duong";
    }
}
