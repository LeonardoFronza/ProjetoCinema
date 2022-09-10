package Cinema;

public class Mapa {
    private String[][] assentos;
    private boolean validaMapa = false;
    public Mapa(int linha, int coluna) {
        inicializaMapa(linha, coluna);
    }

    public boolean inicializaMapa(int linha, int coluna) {
        if(linha <= 0 || coluna <= 0){
            return false;
        }

        assentos = new String[linha][coluna];

        for (int a = 0; a < assentos.length; a++) {
            for (int b= 0; b < assentos[0].length; b++){
                assentos[a][b] = "O ";
            }
        }

        for (int a = 1; a < assentos.length; a++) {
            assentos[a][0] = (char)((a-1)+65) + " ";
        }
        for (int b = 1; b < assentos[0].length; b++) {
            assentos[0][b] = " " + b;
        }
        assentos[0][0] = " ";

        validaMapa = true;
        return true;
    }

    public boolean isValidaMapa() {
        return validaMapa;
    }

    public String[][] getAssentos() {
        return assentos;
    }

    public void setAssentos(String[][] assentos) {
        this.assentos = assentos;
    }
}
