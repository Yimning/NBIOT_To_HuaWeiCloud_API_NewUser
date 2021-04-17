package com.yimning.service.deviceAccess.commandDelivery;

import com.yimning.entity.SendCommand;

public interface InvokeDeviceServicesService {
    /** 
     * @Description: 下发设备命令服务,仅适用于使用MQTT协议接入的设备
     */
    public SendCommand InvokeDeviceServices(SendCommand sendCommand) throws Exception ;

}
