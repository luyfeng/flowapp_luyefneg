package bishe.lu.mapper;

import bishe.lu.pojo.TbFlow;
import bishe.lu.utils.MyMapper;

import java.util.List;

public interface TbFlowMapper extends MyMapper<TbFlow> {
    public List<TbFlow> selectFlowListByQueryVo(TbFlow flow);
}