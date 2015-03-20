
package com.yonyou.itf.mdm07.sharing.imdsharingthirdpartservice;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getRemoteMdCount complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getRemoteMdCount">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="string0" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getRemoteMdCount", propOrder = {
    "string0"
})
public class GetRemoteMdCount
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    protected String string0;

    /**
     * Gets the value of the string0 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getString0() {
        return string0;
    }

    /**
     * Sets the value of the string0 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setString0(String value) {
        this.string0 = value;
    }

}
