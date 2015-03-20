
package com.yonyou.itf.mdm07.sharing;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.yonyou.itf.mdm07.sharing package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _OuterSystemRetVO_QNAME = new QName("http://sharing.mdm07.itf.yonyou.com/OuterSystemRetVO", "OuterSystemRetVO");
    private final static QName _MdMapingVO_QNAME = new QName("http://sharing.mdm07.itf.yonyou.com/MdMapingVO", "MdMapingVO");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.yonyou.itf.mdm07.sharing
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link OuterSystemRetVO }
     * 
     */
    public OuterSystemRetVO createOuterSystemRetVO() {
        return new OuterSystemRetVO();
    }

    /**
     * Create an instance of {@link MdMapingVO }
     * 
     */
    public MdMapingVO createMdMapingVO() {
        return new MdMapingVO();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OuterSystemRetVO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sharing.mdm07.itf.yonyou.com/OuterSystemRetVO", name = "OuterSystemRetVO")
    public JAXBElement<OuterSystemRetVO> createOuterSystemRetVO(OuterSystemRetVO value) {
        return new JAXBElement<OuterSystemRetVO>(_OuterSystemRetVO_QNAME, OuterSystemRetVO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MdMapingVO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sharing.mdm07.itf.yonyou.com/MdMapingVO", name = "MdMapingVO")
    public JAXBElement<MdMapingVO> createMdMapingVO(MdMapingVO value) {
        return new JAXBElement<MdMapingVO>(_MdMapingVO_QNAME, MdMapingVO.class, null, value);
    }

}
