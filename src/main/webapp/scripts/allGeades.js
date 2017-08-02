(function(){

    let app = {

        initialize(){
            app.setListeners();
        },

        setListeners(){
            $(".form-delete-mark").on("submit", app.submitForm);
        },

        submitForm(e){
            e.preventDefault();
            let form = $(this);
            $("#input-delete-mark").val($(form[0].mark).val());
            $('#countedSubject').modal('toggle');
        }
    };

    app.initialize();

})();