/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cliente;

import interfaceCalculadora.Calculadora;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joaquin Pereira Chapel
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Calculadora calculadora = null;
        
        System.out.println("Localizando el registro de objetos remotos");
        try {
            Registry registry = LocateRegistry.getRegistry("localhost",5555);
            System.out.println("Obteniendo el stub del obejto remoto");
            
            calculadora = (Calculadora) registry.lookup("Calculadora");
            
            if(calculadora != null){
                System.out.println("Realizando operacion con objeto remoto");
                System.out.println("2 + 2 = " + calculadora.sumar(2, 2));
                System.out.println("2 - 2 = " + calculadora.restar(2, 2));
                System.out.println("2 * 2 = " + calculadora.multiplicar(2, 2));
                System.out.println("2 / 2 = " + calculadora.dividir(2, 2));
            }
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
