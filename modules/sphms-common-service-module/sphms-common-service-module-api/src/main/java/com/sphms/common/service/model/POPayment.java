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

package com.sphms.common.service.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the POPayment service. Represents a row in the &quot;SPHMS_POPayment&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see POPaymentModel
 * @see com.sphms.common.service.model.impl.POPaymentImpl
 * @see com.sphms.common.service.model.impl.POPaymentModelImpl
 * @generated
 */
@ImplementationClassName("com.sphms.common.service.model.impl.POPaymentImpl")
@ProviderType
public interface POPayment extends POPaymentModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.sphms.common.service.model.impl.POPaymentImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<POPayment, Long> PO_PAYMENT_ID_ACCESSOR = new Accessor<POPayment, Long>() {
			@Override
			public Long get(POPayment poPayment) {
				return poPayment.getPoPaymentId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<POPayment> getTypeClass() {
				return POPayment.class;
			}
		};
}