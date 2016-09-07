package com.accenture.kdc.batch.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.accenture.kdc.batch.domain.Statistics;

public class BoardRowMapper implements RowMapper<Statistics> {

	@Override
	public Statistics mapRow(ResultSet rs, int rowNum) throws SQLException {
		Statistics statistics = new Statistics();
		statistics.setStatisticsDate(rs.getString("statisticsDate"));
		statistics.setArticleCount(rs.getString("articleCount"));
		return statistics;
	}

}
