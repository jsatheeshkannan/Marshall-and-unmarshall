package org.vmware.jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;



public class Marshall {
	private April april;
	public void setApril(April april) {
		this.april = april;
	}
	
	private JAXBContext context;
	
	public void test1(File f){
			
		try {
			marshallXML(f);
			unMarshall(f);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void test2(File f){
		//JAXBContext.newInstance(C)
	}
	private void unMarshall(File f) throws JAXBException {
		context=JAXBContext.newInstance(April.class);
		Unmarshaller um = context.createUnmarshaller();
		April a=(April)um.unmarshal(f);
		System.out.println(a.getDays()+":"+a.getHoliday()+":"+a.getMonth());

	}
	private void marshallXML(File f) throws JAXBException {
		context = JAXBContext.newInstance(April.class);
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		m.marshal(april, f);
		m.marshal(april, System.out);

	}

}
