package pr2;

import java.rmi.Remote;
import java.rmi.RemoteException;

public class EquaInf {
//    создание удаленного интерфейса с публичным уровнем доступа
//    (для избежания ошибки на уровне клиента при попытки загрузки объекта)
    public interface equaInf extends Remote {
        double[] solver(double a, double b, double c) throws
                RemoteException;
        }
}
