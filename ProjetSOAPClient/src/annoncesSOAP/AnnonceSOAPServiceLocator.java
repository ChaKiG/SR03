/**
 * AnnonceSOAPServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package annoncesSOAP;

public class AnnonceSOAPServiceLocator extends org.apache.axis.client.Service implements annoncesSOAP.AnnonceSOAPService {

    public AnnonceSOAPServiceLocator() {
    }


    public AnnonceSOAPServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public AnnonceSOAPServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for AnnonceSOAP
    private java.lang.String AnnonceSOAP_address = "http://localhost:8080/ProjetSOAP/services/AnnonceSOAP";

    public java.lang.String getAnnonceSOAPAddress() {
        return AnnonceSOAP_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String AnnonceSOAPWSDDServiceName = "AnnonceSOAP";

    public java.lang.String getAnnonceSOAPWSDDServiceName() {
        return AnnonceSOAPWSDDServiceName;
    }

    public void setAnnonceSOAPWSDDServiceName(java.lang.String name) {
        AnnonceSOAPWSDDServiceName = name;
    }

    public annoncesSOAP.AnnonceSOAP getAnnonceSOAP() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(AnnonceSOAP_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getAnnonceSOAP(endpoint);
    }

    public annoncesSOAP.AnnonceSOAP getAnnonceSOAP(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            annoncesSOAP.AnnonceSOAPSoapBindingStub _stub = new annoncesSOAP.AnnonceSOAPSoapBindingStub(portAddress, this);
            _stub.setPortName(getAnnonceSOAPWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setAnnonceSOAPEndpointAddress(java.lang.String address) {
        AnnonceSOAP_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (annoncesSOAP.AnnonceSOAP.class.isAssignableFrom(serviceEndpointInterface)) {
                annoncesSOAP.AnnonceSOAPSoapBindingStub _stub = new annoncesSOAP.AnnonceSOAPSoapBindingStub(new java.net.URL(AnnonceSOAP_address), this);
                _stub.setPortName(getAnnonceSOAPWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("AnnonceSOAP".equals(inputPortName)) {
            return getAnnonceSOAP();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://endpoints", "AnnonceSOAPService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://endpoints", "AnnonceSOAP"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("AnnonceSOAP".equals(portName)) {
            setAnnonceSOAPEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
