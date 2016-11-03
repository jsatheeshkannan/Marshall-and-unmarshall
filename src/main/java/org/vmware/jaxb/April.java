package org.vmware.jaxb;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class April {
	
	private int month;
	private int days;
	private int holiday;
	@XmlAttribute(name="MM")
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	@XmlElement
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	@XmlElement
	public int getHoliday() {
		return holiday;
	}
	public void setHoliday(int holiday) {
		this.holiday = holiday;
	}
	@Override
	public String toString() {
		return "April [month=" + month + ", days=" + days + ", holiday=" + holiday + "]";
	}

}
