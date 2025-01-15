package bank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class CuentaAhorrosTest {

    @Test
    public void testConsignarCuentaActiva() {
        CuentaAhorros cuenta = new CuentaAhorros(15000, 1.5f); 
        cuenta.consignar(5000); 
        assertEquals(20000, cuenta.saldo, 0.01); 
        assertEquals(1, cuenta.numConsignaciones); 
    }

    @Test
    public void testConsignarCuentaInactiva() {
        CuentaAhorros cuenta = new CuentaAhorros(5000, 1.5f); 
        cuenta.consignar(3000); 
        assertEquals(5000, cuenta.saldo, 0.01); 
        assertEquals(0, cuenta.numConsignaciones); 
    }

    @Test
    public void testRetirarCuentaActiva() {
        CuentaAhorros cuenta = new CuentaAhorros(15000, 1.5f); 
        cuenta.retirar(2000);
        assertEquals(13000, cuenta.saldo, 0.01); 
        assertEquals(1, cuenta.numRetiros); 
    }

    @Test
    public void testRetirarCuentaInactiva() {
        CuentaAhorros cuenta = new CuentaAhorros(5000, 1.5f); 
        cuenta.retirar(1000); 
        assertEquals(5000, cuenta.saldo, 0.01); 
        assertEquals(0, cuenta.numRetiros); 
    }

    @Test
    public void testExtractoMensualSinComision() {
        CuentaAhorros cuenta = new CuentaAhorros(15000, 12); 
        cuenta.retirar(1000); 
        cuenta.retirar(1000); 
        cuenta.retirar(1000); 
        cuenta.retirar(1000); 
        cuenta.extractoMensual(); 
        assertEquals(11000, cuenta.saldo, 0.01); 
    }

    @Test
    public void testExtractoMensualConComision() {
        CuentaAhorros cuenta = new CuentaAhorros(15000, 12); 
        cuenta.retirar(1000); 
        cuenta.retirar(1000); 
        cuenta.retirar(1000); 
        cuenta.retirar(1000); 
        cuenta.retirar(1000); 
        cuenta.extractoMensual(); 
        assertEquals(9960, cuenta.saldo, 0.01); 
    }

    @Test
    public void testExtractoMensualCuentaInactiva() {
        CuentaAhorros cuenta = new CuentaAhorros(5000, 12); 
        cuenta.extractoMensual(); 
        assertFalse(cuenta.activa); 
    }

    @Test
    public void testImprimir() {
        CuentaAhorros cuenta = new CuentaAhorros(15000, 1.5f); 
        cuenta.retirar(2000); 
        cuenta.consignar(1000); 
        cuenta.imprimir(); 
    }
}