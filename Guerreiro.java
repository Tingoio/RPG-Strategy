public class Guerreiro extends Personagem {

    public Guerreiro(String nome) {
        super(nome, 15, 8, 5, 120, 50);
    }

    @Override
    public boolean podeUsarTipoDeArma(iArma arma) {

        return (arma instanceof EspadaLonga || arma instanceof MachadoDeGuerra);
    }

    @Override
    protected void aplicarPassivaDefensiva(int dano) {
        int danoReduzido = (int) (dano * 0.80);
        System.out.println("Pele Dura! " + this.nome + " reduz o dano para " + danoReduzido + ".");
        super.aplicarPassivaDefensiva(danoReduzido);
    }
}