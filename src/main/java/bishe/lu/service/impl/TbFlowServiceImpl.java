package bishe.lu.service.impl;

import bishe.lu.mapper.TbFlowMapper;
import bishe.lu.mapper.TbFlowMapperList;
import bishe.lu.pojo.QueryVo;
import bishe.lu.pojo.TbFlow;
import bishe.lu.service.TbFlowService;
import bishe.lu.utils.Page;
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
    public List<TbFlow> selectFlowListByQueryVo2(TbFlow flow) {

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
        List<TbFlow> flowList = tbFlowMapper.selectFlowListByQueryVo2(flow);
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

    // 通过四个条件 查询分页对象
    @Override
    public Page<TbFlow> selectPageByQueryVo(QueryVo vo) {
        Page<TbFlow> page = new Page<>();
        //每页数
        page.setPage(1);
        vo.setSize(5);
        if (null != vo) {

            // 判断当前页
            if (null != vo.getPage()) {
                page.setPage(vo.getPage());
                vo.setStartRow((vo.getPage() -1)*vo.getSize());
            }

            if (null != vo.getFlowId() && !"".equals(vo.getFlowId().trim())){
                vo.setFlowId(vo.getFlowId().trim());
            }
            if (null != vo.getTableId() && !"".equals(vo.getTableId().trim())){
                vo.setTableId(vo.getTableId().trim());
            }
            if (null != vo.getInPort() && !"".equals(vo.getInPort().trim())){
                vo.setInPort(vo.getInPort().trim());
            }
            if (null != vo.getOutputNodeConnector() && !"".equals(vo.getOutputNodeConnector().trim())){
                vo.setOutputNodeConnector(vo.getOutputNodeConnector().trim());
            }
            //总条数
            page.setTotal(tbFlowMapper.flowCountByQueryVo(vo));
            page.setRows(tbFlowMapper.selectFlowListByQueryVo(vo));
        }
        return page;
    }
}
