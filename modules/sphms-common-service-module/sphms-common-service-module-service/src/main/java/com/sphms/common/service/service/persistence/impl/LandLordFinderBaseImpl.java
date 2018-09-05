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

import com.sphms.common.service.model.LandLord;
import com.sphms.common.service.service.persistence.LandLordPersistence;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LandLordFinderBaseImpl extends BasePersistenceImpl<LandLord> {
	/**
	 * Returns the land lord persistence.
	 *
	 * @return the land lord persistence
	 */
	public LandLordPersistence getLandLordPersistence() {
		return landLordPersistence;
	}

	/**
	 * Sets the land lord persistence.
	 *
	 * @param landLordPersistence the land lord persistence
	 */
	public void setLandLordPersistence(LandLordPersistence landLordPersistence) {
		this.landLordPersistence = landLordPersistence;
	}

	@BeanReference(type = LandLordPersistence.class)
	protected LandLordPersistence landLordPersistence;
}