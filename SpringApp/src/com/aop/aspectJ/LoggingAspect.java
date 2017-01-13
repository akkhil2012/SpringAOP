package com.aop.aspectJ;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.util.StopWatch;

@Aspect
public class LoggingAspect {
	
	
	private final Log log = LogFactory.getLog(this.getClass());

	@Around("execution(public * get*())")
	public Object logTimeMethod(ProceedingJoinPoint joinPoint) throws Throwable {

			StopWatch stopWatch = new StopWatch();
			stopWatch.start();

			Object retVal = joinPoint.proceed();

			stopWatch.stop();

			StringBuffer logMessage = new StringBuffer();
			logMessage.append(joinPoint.getTarget().getClass().getName());
			logMessage.append(".");
			logMessage.append(joinPoint.getSignature().getName());
			logMessage.append("(");
			// append args
			Object[] args = joinPoint.getArgs();
			for (int i = 0; i < args.length; i++) {
				logMessage.append(args[i]).append(",");
			}
			if (args.length > 0) {
				logMessage.deleteCharAt(logMessage.length() - 1);
			}

			logMessage.append(")");
			logMessage.append(" execution time:----------------> ");
			logMessage.append(stopWatch.getTotalTimeMillis());
			logMessage.append(" ms");
			log.error(logMessage.toString());
			return retVal;
	}
	
	
	/*@Before("allCircleMethods()")
	public void LoggingAdvice(JoinPoint joinPoint){
		//System.out.println("Advice run . get Method called");
		System.out.println(joinPoint.toString()+" " + joinPoint.getTarget());
	}
	
	
	//@Before("args(String)")
	@After("args(name)")
	public void stringArgumentMethods(String name){
		System.out.println("Method that takes String arguments only is called.  AFTER ..The value is = " + name);
	}
	
	
	@Pointcut("within(com.aop.model.Circle)")
	public void allCircleMethods(){
		
	}*/
	
	
	/*@Before("allGetters()")
	public void LoggingAdvice(){
		System.out.println("Advice run . get Method called");
	}
	
	
	@Before("allGetters()")
	public void SecondAdvice(){
		System.out.println("Second Advice executed");
	}
	
	
	@Pointcut("execution(public * get*())")
	public void allGetters(){}
	
	
	@Pointcut("within(com.aop.model..*)")
	public void allCircleMethods(){}*/

}
