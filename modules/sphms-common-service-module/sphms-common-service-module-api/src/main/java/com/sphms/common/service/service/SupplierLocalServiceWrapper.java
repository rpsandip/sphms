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

package com.sphms.common.service.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SupplierLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SupplierLocalService
 * @generated
 */
@ProviderType
public class SupplierLocalServiceWrapper implements SupplierLocalService,
	ServiceWrapper<SupplierLocalService> {
	public SupplierLocalServiceWrapper(
		SupplierLocalService supplierLocalService) {
		_supplierLocalService = supplierLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _supplierLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _supplierLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _supplierLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _supplierLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _supplierLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the supplier to the database. Also notifies the appropriate model listeners.
	*
	* @param supplier the supplier
	* @return the supplier that was added
	*/
	@Override
	public com.sphms.common.service.model.Supplier addSupplier(
		com.sphms.common.service.model.Supplier supplier) {
		return _supplierLocalService.addSupplier(supplier);
	}

	@Override
	public com.sphms.common.service.model.Supplier addSupplier(
		java.lang.String supplierName, java.lang.String address1,
		java.lang.String address2, java.lang.String city,
		java.lang.String state, java.lang.String contactPersonName,
		java.lang.String contactPersonPhoneNo,
		java.lang.String contactPersonEmail, java.lang.String panNo,
		java.lang.String gstNo, long createdBy) {
		return _supplierLocalService.addSupplier(supplierName, address1,
			address2, city, state, contactPersonName, contactPersonPhoneNo,
			contactPersonEmail, panNo, gstNo, createdBy);
	}

	/**
	* Creates a new supplier with the primary key. Does not add the supplier to the database.
	*
	* @param supplierId the primary key for the new supplier
	* @return the new supplier
	*/
	@Override
	public com.sphms.common.service.model.Supplier createSupplier(
		long supplierId) {
		return _supplierLocalService.createSupplier(supplierId);
	}

	@Override
	public com.sphms.common.service.model.Supplier deleteClient(long supplierId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _supplierLocalService.deleteClient(supplierId);
	}

	/**
	* Deletes the supplier from the database. Also notifies the appropriate model listeners.
	*
	* @param supplier the supplier
	* @return the supplier that was removed
	*/
	@Override
	public com.sphms.common.service.model.Supplier deleteSupplier(
		com.sphms.common.service.model.Supplier supplier) {
		return _supplierLocalService.deleteSupplier(supplier);
	}

	/**
	* Deletes the supplier with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param supplierId the primary key of the supplier
	* @return the supplier that was removed
	* @throws PortalException if a supplier with the primary key could not be found
	*/
	@Override
	public com.sphms.common.service.model.Supplier deleteSupplier(
		long supplierId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _supplierLocalService.deleteSupplier(supplierId);
	}

	@Override
	public com.sphms.common.service.model.Supplier fetchSupplier(
		long supplierId) {
		return _supplierLocalService.fetchSupplier(supplierId);
	}

	/**
	* Returns the supplier with the primary key.
	*
	* @param supplierId the primary key of the supplier
	* @return the supplier
	* @throws PortalException if a supplier with the primary key could not be found
	*/
	@Override
	public com.sphms.common.service.model.Supplier getSupplier(long supplierId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _supplierLocalService.getSupplier(supplierId);
	}

	/**
	* Updates the supplier in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param supplier the supplier
	* @return the supplier that was updated
	*/
	@Override
	public com.sphms.common.service.model.Supplier updateSupplier(
		com.sphms.common.service.model.Supplier supplier) {
		return _supplierLocalService.updateSupplier(supplier);
	}

	@Override
	public com.sphms.common.service.model.Supplier updateSupplier(
		long supplierId, java.lang.String supplierName,
		java.lang.String address1, java.lang.String address2,
		java.lang.String city, java.lang.String state,
		java.lang.String contactPersonName,
		java.lang.String contactPersonPhoneNo,
		java.lang.String contactPersonEmail, java.lang.String panNo,
		java.lang.String gstNo, long createdBy)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _supplierLocalService.updateSupplier(supplierId, supplierName,
			address1, address2, city, state, contactPersonName,
			contactPersonPhoneNo, contactPersonEmail, panNo, gstNo, createdBy);
	}

	/**
	* Returns the number of suppliers.
	*
	* @return the number of suppliers
	*/
	@Override
	public int getSuppliersCount() {
		return _supplierLocalService.getSuppliersCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _supplierLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _supplierLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sphms.common.service.model.impl.SupplierModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _supplierLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sphms.common.service.model.impl.SupplierModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _supplierLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<com.sphms.common.service.model.Supplier> getSuppliers() {
		return _supplierLocalService.getSuppliers();
	}

	/**
	* Returns a range of all the suppliers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sphms.common.service.model.impl.SupplierModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of suppliers
	* @param end the upper bound of the range of suppliers (not inclusive)
	* @return the range of suppliers
	*/
	@Override
	public java.util.List<com.sphms.common.service.model.Supplier> getSuppliers(
		int start, int end) {
		return _supplierLocalService.getSuppliers(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _supplierLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _supplierLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public SupplierLocalService getWrappedService() {
		return _supplierLocalService;
	}

	@Override
	public void setWrappedService(SupplierLocalService supplierLocalService) {
		_supplierLocalService = supplierLocalService;
	}

	private SupplierLocalService _supplierLocalService;
}