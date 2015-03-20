
package com.yonyou.itf.mdm07.sharing.imdsharingthirdpartservice;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.yonyou.itf.mdm07.sharing.OuterSystemRetVO;


/**
 * <p>Java class for getRemoteMdCountResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getRemoteMdCountResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://sharing.mdm07.itf.yonyou.com/OuterSystemRetVO}OuterSystemRetVO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getRemoteMdCountResponse", propOrder = {
    "_return"
})
public class GetRemoteMdCountResponse
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "return")
    protected OuterSystemRetVO _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link OuterSystemRetVO }
     *     
     */
    public OuterSystemRetVO getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link OuterSystemRetVO }
     *     
     */
    public void setReturn(OuterSystemRetVO value) {
        this._return = value;
    }

}
