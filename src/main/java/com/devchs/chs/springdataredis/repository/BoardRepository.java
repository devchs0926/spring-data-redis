package com.devchs.chs.springdataredis.repository;

import com.devchs.chs.springdataredis.model.Board;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BoardRepository extends CrudRepository<Board, String> {
    Optional<Board> findBySymbol(String symbol);
}
