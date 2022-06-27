package designpatternsday09statepattern;

import oracle.jrockit.jfr.tools.ConCatRepository;

public class Test {

    public static void main(String[] args) {

        Context c = new Context();

        A a = new A();
        B b = new B();

        c.setState(a);
        c.p();
        c.q();
        c.r();

        c.setState(b);
        c.p();
        c.q();
        c.r();

    }

}

interface State {

    public abstract void p();

    public abstract void q();

    public abstract void r();

}

class Context implements State { //Context Is-A State

    State s; //Context Has-A State

    public State getState() {
        return s;
    }

    public void setState(State s) {
        this.s = s;
    }

    @Override
    public void p() {
        s.p();
    }

    @Override
    public void q() {
        s.q();
    }

    @Override
    public void r() {
        s.r();
    }

}

class A implements State {

    @Override
    public void p() {
        System.out.println("A -> p");
    }

    @Override
    public void q() {
        System.out.println("A -> q");
    }

    @Override
    public void r() {
        System.out.println("A -> r");
    }

}

class B implements State {

    @Override
    public void p() {
        System.out.println("B -> p");
    }

    @Override
    public void q() {
        System.out.println("B -> q");
    }

    @Override
    public void r() {
        System.out.println("B -> r");
    }

}
