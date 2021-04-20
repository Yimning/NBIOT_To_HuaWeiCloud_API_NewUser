package com.yimning.utils;

/**
 * File Name: com.huawei.utils.Constant.java
 *
 * Copyright Notice:
 *      Copyright  1998-2008, Huawei Technologies Co., Ltd.  ALL Rights Reserved.
 *
 *      Warning: This computer software sourcecode is protected by copyright law
 *      and international treaties. Unauthorized reproduction or distribution
 *      of this sourcecode, or any portion of it, may result in severe civil and
 *      criminal penalties, and will be prosecuted to the maximum extent
 *      possible under the law.
 */


public class Constant {

    public static final String TOKEN_BASE_URL = "https://iam.cn-north-4.myhuaweicloud.com";
    public static final String IOTDM_BASE_URL = "https://iotda.cn-north-4.myhuaweicloud.com";
    public static final String TOKEN_ACCESS_URL = TOKEN_BASE_URL + "/v3/auth/tokens";
    public static final String PROJECTS_ID_URL="https://iam.myhuaweicloud.com/v3/projects";

    public static final String Content_Type="application/json";


    public static final String DEVICE_COMMAND_URL = IOTDM_BASE_URL + "/v5/iot/%s/devices";
    public static final String PRODUCT_COMMAND_URL = IOTDM_BASE_URL + "/v5/iot/%s/products";


    //please replace the IP and Port of the IoT platform environment address, when you use the demo.
    public static final String BASE_URL = "https://49.4.92.191:8743";

    //please replace the appId and secret, when you use the demo.
    public static final String APPID = "O8syWKWBEMGUO7j0mqOskvH6x2Ea";
    public static final String SECRET = "o_m_0fHmxcMPhOgSLiv6O1HxBwEa";

    /*
     *IP and port of callback url.
     *please replace the IP and Port of your Application deployment environment address, when you use the demo.
     */
    public static final String CALLBACK_BASE_URL = "http://10.10.10.99:9999";

    /*
     * complete callback url.
     * please replace uri, when you use the demo.
     */
    public static final String DEVICE_ADDED_CALLBACK_URL = CALLBACK_BASE_URL + "/na/iocm/devNotify/v1.1.0/addDevice";
    public static final String DEVICE_INFO_CHANGED_CALLBACK_URL = CALLBACK_BASE_URL + "/na/iocm/devNotify/v1.1.0/updateDeviceInfo";
    public static final String DEVICE_DATA_CHANGED_CALLBACK_URL = CALLBACK_BASE_URL + "/na/iocm/devNotify/v1.1.0/updateDeviceData";
    public static final String DEVICE_DELETED_CALLBACK_URL = CALLBACK_BASE_URL + "/na/iocm/devNotify/v1.1.0/deletedDevice";
    public static final String MESSAGE_CONFIRM_CALLBACK_URL = CALLBACK_BASE_URL + "/na/iocm/devNotify/v1.1.0/commandConfirmData";
    public static final String SERVICE_INFO_CHANGED_CALLBACK_URL = CALLBACK_BASE_URL + "/na/iocm/devNotify/v1.1.0/updateServiceInfo";
    public static final String COMMAND_RSP_CALLBACK_URL = CALLBACK_BASE_URL + "/na/iocm/devNotify/v1.1.0/commandRspData";
    public static final String DEVICE_EVENT_CALLBACK_URL = CALLBACK_BASE_URL + "/na/iocm/devNotify/v1.1.0/DeviceEvent";
    public static final String RULE_EVENT_CALLBACK_URL = CALLBACK_BASE_URL + "/na/iocm/devNotify/v1.1.0/RulEevent";
    public static final String DEVICE_DATAS_CHANGED_CALLBACK_URL = CALLBACK_BASE_URL + "/na/iocm/devNotify/v1.1.0/updateDeviceDatas";
    public static final String DEVICE_SHADOW_MODIFIED_CALLBACK_URL = CALLBACK_BASE_URL + "/na/iocm/devNotify/v1.1.0/modifyDeviceDesired";
    
    public static final String SW_UPGRADE_CALLBACK_URL = CALLBACK_BASE_URL + "/na/iocm/devNotify/v1.1.0/upgradeSW";
    public static final String FW_UPGRADE_CALLBACK_URL = CALLBACK_BASE_URL + "/na/iocm/devNotify/v1.1.0/upgradeFW";


    /*
     * Specifies the callback URL for the command execution result notification.
     * For details about the execution result notification definition.
     *
     * please replace uri, when you use the demo.
     */
    public static final String REPORT_CMD_EXEC_RESULT_CALLBACK_URL = CALLBACK_BASE_URL + "/na/iocm/devNotify/v1.1.0/reportCmdExecResult";


    //Paths of certificates.
    public static String PROJECT_FILE_PATH = System.getProperty("user.dir");
    public static String SELFCERTPATH = "/src/main/resources/cert/outgoing.CertwithKey.pkcs12";
    public static String TRUSTCAPATH = "/src/main/resources/cert/ca.jks";

    //Password of certificates.
    public static String SELFCERTPWD = "IoM@1234";
    public static String TRUSTCAPWD = "Huawei@123";


    //*************************** The following constants do not need to be modified *********************************//

    /*
     * request header
     * 1. HEADER_APP_KEY
     * 2. HEADER_APP_AUTH
     */
    public static final String HEADER_APP_KEY = "app_key";
    public static final String HEADER_APP_AUTH = "Authorization";
    
    /*
     * Application Access Security:
     * 1. APP_AUTH
     * 2. REFRESH_TOKEN
     */
    public static final String APP_AUTH = BASE_URL + "/iocm/app/sec/v1.1.0/login";
    public static final String REFRESH_TOKEN = BASE_URL + "/iocm/app/sec/v1.1.0/refreshToken";












    /*
     * Product Management:
     * 1. CREATE_PRODUCT
     * 2. QUERY_PRODUCT
     * 3. QUERY_PRODUCT_LIST
     * 4. MODIFY_PRODUCT
     * 5. DELETE_PRODUCT
     */
    public static final String CREATE_PRODUCT = IOTDM_BASE_URL + "/v5/iot/%s/products";
    public static final String QUERY_PRODUCT = IOTDM_BASE_URL + "/v5/iot/%s/products/%s";
    public static final String QUERY_PRODUCT_LIST = IOTDM_BASE_URL + "/v5/iot/%s/products";
    public static final String MODIFY_PRODUCT = IOTDM_BASE_URL + "/v5/iot/%s/products/%s";
    public static final String DELETE_PRODUCT = IOTDM_BASE_URL + "/v5/iot/%s/products/%s";



    /*
     * Device Management:
     * 1. CREATE_DEVICE
     * 2. QUERY_DEVICE_LIST
     * 3. QUERY_DEVICE
     * 4. MODIFY_DEVICE
     * 5. DELETE_DEVICE
     * 6. RESET_DEVICE_SECRET
     * 7. FREEZE_DEVICE
     * 8. UNFREEZE_DEVICE
     */
    public static final String CREATE_DEVICE = IOTDM_BASE_URL + "/v5/iot/%s/devices";
    public static final String QUERY_DEVICE_LIST = IOTDM_BASE_URL + "/v5/iot/%s/devices";
    public static final String QUERY_DEVICE_INFO = IOTDM_BASE_URL + "/v5/iot/%s/devices/%s";
    public static final String MODIFY_DEVICE_INFO = IOTDM_BASE_URL + "/v5/iot/%s/devices/%s";
    public static final String DELETE_DEVICE = IOTDM_BASE_URL + "/v5/iot/%s/devices/%s";
    public static final String RESET_DEVICE_SECRET = IOTDM_BASE_URL + "/v5/iot/%s/devices/%s/action";
    public static final String FREEZE_DEVICE = IOTDM_BASE_URL + "/v5/iot/%s/devices/%s/freeze";
    public static final String UNFREEZE_DEVICE = IOTDM_BASE_URL + "/v5/iot/%s/devices/%s/unfreeze";

    /*
     * Device Message:
     * 1. ISSUE_DEVICE_MESSAGE
     * 2. QUERY_DEVICE_MESSAGE_LIST
     * 3. QUERY_DEVICE_MESSAGE_BY_MESSAGEID
     */
    public static final String ISSUE_DEVICE_MESSAGE = IOTDM_BASE_URL + "/v5/iot/%s/devices/%s/messages";
    public static final String QUERY_DEVICE_MESSAGE_LIST = IOTDM_BASE_URL + "/v5/iot/%s/devices/%s/messages";
    public static final String QUERY_DEVICE_MESSAGE_BY_MESSAGEID = IOTDM_BASE_URL + "/v5/iot/%s/devices/%s/messages/%s";

    /*
     * Device Command :
     * 1. CREATE_ISSUE_SYNC_DEVICE_COMMAND
     * 2. CREATE_ISSUE_ASYNC_DEVICE_COMMAND
     * 3. QUERY_DEVICE_ASYNC_COMMAND_BY_COMMANDID
     */
    public static final String CREATE_ISSUE_SYNC_DEVICE_COMMAND = IOTDM_BASE_URL + "/v5/iot/%s/devices/%s/commands";
    public static final String CREATE_ISSUE_ASYNC_DEVICE_COMMAND = IOTDM_BASE_URL + "/v5/iot/%s/devices/%s/async-commands";
    public static final String QUERY_DEVICE_ASYNC_COMMAND_BY_COMMANDID = IOTDM_BASE_URL + "/v5/iot/%s/devices/%s/async-commands/%s";

    /*
     * Device Properties :
     * 1. QUERY_DEVICE_PROPERTIES_LIST
     * 2. UPDATE_DEVICE_PROPERTIES
     */
    public static final String QUERY_DEVICE_PROPERTIES_LIST = IOTDM_BASE_URL + "/v5/iot/%s/devices/%s/properties";
    public static final String UPDATE_DEVICE_PROPERTIES = IOTDM_BASE_URL + "/v5/iot/%s/devices/%s/properties";





    /*
     * Batch Task:
     * 1. CREATE_BATCH_TASK
     * 2. QUERY_SPECIFY_TASK
     * 3. QUERY_TASK_DETAILS
     */
    public static final String CREATE_BATCH_TASK = BASE_URL + "/iocm/app/batchtask/v1.1.0/tasks";
    public static final String QUERY_SPECIFY_BATCH_TASK = BASE_URL + "/iocm/app/batchtask/v1.1.0/tasks";
    public static final String QUERY_BATCH_TASK_DETAILS = BASE_URL + "/iocm/app/batchtask/v1.1.0/taskDetails";

    /*
     * Data Collection:
     * 1. QUERY_SPECIFY_DEVICE
     * 2. QUERY_DEVICES
     * 3. QUERY_DEVICE_HISTORY_DATA
     * 4. QUERY_DEVICE_CAPABILITIES
     */
    public static final String QUERY_DEVICE = BASE_URL + "/iocm/app/dm/v1.4.0/devices";
    public static final String QUERY_DEVICES = BASE_URL + "/iocm/app/dm/v1.4.0/devices";
    public static final String QUERY_DEVICE_HISTORY_DATA = BASE_URL + "/iocm/app/data/v1.2.0/deviceDataHistory";
    public static final String QUERY_DEVICE_CAPABILITIES = BASE_URL + "/iocm/app/data/v1.1.0/deviceCapabilities";
    
    /*
     * Subscription Management:
     * 1. SUBSCRIBE_SERVICE_NOTIFYCATION
     * 2. SUBSCRIBE_MANAGEMENT_NOTIFYCATION
     * 3. QUERY_SPECIFY_SUBSCRIPTION
     * 4. QUERY_BATCH_SUBSCRIPTIONS
     * 5. DELETE_SPECIFY_SUBSCRIPTION
     * 6. DELETE_BATCH_SUBSCRIPTIONS
     */
    public static final String SUBSCRIBE_SERVICE_NOTIFYCATION = BASE_URL + "/iocm/app/sub/v1.2.0/subscriptions";
    public static final String SUBSCRIBE_MANAGEMENT_NOTIFYCATION = BASE_URL + "/iodm/app/sub/v1.1.0/subscribe";
    public static final String QUERY_SUBSCRIPTION = BASE_URL + "/iocm/app/sub/v1.2.0/subscriptions";
    public static final String QUERY_SUBSCRIPTIONS = BASE_URL + "/iocm/app/sub/v1.2.0/subscriptions";
    public static final String DELETE_SUBSCRIPTION = BASE_URL + "/iocm/app/sub/v1.2.0/subscriptions";
    public static final String DELETE_SUBSCRIPTIONS = BASE_URL + "/iocm/app/sub/v1.2.0/subscriptions";
    
    /*
     * Command Delivery:
     * 1. CREATE_DEVICE_CMD
     * 2. QUERY_DEVICE_CMD
     * 3. MODIFY_DEVICE_CMD
     * 4. CREATE_DEVICECMD_CANCEL_TASK
     * 5. QUERY_DEVICECMD_CANCEL_TASK
     * 6. INVOKE_DEVICE_SERVICES
     */
    public static final String CREATE_DEVICE_CMD = BASE_URL + "/iocm/app/cmd/v1.4.0/deviceCommands";
    public static final String QUERY_DEVICE_CMD = BASE_URL + "/iocm/app/cmd/v1.4.0/deviceCommands";
    public static final String MODIFY_DEVICE_COMMAND = BASE_URL + "/iocm/app/cmd/v1.4.0/deviceCommands";
    public static final String CREATE_DEVICECMD_CANCEL_TASK = BASE_URL + "/iocm/app/cmd/v1.4.0/deviceCommandCancelTasks";
    public static final String QUERY_DEVICECMD_CANCEL_TASK = BASE_URL + "/iocm/app/cmd/v1.4.0/deviceCommandCancelTasks";
    public static final String INVOKE_DEVICE_SERVICES = BASE_URL + "/iocm/app/signaltrans/v1.1.0/devices/%s/services/%s/sendCommand";
    
    
    /*
     * Device Group Management:
     * 1. CREATE_DEVICE_GROUP
     * 2. MODIFY_DEVICE_GROUP
     * 3. DELETE_DEVICE_GROUP
     * 4. QUERY_SPECIFY_DEVICE_GROUP
     * 5. QUERY_DEVICE_GROUPS
     * 6. QUERY_DEVICE_GROUP_MEMBERS
     * 7. ADD_DEVICE_GROUP_MEMBER
     * 8. DELETE_DEVICE_GROUP_MEMBER
     */
    public static final String CREATE_DEVICE_GROUP = BASE_URL + "/iocm/app/devgroup/v1.3.0/devGroups";
    public static final String MODIFY_DEVICE_GROUP = BASE_URL + "/iocm/app/devgroup/v1.3.0/devGroups";
    public static final String DELETE_DEVICE_GROUP = BASE_URL + "/iocm/app/devgroup/v1.3.0/devGroups";
    public static final String QUERY_SPECIFY_DEVICE_GROUP = BASE_URL + "/iocm/app/devgroup/v1.3.0/devGroups";
    public static final String QUERY_DEVICE_GROUPS = BASE_URL + "/iocm/app/devgroup/v1.3.0/devGroups";
    public static final String QUERY_DEVICE_GROUP_MEMBERS = BASE_URL + "/iocm/app/dm/v1.2.0/devices/ids";
    public static final String ADD_DEVICE_GROUP_MEMBER = BASE_URL + "/iocm/app/dm/v1.1.0/devices/addDevGroupTagToDevices";
    public static final String DELETE_DEVICE_GROUP_MEMBER = BASE_URL + "/iocm/app/dm/v1.1.0/devices/deleteDevGroupTagFromDevices";
    
    
    /*
     * Device Upgrade:
     * 1. CREATE_SW_UPGRADE_TASK
     * 2. CREATE_FW_UPGRADE_TASK
     * 3. QUERY_SPECIFY_PACKAGE
     * 4. QUERY_BATCH_PACKAGES
     * 5. DELETE_SPECIFY_PACKAGE
     * 6. QUERY_SPECIFY_UPGRADE_TASK_RESULT
     * 7. QUERY_UPGRADE_TASKS
     */
    public static final String CREATE_SW_UPGRADE_TASK = BASE_URL + "/iodm/northbound/v1.5.0/operations/softwareUpgrade";
    public static final String CREATE_FW_UPGRADE_TASK = BASE_URL + "/iodm/northbound/v1.5.0/operations/firmwareUpgrade";
    public static final String QUERY_SPECIFY_PACKAGE = BASE_URL + "/iodm/northbound/v1.5.0/category";
    public static final String QUERY_BATCH_PACKAGES = BASE_URL + "/iodm/northbound/v1.5.0/category";
    public static final String DELETE_SPECIFY_PACKAGE = BASE_URL + "/iodm/northbound/v1.5.0/category";
    public static final String QUERY_SPECIFY_UPGRADE_TASK_RESULT = BASE_URL + "/iodm/northbound/v1.5.0/operations";
    public static final String QUERY_UPGRADE_TASKS = BASE_URL + "/iodm/northbound/v1.5.0/operations";

    /*
     * service Notify Type
     * 1. deviceAdded
     * 2. bindDevice
     * 3. deviceInfoChanged
     * 4. deviceDataChanged
     * 5. deviceDatasChanged
     * 6. deviceCapabilitiesChanged
     * 7. deviceCapabilitiesAdded
     * 8. deviceCapabilitiesDeleted
     * 9. deviceDeleted
     * 10. messageConfirm
     * 11. commandRsp
     * 12. ruleEvent
     * 13. deviceDesiredPropertiesModifyStatusChanged
     */
    public static final String DEVICE_ADDED = "deviceAdded";
    public static final String BIND_DEVICE = "bindDevice";
    public static final String DEVICE_INFO_CHANGED = "deviceInfoChanged";
    public static final String DEVICE_DATA_CHANGED = "deviceDataChanged";
    public static final String DEVICE_DATAS_CHANGED = "deviceDatasChanged";
    public static final String DEVICE_CAPABILITIES_CHANGED = "deviceCapabilitiesChanged";
    public static final String DEVICE_CAPABILITIES_ADD = "deviceCapabilitiesAdded";
    public static final String DEVICE_CAPABILITIES_DELETE = "deviceCapabilitiesDeleted";
    public static final String DEVICE_DELETED = "deviceDeleted";
    public static final String MESSAGE_CONFIRM = "messageConfirm";
    public static final String COMMAND_RSP = "commandRsp";
    public static final String RULE_EVENT = "ruleEvent";
    public static final String DEVICE_SHADOW_MODIFIED = "deviceDesiredPropertiesModifyStatusChanged";
    
    /*
     * management Notify Type
     * 1. swUpgradeStateChangeNotify
     * 2. swUpgradeResultNotify
     * 3. fwUpgradeStateChangeNotify
     * 4. fwUpgradeResultNotify
     */
    public static final String SW_UPGRADE_STATE_CHANGED = "swUpgradeStateChangeNotify";
    public static final String SW_UPGRADE_RESULT = "swUpgradeResultNotify";
    public static final String FW_UPGRADE_STATE_CHANGED = "fwUpgradeStateChangeNotify";
    public static final String FW_UPGRADE_RESULT = "fwUpgradeResultNotify";

}
