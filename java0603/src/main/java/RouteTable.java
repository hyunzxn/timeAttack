import java.util.List;

public class RouteTable {
    private String id;
    private GateWay gateway;
    private List<Subnet> subnetList;

    public void addSubnet(Subnet subnet) {
        subnetList.add(subnet);
    }



    public void route() {

    }

    public void setGateWay(GateWay gateWay) {
        this.gateway = gateWay;
    }


}
