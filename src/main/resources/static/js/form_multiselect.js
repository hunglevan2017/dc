$(function () {

    $('.multiselect').multiselect({
        onChange: function () {
            $.uniform.update();
        }
    });

    // Select all/Deselect all
    function multiselect_selected($el) {
        var ret = true;
        $('option', $el).each(function (element) {
            if (!!!$(this).prop('selected')) {
                ret = false;
            }
        });
        return ret;
    }

    function multiselect_selectAll($el) {
        $('option', $el).each(function (element) {
            $el.multiselect('select', $(this).val());
        });
    }

    function multiselect_deselectAll($el) {
        $('option', $el).each(function (element) {
            $el.multiselect('deselect', $(this).val());
        });
    }

    function multiselect_toggle($el, $btn) {
        if (multiselect_selected($el)) {
            multiselect_deselectAll($el);
            $btn.text("Select All");
        }
        else {
            multiselect_selectAll($el);
            $btn.text("Deselect All");
        }
    }

    // Initialize
    $('.multiselect-toggle-selection').multiselect();

    // Toggle selection on button click
    $(".multiselect-toggle-selection-button").click(function (e) {
        e.preventDefault();
        multiselect_toggle($(".multiselect-toggle-selection"), $(this));
        $.uniform.update();
    });


    // Styled checkboxes and radios
    $(".styled, .multiselect-container input").uniform({radioClass: 'choice'});

});
