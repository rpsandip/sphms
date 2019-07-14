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
public class SupplierBillPK implements Comparable<SupplierBillPK>, Serializable {
	public long supplierBillId;
	public long companyId;

	public SupplierBillPK() {
	}

	public SupplierBillPK(long supplierBillId, long companyId) {
		this.supplierBillId = supplierBillId;
		this.companyId = companyId;
	}

	public long getSupplierBillId() {
		return supplierBillId;
	}

	public void setSupplierBillId(long supplierBillId) {
		this.supplierBillId = supplierBillId;
	}

	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

	@Override
	public int compareTo(SupplierBillPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (supplierBillId < pk.supplierBillId) {
			value = -1;
		}
		else if (supplierBillId > pk.supplierBillId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (companyId < pk.companyId) {
			value = -1;
		}
		else if (companyId > pk.companyId) {
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

		if (!(obj instanceof SupplierBillPK)) {
			return false;
		}

		SupplierBillPK pk = (SupplierBillPK)obj;

		if ((supplierBillId == pk.supplierBillId) &&
				(companyId == pk.companyId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, supplierBillId);
		hashCode = HashUtil.hash(hashCode, companyId);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("supplierBillId");
		sb.append(StringPool.EQUAL);
		sb.append(supplierBillId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("companyId");
		sb.append(StringPool.EQUAL);
		sb.append(companyId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}