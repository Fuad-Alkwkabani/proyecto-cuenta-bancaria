package bank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CuentaCorrienteTest {

    @Test
    public void testRetirarSinSobregiro() {
        CuentaCorriente cuenta = new CuentaCorriente(1000, 1.5f); 
        cuenta.retirar(500); 
        assertEquals(500, cuenta.saldo, 0.01); 
        assertEquals(0, cuenta.sobregiro, 0.01); 
        assertEquals(1, cuenta.numRetiros); 
    }

    @Test
    public void testRetirarConSobregiro() {
        CuentaCorriente cuenta = new CuentaCorriente(1000, 1.5f); 
        cuenta.retirar(1500); 
        assertEquals(0, cuenta.saldo, 0.01); 
        assertEquals(500, cuenta.sobregiro, 0.01); 
        assertEquals(1, cuenta.numRetiros); 
    }

    @Test
    public void testConsignarSinSobregiro() {
        CuentaCorriente cuenta = new CuentaCorriente(1000, 1.5f); 
        cuenta.consignar(500); 
        assertEquals(1500, cuenta.saldo, 0.01); 
        assertEquals(0, cuenta.sobregiro, 0.01); 
        assertEquals(1, cuenta.numConsignaciones); 
    }

    @Test
    public void testConsignarConSobregiro() {
        CuentaCorriente cuenta = new CuentaCorriente(1000, 1.5f); 
        cuenta.retirar(1500); 
        cuenta.consignar(300); 
        assertEquals(0, cuenta.saldo, 0.01); 
        assertEquals(200, cuenta.sobregiro, 0.01); 
        assertEquals(1, cuenta.numConsignaciones); 
    }

    @Test
    public void testConsignarCubrirSobregiro() {
        CuentaCorriente cuenta = new CuentaCorriente(1000, 1.5f); 
        cuenta.retirar(1500); 
        cuenta.consignar(600); 
        assertEquals(100, cuenta.saldo, 0.01); 
        assertEquals(0, cuenta.sobregiro, 0.01); 
        assertEquals(1, cuenta.numConsignaciones); 
    }

    @Test
    public void testExtractoMensual() {
        CuentaCorriente cuenta = new CuentaCorriente(1000, 12); 
        cuenta.retirar(500); 
        cuenta.consignar(200); 
        cuenta.extractoMensual(); 
        assertEquals(707, cuenta.saldo, 0.01); 
    }

    @Test
    public void testImprimir() {
        CuentaCorriente cuenta = new CuentaCorriente(1000, 1.5f); 
        cuenta.retirar(500); 
        cuenta.consignar(200); 
        cuenta.imprimir(); 
    }
}