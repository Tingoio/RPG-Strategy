import java.util.List;

public class MachadoDeGuerra implements iArma {
    private final int DANO_BASE = 18;
    private final int CUSTO_MANA = 5;

    @Override public String getNome() { return "Machado de Guerra"; }
    @Override public int getCustoMana() { return CUSTO_MANA; }
    @Override public int getRequisitoForca() { return 15; }
    @Override public int getRequisitoDestreza() { return 0; }
    @Override public int getRequisitoInteligencia() { return 0; }

    @Override
    public void usar(Personagem atacante, List<Personagem> inimigos) {

        Personagem alvo = null;
        for (Personagem p : inimigos) { if (!p.estaMorto()) { alvo = p; break; } }
        if (alvo == null) return;

        System.out.println(atacante.getNome() + " desfere um golpe com seu " + getNome() + " em " + alvo.getNome() + "!");
        
        if (atacante.getManaAtual() < CUSTO_MANA) {
            System.out.println(atacante.getNome() + " não tem mana suficiente!");
            return;
        }
        atacante.gastarMana(CUSTO_MANA);

        alvo.receberDano(DANO_BASE);

        if (Math.random() < 0.25) {
            System.out.println("Golpe Esmagador! " + alvo.getNome() + " está atordoado!");
            alvo.aplicarEfeito(new Atordoado());
        }
    }
}