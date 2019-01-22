create index IX_85729F11 on SPHMS_Billing (bookingId);
create index IX_2C92650D on SPHMS_Billing (clientId);

create index IX_BFAA6CB on SPHMS_Billing_Hording (billingId, hordingId);

create index IX_8BB6B63E on SPHMS_Billing_PO (billingId, landLordId);

create index IX_D9CA80E7 on SPHMS_Booking (billId);

create index IX_C83966C9 on SPHMS_Booking_Hording (bookingId);

create index IX_B117F0E5 on SPHMS_Client (status);

create index IX_D76495B9 on SPHMS_CreditNote (clientId);

create index IX_BB1D6CB6 on SPHMS_Hording (landLordId, status);

create index IX_5BBB891E on SPHMS_LandLordPayment (landLoadId);

create index IX_F2379176 on SPHMS_POPayment (billingId, landLordId);

create index IX_A5EF5E5B on SPHMS_PO_Payment (billingId, landLordId);

create index IX_F262A288 on SPHMS_Payment (billingId);

create index IX_B8AC09B1 on SPHMS_Proposal_Hording (proposalId);