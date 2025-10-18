import java.util.List;

public class Batalha {
    private List<Personagem> timeHerois;
    private List<Personagem> timeInimigos;
    private int turno;

    public Batalha(List<Personagem> timeHerois, List<Personagem> timeInimigos) {
        this.timeHerois = timeHerois;
        this.timeInimigos = timeInimigos;
        this.turno = 1;
    }

    public void iniciarBatalha() {
        System.out.println("====== A BATALHA COMEÇA! ======");

        while (ambosOsTimesEstaoVivos()) {
            System.out.println("\n--- TURNO " + turno + " ---");
            
            System.out.println("\n=== Vez dos Heróis ===");
            processarTurnoDoTime(timeHerois, timeInimigos);
            if (!timeEstaVivo(timeInimigos)) break;

            System.out.println("\n=== Vez dos Inimigos ===");
            processarTurnoDoTime(timeInimigos, timeHerois);
            if (!timeEstaVivo(timeHerois)) break;

            turno++;
        }

        System.out.println("\n====== A BATALHA TERMINOU! ======");
        if (timeEstaVivo(timeHerois)) {
            System.out.println("Os Heróis venceram!");
        } else {
            System.out.println("Os Inimigos venceram!");
        }
    }

    private void processarTurnoDoTime(List<Personagem> timeAtacante, List<Personagem> timeDefensor) {
        for (Personagem atacante : timeAtacante) {
            if (atacante.estaMorto()) continue;

            atacante.processarInicioTurno();

            if (atacante.estaMorto()) continue;

            if (atacante.estaAtordoado()) {
                 System.out.println(atacante.getNome() + " está atordoado e não pode agir!");
                 continue;
            }

            atacante.atacar(timeDefensor);

            if (!timeEstaVivo(timeDefensor)) break;
            
            System.out.println();
        }
    }

    private boolean ambosOsTimesEstaoVivos() {
        return timeEstaVivo(timeHerois) && timeEstaVivo(timeInimigos);
    }

    private boolean timeEstaVivo(List<Personagem> time) {
        for (Personagem p : time) {
            if (!p.estaMorto()) {
                return true;
            }
        }
        return false;
    }
}
