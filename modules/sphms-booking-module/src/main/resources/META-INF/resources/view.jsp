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
          
          $('#startDate').datepicker({
        		format: 'dd/mm/yyyy',  
        	    autoclose: true
          }); 
          
          $('#endDate').datepicker({
      		format: 'dd/mm/yyyy',  
      	    autoclose: true
        }); 
            
          $("#filterSearch").on('click',function(){
            	var clientId = $("#client").val();
            	var startDate = $("#startDate").val();
            	var endDate = $("#endDate").val();
            	var getDocumentURL = '${getBookingListURL}&<portlet:namespace />searchClient='+clientId+'&<portlet:namespace />searchStartDate='+startDate+'&<portlet:namespace />searchEndDate='+endDate;
                bookingDataTable.ajax.url(getDocumentURL).load();
			});  
        })(jQuery);
</script>