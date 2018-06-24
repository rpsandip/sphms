<%@ include file="/init.jsp" %>
<portlet:renderURL var="addClientURL">
        <portlet:param name="mvcRenderCommandName" value="/prepare-proposal" />
</portlet:renderURL>

<portlet:resourceURL id="/getProposalList" var="getProposalListURL">
</portlet:resourceURL>

<liferay-ui:success key="proposal-added-successfully" message="proposal-added-successfully"/>
<liferay-ui:success key="delete-proposal-successs" message="delete-proposal-successs"/>
<liferay-ui:error key="delete-proposal-err" message="delete-proposal-err"/>



<a href="${addClientURL}" class="btn btn-primary">Add Proposal</a>

<section class="content">
 <div class="row">
 	 <div class="col-xs-12">
     	<div class="box">
            <div class="box-body">
	            <form id="filterProposal">
	              	<div class="form-group col-md-3">
	                  <select name="client" id="client" class="form-control">
						<option value="0">Select Client</option>
							<c:forEach items="${clientList }" var="client">
								<option value="${client.clientId }">${client.clientName }</option>
							</c:forEach>	
						</select>
	                </div>
	              	<div class="form-group col-md-3">
	                  <input type="text" class="form-control" name="searchStartDate" id="searchStartDate" placeholder="Start Date"/>
	                </div>
	                <div class="form-group col-md-3">
	                  <input type="text" class="form-control" name="searchEndDate" id="searchEndDate" placeholder="End Date"/>
	                </div>
	                <div class="form-group col-md-3">
	                  <input type=button class="btn btn-primary"  value="Search" id="filterSearch">
	                </div>
	              </form>
	              <br/>
	             <table id="proposals" class="display table table-bordered table-hover table-striped" cellspacing="0" width="100%">
            		<tbody></tbody>
            	</table>
            </div>
         </div>
      </div>
   </div>
</section>            	

<script type="text/javascript">
        var proposalDataTable="";
        jQuery.noConflict();
        (function($) {
            $(function() {  
            	 AUI().use('aui-base','liferay-portlet-url', function(A) {
            		 proposalDataTable =  $('#proposals').DataTable({
            		 "processing": true,
            	     "serverSide": true,
            	     "searching": false,
            	     "pageLength": 50,
            	     "bSort": false,
            	     "ajax": '${getProposalListURL}',
            		 "order": [],
            		 "columns": [
            	                    { "data": "campaign", "name" : "campaign", "title" : "Campaign"  },
            	                    { "data": "client", "name" : "client" , "title" : "Client"},
            	                    { "data": "startDate", "name" : "startDate" , "title" : "Start Date"},
            	                    { "data": "endDate", "name" : "endDate" , "title" : "End Date"},
            	                    { "data": "action", "name" : "Action" , "title" : "Action",
            	                    	"render": function(data, type, row, meta){
            	                    		var displayData="";
            	                    			var editPatientURL = Liferay.PortletURL.createRenderURL();
            	                    			editPatientURL.setParameter("proposalId",row.proposalId);
            	                    			editPatientURL.setPortletId("<%=themeDisplay.getPortletDisplay().getId() %>");
            	                    			editPatientURL.setParameter("mvcRenderCommandName","/view-proposal");
            	                    			displayData = '<a href="'+editPatientURL+'" class="btn btn-block btn-primary">View</a>';
            	                    			
            	                    			var deleteProposalURL = Liferay.PortletURL.createActionURL();
            	                    			deleteProposalURL.setParameter("proposalId",row.proposalId);
            	                    			deleteProposalURL.setPortletId("<%=themeDisplay.getPortletDisplay().getId() %>");
            	                    			deleteProposalURL.setName("/delete_proposal");
            	                    			
            	                    			displayData = displayData +  '<a href="'+deleteProposalURL+'" class="btn btn-block btn-primary">Delete</a>';
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
            	var startDate = $("#searchStartDate").val();
            	var endDate = $("#searchEndDate").val();
            	var getDocumentURL = '${getProposalListURL}&<portlet:namespace />clientId='+clientId+'&<portlet:namespace />searchStartDate='+startDate+'&<portlet:namespace />searchEndDate='+endDate;
                proposalDataTable.ajax.url(getDocumentURL).load();
			});  
        })(jQuery);
    </script>