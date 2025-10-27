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
    public void soNguyenDuongHopLe(){
        Integer number = 10;
        assertEquals("So nguyen duong", soNguyenDuong.kiemTraSoNguyenDuong(number));
    }

    @Test
    public void soNguyenDuongKhongHopLeTren(){
        Integer number = 120;
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, ()->{
            soNguyenDuong.kiemTraSoNguyenDuong(number);
        });
        assertEquals("So tu 1 - 100", ex.getMessage());
    }

    @Test
    public void soNguyenDuongKhongHopLeDuoi(){
        Integer number = -30;
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, ()->{
            soNguyenDuong.kiemTraSoNguyenDuong(number);
        });
        assertEquals("So tu 1 - 100", ex.getMessage());
    }

    @Test
    public void soNguyenDuongHopLeBienTren(){
        Integer number = 100;
        assertEquals("So nguyen duong", soNguyenDuong.kiemTraSoNguyenDuong(number));
    }

    @Test
    public void soNguyenDuongHopLeBienDuoi(){
        Integer number = 1;
        assertEquals("So nguyen duong", soNguyenDuong.kiemTraSoNguyenDuong(number));
    }



    @AfterEach
    public void tearDown() {
        soNguyenDuong = null;
    }
}
