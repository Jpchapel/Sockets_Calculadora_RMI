/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import interfaceCalculadora.Calculadora;
import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joaquin Pereira Chapel
 */
public class Servidor implements Calculadora {

    public static void main(String[] args) {
        System.out.println("Creando el registro de objetos remotos");
        
        Registry registry;
        
        try {
            registry = LocateRegistry.createRegistry(5555);
            
            System.out.println("Creando el objeto servidor e inscribiendolo en el registro");
            Servidor servidor = new Servidor();
            
            registry.bind("Calculadora", UnicastRemoteObject.exportObject(servidor, 0));
        } catch (RemoteException | AlreadyBoundException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int sumar(int a, int b) throws RemoteException {
        System.out.println("Objeto remoto: sumando " + a + " y " + b);
        return a + b;
    }

    @Override
    public int restar(int a, int b) throws RemoteException {
        System.out.println("Objeto remoto: restando " + a + " y " + b);
        return a - b;
    }

    @Override
    public int multiplicar(int a, int b) throws RemoteException {
        System.out.println("Objeto remoto: multiplicando " + a + " y " + b);
        return a * b;
    }

    @Override
    public int dividir(int a, int b) throws RemoteException {
        System.out.println("Objeto remoto: diviendo " + a + " y " + b);
        return a / b;
    }

}
