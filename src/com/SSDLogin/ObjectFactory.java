package com.SSDLogin;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each Java content interface and Java
 * element interface generated in the com.SSDLogin package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the
 * Java representation for XML content. The Java representation of XML content
 * can consist of schema derived interfaces and classes representing the binding
 * of schema type definitions, element declarations and model groups. Factory
 * methods for each of these are provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

	private final static QName _GetEKPUserFullName_QNAME = new QName(
			"http://dao/", "getEKPUserFullName");
	private final static QName _GetEKPUserFullNameResponse_QNAME = new QName(
			"http://dao/", "getEKPUserFullNameResponse");
	private final static QName _Exception_QNAME = new QName("http://dao/",
			"Exception");

	/**
	 * Create a new ObjectFactory that can be used to create new instances of
	 * schema derived classes for package: com.SSDLogin
	 * 
	 */
	public ObjectFactory() {
	}

	/**
	 * Create an instance of {@link Exception }
	 * 
	 */
	public Exception createException() {
		return new Exception();
	}

	/**
	 * Create an instance of {@link GetEKPUserFullNameResponse }
	 * 
	 */
	public GetEKPUserFullNameResponse createGetEKPUserFullNameResponse() {
		return new GetEKPUserFullNameResponse();
	}

	/**
	 * Create an instance of {@link GetEKPUserFullName }
	 * 
	 */
	public GetEKPUserFullName createGetEKPUserFullName() {
		return new GetEKPUserFullName();
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetEKPUserFullName }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://dao/", name = "getEKPUserFullName")
	public JAXBElement<GetEKPUserFullName> createGetEKPUserFullName(
			GetEKPUserFullName value) {
		return new JAXBElement<GetEKPUserFullName>(_GetEKPUserFullName_QNAME,
				GetEKPUserFullName.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetEKPUserFullNameResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://dao/", name = "getEKPUserFullNameResponse")
	public JAXBElement<GetEKPUserFullNameResponse> createGetEKPUserFullNameResponse(
			GetEKPUserFullNameResponse value) {
		return new JAXBElement<GetEKPUserFullNameResponse>(
				_GetEKPUserFullNameResponse_QNAME,
				GetEKPUserFullNameResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Exception }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://dao/", name = "Exception")
	public JAXBElement<Exception> createException(Exception value) {
		return new JAXBElement<Exception>(_Exception_QNAME, Exception.class,
				null, value);
	}

}
