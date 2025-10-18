import java.util.List;

public class EspadaLonga implements iArma {
    private final int DANO_BASE = 15;
    private final int CUSTO_MANA = 0;

    @Override public String getNome() { return "Espada Longa"; }
    @Override public int getCustoMana() { return CUSTO_MANA; }
    @Override public int getRequisitoForca() { return 10; }
    @Override public int getRequisitoDestreza() { return 0; }
    @Override public int getRequisitoInteligencia() { return 0; }

    @Override
    public void usar(Personagem atacante, List<Personagem> inimigos) {

        Personagem alvo = null;
        for (Personagem p : inimigos) {
            if (!p.estaMorto()) {
                alvo = p;
                break;
            }
        }
        if (alvo == null) return;

        System.out.println(atacante.getNome() + " ataca " + alvo.getNome() + " com a " + getNome() + ".");
        
        alvo.receberDano(DANO_BASE);

        if (Math.random() < 0.30) {
            System.out.println("Corte Profundo! " + alvo.getNome() + " está sangrando.");
            alvo.aplicarEfeito(new Sangramento());
        }
    }
}