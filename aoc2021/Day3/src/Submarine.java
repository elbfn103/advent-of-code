public class Submarine {

    private int gamma;
    private int epsilon;
    private int[] bits;

    public Submarine(int gamma, int epsilon, int[] bits) {
        this.gamma = gamma;
        this.epsilon = epsilon;
        this.bits = bits;
    }

    public void processDiagnostic(String line) {

        for(int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '1') {
                bits[i]++;
            } else {
                bits[i]--;
            }
        }

        String gammaBin = "";
        String epsilonBin = "";

        for (int i : bits) {
            if (i > 0) {
                gammaBin += '1';
                epsilonBin += '0';
            } else {
                gammaBin += '0';
                epsilonBin += '1';
            }
        }

        setGamma(Integer.parseInt(gammaBin, 2));
        setEpsilon(Integer.parseInt(epsilonBin, 2));
    }

    public int getGamma() {
        return gamma;
    }

    public void setGamma(int gamma) {
        this.gamma = gamma;
    }

    public int getEpsilon() {
        return epsilon;
    }

    public void setEpsilon(int epsilon) {
        this.epsilon = epsilon;
    }

    public int getPowerConsumption() {
        return getGamma() * getEpsilon();
    }
}
