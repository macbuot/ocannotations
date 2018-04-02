package oc.proxies;

import java.lang.reflect.Proxy;

import oc.classes.StringInterface;
import oc.classes.StringInterfaceImpl;
import oc.handlers.ProxyInvocationHandlerReverse;

public class ReverseStringProxyFactory {
    public static StringInterface newInstance(String str) {
        return (StringInterface) Proxy.newProxyInstance(
                ProxyInvocationHandlerReverse.class.getClassLoader(),
                new Class[]{StringInterface.class},
                new ProxyInvocationHandlerReverse(new StringInterfaceImpl(str))
        );
    }
}
