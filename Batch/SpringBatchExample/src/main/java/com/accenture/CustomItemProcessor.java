package com.accenture;

import org.springframework.batch.item.ItemProcessor;

import com.accenture.model.ResultModel;

public class CustomItemProcessor implements ItemProcessor<ResultModel, ResultModel> {

	@Override
	public ResultModel process(ResultModel item) throws Exception {
		/*
		 * ItemProcessor : modify, filter, validate ������ �����Ѵ�.
		 */
		System.out.println("Processing..." + item);
		return item;
	}

}