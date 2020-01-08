package com.sys.china.utils;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.sys.china.config.SmsProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 汪梦瑶
 * @create  2019-12-24 15:19
 */
@Component
@EnableConfigurationProperties(SmsProperties.class)
public class SmsUtils {

    @Autowired
    private SmsProperties prop;

    //产品域名,开发者无需替换
    static final String domain = "dysmsapi.aliyuncs.com";

    static final Logger logger =
            LoggerFactory.getLogger(SmsUtils.class);


    public CommonResponse sendSms(String phone, String code, String signName, String template)  {
        //初始化acsClient,暂不支持region化
        DefaultProfile profile = DefaultProfile.getProfile("default", prop.getAccessKeyId(), prop.getAccessKeySecret());
        IAcsClient client = new DefaultAcsClient(profile);

        //组装请求对象-具体描述见控制台-文档部分内容
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain(domain);
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");

        //必填:待发送手机号
        request.putQueryParameter("PhoneNumbers", phone);
        //必填:短信签名-可在短信控制台中找到
        request.putQueryParameter("SignName", signName);
        //必填:短信模板-可在短信控制台中找到
        request.putQueryParameter("TemplateCode", template);

        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        request.putQueryParameter("TemplateParam", "{\"code\":\"" + code + "\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println("发送短信结果为："+response.getData());
            //{"Message":"OK","RequestId":"08C3FC82-159B-4FCC-A32C-4E1638787F09","BizId":"351910169162041803^0","Code":"OK"}
            return response;
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return null;
    }
}

