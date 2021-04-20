package com.yimning.service.deviceMessage;

import com.yimning.entity.deviceManagement.AddDevice;
import com.yimning.entity.deviceManagement.AddDeviceResponse;
import com.yimning.entity.deviceMessage.CreateIssueMessage;
import com.yimning.entity.deviceMessage.CreateIssueMessageResponse;

public interface CreateIssueMessageService {
    /** 
     * @Description: 创建下发设备消息
     */
    public  CreateIssueMessageResponse createIssueMessage(CreateIssueMessage createIssueMessage) throws Exception ;
}
