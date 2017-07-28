<%@ include file="/init.jsp" %>
<portlet:renderURL var="addLandLordURL">
        <portlet:param name="mvcRenderCommandName" value="/add_land_lord" />
</portlet:renderURL>

<liferay-ui:success key="land-lord-added-successfully" message="land-lord-added-successfully"/>
<liferay-ui:success key="land-lord-updated-successfully" message="land-lord-updated-successfully"/>
<liferay-ui:success key="add-land-lord-payment-successfully" message="add-land-lord-payment-successfully"/>
<liferay-ui:success key="update-land-lord-payment-successfully" message="update-land-lord-payment-successfully"/>


<a href="${addLandLordURL}" class="btn btn-primary">Add Land Lord</a>

<section class="content">
 <div class="row">
 	 <div class="col-xs-12">
     	<div class="box">
            <div class="box-body">
            	<table id="landlords" class="display table table-bordered table-hover table-striped" cellspacing="0" width="100%">
					<thead>
			            <tr>
			                <th>First Name</th>
			                <th>Last Name</th>
			                <th>Location</th>
			                <th>City</th>
			                <th>Phone No</th>
			                <th>Action</th>
			            </tr>
     			   </thead>
        		   <tbody>
            	      <c:forEach items="${landLordList }" var="landLord">
            			<tr>
			                <td>${landLord.firstName }</td>
			                <td>${landLord.lastName }</td>
			                <td>${landLord.location }</td>
			                <td>${landLord.city }</td>
			                <td>${landLord.phoneNo }</td>
			                <portlet:renderURL var="editLandLordURL">
       							 <portlet:param name="mvcRenderCommandName" value="/add_land_lord" />
       							 <portlet:param name="landLordId" value="${ landLord.landLordId}" />
							</portlet:renderURL>
							<portlet:renderURL var="addPaymentURL">
       							 <portlet:param name="mvcRenderCommandName" value="/add_land_lord_payment" />
       							 <portlet:param name="landLordId" value="${ landLord.landLordId}" />
							</portlet:renderURL>
							<portlet:renderURL var="viewPaymentURL">
       							 <portlet:param name="mvcRenderCommandName" value="/viewPayment" />
       							 <portlet:param name="landLordId" value="${ landLord.landLordId}" />
							</portlet:renderURL>
			                <td>
			                	<a href="${editLandLordURL }" class="btn btn-block btn-primary">Edit</a>
			                	<a href="${addPaymentURL }" class="btn btn-block btn-primary">Add Payment</a>
			                	<a href="${viewPaymentURL }" class="btn btn-block btn-primary">Payment History</a>
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
            	 $('#landlords').DataTable({
            		 "pageLength": 50,
            		 "order": []
            	 });
            });
        })(jQuery);
    </script>     