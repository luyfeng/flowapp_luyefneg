package bishe.lu.utils;

import bishe.lu.controller.viewobject.FlowVo;
import com.google.gson.Gson;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class OdlUtil {

    private String url = "";

    private String username;
    private String password;
    private String containerName;

    public OdlUtil(String host,int port){
        this.url = "http://" + host + ":" + port;
    }

    /**
     * 构造函数
     * @param host OpenDayLight的北向接口的主机名称
     * @param port OpenDayLight的北向接口的端口
     * @param username OpenDayLight的管理员的用户名
     * @param password OpenDayLight的管理员的密码
     * @param containerName OpenDayLight的容器名称
     * */
    public OdlUtil(String host,int port,String username,String password, String containerName){
        this.url = "http://" + host + ":" + port;
        this.username = username;
        this.password = password;
        this.containerName = containerName;
        HttpRequest.setBasicAuth(getBasicAuthStr(username,password));
    }

    /**
     * 构造函数
     * @param host OpenDayLight的北向接口的主机名称
     * @param port OpenDayLight的北向接口的端口
     * @param username OpenDayLight的管理员的用户名
     * @param password OpenDayLight的管理员的密码
     * */
    public OdlUtil(String host,int port,String username,String password){
        this.url = "http://" + host + ":" + port;
        this.username = username;
        this.password = password;
        this.containerName = "default";
        HttpRequest.setBasicAuth(getBasicAuthStr(username,password));
    }


    /***
     * getTpNodes
     * @return
     * 2019/01/30
     */

    public String getTpNodes() {
        return getTpNodes("");
    }

    public String getTpNodes(String containerName){
        return getTpNodes(containerName, "admin","admin");
    }

    public String getTpNodes(String containerName,String username,String password) {
        HttpRequest.setBasicAuth(getBasicAuthStr(username,password));
        String str = HttpRequest.sendGet(url + "/restconf/operational/network-topology:network-topology" + containerName,"");
        return str;

    }

    /***
     * getTpLinks
     * @return
     * 2019/01/30
     */

    public String getTpLinks() {
        return getTpLinks("");
    }

    public String getTpLinks(String containerName){
        return getTpLinks(containerName, "admin","admin");
    }

    public String getTpLinks(String containerName,String username,String password) {
        HttpRequest.setBasicAuth(getBasicAuthStr(username,password));
        String str = HttpRequest.sendGet(url + "/restconf/operational/network-topology:network-topology" + containerName,"");
        return str;

    }

    /***
     * getNodes
     * @lu
     */

    public String getNodes() {
        return getNodes("");
    }

    public String getNodes(String containerName, String username, String password) {
        HttpRequest.setBasicAuth(getBasicAuthStr(username,password));
        String str = HttpRequest.sendGet(url + "/restconf/operational/opendaylight-inventory:nodes" + containerName,"");
//        System.out.print(str);
        return str;
    }

    public String getNodes(String containerName){
        return getNodes(containerName, "admin","admin");
    }

    /***
     * getNode_Connector
     * @lu
     */

    public String getNode_Connector(){
        return getNode_Connector("openflow:1:1");
    }

    public String getNode_Connector(String containerName, String username, String password) {
        HttpRequest.setBasicAuth(getBasicAuthStr(username,password));
        String str = HttpRequest.sendGet(url + "/restconf/operational/opendaylight-inventory:nodes/node/openflow:1/node-connector/" + containerName,"");
//        System.out.print(str);
        return str;
    }

    public String getNode_Connector(String containerName){
        return getNode_Connector(containerName, "admin","admin");
    }

    /**
     * 下发流表
     * */
    public String installFlow(FlowVo flow){
        String json  = new Gson().toJson(flow);
        Map<String,String > headers = new HashMap<>();
        headers.put("Accept","application/json'");
        headers.put("Content-type","application/json");
        try {
            String str = HttpRequest.sendPut(url + "/controller/nb/v2/flowprogrammer/" + containerName + "/node/OF/" + flow.getNode().getId() + "/staticFlow/" + flow.getName(),headers,json);
            System.out.println(str);
            return str;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /******************************************/

    private String getBasicAuthStr(String name,String password){
        return "Basic " + Base64.getEncoder().encodeToString((name + ":" + password).getBytes());
    }
}
