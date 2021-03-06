(function(){



    let app = {

            messages: {
                empty:{
                    'en':'Fill in this field',
                    'ua':'Заповніть дане поле',
                },

                mark:{
                    'en':'Mark must between 0 and 99',
                    'ua':'Оцінка повинна бути в межах від 0 до 99',
                },

                createdate: {
                    'en':'Date is not valid',
                    'ua':'Некоректна дата',
                }
            },

            locale:'en',

            patterns:{
                mark: /^[0-9]{1,2}$/
            },

            form:null,
            btnSubmit:null,
            inputMark:null,
            inputCreateDate:null,

            initialize(){

                if($.cookie('locale') != null){
                    app.locale = $.cookie('locale');
                }

                let max = new Date();
                let min = new Date(max.getFullYear(), 0, 1);
                this.form = $("#form-add-grade");

                this.inputCreateDate = this.form.find("input[name='createdate']");
                this.inputCreateDate.datepicker({
                    changeMonth:true,
                    changeYear:true,
                    showOtherMonths:true,
                    dateFormat: 'yy-mm-dd',
                    maxDate: max,
                    minDate: min,
                    onSelect:app.handlerInputForm
                });

                this.inputMark = this.form.find("input[name='mark']");

                this.bthSubmit = $("#btnSubmit");
                this.bthSubmit.attr("disabled", "disabled");

                this.setListeners();
            },

            setListeners(){
                this.form.on("submit", app.submitForm);
                this.inputMark.on("input", app.handlerInputForm);
            },

            submitForm(e){
                return app.validateForm($(this));
            },

            handlerInputForm(){
                if(app.inputCreateDate.val().length != 0 && app.inputMark.val().length != 0 && app.bthSubmit.attr("disabled") == "disabled"){
                    app.bthSubmit.removeAttr("disabled");
                }
                else if(app.inputCreateDate.val().length == 0 || app.inputMark.val().length == 0){
                    app.bthSubmit.attr("disabled", "disabled");
                }
                app.destroyMessage($(this));
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
                withErrors.html(app.messages[error][app.locale]);
            }

        };

        app.initialize();


})();
