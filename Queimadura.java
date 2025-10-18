public class Queimadura implements iStatusEffect {
    private int duracao = 2;
    private final int DANO_POR_TURNO = 10;

    @Override public String getNome() { return "Queimadura"; }
    @Override public boolean estaAtivo() { return duracao > 0; }

    @Override
    public void processar(Personagem alvo) {
        if (this.estaAtivo()) {
            System.out.println(alvo.getNome() + " sofre " + DANO_POR_TURNO + " de dano de queimadura.");
            alvo.sofrerDanoEfeito(DANO_POR_TURNO);
            duracao--;
        }
    }
}