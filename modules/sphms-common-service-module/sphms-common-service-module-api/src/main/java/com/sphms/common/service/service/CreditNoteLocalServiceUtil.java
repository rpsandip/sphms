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

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for CreditNote. This utility wraps
 * {@link com.sphms.common.service.service.impl.CreditNoteLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see CreditNoteLocalService
 * @see com.sphms.common.service.service.base.CreditNoteLocalServiceBaseImpl
 * @see com.sphms.common.service.service.impl.CreditNoteLocalServiceImpl
 * @generated
 */
@ProviderType
public class CreditNoteLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sphms.common.service.service.impl.CreditNoteLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the credit note to the database. Also notifies the appropriate model listeners.
	*
	* @param creditNote the credit note
	* @return the credit note that was added
	*/
	public static com.sphms.common.service.model.CreditNote addCreditNote(
		com.sphms.common.service.model.CreditNote creditNote) {
		return getService().addCreditNote(creditNote);
	}

	public static com.sphms.common.service.model.CreditNote addCreditNote(
		long clientId, long billingId, double creditNoteAmount,
		double creditNoteTax, java.lang.String chequeNo,
		java.lang.String bankName, java.util.Date paymentDate, long createdBy) {
		return getService()
				   .addCreditNote(clientId, billingId, creditNoteAmount,
			creditNoteTax, chequeNo, bankName, paymentDate, createdBy);
	}

	/**
	* Creates a new credit note with the primary key. Does not add the credit note to the database.
	*
	* @param creditNoteId the primary key for the new credit note
	* @return the new credit note
	*/
	public static com.sphms.common.service.model.CreditNote createCreditNote(
		long creditNoteId) {
		return getService().createCreditNote(creditNoteId);
	}

	/**
	* Deletes the credit note from the database. Also notifies the appropriate model listeners.
	*
	* @param creditNote the credit note
	* @return the credit note that was removed
	*/
	public static com.sphms.common.service.model.CreditNote deleteCreditNote(
		com.sphms.common.service.model.CreditNote creditNote) {
		return getService().deleteCreditNote(creditNote);
	}

	/**
	* Deletes the credit note with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param creditNoteId the primary key of the credit note
	* @return the credit note that was removed
	* @throws PortalException if a credit note with the primary key could not be found
	*/
	public static com.sphms.common.service.model.CreditNote deleteCreditNote(
		long creditNoteId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteCreditNote(creditNoteId);
	}

	public static com.sphms.common.service.model.CreditNote fetchCreditNote(
		long creditNoteId) {
		return getService().fetchCreditNote(creditNoteId);
	}

	/**
	* Returns the credit note with the primary key.
	*
	* @param creditNoteId the primary key of the credit note
	* @return the credit note
	* @throws PortalException if a credit note with the primary key could not be found
	*/
	public static com.sphms.common.service.model.CreditNote getCreditNote(
		long creditNoteId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getCreditNote(creditNoteId);
	}

	/**
	* Updates the credit note in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param creditNote the credit note
	* @return the credit note that was updated
	*/
	public static com.sphms.common.service.model.CreditNote updateCreditNote(
		com.sphms.common.service.model.CreditNote creditNote) {
		return getService().updateCreditNote(creditNote);
	}

	public static com.sphms.common.service.model.CreditNote updateCreditNote(
		long creditNoteId, long billingId, double creditNoteAmount,
		double creditNoteTax, java.lang.String chequeNo,
		java.lang.String bankName, java.util.Date paymentDate, long modifiedBy)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .updateCreditNote(creditNoteId, billingId, creditNoteAmount,
			creditNoteTax, chequeNo, bankName, paymentDate, modifiedBy);
	}

	/**
	* Returns the number of credit notes.
	*
	* @return the number of credit notes
	*/
	public static int getCreditNotesCount() {
		return getService().getCreditNotesCount();
	}

	public static java.lang.String getNextCreditNoteNumber() {
		return getService().getNextCreditNoteNumber();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sphms.common.service.model.impl.CreditNoteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sphms.common.service.model.impl.CreditNoteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	public static java.util.List<com.sphms.common.service.model.CreditNote> getClientCreditNoteList(
		long clientId) {
		return getService().getClientCreditNoteList(clientId);
	}

	/**
	* Returns a range of all the credit notes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sphms.common.service.model.impl.CreditNoteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of credit notes
	* @param end the upper bound of the range of credit notes (not inclusive)
	* @return the range of credit notes
	*/
	public static java.util.List<com.sphms.common.service.model.CreditNote> getCreditNotes(
		int start, int end) {
		return getService().getCreditNotes(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static CreditNoteLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CreditNoteLocalService, CreditNoteLocalService> _serviceTracker =
		ServiceTrackerFactory.open(CreditNoteLocalService.class);
}