import java.util.List;

public class ArcoElfico implements iArma {
    private final int DANO_BASE = 12;
    private final int CUSTO_MANA = 15;

    @Override public String getNome() { return "Arco Élfico"; }
    @Override public int getCustoMana() { return CUSTO_MANA; }
    @Override public int getRequisitoForca() { return 0; }
    @Override public int getRequisitoDestreza() { return 8; }
    @Override public int getRequisitoInteligencia() { return 0; }

    @Override
    public void usar(Personagem atacante, List<Personagem> inimigos) {
        System.out.println(atacante.getNome() + " usa " + getNome() + " para disparar uma 'Chuva de Flechas'!");

        if (atacante.getManaAtual() < CUSTO_MANA) {
            System.out.println(atacante.getNome() + " não tem mana suficiente!");
            return;
        }
        atacante.gastarMana(CUSTO_MANA);

        for (Personagem alvo : inimigos) {
            if (!alvo.estaMorto()) {
                System.out.println(alvo.getNome() + " é atingido pela chuva de flechas!");
                alvo.receberDano(DANO_BASE);
            }
        }
    }
}