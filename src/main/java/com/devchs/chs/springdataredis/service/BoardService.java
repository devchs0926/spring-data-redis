package com.devchs.chs.springdataredis.service;

import com.devchs.chs.springdataredis.dto.BoardDto;
import com.devchs.chs.springdataredis.model.Board;
import com.devchs.chs.springdataredis.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    private final ModelMapper mapper;

    public BoardDto findBoard(String symbol) {
        Board board = findBySymbol(symbol);
        if (board == null) {
            board = save(symbol);
        }

        return mapper.map(board, BoardDto.class);
    }

    public Board findBySymbol(String symbol) {
        Optional<Board> optBoard = boardRepository.findBySymbol(symbol);
        return optBoard.isPresent() ? optBoard.get() : null;
    }

    public Board save(String symbol) {
        Board board = Board.builder().symbol(symbol).lastPrice(BigDecimal.ZERO).updateTime(getTimeStamp()).build();
        return boardRepository.save(board);
    }

    private Long getTimeStamp() {
        LocalDateTime now = LocalDateTime.now();
        return Timestamp.valueOf(now).getTime();
    }
}
