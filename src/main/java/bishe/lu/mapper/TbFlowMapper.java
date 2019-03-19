package bishe.lu.mapper;

import bishe.lu.pojo.QueryVo;
import bishe.lu.pojo.TbFlow;
import bishe.lu.utils.MyMapper;

import java.util.List;

public interface TbFlowMapper extends MyMapper<TbFlow> {

    //总条数
    public Integer flowCountByQueryVo(QueryVo vo);
    //结果集
    public List<TbFlow> selectFlowListByQueryVo(QueryVo vo);

    public List<TbFlow> selectFlowListByQueryVo2(TbFlow flow);

}