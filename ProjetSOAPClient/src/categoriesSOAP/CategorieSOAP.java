/**
 * CategorieSOAP.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package categoriesSOAP;

public interface CategorieSOAP extends java.rmi.Remote {
    public beans.Categorie[] getCategories() throws java.rmi.RemoteException;
    public beans.Categorie getCategorie(int id) throws java.rmi.RemoteException;
    public int addCategorie(beans.Categorie c) throws java.rmi.RemoteException;
    public boolean delCategorie(int cat_id) throws java.rmi.RemoteException;
    public boolean deleteAnnonce(beans.Annonce a) throws java.rmi.RemoteException;
}
