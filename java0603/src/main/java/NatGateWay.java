public class NatGateWay extends GateWay {
    private int id;
    private Subnet subnet;

    public void send() {

    }

    public NatGateWay(Subnet subnet) {
        this.subnet = subnet;
    }
}
