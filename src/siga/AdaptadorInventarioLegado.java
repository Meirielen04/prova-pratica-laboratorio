package siga;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorInventarioLegado implements FonteEquipamentos {
   private static final int CODIGO = 0;
   private static final int DESCRICAO = 1;
   private static final int SITUACAO = 2;
   private final InventarioLegadoWS legado;

   public AdaptadorInventarioLegado(InventarioLegadoWS var1) {
      this.legado = var1;
   }

   public List<Equipamento> listarTodos() {
      ArrayList var1 = new ArrayList();

      for(String[] var5 : this.legado.consultarEquipamentos()) {
         Equipamento var6 = new Equipamento(var5[0], var5[1]);
         var6.setDisponivel("D".equalsIgnoreCase(var5[2]));
         var1.add(var6);
      }

      return var1;
   }
}
