
package com.yonyou.itf.mdm07.sharing;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MdMapingVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MdMapingVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="busiDataId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="entityCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mdmCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MdMapingVO", propOrder = {
    "busiDataId",
    "entityCode",
    "mdmCode"
})
public class MdMapingVO
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    protected String busiDataId;
    protected String entityCode;
    protected String mdmCode;

    /**
     * Gets the value of the busiDataId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusiDataId() {
        return busiDataId;
    }

    /**
     * Sets the value of the busiDataId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusiDataId(String value) {
        this.busiDataId = value;
    }

    /**
     * Gets the value of the entityCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEntityCode() {
        return entityCode;
    }

    /**
     * Sets the value of the entityCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEntityCode(String value) {
        this.entityCode = value;
    }

    /**
     * Gets the value of the mdmCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMdmCode() {
        return mdmCode;
    }

    /**
     * Sets the value of the mdmCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMdmCode(String value) {
        this.mdmCode = value;
    }

}
