// Bernardo Luiz Montverde Gonçalves - 4251923322

public class ArattaiGrowthTracker {

    public static void main(String[] args) {
        
        int [] downloadsDiarios = {850000, 1050000, 1100000, 950000, 1200000, 1000000, 850000};
        String [] diasDaSemana = {"Dom", "Seg", "Ter", "Qua", "Qui", "Sex", "Sáb"};



        int totalDownloads = 0;
        for (int d : downloadsDiarios) {
            totalDownloads += d;
        }

        String totalFormatado = String.format ("%d", totalDownloads).replaceAll ("\\B(?=(\\d{3})+(?!\\d))", ".");
        System.out.println ("Total de Downloads na Semana: " + totalFormatado);

        int indicePico = 0;
        int indiceMinimo = 0;
        
        for (int i = 1; i < downloadsDiarios.length; i++) {
            if (downloadsDiarios[i] > downloadsDiarios[indicePico]) {
                indicePico = i;
            }
            if (downloadsDiarios[i] < downloadsDiarios[indiceMinimo]) {
                indiceMinimo = i;
            }
        }

        String picoFormatado = String.format("%d", downloadsDiarios[indicePico]).replaceAll("\\B(?=(\\d{3})+(?!\\d))", ".");
        String minimoFormatado = String.format("%d", downloadsDiarios[indiceMinimo]).replaceAll("\\B(?=(\\d{3})+(?!\\d))", ".");
        
        System.out.println("Dia de Pico de Downloads: " + diasDaSemana[indicePico] + " com " + picoFormatado + " downloads.");
        System.out.println("Dia de Mínimo de Downloads: " + diasDaSemana[indiceMinimo] + " com " + minimoFormatado + " downloads.");

        final int META_DIARIA = 1_000_000;
        int diasAcimaDaMeta = 0;
        
        for (int downloads : downloadsDiarios) {
            if (downloads > META_DIARIA) {
                diasAcimaDaMeta++;
            }
        }
        
        System.out.println("O Arattai superou a meta diária em " + diasAcimaDaMeta + " dias esta semana.");
    }
}