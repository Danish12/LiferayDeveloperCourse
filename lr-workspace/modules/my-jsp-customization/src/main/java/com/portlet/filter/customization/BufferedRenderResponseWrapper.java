package com.portlet.filter.customization;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.portlet.RenderResponse;
import javax.portlet.filter.RenderResponseWrapper;

public class BufferedRenderResponseWrapper extends RenderResponseWrapper {

	public BufferedRenderResponseWrapper(RenderResponse response) {
		super(response);
		charWriter = new CharArrayWriter();
	}

	public OutputStream getOutputStream() throws IOException {
		if (getWriterCalled) {
			throw new IllegalStateException("getWriter already called");
		}

		getOutputStreamCalled = true;

		return super.getPortletOutputStream();
	}

	/*
	 * method lets you write data to the response before it�s sent back to the
	 * client.
	 * 
	 * (non-Javadoc)
	 * 
	 * @see javax.portlet.filter.MimeResponseWrapper#getWriter()
	 */
	public PrintWriter getWriter() throws IOException {
		if (writer != null) {
			return writer;
		}

		if (getOutputStreamCalled) {
			throw new IllegalStateException("getOutputStream already called");
		}

		getWriterCalled = true;

		writer = new PrintWriter(charWriter);

		return writer;
	}

	/*
	 * method returns the current response text (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String s = null;

		if (writer != null) {
			s = charWriter.toString();
		}

		return s;
	}

	protected CharArrayWriter charWriter;
	protected PrintWriter writer;
	protected boolean getOutputStreamCalled;
	protected boolean getWriterCalled;
}
