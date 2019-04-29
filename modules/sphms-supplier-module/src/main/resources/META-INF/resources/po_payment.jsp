<%@ include file="./init.jsp" %>

<liferay-ui:success key="payment-added-successfully" message="payment-added-successfully"/>
<liferay-ui:error key="payment-add-error" message="payment-add-error"/>
<liferay-ui:success key="payment-updated-successfully" message="payment-updated-successfully"/>
<liferay-ui:error key="payment-update-aerror" message="payment-update-error"/>

<liferay-ui:success key="po-payment-add-success" message="po-payment-add-success"/>
<liferay-ui:success key="po-payment-update-success" message="po-payment-add-success"/>
<liferay-ui:success key="delet-po-success" message="delet-po-success"/>
<liferay-ui:error key="delet-po-aerror" message="delet-po-error"/>


<portlet:renderURL var="addPOPaymentURL">
        <portlet:param name="mvcRenderCommandName" value="/add_po_payment" />
        <portlet:param name="billingId" value="${billingId}" />
        <portlet:param name="landLordId" value="${landLordId}" />
         <portlet:param name="companyId" value="${companyId}" />
</portlet:renderURL>

<section>
	<h1>
    	<span>
    		<a href="${addPOPaymentURL}" class="btn btn-primary">Add Payment</a>
    	</span>
    	<span class="pull-right">
    		<h3>PO No :  ${billingPOBean.poNumber } </h3>
    	</span>
  	</h1>
</section>
<section>
 <div class="row">
 	 <div class="col-xs-12">
     	<div class="box">
            <div class="box-body">
            	<table id="billPayments" class="display table table-bordered table-hover table-striped" cellspacing="0" width="100%">
					<thead>
			            <tr>
			                <th>Supplier</th>
			                <th>Amount</th>
			                <th>Payment Type</th>
			                <th>GST</th>
			                <th>Payment Date</th>
			                <th>Action</th>
			            </tr>
     			   </thead>
        		   <tbody>
            	      <c:forEach items="${poPayments }" var="poPayment">
            			<tr>
			                <td>${supplierName }</td>
			                <td>${poPayment.amount }</td>
			                <td>
			                <c:if test="${fn:length(poPayment.chequeNo) gt 0}">
			               		 Cheque No - ${poPayment.chequeNo }
			               	</c:if>
			               	 <c:if test="${fn:length(poPayment.chequeNo) eq 0}">
			               		 Cash
			               	</c:if>		 
			               	</td>
			                <td>${poPayment.gst }</td>
			                <c:choose>
			                	<c:when test="${not empty poPayment.paymentDate}">
			                		<fmt:formatDate pattern = "dd/MM/yyyy" 	value = "${ poPayment.paymentDate}"  var="paymentDate"/>
			                	</c:when>
			                	<c:otherwise>
			                		<fmt:formatDate pattern = "dd/MM/yyyy" 	value = "${ poPayment.createDate}"  var="paymentDate"/>
			                	</c:otherwise>
			                </c:choose>
			                
			                <td>${paymentDate }</td>
			                <portlet:renderURL var="editPaymentURL">
       							 <portlet:param name="mvcRenderCommandName" value="/add_po_payment" />
       							 <portlet:param name="poPaymentId" value="${ poPayment.poPaymentId}" />
       							 <portlet:param name="billingId" value="${billingId}" />
        						 <portlet:param name="landLordId" value="${landLordId}" />
         						 <portlet:param name="companyId" value="${companyId}" />
							</portlet:renderURL>
							<portlet:actionURL var="deletePaymentURL" name="/delete_po_payment">
			                	  <portlet:param name="poPaymentId" value="${ poPayment.poPaymentId}" />
       							 <portlet:param name="billingId" value="${billingId}" />
        						 <portlet:param name="landLordId" value="${landLordId}" />
         						 <portlet:param name="companyId" value="${companyId}" />
							</portlet:actionURL>
							<td>
								<a href="${editPaymentURL }" class="btn btn-block btn-primary">Edit</a>
								<a href="${deletePaymentURL }" class="btn btn-block btn-primary">Delete</a>
							</td>
        			    </tr>
           			</c:forEach>
           			</tbody>
				</table>
            </div>
        </div>
     </div>
  </div>
</section>  
<script type="text/javascript">
        jQuery.noConflict();
        (function($) {
            $(function() {  
            	 $('#billPayments').DataTable({
            		 "pageLength": 50,
            		 "order": []
            	 });
            });
        })(jQuery);
 </script>