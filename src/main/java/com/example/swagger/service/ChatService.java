package com.example.swagger.service;

import com.example.swagger.dto.ChatMessageRequestDTO;
import com.example.swagger.dto.ChatMessageResponseDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChatService {

    private final List<ChatMessageResponseDTO> chatHistory = new ArrayList<>();

    public ChatMessageResponseDTO sendMessage(ChatMessageRequestDTO requestDTO) {
        ChatMessageResponseDTO responseDTO = new ChatMessageResponseDTO();
        responseDTO.setChattingRoomId(requestDTO.getChattingRoomId());
        responseDTO.setUserId(requestDTO.getUserId());
        responseDTO.setContent(requestDTO.getContent());
        responseDTO.setSendTime(requestDTO.getSendTime());
        chatHistory.add(responseDTO);
        return responseDTO;
    }

    public List<ChatMessageResponseDTO> getChatHistory() {
        return chatHistory;
    }
}
