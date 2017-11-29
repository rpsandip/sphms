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

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.sphms.common.service.exception.NoSuchCreditNoteException;
import com.sphms.common.service.model.CreditNote;
import com.sphms.common.service.model.impl.CreditNoteImpl;
import com.sphms.common.service.model.impl.CreditNoteModelImpl;
import com.sphms.common.service.service.persistence.CreditNotePersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the credit note service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CreditNotePersistence
 * @see com.sphms.common.service.service.persistence.CreditNoteUtil
 * @generated
 */
@ProviderType
public class CreditNotePersistenceImpl extends BasePersistenceImpl<CreditNote>
	implements CreditNotePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CreditNoteUtil} to access the credit note persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CreditNoteImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CreditNoteModelImpl.ENTITY_CACHE_ENABLED,
			CreditNoteModelImpl.FINDER_CACHE_ENABLED, CreditNoteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CreditNoteModelImpl.ENTITY_CACHE_ENABLED,
			CreditNoteModelImpl.FINDER_CACHE_ENABLED, CreditNoteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CreditNoteModelImpl.ENTITY_CACHE_ENABLED,
			CreditNoteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CLIENTID = new FinderPath(CreditNoteModelImpl.ENTITY_CACHE_ENABLED,
			CreditNoteModelImpl.FINDER_CACHE_ENABLED, CreditNoteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByclientId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLIENTID =
		new FinderPath(CreditNoteModelImpl.ENTITY_CACHE_ENABLED,
			CreditNoteModelImpl.FINDER_CACHE_ENABLED, CreditNoteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByclientId",
			new String[] { Long.class.getName() },
			CreditNoteModelImpl.CLIENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CLIENTID = new FinderPath(CreditNoteModelImpl.ENTITY_CACHE_ENABLED,
			CreditNoteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByclientId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the credit notes where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @return the matching credit notes
	 */
	@Override
	public List<CreditNote> findByclientId(long clientId) {
		return findByclientId(clientId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

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
	@Override
	public List<CreditNote> findByclientId(long clientId, int start, int end) {
		return findByclientId(clientId, start, end, null);
	}

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
	@Override
	public List<CreditNote> findByclientId(long clientId, int start, int end,
		OrderByComparator<CreditNote> orderByComparator) {
		return findByclientId(clientId, start, end, orderByComparator, true);
	}

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
	@Override
	public List<CreditNote> findByclientId(long clientId, int start, int end,
		OrderByComparator<CreditNote> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLIENTID;
			finderArgs = new Object[] { clientId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CLIENTID;
			finderArgs = new Object[] { clientId, start, end, orderByComparator };
		}

		List<CreditNote> list = null;

		if (retrieveFromCache) {
			list = (List<CreditNote>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CreditNote creditNote : list) {
					if ((clientId != creditNote.getClientId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_CREDITNOTE_WHERE);

			query.append(_FINDER_COLUMN_CLIENTID_CLIENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CreditNoteModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(clientId);

				if (!pagination) {
					list = (List<CreditNote>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CreditNote>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first credit note in the ordered set where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching credit note
	 * @throws NoSuchCreditNoteException if a matching credit note could not be found
	 */
	@Override
	public CreditNote findByclientId_First(long clientId,
		OrderByComparator<CreditNote> orderByComparator)
		throws NoSuchCreditNoteException {
		CreditNote creditNote = fetchByclientId_First(clientId,
				orderByComparator);

		if (creditNote != null) {
			return creditNote;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("clientId=");
		msg.append(clientId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCreditNoteException(msg.toString());
	}

	/**
	 * Returns the first credit note in the ordered set where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching credit note, or <code>null</code> if a matching credit note could not be found
	 */
	@Override
	public CreditNote fetchByclientId_First(long clientId,
		OrderByComparator<CreditNote> orderByComparator) {
		List<CreditNote> list = findByclientId(clientId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last credit note in the ordered set where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching credit note
	 * @throws NoSuchCreditNoteException if a matching credit note could not be found
	 */
	@Override
	public CreditNote findByclientId_Last(long clientId,
		OrderByComparator<CreditNote> orderByComparator)
		throws NoSuchCreditNoteException {
		CreditNote creditNote = fetchByclientId_Last(clientId, orderByComparator);

		if (creditNote != null) {
			return creditNote;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("clientId=");
		msg.append(clientId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCreditNoteException(msg.toString());
	}

	/**
	 * Returns the last credit note in the ordered set where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching credit note, or <code>null</code> if a matching credit note could not be found
	 */
	@Override
	public CreditNote fetchByclientId_Last(long clientId,
		OrderByComparator<CreditNote> orderByComparator) {
		int count = countByclientId(clientId);

		if (count == 0) {
			return null;
		}

		List<CreditNote> list = findByclientId(clientId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the credit notes before and after the current credit note in the ordered set where clientId = &#63;.
	 *
	 * @param creditNoteId the primary key of the current credit note
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next credit note
	 * @throws NoSuchCreditNoteException if a credit note with the primary key could not be found
	 */
	@Override
	public CreditNote[] findByclientId_PrevAndNext(long creditNoteId,
		long clientId, OrderByComparator<CreditNote> orderByComparator)
		throws NoSuchCreditNoteException {
		CreditNote creditNote = findByPrimaryKey(creditNoteId);

		Session session = null;

		try {
			session = openSession();

			CreditNote[] array = new CreditNoteImpl[3];

			array[0] = getByclientId_PrevAndNext(session, creditNote, clientId,
					orderByComparator, true);

			array[1] = creditNote;

			array[2] = getByclientId_PrevAndNext(session, creditNote, clientId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CreditNote getByclientId_PrevAndNext(Session session,
		CreditNote creditNote, long clientId,
		OrderByComparator<CreditNote> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CREDITNOTE_WHERE);

		query.append(_FINDER_COLUMN_CLIENTID_CLIENTID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(CreditNoteModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(clientId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(creditNote);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CreditNote> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the credit notes where clientId = &#63; from the database.
	 *
	 * @param clientId the client ID
	 */
	@Override
	public void removeByclientId(long clientId) {
		for (CreditNote creditNote : findByclientId(clientId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(creditNote);
		}
	}

	/**
	 * Returns the number of credit notes where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @return the number of matching credit notes
	 */
	@Override
	public int countByclientId(long clientId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CLIENTID;

		Object[] finderArgs = new Object[] { clientId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CREDITNOTE_WHERE);

			query.append(_FINDER_COLUMN_CLIENTID_CLIENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(clientId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CLIENTID_CLIENTID_2 = "creditNote.clientId = ?";

	public CreditNotePersistenceImpl() {
		setModelClass(CreditNote.class);
	}

	/**
	 * Caches the credit note in the entity cache if it is enabled.
	 *
	 * @param creditNote the credit note
	 */
	@Override
	public void cacheResult(CreditNote creditNote) {
		entityCache.putResult(CreditNoteModelImpl.ENTITY_CACHE_ENABLED,
			CreditNoteImpl.class, creditNote.getPrimaryKey(), creditNote);

		creditNote.resetOriginalValues();
	}

	/**
	 * Caches the credit notes in the entity cache if it is enabled.
	 *
	 * @param creditNotes the credit notes
	 */
	@Override
	public void cacheResult(List<CreditNote> creditNotes) {
		for (CreditNote creditNote : creditNotes) {
			if (entityCache.getResult(
						CreditNoteModelImpl.ENTITY_CACHE_ENABLED,
						CreditNoteImpl.class, creditNote.getPrimaryKey()) == null) {
				cacheResult(creditNote);
			}
			else {
				creditNote.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all credit notes.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CreditNoteImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the credit note.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CreditNote creditNote) {
		entityCache.removeResult(CreditNoteModelImpl.ENTITY_CACHE_ENABLED,
			CreditNoteImpl.class, creditNote.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CreditNote> creditNotes) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CreditNote creditNote : creditNotes) {
			entityCache.removeResult(CreditNoteModelImpl.ENTITY_CACHE_ENABLED,
				CreditNoteImpl.class, creditNote.getPrimaryKey());
		}
	}

	/**
	 * Creates a new credit note with the primary key. Does not add the credit note to the database.
	 *
	 * @param creditNoteId the primary key for the new credit note
	 * @return the new credit note
	 */
	@Override
	public CreditNote create(long creditNoteId) {
		CreditNote creditNote = new CreditNoteImpl();

		creditNote.setNew(true);
		creditNote.setPrimaryKey(creditNoteId);

		return creditNote;
	}

	/**
	 * Removes the credit note with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param creditNoteId the primary key of the credit note
	 * @return the credit note that was removed
	 * @throws NoSuchCreditNoteException if a credit note with the primary key could not be found
	 */
	@Override
	public CreditNote remove(long creditNoteId)
		throws NoSuchCreditNoteException {
		return remove((Serializable)creditNoteId);
	}

	/**
	 * Removes the credit note with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the credit note
	 * @return the credit note that was removed
	 * @throws NoSuchCreditNoteException if a credit note with the primary key could not be found
	 */
	@Override
	public CreditNote remove(Serializable primaryKey)
		throws NoSuchCreditNoteException {
		Session session = null;

		try {
			session = openSession();

			CreditNote creditNote = (CreditNote)session.get(CreditNoteImpl.class,
					primaryKey);

			if (creditNote == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCreditNoteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(creditNote);
		}
		catch (NoSuchCreditNoteException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected CreditNote removeImpl(CreditNote creditNote) {
		creditNote = toUnwrappedModel(creditNote);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(creditNote)) {
				creditNote = (CreditNote)session.get(CreditNoteImpl.class,
						creditNote.getPrimaryKeyObj());
			}

			if (creditNote != null) {
				session.delete(creditNote);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (creditNote != null) {
			clearCache(creditNote);
		}

		return creditNote;
	}

	@Override
	public CreditNote updateImpl(CreditNote creditNote) {
		creditNote = toUnwrappedModel(creditNote);

		boolean isNew = creditNote.isNew();

		CreditNoteModelImpl creditNoteModelImpl = (CreditNoteModelImpl)creditNote;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (creditNote.getCreateDate() == null)) {
			if (serviceContext == null) {
				creditNote.setCreateDate(now);
			}
			else {
				creditNote.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!creditNoteModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				creditNote.setModifiedDate(now);
			}
			else {
				creditNote.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (creditNote.isNew()) {
				session.save(creditNote);

				creditNote.setNew(false);
			}
			else {
				creditNote = (CreditNote)session.merge(creditNote);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CreditNoteModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((creditNoteModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLIENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						creditNoteModelImpl.getOriginalClientId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CLIENTID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLIENTID,
					args);

				args = new Object[] { creditNoteModelImpl.getClientId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CLIENTID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLIENTID,
					args);
			}
		}

		entityCache.putResult(CreditNoteModelImpl.ENTITY_CACHE_ENABLED,
			CreditNoteImpl.class, creditNote.getPrimaryKey(), creditNote, false);

		creditNote.resetOriginalValues();

		return creditNote;
	}

	protected CreditNote toUnwrappedModel(CreditNote creditNote) {
		if (creditNote instanceof CreditNoteImpl) {
			return creditNote;
		}

		CreditNoteImpl creditNoteImpl = new CreditNoteImpl();

		creditNoteImpl.setNew(creditNote.isNew());
		creditNoteImpl.setPrimaryKey(creditNote.getPrimaryKey());

		creditNoteImpl.setCreditNoteId(creditNote.getCreditNoteId());
		creditNoteImpl.setClientId(creditNote.getClientId());
		creditNoteImpl.setBillingId(creditNote.getBillingId());
		creditNoteImpl.setCreditNoteNumber(creditNote.getCreditNoteNumber());
		creditNoteImpl.setCreditNoteAmount(creditNote.getCreditNoteAmount());
		creditNoteImpl.setCreditNoteTax(creditNote.getCreditNoteTax());
		creditNoteImpl.setPaymentDate(creditNote.getPaymentDate());
		creditNoteImpl.setChequeNo(creditNote.getChequeNo());
		creditNoteImpl.setBankName(creditNote.getBankName());
		creditNoteImpl.setFinancialYear(creditNote.getFinancialYear());
		creditNoteImpl.setCreateDate(creditNote.getCreateDate());
		creditNoteImpl.setCreatedBy(creditNote.getCreatedBy());
		creditNoteImpl.setModifiedDate(creditNote.getModifiedDate());
		creditNoteImpl.setModifiedBy(creditNote.getModifiedBy());

		return creditNoteImpl;
	}

	/**
	 * Returns the credit note with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the credit note
	 * @return the credit note
	 * @throws NoSuchCreditNoteException if a credit note with the primary key could not be found
	 */
	@Override
	public CreditNote findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCreditNoteException {
		CreditNote creditNote = fetchByPrimaryKey(primaryKey);

		if (creditNote == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCreditNoteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return creditNote;
	}

	/**
	 * Returns the credit note with the primary key or throws a {@link NoSuchCreditNoteException} if it could not be found.
	 *
	 * @param creditNoteId the primary key of the credit note
	 * @return the credit note
	 * @throws NoSuchCreditNoteException if a credit note with the primary key could not be found
	 */
	@Override
	public CreditNote findByPrimaryKey(long creditNoteId)
		throws NoSuchCreditNoteException {
		return findByPrimaryKey((Serializable)creditNoteId);
	}

	/**
	 * Returns the credit note with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the credit note
	 * @return the credit note, or <code>null</code> if a credit note with the primary key could not be found
	 */
	@Override
	public CreditNote fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(CreditNoteModelImpl.ENTITY_CACHE_ENABLED,
				CreditNoteImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		CreditNote creditNote = (CreditNote)serializable;

		if (creditNote == null) {
			Session session = null;

			try {
				session = openSession();

				creditNote = (CreditNote)session.get(CreditNoteImpl.class,
						primaryKey);

				if (creditNote != null) {
					cacheResult(creditNote);
				}
				else {
					entityCache.putResult(CreditNoteModelImpl.ENTITY_CACHE_ENABLED,
						CreditNoteImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(CreditNoteModelImpl.ENTITY_CACHE_ENABLED,
					CreditNoteImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return creditNote;
	}

	/**
	 * Returns the credit note with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param creditNoteId the primary key of the credit note
	 * @return the credit note, or <code>null</code> if a credit note with the primary key could not be found
	 */
	@Override
	public CreditNote fetchByPrimaryKey(long creditNoteId) {
		return fetchByPrimaryKey((Serializable)creditNoteId);
	}

	@Override
	public Map<Serializable, CreditNote> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, CreditNote> map = new HashMap<Serializable, CreditNote>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			CreditNote creditNote = fetchByPrimaryKey(primaryKey);

			if (creditNote != null) {
				map.put(primaryKey, creditNote);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(CreditNoteModelImpl.ENTITY_CACHE_ENABLED,
					CreditNoteImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (CreditNote)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_CREDITNOTE_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(String.valueOf(primaryKey));

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (CreditNote creditNote : (List<CreditNote>)q.list()) {
				map.put(creditNote.getPrimaryKeyObj(), creditNote);

				cacheResult(creditNote);

				uncachedPrimaryKeys.remove(creditNote.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(CreditNoteModelImpl.ENTITY_CACHE_ENABLED,
					CreditNoteImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the credit notes.
	 *
	 * @return the credit notes
	 */
	@Override
	public List<CreditNote> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<CreditNote> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<CreditNote> findAll(int start, int end,
		OrderByComparator<CreditNote> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<CreditNote> findAll(int start, int end,
		OrderByComparator<CreditNote> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<CreditNote> list = null;

		if (retrieveFromCache) {
			list = (List<CreditNote>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CREDITNOTE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CREDITNOTE;

				if (pagination) {
					sql = sql.concat(CreditNoteModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CreditNote>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CreditNote>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the credit notes from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CreditNote creditNote : findAll()) {
			remove(creditNote);
		}
	}

	/**
	 * Returns the number of credit notes.
	 *
	 * @return the number of credit notes
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CREDITNOTE);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CreditNoteModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the credit note persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(CreditNoteImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_CREDITNOTE = "SELECT creditNote FROM CreditNote creditNote";
	private static final String _SQL_SELECT_CREDITNOTE_WHERE_PKS_IN = "SELECT creditNote FROM CreditNote creditNote WHERE creditNoteId IN (";
	private static final String _SQL_SELECT_CREDITNOTE_WHERE = "SELECT creditNote FROM CreditNote creditNote WHERE ";
	private static final String _SQL_COUNT_CREDITNOTE = "SELECT COUNT(creditNote) FROM CreditNote creditNote";
	private static final String _SQL_COUNT_CREDITNOTE_WHERE = "SELECT COUNT(creditNote) FROM CreditNote creditNote WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "creditNote.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CreditNote exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CreditNote exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(CreditNotePersistenceImpl.class);
}