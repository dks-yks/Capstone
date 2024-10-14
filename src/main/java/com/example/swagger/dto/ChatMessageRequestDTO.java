package com.example.swagger.dto;

public class ChatMessageRequestDTO {
    private int chattingRoomId;
    private int userId;
    private String content;
    private long sendTime;

    public int getChattingRoomId() {
        return chattingRoomId;
    }

    public void setChattingRoomId(int chattingRoomId) {
        this.chattingRoomId = chattingRoomId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getSendTime() {
        return sendTime;
    }

    public void setSendTime(long sendTime) {
        this.sendTime = sendTime;
    }
}