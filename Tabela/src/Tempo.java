public class Tempo {
    private long tempoIni = 0;
    private long tempoFim = 0;

    public void initClock() {
        tempoIni = tempoFim = System.nanoTime();
    }
    public double getClockSec() {
        double res;

        tempoFim = System.nanoTime();

        res = ((double) tempoFim - (double) tempoIni) / (double) 1_000_000_000.0;

        return res;
    }
}
