package pr2;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import static pr2.Client.UNIQUE_BINDING_NAME;

public class Server {
    public static void main(String[] args) throws RemoteException,
            AlreadyBoundException, InterruptedException {
//        реализация простого сервера, предоставляющего простые
//        элементы для размещения
        final Equa server = new Equa();

//        установка порта серверу в локальной сети (связь с реестром)
        final Registry registry = LocateRegistry.createRegistry(2732);

//        удаленные службы RMI помещены в процесс сервера
        Remote stub = UnicastRemoteObject.exportObject(server, 0);

//        соединение реестра с уникальным именем
        registry.bind(UNIQUE_BINDING_NAME, stub);

        Thread.sleep(Integer.MAX_VALUE);
    }
}
