package com.fawvw.zheda.HBase;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.hbase.model.v20190101.DescribeInstanceRequest;
import com.aliyuncs.hbase.model.v20190101.DescribeInstanceResponse;
import com.aliyuncs.profile.DefaultProfile;
import com.google.gson.Gson;

public class MyTest {
    public static void main(String[] args) {

        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou",
                "LTAI5tQ5kHVFXgNvH2t2BNEs", "UXwZt8mxQJ4bPncMC4mFdwJBuFrT8S");
        DefaultProfile.addEndpoint(
                "cn-hangzhou",    // 地域ID
                "hbase",    // 产品编码
                "hbase.aliyuncs.com"    // 接入地址，即域名
        );
        IAcsClient client = new DefaultAcsClient(profile);
        DescribeInstanceRequest request = new DescribeInstanceRequest();
        request.setClusterId("ap-111111111111111");
        DescribeInstanceResponse response;
        try {
            response = client.getAcsResponse(request);
            System.out.println(new Gson().toJson(response));
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}
