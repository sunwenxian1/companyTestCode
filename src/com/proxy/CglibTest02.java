package com.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.beans.BeanGenerator;
import net.sf.cglib.beans.BeanMap;

import org.junit.Assert;
import org.junit.Test;

public class CglibTest02 {
    @Test
    public void testBeanMap() throws Exception{
        BeanGenerator generator = new BeanGenerator();
        generator.addProperty("username",String.class);
        generator.addProperty("password",String.class);
        Object bean = generator.create();
        Method setUserName = bean.getClass().getMethod("setUsername", String.class);
        Method setPassword = bean.getClass().getMethod("setPassword", String.class);
        setUserName.invoke(bean, "admin1");
        setPassword.invoke(bean,"password1");
        BeanMap map = BeanMap.create(bean);
        Assert.assertEquals("admin1", map.get("username"));
        Assert.assertEquals("password1", map.get("password"));
        System.out.println(map.toString());
    }
}
