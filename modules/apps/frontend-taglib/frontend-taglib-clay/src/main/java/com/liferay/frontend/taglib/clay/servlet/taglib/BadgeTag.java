/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.frontend.taglib.clay.servlet.taglib;

import com.liferay.frontend.taglib.clay.internal.servlet.taglib.BaseContainerTag;

import java.util.Set;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

/**
 * @author Chema Balsas
 */
public class BadgeTag extends BaseContainerTag {

	@Override
	public int doStartTag() throws JspException {
		setAttributeNamespace(_ATTRIBUTE_NAMESPACE);

		if (getContainerElement() == null) {
			setContainerElement("span");
		}

		return super.doStartTag();
	}

	public String getDisplayType() {
		return _displayType;
	}

	public String getLabel(String label) {
		return _label;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getDisplayType()}
	 */
	@Deprecated
	public String getStyle() {
		return getDisplayType();
	}

	public void setDisplayType(String displayType) {
		_displayType = displayType;
	}

	public void setLabel(String label) {
		_label = label;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #setDisplayType(String)}
	 */
	@Deprecated
	public void setStyle(String style) {
		setDisplayType(style);
	}

	@Override
	protected void cleanUp() {
		super.cleanUp();

		_displayType = "primary";
		_label = null;
		_style = null;
	}

	@Override
	protected String getEndPage() {
		return _END_PAGE;
	}

	@Override
	protected String getStartPage() {
		return _START_PAGE;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #processCssClasses(String)}
	 */
	@Deprecated
	@Override
	protected String processClassName(Set<String> className) {
		return processCssClasses(className);
	}

	@Override
	protected String processCssClasses(Set<String> cssClasses) {
		cssClasses.add("badge");
		cssClasses.add("badge-" + _displayType);

		return super.processCssClasses(cssClasses);
	}

	@Override
	protected int processStartTag() throws Exception {
		super.processStartTag();

		JspWriter jspWriter = pageContext.getOut();

		jspWriter.write("<span");
		jspWriter.write(" class=\"badge-item badge-item-expand");
		jspWriter.write("\">");
		jspWriter.write(_label);
		jspWriter.write("</span>");

		return SKIP_BODY;
	}

	private static final String _ATTRIBUTE_NAMESPACE = "clay:badge:";

	private static final String _END_PAGE = "/badge/end.jsp";

	private static final String _START_PAGE = "/badge/start.jsp";

	private String _displayType = "primary";
	private String _label;
	private String _style;

}