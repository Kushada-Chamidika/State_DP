package designpatternsday09statepattern;

public class RealImplementation {

    public static void main(String[] args) {

        phoneContext contextPhn = new phoneContext();

        onState stateOn = new onState();
        offState stateOff = new offState();
        silentState stateSilent = new silentState();

        contextPhn.setState(stateOn);
        contextPhn.incomingCall();

        contextPhn.setState(stateOff);
        contextPhn.incomingCall();

        contextPhn.setState(stateSilent);
        contextPhn.incomingCall();

    }

}

interface phoneState {

    public abstract void incomingCall();

}

class phoneContext implements phoneState {

    phoneState state;

    public void setState(phoneState state) {
        this.state = state;
    }

    public phoneState getState() {
        return state;
    }

    @Override
    public void incomingCall() {
        state.incomingCall();
    }
}

class offState implements phoneState {

    @Override
    public void incomingCall() {
        System.out.println("Incoming Call -> Off State");
    }

}

class onState implements phoneState {

    @Override
    public void incomingCall() {
        System.out.println("Incoming Call -> On State");
    }

}

class silentState implements phoneState {

    @Override
    public void incomingCall() {
        System.out.println("Incoming Call -> Silent State");
    }

}
