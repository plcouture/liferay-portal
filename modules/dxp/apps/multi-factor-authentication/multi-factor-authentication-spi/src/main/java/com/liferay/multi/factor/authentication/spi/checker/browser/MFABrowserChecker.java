/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.multi.factor.authentication.spi.checker.browser;

import com.liferay.multi.factor.authentication.spi.checker.MFAChecker;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Tomas Polesovsky
 * @author Marta Medio
 */
public interface MFABrowserChecker extends MFAChecker {

	public void includeBrowserVerification(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, long userId)
		throws Exception;

	public boolean isBrowserVerified(
		HttpServletRequest httpServletRequest, long userId);

	public boolean verifyBrowserRequest(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, long userId)
		throws Exception;

}