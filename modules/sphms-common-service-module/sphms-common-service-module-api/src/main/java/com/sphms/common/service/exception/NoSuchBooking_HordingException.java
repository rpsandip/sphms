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

package com.sphms.common.service.exception;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
@ProviderType
public class NoSuchBooking_HordingException extends NoSuchModelException {

	public NoSuchBooking_HordingException() {
	}

	public NoSuchBooking_HordingException(String msg) {
		super(msg);
	}

	public NoSuchBooking_HordingException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchBooking_HordingException(Throwable cause) {
		super(cause);
	}

}