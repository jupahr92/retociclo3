package com.jph.servimed.service;

import com.jph.servimed.model.Message;
import com.jph.servimed.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll(){
        return messageRepository.getAll();
    }

    public Optional<Message> getMessage(int messageId) {
        return messageRepository.getMessage(messageId);
    }

    public Message save(Message message){
        if(message.getIdMessage()==null){
            return messageRepository.save(message);
        }else{
            Optional<Message> m= messageRepository.getMessage(message.getIdMessage());
            if(m.isEmpty()){
                return messageRepository.save(message);
            }else{
                return message;
            }
        }
    }

    public Message update(Message message){
        if(message.getIdMessage()!=null){
            Optional<Message> m= messageRepository.getMessage(message.getIdMessage());
            if(!m.isEmpty()){
                if(message.getMessageText()!=null){
                    m.get().setMessageText(message.getMessageText());
                }
                messageRepository.save(m.get());
                return m.get();
            }else{
                return message;
            }
        }else{
            return message;
        }
    }

    public boolean deleteMessage(int messageId) {
        Boolean aB = getMessage(messageId).map(message -> {
            messageRepository.delete(message);
            return true;
        }).orElse(false);
        return aB;
    }
}
