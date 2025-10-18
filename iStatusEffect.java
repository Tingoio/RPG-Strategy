public interface iStatusEffect {
    String getNome();
    boolean estaAtivo();
    
    /** Processa o efeito no início do turno do personagem afetado. */
    void processar(Personagem alvo);
}