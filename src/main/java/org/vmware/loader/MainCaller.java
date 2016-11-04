package org.vmware.loader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.vmware.jaxb.Marshall;
import org.vmware.serializ.Person;

public class MainCaller {
	private static ApplicationContext context;

	public static void main(String[] args) {
		// do Marshall and unMarshall of object
		doMarshaller();
		// do Serialize the object to output file
		doSerial();
		// do Deserialize the file to objects
		doDeserial();

	}

	private static void doDeserial() {
		System.out.println("deSerial block continue....");
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("serialObject.ser"));

			Person p = (Person) ois.readObject();
			System.out.println(p.toString());
			ois.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}

	}

	private static void doMarshaller() {
		System.out.println("Marshaller  and unmarshaller block continue....");
		context = new ClassPathXmlApplicationContext("bean.xml");
		Marshall a = (Marshall) context.getBean("marshall");
		File f = new File("ConnectionSettings.xml");
		a.test2(f);
		File f1 = new File("aprilmonth.xml");
		a.test1(f1);
	}

	private static void doSerial() {
		System.out.println("Serial block continue....");
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		Person p = (Person) context.getBean("person");
		System.out.println(p.toString());

		File f2 = new File("serialObject.ser");
		ObjectOutputStream oos = null;
		try {

			oos = new ObjectOutputStream(new FileOutputStream(f2));
			oos.writeObject(p);
			oos.flush();
			oos.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("Completed by Spring application control");

		}
	}

}