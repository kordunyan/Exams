(function(){
    $("#createDate").datepicker({
        changeMonth:true,
        changeYear:true,
        showOtherMonths:true,
        dateFormat: 'yy-mm-dd',
        maxDate: new Date()
    });
})();