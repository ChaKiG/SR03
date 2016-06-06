/**
 * AnnonceSOAP.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package annoncesSOAP;

public interface AnnonceSOAP extends java.rmi.Remote {
    public boolean modifyAnnonce(beans.Annonce a) throws java.rmi.RemoteException;
    public beans.Annonce[] getAnnonces() throws java.rmi.RemoteException;
    public beans.Annonce getAnnonce(int id) throws java.rmi.RemoteException;
    public beans.Annonce[] getAnnoncesCat(int cat_id) throws java.rmi.RemoteException;
    public int createAnnonce(beans.Annonce a) throws java.rmi.RemoteException;
    public boolean deleteAnnonce(beans.Annonce a) throws java.rmi.RemoteException;
}
