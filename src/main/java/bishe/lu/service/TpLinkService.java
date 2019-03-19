package bishe.lu.service;


import bishe.lu.pojo.TpLink;

import java.util.List;

public interface TpLinkService {

//    public void saveNodeConnector();
//
//    public List<NodeConnector> queryNodeConnectorList(NodeConnector nodeConnector);


    public void saveTpLink();
    public TpLink saveTpLinkapi(TpLink link);
    public List<TpLink> queryTpLinkList(TpLink tpLink);
}
