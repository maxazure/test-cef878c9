
/**
 * @Title: JoddHttpUtils.java
 * @Package: com.hynet.ssn.server.util
 * @Description: TODO
 * @author: zhangcan
 * @date: 2016年6月15日 下午5:15:37
 * @version: V1.0
 */
package nz.co.cocca.test.javatest.utils;

import jodd.http.HttpRequest;
import jodd.http.HttpResponse;
import jodd.http.JoddHttp;

import java.util.Map;

/**
 * @moudle: JoddHttpUtils
 * @version:v1.0
 *
 */
public class JoddHttpUtils {
    private static int DEFAULT_CONNECT_TIME_OUT = 6000;
    private static int DEFAULT_READ_TIME_OUT = 6000;
    private static String DEFAULT_ENCODING_UTF_8 = JoddHttp.defaultBodyEncoding;

    private static String DEFAULT_APPLICATION_JSON = "application/json";

    public static String FORM_URLENCODED = "application/x-www-form-urlencoded" ;

    /**
     * send <br>
     * <p>Title: sendPost</p>
     *
     * @param url String <br>
     * @param params Map<String, Object> <br/>
     * @return String <br/>
     */
    public static String sendPost(String url, Map<String, Object> params) {
        return sendPost(url, params, DEFAULT_CONNECT_TIME_OUT,
                DEFAULT_READ_TIME_OUT, DEFAULT_ENCODING_UTF_8);
    }

    /**
     * send post <br>
     * <p>Title: sendPost</p>
     *
     * @param url String <br>
     * @param params Map<String, Object> <br/>
     * @param connectTimeOut int (ms)<br/>
     * @param readTimeOut int (ms)<br/>
     * @param encoding String <br/>
     * @return String response content<br/>
     */
    public static String sendPost(String url, Map<String, Object> params,
                                  int connectTimeOut, int readTimeOut, String encoding) {
        HttpResponse httpResponse = HttpRequest.post(url)
                .connectionTimeout(connectTimeOut).timeout(readTimeOut)
                .formEncoding(encoding).form(params).send();
        return httpResponse.accept(encoding).bodyText();
    }

    public static String sendPost(String url, Map<String, Object> params,
                                  int connectTimeOut, int readTimeOut, String encoding,String contentType) {
        HttpResponse httpResponse = HttpRequest.post(url)
                .connectionTimeout(connectTimeOut).timeout(readTimeOut)
                .formEncoding(encoding).form(params).contentType(contentType).send();
        return httpResponse.accept(encoding).bodyText();
    }


    /**
     * <p>Title: sendPostUseBody</p>
     *
     * @param url String <br/>
     * @param jsonParamBody String <br/>
     * @return String <br/>
     */
    public static String sendPostUseBody(String url, String jsonParamBody) {
        return sendPostUseBody(url, jsonParamBody, DEFAULT_CONNECT_TIME_OUT,
                DEFAULT_READ_TIME_OUT, DEFAULT_ENCODING_UTF_8);
    }

    /**
     * <p>Title: sendPostUseBody</p>
     *
     * @param url String <br/>
     * @param jsonParamBody String <br/>
     * @param connectTimeOut int (ms)<br/>
     * @param readTimeOut int (ms)<br/>
     * @param encoding String <br/>
     * @return String response content<br/>
     */
    public static String sendPostUseBody(String url, String jsonParamBody,
                                         int connectTimeOut, int readTimeOut, String encoding) {
        HttpResponse httpResponse =
                HttpRequest.post(url).connectionTimeout(connectTimeOut)
                        .timeout(readTimeOut).formEncoding(encoding)
                        .bodyText(jsonParamBody, "application/json;", encoding).send();
        return httpResponse.accept(encoding).bodyText();
    }

    /**
     *
     * 使用Jodd发送Get请求<br/>
     * <p>Title: getData</p>
     *
     * @param url String <br/>
     * @param params Map<String,String> <br/>
     * @return String <br/>
     */
    public static String getData(String url, Map<String, String> params) {
        return getData(url, params, DEFAULT_CONNECT_TIME_OUT,
                DEFAULT_READ_TIME_OUT, DEFAULT_ENCODING_UTF_8);
    }

    /**
     *
     * 使用Jodd发送Get请求<br/>
     * <p>Title: getData</p>
     *
     * @param url String request url<br/>
     * @param params Map<String, String> request params<br/>
     * @param connectTimeOut int Time out<br/>
     * @param readReadTimeOut timeout of reading<br/>
     * @param encoding String encoding<br/>
     * @return String 响应内容<br/>
     */
    public static String getData(String url, Map<String, String> params,
                                 int connectTimeOut, int readReadTimeOut, String encoding) {
        HttpResponse httpResponse =
                HttpRequest.get(url).connectionTimeout(connectTimeOut)
                        .timeout(readReadTimeOut).accept(DEFAULT_APPLICATION_JSON).query(params).send();
        return httpResponse.accept(DEFAULT_APPLICATION_JSON).bodyText();
    }

    public static void main(String[] args) {
        /** usage of params  */
/*        String url = "http://localhost:8080/m/mail";
        Map<String, Object> paramMap = new HashMap<String,Object>();
        paramMap.put("html", "您好，测试一下数据");
        paramMap.put("mailTo","zhangcan0327@sina.com;fshuqing@qq.com");
        paramMap.put("subject", "逗你玩！");
        String result = JoddHttpUtils.sendPost(url, paramMap);
        System.out.println("post:" + result);*/

        /** JSON to post Example*/
/*        String url = "http://192.168.200.106:8080/zxBadInfo/query.do";
        Gson gson = new Gson();
        String sid = "";
        String md5pwd = "";
        String despwd = "";
        String transno = RandomStringUtils.randomNumeric(20);
        ZxBadInfo blxx = new ZxBadInfo();
        blxx.setDespwd(despwd);
        blxx.setMd5pwd(md5pwd);
        blxx.setCpserialnum(transno);
        blxx.setIdnum("110201198901205230");
        blxx.setName("奥巴马");
        String jsonParamBody = gson.toJson(blxx);
        String result = sendPostUseBody(url, jsonParamBody);
        System.out.println("result:" + result);*/

    }
}
