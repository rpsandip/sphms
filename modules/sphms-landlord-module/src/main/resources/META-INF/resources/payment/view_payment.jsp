<%@ include file="../init.jsp" %>


<section class="content-header">
  <h1>
  	${landLord.firstName } ${landLord.lastName }
  </h1>
</section>
<section class="content">
 <div class="row">
 	 <div class="col-xs-12">
     	<div class="box">
            <div class="box-body">
            	<table id="payments" class="display table table-bordered table-hover table-striped" cellspacing="0" width="100%">
					<thead>
			            <tr>
			                <th>Hoarding</th>
			                <th>Payment Date</th>
			                <th>Amount</th>
			                <th>Payment Type</th>
			                <th>Description</th>
			                <th>Action</th>
			            </tr>
     			   </thead>
        		   <tbody>
            	      <c:forEach items="${landLordPaymentBeanList }" var="landLordPaymentBean">
            			<tr>
            				<td>${landLordPaymentBean.hordingTitle }</td>
            				<fmt:formatDate pattern = "dd/MM/yyyy" value = "${landLordPaymentBean.paymentDate}" var="paymentDate"/>
			                <td>${paymentDate }</td>
			                <td>Rs. ${landLordPaymentBean.amount }</td>
			                <td>
			                <c:if test="${fn:length(landLordPaymentBean.chequeNo) gt 0}">
			               		Cheque No : ${landLordPaymentBean.chequeNo } (${landLordPaymentBean.bankName })
			               	</c:if>
			               	 <c:if test="${fn:length(landLordPaymentBean.chequeNo) eq 0}">
			               		 Cash
			               	</c:if>	
			               	</td>
			               	<td>
			               		${landLordPaymentBean.description}
			               	</td>
			                <portlet:renderURL var="editPaymentURL">
       							 <portlet:param name="mvcRenderCommandName" value="/add_land_lord_payment" />
       							 <portlet:param name="landLordId" value="${ landLord.landLordId}" />
       							 <portlet:param name="landLordPaymentId" value="${ landLordPaymentBean.landLordPaymentId}" />
							</portlet:renderURL>
			                <td><a href="${editPaymentURL }" class="btn btn-block btn-primary">Edit</a></td>
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
            	 $('#payments').DataTable({
            		 "order": []
            	 });
            });
        })(jQuery);
    </script>     