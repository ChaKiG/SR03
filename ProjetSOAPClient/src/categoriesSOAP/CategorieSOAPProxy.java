package categoriesSOAP;

public class CategorieSOAPProxy implements categoriesSOAP.CategorieSOAP {
  private String _endpoint = null;
  private categoriesSOAP.CategorieSOAP categorieSOAP = null;
  
  public CategorieSOAPProxy() {
    _initCategorieSOAPProxy();
  }
  
  public CategorieSOAPProxy(String endpoint) {
    _endpoint = endpoint;
    _initCategorieSOAPProxy();
  }
  
  private void _initCategorieSOAPProxy() {
    try {
      categorieSOAP = (new categoriesSOAP.CategorieSOAPServiceLocator()).getCategorieSOAP();
      if (categorieSOAP != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)categorieSOAP)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)categorieSOAP)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (categorieSOAP != null)
      ((javax.xml.rpc.Stub)categorieSOAP)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public categoriesSOAP.CategorieSOAP getCategorieSOAP() {
    if (categorieSOAP == null)
      _initCategorieSOAPProxy();
    return categorieSOAP;
  }
  
  public beans.Categorie[] getCategories() throws java.rmi.RemoteException{
    if (categorieSOAP == null)
      _initCategorieSOAPProxy();
    return categorieSOAP.getCategories();
  }
  
  public beans.Categorie getCategorie(int id) throws java.rmi.RemoteException{
    if (categorieSOAP == null)
      _initCategorieSOAPProxy();
    return categorieSOAP.getCategorie(id);
  }
  
  public int addCategorie(beans.Categorie c) throws java.rmi.RemoteException{
    if (categorieSOAP == null)
      _initCategorieSOAPProxy();
    return categorieSOAP.addCategorie(c);
  }
  
  public boolean delCategorie(int cat_id) throws java.rmi.RemoteException{
    if (categorieSOAP == null)
      _initCategorieSOAPProxy();
    return categorieSOAP.delCategorie(cat_id);
  }
  
  public boolean deleteAnnonce(beans.Annonce a) throws java.rmi.RemoteException{
    if (categorieSOAP == null)
      _initCategorieSOAPProxy();
    return categorieSOAP.deleteAnnonce(a);
  }
  
  
}