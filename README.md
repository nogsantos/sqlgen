# Simple SQL generator

[![CircleCI](https://circleci.com/gh/nogsantos/sqlgen.svg?style=svg)](https://circleci.com/gh/nogsantos/sqlgen)

Este problema visa criar um gerador de scripts SQL. Dado o tipo de operação, as informações de metadados, como nomes de colunas e tabela, e os parâmetros necessários, o programa criado deve gerar o script SQL correspondente no formato correto.
A solução criada deve ser proporcionar o maior reaproveitamento de código na criação de queries que o candidato conseguir.

## Especificação

1. [x] O usuário deve indicar uma das operações básicas de manipulação do SQL: `SELECT`, `INSERT`, `UPDATE` ou `DELETE`.
2. [x] O usuário deve indicar a tabela onde ocorrerá a operação.
3. [x] O usuário poderá indicar operações `JOIN`, sendo elas do tipo `INNER JOIN`, `LEFT OUTER JOIN`, `RIGHT OUTER JOIN`, e `CROSS JOIN`. Caso o tipo de `JOIN` não seja indicado, considerar `INNER JOIN` como padrão.
4. [x] O usuário poderá especificar apelidos para cada tabela selecionada.
5. [x] O usuário poderá adicionar diferentes critérios de selecão na cláusula `WHERE`.
6. [ ] Os critérios de seleção da cláusula `WHERE` e outros campos parametrizados, no caso de `INSERT` e `UPDATE`, deverão aceitar objetos númericos, tanto inteiros como ponto flutuante, datas, valores booleanos e strings.
7. [ ] Os objetos do tipo data deverão ser impressos no formato 'yyyy-mm-dd'.
8. [ ] O usuário poderá informar o esquema do banco ao qual as tabelas selecionadas pertencem.
9. [x] No caso de `SELECT`, o usuário poderá informar quais colunas serão selecionadas. Caso nenhuma seja explicitada, todas as colunas devem ser selecionadas. Caso o usuário informe a seleção de um apelido, todas as colunas da tabela correspondente devem ser selecionadas.
10. [ ] No caso de `INSERT`, a ordem final de declaração das colunas deve coincidir com a ordem em que os parâmetros são fornecidos.
11. [ ] O usuário ainda poderá especificar cláusulas `COUNT`, `AVG`, `MAX`, `MIN`, `GROUP BY` e `ORDER BY`.

#### EXEMPLO

```java
assertEquals("select pes.*, vei.placa from pessoa as pes inner join veiculo as vei on pes.rg = vei.rg", SQL.select("pessoa", "pes").join("veiculo", "vei", "rg").columns(new String[]{"pes", "vei.placa"}).toString())
```
