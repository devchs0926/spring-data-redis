package com.devchs.chs.springdataredis.controller;

import com.devchs.chs.springdataredis.dto.BoardDto;
import com.devchs.chs.springdataredis.service.BoardService;
import com.devchs.chs.springdataredis.service.KeywordService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/home")
@RequiredArgsConstructor
@RestController
public class HomeController {

    private final BoardService boardService;
    private final KeywordService keywordService;

    @GetMapping("/search")
    public void addKeyword(@RequestParam String keyword) {
        keywordService.setCount(keyword);
    }

    @GetMapping("/keyword/rank")
    public List<String> getKeywordRank() {
        return keywordService.findKeywordRank();
    }

    @GetMapping
    public BoardDto getBoard(@RequestParam String symbol) {
        return boardService.findBoard(symbol);
    }
}
