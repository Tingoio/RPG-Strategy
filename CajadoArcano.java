import java.util.List;

public class CajadoArcano implements iArma {
    private final int DANO_BASE = 8;
    private final int CUSTO_MANA = 25;

    @Override public String getNome() { return "Cajado Arcano"; }
    @Override public int getCustoMana() { return CUSTO_MANA; }
    @Override public int getRequisitoForca() { return 0; }
    @Override public int getRequisitoDestreza() { return 0; }
    @Override public int getRequisitoInteligencia() { return 12; }

    @Override
    public void usar(Personagem atacante, List<Personagem> inimigos) {
        // Ataque de alvo único
        Personagem alvo = null;
        for (Personagem p : inimigos) {
            if (!p.estaMorto()) {
                alvo = p;
                break;
            }
        }
        if (alvo == null) return;

        System.out.println(atacante.getNome() + " lança 'Bola de Fogo' de seu " + getNome() + " em " + alvo.getNome() + "!");

        if (atacante.getManaAtual() < CUSTO_MANA) {
            System.out.println(atacante.getNome() + " não tem mana suficiente!");
            return;
        }
        atacante.gastarMana(CUSTO_MANA);

        alvo.receberDano(DANO_BASE);

        System.out.println(alvo.getNome() + " está queimando!");
        alvo.aplicarEfeito(new Queimadura());
    }
}
