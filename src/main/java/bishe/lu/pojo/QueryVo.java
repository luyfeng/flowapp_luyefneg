package bishe.lu.pojo;

import java.util.List;

public class QueryVo {

    //分页
    //当前页
    private Integer page;
    //每页数
    private Integer size = 10;
    //开始行
    private Integer startRow = 0;

    private List<Integer> pageNums;

    private String tableId;
    private String flowId;
    private String inPort;
    private String outputNodeConnector;

    public List<Integer> getPageNums() {
        return pageNums;
    }

    public void setPageNums(List<Integer> pageNums) {
        this.pageNums = pageNums;
    }

    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public String getInPort() {
        return inPort;
    }

    public void setInPort(String inPort) {
        this.inPort = inPort;
    }

    public String getOutputNodeConnector() {
        return outputNodeConnector;
    }

    public void setOutputNodeConnector(String outputNodeConnector) {
        this.outputNodeConnector = outputNodeConnector;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getStartRow() {
        return startRow;
    }

    public void setStartRow(Integer startRow) {
        this.startRow = startRow;
    }


}
