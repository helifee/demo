
package com.yonyou.itf.mdm07.sharing.imdsharingthirdpartservice;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for distributeMd complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="distributeMd">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="string0" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="string1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="string2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "distributeMd", propOrder = {
    "string0",
    "string1",
    "string2"
})
public class DistributeMd
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    protected String string0;
    protected String string1;
    protected String string2;

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

    /**
     * Gets the value of the string1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getString1() {
        return string1;
    }

    /**
     * Sets the value of the string1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setString1(String value) {
        this.string1 = value;
    }

    /**
     * Gets the value of the string2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getString2() {
        return string2;
    }

    /**
     * Sets the value of the string2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setString2(String value) {
        this.string2 = value;
    }

}
