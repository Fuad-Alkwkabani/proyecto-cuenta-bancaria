package bank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CuentaTest {

    @Test
    public void testConsignar() {
        Cuenta cuenta = new Cuenta(1000, 1.5f); // Saldo inicial: 1000, tasa anual: 1.5%
        cuenta.consignar(500);
        assertEquals(1500, cuenta.saldo, 0.01); // Verifica que el saldo sea 1500
        assertEquals(1, cuenta.numConsignaciones); // Verifica que se haya registrado una consignación
    }

    @Test
    public void testRetirar() {
        Cuenta cuenta = new Cuenta(1000, 1.5f); // Saldo inicial: 1000, tasa anual: 1.5%
        cuenta.retirar(300);
        assertEquals(700, cuenta.saldo, 0.01); // Verifica que el saldo sea 700
        assertEquals(1, cuenta.numRetiros); // Verifica que se haya registrado un retiro
    }

    @Test
    public void testRetirarFondosInsuficientes() {
        Cuenta cuenta = new Cuenta(1000, 1.5f); // Saldo inicial: 1000, tasa anual: 1.5%
        cuenta.retirar(1500); // Intenta retirar más de lo que hay en la cuenta
        assertEquals(1000, cuenta.saldo, 0.01); // Verifica que el saldo no haya cambiado
        assertEquals(0, cuenta.numRetiros); // Verifica que no se haya registrado el retiro
    }

    @Test
    public void testCalcularInteresMensual() {
        Cuenta cuenta = new Cuenta(1000, 12); // Saldo inicial: 1000, tasa anual: 12%
        cuenta.calcularInteresMensual();
        assertEquals(1010, cuenta.saldo, 0.01); // Interés mensual: 1000 * (12 / 12) / 100 = 10
    }

    @Test
    public void testExtractoMensual() {
        Cuenta cuenta = new Cuenta(1000, 12); // Saldo inicial: 1000, tasa anual: 12%
        cuenta.consignar(500);
        cuenta.retirar(200);
        cuenta.extractoMensual(); // Aplica comisión mensual e interés
        assertEquals(1307.5, cuenta.saldo, 0.01); // Saldo final: 1300 - 0 (comisión) + 7.5 (interés)
    }

    @Test
    public void testImprimir() {
        Cuenta cuenta = new Cuenta(1000, 1.5f); // Saldo inicial: 1000, tasa anual: 1.5%
        cuenta.consignar(500);
        cuenta.retirar(200);
        cuenta.imprimir(); // Este método no retorna nada, pero puedes verificar la salida en consola
    }
}