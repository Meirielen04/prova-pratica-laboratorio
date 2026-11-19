package siga;

public abstract class EstadoReserva {
    
    public abstract String getNome();

    public EstadoReserva retirar() {
        throw recusar("retirar");
    }

    public EstadoReserva devolver() {
        throw recusar("devolver");
    }

    public EstadoReserva cancelar() {
        throw recusar("cancelar");
    }

    private IllegalStateException recusar(String operacao) {
        return new IllegalStateException(
                "Nao e possivel " + operacao + " em " + getNome() + ".");
    }
}
