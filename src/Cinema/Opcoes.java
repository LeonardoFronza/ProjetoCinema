package Cinema;

public class Opcoes {

    Mapa mapa;

    public Opcoes(int linha, int coluna){
        mapa = new Mapa(linha,coluna);
    }

    public void reservaAssento(char linha, int coluna){
        int converte = (int)linha-65;

        if(!mapa.getAssentos()[converte+1][coluna].equals("X "))
            mapa.setAssentos(converte+1, coluna , "X ");
        else
            System.out.println("Assento já reservado");
    }

    public void cancelaReservaAssento(char linha, int coluna){
        int converte = (int)linha-65;

        if(!mapa.getAssentos()[converte+1][coluna].equals("X "))
            mapa.setAssentos(converte+1, coluna , "O ");
        else
            System.out.println("Assento não estava reservado");
    }

    public void qtdAssentosLivreOcupado() {
        int assentosLivres = 0, assentosOcupados = 0;

        for (int i = 0; i < mapa.getAssentos().length; i++){
                if(mapa.getAssentos().equals("x ")) {
                    assentosLivres++;
                }
                assentosOcupados++;
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
}
