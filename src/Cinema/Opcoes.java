package Cinema;

public class Opcoes {

    Mapa mapa;

    public Opcoes(int linha, int coluna){
        mapa = new Mapa(linha,coluna);
    }

    public void reservaAssento(char linha, int coluna){
       int converte = (int)linha-65;

       if(mapa.getAssentos()[converte][coluna].equals('O')){
           //mapa.setAssentos(mapa.getAssentos()[converte][linha]) = "X "; Erro
        }
    }

    public void cancelaReservaAssento(){

    }

    public void qtdAssentosLivreOcupado() {

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
