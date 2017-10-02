create index IX_85729F11 on SPHMS_Billing (bookingId);
create index IX_2C92650D on SPHMS_Billing (clientId);

create index IX_E0528F09 on SPHMS_Billing_Hording (billingId);

create index IX_C83966C9 on SPHMS_Booking_Hording (bookingId);

create index IX_BB1D6CB6 on SPHMS_Hording (landLordId, status);

create index IX_5BBB891E on SPHMS_LandLordPayment (landLoadId);

create index IX_F262A288 on SPHMS_Payment (billingId);

create index IX_B8AC09B1 on SPHMS_Proposal_Hording (proposalId);