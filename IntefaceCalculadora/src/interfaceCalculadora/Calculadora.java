/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaceCalculadora;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Joaquin Pereira Chapel
 */
public interface Calculadora extends Remote{
    public int sumar(int a, int b)throws RemoteException;
    public int restar(int a, int b)throws RemoteException;
    public int multiplicar(int a, int b)throws RemoteException;
    public int dividir(int a, int b)throws RemoteException;
}
