package com.accenture.kdc.common.util;

import java.text.SimpleDateFormat;

import org.apache.log4j.Layout;
import org.apache.log4j.spi.LoggingEvent;

import com.accenture.kdc.board.vo.BoardBatchModel;
import com.google.gson.Gson;

public class CommXmlLayout extends Layout{
	private static SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	private final int DEFAULT_SIZE = 256;
	private final int UPPER_LIMIT = 2048;

	private StringBuffer buf = new StringBuffer(DEFAULT_SIZE);
	private boolean locationInfo = false;

	/**
	 * The <b>LocationInfo</b> option takes a boolean value. By default, it is
	 * set to false which means there will be no location information output by
	 * this layout. If the the option is set to true, then the file name and
	 * line number of the statement at the origin of the log statement will be
	 * output.
	 *
	 * <p>
	 * If you are embedding this layout within an
	 * {@link org.apache.log4j.net.SMTPAppender} then make sure to set the
	 * <b>LocationInfo</b> option of that appender as well.
	 * */
	public void setLocationInfo(boolean flag) {
		locationInfo = flag;
	}

	/**
	 * Returns the current value of the <b>LocationInfo</b> option.
	 */
	public boolean getLocationInfo() {
		return locationInfo;
	}

	/** No options to activate. */
	public void activateOptions() {
	}

	/**
	 * Formats a {@link LoggingEvent} in conformance with the log4j.dtd.
	 * */
	public String format(LoggingEvent event) {

		// Reset working buffer. If the buffer is too large, then we need a new
		// one in order to avoid the penalty of creating a large array.
		if (buf.capacity() > UPPER_LIMIT) {
			buf = new StringBuffer(DEFAULT_SIZE);
		} else {
			buf.setLength(0);
		}

		// We yield to the \r\n heresy.

		Gson gson = new Gson();
		BoardBatchModel boardBatchModel = gson.fromJson(event.getRenderedMessage(), BoardBatchModel.class); 
		buf.append("<board>\r\n");
		buf.append("<title>");
		buf.append(boardBatchModel.getTitle());
		buf.append("</title>\r\n");
		buf.append("<writer>");
		buf.append(boardBatchModel.getWriter());
		buf.append("</writer>\r\n");
		buf.append("<content>");
		buf.append(boardBatchModel.getContent());
		buf.append("</content>\r\n");
		buf.append("<password>");
		buf.append(boardBatchModel.getPassword());
		buf.append("</password>\r\n");
		buf.append("<regDate>");
		buf.append(dataFormat.format(event.getTimeStamp()));
		buf.append("</regDate>\r\n");
		buf.append("</board>\r\n\r\n");
		
		return buf.toString();
	}

	/**
	 * The XMLLayout prints and does not ignore exceptions. Hence the return
	 * value <code>false</code>.
	 */
	public boolean ignoresThrowable() {
		return false;
	}
}
