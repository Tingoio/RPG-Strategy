import java.util.List;

public class AdagaSombria implements iArma {
    private final int DANO_BASE = 10;
    private final int CUSTO_MANA = 10;

    @Override public String getNome() { return "Adaga Sombria"; }
    @Override public int getCustoMana() { return CUSTO_MANA; }
    @Override public int getRequisitoForca() { return 0; }
    @Override public int getRequisitoDestreza() { return 12; }
    @Override public int getRequisitoInteligencia() { return 0; }

    @Override
    public void usar(Personagem atacante, List<Personagem> inimigos) {

        Personagem alvo = null;
        for (Personagem p : inimigos) { if (!p.estaMorto()) { alvo = p; break; } }
        if (alvo == null) return;
        
        System.out.println(atacante.getNome() + " apunhala " + alvo.getNome() + " com a " + getNome() + ".");

        if (atacante.getManaAtual() < CUSTO_MANA) {
            System.out.println(atacante.getNome() + " não tem mana suficiente!");
            return;
        }
        atacante.gastarMana(CUSTO_MANA);

        int danoFinal = DANO_BASE;

        if (alvo.getVidaAtual() == alvo.getVida()) {
            System.out.println("Ataque Furtivo! O alvo estava desprevenido. Dano triplicado!");
            danoFinal *= 3;
        }

        alvo.receberDano(danoFinal);
    }
}