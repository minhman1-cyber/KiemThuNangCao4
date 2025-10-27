import org.example.Sach;
import org.example.SachService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SachTest {
    SachService sachService;
    @BeforeEach
    public void setUp() {
        sachService = new SachService();
    }

    @Test
    public void suaPhanVungHopLe(){
        Sach sach = new Sach("id1", "sach 1", "tac gia 1", 2009, 34f);
        sachService.sua(sach);
        assertEquals(2009, sachService.sach.getNamXuatBan());
    }

    @Test
    public void suaPhanVungKoHopLeTren(){
        Sach sach = new Sach("id1", "sach 1", "tac gia 1", 2300, 34f);
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            sachService.sua(sach);
        });
        assertEquals("Nam xuat ban tu 1990 - 2025", ex.getMessage());
    }

    @Test
    public void suaPhanVungKoHopLeDuoi(){
        Sach sach = new Sach("id1", "sach 1", "tac gia 1", 1900, 34f);
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            sachService.sua(sach);
        });
        assertEquals("Nam xuat ban tu 1990 - 2025", ex.getMessage());
    }

    @Test
    public void suaBienTren(){
        Sach sach = new Sach("id1", "sach 1", "tac gia 1", 2025, 34f);
        sachService.sua(sach);
        assertEquals(2025, sachService.sach.getNamXuatBan());
    }

    @Test
    public void suaBienDuoi(){
        Sach sach = new Sach("id1", "sach 1", "tac gia 1", 1990, 34f);
        sachService.sua(sach);
        assertEquals(1990, sachService.sach.getNamXuatBan());
    }

    @Test
    public void suaTrong(){
        Sach sach = new Sach("id1", "", "tac gia 1", 1990, 34f);
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            sachService.sua(sach);
        });
        assertEquals("Khong duoc de trong truong nhap", ex.getMessage());
    }

    @AfterEach
    public void tearDown() {
        sachService = null;
    }
}
