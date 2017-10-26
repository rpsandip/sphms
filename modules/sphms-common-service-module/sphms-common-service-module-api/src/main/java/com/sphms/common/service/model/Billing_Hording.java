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
 * The extended model interface for the Billing_Hording service. Represents a row in the &quot;SPHMS_Billing_Hording&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see Billing_HordingModel
 * @see com.sphms.common.service.model.impl.Billing_HordingImpl
 * @see com.sphms.common.service.model.impl.Billing_HordingModelImpl
 * @generated
 */
@ImplementationClassName("com.sphms.common.service.model.impl.Billing_HordingImpl")
@ProviderType
public interface Billing_Hording extends Billing_HordingModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.sphms.common.service.model.impl.Billing_HordingImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Billing_Hording, Long> BILLING_ID_ACCESSOR = new Accessor<Billing_Hording, Long>() {
			@Override
			public Long get(Billing_Hording billing_Hording) {
				return billing_Hording.getBillingId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Billing_Hording> getTypeClass() {
				return Billing_Hording.class;
			}
		};

	public static final Accessor<Billing_Hording, Long> HORDING_ID_ACCESSOR = new Accessor<Billing_Hording, Long>() {
			@Override
			public Long get(Billing_Hording billing_Hording) {
				return billing_Hording.getHordingId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Billing_Hording> getTypeClass() {
				return Billing_Hording.class;
			}
		};
}