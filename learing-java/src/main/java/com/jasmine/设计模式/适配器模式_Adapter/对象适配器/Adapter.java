package com.jasmine.设计模式.适配器模式_Adapter.对象适配器;

/**
 * @author : jasmineXz
 */
public class Adapter implements Ps2 {
    private Usb usb;
    public Adapter(Usb usb){
        this.usb = usb;
    }
    @Override
    public void isPs2() {
        usb.isUsb();
    }
}
