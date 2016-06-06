/**
 * CategorieSOAPServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package categoriesSOAP;

public class CategorieSOAPServiceLocator extends org.apache.axis.client.Service implements categoriesSOAP.CategorieSOAPService {

    public CategorieSOAPServiceLocator() {
    }


    public CategorieSOAPServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CategorieSOAPServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for CategorieSOAP
    private java.lang.String CategorieSOAP_address = "http://localhost:8080/ProjetSOAP/services/CategorieSOAP";

    public java.lang.String getCategorieSOAPAddress() {
        return CategorieSOAP_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CategorieSOAPWSDDServiceName = "CategorieSOAP";

    public java.lang.String getCategorieSOAPWSDDServiceName() {
        return CategorieSOAPWSDDServiceName;
    }

    public void setCategorieSOAPWSDDServiceName(java.lang.String name) {
        CategorieSOAPWSDDServiceName = name;
    }

    public categoriesSOAP.CategorieSOAP getCategorieSOAP() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(CategorieSOAP_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCategorieSOAP(endpoint);
    }

    public categoriesSOAP.CategorieSOAP getCategorieSOAP(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            categoriesSOAP.CategorieSOAPSoapBindingStub _stub = new categoriesSOAP.CategorieSOAPSoapBindingStub(portAddress, this);
            _stub.setPortName(getCategorieSOAPWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCategorieSOAPEndpointAddress(java.lang.String address) {
        CategorieSOAP_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (categoriesSOAP.CategorieSOAP.class.isAssignableFrom(serviceEndpointInterface)) {
                categoriesSOAP.CategorieSOAPSoapBindingStub _stub = new categoriesSOAP.CategorieSOAPSoapBindingStub(new java.net.URL(CategorieSOAP_address), this);
                _stub.setPortName(getCategorieSOAPWSDDServiceName());
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
        if ("CategorieSOAP".equals(inputPortName)) {
            return getCategorieSOAP();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://endpoints", "CategorieSOAPService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://endpoints", "CategorieSOAP"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("CategorieSOAP".equals(portName)) {
            setCategorieSOAPEndpointAddress(address);
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
