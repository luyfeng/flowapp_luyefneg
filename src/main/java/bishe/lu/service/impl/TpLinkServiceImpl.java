package bishe.lu.service.impl;

import bishe.lu.mapper.TpLinkMapper;
import bishe.lu.pojo.TpLink;
import bishe.lu.service.TpLinkService;
import bishe.lu.service.model.topomodel.LinkBean;
import bishe.lu.service.model.topomodel.NetworkTopologyBean;
import bishe.lu.service.model.topomodel.NetworkTopologyRootBean;
import bishe.lu.service.model.topomodel.TopologyBean;
import bishe.lu.utils.OdlUtil;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TpLinkServiceImpl implements TpLinkService {


    @Autowired
    TpLinkMapper tpLinkMapper;

    @Override
    @Transactional
    public void saveTpLink() {
        //调用odl接口类，取出数据
        OdlUtil odlUtil = new OdlUtil("10.211.55.10",8181);

        String str = null;
        str = odlUtil.getTpLinks();

        Gson gson = new Gson();

        //用gson把json字符串数据转化成javabean实体，数据存到NodesRootBean类中
        NetworkTopologyRootBean networkTopologyRootBean = gson.fromJson(str,NetworkTopologyRootBean.class);

        TpLink tpLink = new TpLink();

        //把从odl接口取到的数据存到pojo中，然后存入数据库
        NetworkTopologyBean networkTopologyBean = networkTopologyRootBean.getNetworkTopology();
        List<TopologyBean> topologyBeanList = networkTopologyBean.getTopologyBeanList();
        for (TopologyBean topologyBean : topologyBeanList) {
            List<LinkBean> linkBeanList = topologyBean.getLinkBeanList();
            for (LinkBean linkBean : linkBeanList) {
                tpLink.setLinkId(linkBean.getLinkId());
                tpLink.setDestNode(linkBean.getDestinationBean().getDestNode());
                tpLink.setDestTp(linkBean.getDestinationBean().getDestTp());
                tpLink.setSourceTp(linkBean.getSourceBean().getSourceTp());
                tpLink.setSourceNode(linkBean.getSourceBean().getSourceNode());
                TpLink link = tpLinkMapper.selectByPrimaryKey(linkBean.getLinkId());
                System.out.println("linktest===="+link);
                if (null == link) {
                    tpLinkMapper.insert(tpLink);
                    System.out.println("lulu123**************"+tpLink.toString());
                }


            }
        }
    }

    @Override
    public TpLink saveTpLinkapi(TpLink tpLink) {
        //调用odl接口类，取出数据
        OdlUtil odlUtil = new OdlUtil("10.211.55.10",8181);

        String str = null;
        str = odlUtil.getTpLinks();

        Gson gson = new Gson();

        //用gson把json字符串数据转化成javabean实体，数据存到NodesRootBean类中
        NetworkTopologyRootBean networkTopologyRootBean = gson.fromJson(str,NetworkTopologyRootBean.class);

//        TpLink tpLink = new TpLink();

        //把从odl接口取到的数据存到pojo中，然后存入数据库
        NetworkTopologyBean networkTopologyBean = networkTopologyRootBean.getNetworkTopology();
        List<TopologyBean> topologyBeanList = networkTopologyBean.getTopologyBeanList();
        for (TopologyBean topologyBean : topologyBeanList) {
            List<LinkBean> linkBeanList = topologyBean.getLinkBeanList();
            for (LinkBean linkBean : linkBeanList) {
                tpLink.setLinkId(linkBean.getLinkId());
                tpLink.setDestNode(linkBean.getDestinationBean().getDestNode());
                tpLink.setDestTp(linkBean.getDestinationBean().getDestTp());
                tpLink.setSourceTp(linkBean.getSourceBean().getSourceTp());
                tpLink.setSourceNode(linkBean.getSourceBean().getSourceNode());
                tpLinkMapper.insert(tpLink);
                System.out.println("lulu123**************"+tpLink);
                return tpLink;
            }
        }
        return tpLink;
    }

    @Override
    public List<TpLink> queryTpLinkList(TpLink tpLink) {
        List<TpLink> tplinkList = tpLinkMapper.select(tpLink);

        return tplinkList;
    }
}
