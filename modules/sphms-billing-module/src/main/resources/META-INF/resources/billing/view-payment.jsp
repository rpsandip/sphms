<%@ include file="../init.jsp" %>

<liferay-ui:success key="payment-added-successfully" message="payment-added-successfully"/>
<liferay-ui:error key="payment-add-error" message="payment-add-error"/>
<liferay-ui:success key="payment-updated-successfully" message="payment-updated-successfully"/>
<liferay-ui:error key="payment-update-aerror" message="payment-update-error"/>


<portlet:renderURL var="addPaymentURL">
        <portlet:param name="mvcRenderCommandName" value="/add_bill_payment" />
         <portlet:param name="billingId" value="${billingBean.billingId}" />
</portlet:renderURL>

<section>
	<h1>
    	<span>
    		<a href="${addPaymentURL}" class="btn btn-primary">Add Payment</a>
    	</span>
    	<span class="pull-right">
    		<h3>Bill No :  ${billingBean.billNo } </h3>
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
			                <th>Campaign</th>
			                <th>Client</th>
			                <th>Amount</th>
			                <th>Payment Type</th>
			                <th>TDS</th>
			                <th>Other Deduction</th>
			                <th>Payment Date</th>
			                <th>Description</th>
			                <th>Action</th>
			            </tr>
     			   </thead>
        		   <tbody>
            	      <c:forEach items="${billPaymentList }" var="payment">
            			<tr>
			                <td>${billingBean.campaign }</td>
			                <td>${billingBean.clientName }</td>
			                <td>${payment.amount }</td>
			                <td>
			                <c:if test="${fn:length(payment.chequeNo) gt 0}">
			               		 ${payment.chequeNo }
			               	</c:if>
			               	 <c:if test="${fn:length(payment.chequeNo) eq 0}">
			               		 Cash
			               	</c:if>		 
			               	</td>
			                <td>${payment.tds }</td>
			                <td>${payment.deduction }</td>
			                <fmt:formatDate pattern = "dd/MM/yyyy" 	value = "${ payment.createDate}"  var="paymentDate"/>
			                <td>${paymentDate }</td>
			                <td>${payment.description }</td>
			                <portlet:renderURL var="editPaymentURL">
       							 <portlet:param name="mvcRenderCommandName" value="/add_bill_payment" />
       							 <portlet:param name="paymentId" value="${ payment.paymentId}" />
       							 <portlet:param name="billingId" value="${billingBean.billingId}" />
							</portlet:renderURL>
							<td>
								<a href="${editPaymentURL }" class="btn btn-block btn-primary">Edit Payment</a>
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