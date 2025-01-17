<%--
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
--%>

<%@ include file="/init.jsp" %>

<%
List<Organization> organizations = (List<Organization>)request.getAttribute("user.organizations");

String className = (String)request.getAttribute("addresses.className");
long classPK = (Long)request.getAttribute("addresses.classPK");

List<Address> personalAddresses = Collections.emptyList();
List<Address> organizationAddresses = new ArrayList<Address>();

if (classPK > 0) {
	personalAddresses = AddressServiceUtil.getAddresses(className, classPK);
}

for (int i = 0; i < organizations.size(); i++) {
	try {
		organizationAddresses.addAll(AddressServiceUtil.getAddresses(Organization.class.getName(), organizations.get(i).getOrganizationId()));
	}
	catch (Exception e) {
	}
}
%>

<c:if test="<%= !personalAddresses.isEmpty() || !organizationAddresses.isEmpty() %>">
	<h3 class="icon-home"><liferay-ui:message key="address" /></h3>

	<c:if test="<%= !organizationAddresses.isEmpty() %>">
		<div>
			<h4><liferay-ui:message key="organization-address" /></h4>

			<ul class="property-list">

				<%
				for (Address address : organizationAddresses) {
				%>

					<li class='<%= address.isPrimary() ? "icon-star" : StringPool.BLANK %>'>
						<%@ include file="/common/addresses_address.jspf" %>
					</li>

				<%
				}
				%>

			</ul>
		</div>
	</c:if>

	<c:if test="<%= !personalAddresses.isEmpty() %>">
		<div>
			<h4><liferay-ui:message key="personal-address" /></h4>

			<ul class="property-list">

				<%
				for (Address address : personalAddresses) {
				%>

					<li class='<%= (address.isPrimary() && !personalAddresses.isEmpty()) ? "icon-star" : StringPool.BLANK %>'>
						<%@ include file="/common/addresses_address.jspf" %>
					</li>

				<%
				}
				%>

			</ul>
		</div>
	</c:if>
</c:if>