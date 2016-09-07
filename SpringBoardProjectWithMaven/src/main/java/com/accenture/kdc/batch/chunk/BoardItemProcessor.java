package com.accenture.kdc.batch.chunk;

import org.springframework.batch.item.ItemProcessor;

import com.accenture.kdc.board.vo.BoardBatchModel;

public class BoardItemProcessor implements ItemProcessor<BoardBatchModel, BoardBatchModel> {
	 
    public BoardBatchModel process(BoardBatchModel boardBatchModel) throws Exception {
 
        return boardBatchModel;
    }
}