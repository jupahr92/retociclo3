package com.jph.servimed.repository.crudRepository;

import com.jph.servimed.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message,Integer> {
}
