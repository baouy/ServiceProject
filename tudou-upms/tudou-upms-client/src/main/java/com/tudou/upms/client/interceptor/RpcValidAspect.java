package com.tudou.upms.client.interceptor;

import com.tudou.common.base.BaseResult;
import com.tudou.upms.common.constant.UpmsResult;
import com.tudou.upms.common.constant.UpmsResultConstant;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.validation.BindingResult;

/**
 * Created by DavidWang on 2017/6/3.
 */
@Aspect
public class RpcValidAspect {

	@Pointcut("execution(* *..controller..*.*(..))")
	public void aopMethod(){}

	@Around("aopMethod()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

		BindingResult bindingResult = null;
		for(Object arg:joinPoint.getArgs()){
			if(arg instanceof BindingResult){
				bindingResult = (BindingResult) arg;
			}
		}
		if(bindingResult != null){
			if(bindingResult.hasErrors()){
				String errorInfo = bindingResult.getFieldError().getDefaultMessage();
				return new UpmsResult(UpmsResultConstant.FAILED, errorInfo);
			}
		}
		return joinPoint.proceed();
	}
}
