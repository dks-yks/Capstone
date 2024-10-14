package com.example.swagger.controller;

import com.example.swagger.dto.ChatMessageRequestDTO;
import com.example.swagger.dto.ChatMessageResponseDTO;
import com.example.swagger.service.ChatService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "채팅 API")
@RestController
@RequestMapping("/picto/api/chat")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @Operation(summary = "채팅 메시지 전송")
    @PostMapping
    public ChatMessageResponseDTO sendChatMessage(@RequestBody ChatMessageRequestDTO requestDTO) {
        return chatService.sendMessage(requestDTO);
    }

    @Operation(summary = "채팅 내역 조회")
    @GetMapping
    public List<ChatMessageResponseDTO> getChatHistory() {
        return chatService.getChatHistory();
    }
}