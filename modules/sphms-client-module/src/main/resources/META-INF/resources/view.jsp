<%@ include file="/init.jsp" %>

<portlet:renderURL var="addClientURL">
        <portlet:param name="mvcRenderCommandName" value="/add_client" />
</portlet:renderURL>

<liferay-ui:success key="client-added-successfully" message="client-added-successfully"/>
<liferay-ui:success key="client-updated-successfully" message="client-updated-successfully"/>

<a href="${addClientURL}" class="btn btn-primary">Add Client</a>

<section class="content">
 <div class="row">
 	 <div class="col-xs-12">
     	<div class="box">
            <div class="box-body">
            	<table id="clients" class="display table table-bordered table-hover table-striped" cellspacing="0" width="100%">
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
			                <th>Action</th>
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
			                <portlet:renderURL var="editClientURL">
       							 <portlet:param name="mvcRenderCommandName" value="/add_client" />
       							 <portlet:param name="clientId" value="${ client.clientId}" />
							</portlet:renderURL>
			                <td>
			                	<a href="${editClientURL }" class="btn btn-block btn-primary">Edit</a>
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
            });
        })(jQuery);
 </script>