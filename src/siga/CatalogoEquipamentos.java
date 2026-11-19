package siga;

import java.util.ArrayList;
import java.util.List;
public class CatalogoEquipamentos {

    private final FonteEquipamentos fonte;

    public CatalogoEquipamentos(FonteEquipamentos fonte) {
        this.fonte = fonte;
    }

    public List<Equipamento> listarDisponiveis() {
        List<Equipamento> disponiveis = new ArrayList<>();
        for (Equipamento item : fonte.listarTodos()) {
            if (item.isDisponivel()) {
                disponiveis.add(item);
            }
        }
        return disponiveis;
    }
}
