$(function () {
    $.fn.spinner = function (options) {
        var _default = {
            max: null,
            min: null,
            step: 1,
            change: null,
            add: null,
            sub: null
        };
        options = $.extend(_default, options);
        this.each(function () {
            $(this)
                .attr('readonly', true)
                .css({'text-align': 'center'})
                .wrap('<div class="input-prepend input-append bootstrap-spinner">');
            var $parent = $(this).parent(".input-prepend");
            $parent.append('<span class="add-on bootstrap-spinner-add" style="cursor:pointer">+</span>')
                .prepend('<span class="add-on bootstrap-spinner-sub" style="cursor:pointer">-</span>');

        });
        $(document).on("click", ".bootstrap-spinner-add",function () {
            var $input = $(this).prev("input");
            if ($input.length > 0) {
                var val = parseInt($input.val());
                var _val = val + options.step;
                if (options.max === null || (options.max !== null && _val <= options.max)) {
                    $input.val(_val);
                    if (options.change) options.change($input.get(0));
                    if (options.add) options.add($input.get(0));
                }
            }
        }).on("click", ".bootstrap-spinner-sub", function () {
                var $input = $(this).next("input");
                if ($input.length > 0) {
                    var val = parseInt($input.val());
                    var _val = val - options.step;
                    if (options.min === null || (options.min !== null && _val >= options.min)) {
                        $input.val(_val);
                        if (options.change) options.change($input.get(0));
                        if (options.sub) options.sub($input.get(0));
                    }
                }
            });
        return this;
    }
});