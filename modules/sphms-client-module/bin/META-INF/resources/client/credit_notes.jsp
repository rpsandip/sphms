<%@ include file="../init.jsp" %>
<portlet:renderURL var="addCreditNoteURL">
	 <portlet:param name="mvcRenderCommandName" value="/add_credit_note" />
	 <portlet:param name="clientId" value="${clientId}" />
</portlet:renderURL>
<section class="content-header">
		<h1>
    		<liferay-ui:message key="credit.notes"/> &nbsp; &nbsp;
    		<a href="${addCreditNoteURL}" class="btn btn-primary">Add Credit Note</a>
  		</h1>
</section>

<section class="content">
 <div class="row">
 	 <div class="col-xs-12">
     	<div class="box">
            <div class="box-body">
            	<table id="creditnotes" class="display table table-bordered table-hover table-striped" cellspacing="0" width="100%">
					<thead>
			            <tr>
			                <th>Client Name</th>
			                <th>Credit Note Amount</th>
			                <th>Credit Note Tax</th>
			                <th>Payment Date</th>
			                <th>Payment Type</th>
			            </tr>
     			   </thead>
        		   <tbody>
            	      <c:forEach items="${creditNoteList }" var="creditNote">
            			<tr>
            				<td>${client.clientName}</td>
            				<td>${creditNote.creditNoteAmount}</td>
            				<td>${creditNote.creditNoteTax}</td>
            				<fmt:formatDate pattern = "dd/MM/yyyy" value = "${creditNote.paymentDate}" var="paymentDate"/>
			                <td>${paymentDate }</td>
			                <td>
			                <c:if test="${fn:length(creditNote.chequeNo) gt 0}">
			               		Cheque No : ${creditNote.chequeNo } (${creditNote.bankName })
			               	</c:if>
			               	 <c:if test="${fn:length(creditNote.chequeNo) eq 0}">
			               		 Cash
			               	</c:if>	
			               	</td>
			                <portlet:renderURL var="editCreditNoteURL">
       							 <portlet:param name="mvcRenderCommandName" value="/add_credit_note" />
       							 <portlet:param name="clientId" value="${ client.clientId}" />
       							 <portlet:param name="creditNoteId" value="${ creditNote.creditNoteId}" />
							</portlet:renderURL>
			                <td><a href="${editCreditNoteURL }" class="btn btn-block btn-primary">Edit</a></td>
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