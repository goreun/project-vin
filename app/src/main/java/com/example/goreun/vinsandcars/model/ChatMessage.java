package com.example.goreun.vinsandcars.model;

public class ChatMessage {

    private String message;
    private boolean left;

    public ChatMessage(boolean left,String message){
        this.message = message;
        this.left = left;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isLeft() {
        return left;
    }

    public void setleft(boolean left) {
        this.left = left;
    }
}
