package com.bgasparotto.oceejbd6.ejb1.interceptor;

import javax.ejb.EJB;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import com.bgasparotto.oceejbd6.ejb2.PrinterLocalBusiness;

/**
 * @author Bruno Gasparotto
 *
 */
public class EchoInterceptor {

	@EJB
	private PrinterLocalBusiness printer;

	@AroundInvoke
	private Object intercept(InvocationContext ic) throws Exception {
		printer.println("EchoInterceptor.intercept(InvocationContext)");

		Object result = ic.proceed();
		return result;
	}
}