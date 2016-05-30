/**
 * CalculetteService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package calculette;

public interface CalculetteService extends javax.xml.rpc.Service {
    public java.lang.String getCalculetteAddress();

    public calculette.Calculette getCalculette() throws javax.xml.rpc.ServiceException;

    public calculette.Calculette getCalculette(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
