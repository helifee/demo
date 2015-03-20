
package com.yonyou.itf.mdm07.sharing.imdsharingthirdpartservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.yonyou.itf.mdm07.sharing.imdsharingthirdpartservice package. 
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

    private final static QName _LoadMdBatch_QNAME = new QName("http://sharing.mdm07.itf.yonyou.com/IMdSharingThirdPartService", "loadMdBatch");
    private final static QName _LoadMdBatchResponse_QNAME = new QName("http://sharing.mdm07.itf.yonyou.com/IMdSharingThirdPartService", "loadMdBatchResponse");
    private final static QName _GetRemoteMdCount_QNAME = new QName("http://sharing.mdm07.itf.yonyou.com/IMdSharingThirdPartService", "getRemoteMdCount");
    private final static QName _LoadMd_QNAME = new QName("http://sharing.mdm07.itf.yonyou.com/IMdSharingThirdPartService", "loadMd");
    private final static QName _DistributeMdResponse_QNAME = new QName("http://sharing.mdm07.itf.yonyou.com/IMdSharingThirdPartService", "distributeMdResponse");
    private final static QName _DistributeMd_QNAME = new QName("http://sharing.mdm07.itf.yonyou.com/IMdSharingThirdPartService", "distributeMd");
    private final static QName _GetRemoteMdCountResponse_QNAME = new QName("http://sharing.mdm07.itf.yonyou.com/IMdSharingThirdPartService", "getRemoteMdCountResponse");
    private final static QName _LoadMdResponse_QNAME = new QName("http://sharing.mdm07.itf.yonyou.com/IMdSharingThirdPartService", "loadMdResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.yonyou.itf.mdm07.sharing.imdsharingthirdpartservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DistributeMd }
     * 
     */
    public DistributeMd createDistributeMd() {
        return new DistributeMd();
    }

    /**
     * Create an instance of {@link DistributeMdResponse }
     * 
     */
    public DistributeMdResponse createDistributeMdResponse() {
        return new DistributeMdResponse();
    }

    /**
     * Create an instance of {@link LoadMd }
     * 
     */
    public LoadMd createLoadMd() {
        return new LoadMd();
    }

    /**
     * Create an instance of {@link LoadMdResponse }
     * 
     */
    public LoadMdResponse createLoadMdResponse() {
        return new LoadMdResponse();
    }

    /**
     * Create an instance of {@link GetRemoteMdCountResponse }
     * 
     */
    public GetRemoteMdCountResponse createGetRemoteMdCountResponse() {
        return new GetRemoteMdCountResponse();
    }

    /**
     * Create an instance of {@link GetRemoteMdCount }
     * 
     */
    public GetRemoteMdCount createGetRemoteMdCount() {
        return new GetRemoteMdCount();
    }

    /**
     * Create an instance of {@link LoadMdBatchResponse }
     * 
     */
    public LoadMdBatchResponse createLoadMdBatchResponse() {
        return new LoadMdBatchResponse();
    }

    /**
     * Create an instance of {@link LoadMdBatch }
     * 
     */
    public LoadMdBatch createLoadMdBatch() {
        return new LoadMdBatch();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadMdBatch }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingThirdPartService", name = "loadMdBatch")
    public JAXBElement<LoadMdBatch> createLoadMdBatch(LoadMdBatch value) {
        return new JAXBElement<LoadMdBatch>(_LoadMdBatch_QNAME, LoadMdBatch.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadMdBatchResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingThirdPartService", name = "loadMdBatchResponse")
    public JAXBElement<LoadMdBatchResponse> createLoadMdBatchResponse(LoadMdBatchResponse value) {
        return new JAXBElement<LoadMdBatchResponse>(_LoadMdBatchResponse_QNAME, LoadMdBatchResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRemoteMdCount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingThirdPartService", name = "getRemoteMdCount")
    public JAXBElement<GetRemoteMdCount> createGetRemoteMdCount(GetRemoteMdCount value) {
        return new JAXBElement<GetRemoteMdCount>(_GetRemoteMdCount_QNAME, GetRemoteMdCount.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadMd }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingThirdPartService", name = "loadMd")
    public JAXBElement<LoadMd> createLoadMd(LoadMd value) {
        return new JAXBElement<LoadMd>(_LoadMd_QNAME, LoadMd.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DistributeMdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingThirdPartService", name = "distributeMdResponse")
    public JAXBElement<DistributeMdResponse> createDistributeMdResponse(DistributeMdResponse value) {
        return new JAXBElement<DistributeMdResponse>(_DistributeMdResponse_QNAME, DistributeMdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DistributeMd }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingThirdPartService", name = "distributeMd")
    public JAXBElement<DistributeMd> createDistributeMd(DistributeMd value) {
        return new JAXBElement<DistributeMd>(_DistributeMd_QNAME, DistributeMd.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRemoteMdCountResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingThirdPartService", name = "getRemoteMdCountResponse")
    public JAXBElement<GetRemoteMdCountResponse> createGetRemoteMdCountResponse(GetRemoteMdCountResponse value) {
        return new JAXBElement<GetRemoteMdCountResponse>(_GetRemoteMdCountResponse_QNAME, GetRemoteMdCountResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadMdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingThirdPartService", name = "loadMdResponse")
    public JAXBElement<LoadMdResponse> createLoadMdResponse(LoadMdResponse value) {
        return new JAXBElement<LoadMdResponse>(_LoadMdResponse_QNAME, LoadMdResponse.class, null, value);
    }

}
