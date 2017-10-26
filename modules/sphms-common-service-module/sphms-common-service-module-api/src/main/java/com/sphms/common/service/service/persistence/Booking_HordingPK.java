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

package com.sphms.common.service.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class Booking_HordingPK implements Comparable<Booking_HordingPK>,
	Serializable {
	public long bookingId;
	public long hordingId;

	public Booking_HordingPK() {
	}

	public Booking_HordingPK(long bookingId, long hordingId) {
		this.bookingId = bookingId;
		this.hordingId = hordingId;
	}

	public long getBookingId() {
		return bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}

	public long getHordingId() {
		return hordingId;
	}

	public void setHordingId(long hordingId) {
		this.hordingId = hordingId;
	}

	@Override
	public int compareTo(Booking_HordingPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (bookingId < pk.bookingId) {
			value = -1;
		}
		else if (bookingId > pk.bookingId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (hordingId < pk.hordingId) {
			value = -1;
		}
		else if (hordingId > pk.hordingId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Booking_HordingPK)) {
			return false;
		}

		Booking_HordingPK pk = (Booking_HordingPK)obj;

		if ((bookingId == pk.bookingId) && (hordingId == pk.hordingId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, bookingId);
		hashCode = HashUtil.hash(hashCode, hordingId);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("bookingId");
		sb.append(StringPool.EQUAL);
		sb.append(bookingId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("hordingId");
		sb.append(StringPool.EQUAL);
		sb.append(hordingId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}