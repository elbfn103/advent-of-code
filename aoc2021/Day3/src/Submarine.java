import java.util.List;

public class Submarine {

    private String gamma;
    private String epsilon;
    private String oxygenRating;
    private String co2Rating;
    private int[] bits;

    public Submarine(String gamma, String epsilon, String oxygenRating, String co2Rating, int[] bits) {
        this.gamma = gamma;
        this.epsilon = epsilon;
        this.oxygenRating = oxygenRating;
        this.co2Rating = co2Rating;
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

        setGamma(gammaBin);
        setEpsilon(epsilonBin);
    }

    public void oxygenRating(List<String> lines) {

        for (int i = 0; i <= lines.get(0).length(); i++) {

            if (lines.size() == 1) {
                setOxygenRating(lines.get(0));
                break;
            }

            int count = 0;
            for (String line : lines) {
                char c = line.charAt(i);
                if (c == '1') {
                    count++;
                } else {
                    count--;
                }
            }

            int finalI = i;
            if (count >= 0) {
                lines = lines.stream().filter(s -> s.charAt(finalI) == '1').toList();
            } else {
                lines = lines.stream().filter(s -> s.charAt(finalI) == '0').toList();
            }
            System.out.println(lines);
        }
    }

    public void co2Rating(List<String> lines) {

        for (int i = 0; i <= lines.get(0).length(); i++) {

            if (lines.size() == 1) {
                setCo2Rating(lines.get(0));
                break;
            }

            int count = 0;
            for (String line : lines) {
                char c = line.charAt(i);
                if (c == '1') {
                    count++;
                } else {
                    count--;
                }
            }

            int finalI = i;
            if (count >= 0) {
                lines = lines.stream().filter(s -> s.charAt(finalI) == '0').toList();
            } else {
                lines = lines.stream().filter(s -> s.charAt(finalI) == '1').toList();
            }
        }
    }

    public int getGamma() {
        return Integer.parseInt(gamma, 2);
    }

    public void setGamma(String gamma) {
        this.gamma = gamma;
    }

    public int getEpsilon() {
        return Integer.parseInt(epsilon, 2);
    }

    public void setEpsilon(String epsilon) {
        this.epsilon = epsilon;
    }

    public int getOxygenRating() {
        return Integer.parseInt(oxygenRating, 2);
    }

    public void setOxygenRating(String oxygenRating) {
        this.oxygenRating = oxygenRating;
    }

    public int getCo2Rating() {
        return Integer.parseInt(co2Rating, 2);
    }

    public void setCo2Rating(String co2Rating) {
        this.co2Rating = co2Rating;
    }

    public int getPowerConsumption() {
        return getGamma() * getEpsilon();
    }

    public int getLifeSupportRating() {
        return getOxygenRating() * getCo2Rating();
    }
}
