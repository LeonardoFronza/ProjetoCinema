package Main;

import Cinema.Mapa;
import Cinema.Opcoes;

public class Main {
    public static void main(String[] args) {

        Opcoes o = new Opcoes(10,6);
        o.imprimeMapa();
        o.reservaAssento('C',2);
        o.imprimeMapa();
        o.reservaAssento('C',2);




    }
}
