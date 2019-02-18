package bishe.lu.service.impl;

import bishe.lu.mapper.TbFlowMapper;
import bishe.lu.mapper.TbFlowMapperList;
import bishe.lu.pojo.TbFlow;
import bishe.lu.service.TbFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbFlowServiceImpl implements TbFlowService {

    @Autowired
    private TbFlowMapper tbFlowMapper;

    @Autowired
    private TbFlowMapperList tbFlowMapperList;

    @Override
    public List<TbFlow> selectFlowListByQueryVo(TbFlow flow) {

        if (null != flow) {
           if (null != flow.getFlowId() && !"".equals(flow.getFlowId().trim())){
               flow.setFlowId(flow.getFlowId().trim());
           }
           if (null != flow.getTableId() && !"".equals(flow.getTableId().trim())){
                flow.setTableId(flow.getTableId().trim());
           }
           if (null != flow.getInPort() && !"".equals(flow.getInPort().trim())){
                flow.setInPort(flow.getInPort().trim());
           }
           if (null != flow.getOutputNodeConnector() && !"".equals(flow.getOutputNodeConnector().trim())){
                flow.setOutputNodeConnector(flow.getOutputNodeConnector().trim());
           }
        }
        List<TbFlow> flowList = tbFlowMapper.selectFlowListByQueryVo(flow);
        return flowList;


    }

    @Override
    public void saveTbFlow(TbFlow flow) throws Exception {
        tbFlowMapper.insert(flow);
    }

    @Override
    public void updateTbFlow(TbFlow flow) {
        tbFlowMapper.updateByPrimaryKey(flow);
    }

    @Override
    public void deleteTbFlow(String flowId) {
        tbFlowMapper.deleteByPrimaryKey(flowId);
    }

    @Override
    public TbFlow queryTbFlowById(String flowId) {
        return tbFlowMapper.selectByPrimaryKey(flowId);
    }

    @Override
    public List<TbFlow> queryTbFlowList(TbFlow flow) {
        List<TbFlow> tbFlowList = tbFlowMapper.select(flow);
        return tbFlowList;
    }

    @Override
    public List<TbFlow> queryTbFlowListPaged(TbFlow flow, Integer page, Integer pageSize) {
        return null;
    }

    @Override
    public TbFlow queryTbFlowByIdList(String flowId) {
        return null;
    }

    @Override
    public void saveTbFlowTransactional(TbFlow flow) {

    }
}
