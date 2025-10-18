import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Personagem {

    protected String nome;
    protected int forca;
    protected int destreza;
    protected int inteligencia;
    protected int vida;
    protected int mana;
 
    protected int vidaAtual;
    protected int manaAtual;
    protected List<iStatusEffect> statusEffects;

    private iArma armaEquipada;

    public Personagem(String nome, int forca, int destreza, int inteligencia, int vida, int mana) {
        this.nome = nome;
        this.forca = forca;
        this.destreza = destreza;
        this.inteligencia = inteligencia;
        this.vida = vida;
        this.mana = mana;
        this.vidaAtual = vida;
        this.manaAtual = mana;
        this.statusEffects = new ArrayList<>();
    }

    public void equiparArma(iArma novaArma) {

        if (this.forca < novaArma.getRequisitoForca() ||
            this.destreza < novaArma.getRequisitoDestreza() ||
            this.inteligencia < novaArma.getRequisitoInteligencia()) {
            
            System.out.println(this.nome + " não tem atributos suficientes para " + novaArma.getNome() + ".");
            return;
        }

        if (!this.podeUsarTipoDeArma(novaArma)) {
            System.out.println(this.nome + " (Classe: " + this.getClass().getSimpleName() + ") não pode equipar " + novaArma.getNome() + ".");
            return;
        }

        this.armaEquipada = novaArma;
        System.out.println(this.nome + " equipou " + novaArma.getNome() + ".");
    }
    
    public abstract boolean podeUsarTipoDeArma(iArma arma);

    public void atacar(List<Personagem> inimigos) {
        if (this.armaEquipada == null) {
            System.out.println(this.nome + " está desarmado e não pode atacar!");
            return;
        }
        if (this.estaAtordoado()) {
            System.out.println(this.nome + " está atordoado e perdeu o turno de ataque!");
            return;
        }
        
        this.armaEquipada.usar(this, inimigos);
    }

    public void processarInicioTurno() {
        System.out.println("--- Início do turno de " + this.nome + " (" + this.vidaAtual + "/" + this.vida + " HP, " + this.manaAtual + "/" + this.mana + " MP) ---");
        this.aplicarPassivaDeTurno();
        this.processarEfeitosDeStatus();
    }

    public void aplicarEfeito(iStatusEffect efeito) {
        // Lógica para evitar duplicatas ou resetar duração (simplificado)
        this.statusEffects.add(efeito);
        System.out.println(this.nome + " agora está sob o efeito de " + efeito.getNome() + ".");
    }

    private void processarEfeitosDeStatus() {
        Iterator<iStatusEffect> iterator = statusEffects.iterator();
        while (iterator.hasNext()) {
            iStatusEffect efeito = iterator.next();
            efeito.processar(this); // Aplica o efeito
            if (!efeito.estaAtivo()) {
                System.out.println("O efeito " + efeito.getNome() + " acabou em " + this.nome + ".");
                iterator.remove(); // Remove se a duração acabou
            }
        }
    }

    public boolean estaAtordoado() {
        for (iStatusEffect efeito : statusEffects) {
            if (efeito instanceof Atordoado && efeito.estaAtivo()) {
                return true;
            }
        }
        return false;
    }
    
    public boolean estaMorto() {
        return this.vidaAtual <= 0;
    }

    public void sofrerDanoEfeito(int dano) {
        this.vidaAtual -= dano;
        System.out.println(this.nome + " sofre " + dano + " de dano de efeito!");
        if (this.estaMorto()) {
            System.out.println(this.nome + " morreu devido a efeitos.");
        }
    }

    public void receberDano(int dano) {

        this.aplicarPassivaDefensiva(dano);
    }
    
    protected void aplicarPassivaDefensiva(int dano) {
        this.vidaAtual -= dano;
        System.out.println(this.nome + " recebe " + dano + " de dano.");
        if (this.estaMorto()) {
            System.out.println(this.nome + " foi derrotado.");
        }
    }

    public void aplicarPassivaDeTurno() {

    }

    public String getNome() { return nome; }
    public int getVida() { return vida; }
    public int getVidaAtual() { return vidaAtual; }
    public int getManaAtual() { return manaAtual; }
    public void gastarMana(int custo) { this.manaAtual -= custo; }
}