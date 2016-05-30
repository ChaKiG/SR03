/**
 * CalculetteServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package calculette;

public class CalculetteServiceLocator extends org.apache.axis.client.Service implements calculette.CalculetteService {

    public CalculetteServiceLocator() {
    }


    public CalculetteServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CalculetteServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Calculette
    private java.lang.String Calculette_address = "http://localhost:8080/calculette/services/Calculette";

    public java.lang.String getCalculetteAddress() {
        return Calculette_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CalculetteWSDDServiceName = "Calculette";

    public java.lang.String getCalculetteWSDDServiceName() {
        return CalculetteWSDDServiceName;
    }

    public void setCalculetteWSDDServiceName(java.lang.String name) {
        CalculetteWSDDServiceName = name;
    }

    public calculette.Calculette getCalculette() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Calculette_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCalculette(endpoint);
    }

    public calculette.Calculette getCalculette(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            calculette.CalculetteSoapBindingStub _stub = new calculette.CalculetteSoapBindingStub(portAddress, this);
            _stub.setPortName(getCalculetteWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCalculetteEndpointAddress(java.lang.String address) {
        Calculette_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (calculette.Calculette.class.isAssignableFrom(serviceEndpointInterface)) {
                calculette.CalculetteSoapBindingStub _stub = new calculette.CalculetteSoapBindingStub(new java.net.URL(Calculette_address), this);
                _stub.setPortName(getCalculetteWSDDServiceName());
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
        if ("Calculette".equals(inputPortName)) {
            return getCalculette();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://calculette", "CalculetteService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://calculette", "Calculette"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Calculette".equals(portName)) {
            setCalculetteEndpointAddress(address);
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
