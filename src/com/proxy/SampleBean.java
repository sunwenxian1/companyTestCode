package com.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.beans.BeanGenerator;
import net.sf.cglib.beans.BeanMap;
import net.sf.cglib.beans.ImmutableBean;

import org.junit.Assert;
import org.junit.Test;

public class SampleBean {
    private String value;

    public SampleBean() {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
/*    
    @Test(expected = IllegalStateException.class)
    public void testImmutableBean() throws Exception{
        SampleBean bean = new SampleBean();
        bean.setValue("Hello world");
        SampleBean immutableBean = (SampleBean) ImmutableBean.create(bean); //�������ɱ���
        Assert.assertEquals("Hello world",immutableBean.getValue()); 
        bean.setValue("Hello world, again"); //����ͨ���ײ�����������޸�
        Assert.assertEquals("Hello world, again", immutableBean.getValue());
        immutableBean.setValue("Hello cglib"); //ֱ���޸Ľ�throw exception
    }*/


	@Test
    public void testBeanGenerator() throws Exception{
        BeanGenerator beanGenerator = new BeanGenerator();
        beanGenerator.addProperty("value",String.class);
        Object myBean = beanGenerator.create();
        Method setter = myBean.getClass().getMethod("setValue",String.class);
        setter.invoke(myBean,"Hello cglib");

        Method getter = myBean.getClass().getMethod("getValue");
        Assert.assertEquals("Hello cglib",getter.invoke(myBean));
    }



}
