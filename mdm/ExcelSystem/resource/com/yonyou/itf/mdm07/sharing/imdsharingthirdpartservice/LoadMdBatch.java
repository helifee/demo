
package com.yonyou.itf.mdm07.sharing.imdsharingthirdpartservice;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for loadMdBatch complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="loadMdBatch">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="string0" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="int1" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="int2" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "loadMdBatch", propOrder = {
    "string0",
    "int1",
    "int2"
})
public class LoadMdBatch
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    protected String string0;
    protected Integer int1;
    protected Integer int2;

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
     * Gets the value of the int1 property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getInt1() {
        return int1;
    }

    /**
     * Sets the value of the int1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setInt1(Integer value) {
        this.int1 = value;
    }

    /**
     * Gets the value of the int2 property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getInt2() {
        return int2;
    }

    /**
     * Sets the value of the int2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setInt2(Integer value) {
        this.int2 = value;
    }

}
