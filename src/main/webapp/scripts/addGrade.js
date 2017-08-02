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
})();
