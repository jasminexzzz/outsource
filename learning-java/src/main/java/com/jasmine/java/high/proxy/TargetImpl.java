package com.jasmine.java.high.proxy;

/**
 * @author wangyf
 */
public class TargetImpl implements Target {

    @Override
    public Object getTarget() {
        return "返回了 target";
    }
}
