
$(function () {
    $(".preloader").fadeOut();
    $('#side-menu').metisMenu();
});


//Loads the correct sidebar on window load,
//collapses the sidebar on window resize.
// Sets the min-height of #page-wrapper to window size
$(function () {
    $(window).bind("load resize", function () {
        topOffset = 50;
        width = (this.window.innerWidth > 0) ? this.window.innerWidth : this.screen.width;
        if (width < 768) {
            $('div.navbar-collapse').addClass('collapse');
            topOffset = 100; // 2-row-menu
        } else {
            $('div.navbar-collapse').removeClass('collapse');
        }

        height = ((this.window.innerHeight > 0) ? this.window.innerHeight : this.screen.height) - 1;
        height = height - topOffset;
        if (height < 1) height = 1;
        if (height > topOffset) {
            $("#page-wrapper").css("min-height", (height) + "px");
        }
    });

    var url = window.location;
    var element = $('ul.nav a').filter(function () {
        return this.href == url || url.href.indexOf(this.href) == 0;
    }).addClass('active').parent().parent().addClass('in').parent();
    if (element.is('li')) {
        element.addClass('active');
    }
});

// Sidebar open close
$(document).ready(function () {
    $(".open-close").click(function () {
        $(".logotog").toggle("slow");
        $("body").toggleClass("content-wrapper");
    });
});

$(document).ready(function () {
    var date_input = $('input[name="date"]');
    var container = $('.bootstrap-iso form').length > 0 ? $('.bootstrap-iso form').parent() : "body";
    var options = {
        format: 'yyyy/mm/dd',
        container: container,
        todayHighlight: true,
        autoclose: true,
        daysOfWeekDisabled: '0',
        language: 'vi'
    };
    date_input.datepicker(options);
})


$(".tog").click(function () {
    this.src = togSrc.reverse()[0];
});

//progress
$(function () {
    $('.progress .progress-bar').css("width",
        function () {
            return $(this).attr("aria-valuenow") + "%";
        }
    )
});

//tooltip
$(function () {
    $('[data-toggle="tooltip"]').tooltip()
})


//Popup
$(document).ready(function () {
    placement: 'bottom',
        $('[data-toggle="popover"]').popover();
});

//Nicescroll
$(".sidebar").niceScroll({cursorcolor: '#ccc', cursorwidth: '5px', cursorborderradius: '0px'});


// Dropzone
$(document).ready(function () {
    $('.dropify').dropify();
});

$("#ckb-all").change(function () {
    $(".check-input").prop('checked', $(this).prop("checked"));
});

// Button
$("#btn-sw").click(function () {
    $("#cview-file").toggleClass('sw-right');
    $("#cview-info").toggleClass('sw-left');
});

$(document).ready(function () {
    var i = 0;

    var ctrlMode = false;
    $(document).keydown(function (e) {
        if (e.ctrlKey) {
            ctrlMode = true;
        }
        ;
    });

    $(document).keyup(function (e) {
        ctrlMode = false;
    });

    $(".photo-view").each(function (i) {
        var pview = document.getElementById("pic-view-" + [i]);
        var btnro = document.getElementById("btn-ro-" + [i]);
        var btnzin = document.getElementById("btn-zin-" + [i]);
        var btnzout = document.getElementById("btn-zout-" + [i]);

        var delta = 90;
        btnro.onclick = function (i) {
            pview.style.webkitTransform = "rotate(" + delta + "deg)";
            delta += 90;
        };

        btnzin.onclick = function (i) {
            pview.width = pview.width * 1.2;
        }

        btnzout.onclick = function (i) {
            pview.width = pview.width / 1.2;
        }

        $(document).keyup(function (e, i) {
            var e = window.event;
            if (e.ctrlKey) {

                if (e.which == 46) {
                    pview.style.webkitTransform = "rotate(" + delta + "deg)";
                    delta += 90;
                }

                if (e.which == 39) {
                    pview.width = pview.width * 1.2;
                }

                if (e.which == 37) {
                    pview.width = pview.width / 1.2;
                }
            }
        });

        i++;
    });
});

$(document).ready(function () {
    var i = 0;
    $(".thumbnail").each(function () {

        var btn = document.getElementById("btn-popup" + [i]);
        var modal = document.getElementById("file-popup" + [i]);
        var btnclbot = document.getElementById("cl-bot" + [i]);
        var btncltop = document.getElementById("cl-top" + [i]);


        i++;
    });
});

$(document).ready(function () {
    $(".editor").hover(function () {
        $('.toolbar').animate({right: '30px'}); //hien
    }, function () {
        $('.toolbar').animate({right: '-80px'});
    });
});

$(document).ready(function () {
    var resize = $("#left_panel");
    var resizetg = $("#content")
    var containerWidth = $("#main-view").width();

    $(resize).resizable({
        handles: 'e',
        maxWidth: 1400,
        minWidth: 320,
        resize: function (event, ui) {
            var currentWidth = ui.size.width;
            var padding = 12;
            $(this).width(currentWidth);
            $("#content").width(containerWidth - currentWidth - padding);
        }
    });

    $(resizetg).resizable({
        handles: 'e',
        maxWidth: 1580,
        minWidth: 500,
        resize: function (event, ui) {
            var currentWidth = ui.size.width;
            var padding = 12;
            $(this).width(currentWidth);
            $("#left_panel").width(containerWidth - currentWidth - padding);
        }
    });

});

$(function () {
    $.extend($.fn.dataTable.defaults, {
        autoWidth: false,
        columnDefs: [{
            orderable: false,
            width: '100px',
            targets: [5]
        }],

        dom: '<"datatable-header"fl><"datatable-scroll"t><"datatable-footer"ip>',
        language: {
            sZeroRecords: "Không tìm thấy thông tin",
            search: '<span>Filter:</span> _INPUT_',
            lengthMenu: '<span>Show:</span> _MENU_',
            paginate: {'first': 'First', 'last': 'Last', 'next': '&rarr;', 'previous': '&larr;'}
        },
        drawCallback: function () {
            $(this).find('tbody tr').slice(-3).find('.dropdown, .btn-group').addClass('dropup');
        },
        "bDestroy": true,
        preDrawCallback: function () {
            $(this).find('tbody tr').slice(-3).find('.dropdown, .btn-group').removeClass('dropup');
        }
    });




    $('.datatable-pagination').DataTable({
        pagingType: "simple",
        language: {
            paginate: {'next': 'Next &rarr;', 'previous': '&larr; Prev'}
        }
    });

    $('.datatable-save-state').DataTable({
        stateSave: true
    });

    $('.datatable-basic').DataTable({
        scrollY: 580,
    });

    $('.dataTables_filter input[type=search]').attr('placeholder', 'Search');

    /*
    $('.dataTables_length select').select2({
        minimumResultsForSearch: Infinity,
        width: 'auto'
    });
    */


});
function trimObj(obj) {
	  if (!Array.isArray(obj) && typeof obj != 'object') return obj;
	  return Object.keys(obj).reduce(function(acc, key) {
	    acc[key.trim()] = typeof obj[key] == 'string'? obj[key].trim() : trimObj(obj[key]);
	    return acc;
	  }, Array.isArray(obj)? []:{});
}




