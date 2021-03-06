<%@ include file="/init.jsp" %>

<portlet:renderURL var="addClientURL">
        <portlet:param name="mvcRenderCommandName" value="/add_client" />
</portlet:renderURL>

<liferay-ui:success key="client-added-successfully" message="client-added-successfully"/>
<liferay-ui:success key="client-updated-successfully" message="client-updated-successfully"/>

<liferay-ui:success key="credit-note-add-success" message="credit-note-add-success"/>
<liferay-ui:success key="credit-note-update-success" message="credit-note-update-success"/>


<liferay-ui:success key="delete-client-success" message="delete-client-success"/>
<liferay-ui:error key="delete-client-error" message="delete-client-error"/>

<a href="${addClientURL}" class="btn btn-primary">Add Client</a>

<section class="content">
 <div class="row">
 	 <div class="col-xs-12">
     	<div class="box">
            <div class="box-body">
            	<table id="clients" class="display table table-bordered table-hover table-striped">
					<thead>
			            <tr>
			                <th>Client Name</th>
			                <th>Address1</th>
			                <th>Address2</th>
			                <th>City</th>
			                <th>State</th>
			                <th>Contact Person Name</th>
			                <th>Contact Person Email</th>
			                <th>Contact Person Phone No</th>
			                <th>PAN No</th>
			                <th>GST No</th>
			                <th>Action</th>
			                <th>Credit Note</th>
			            </tr>
     			   </thead>
        		   <tbody>
            	      <c:forEach items="${clientList }" var="client">
            			<tr>
			                <td>${client.clientName }</td>
			                <td>${client.address1 }</td>
			                <td>${client.address2 }</td>
			                <td>${client.city }</td>
			                <td>${client.state }</td>
			                <td>${client.contactPersonName }</td>
			                <td>${client.contactPersonEmail }</td>
			                <td>${client.contactPersonPhoneNo }</td>
			                <td>${client.panNo }</td>
			                <td>${client.gstNo }</td>
			                <portlet:renderURL var="editClientURL">
       							 <portlet:param name="mvcRenderCommandName" value="/add_client" />
       							 <portlet:param name="clientId" value="${ client.clientId}" />
							</portlet:renderURL>
							<portlet:actionURL var="deleteClientURL" name="/delete_client">
			                	 <portlet:param name="clientId" value="${ client.clientId}" />
							</portlet:actionURL>
			                <td>
			                	<a href="${editClientURL }" class="btn btn-block btn-primary">Edit</a>
				                <a href="${deleteClientURL }" class="btn btn-block btn-primary">Delete</a>
			                </td>
			               
			                <portlet:renderURL var="creditNoteURL">
       							 <portlet:param name="mvcRenderCommandName" value="/credit_note" />
       							 <portlet:param name="clientId" value="${ client.clientId}" />
							</portlet:renderURL>
			                <td>
			                	<a href="${creditNoteURL}" class="btn btn-block btn-primary">Credit Note</a>
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
            	 $('#clients').DataTable({
            		 "pageLength": 50,
            		 "order": []
            	 });
            	 
            	 $("#clients").removeClass("dataTable");
            });
        })(jQuery);
 </script>