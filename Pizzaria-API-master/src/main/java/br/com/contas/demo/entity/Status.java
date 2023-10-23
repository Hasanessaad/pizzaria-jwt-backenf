package br.com.contas.demo.entity;
public enum Status {
   PENDENTE(0),
    FEITO(1),
    ENVIADO(2),
    ENTREGUE(3),
    CANCELADO(4),
    PAGO(5);

    private final int value;

    Status(int value) {
        this.value = value;
    }
}