<%@ include file="/init.jsp" %>

<portlet:renderURL var="addBookingURL">
        <portlet:param name="mvcRenderCommandName" value="/prepare_booking" />
</portlet:renderURL>

<portlet:resourceURL id="/getBookingList" var="getBookingListURL">
</portlet:resourceURL>

<liferay-ui:success key="booking-added-successfully" message="booking-added-successfully"/>

<a href="${addBookingURL}" class="btn btn-primary">Add Booking</a>

<section class="content">
 <div class="row">
 	 <div class="col-xs-12">
     	<div class="box">
            <div class="box-body">
	            <form id="filterBookign">
	              	<div class="form-group col-md-3">
	                  <select name="client" id="client" class="form-control">
						<option value="0">Select Client</option>
							<c:forEach items="${clientList }" var="client">
								<option value="${client.clientId }">${client.clientName }</option>
							</c:forEach>	
						</select>
	                </div>
	              	<div class="form-group col-md-3">
	                  <input type="text" class="form-control" name="startDate" id="startDate" placeholder="Start Date"/>
	                </div>
	                <div class="form-group col-md-3">
	                  <input type="text" class="form-control" name="endDate" id="endDate" placeholder="End Date"/>
	                </div>
	                <div class="form-group col-md-3">
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
            		 bookingDataTable =  $('#bookings').DataTable({
            		 "processing": true,
            	     "serverSide": true,
            	     "searching": false,
            	     "pageLength": 50,
            	     "ajax": '${getBookingListURL}',
            		 "order": [],
            		 "columns": [
            	                    { "data": "campaign", "name" : "campaign", "title" : "Campaign"  },
            	                    { "data": "client", "name" : "client" , "title" : "Client"},
            	                    { "data": "startDate", "name" : "startDate" , "title" : "Start Date"},
            	                    { "data": "endDate", "name" : "endDate" , "title" : "End Date"},
            	                    { "data": "action", "name" : "Action" , "title" : "Action",
            	                    	"render": function(data, type, row, meta){
            	                    		var displayData="";
            	                    			var viewBookingURL = Liferay.PortletURL.createRenderURL();
            	                    			viewBookingURL.setParameter("bookingId",row.bookingId);
            	                    			viewBookingURL.setPortletId("<%=themeDisplay.getPortletDisplay().getId() %>");
            	                    			viewBookingURL.setParameter("mvcRenderCommandName","/view-booking");
            	                    			displayData = '<a href="'+viewBookingURL+'" class="btn btn-block btn-primary">View Booking</a>';
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
            	var getDocumentURL = '${getBookingListURL}&<portlet:namespace />clientId='+clientId+'&<portlet:namespace />startDate='+startDate+'&<portlet:namespace />endDate='+endDate;
                bookingDataTable.ajax.url(getDocumentURL).load();
			});  
        })(jQuery);
</script>