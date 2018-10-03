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

package com.sphms.common.service.service.base;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalServiceRegistry;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.sphms.common.service.model.Payment;
import com.sphms.common.service.service.PaymentLocalService;
import com.sphms.common.service.service.persistence.BillingPersistence;
import com.sphms.common.service.service.persistence.Billing_HordingPersistence;
import com.sphms.common.service.service.persistence.Billing_POPersistence;
import com.sphms.common.service.service.persistence.BookingPersistence;
import com.sphms.common.service.service.persistence.Booking_HordingPersistence;
import com.sphms.common.service.service.persistence.ClientPersistence;
import com.sphms.common.service.service.persistence.CreditNotePersistence;
import com.sphms.common.service.service.persistence.CustomCompanyPersistence;
import com.sphms.common.service.service.persistence.ExpensePersistence;
import com.sphms.common.service.service.persistence.HordingFinder;
import com.sphms.common.service.service.persistence.HordingPersistence;
import com.sphms.common.service.service.persistence.LandLordFinder;
import com.sphms.common.service.service.persistence.LandLordPaymentPersistence;
import com.sphms.common.service.service.persistence.LandLordPersistence;
import com.sphms.common.service.service.persistence.PaymentPersistence;
import com.sphms.common.service.service.persistence.ProposalPersistence;
import com.sphms.common.service.service.persistence.Proposal_HordingPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the payment local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.sphms.common.service.service.impl.PaymentLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.sphms.common.service.service.impl.PaymentLocalServiceImpl
 * @see com.sphms.common.service.service.PaymentLocalServiceUtil
 * @generated
 */
@ProviderType
public abstract class PaymentLocalServiceBaseImpl extends BaseLocalServiceImpl
	implements PaymentLocalService, IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.sphms.common.service.service.PaymentLocalServiceUtil} to access the payment local service.
	 */

	/**
	 * Adds the payment to the database. Also notifies the appropriate model listeners.
	 *
	 * @param payment the payment
	 * @return the payment that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Payment addPayment(Payment payment) {
		payment.setNew(true);

		return paymentPersistence.update(payment);
	}

	/**
	 * Creates a new payment with the primary key. Does not add the payment to the database.
	 *
	 * @param paymentId the primary key for the new payment
	 * @return the new payment
	 */
	@Override
	public Payment createPayment(long paymentId) {
		return paymentPersistence.create(paymentId);
	}

	/**
	 * Deletes the payment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param paymentId the primary key of the payment
	 * @return the payment that was removed
	 * @throws PortalException if a payment with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Payment deletePayment(long paymentId) throws PortalException {
		return paymentPersistence.remove(paymentId);
	}

	/**
	 * Deletes the payment from the database. Also notifies the appropriate model listeners.
	 *
	 * @param payment the payment
	 * @return the payment that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Payment deletePayment(Payment payment) {
		return paymentPersistence.remove(payment);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(Payment.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return paymentPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sphms.common.service.model.impl.PaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end) {
		return paymentPersistence.findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sphms.common.service.model.impl.PaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator) {
		return paymentPersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return paymentPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) {
		return paymentPersistence.countWithDynamicQuery(dynamicQuery, projection);
	}

	@Override
	public Payment fetchPayment(long paymentId) {
		return paymentPersistence.fetchByPrimaryKey(paymentId);
	}

	/**
	 * Returns the payment with the primary key.
	 *
	 * @param paymentId the primary key of the payment
	 * @return the payment
	 * @throws PortalException if a payment with the primary key could not be found
	 */
	@Override
	public Payment getPayment(long paymentId) throws PortalException {
		return paymentPersistence.findByPrimaryKey(paymentId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery = new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(paymentLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Payment.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("paymentId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery = new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(paymentLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(Payment.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("paymentId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {
		actionableDynamicQuery.setBaseLocalService(paymentLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Payment.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("paymentId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return paymentLocalService.deletePayment((Payment)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return paymentPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the payments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sphms.common.service.model.impl.PaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of payments
	 * @param end the upper bound of the range of payments (not inclusive)
	 * @return the range of payments
	 */
	@Override
	public List<Payment> getPayments(int start, int end) {
		return paymentPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of payments.
	 *
	 * @return the number of payments
	 */
	@Override
	public int getPaymentsCount() {
		return paymentPersistence.countAll();
	}

	/**
	 * Updates the payment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param payment the payment
	 * @return the payment that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Payment updatePayment(Payment payment) {
		return paymentPersistence.update(payment);
	}

	/**
	 * Returns the billing local service.
	 *
	 * @return the billing local service
	 */
	public com.sphms.common.service.service.BillingLocalService getBillingLocalService() {
		return billingLocalService;
	}

	/**
	 * Sets the billing local service.
	 *
	 * @param billingLocalService the billing local service
	 */
	public void setBillingLocalService(
		com.sphms.common.service.service.BillingLocalService billingLocalService) {
		this.billingLocalService = billingLocalService;
	}

	/**
	 * Returns the billing persistence.
	 *
	 * @return the billing persistence
	 */
	public BillingPersistence getBillingPersistence() {
		return billingPersistence;
	}

	/**
	 * Sets the billing persistence.
	 *
	 * @param billingPersistence the billing persistence
	 */
	public void setBillingPersistence(BillingPersistence billingPersistence) {
		this.billingPersistence = billingPersistence;
	}

	/**
	 * Returns the billing_ hording local service.
	 *
	 * @return the billing_ hording local service
	 */
	public com.sphms.common.service.service.Billing_HordingLocalService getBilling_HordingLocalService() {
		return billing_HordingLocalService;
	}

	/**
	 * Sets the billing_ hording local service.
	 *
	 * @param billing_HordingLocalService the billing_ hording local service
	 */
	public void setBilling_HordingLocalService(
		com.sphms.common.service.service.Billing_HordingLocalService billing_HordingLocalService) {
		this.billing_HordingLocalService = billing_HordingLocalService;
	}

	/**
	 * Returns the billing_ hording persistence.
	 *
	 * @return the billing_ hording persistence
	 */
	public Billing_HordingPersistence getBilling_HordingPersistence() {
		return billing_HordingPersistence;
	}

	/**
	 * Sets the billing_ hording persistence.
	 *
	 * @param billing_HordingPersistence the billing_ hording persistence
	 */
	public void setBilling_HordingPersistence(
		Billing_HordingPersistence billing_HordingPersistence) {
		this.billing_HordingPersistence = billing_HordingPersistence;
	}

	/**
	 * Returns the billing_ p o local service.
	 *
	 * @return the billing_ p o local service
	 */
	public com.sphms.common.service.service.Billing_POLocalService getBilling_POLocalService() {
		return billing_POLocalService;
	}

	/**
	 * Sets the billing_ p o local service.
	 *
	 * @param billing_POLocalService the billing_ p o local service
	 */
	public void setBilling_POLocalService(
		com.sphms.common.service.service.Billing_POLocalService billing_POLocalService) {
		this.billing_POLocalService = billing_POLocalService;
	}

	/**
	 * Returns the billing_ p o persistence.
	 *
	 * @return the billing_ p o persistence
	 */
	public Billing_POPersistence getBilling_POPersistence() {
		return billing_POPersistence;
	}

	/**
	 * Sets the billing_ p o persistence.
	 *
	 * @param billing_POPersistence the billing_ p o persistence
	 */
	public void setBilling_POPersistence(
		Billing_POPersistence billing_POPersistence) {
		this.billing_POPersistence = billing_POPersistence;
	}

	/**
	 * Returns the booking local service.
	 *
	 * @return the booking local service
	 */
	public com.sphms.common.service.service.BookingLocalService getBookingLocalService() {
		return bookingLocalService;
	}

	/**
	 * Sets the booking local service.
	 *
	 * @param bookingLocalService the booking local service
	 */
	public void setBookingLocalService(
		com.sphms.common.service.service.BookingLocalService bookingLocalService) {
		this.bookingLocalService = bookingLocalService;
	}

	/**
	 * Returns the booking persistence.
	 *
	 * @return the booking persistence
	 */
	public BookingPersistence getBookingPersistence() {
		return bookingPersistence;
	}

	/**
	 * Sets the booking persistence.
	 *
	 * @param bookingPersistence the booking persistence
	 */
	public void setBookingPersistence(BookingPersistence bookingPersistence) {
		this.bookingPersistence = bookingPersistence;
	}

	/**
	 * Returns the booking_ hording local service.
	 *
	 * @return the booking_ hording local service
	 */
	public com.sphms.common.service.service.Booking_HordingLocalService getBooking_HordingLocalService() {
		return booking_HordingLocalService;
	}

	/**
	 * Sets the booking_ hording local service.
	 *
	 * @param booking_HordingLocalService the booking_ hording local service
	 */
	public void setBooking_HordingLocalService(
		com.sphms.common.service.service.Booking_HordingLocalService booking_HordingLocalService) {
		this.booking_HordingLocalService = booking_HordingLocalService;
	}

	/**
	 * Returns the booking_ hording persistence.
	 *
	 * @return the booking_ hording persistence
	 */
	public Booking_HordingPersistence getBooking_HordingPersistence() {
		return booking_HordingPersistence;
	}

	/**
	 * Sets the booking_ hording persistence.
	 *
	 * @param booking_HordingPersistence the booking_ hording persistence
	 */
	public void setBooking_HordingPersistence(
		Booking_HordingPersistence booking_HordingPersistence) {
		this.booking_HordingPersistence = booking_HordingPersistence;
	}

	/**
	 * Returns the client local service.
	 *
	 * @return the client local service
	 */
	public com.sphms.common.service.service.ClientLocalService getClientLocalService() {
		return clientLocalService;
	}

	/**
	 * Sets the client local service.
	 *
	 * @param clientLocalService the client local service
	 */
	public void setClientLocalService(
		com.sphms.common.service.service.ClientLocalService clientLocalService) {
		this.clientLocalService = clientLocalService;
	}

	/**
	 * Returns the client persistence.
	 *
	 * @return the client persistence
	 */
	public ClientPersistence getClientPersistence() {
		return clientPersistence;
	}

	/**
	 * Sets the client persistence.
	 *
	 * @param clientPersistence the client persistence
	 */
	public void setClientPersistence(ClientPersistence clientPersistence) {
		this.clientPersistence = clientPersistence;
	}

	/**
	 * Returns the credit note local service.
	 *
	 * @return the credit note local service
	 */
	public com.sphms.common.service.service.CreditNoteLocalService getCreditNoteLocalService() {
		return creditNoteLocalService;
	}

	/**
	 * Sets the credit note local service.
	 *
	 * @param creditNoteLocalService the credit note local service
	 */
	public void setCreditNoteLocalService(
		com.sphms.common.service.service.CreditNoteLocalService creditNoteLocalService) {
		this.creditNoteLocalService = creditNoteLocalService;
	}

	/**
	 * Returns the credit note persistence.
	 *
	 * @return the credit note persistence
	 */
	public CreditNotePersistence getCreditNotePersistence() {
		return creditNotePersistence;
	}

	/**
	 * Sets the credit note persistence.
	 *
	 * @param creditNotePersistence the credit note persistence
	 */
	public void setCreditNotePersistence(
		CreditNotePersistence creditNotePersistence) {
		this.creditNotePersistence = creditNotePersistence;
	}

	/**
	 * Returns the custom company local service.
	 *
	 * @return the custom company local service
	 */
	public com.sphms.common.service.service.CustomCompanyLocalService getCustomCompanyLocalService() {
		return customCompanyLocalService;
	}

	/**
	 * Sets the custom company local service.
	 *
	 * @param customCompanyLocalService the custom company local service
	 */
	public void setCustomCompanyLocalService(
		com.sphms.common.service.service.CustomCompanyLocalService customCompanyLocalService) {
		this.customCompanyLocalService = customCompanyLocalService;
	}

	/**
	 * Returns the custom company persistence.
	 *
	 * @return the custom company persistence
	 */
	public CustomCompanyPersistence getCustomCompanyPersistence() {
		return customCompanyPersistence;
	}

	/**
	 * Sets the custom company persistence.
	 *
	 * @param customCompanyPersistence the custom company persistence
	 */
	public void setCustomCompanyPersistence(
		CustomCompanyPersistence customCompanyPersistence) {
		this.customCompanyPersistence = customCompanyPersistence;
	}

	/**
	 * Returns the expense local service.
	 *
	 * @return the expense local service
	 */
	public com.sphms.common.service.service.ExpenseLocalService getExpenseLocalService() {
		return expenseLocalService;
	}

	/**
	 * Sets the expense local service.
	 *
	 * @param expenseLocalService the expense local service
	 */
	public void setExpenseLocalService(
		com.sphms.common.service.service.ExpenseLocalService expenseLocalService) {
		this.expenseLocalService = expenseLocalService;
	}

	/**
	 * Returns the expense persistence.
	 *
	 * @return the expense persistence
	 */
	public ExpensePersistence getExpensePersistence() {
		return expensePersistence;
	}

	/**
	 * Sets the expense persistence.
	 *
	 * @param expensePersistence the expense persistence
	 */
	public void setExpensePersistence(ExpensePersistence expensePersistence) {
		this.expensePersistence = expensePersistence;
	}

	/**
	 * Returns the hording local service.
	 *
	 * @return the hording local service
	 */
	public com.sphms.common.service.service.HordingLocalService getHordingLocalService() {
		return hordingLocalService;
	}

	/**
	 * Sets the hording local service.
	 *
	 * @param hordingLocalService the hording local service
	 */
	public void setHordingLocalService(
		com.sphms.common.service.service.HordingLocalService hordingLocalService) {
		this.hordingLocalService = hordingLocalService;
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

	/**
	 * Returns the hording finder.
	 *
	 * @return the hording finder
	 */
	public HordingFinder getHordingFinder() {
		return hordingFinder;
	}

	/**
	 * Sets the hording finder.
	 *
	 * @param hordingFinder the hording finder
	 */
	public void setHordingFinder(HordingFinder hordingFinder) {
		this.hordingFinder = hordingFinder;
	}

	/**
	 * Returns the land lord local service.
	 *
	 * @return the land lord local service
	 */
	public com.sphms.common.service.service.LandLordLocalService getLandLordLocalService() {
		return landLordLocalService;
	}

	/**
	 * Sets the land lord local service.
	 *
	 * @param landLordLocalService the land lord local service
	 */
	public void setLandLordLocalService(
		com.sphms.common.service.service.LandLordLocalService landLordLocalService) {
		this.landLordLocalService = landLordLocalService;
	}

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

	/**
	 * Returns the land lord finder.
	 *
	 * @return the land lord finder
	 */
	public LandLordFinder getLandLordFinder() {
		return landLordFinder;
	}

	/**
	 * Sets the land lord finder.
	 *
	 * @param landLordFinder the land lord finder
	 */
	public void setLandLordFinder(LandLordFinder landLordFinder) {
		this.landLordFinder = landLordFinder;
	}

	/**
	 * Returns the land lord payment local service.
	 *
	 * @return the land lord payment local service
	 */
	public com.sphms.common.service.service.LandLordPaymentLocalService getLandLordPaymentLocalService() {
		return landLordPaymentLocalService;
	}

	/**
	 * Sets the land lord payment local service.
	 *
	 * @param landLordPaymentLocalService the land lord payment local service
	 */
	public void setLandLordPaymentLocalService(
		com.sphms.common.service.service.LandLordPaymentLocalService landLordPaymentLocalService) {
		this.landLordPaymentLocalService = landLordPaymentLocalService;
	}

	/**
	 * Returns the land lord payment persistence.
	 *
	 * @return the land lord payment persistence
	 */
	public LandLordPaymentPersistence getLandLordPaymentPersistence() {
		return landLordPaymentPersistence;
	}

	/**
	 * Sets the land lord payment persistence.
	 *
	 * @param landLordPaymentPersistence the land lord payment persistence
	 */
	public void setLandLordPaymentPersistence(
		LandLordPaymentPersistence landLordPaymentPersistence) {
		this.landLordPaymentPersistence = landLordPaymentPersistence;
	}

	/**
	 * Returns the payment local service.
	 *
	 * @return the payment local service
	 */
	public PaymentLocalService getPaymentLocalService() {
		return paymentLocalService;
	}

	/**
	 * Sets the payment local service.
	 *
	 * @param paymentLocalService the payment local service
	 */
	public void setPaymentLocalService(PaymentLocalService paymentLocalService) {
		this.paymentLocalService = paymentLocalService;
	}

	/**
	 * Returns the payment persistence.
	 *
	 * @return the payment persistence
	 */
	public PaymentPersistence getPaymentPersistence() {
		return paymentPersistence;
	}

	/**
	 * Sets the payment persistence.
	 *
	 * @param paymentPersistence the payment persistence
	 */
	public void setPaymentPersistence(PaymentPersistence paymentPersistence) {
		this.paymentPersistence = paymentPersistence;
	}

	/**
	 * Returns the proposal local service.
	 *
	 * @return the proposal local service
	 */
	public com.sphms.common.service.service.ProposalLocalService getProposalLocalService() {
		return proposalLocalService;
	}

	/**
	 * Sets the proposal local service.
	 *
	 * @param proposalLocalService the proposal local service
	 */
	public void setProposalLocalService(
		com.sphms.common.service.service.ProposalLocalService proposalLocalService) {
		this.proposalLocalService = proposalLocalService;
	}

	/**
	 * Returns the proposal persistence.
	 *
	 * @return the proposal persistence
	 */
	public ProposalPersistence getProposalPersistence() {
		return proposalPersistence;
	}

	/**
	 * Sets the proposal persistence.
	 *
	 * @param proposalPersistence the proposal persistence
	 */
	public void setProposalPersistence(ProposalPersistence proposalPersistence) {
		this.proposalPersistence = proposalPersistence;
	}

	/**
	 * Returns the proposal_ hording local service.
	 *
	 * @return the proposal_ hording local service
	 */
	public com.sphms.common.service.service.Proposal_HordingLocalService getProposal_HordingLocalService() {
		return proposal_HordingLocalService;
	}

	/**
	 * Sets the proposal_ hording local service.
	 *
	 * @param proposal_HordingLocalService the proposal_ hording local service
	 */
	public void setProposal_HordingLocalService(
		com.sphms.common.service.service.Proposal_HordingLocalService proposal_HordingLocalService) {
		this.proposal_HordingLocalService = proposal_HordingLocalService;
	}

	/**
	 * Returns the proposal_ hording persistence.
	 *
	 * @return the proposal_ hording persistence
	 */
	public Proposal_HordingPersistence getProposal_HordingPersistence() {
		return proposal_HordingPersistence;
	}

	/**
	 * Sets the proposal_ hording persistence.
	 *
	 * @param proposal_HordingPersistence the proposal_ hording persistence
	 */
	public void setProposal_HordingPersistence(
		Proposal_HordingPersistence proposal_HordingPersistence) {
		this.proposal_HordingPersistence = proposal_HordingPersistence;
	}

	/**
	 * Returns the s p h m s common local service.
	 *
	 * @return the s p h m s common local service
	 */
	public com.sphms.common.service.service.SPHMSCommonLocalService getSPHMSCommonLocalService() {
		return sphmsCommonLocalService;
	}

	/**
	 * Sets the s p h m s common local service.
	 *
	 * @param sphmsCommonLocalService the s p h m s common local service
	 */
	public void setSPHMSCommonLocalService(
		com.sphms.common.service.service.SPHMSCommonLocalService sphmsCommonLocalService) {
		this.sphmsCommonLocalService = sphmsCommonLocalService;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService getClassNameLocalService() {
		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService) {
		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {
		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		persistedModelLocalServiceRegistry.register("com.sphms.common.service.model.Payment",
			paymentLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"com.sphms.common.service.model.Payment");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return PaymentLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Payment.class;
	}

	protected String getModelClassName() {
		return Payment.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = paymentPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.sphms.common.service.service.BillingLocalService.class)
	protected com.sphms.common.service.service.BillingLocalService billingLocalService;
	@BeanReference(type = BillingPersistence.class)
	protected BillingPersistence billingPersistence;
	@BeanReference(type = com.sphms.common.service.service.Billing_HordingLocalService.class)
	protected com.sphms.common.service.service.Billing_HordingLocalService billing_HordingLocalService;
	@BeanReference(type = Billing_HordingPersistence.class)
	protected Billing_HordingPersistence billing_HordingPersistence;
	@BeanReference(type = com.sphms.common.service.service.Billing_POLocalService.class)
	protected com.sphms.common.service.service.Billing_POLocalService billing_POLocalService;
	@BeanReference(type = Billing_POPersistence.class)
	protected Billing_POPersistence billing_POPersistence;
	@BeanReference(type = com.sphms.common.service.service.BookingLocalService.class)
	protected com.sphms.common.service.service.BookingLocalService bookingLocalService;
	@BeanReference(type = BookingPersistence.class)
	protected BookingPersistence bookingPersistence;
	@BeanReference(type = com.sphms.common.service.service.Booking_HordingLocalService.class)
	protected com.sphms.common.service.service.Booking_HordingLocalService booking_HordingLocalService;
	@BeanReference(type = Booking_HordingPersistence.class)
	protected Booking_HordingPersistence booking_HordingPersistence;
	@BeanReference(type = com.sphms.common.service.service.ClientLocalService.class)
	protected com.sphms.common.service.service.ClientLocalService clientLocalService;
	@BeanReference(type = ClientPersistence.class)
	protected ClientPersistence clientPersistence;
	@BeanReference(type = com.sphms.common.service.service.CreditNoteLocalService.class)
	protected com.sphms.common.service.service.CreditNoteLocalService creditNoteLocalService;
	@BeanReference(type = CreditNotePersistence.class)
	protected CreditNotePersistence creditNotePersistence;
	@BeanReference(type = com.sphms.common.service.service.CustomCompanyLocalService.class)
	protected com.sphms.common.service.service.CustomCompanyLocalService customCompanyLocalService;
	@BeanReference(type = CustomCompanyPersistence.class)
	protected CustomCompanyPersistence customCompanyPersistence;
	@BeanReference(type = com.sphms.common.service.service.ExpenseLocalService.class)
	protected com.sphms.common.service.service.ExpenseLocalService expenseLocalService;
	@BeanReference(type = ExpensePersistence.class)
	protected ExpensePersistence expensePersistence;
	@BeanReference(type = com.sphms.common.service.service.HordingLocalService.class)
	protected com.sphms.common.service.service.HordingLocalService hordingLocalService;
	@BeanReference(type = HordingPersistence.class)
	protected HordingPersistence hordingPersistence;
	@BeanReference(type = HordingFinder.class)
	protected HordingFinder hordingFinder;
	@BeanReference(type = com.sphms.common.service.service.LandLordLocalService.class)
	protected com.sphms.common.service.service.LandLordLocalService landLordLocalService;
	@BeanReference(type = LandLordPersistence.class)
	protected LandLordPersistence landLordPersistence;
	@BeanReference(type = LandLordFinder.class)
	protected LandLordFinder landLordFinder;
	@BeanReference(type = com.sphms.common.service.service.LandLordPaymentLocalService.class)
	protected com.sphms.common.service.service.LandLordPaymentLocalService landLordPaymentLocalService;
	@BeanReference(type = LandLordPaymentPersistence.class)
	protected LandLordPaymentPersistence landLordPaymentPersistence;
	@BeanReference(type = PaymentLocalService.class)
	protected PaymentLocalService paymentLocalService;
	@BeanReference(type = PaymentPersistence.class)
	protected PaymentPersistence paymentPersistence;
	@BeanReference(type = com.sphms.common.service.service.ProposalLocalService.class)
	protected com.sphms.common.service.service.ProposalLocalService proposalLocalService;
	@BeanReference(type = ProposalPersistence.class)
	protected ProposalPersistence proposalPersistence;
	@BeanReference(type = com.sphms.common.service.service.Proposal_HordingLocalService.class)
	protected com.sphms.common.service.service.Proposal_HordingLocalService proposal_HordingLocalService;
	@BeanReference(type = Proposal_HordingPersistence.class)
	protected Proposal_HordingPersistence proposal_HordingPersistence;
	@BeanReference(type = com.sphms.common.service.service.SPHMSCommonLocalService.class)
	protected com.sphms.common.service.service.SPHMSCommonLocalService sphmsCommonLocalService;
	@ServiceReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@ServiceReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@ServiceReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry persistedModelLocalServiceRegistry;
}