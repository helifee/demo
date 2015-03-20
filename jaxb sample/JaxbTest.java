package test;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JaxbTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		pojo2xml();
		xml2pojo();
	}
	
	public static void pojo2xml() {
		Person person = new Person();
		person.setId(100);
		person.setName("Jack");
		person.setAge(22);
		
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
//			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(person, System.out);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	public static void xml2pojo() {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			Object person = unmarshaller.unmarshal(new File("D:\\person.xml"));
			System.out.println(person);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}
