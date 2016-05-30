/**
 * Calculette.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package calculette;

public interface Calculette extends java.rmi.Remote {
    public int add(int val1, int val2) throws java.rmi.RemoteException;
    public int mul(int val1, int val2) throws java.rmi.RemoteException;
    public int sou(int val1, int val2) throws java.rmi.RemoteException;
}
