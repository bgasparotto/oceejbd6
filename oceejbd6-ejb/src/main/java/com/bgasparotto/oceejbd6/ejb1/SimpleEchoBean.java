package com.bgasparotto.oceejbd6.ejb1;

import java.security.Principal;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;
import javax.interceptor.Interceptors;

import com.bgasparotto.oceejbd6.ejb1.interceptor.EchoInterceptor;
import com.bgasparotto.oceejbd6.ejb2.PrinterRemoteBusiness;

/**
 * @author Bruno Gasparotto
 *
 */
@Stateful
@Interceptors(EchoInterceptor.class)
@DeclareRoles("admin")
@StatefulTimeout(value=0)
public class SimpleEchoBean implements EchoLocalBusiness, EchoRemoteBusiness {

	@EJB
	private PrinterRemoteBusiness printer;

	@Resource
	private SessionContext context;

	@PostConstruct
	private void init() {
		printer.println("SimpleEchoBean.init()");
		Principal callerPrincipal = context.getCallerPrincipal();
		System.out.println("Caller principal: " + callerPrincipal);
//		System.out.println("Is caller in role: " + context.isCallerInRole("admin"));
	}

	@Override
	public String echoAndReturn(String s1, String s2) {
		EchoLocalBusiness o = context
				.getBusinessObject(EchoLocalBusiness.class);
//		TimerService timerService = context.getTimerService();
//		Collection<Timer> timers = timerService.getTimers();
//		for (Timer timer : timers) {
//			timer.cancel();
//			TimerHandle handle = timer.getHandle();
//			Timer timer2 = handle.getTimer();
//			printer.println(timer2.equals(timer));
//			printer.println(handle.toString());
//		}
		printer.println(o);
		printer.println(s1);
		printer.println(s2);
		return (s1 + " - " + s2);
	}

	@Override
	public void justEcho(String s) {
		printer.println(s);

//		Future<Integer> future = new AsyncResult<Integer>(10);
//		future.cancel(true);
//		int result = 0;
//		try {
//			result = future.get();
//		} catch (InterruptedException e) {
//			printer.println(e.getMessage());
//		} catch (ExecutionException e) {
//			Throwable originalException = e.getCause();
//			printer.println(originalException.getMessage());
//		}
//
//		printer.println(result);
	}

	@PreDestroy
	private void cleanup() {
		System.out.println("SimpleEchoBean.cleanup()");
		Principal callerPrincipal = context.getCallerPrincipal();
		System.out.println("Caller principal: " + callerPrincipal);
//		System.out.println("Is caller in role: " + context.isCallerInRole("admin"));
	}
}