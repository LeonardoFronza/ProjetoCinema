package Cinema;

public class Opcoes {

    Mapa mapa;
    public int assentosLivres = 0, assentosOcupados = 0;

    public Opcoes(int linha, int coluna){
        mapa = new Mapa(linha,coluna);
    }

    public boolean reservaAssento(char linha, int coluna){
        int converte = (int)linha-65;

        if(!mapa.getAssentos()[converte+1][coluna].equals("X ")) {
            mapa.setAssentos(converte + 1, coluna, "X ");
            return true;
        }
        return false;
    }

    public boolean cancelaReservaAssento(char linha, int coluna){
        int converte = (int)linha-65;

        if(!mapa.getAssentos()[converte+1][coluna].equals("O ")){
            mapa.setAssentos(converte+1, coluna , "O ");
            return true;
        }
        return false;
    }

    public void qtdAssentosLivreOcupado() {
        assentosLivres = 0;
        assentosOcupados = 0;
        for (int i = 0; i < mapa.getAssentos().length; i++){
            for (int x = 0; x < mapa.getAssentos().length; x++) {
                if (mapa.getAssentos()[i][x].equals("X ")) {
                    assentosOcupados++;
                }
                if (mapa.getAssentos()[i][x].equals("O ")) {
                    assentosLivres++;
                }
            }
        }

    }

    public boolean imprimeMapa() {
        if(!mapa.isValidaMapa())
            return false;

        for (int l = 0; l < mapa.getAssentos().length; l++) {
            for (int c = 0; c < mapa.getAssentos()[0].length; c++) {
                System.out.print(mapa.getAssentos()[l][c] + " "); //imprime caracter a caracter
            }
            System.out.println(" "); //muda de linha
        }
        return true;
    }

    public int vereficaAssento() {
        int count = 0;

        for (int i = 0; i < mapa.getAssentos().length; i++){
            mapa.getAssentos()[i][0].equals("x ");
            count++;
        }

        return count;
    }
    public Mapa getMapa() {
        return mapa;
    }

    public void setMapa(Mapa mapa) {
        this.mapa = mapa;
    }

    public int getAssentosLivres() {
        return assentosLivres;
    }

    public void setAssentosLivres(int assentosLivres) {
        this.assentosLivres = assentosLivres;
    }

    public int getAssentosOcupados() {
        return assentosOcupados;
    }

    public void setAssentosOcupados(int assentosOcupados) {
        this.assentosOcupados = assentosOcupados;
    }
}
