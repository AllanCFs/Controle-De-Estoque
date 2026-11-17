# language: pt
Funcionalidade: Controle de Estoque
  Uma loja precisa registrar entradas e saídas de produtos,
  consultar o saldo e impedir retiradas acima da quantidade disponível.

  Cenário: Entrada de produtos
    Dado que o produto "Monitor" possui 10 unidades em estoque
    Quando eu adiciono 5 unidades ao estoque
    Então o saldo do estoque deve ser 15 unidades

  Cenário: Saída com saldo suficiente
    Dado que o produto "Monitor" possui 10 unidades em estoque
    Quando eu solicito a retirada de 4 unidades
    Então a retirada deve ser aprovada
    E o saldo do estoque deve ser 6 unidades

  Cenário: Saída com saldo insuficiente
    Dado que o produto "Monitor" possui 10 unidades em estoque
    Quando eu solicito a retirada de 15 unidades
    Então a retirada deve ser recusada
    E o saldo do estoque deve ser 10 unidades
