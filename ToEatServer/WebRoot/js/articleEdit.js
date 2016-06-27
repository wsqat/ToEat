
	function initEditor() {
        $('#content').ckeditor();//控件1
        CKEDITOR.on('dialogDefinition', function(ev) {
            var dialogName = ev.data.name;
            var dialogDefinition = ev.data.definition;
            var dd = ev.data.definition;
            
            if(dialogName == 'image') {
            	
                dialogDefinition.onLoad = function () {
                	
                   var dialog = CKEDITOR.dialog.getCurrent(); 
                   $("td.cke_dialog_ui_hbox_first:first input.cke_dialog_ui_input_text").attr("readonly","true");
                   // show upload tab 
                   this.selectPage('Upload');
                   
                   // optional:
                   dialog.hidePage( 'Link' ); 
                   dialog.hidePage( 'advanced' ); 

                   var uploadTab = dialogDefinition.getContents('Upload');
                   var uploadButton = uploadTab.get('uploadButton');
                   uploadButton['filebrowser']['onSelect'] = function( fileUrl, errorMessage ) {
                      //$("input.cke_dialog_ui_input_text").val(fileUrl);
                      dialog.getContentElement('info', 'txtUrl').setValue(fileUrl);
                      $(".cke_dialog_ui_button_ok span").click();
                   }
                };

             }
            
            if(dialogName == 'link') {
                
                dialogDefinition.onLoad = function () {
                	
                   var dialog = CKEDITOR.dialog.getCurrent(); 
                   $("td.cke_dialog_ui_hbox_last input.cke_dialog_ui_input_text").attr("readonly","true");
                    
                   dialogDefinition.onShow = function () {
               	    var uploadTab = dialogDefinition.getContents( 'upload' );
   	                var uploadButton = uploadTab.get('uploadButton');
   	                uploadButton['filebrowser']['onSelect'] = function( fileUrl, errorMessage ) {
   	                	dialog.getContentElement('info', 'url' ).setValue(fileUrl);
//   	                	$("input.cke_dialog_ui_input_text").val(fileUrl);
   	                	$(".cke_dialog_ui_button_ok span").click();
   	                }
                };
             }
            }
        })
        
    }