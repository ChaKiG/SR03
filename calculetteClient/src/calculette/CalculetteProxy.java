package calculette;

public class CalculetteProxy implements calculette.Calculette {
  private String _endpoint = null;
  private calculette.Calculette calculette = null;
  
  public CalculetteProxy() {
    _initCalculetteProxy();
  }
  
  public CalculetteProxy(String endpoint) {
    _endpoint = endpoint;
    _initCalculetteProxy();
  }
  
  private void _initCalculetteProxy() {
    try {
      calculette = (new calculette.CalculetteServiceLocator()).getCalculette();
      if (calculette != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)calculette)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)calculette)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (calculette != null)
      ((javax.xml.rpc.Stub)calculette)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public calculette.Calculette getCalculette() {
    if (calculette == null)
      _initCalculetteProxy();
    return calculette;
  }
  
  public int add(int val1, int val2) throws java.rmi.RemoteException{
    if (calculette == null)
      _initCalculetteProxy();
    return calculette.add(val1, val2);
  }
  
  public int mul(int val1, int val2) throws java.rmi.RemoteException{
    if (calculette == null)
      _initCalculetteProxy();
    return calculette.mul(val1, val2);
  }
  
  public int sou(int val1, int val2) throws java.rmi.RemoteException{
    if (calculette == null)
      _initCalculetteProxy();
    return calculette.sou(val1, val2);
  }
  
  
}