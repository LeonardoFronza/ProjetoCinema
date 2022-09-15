package Main;

import Cinema.Mapa;
import Cinema.Opcoes;

public class Main {
    public static void main(String[] args) {

        Opcoes o = new Opcoes(6,5);
        o.imprimeMapa();
        o.reservaAssento('C',2);
        o.imprimeMapa();
        o.reservaAssento('D',4);
        o.imprimeMapa();




    }
}
