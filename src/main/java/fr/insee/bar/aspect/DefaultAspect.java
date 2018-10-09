package fr.insee.bar.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DefaultAspect {

	public DefaultAspect() {
		System.out.println("DefaultAspect()");
	}

	@Before("apiPointcut()")
	public void logRequest(JoinPoint joinPoint) {
		System.out.println(joinPoint.toString());
	}

	@AfterReturning(value = "apiPointcut()", returning = "returnValue")
	public void logResponse(Object returnValue) {
		System.out.println("=> " + returnValue);
	}

	@Pointcut("within(fr.insee.bar.controller.*) || within(fr.insee.bar.service.*)")
	public void apiPointcut() {
	}
}
