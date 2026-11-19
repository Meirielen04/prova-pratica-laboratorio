package siga;

public class Reserva {

    private final Usuario solicitante;
    private final Equipamento item;
    private EstadoReserva estado;

    public Reserva(Usuario solicitante, Equipamento item) {
        this.solicitante = solicitante;
        this.item = item;
        this.estado = new Solicitada();
    }

    public String getSituacao() {
        return estado.getNome();
    }

    public void retirar() {
        estado = estado.retirar();
    }

    public void devolver() {
        estado = estado.devolver();
    }

    public void cancelar() {
        estado = estado.cancelar();
    }

    public Usuario getSolicitante() {
        return solicitante;
    }

    public Equipamento getEquipamento() {
        return item;
    }
}
