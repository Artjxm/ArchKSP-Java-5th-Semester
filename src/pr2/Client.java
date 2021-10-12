package pr2;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Arrays;

public class Client {
//    уникальное имя привязки
    public static final String UNIQUE_BINDING_NAME = "server.equation";

//    реализация клиентской программы
    public static void main(String[] args) throws RemoteException, NotBoundException {
//        установка порта серверу в локальной сети (реестр)
        final Registry registry = LocateRegistry.getRegistry(2732);

//        поиск удаленного объекта в реестре
        EquaInf.equaInf equation = (EquaInf.equaInf) registry.lookup(UNIQUE_BINDING_NAME);

        double[] multiplyResult = equation.solver(2, 5, -3);
        double[] multiplyResult2 = equation.solver(1, -8, 15);

        System.out.println(Arrays.toString(multiplyResult));
        System.out.println(Arrays.toString(multiplyResult2));
    }
}
