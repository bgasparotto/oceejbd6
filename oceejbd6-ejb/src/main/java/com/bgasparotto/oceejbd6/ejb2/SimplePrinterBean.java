package com.bgasparotto.oceejbd6.ejb2;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 * @author Bruno Gasparotto
 *
 */
@Local(PrinterLocalBusiness.class)
@Remote(PrinterRemoteBusiness.class)
@LocalBean
@Singleton
@Startup
public class SimplePrinterBean {

	public void println(String value) {
		System.out.println(value);
	}

	public void println(Object object) {
		if (object == null) {
			this.println(null);
			return;
		}

		this.println(object.toString());
	}
}