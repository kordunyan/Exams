(function(){

    let max = new Date();
    let min = new Date(max.getFullYear(), 0, 1);

    $("#createDate").datepicker({
        changeMonth:true,
        changeYear:true,
        showOtherMonths:true,
        dateFormat: 'yy-mm-dd',
        maxDate: max,
        minDate: min
    });


    let app = {

            messages: {
                empty:'Fill in this field',
                mark: 'Mark should be a integer',
                createdate: 'Date is not valid',
            },

            patterns:{
                mark: /^[0-9]{1,2}$/
            },

            initialize(){
                app.setListeners();
            },

            setListeners(){
                $("#form-add-grade").on("submit", app.submitForm);
            },

            submitForm(e){
                return app.validateForm($(this));
            },

            validateForm(form){
                let inputs = form.find('input');
                let isValid = true;
                $.each(inputs, function(index, val){
                    let input = $(val);
                    let res = true;
                    if(input.attr('type') == 'hidden') return;
                    if(input.val().length == 0){
                        isValid = false;
                        app.showMessage(input, "empty");
                        return;
                    }
                    switch(input.attr('name')){
                        case "mark":
                            res = app.patterns.mark.test(input.val());
                        break;
                        case "createdate":
                            let date = new Date();
                            let inputDate = new Date(input.val());
                            if(date.getTime() < inputDate.getTime()){
                                res = false;
                            }
                            else if(inputDate.getFullYear() < date.getFullYear()){
                                res = false;
                            }
                        break;
                    }

                    if(!res){
                        app.showMessage(input, input.attr("name"));
                        isValid = false;
                    }
                    else{
                        app.destroyMessage(input);
                    }
                });
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
