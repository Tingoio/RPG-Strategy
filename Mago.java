public class Mago extends Personagem {

    public Mago(String nome) {
        super(nome, 5, 7, 18, 70, 150);
    }

    @Override
    public boolean podeUsarTipoDeArma(iArma arma) {
        
        return (arma instanceof CajadoArcano || arma instanceof AdagaSombria);
    }

    @Override
    public void aplicarPassivaDeTurno() {
        super.aplicarPassivaDeTurno();
        this.manaAtual = Math.min(this.mana, this.manaAtual + 10);
        System.out.println("Regeneração de Mana! " + this.nome + " regenera 10 de mana.");
    }
}
