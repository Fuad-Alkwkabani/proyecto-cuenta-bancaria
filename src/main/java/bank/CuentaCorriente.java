package bank;

public class CuentaCorriente extends Cuenta {
    float sobregiro = 0;

    public CuentaCorriente(float saldo, float tasaAnual) {
        super(saldo, tasaAnual);
    }

    @Override
    public void retirar(float cantidad) {
        float saldoNecesario = cantidad - saldo;
        if (saldoNecesario > 0) {
            sobregiro += saldoNecesario;
            saldo = 0;
        } else {
            saldo -= cantidad;
        }
        numRetiros++;
    }

    @Override
    public void consignar(float cantidad) {
        if (sobregiro > 0) {
            if (cantidad <= sobregiro) {
                sobregiro -= cantidad;
            } else {
                saldo += (cantidad - sobregiro);
                sobregiro = 0;
            }
        } else {
            super.consignar(cantidad);
        }
    }

    @Override
    public void extractoMensual() {
        super.extractoMensual();
    }

    @Override
    public void imprimir() {
        System.out.println("Cuenta Corriente");
        super.imprimir();
        System.out.println("Sobregiro: " + sobregiro);
    }
}
