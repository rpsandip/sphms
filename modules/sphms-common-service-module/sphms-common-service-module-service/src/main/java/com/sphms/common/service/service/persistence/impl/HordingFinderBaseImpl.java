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

package com.sphms.common.service.service.persistence.impl;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;

import com.sphms.common.service.model.Hording;
import com.sphms.common.service.service.persistence.HordingPersistence;

import java.util.Set;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class HordingFinderBaseImpl extends BasePersistenceImpl<Hording> {
	@Override
	public Set<String> getBadColumnNames() {
		return getHordingPersistence().getBadColumnNames();
	}

	/**
	 * Returns the hording persistence.
	 *
	 * @return the hording persistence
	 */
	public HordingPersistence getHordingPersistence() {
		return hordingPersistence;
	}

	/**
	 * Sets the hording persistence.
	 *
	 * @param hordingPersistence the hording persistence
	 */
	public void setHordingPersistence(HordingPersistence hordingPersistence) {
		this.hordingPersistence = hordingPersistence;
	}

	@BeanReference(type = HordingPersistence.class)
	protected HordingPersistence hordingPersistence;
}