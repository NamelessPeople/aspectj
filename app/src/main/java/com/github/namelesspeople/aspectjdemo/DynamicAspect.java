package com.github.namelesspeople.aspectjdemo;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.github.namelesspeople.aspectjdemo.permission.annotation.NeedPermission;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.ArrayList;

/**
 * 类描述：
 * 创建人： 张力
 * 创建时间： 2018/9/11
 * 版权： 成都智慧一生约科技有限公司
 */
@Aspect
public class DynamicAspect {

    private static final String PERMISSION_REQUEST_POINTCUT =
            "execution(@com.github.namelesspeople.aspectjdemo.Intercept * *(..))";

    @Pointcut(PERMISSION_REQUEST_POINTCUT + " && @annotation(intercept)")
    public void requestInterceptMethod(Intercept intercept) {
    }

    @Around("requestInterceptMethod(intercept)")
    public void AroundJoinPoint(final ProceedingJoinPoint joinPoint, Intercept intercept) {
//        try {
//            joinPoint.proceed();
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//        }

        Context context = null;
        final Object object = joinPoint.getThis();
        if (object instanceof Context) {
            context = (Context) object;
        } else if (object instanceof Fragment) {
            context = ((Fragment) object).getActivity();
        } else if (object instanceof android.support.v4.app.Fragment) {
            context = ((android.support.v4.app.Fragment) object).getActivity();
        }
        if (context == null ) return;
        context.startActivity(new Intent(context,LoginActivity.class));

    }

    @Before("requestInterceptMethod(intercept)")
    public void before(JoinPoint joinPoint) {
        Log.d("ssss","Before");
    }

    @After("requestInterceptMethod(intercept)")
    public void After(JoinPoint joinPoint) {
        Log.d("ssss","After");
    }

    @AfterReturning("requestInterceptMethod(intercept)")
    public void AfterReturning(JoinPoint joinPoint, Object result) {
        Log.d("ssss","AfterReturning");
    }

    @AfterThrowing(value ="requestInterceptMethod(intercept)")
    public void afterThrowing(JoinPoint joinPoint) {
        Log.d("ssss","AfterThrowing");
    }


}
