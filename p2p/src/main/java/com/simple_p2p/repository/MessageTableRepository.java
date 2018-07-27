package com.simple_p2p.repository;

import com.simple_p2p.entity.MessageTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface MessageTableRepository extends JpaRepository<MessageTable, Integer> {

}
