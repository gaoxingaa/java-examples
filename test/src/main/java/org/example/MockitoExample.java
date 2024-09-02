package org.example;

public class MockitoExample {
    private Example hello;

    public Example getHello() {
        return hello;
    }

    public void setHello(Example hello) {
        this.hello = hello;
    }

    public String getName(){
        return hello.getName();
    }
}
