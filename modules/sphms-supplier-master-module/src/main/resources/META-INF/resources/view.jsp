<%@ include file="/init.jsp" %>

<portlet:renderURL var="addSupplierURL">
        <portlet:param name="mvcRenderCommandName" value="/add_supplier" />
</portlet:renderURL>

<liferay-ui:success key="supplier-added-successfully" message="supplier-added-successfully"/>
<liferay-ui:success key="supplier-updated-successfully" message="supplier-updated-successfully"/>

<liferay-ui:success key="delete-supplier-success" message="delete-supplier-success"/>
<liferay-ui:error key="delete-supplier-error" message="delete-supplier-error"/>

<a href="${addSupplierURL}" class="btn btn-primary">Add Supplier</a>

<section class="content">
 <div class="row">
 	 <div class="col-xs-12">
     	<div class="box">
            <div class="box-body">
            	<table id="suppliers" class="display table table-bordered table-hover table-striped">
					<thead>
			            <tr>
			                <th>Supplier Name</th>
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
			            </tr>
     			   </thead>
        		   <tbody>
            	      <c:forEach items="${supplierList }" var="supplier">
            			<tr>
			                <td>${supplier.supplierName }</td>
			                <td>${supplier.address1 }</td>
			                <td>${supplier.address2 }</td>
			                <td>${supplier.city }</td>
			                <td>${supplier.state }</td>
			                <td>${supplier.contactPersonName }</td>
			                <td>${supplier.contactPersonEmail }</td>
			                <td>${supplier.contactPersonPhoneNo }</td>
			                <td>${supplier.panNo }</td>
			                <td>${supplier.gstNo }</td>
			                <portlet:renderURL var="editSupplierURL">
       							 <portlet:param name="mvcRenderCommandName" value="/add_supplier" />
       							 <portlet:param name="supplierId" value="${ supplier.supplierId}" />
							</portlet:renderURL>
							<portlet:actionURL var="deleteSupploerURL" name="/delete_supplier">
			                	 <portlet:param name="supplierId" value="${ supplier.supplierId}" />
							</portlet:actionURL>
			                <td>
			                	<a href="${editSupplierURL }" class="btn btn-block btn-primary">Edit</a>
				                <a href="${deleteSupploerURL }" class="btn btn-block btn-primary">Delete</a>
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
            	 $('#suppliers').DataTable({
            		 "pageLength": 50,
            		 "order": []
            	 });
            	 
            	 $("#suppliers").removeClass("dataTable");
            });
        })(jQuery);
 </script>