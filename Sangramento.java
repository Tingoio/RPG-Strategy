public class Sangramento implements iStatusEffect {
    private int duracao = 3;
    private final int DANO_POR_TURNO = 5;

    @Override public String getNome() { return "Sangramento"; }
    @Override public boolean estaAtivo() { return duracao > 0; }

    @Override
    public void processar(Personagem alvo) {
        if (this.estaAtivo()) {
            System.out.println(alvo.getNome() + " sofre " + DANO_POR_TURNO + " de dano de sangramento.");
            alvo.sofrerDanoEfeito(DANO_POR_TURNO);
            duracao--;
        }
    }
}