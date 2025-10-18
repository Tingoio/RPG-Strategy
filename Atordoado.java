public class Atordoado implements iStatusEffect {
    private int duracao = 1;

    @Override public String getNome() { return "Atordoado"; }
    @Override public boolean estaAtivo() { return duracao > 0; }

    @Override
    public void processar(Personagem alvo) {
        if (this.estaAtivo()) {
            System.out.println(alvo.getNome() + " continua atordoado.");
            duracao--;
        }
    }
}