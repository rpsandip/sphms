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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.sphms.common.service.exception.NoSuchCreditNoteException;
import com.sphms.common.service.model.CreditNote;

/**
 * The persistence interface for the credit note service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.sphms.common.service.service.persistence.impl.CreditNotePersistenceImpl
 * @see CreditNoteUtil
 * @generated
 */
@ProviderType
public interface CreditNotePersistence extends BasePersistence<CreditNote> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CreditNoteUtil} to access the credit note persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the credit notes where clientId = &#63;.
	*
	* @param clientId the client ID
	* @return the matching credit notes
	*/
	public java.util.List<CreditNote> findByclientId(long clientId);

	/**
	* Returns a range of all the credit notes where clientId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CreditNoteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param clientId the client ID
	* @param start the lower bound of the range of credit notes
	* @param end the upper bound of the range of credit notes (not inclusive)
	* @return the range of matching credit notes
	*/
	public java.util.List<CreditNote> findByclientId(long clientId, int start,
		int end);

	/**
	* Returns an ordered range of all the credit notes where clientId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CreditNoteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param clientId the client ID
	* @param start the lower bound of the range of credit notes
	* @param end the upper bound of the range of credit notes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching credit notes
	*/
	public java.util.List<CreditNote> findByclientId(long clientId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<CreditNote> orderByComparator);

	/**
	* Returns an ordered range of all the credit notes where clientId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CreditNoteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param clientId the client ID
	* @param start the lower bound of the range of credit notes
	* @param end the upper bound of the range of credit notes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching credit notes
	*/
	public java.util.List<CreditNote> findByclientId(long clientId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<CreditNote> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first credit note in the ordered set where clientId = &#63;.
	*
	* @param clientId the client ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching credit note
	* @throws NoSuchCreditNoteException if a matching credit note could not be found
	*/
	public CreditNote findByclientId_First(long clientId,
		com.liferay.portal.kernel.util.OrderByComparator<CreditNote> orderByComparator)
		throws NoSuchCreditNoteException;

	/**
	* Returns the first credit note in the ordered set where clientId = &#63;.
	*
	* @param clientId the client ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching credit note, or <code>null</code> if a matching credit note could not be found
	*/
	public CreditNote fetchByclientId_First(long clientId,
		com.liferay.portal.kernel.util.OrderByComparator<CreditNote> orderByComparator);

	/**
	* Returns the last credit note in the ordered set where clientId = &#63;.
	*
	* @param clientId the client ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching credit note
	* @throws NoSuchCreditNoteException if a matching credit note could not be found
	*/
	public CreditNote findByclientId_Last(long clientId,
		com.liferay.portal.kernel.util.OrderByComparator<CreditNote> orderByComparator)
		throws NoSuchCreditNoteException;

	/**
	* Returns the last credit note in the ordered set where clientId = &#63;.
	*
	* @param clientId the client ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching credit note, or <code>null</code> if a matching credit note could not be found
	*/
	public CreditNote fetchByclientId_Last(long clientId,
		com.liferay.portal.kernel.util.OrderByComparator<CreditNote> orderByComparator);

	/**
	* Returns the credit notes before and after the current credit note in the ordered set where clientId = &#63;.
	*
	* @param creditNoteId the primary key of the current credit note
	* @param clientId the client ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next credit note
	* @throws NoSuchCreditNoteException if a credit note with the primary key could not be found
	*/
	public CreditNote[] findByclientId_PrevAndNext(long creditNoteId,
		long clientId,
		com.liferay.portal.kernel.util.OrderByComparator<CreditNote> orderByComparator)
		throws NoSuchCreditNoteException;

	/**
	* Removes all the credit notes where clientId = &#63; from the database.
	*
	* @param clientId the client ID
	*/
	public void removeByclientId(long clientId);

	/**
	* Returns the number of credit notes where clientId = &#63;.
	*
	* @param clientId the client ID
	* @return the number of matching credit notes
	*/
	public int countByclientId(long clientId);

	/**
	* Caches the credit note in the entity cache if it is enabled.
	*
	* @param creditNote the credit note
	*/
	public void cacheResult(CreditNote creditNote);

	/**
	* Caches the credit notes in the entity cache if it is enabled.
	*
	* @param creditNotes the credit notes
	*/
	public void cacheResult(java.util.List<CreditNote> creditNotes);

	/**
	* Creates a new credit note with the primary key. Does not add the credit note to the database.
	*
	* @param creditNoteId the primary key for the new credit note
	* @return the new credit note
	*/
	public CreditNote create(long creditNoteId);

	/**
	* Removes the credit note with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param creditNoteId the primary key of the credit note
	* @return the credit note that was removed
	* @throws NoSuchCreditNoteException if a credit note with the primary key could not be found
	*/
	public CreditNote remove(long creditNoteId)
		throws NoSuchCreditNoteException;

	public CreditNote updateImpl(CreditNote creditNote);

	/**
	* Returns the credit note with the primary key or throws a {@link NoSuchCreditNoteException} if it could not be found.
	*
	* @param creditNoteId the primary key of the credit note
	* @return the credit note
	* @throws NoSuchCreditNoteException if a credit note with the primary key could not be found
	*/
	public CreditNote findByPrimaryKey(long creditNoteId)
		throws NoSuchCreditNoteException;

	/**
	* Returns the credit note with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param creditNoteId the primary key of the credit note
	* @return the credit note, or <code>null</code> if a credit note with the primary key could not be found
	*/
	public CreditNote fetchByPrimaryKey(long creditNoteId);

	@Override
	public java.util.Map<java.io.Serializable, CreditNote> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the credit notes.
	*
	* @return the credit notes
	*/
	public java.util.List<CreditNote> findAll();

	/**
	* Returns a range of all the credit notes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CreditNoteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of credit notes
	* @param end the upper bound of the range of credit notes (not inclusive)
	* @return the range of credit notes
	*/
	public java.util.List<CreditNote> findAll(int start, int end);

	/**
	* Returns an ordered range of all the credit notes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CreditNoteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of credit notes
	* @param end the upper bound of the range of credit notes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of credit notes
	*/
	public java.util.List<CreditNote> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CreditNote> orderByComparator);

	/**
	* Returns an ordered range of all the credit notes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CreditNoteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of credit notes
	* @param end the upper bound of the range of credit notes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of credit notes
	*/
	public java.util.List<CreditNote> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CreditNote> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the credit notes from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of credit notes.
	*
	* @return the number of credit notes
	*/
	public int countAll();
}