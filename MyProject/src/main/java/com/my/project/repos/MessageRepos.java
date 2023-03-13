package com.my.project.repos;

import com.my.project.domains.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;


import java.util.List;

public interface MessageRepos extends CrudRepository<Message, Long> {
    List<Message> findByTag(String tag);
}
