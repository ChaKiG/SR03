package beans;

public class Annonce  implements java.io.Serializable {
    private int id = -1;
    private int categorie = -1;
    private java.lang.String nom = "";
    private int telephone = -1;
    private beans.Adresse adresse = new Adresse();

    public Annonce() {}

    public Annonce(
           int id,
           int categorie,
           java.lang.String nom,
           int telephone,
           beans.Adresse adresse) {
           this.id = id;
           this.categorie = categorie;
           this.nom = nom;
           this.telephone = telephone;
           this.adresse = adresse;
    }


    /**
     * Gets the id value for this Annonce.
     * 
     * @return id
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the id value for this Annonce.
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Gets the categorie value for this Annonce.
     * 
     * @return categorie
     */
    public int getCategorie() {
        return categorie;
    }


    /**
     * Sets the categorie value for this Annonce.
     * 
     * @param categorie
     */
    public void setCategorie(int categorie) {
        this.categorie = categorie;
    }


    /**
     * Gets the nom value for this Annonce.
     * 
     * @return nom
     */
    public java.lang.String getNom() {
        return nom;
    }


    /**
     * Sets the nom value for this Annonce.
     * 
     * @param nom
     */
    public void setNom(java.lang.String nom) {
        this.nom = nom;
    }


    /**
     * Gets the telephone value for this Annonce.
     * 
     * @return telephone
     */
    public int getTelephone() {
        return telephone;
    }


    /**
     * Sets the telephone value for this Annonce.
     * 
     * @param telephone
     */
    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }


    /**
     * Gets the adresse value for this Annonce.
     * 
     * @return adresse
     */
    public beans.Adresse getAdresse() {
        return adresse;
    }


    /**
     * Sets the adresse value for this Annonce.
     * 
     * @param adresse
     */
    public void setAdresse(beans.Adresse adresse) {
        this.adresse = adresse;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Annonce)) return false;
        Annonce other = (Annonce) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.id == other.getId() &&
            this.categorie == other.getCategorie() &&
            ((this.nom==null && other.getNom()==null) || 
             (this.nom!=null &&
              this.nom.equals(other.getNom()))) &&
            this.telephone == other.getTelephone() &&
            ((this.adresse==null && other.getAdresse()==null) || 
             (this.adresse!=null &&
              this.adresse.equals(other.getAdresse())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += getId();
        _hashCode += getCategorie();
        if (getNom() != null) {
            _hashCode += getNom().hashCode();
        }
        _hashCode += getTelephone();
        if (getAdresse() != null) {
            _hashCode += getAdresse().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Annonce.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://beans", "Annonce"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://beans", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("categorie");
        elemField.setXmlName(new javax.xml.namespace.QName("http://beans", "categorie"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nom");
        elemField.setXmlName(new javax.xml.namespace.QName("http://beans", "nom"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("telephone");
        elemField.setXmlName(new javax.xml.namespace.QName("http://beans", "telephone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("adresse");
        elemField.setXmlName(new javax.xml.namespace.QName("http://beans", "adresse"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://beans", "Adresse"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
