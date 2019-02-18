package bishe.lu.service;

import bishe.lu.pojo.TbFlow;

import java.util.List;

public interface TbFlowService {

    public List<TbFlow> selectFlowListByQueryVo(TbFlow flow);

    public void saveTbFlow(TbFlow flow) throws Exception;

    public void updateTbFlow(TbFlow flow);

    public void deleteTbFlow(String flowId);

    public TbFlow queryTbFlowById(String flowId);

    public List<TbFlow> queryTbFlowList(TbFlow flow);

    public List<TbFlow> queryTbFlowListPaged(TbFlow flow, Integer page, Integer pageSize);

    public TbFlow queryTbFlowByIdList(String flowId);

    public void saveTbFlowTransactional(TbFlow flow);

}
