(function(){

    let app = {

        messages: {
            title: 'Title must contain between 3 and 35 characters',
        },

        pattern: /^[A-Za-z]{3,32}([\s][A-Za-z]{2,32}){0,1}$/,

        initialize(){
            app.setListeners();
        },

        setListeners(){
            $("#formAddSubject").on("submit", app.submitForm);
        },

        submitForm(e){
            let form = $(this);
            let title = $(form[0].title);
            let isValid = app.pattern.test(title.val());
            if(isValid){
                app.destroyMessage(title);
            }
            else{
                app.showMessage(title, title.attr('name'));
            }
            return isValid;
        },

        destroyMessage(elem) {
            var formGroup = elem.closest('.form-group');
            if (formGroup.hasClass('has-error')) {
                formGroup.removeClass('has-error');
                var withErrors = formGroup.find('.help-block');
                withErrors.html('');
            }
        },

        showMessage(elem, error){
            let formGroup = elem.closest('.form-group');
            formGroup.addClass('has-error');
            let withErrors = formGroup.find('.help-block');
            withErrors.html(app.messages[error]);
        }

    };

    app.initialize();

})();