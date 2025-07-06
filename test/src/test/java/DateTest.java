
import com.test.negocio.Date;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DateTest {

    @Test
    void testConstrutorVazio() {
        Date d = new Date();
        assertEquals(1, d.getDay());
        assertEquals(1, d.getMonth());
        assertEquals(1900, d.getYear());
    }

    @Test
    void testConstrutorComParametros() {
        Date d = new Date(2000, 12, 25);
        assertEquals(25, d.getDay());
        assertEquals(12, d.getMonth());
        assertEquals(2000, d.getYear());
    }

    @Test
    void testConstrutorComParametrosOrdemAnoMeio() {
        Date d = new Date(13, 7, 2016);
        assertEquals(13, d.getDay());
        assertEquals(7, d.getMonth());
        assertEquals(2016, d.getYear());
    }

    // Testes para construtores inválidos lançarem exceção
    @Test
    void testConstrutorInvalidoAmbiguo() {
        assertThrows(IllegalArgumentException.class, () -> new Date(1900, 7, 2016));
    }

    @Test
    void testConstrutorAnoAbaixoMinimo1() {
        assertThrows(IllegalArgumentException.class, () -> new Date(16, 7, 1899));
    }

    @Test
    void testConstrutorAnoAbaixoMinimo2() {
        assertThrows(IllegalArgumentException.class, () -> new Date(1899, 7, 16));
    }

    @Test
    void testConstrutorMesInvalido() {
        assertThrows(IllegalArgumentException.class, () -> new Date(2016, 13, 16));
    }

    @Test
    void testConstrutorDiaInvalido1() {
        assertThrows(IllegalArgumentException.class, () -> new Date(2016, 12, 32));
    }

    @Test
    void testConstrutorDiaInvalido2() {
        assertThrows(IllegalArgumentException.class, () -> new Date(2016, 12, -1));
    }

    @Test
    void testConstrutorMesInvalidoNegativo() {
        assertThrows(IllegalArgumentException.class, () -> new Date(2016, -1, 16));
    }

    @Test
    void testConstrutorDiaInvalidoFevereiro() {
        assertThrows(IllegalArgumentException.class, () -> new Date(2016, 2, 30));
    }

    @Test
    void testToStringFormat() {
        Date d = new Date(5, 5, 2005);
        assertEquals("05/05/2005", d.toString());
        d = new Date(1, 10, 2001);
        assertEquals("01/10/2001", d.toString());
    }

    @Test
    void testEquals() {
        Date d1 = new Date(1, 7, 2014);
        Date d2 = new Date(1, 7, 2014);
        Date d3 = new Date();
        assertTrue(d1.equals(d2));
        assertFalse(d1.equals(d3));
    }

    @Test
    void testAfterBefore() {
        Date d1 = new Date(1, 7, 2014);
        Date d2 = new Date(23, 4, 2016);

        assertFalse(d1.after(d2));
        assertTrue(d2.after(d1));
        assertTrue(d1.before(d2));
        assertFalse(d2.before(d1));
        assertFalse(d2.before(d2));
        assertFalse(d2.after(d2));
    }

    @Test
    void testPlusMinusDaysTomorrowYesterday() {
        Date d = new Date(2016, 4, 22);

        Date yesterday = d.yesterday();
        assertEquals(21, yesterday.getDay());
        assertEquals(4, yesterday.getMonth());
        assertEquals(2016, yesterday.getYear());

        // Imutabilidade
        assertEquals(22, d.getDay());
        assertEquals(4, d.getMonth());
        assertEquals(2016, d.getYear());

        Date tomorrow = d.tomorrow();
        assertEquals(23, tomorrow.getDay());
        assertEquals(4, tomorrow.getMonth());
        assertEquals(2016, tomorrow.getYear());

        Date plus10 = tomorrow.plusDays(10);
        assertEquals(3, plus10.getDay());
        assertEquals(5, plus10.getMonth());
        assertEquals(2016, plus10.getYear());

        Date minus10 = plus10.minusDays(10);
        assertEquals(23, minus10.getDay());
        assertEquals(4, minus10.getMonth());
        assertEquals(2016, minus10.getYear());
    }

    @Test
    void testSituacoesComplexas() {
        Date q = new Date(20, 2, 2016);
        q = q.plusDays(9);
        assertEquals("29/02/2016", q.toString());

        for (int i = 0; i < 400; i++) {
            q = q.tomorrow();
        }

        assertEquals("04/04/2017", q.toString());

        q = q.plusDays(365);
        assertEquals("04/04/2018", q.toString());
    }
}
