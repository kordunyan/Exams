(function(){

    let app = {

        messages: {
            'single': 'Are you sure to delete this subject?',
            'many': 'This subject contains a lot of grades. Are you sure to delete it?',
        },

        initialize(){
            app.setListeners();
        },

        setListeners(){
            $(".form-delete-subject").on("submit", app.submitForm);
        },

        submitForm(e){
            e.preventDefault();
            let form = $(this);
            console.log(form.serialize());
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
                        $("#delete-subject-modal-content").html(app.messages["many"]);
                    }
                    else{
                        $("#delete-subject-modal-content").html(app.messages["single"]);
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