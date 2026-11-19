# Respostas — Sistema de Reserva de Laboratorio

Nome completo: Meirielen da Silva  RA: 3111392523021

> Preencha **todos** os campos. Campo vazio é campo não avaliado.
> Não apague os títulos nem os rótulos em negrito: a correção procura por eles.

---

# Etapa 1 — Diagnóstico

## Problema 1 — a conversão do inventario patrimonial

**Em que consiste o problema, e o que acontece quando o sistema cresce:**
Como a letra miniscula não é tratada nas duas classes que chama, gera logica de conversão escrita em duas classes e quantos mais itens, mais arquivos tem que converter e qualquer mudança exige corrigir todas as copias

**Princípio SOLID violado:**
SRP e DIP

**Classes afetadas (pelo nome):** `CatalogoEquipamento` e `RelatorioAcervo` + a main


**Que outra dependência indevida essas classes têm em relação ao
inventario patrimonial, e por que ela é um problema:**
Elas dependem de `InventarioLegadoWS` e é um problema porque viola o DIP. Assim as regras de catalogo e de relatorio fica acoplado a um serviço legado, precisando mudar a cada alteração.

## Problema 2 — o ciclo de vida de Reserva

**Em que consiste o problema, e o que acontece quando o sistema cresce:**
As regras estão espalhadas com if/else, sem um lugar que mostre o ciclo inteiro. Um novo estado ou operação obriga a alterar todos os métodos, aumentando o risco de quebrar o que funciona.

**Princípio SOLID violado:**
OCP

**Classes afetadas (pelo nome):**
`Reserva` 

---

# Etapa 4 — Justificativa

## Padrão aplicado ao Problema 1

**O problema que ele resolve (descreva antes de nomear o padrão):**
A interface `FonteEquipamentos` e a classe `AdaptadorInventarioLegado` fazem a conversão num só lugar, e os clientes dependem só da interface.

**Nome do padrão:**
Adapter

**Alternativa descartada e por que ela não resolveria por completo:**
Alterar o serviço legado é proibido, pois pertence a outra equipe.
Mesmo assim, os clientes ainda dependeriam da classe concreta `InventarioLegadoWS`.


## Padrão aplicado ao Problema 2

**O problema que ele resolve (descreva antes de nomear o padrão):**
Cada fase (`Solicitada`, `EmUso`, `Encerrada`) vira uma classe que sabe o que é permitido nela, e `Reserva` só delega para a fase atual.

**Nome do padrão:**
State

**Alternativa descartada e por que ela não resolveria por completo:**
Trocar a `String` por um `enum` só evitaria erros de digitação.
As regras continuariam em `if`/`switch` dentro de cada método, e um novo estado ainda exigiria alterar todos eles.