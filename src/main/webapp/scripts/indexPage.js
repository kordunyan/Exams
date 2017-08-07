(function(){

    let app = {

        messages: {
            'single':{
                'en':'Are you sure to delete this subject?',
                'ua':'Видалити даний предмет?'
            },
            'many': {
                'en':'This subject contains a lot of grades. Are you sure to delete it?',
                'ua':'Даний предмет містить оцінки. Видалити даний предмет?'
            }
        },

        locale:'en',

        initialize(){
            if($.cookie('locale') != null){
                app.locale = $.cookie('locale');
            }
            app.setListeners();
        },

        setListeners(){
            $(".form-delete-subject").on("submit", app.submitForm);
        },

        submitForm(e){
            e.preventDefault();
            let form = $(this);
            let link = $(location).attr("protocol")+ "//" + $(location).attr("host")+  $(location).attr("pathname")+ "subject/countexams";
            $.ajax({
                url: link,
                type: "POST",
                data: form.serialize()
            }).fail(function(){
                console.log("Fail");
            })
            .always(function(msg){

            })
            .done(function(msg){
                if(msg["status"]){
                    if(msg["count"] !== 0){
                        $("#delete-subject-modal-content").html(app.messages["many"][app.locale]);
                    }
                    else{
                        $("#delete-subject-modal-content").html(app.messages["single"][app.locale]);
                    }
                    $("#input-delete-subject").val(msg["subject"]);
                    $('#countedSubject').modal('toggle');
                }
                else{
                    $('#error-modal').modal('toggle');
                }
            });
        }
    };

    app.initialize();

})();