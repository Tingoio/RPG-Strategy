# RPG com Padrão Strategy

Este projeto é um exemplo de implementação do **Design Pattern Strategy** em Java, simulando um sistema de combate básico de RPG.

O padrão é usado para definir os diferentes tipos de ataque. Cada `Arma` é uma "Estratégia" que implementa a interface `iArma`. A classe `Personagem` (o "Contexto") usa uma instância de `iArma` para executar seu ataque, podendo trocar de arma (e, portanto, de estratégia) dinamicamente.
