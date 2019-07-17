package Object;

public class Corpo {
    public double alcance;
    public double altura_max;
    public double t_final;
    public double t_subida;
    public double sen;
    public double cos;
    public double massa;
    public double v_inicial_x;
    public double v_inicial_y;
    private double g;
    private double res_ar;
    public double co_arrasto;
    public double area_frontal;
    private double a_arrasto_x;
    private double a_arrasto_y;

    public Corpo() {
        this.g = 9.8;
        this.res_ar = 1.22;
    }

    public void aceleracaoArrasto() {
        a_arrasto_x = (co_arrasto * res_ar * area_frontal * v_inicial_x * v_inicial_x) / (2 * massa);
        a_arrasto_y = (co_arrasto * res_ar * area_frontal * v_inicial_y * v_inicial_y) / (2 * massa);
    }

    public void xFinal() {
        t_final = (v_inicial_x / a_arrasto_x);
        alcance = (v_inicial_x * t_final) - (a_arrasto_x * t_final * t_final) / 2;
    }

    public void yFinal() {
        t_subida = (v_inicial_y) / (a_arrasto_y + g);
        altura_max = (v_inicial_y * t_subida) - ((a_arrasto_y + g) * t_subida * t_subida) / 2;
    }

    public double xAtual(double t) {
        return  ((v_inicial_x * t) - (a_arrasto_x * t * t) / 2);
    }

    public double yBefore(double t)
    {
        return ((v_inicial_y * t) - ((a_arrasto_y + g) * t * t) / 2);
    }
    public double yAfter(double t)
    {
        return (altura_max - ((g - a_arrasto_y) * t * t) / 2);
    }

    public void imprimir()
    {
        System.out.println("X = 0, Y = 0, t = 0");
        double t = 1;
        double x;
        double y;
        while (t < t_subida)
        {
            x = xAtual(t);
            y = yBefore(t);
            System.out.println("X = " + x + ", Y = " + y + ", t = " + t);
            t++;
        }
        x = xAtual(t_subida);
        System.out.println("X = " + x + ",Y = " + altura_max + ", t = " + t_subida);
        t++;
        while (t < t_final)
        {
            x = xAtual(t);
            y = yAfter(t);
            System.out.println("X = " + x + ", Y = " + y + ", t = " + t);
            t++;
        }
        y = yAfter(t_final);
        System.out.println("X = " + alcance + ", Y = " + y + ", t = " + t_final);

    }

}
