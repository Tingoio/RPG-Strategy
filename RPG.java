import java.util.Arrays;
import java.util.List;

public class RPG {
    public static void main(String[] args) {
        // 1. Criar as Armas (Estratégias)
        iArma espada = new EspadaLonga();
        iArma machado = new MachadoDeGuerra();
        iArma arco = new ArcoElfico();
        iArma adaga = new AdagaSombria();
        iArma cajado = new CajadoArcano();

        // 2. Criar os Personagens (Contextos)
        Personagem garen = new Guerreiro("Garen (Guerreiro)");
        Personagem ashe = new Arqueiro("Ashe (Arqueira)");
        Personagem ryze = new Mago("Ryze (Mago)");

        // 3. Equipar as armas (Definir as Estratégias)
        System.out.println("--- EQUIPANDO ARMAS ---");
        garen.equiparArma(machado);
        ashe.equiparArma(arco);
        ryze.equiparArma(cajado);
        
        System.out.println("\n--- TENTATIVAS DE EQUIPAR INVÁLIDAS ---");
        garen.equiparArma(arco);    // Falha (Guerreiro não usa Arco)
        ryze.equiparArma(espada);   // Falha (Mago não usa Espada)
        
        // Teste de requisito (Mago tentando usar Adaga Sombria)
        // Mago tem Int 18, Dex 7. Adaga requer Dex 12.
        ryze.equiparArma(adaga);    // Falha (Não tem Destreza suficiente)
        
        // Arqueiro (Dex 15) tentando usar Adaga (Req Dex 12)
        ashe.equiparArma(adaga);    // OK (Troca o Arco pela Adaga)
        
        // Re-equipando o arco para a batalha
        ashe.equiparArma(arco);
        
        System.out.println("\n--- FIM DA FASE DE EQUIPAMENTO ---");


        // 4. Criar Inimigos
        // Vamos usar as mesmas classes, mas com nomes diferentes
        Personagem goblinLider = new Guerreiro("Goblin Líder");
        Personagem goblinAtirador1 = new Arqueiro("Goblin Atirador 1");
        Personagem goblinAtirador2 = new Arqueiro("Goblin Atirador 2");
        
        goblinLider.equiparArma(espada);
        goblinAtirador1.equiparArma(adaga);
        goblinAtirador2.equiparArma(adaga);

        // 5. Preparar a Batalha
        List<Personagem> herois = Arrays.asList(garen, ashe, ryze);
        List<Personagem> inimigos = Arrays.asList(goblinLider, goblinAtirador1, goblinAtirador2);

        // 6. Iniciar a Batalha
        Batalha batalha = new Batalha(herois, inimigos);
        batalha.iniciarBatalha();
    }
}