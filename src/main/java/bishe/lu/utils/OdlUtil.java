package bishe.lu.utils;

import java.util.Base64;

public class OdlUtil {

    private String url = "";

    public OdlUtil(String host,int port){
        this.url = "http://" + host + ":" + port;
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
     * @return
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
     * @return
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

    /******************************************/

    private String getBasicAuthStr(String name,String password){
        return "Basic " + Base64.getEncoder().encodeToString((name + ":" + password).getBytes());
    }



}