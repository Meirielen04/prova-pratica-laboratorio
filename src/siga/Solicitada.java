package siga;

public class Solicitada extends EstadoReserva {
    
    @Override
    public String getNome() {
        return "SOLICITADA";
    }

    @Override
    public EstadoReserva retirar() {
        return new EmUso();
    }

    @Override
    public EstadoReserva cancelar() {
        return new Encerrada();
    }
}
