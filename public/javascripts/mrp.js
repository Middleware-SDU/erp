
// -------------
// Variables
//----------------
// --------------
// main
// --------------
$(function(){
    init();
    $('#bom').change(init);
    $('#btn-process').click(function(){
    });
});

//-----------
// Functions
//-----------

var init = function() {
    $('#dcm').html($('#bom').find("option:selected").attr("dcm"));
    $('#tqq').html($('#bom').find("option:selected").attr("tqq"));
    $('#xyl').html($('#bom').find("option:selected").attr("stack"));
    $('#aqkc').html($('#bom').find("option:selected").attr("safeStack"));
    $('#pl').html($('#bom').find("option:selected").attr("batch"));
    $('#wlh').html($('#bom').find("option:selected").attr("wlh"));

    var id = $('#bom').find("option:selected").attr("mid");
    setInitPAB($.jStorage.get(id+"-initPAB"));
    setPAB($.jStorage.get(id+"-pab"));
    setJieshou($.jStorage.get(id+"-jieshou"));
    setJXQ($.jStorage.get(id+"-jxq"));
    setCC($.jStorage.get(id+"-cc"));
    setTR($.jStorage.get(id+"-tr"));

    return false;
}

var setInitPAB = function(temp) {
    $('#pab-one').html(temp.one);
    $('#pab-two').html(temp.two);
    $('#pab-three').html(temp.three);
    $('#pab-four').html(temp.four);
    $('#pab-five').html(temp.five);
    $('#pab-six').html(temp.six);
    $('#pab-seven').html(temp.seven);
    $('#pab-eight').html(temp.eight);
    $('#pab-nine').html(temp.nine);
    $('#pab-ten').html(temp.ten);
    $('#pab-eleven').html(temp.eleven);
    $('#pab-twelve').html(temp.twelve);
    return temp;
}

var setPAB = function(temp) {
    $('#pab1-one').html(temp.one);
    $('#pab1-two').html(temp.two);
    $('#pab1-three').html(temp.three);
    $('#pab1-four').html(temp.four);
    $('#pab1-five').html(temp.five);
    $('#pab1-six').html(temp.six);
    $('#pab1-seven').html(temp.seven);
    $('#pab1-eight').html(temp.eight);
    $('#pab1-nine').html(temp.nine);
    $('#pab1-ten').html(temp.ten);
    $('#pab1-eleven').html(temp.eleven);
    $('#pab1-twelve').html(temp.twelve);
    return temp;
}

var setJieshou = function(temp) {
    $('#j-one').html(temp.one);
    $('#j-two').html(temp.two);
    $('#j-three').html(temp.three);
    $('#j-four').html(temp.four);
    $('#j-five').html(temp.five);
    $('#j-six').html(temp.six);
    $('#j-seven').html(temp.seven);
    $('#j-eight').html(temp.eight);
    $('#j-nine').html(temp.nine);
    $('#j-ten').html(temp.ten);
    $('#j-eleven').html(temp.eleven);
    $('#j-twelve').html(temp.twelve);
    return temp;
}

var setJXQ = function(temp) {
    $('#x-one').html(temp.one);
    $('#x-two').html(temp.two);
    $('#x-three').html(temp.three);
    $('#x-four').html(temp.four);
    $('#x-five').html(temp.five);
    $('#x-six').html(temp.six);
    $('#x-seven').html(temp.seven);
    $('#x-eight').html(temp.eight);
    $('#x-nine').html(temp.nine);
    $('#x-ten').html(temp.ten);
    $('#x-eleven').html(temp.eleven);
    $('#x-twelve').html(temp.twelve);
    return temp;
}

var setCC = function(temp) {
    $('#c-one').html(temp.one);
    $('#c-two').html(temp.two);
    $('#c-three').html(temp.three);
    $('#c-four').html(temp.four);
    $('#c-five').html(temp.five);
    $('#c-six').html(temp.six);
    $('#c-seven').html(temp.seven);
    $('#c-eight').html(temp.eight);
    $('#c-nine').html(temp.nine);
    $('#c-ten').html(temp.ten);
    $('#c-eleven').html(temp.eleven);
    $('#c-twelve').html(temp.twelve);

    $('#cc-one').html(temp.one);
    $('#cc-two').html(temp.two);
    $('#cc-three').html(temp.three);
    $('#cc-four').html(temp.four);
    $('#cc-five').html(temp.five);
    $('#cc-six').html(temp.six);
    $('#cc-seven').html(temp.seven);
    $('#cc-eight').html(temp.eight);
    $('#cc-nine').html(temp.nine);
    $('#cc-ten').html(temp.ten);
    $('#cc-eleven').html(temp.eleven);
    $('#cc-twelve').html(temp.twelve);
    return temp;
}

var setTR = function(temp) {
    $('#t-one').html(temp.one);
    $('#t-two').html(temp.two);
    $('#t-three').html(temp.three);
    $('#t-four').html(temp.four);
    $('#t-five').html(temp.five);
    $('#t-six').html(temp.six);
    $('#t-seven').html(temp.seven);
    $('#t-eight').html(temp.eight);
    $('#t-nine').html(temp.nine);
    $('#t-ten').html(temp.ten);
    $('#t-eleven').html(temp.eleven);
    $('#t-twelve').html(temp.twelve);

    $('#tr-one').html(temp.one);
    $('#tr-two').html(temp.two);
    $('#tr-three').html(temp.three);
    $('#tr-four').html(temp.four);
    $('#tr-five').html(temp.five);
    $('#tr-six').html(temp.six);
    $('#tr-seven').html(temp.seven);
    $('#tr-eight').html(temp.eight);
    $('#tr-nine').html(temp.nine);
    $('#tr-ten').html(temp.ten);
    $('#tr-eleven').html(temp.eleven);
    $('#tr-twelve').html(temp.twelve);
    return temp;
}
