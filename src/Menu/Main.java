package Menu;

import Object.Corpo;

import java.util.Scanner;

public class Main {

    public static void main(String arg[])
    {
        System.out.println("BEM-VINDO");
        Scanner sc = new Scanner(System.in);
        Corpo obj = new Corpo();
        System.out.println("QUAL A MASSA? (EM KG)");
        obj.massa = sc.nextDouble();
        System.out.println("QUAL A VELOCIDADE INICIAL? (EM m/s)");
        double v_inicial;
        v_inicial = sc.nextDouble();
        System.out.println("QUAL O ANGULO DE LANÇAMENTO? (EM GRAUS)");
        double graus;
        graus = sc.nextDouble();
        graus = Math.toRadians(graus);
        obj.sen = Math.sin(graus);
        obj.cos = Math.cos(graus);
        obj.v_inicial_x = (v_inicial*obj.sen);
        obj.v_inicial_y = (v_inicial*obj.cos);
        System.out.println("QUAL O COEFICIENTE DE ARRASTO?");
        obj.co_arrasto = sc.nextDouble();
        System.out.println("QUAL AREA FRONTAL? (EM METROS QUADRADROS)");
        obj.area_frontal = sc.nextDouble();
        obj.aceleracaoArrasto();
        obj.xFinal();
        obj.yFinal();
        obj.imprimir();
    }
}
