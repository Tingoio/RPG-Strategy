public class Arqueiro extends Personagem {

    public Arqueiro(String nome) {
        super(nome, 8, 15, 7, 90, 80);
    }

    @Override
    public boolean podeUsarTipoDeArma(iArma arma) {

        return (arma instanceof ArcoElfico || arma instanceof AdagaSombria);
    }


    @Override
    protected void aplicarPassivaDefensiva(int dano) {
        if (Math.random() < 0.25) {
            System.out.println("Esquiva! " + this.nome + " evitou o ataque completamente!");
            return;
        }
        super.aplicarPassivaDefensiva(dano);
    }
}