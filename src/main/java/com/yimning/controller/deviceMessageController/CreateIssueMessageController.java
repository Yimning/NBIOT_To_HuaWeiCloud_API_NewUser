package com.yimning.controller.deviceMessageController;


import com.yimning.entity.deviceManagement.AddDevice;
import com.yimning.entity.deviceManagement.AddDeviceResponse;
import com.yimning.entity.deviceMessage.CreateIssueMessage;
import com.yimning.entity.deviceMessage.CreateIssueMessageResponse;
import com.yimning.service.deviceMessage.CreateIssueMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deviceMessage")
public class CreateIssueMessageController {
    @Autowired
    private CreateIssueMessageService createIssueMessageService;

    @PostMapping("/createIssueMessage")
    public CreateIssueMessageResponse DeleteDevice(@RequestBody CreateIssueMessage createIssueMessage) throws Exception {
        CreateIssueMessageResponse createIssueMessageResponse = createIssueMessageService.createIssueMessage(createIssueMessage);
        return createIssueMessageResponse;
    }

}
