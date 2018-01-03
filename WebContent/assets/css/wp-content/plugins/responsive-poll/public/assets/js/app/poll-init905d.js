jQuery(function($){

    setTimeout(function(){
        $("canvas[data-weblator-poll-id]").each(function(){
            new Poll($(this).data("weblator-poll-id"));
        });
    }, 1000);

});