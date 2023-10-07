package com.jiang.api;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
@SpringBootApplication
public class ApiTest {
    @Test
    public void query_question() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet("https://api.zsxq.com/v2/topics/811252154528852/comments?sort=asc&count=30&with_sticky=true");

        get.addHeader("cookie","zsxq_access_token=724CB3FA-D62D-7297-E0B5-EA999CBB7680_FB220ECC3FBA7442; abtest_env=product; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22415842188511828%22%2C%22first_id%22%3A%2218952e94c82512-0f5f965e88ac7e8-7e565470-1395396-18952e94c831019%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg5NTJlOTRjODI1MTItMGY1Zjk2NWU4OGFjN2U4LTdlNTY1NDcwLTEzOTUzOTYtMTg5NTJlOTRjODMxMDE5IiwiJGlkZW50aXR5X2xvZ2luX2lkIjoiNDE1ODQyMTg4NTExODI4In0%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22415842188511828%22%7D%2C%22%24device_id%22%3A%2218952e94c82512-0f5f965e88ac7e8-7e565470-1395396-18952e94c831019%22%7D; zsxqsessionid=ba8106217974bba3c971da633e81594c");
        get.addHeader("Content-Type","application/json; charset=UTF-8");

        CloseableHttpResponse response = httpClient.execute(get);
        if(response.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else{
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/811252154528852/comments");

        post.addHeader("cookie","zsxq_access_token=724CB3FA-D62D-7297-E0B5-EA999CBB7680_FB220ECC3FBA7442; abtest_env=product; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22415842188511828%22%2C%22first_id%22%3A%2218952e94c82512-0f5f965e88ac7e8-7e565470-1395396-18952e94c831019%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg5NTJlOTRjODI1MTItMGY1Zjk2NWU4OGFjN2U4LTdlNTY1NDcwLTEzOTUzOTYtMTg5NTJlOTRjODMxMDE5IiwiJGlkZW50aXR5X2xvZ2luX2lkIjoiNDE1ODQyMTg4NTExODI4In0%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22415842188511828%22%7D%2C%22%24device_id%22%3A%2218952e94c82512-0f5f965e88ac7e8-7e565470-1395396-18952e94c831019%22%7D; zsxqsessionid=ba8106217974bba3c971da633e81594c");
        post.addHeader("Content-Type","application/json; charset=UTF-8");

        //设置实体集
        String paramJson ="{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"不知道\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"mentioned_user_ids\": []\n" +
                "  }\n" +
                "}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json","utf-8"));

        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if(response.getStatusLine().getStatusCode()==HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else{
            System.out.println(response.getStatusLine().getStatusCode());
        }

    }
}
