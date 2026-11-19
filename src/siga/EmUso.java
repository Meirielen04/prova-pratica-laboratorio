package siga;

public class EmUso extends EstadoReserva {
    
    @Override
    public String getNome() {
        return "EM_USO";
    }

    @Override
    public EstadoReserva devolver() {
        return new Encerrada();
    }
}
