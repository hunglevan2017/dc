    function replaceAll(str, find, replace) {
    	return str.replace(new RegExp(find, 'g'), replace);
	}
    function trimObj(obj) {
    	  if (!Array.isArray(obj) && typeof obj != 'object') return obj;
    	  return Object.keys(obj).reduce(function(acc, key) {
    	    acc[key.trim()] = typeof obj[key] == 'string'? obj[key].trim() : trimObj(obj[key]);
    	    return acc;
    	  }, Array.isArray(obj)? []:{});
    }
    function ConvertFormToJSON(form){
        var array = jQuery(form).serializeArray();
        var json = {};
        
        jQuery.each(array, function() {
            json[this.name] = this.value || '';
        });
        
        return json;
    }
    
	function resetDivToDefault(div_id, table_id) {
		var table = '<table class="table table-striped table-bordered table-hover " id="' + table_id + '">';
		table += ' <thead ></thead>';
		table += ' <tbody></tbody>';
		table += ' </table>';
		$('#' + div_id).html(table);
	}
	

	function popupModalAdd(url) {
		$.ajax({
			type : 'GET',
			url : url,
			beforeSend : function() {
			},
			error : function(error) {
				console.log(error);
			},
			success : function(data) {
				//console.log(data);
				//alert(data);
				//console.log(data);
				$('#modal-confirm').html(data);
				$('#modal-confirm').modal('show');
			},
			complete : function() {
				// alert(1);
			}
		});
	}
	
	