package bishe.lu.controller.viewobject;

public class TpLinkVO {
    private String source;
    private String target;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    @Override
    public String toString() {
        return "TpLinkVO{" +
                "source='" + source + '\'' +
                ", target='" + target + '\'' +
                '}';
    }
}
