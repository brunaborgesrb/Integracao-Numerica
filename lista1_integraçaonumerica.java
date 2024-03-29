public class lista {
    // Função que você deseja integrar
    public static double fa(double x) {
        return 1 / Math.cos(x);
    }

    public static double trapezoidalRuleA(double a, double b, int n) {
        double h = (b - a) / n; // Largura dos subintervalos
        double sum = 0.5 * (fa(a) + fa(b));
        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            sum += fa(x);
        }
        return h * sum;
    }

    public static double fb(double x) {
        return 4 / (2 + Math.pow(x, 4));
    }

    public static double trapezoidalRuleB(double a, double b, int n) {
        double h = (b - a) / n; // Largura dos subintervalos
        double sum = 0.5 * (fb(a) + fb(b));
        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            sum += fb(x);
        }
        return h * sum;
    }

    private static double fc(double x) {
        return 2 / Math.pow(1 + Math.pow(x, 2), 0.5);
    }

    public static double trapezoidalRuleC(double a, double b, int n) {
        double h = (b - a) / n; // Largura dos subintervalos
        double sum = 0.5 * (fc(a) + fc(b));
        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            sum += fc(x);
        }
        return h * sum;
    }

    private static double fd(double x) {
        return Math.pow(Math.cos(x), 3);
    }

    public static double trapezoidalRuleD(double a, double b, int n) {
        double h = (b - a) / n; // Largura dos subintervalos
        double sum = 0.5 * (fd(a) + fd(b));
        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            sum += fd(x);
        }
        return h * sum;
    }

    private static double fa2(double x) {
        return -1 / Math.cos(x) + 2 * (1 / Math.pow(Math.cos(x), 3));
    }

    // (N*H^3*derivada''(c))/12
    public static double erroA(double b, double a, double n) {
        double aux = fa2(b);
        double h = (b - a) / n; // Largura dos subintervalos
        aux = (aux * n * (Math.pow(h, 3))) / 12;
        return aux;

    }

    private static double fb2(double x) {
        return (-(16 * Math.pow(x, 2) * (-5 * Math.pow(x, 4) + 6))) / Math.pow(2 + Math.pow(x, 4), 3);
    }

    public static double errob(double b, double a, double n) {
        double aux = fb2(b);
        double h = (b - a) / n; // Largura dos subintervalos
        aux = (aux * n * (Math.pow(h, 3))) / 12;
        return aux;

    }

    private static double fc2(double x) {
        return (-(2 * (-2 * Math.pow(x, 2) + 1))) / (Math.pow(1 + Math.pow(x, 2), 2.5));
    }

    public static double erroc(double b, double a, double n) {
        double aux = fc2(b);
        double h = (b - a) / n; // Largura dos subintervalos
        aux = (aux * n * (Math.pow(h, 3))) / 12;
        return aux;

    }

    private static double fd2(double x) {
        return -3 * (-2 * Math.cos(x) + 3 * Math.pow(Math.cos(x), 3));
    }

    public static double errod(double b, double a, double n) {
        double aux = fd2(b);
        double h = (b - a) / n; // Largura dos subintervalos
        aux = (aux * n * (Math.pow(h, 3))) / 12;
        return aux;

    }

    public static void main(String[] args) {

        double a = 0;
        double a2 = -4;
        double a3 = -4;
        double a4 = 0;

        double b = Math.PI / 4;
        double b2 = 4;
        double b3 = 4;
        double b4 = Math.PI / 2;

        double result = 0, result2 = 0, result3 = 0, result4 = 0;

        result = trapezoidalRuleA(a, b, 3);
        result2 = trapezoidalRuleB(a2, b2, 9);
        result3 = trapezoidalRuleC(a3, b3, 8);
        result4 = trapezoidalRuleD(a4, b4, 4);

        System.out.println("Questões normais");
        System.out.println(" ");
        System.out.println("Questão 1: " + result);
        System.out.println("Questão 2: " + result2);
        System.out.println("Questão 3: " + result3);
        System.out.println("Questão 4: " + result4);
        System.out.println(" ");

        double resultA1 = 0;
        double resultA2 = 0;
        double resultA3 = 0;
        double resultA4 = 0;

        resultA1 = erroA(b, a, 3);
        resultA2 = errob(b2, a2, 9);
        resultA3 = erroc(b3, a3, 8);
        resultA4 = errod(b4, a4, 4);

        System.out.println("Questão com o erro");
        System.out.println(" ");
        System.out.println("Questão 1: " + resultA1);
        System.out.println("Questão 2: " +resultA2);
        System.out.println("Questão 3: " +resultA3);
        System.out.println("Questão 4: " +resultA4);

        System.out.println(" ");
        System.out.println("Questão de comparação de erros: ");
        System.out.println("Comparação 1: " + (result - resultA1));
        System.out.println("Comparação 2: " + (result2 - resultA2));
        System.out.println("Comparação 3: " + (result3 - resultA3));
        System.out.println("Comparação 4: " + (result4 - resultA4));
    }
}

// (N*H^3 derivada''(c))/12