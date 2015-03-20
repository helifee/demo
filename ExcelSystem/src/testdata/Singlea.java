
package testdata;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for singlea complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="singlea">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="aa" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="bb" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="cc" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="dd" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="ee" type="{http://testdata/singlea}singleb"/>
 *         &lt;element name="ff" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "singlea", propOrder = {
    "id",
    "name",
    "code",
    "description",
    "aa",
    "bb",
    "cc",
    "dd",
    "ee",
    "ff"
})
public class Singlea
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true)
    protected String id;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String code;
    @XmlElement(required = true)
    protected String description;
    protected int aa;
    protected double bb;
    protected boolean cc;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dd;
    @XmlElement(required = true)
    protected Singleb ee;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar ff;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the aa property.
     * 
     */
    public int getAa() {
        return aa;
    }

    /**
     * Sets the value of the aa property.
     * 
     */
    public void setAa(int value) {
        this.aa = value;
    }

    /**
     * Gets the value of the bb property.
     * 
     */
    public double getBb() {
        return bb;
    }

    /**
     * Sets the value of the bb property.
     * 
     */
    public void setBb(double value) {
        this.bb = value;
    }

    /**
     * Gets the value of the cc property.
     * 
     */
    public boolean isCc() {
        return cc;
    }

    /**
     * Sets the value of the cc property.
     * 
     */
    public void setCc(boolean value) {
        this.cc = value;
    }

    /**
     * Gets the value of the dd property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDd() {
        return dd;
    }

    /**
     * Sets the value of the dd property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDd(XMLGregorianCalendar value) {
        this.dd = value;
    }

    /**
     * Gets the value of the ee property.
     * 
     * @return
     *     possible object is
     *     {@link Singleb }
     *     
     */
    public Singleb getEe() {
        return ee;
    }

    /**
     * Sets the value of the ee property.
     * 
     * @param value
     *     allowed object is
     *     {@link Singleb }
     *     
     */
    public void setEe(Singleb value) {
        this.ee = value;
    }

    /**
     * Gets the value of the ff property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFf() {
        return ff;
    }

    /**
     * Sets the value of the ff property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFf(XMLGregorianCalendar value) {
        this.ff = value;
    }

}
