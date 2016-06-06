package endpoints;

public class AnnonceSOAPProxy implements endpoints.AnnonceSOAP {
  private String _endpoint = null;
  private endpoints.AnnonceSOAP annonceSOAP = null;
  
  public AnnonceSOAPProxy() {
    _initAnnonceSOAPProxy();
  }
  
  public AnnonceSOAPProxy(String endpoint) {
    _endpoint = endpoint;
    _initAnnonceSOAPProxy();
  }
  
  private void _initAnnonceSOAPProxy() {
    try {
      annonceSOAP = (new endpoints.AnnonceSOAPServiceLocator()).getAnnonceSOAP();
      if (annonceSOAP != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)annonceSOAP)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)annonceSOAP)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (annonceSOAP != null)
      ((javax.xml.rpc.Stub)annonceSOAP)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public endpoints.AnnonceSOAP getAnnonceSOAP() {
    if (annonceSOAP == null)
      _initAnnonceSOAPProxy();
    return annonceSOAP;
  }
  
  public boolean modifyAnnonce(beans.Annonce a) throws java.rmi.RemoteException{
    if (annonceSOAP == null)
      _initAnnonceSOAPProxy();
    return annonceSOAP.modifyAnnonce(a);
  }
  
  public beans.Annonce[] getAnnonces() throws java.rmi.RemoteException{
    if (annonceSOAP == null)
      _initAnnonceSOAPProxy();
    return annonceSOAP.getAnnonces();
  }
  
  public beans.Annonce getAnnonce(int id) throws java.rmi.RemoteException{
    if (annonceSOAP == null)
      _initAnnonceSOAPProxy();
    return annonceSOAP.getAnnonce(id);
  }
  
  public beans.Annonce[] getAnnoncesCat(int cat_id) throws java.rmi.RemoteException{
    if (annonceSOAP == null)
      _initAnnonceSOAPProxy();
    return annonceSOAP.getAnnoncesCat(cat_id);
  }
  
  public int createAnnonce(beans.Annonce a) throws java.rmi.RemoteException{
    if (annonceSOAP == null)
      _initAnnonceSOAPProxy();
    return annonceSOAP.createAnnonce(a);
  }
  
  public boolean deleteAnnonce(beans.Annonce a) throws java.rmi.RemoteException{
    if (annonceSOAP == null)
      _initAnnonceSOAPProxy();
    return annonceSOAP.deleteAnnonce(a);
  }
  
  
}