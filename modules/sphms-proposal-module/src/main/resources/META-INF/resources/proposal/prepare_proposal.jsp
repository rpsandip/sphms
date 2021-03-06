<%@ include file="../init.jsp" %>

<portlet:actionURL var="addProposalURL" name="/add_proposal">
</portlet:actionURL>

<portlet:resourceURL id="/search_hording" var="searchHordingActionURL" />

<portlet:renderURL var="addProposalURL">
        <portlet:param name="mvcRenderCommandName" value="/add_proposal" />
</portlet:renderURL>

<liferay-ui:error key="select-start-end-date" message="select-start-end-date"/>

<section class="content-header">
	<h1>
    	<liferay-ui:message key="select.hording"/> 
  	</h1>
  	<div>
  		<div id="selectedHordings"></div>
  	</div><br/>
  	<div style="clear: both;padding-bottom: 5px;" class="pull-right">
  		<a class="btn btn-primary add-proposal"> Continue to Create Proposal</a>
  	</div>
</section>
<br/>
<div class="row pad-10">
	<div class="col-xs-12">
    	<div class="box">
       		<div class="box-body">
	 	<div class="col-md-3">
			<div class="box box-solid">
				 <aui:form name="searchHordingFrm" action="${searchHordingActionURL}" cssClass="row contact_form">

				 <div class="form-group col-md-12">
					<aui:input type="text" name="keyword" label="keyword"/>
			   	 </div> 
				 <div class="form-group col-md-12">
						<aui:input type="text" name="city" label="city"/>
				 </div>
				 <div class="form-group col-md-12">
						<aui:input type="text" name="distinct" label="Distinct"/>
				 </div>
				 <div class="form-group col-md-12">
				 	<aui:input type="text" name="width" label="width">
				 		<aui:validator name="number"></aui:validator>
				 	</aui:input>
				 </div>
				 <div class="form-group col-md-12">
				 	<aui:input type="text" name="height" label="height">
				 		<aui:validator name="number"></aui:validator>
				 	</aui:input>
				 </div>
				 <div class="form-group col-md-12">
				 	<aui:input name="startDate" label="start.date" cssClass="form-control">
				 		<aui:validator name="required"></aui:validator>
				 	</aui:input> 
				 </div>
				  <div class="form-group col-md-12">
				 	<aui:input name="endDate" label="end.date" cssClass="form-control">
				 		<aui:validator name="required"></aui:validator>
				 	</aui:input> 
				 </div>
				 <div class="col-sm-12">
                       	<aui:button type="button" value="Search"  cssClass="submitserarchBtn btn btn-primary"/>
                 </div>
                 <aui:input type="hidden" name="selectedhordings"/>
                </aui:form>
			</div>
	    </div>
	    
	    <div class="col-md-9">
	    	<div class="row">
 	 			<div class="col-xs-12">
           			<div class="box-body">
						<table id="hordinglist" class="display table table-bordered table-hover table-striped" cellspacing="0" width="100%">
       						<tbody>
       						</tbody>
       					</table>
        			</div>
        		</div>
        	</div>					
	    </div>
	 </div>
	</div>
</div>
</div>	 
</section>	

<script type="text/javascript">
var hordinfDataTable;
var selectedHordings = new Array();
var proposalFn={};
jQuery.noConflict();
(function($) {
    $(function() {
    	
     AUI().use('aui-base','liferay-portlet-url', function(A) {
    	
	  //Date picker
	  $('#'+ '<portlet:namespace/>' + 'startDate').datepicker({
		format: 'dd/mm/yyyy',  
	    autoclose: true
	  });
	  
	  $('#'+ '<portlet:namespace/>' + 'endDate').datepicker({
			format: 'dd/mm/yyyy',  
		    autoclose: true
	  });
	  
	  
		  // TODO : Need some work here 
		  var keyword = "dcdsavjkdsnvjkvdnvjkdvndsjknvjvnjnvnj";//$('#'+ '<portlet:namespace/>' + 'keyword').val();
		  var city = $('#'+ '<portlet:namespace/>' + 'city').val();
		  var distinct = $('#'+ '<portlet:namespace/>' + 'distinct').val();
		  var height = $('#'+ '<portlet:namespace/>' + 'height').val();
		  var width = $('#'+ '<portlet:namespace/>' + 'width').val();
		  var startDate = $('#'+ '<portlet:namespace/>' + 'startDate').val();
		  var endDate = $('#'+ '<portlet:namespace/>' + 'endDate').val();
		  
		  var searchHordingURL = '${searchHordingActionURL}&<portlet:namespace />keyword='+keyword+'&<portlet:namespace />city='+city+'&<portlet:namespace />distinct='+distinct
		  +'&<portlet:namespace />height='+height+'&<portlet:namespace />width='+width+'&<portlet:namespace />startDate='+startDate+
		  '&<portlet:namespace />endDate='+endDate;
		  
		  hordinfDataTable =  $('#hordinglist').DataTable({
     		 "processing": true,
     	     "serverSide": true,
     	     "searching": false,
     	     "bSort": false,
     	     "ajax": searchHordingURL,
     		 "order": [],
     		 "columns": [
     	                    { "data": "hording", "name" : "hording" , "title" : "Hordings",
     	                    	"render": function(data, type, row, meta){
     	                    		return renderHordingDate(data);
     	                    	 }
     	                    }
     	                ]
     	 });
    
    
    var renderHordingDate = function(data){
    	var dataHtml='';
    	var isHordingSelect = proposalFn.isHordingSelected(data.hordingId);
    	var selectBtnDiv = "";
    	if(!isHordingSelect){
    		selectBtnDiv = '<div class="hording'+data.hordingId+'">'+
			'<span class="pull-right select-hording btn btn-primary"> Select </span>'+
			'</div>';
    	}else{
    		selectBtnDiv = '<div class="hording'+data.hordingId+'">'+
			'<span class="pull-right select-hording btn btn-primary"> Already Selected </span>'+
			'</div>';
    	}
    	dataHtml+='<div class="row">'+
					'<div class="col-md-4">'+
						'<img src="'+data.normalImageURL+'" style="height:3.8cm;width: 6.0cm;">'+
					'</div>'+
					'<div class="col-md-8">'+
						'<div class="hording-detail" data-hordingId="'+data.hordingId+'">'+
							'<span class="pull-left">'+
								'<h4 class="title">'+data.title+', '+data.city+'</h3>'+
							'</span>'+
							'<span class="pull-right">'+
								'<h4>Rs. '+data.pricePerMonth+'/PM</h4>'+
							'</span>'+
						'</div>'+
						'<div style="clear: both;">'+
							'<span><b>Type:</b> '+data.hordingType+' </span>'+
						'</div>'+
						'<div style="clear: both;">'+
							'<b>Size :</b> '+data.size+'(Sq. Ft)'+
						'</div>'+
						'<div style="clear: both;">'+
							'<b>Land Lord : </b> '+ data.landLordName+
						'</div>'+
						selectBtnDiv +
					'</div>'+
				  '</div>';
				  return dataHtml;
    }
    
    
    $(".submitserarchBtn").on('click',function(){
    	
    	var formValidator = Liferay.Form.get('<portlet:namespace />searchHordingFrm').formValidator;
		formValidator.validate();
		if(formValidator.hasErrors()){
			return false;
		}
    	
    	var keyword = $('#'+ '<portlet:namespace/>' + 'keyword').val();
		  var city = $('#'+ '<portlet:namespace/>' + 'city').val();
		  var distinct = $('#'+ '<portlet:namespace/>' + 'distinct').val();
		  var height = $('#'+ '<portlet:namespace/>' + 'height').val();
		  var width = $('#'+ '<portlet:namespace/>' + 'width').val();
		  var startDate = $('#'+ '<portlet:namespace/>' + 'startDate').val();
		  var endDate = $('#'+ '<portlet:namespace/>' + 'endDate').val();
		  
		  var searchHordingURL = '${searchHordingActionURL}&<portlet:namespace />keyword='+keyword+'&<portlet:namespace />city='+city+'&<portlet:namespace />distinct='+distinct+
		  '&<portlet:namespace />height='+height+'&<portlet:namespace />width='+width+'&<portlet:namespace />startDate='+startDate+
		  '&<portlet:namespace />endDate='+endDate;
		  
		  hordinfDataTable.ajax.url(searchHordingURL).load();
    });
    
    $(document).on('click', '.select-hording', function() {
    	var hordingId = $(this).parent().parent().find(".hording-detail").data("hordingid");
    	if(!proposalFn.isHordingSelected(hordingId)){
	    	var hordingTitle = $(this).parent().parent().find("h4.title").text();
	    	var hordingObj ={};
	    	hordingObj.hordingId = hordingId;
	    	hordingObj.title = hordingTitle;
	    	selectedHordings.push(hordingObj);
	    	$("#selectedHordings").append('<div class="bb-badges pull-right" >'+hordingTitle+'<span data-hordingId="'+ hordingId +'" class="deleteSelectedHording handHover">&nbsp;X</span> </div>');
	    	proposalFn.prepareSelectedHordingList();
	    	$(this).text("Already Selected");
    	}
    });
    
    $(document).on('click', '.deleteSelectedHording', function() {
    	for(var i=0;i<selectedHordings.length;i++){
				if($(this).data("hordingid")===selectedHordings[i].hordingId){
					selectedHordings.splice(i,1);
					$(this).parent().remove();
				}
		}
    	proposalFn.prepareSelectedHordingList();
    	$(".hording"+$(this).data("hordingid")+" span").text("Select");
    });
    
    $(document).on('click', '.add-proposal', function() {
    	var addProposalURL = '${addProposalURL}';
    	
    	var formValidator = Liferay.Form.get('<portlet:namespace />searchHordingFrm').formValidator;
		formValidator.validate();
		if(formValidator.hasErrors()){
			return false;
		}
    	
    	var selectedHordingList = $("#<portlet:namespace/>selectedhordings").val();
    	addProposalURL = addProposalURL + "&<portlet:namespace/>selectedHordingIds="+selectedHordingList+"&<portlet:namespace/>startDate="+A.one("#<portlet:namespace />startDate").val()+"&<portlet:namespace/>endDate="+A.one("#<portlet:namespace />endDate").val();;
    	window.location.href=addProposalURL;
    });
    
    proposalFn.prepareSelectedHordingList = function(){
    	var selectedHordingIds = "";
    	for(var i=0;i<selectedHordings.length;i++){
    		selectedHordingIds=selectedHordingIds+selectedHordings[i].hordingId+",";
		}
    	$("#<portlet:namespace/>selectedhordings").val(selectedHordingIds);
    }
    
    proposalFn.isHordingSelected = function(hordingId){
    	var selectedHordingList = $("#<portlet:namespace/>selectedhordings").val();
    	if(selectedHordingList.indexOf(hordingId)>=0){
    		return true;
    	}else{
    		return false;
    	}
    }

	  });
    });
    
})(jQuery);
</script>