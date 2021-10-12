package pr2;

import java.rmi.RemoteException;

public class Equa implements EquaInf.equaInf {
//    реализация удаленной службы решения уравнения
    @Override
    public double[] solver(double a, double b, double c) throws
            RemoteException {
        double result = b * b - 4.0 * a * c;

        if (result > 0.0) {
            double r1 = (-b + Math.pow(result, 0.5)) / (2.0 * a);
            double r2 = (-b - Math.pow(result, 0.5)) / (2.0 * a);
            return new double[]{r1, r2};
        } else if (result == 0.0) {
            double r1 = -b / (2.0 * a);
            return new double[]{r1,r1};
        } else {
            return new double[]{0};

        }
    }
}
