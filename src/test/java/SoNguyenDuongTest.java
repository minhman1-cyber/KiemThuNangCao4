import org.example.SoNguyenDuong;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SoNguyenDuongTest {
    SoNguyenDuong soNguyenDuong;
    @BeforeEach
    public void setUp() {
        soNguyenDuong = new SoNguyenDuong();
    }

    @Test
    public void soNguyenDuongKoHopLe(){
        Float number = 10.5f;
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, ()->{
            soNguyenDuong.kiemTraSoNguyenDuong(number);
        });
        assertEquals("Khong phai so nguyen", ex.getMessage());
    }

    @Test
    public void soNguyenDuongHopLe(){
        Float number = 10f;
        assertEquals("So nguyen duong", soNguyenDuong.kiemTraSoNguyenDuong(number));
    }

    @Test
    public void soNguyenDuongKhongHopLeTren(){
        Float number = 120f;
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, ()->{
            soNguyenDuong.kiemTraSoNguyenDuong(number);
        });
        assertEquals("So tu 1 - 100", ex.getMessage());
    }

    @Test
    public void soNguyenDuongKhongHopLeDuoi(){
        Float number = -30f;
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, ()->{
            soNguyenDuong.kiemTraSoNguyenDuong(number);
        });
        assertEquals("So tu 1 - 100", ex.getMessage());
    }

    @Test
    public void soNguyenDuongHopLeBienTren(){
        Float number = 100f;
        assertEquals("So nguyen duong", soNguyenDuong.kiemTraSoNguyenDuong(number));
    }

    @Test
    public void soNguyenDuongHopLeBienDuoi(){
        Float number = 1f;
        assertEquals("So nguyen duong", soNguyenDuong.kiemTraSoNguyenDuong(number));
    }



    @AfterEach
    public void tearDown() {
        soNguyenDuong = null;
    }
}
