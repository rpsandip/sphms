<%@ include file="../init.jsp"%>

<portlet:actionURL var="editPODetailURL" name="/edit-po">
</portlet:actionURL>

<section>
	<h1>
		<span> <liferay-ui:message key="edit.po" />
		</span> <span class="pull-right">
			<h4>PO :</h4> ${poNumber }
		</span>
	</h1>
</section>

<div class="row">
	<div class="col-xs-12">
		<div class="box">
			<div class="box-body">
				<aui:form name="editPOFm" action="${editPODetailURL}"
					cssClass="row contact_form" method="POST">

					<div class="row">

						<div class="form-group col-md-6">
							<aui:input type="text" name="supplierGstAmt"
								label="Supplier GST Amount" value="${supplierGstAmt}" />
						</div>
						<div class="form-group col-md-6">
							<aui:input type="text" name="supplierBillNo"
								label="Suplier Bill No" value="${supplierBillNo}" />
						</div>
					</div>

					<div class="row">

						<div class="form-group col-md-6">
						<fmt:formatDate pattern = "dd/MM/yyyy" value = "${supplierBillDate}" var="supplierBillDate"/>
							<aui:input type="text" name="supplierBillDate"
								id="supplierBillDateVal" label="Supllier Bill Date"
								value="${supplierBillDate}" />
						</div>
						<div class="form-group col-md-6">
							<aui:input type="text" name="supplierTotalAmt"
								label="Supplier Total Amount" value="${supplierTotalAmt}" />
						</div>
					</div>




					<c:forEach items="${billingPOBeanList }" var="billingPOBean">

						<div class="row">
							<div class="form-group col-md-12">
								<b>Hoarding : </b> ${billingPOBean.hordingTitle }
							</div>
							<div class="form-group col-md-6">
								<aui:input type="text" name="totalAmount" label="Total Amount"
									value="${billingPOBean.totalAmount }" />
								<aui:input type="hidden" name="hordingId" label=""
									value="${billingPOBean.hordingId }" />
							</div>
						</div>

					</c:forEach>

					<div class="row">
						<div class="form-group col-md-6">
							<aui:select name="paymentGiven" label="Payment Given" cssClass="form-control">
	       					 	<aui:option value="NO" selected='${supplierPaymentGiven eq "NO" ? true : false }'>No</aui:option>
	       					 	<aui:option value="YES" selected='${supplierPaymentGiven eq "YES" ? true : false }'>Yes</aui:option>
							</aui:select>
							
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<%-- <aui:input type="hidden" name="hordingId" value="${billingPOBean.hordingId }"></aui:input> --%>
							<aui:input type="hidden" name="billingId" value="${billingId }"></aui:input>
							<aui:input type="hidden" name="landLordId" value="${landLordId }"></aui:input>
							<aui:button type="button" value="Update PO"
								cssClass="editPOBtn btn btn-primary" />
						</div>
					</div>	
					
				</aui:form>
			</div>
		</div>
	</div>
</div>
	
<script type="text/javascript">

		jQuery.noConflict();
		(function($) {
		    $(function() {
		    	
		   		AUI().use('aui-base','liferay-portlet-url','aui-form-validator', function(A) {
		   			
		   			
		   			var userModuleNameSpace = '<portlet:namespace/>';
		   			AUI().use('aui-base', 'aui-form-validator', function(A) {
		   				var editPOBtn = A.one(".editPOBtn");
		   				editPOBtn.on('click', function(e) {
		   					/* var formValidator = Liferay.Form.get('<portlet:namespace />editPOFm').formValidator;
		   					formValidator.validate();
		   					if(!formValidator.hasErrors()){ */
		   					document.<portlet:namespace />editPOFm.submit();
		   					/* 	} */
		   				});

		   			});

					$('#'+'<portlet:namespace/>'+'supplierBillDateVal').datepicker({
						format : 'dd/mm/yyyy',
						autoclose : true
					});
	
	

		   	  });
		    });
		   })(jQuery);
</script>

