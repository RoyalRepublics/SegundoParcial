package practicapoo_banksystem;

class Cuentalimitada extends Cuenta {
    public Cuentalimitada(double saldoCapital) {
        super(saldoCapital);
    }

    @Override
    public void salidaCapital(double valor) {
        if (valor > 500) {
            System.out.println("Su monto supera el límite máximo diario.");
        } else {
            double saldoActual=getSaldoCapital();
            saldoActual += valor;
            setSaldoCapital(saldoActual);
                    System.out.println(getSaldoCapital());
        }
    }
    
}