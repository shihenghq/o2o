var SUCCCESS_MSG = '成功';
var ERROR_MSG = '错误';
var WARRYING_MSG = '错误';
function progressLoad(){
$("<div class=\"wrapper wrapper-content animated fadeInRight\" style=\"position:absolute;z-index: 9999;\">")
    .append("<div class=\"row\">")
      .append("<div class=\"col-sm-12\">")
        .append("<div class=\"sk-spinner sk-spinner-three-bounce\">")
           .append("<div class=\"sk-bounce1\"></div>")
           .append("<div class=\"sk-bounce2\"></div>")
           .append("<div class=\"sk-bounce3\"></div>")
        .append("</div>")
      .append("</div>")
    .append("</div>")
  .append("</div>")
  .css({display:"block",width:"100%",height:$(window).height()})
  .appendTo("body");
}

/**
 *
 * @requires jQuery
 *
 * 防止退格键导致页面回退
 */
$(document).keydown(function (e) {
  var doPrevent;
  if (e.keyCode == 8) {
    var d = e.srcElement || e.target;
    if (d.tagName.toUpperCase() == 'INPUT' || d.tagName.toUpperCase() == 'TEXTAREA') {
      doPrevent = d.readOnly || d.disabled;
    }else{
      doPrevent = true;
    }
  }else{
    doPrevent = false;
  }
  if (doPrevent)
    e.preventDefault();
});

toastr.options = {
  "closeButton": true,
  "debug": false,
  "progressBar": true,
  "positionClass": "toast-bottom-right",
  "onclick": null,
  "showDuration": "400",
  "hideDuration": "1000",
  "timeOut": "7000",
  "extendedTimeOut": "1000",
  "showEasing": "swing",
  "hideEasing": "linear",
  "showMethod": "fadeIn",
  "hideMethod": "fadeOut"
};
