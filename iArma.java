import java.util.List;

public interface iArma {
    String getNome();
    int getCustoMana();
    
    // Requisitos para equipar
    int getRequisitoForca();
    int getRequisitoDestreza();
    int getRequisitoInteligencia();

    void usar(Personagem atacante, List<Personagem> inimigos);
}
