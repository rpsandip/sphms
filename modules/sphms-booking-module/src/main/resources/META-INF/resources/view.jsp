<%@ include file="/init.jsp" %>

<portlet:renderURL var="addBookingURL">
        <portlet:param name="mvcRenderCommandName" value="/prepare_booking" />
</portlet:renderURL>

<portlet:resourceURL id="/getBookingList" var="getBookingListURL">
</portlet:resourceURL>

<liferay-ui:success key="booking-added-successfully" message="booking-added-successfully"/>
<liferay-ui:success key="booking-updated-successfully" message="booking-updated-successfully"/>

<liferay-ui:success key="booking-delete-success" message="booking-delete-success"/>
<liferay-ui:error key="booking-delete-error" message="booking-delete-error"/>


<a href="${addBookingURL}" class="btn btn-primary">Add Booking</a>

<section class="content">
 <div class="row">
 	 <div class="col-xs-12">
     	<div class="box">
            <div class="box-body">
	              <form id="filterProposal">
	              	
	              	<div class="form-group col-md-2">
	                  <select name="customCompany" id="customCompany" class="form-control">
						<option value="0">Select Company</option>
							<c:forEach items="${companyList }" var="company">
								<option value="${company.companyId }">${company.name }</option>
							</c:forEach>	
						</select>
	                </div>
	                
	              	<div class="form-group col-md-2">
	                  <select name="client" id="client" class="form-control">
						<option value="0">Select Client</option>
							<c:forEach items="${clientList }" var="client">
								<option value="${client.clientId }">${client.clientName }</option>
							</c:forEach>	
						</select>
	                </div>
	                
	                <div class="form-group col-md-2">
	                  <select name="status" id="status" class="form-control">
						<option value="">Select Status</option>
							<option value="0">Active</option>
							<option value="1">In Active</option>
						</select>
	                </div>
	                
	              	<div class="form-group col-md-3">
	                  <input type="text" class="form-control" name="searchStartDate" id="searchStartDate" placeholder="Start Date"/>
	                </div>
	                <div class="form-group col-md-3">
	                  <input type="text" class="form-control" name="searchEndDate" id="searchEndDate" placeholder="End Date"/>
	                </div>
	                <div class="form-group col-md-2">
	                  <input type=button class="btn btn-primary"  value="Search" id="filterSearch">
	                </div>
	              </form>
	              <br/>
	             <table id="bookings" class="display table table-bordered table-hover table-striped" cellspacing="0" width="100%">
            		<tbody></tbody>
            	</table>
            </div>
         </div>
      </div>
   </div>
</section>            	

<script type="text/javascript">
        var bookingDataTable="";
        jQuery.noConflict();
        (function($) {
            $(function() {  
            	 AUI().use('aui-base','liferay-portlet-url', function(A) {
            		 
            		 var resourceURL= Liferay.PortletURL.createResourceURL();
            		 resourceURL.setPortletId('com_booking_portlet_portlet_BookongModulePortlet');
            		 resourceURL.setResourceId('/getBookingList');
            		 
            		 bookingDataTable =  $('#bookings').DataTable({
            		 "processing": true,
            	     "serverSide": true,
            	     "searching": false,
            	     "bSort": false,
            	     "pageLength": 50,
            	     "ajax": resourceURL.toString(),
            		 "order": [],
            		 "columns": [
            	                    { "data": "campaign", "name" : "campaign", "title" : "Campaign"  },
            	                    { "data": "client", "name" : "client" , "title" : "Client"},
            	                    { "data": "startDate", "name" : "startDate" , "title" : "Start Date"},
            	                    { "data": "endDate", "name" : "endDate" , "title" : "End Date"},
            	                    { "data": "status", "name" : "status" , "title" : "Status"},
            	                    { "data": "action", "name" : "Action" , "title" : "Action",
            	                    	"render": function(data, type, row, meta){
            	                    		var displayData="";
            	                    			var viewBookingURL = Liferay.PortletURL.createRenderURL();
            	                    			viewBookingURL.setParameter("bookingId",row.bookingId);
            	                    			viewBookingURL.setPortletId("<%=themeDisplay.getPortletDisplay().getId() %>");
            	                    			viewBookingURL.setParameter("mvcRenderCommandName","/view-booking");
            	                    			displayData = '<a href="'+viewBookingURL+'" class="btn btn-block btn-primary">View</a>';
            	                    			
            	                    			var viewBookingURL = Liferay.PortletURL.createRenderURL();
            	                    			viewBookingURL.setParameter("bookingId",row.bookingId);
            	                    			viewBookingURL.setPortletId("<%=themeDisplay.getPortletDisplay().getId() %>");
            	                    			viewBookingURL.setParameter("mvcRenderCommandName","/prepare_booking");
            	                    			displayData = displayData +   '<a href="'+viewBookingURL+'" class="btn btn-block btn-primary">Edit</a>';
            	                    			
            	                    			var deleteBookingURL = Liferay.PortletURL.createActionURL();
            	                    			deleteBookingURL.setParameter("bookingId",row.bookingId);
            	                    			deleteBookingURL.setPortletId("<%=themeDisplay.getPortletDisplay().getId() %>");
            	                    			deleteBookingURL.setName("/delete_booking");
            	                    			displayData = displayData +   '<a href="'+deleteBookingURL+'" class="btn btn-block btn-primary">Delete</a>';
            	                    			
            	                    		return displayData;
            	                    	 }
            	                    }
            	                ]
            	 });
            });
          });
          
          $('#searchStartDate').datepicker({
        		format: 'dd/mm/yyyy',  
        	    autoclose: true
          }); 
          
          $('#searchEndDate').datepicker({
      		format: 'dd/mm/yyyy',  
      	    autoclose: true
        }); 
            
          $("#filterSearch").on('click',function(){
            	var clientId = $("#client").val();
            	var companyId = $("#customCompany").val();
            	var startDate = $("#searchStartDate").val();
            	var endDate = $("#searchEndDate").val();
            	var status = $("#status").val();
            	var getDocumentURL = '${getBookingListURL}&<portlet:namespace />status='+status+'&<portlet:namespace />customCompany='+companyId+'&<portlet:namespace />searchclient='+clientId+'&<portlet:namespace />searchStartDate='+startDate+'&<portlet:namespace />searchEndDate='+endDate;
                bookingDataTable.ajax.url(getDocumentURL).load();
			});  
        })(jQuery);
</script>