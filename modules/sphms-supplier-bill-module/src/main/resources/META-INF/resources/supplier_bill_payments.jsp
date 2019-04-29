<%@ include file="/init.jsp" %>

<portlet:renderURL var="addSupplierBillPaymentURL">
        <portlet:param name="mvcRenderCommandName" value="/add_supplier_bill_payment" />
        <portlet:param name="supplierId" value="${supplierId}" />
        <portlet:param name="supplierBillId" value="${supplierBillId}" />
</portlet:renderURL>

<liferay-ui:success key="delete-supplier-patment-successs" message="delete-supplier-patment-successs"/>
<liferay-ui:success key="delete-supplier-patment-error" message="delete-supplier-patment-error"/>

<liferay-ui:success key="payment-add-success" message="payment-add-success"/>
<liferay-ui:success key="payment-update-success" message="payment-update-success"/>


<section>
	<h1>
    	<span>
    		<a href="${addSupplierBillPaymentURL}" class="btn btn-primary">Add Payment</a>
    	</span>
  	</h1>
</section>

<section class="content">
 <div class="row">
 	 <div class="col-xs-12">
     	<div class="box">
            <div class="box-body">
            	<table id="billPayments" class="display table table-bordered table-hover table-striped">
					<thead>
			            <tr>
			                <th>Supplier Name</th>
			                <th>Amount</th>
			                <th>GST</th>
			                <th>Payment Type</th>
			                <th>Payment Date</th>
			                <th>Action</th>
			            </tr>
     			   </thead>
        		   <tbody>
            	      <c:forEach items="${billPayments }" var="payment">
            			<tr>
			                <td>${supplierName }</td>
			                <td>${payment.amount }</td>
			                <td>${payment.gst }</td>
			                <td>
			                <c:if test="${fn:length(payment.chequeNo) gt 0}">
			               		 Cheque No - ${payment.chequeNo }
			               	</c:if>
			               	 <c:if test="${fn:length(payment.chequeNo) eq 0}">
			               		 Cash
			               	</c:if>		
			                </td>
			                <c:choose>
			                	<c:when test="${not empty payment.paymentDate}">
			                		<fmt:formatDate pattern = "dd/MM/yyyy" 	value = "${ payment.paymentDate}"  var="paymentDate"/>
			                	</c:when>
			                	<c:otherwise>
			                		<fmt:formatDate pattern = "dd/MM/yyyy" 	value = "${ payment.paymentDate}"  var="paymentDate"/>
			                	</c:otherwise>
			                </c:choose>
			                
			                <td>${paymentDate }</td>
			                <portlet:renderURL var="editPaymentURL">
       							 <portlet:param name="mvcRenderCommandName" value="/add_supplier_bill_payment" />
       							 <portlet:param name="supplierBillPaymentId" value="${ payment.supplierBillPaymentId}" />
       							 <portlet:param name="supplierId" value="${supplierId}" />
       							 <portlet:param name="supplierBillId" value="${supplierBillId}" />
							</portlet:renderURL>
							<portlet:actionURL var="deletePaymentURL" name="/delete_payment">
			                	 <portlet:param name="supplierBillPaymentId" value="${ payment.supplierBillPaymentId}" />
       							 <portlet:param name="supplierId" value="${supplierId}" />
       							 <portlet:param name="supplierBillId" value="${supplierBillId}" />
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
            	 
            	 $("#billPayments").removeClass("dataTable");
            });
        })(jQuery);
 </script>