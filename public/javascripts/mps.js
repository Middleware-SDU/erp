
// -------------
// Variables
//----------------
// --------------
// main
// --------------
$(function(){
    setBargaint();
    setYuce();
    initJieshou();
    setMao();
    setPABCX();
    setATP();
    $('#material').change(setBargaint);
    $('#btn-process').click(function(){
        var v1 = setMao();
        var v2 = setPABCX();
        var v3 = setATP();
        $('#show-process').html(v1+v2+v3);
    });
});

//-----------
// Functions
//-----------

var reloadVar = function() {
    selectedOption = $('#material').find("option:selected");
    safeStack = $(selectedOption).attr("safeStack");
    batch = $(selectedOption).attr("batch");
    stack = $(selectedOption).attr("stack");
    data = $(selectedOption).attr("data");
}

var setBargaint = function() {
    var bargaint = JSON.parse($('#material').find("option:selected").attr("data"));
    $('#b-one').html(bargaint.one);
    $('#b-two').html(bargaint.two);
    $('#b-three').html(bargaint.three);
    $('#b-four').html(bargaint.four);
    $('#b-five').html(bargaint.five);
    $('#b-six').html(bargaint.six);
    $('#b-seven').html(bargaint.seven);
    $('#b-eight').html(bargaint.eight);
    $('#b-nine').html(bargaint.nine);
    $('#b-ten').html(bargaint.ten);
    $('#b-eleven').html(bargaint.eleven);
    $('#b-twelve').html(bargaint.twelve);
    return false;
}

var getYuce = function() {
    var temp = JSON.parse($('#material').find("option:selected").attr("data"));
    temp.one = $('#y-one').val();
    temp.two = $('#y-two').val();
    temp.three = $('#y-three').val();
    temp.four = $('#y-four').val();
    temp.five = $('#y-five').val();
    temp.six = $('#y-six').val();
    temp.seven = $('#y-seven').val();
    temp.eight = $('#y-eight').val();
    temp.nine = $('#y-nine').val();
    temp.ten = $('#y-ten').val();
    temp.eleven = $('#y-eleven').val();
    temp.twelve = $('#y-twelve').val();
    return temp;
}

var setYuce = function() {
    var temp = JSON.parse($('#material').find("option:selected").attr("data"));
    $('#y-one').val(temp.one + 10);
    $('#y-two').val(temp.two + 10);
    $('#y-three').val(temp.three + 10);
    $('#y-four').val(temp.four + 10);
    $('#y-five').val(temp.five + 10);
    $('#y-six').val(temp.six + 10);
    $('#y-seven').val(temp.seven + 10);
    $('#y-eight').val(temp.eight + 10);
    $('#y-nine').val(temp.nine + 10);
    $('#y-ten').val(temp.ten + 10);
    $('#y-eleven').val(temp.eleven + 10);
    $('#y-twelve').val(temp.twelve + 10);
    return false;
}

var getMao = function() {
    var temp = JSON.parse($('#material').find("option:selected").attr("data"));
    temp.one = $('#m-one').html();
    temp.two = $('#m-two').html();
    temp.three = $('#m-three').html();
    temp.four = $('#m-four').html();
    temp.five = $('#m-five').html();
    temp.six = $('#m-six').html();
    temp.seven = $('#m-seven').html();
    temp.eight = $('#m-eight').html();
    temp.nine = $('#m-nine').html();
    temp.ten = $('#m-ten').html();
    temp.eleven = $('#m-eleven').html();
    temp.twelve = $('#m-twelve').html();
    return temp;
}

var setMao = function() {
    var temp = JSON.parse($('#material').find("option:selected").attr("data"));
    var temp2 = getYuce();
    $('#m-one').html(temp.one);
    $('#m-two').html(temp.two);
    $('#m-three').html(temp.three);
    $('#m-four').html(temp.four > temp2.four ? temp.four : temp2.four);
    $('#m-five').html(temp.five > temp2.five ? temp.five : temp2.five);
    $('#m-six').html(temp.six > temp2.six ? temp.six : temp2.six);
    $('#m-seven').html(temp.seven > temp2.seven ? temp.seven : temp2.seven);
    $('#m-eight').html(temp.eight > temp2.eight ? temp.eight : temp2.eight);
    $('#m-nine').html(temp2.nine);
    $('#m-ten').html(temp2.ten);
    $('#m-eleven').html(temp2.eleven);
    $('#m-twelve').html(temp2.twelve);
    var res = "[ 计算毛需求量 ] -- <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
    "需求时区：毛需求量 = 合同需求量<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
    "计划时区：毛需求量 = Max(预测量,合同量)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
    "预测时区：毛需求量 = 预测需求量";
    return res;
}

var setPABCX = function() {
    var temp = getJieshou();
    var mao = getMao();
    var safeStack = Number($('#material').find("option:selected").attr("safeStack"));
    var batch = Number($('#material').find("option:selected").attr("batch"));
    var stack = Number($('#material').find("option:selected").attr("stack"));

    $('#pab-zero').html($('#material').find("option:selected").attr("stack"));
    $('#pab1-zero').html($('#pab-zero').html());

    $('#pab-one').html(Number($('#pab1-zero').html()) + Number(temp.one) - Number(mao.one));
    $('#x-one').html(Number($('#pab-one').html()) >= safeStack ? 0 : safeStack - Number($('#pab-one').html()));
    $('#c-one').html(Number($('#x-one').html()) > 0 
            ? batch * (Number($('#x-one').html())%batch > 0 ? (1 + Math.floor(Number($('#x-one').html())/batch)) : $('#x-one').html()/batch )
            : 0);
    $('#pab1-one').html( Number($('#pab-one').html()) + Number($('#c-one').html()));

    $('#pab-two').html(Number($('#pab1-one').html()) + Number(temp.two) - Number(mao.two));
    $('#x-two').html(Number($('#pab-two').html()) >= safeStack ? 0 : safeStack - Number($('#pab-two').html()));
    $('#c-two').html(($('#x-two').html()) > 0 
            ? batch * (Number($('#x-two').html())%batch > 0 ? (1 + Math.floor(Number($('#x-two').html())/batch)) : $('#x-two').html()/batch )
            : 0);
    $('#pab1-two').html( Number($('#pab-two').html()) + Number($('#c-two').html()));
    $('#t-one').html($('#c-two').html());

    $('#pab-three').html(Number($('#pab1-two').html()) + Number(temp.three) - Number(mao.three));
    $('#x-three').html(Number($('#pab-three').html()) >= safeStack ? 0 : (safeStack - Number($('#pab-three').html())));
    $('#c-three').html(Number($('#x-three').html()) > 0 
            ? batch * (Number($('#x-three').html())%batch > 0 ? (1 + Math.floor(Number($('#x-three').html())/batch)) : $('#x-three').html()/batch )
            : 0);
    $('#pab1-three').html( Number($('#pab-three').html()) + Number($('#c-three').html()));
    $('#t-two').html($('#c-three').html());

    $('#pab-four').html(Number($('#pab1-three').html()) + Number(temp.four) - Number(mao.four));
    $('#x-four').html(Number($('#pab-four').html()) >= safeStack ? 0 : safeStack - Number($('#pab-four').html()));
    $('#c-four').html(Number($('#x-four').html()) > 0 
            ? batch * (Number($('#x-four').html())%batch > 0 ? (1 + Math.floor(Number($('#x-four').html())/batch)) : $('#x-four').html()/batch )
            : 0);
    $('#pab1-four').html( Number($('#pab-four').html()) + Number($('#c-four').html()));
    $('#t-three').html($('#c-four').html());

    $('#pab-five').html(Number($('#pab1-four').html()) + Number(temp.five) - Number(mao.five));
    $('#x-five').html(Number($('#pab-five').html()) >= safeStack ? 0 : safeStack - Number($('#pab-five').html()));
    $('#c-five').html(Number($('#x-five').html()) > 0 
            ? batch * (Number($('#x-five').html())%batch > 0 ? (1 + Math.floor(Number($('#x-five').html())/batch)) : $('#x-five').html()/batch )
            : 0);
    $('#pab1-five').html( Number($('#pab-five').html()) + Number($('#c-five').html()));
    $('#t-four').html($('#c-five').html());

    $('#pab-six').html(Number($('#pab1-five').html()) + Number(temp.six) - Number(mao.six));
    $('#x-six').html(Number($('#pab-six').html()) >= safeStack ? 0 : safeStack - Number($('#pab-six').html()));
    $('#c-six').html(Number($('#x-six').html()) > 0 
            ? batch * (Number($('#x-six').html())%batch > 0 ? (1 + Math.floor(Number($('#x-six').html())/batch)) : $('#x-six').html()/batch )
            : 0);
    $('#pab1-six').html( Number($('#pab-six').html()) + Number($('#c-six').html()));
    $('#t-five').html($('#c-six').html());

    $('#pab-seven').html(Number($('#pab1-six').html()) + Number(temp.seven) - Number(mao.seven));
    $('#x-seven').html(Number($('#pab-seven').html()) >= safeStack ? 0 : safeStack - Number($('#pab-seven').html()));
    $('#c-seven').html(Number($('#x-seven').html()) > 0 
            ? batch * (Number($('#x-seven').html())%batch > 0 ? (1 + Math.floor(Number($('#x-seven').html())/batch)) : Number($('#x-seven').html())/batch )
            : 0);
    $('#pab1-seven').html( Number($('#pab-seven').html()) + Number($('#c-seven').html()));
    $('#t-six').html($('#c-seven').html());

    $('#pab-eight').html(Number($('#pab1-seven').html()) + Number(temp.eight) - Number(mao.eight));
    $('#x-eight').html(Number($('#pab-eight').html()) >= safeStack ? 0 : safeStack - Number($('#pab-eight').html()));
    $('#c-eight').html(Number($('#x-eight').html()) > 0 
            ? batch * (Number($('#x-eight').html())%batch > 0 ? (1 + Math.floor(Number($('#x-eight').html())/batch)) : $('#x-eight').html()/batch )
            : 0);
    $('#pab1-eight').html( Number($('#pab-eight').html()) + Number($('#c-eight').html()));
    $('#t-seven').html($('#c-eight').html());

    $('#pab-nine').html(Number($('#pab1-eight').html()) + Number(temp.nine) - Number(mao.nine));
    $('#x-nine').html(Number($('#pab-nine').html()) >= safeStack ? 0 : safeStack - Number($('#pab-nine').html()));
    $('#c-nine').html(Number($('#x-nine').html()) > 0 
            ? batch * (Number($('#x-nine').html())%batch > 0 ? (1 + Math.floor(Number($('#x-nine').html())/batch)) : Number($('#x-nine').html())/batch )
            : 0);
    $('#pab1-nine').html( Number($('#pab-nine').html()) + Number($('#c-nine').html()));
    $('#t-eight').html($('#c-nine').html());

    $('#pab-ten').html(Number($('#pab1-nine').html()) + Number(temp.ten) - Number(mao.ten));
    $('#x-ten').html(Number($('#pab-ten').html()) >= safeStack ? 0 : safeStack - Number($('#pab-ten').html()));
    $('#c-ten').html(Number($('#x-ten').html()) > 0 
            ? batch * (Number($('#x-ten').html())%batch > 0 ? (1 + Math.floor(Number($('#x-ten').html())/batch)) : $('#x-ten').html()/batch )
            : 0);
    $('#pab1-ten').html( Number($('#pab-ten').html()) + Number($('#c-ten').html()));
    $('#t-nine').html($('#c-ten').html());

    $('#pab-eleven').html(Number($('#pab-ten').html()) + Number(temp.eleven) - Number(mao.eleven));
    $('#x-eleven').html(Number($('#pab-eleven').html()) >= safeStack ? 0 : safeStack - Number($('#pab-eleven').html()));
    $('#c-eleven').html(Number($('#x-eleven').html()) > 0 
            ? batch * (Number($('#x-eleven').html())%batch > 0 ? (1 + Math.floor(Number($('#x-eleven').html())/batch)) : Number($('#x-eleven').html())/batch )
            : 0);
    $('#pab1-eleven').html( Number($('#pab-eleven').html()) + Number($('#c-eleven').html()));
    $('#t-ten').html($('#c-eleven').html());

    $('#pab-twelve').html(Number($('#pab1-eleven').html()) + Number(temp.twelve) - Number(mao.twelve));
    $('#x-twelve').html(Number($('#pab-twelve').html()) >= safeStack ? 0 : safeStack - Number($('#pab-twelve').html()));
    $('#c-twelve').html(Number($('#x-twelve').html()) > 0 
            ? batch * (Number($('#x-twelve').html())%batch > 0 ? (1 + Math.floor(Number($('#x-twelve').html())/batch)) : Number($('#x-twelve').html())/batch )
            : 0);
    $('#pab1-twelve').html( Number($('#pab-twelve').html()) + Number($('#c-twelve').html()));
    $('#t-eleven').html($('#c-twelve').html());
    var res = "[ 计算PAB初值 ] -- PAB初值 = 上期末PAB + 计划接收量 - 毛需求量" + 
                "<br>[ 净需求量 ] -- 净需求量 = 安全库存 - PAB初值  -- OR 0(PAB初值 >= 安全库存)" +
                "<br>[ 计划生产量 ] -- 计划生产量 = 净需求量%生产批量==0 ? 生产批量 * (净需求量/生产批量) : 生产批量 * (1+净需求量/生产批量) -- OR 0(净需求量==0)" +
                "<br>[ 计算PAB ] -- PAB = PAB初值 + 计划生产量" +
                "<br>[ 计算计划投入量 ] -- 计划投入量 = 下一期的计划生产量"
                ;
    return res;
}

var setATP = function() {
    var temp = getJieshou();
    var bargaint = JSON.parse($('#material').find("option:selected").attr("data"));
    $('#atp-one').html(Number($('#pab-zero').html()) + Number($('#c-one').html()) + Number(temp.one) - Number(bargaint.one) -(
        Number($('#c-two').html()) >= 0 ? 0 : (Number(bargaint.two) +
                Number($('#c-three').html()) >= 0 ? 0 : (Number(bargaint.three) +
                        Number($('#c-four').html()) >= 0 ? 0 : (Number(bargaint.four) +
                                Number($('#c-five').html()) >= 0 ? 0 : (Number(bargaint.five) +
                                        Number($('#c-six').html()) >= 0 ? 0 : (Number(bargaint.six) +
                                                Number($('#c-seven').html()) >= 0 ? 0 : (Number(bargaint.seven) +
                                                        Number($('#c-eight').html()) >= 0 ? 0 : (Number(bargaint.eight) +
                                                                Number($('#c-nine').html()) >= 0 ? 0 : (Number(bargaint.nine) +
                                                                        Number($('#c-ten').html()) >= 0 ? 0 : (Number(bargaint.ten) +
                                                                                Number($('#c-eleven').html()) >= 0 ? 0 : (Number(bargaint.eleven) +
                                                                                        Number($('#c-twelve').html()) >= 0 ? 0 : (Number(bargaint.twelve))
                                                                                )
                                                                        )
                                                                )
                                                        )
                                                )
                                        )
                                )
                        )
                )
            )
        ));

    $('#atp-two').html(Number($('#c-two').html()) + Number(temp.two) - Number(bargaint.two) -(
        Number($('#c-three').html()) >= 0 ? 0 : (Number(bargaint.three) +
                Number($('#c-four').html()) >= 0 ? 0 : (Number(bargaint.four) +
                        Number($('#c-five').html()) >= 0 ? 0 : (Number(bargaint.five) +
                                Number($('#c-six').html()) >= 0 ? 0 : (Number(bargaint.six) +
                                        Number($('#c-seven').html()) >= 0 ? 0 : (Number(bargaint.seven) +
                                                Number($('#c-eight').html()) >= 0 ? 0 : (Number(bargaint.eight) +
                                                        Number($('#c-nine').html()) >= 0 ? 0 : (Number(bargaint.nine) +
                                                                Number($('#c-ten').html()) >= 0 ? 0 : (Number(bargaint.ten) +
                                                                        Number($('#c-eleven').html()) >= 0 ? 0 : (Number(bargaint.eleven) +
                                                                                Number($('#c-twelve').html()) >= 0 ? 0 : (Number(bargaint.twelve))
                                                                        )
                                                                )
                                                        )
                                                )
                                        )
                                )
                        )
                )
        )
    ));

    $('#atp-three').html(Number($('#c-three').html()) + Number(temp.three) - Number(bargaint.three) -(
            Number($('#c-four').html()) >= 0 ? 0 : (Number(bargaint.four) +
                    Number($('#c-five').html()) >= 0 ? 0 : (Number(bargaint.five) +
                            Number($('#c-six').html()) >= 0 ? 0 : (Number(bargaint.six) +
                                    Number($('#c-seven').html()) >= 0 ? 0 : (Number(bargaint.seven) +
                                            Number($('#c-eight').html()) >= 0 ? 0 : (Number(bargaint.eight) +
                                                    Number($('#c-nine').html()) >= 0 ? 0 : (Number(bargaint.nine) +
                                                            Number($('#c-ten').html()) >= 0 ? 0 : (Number(bargaint.ten) +
                                                                    Number($('#c-eleven').html()) >= 0 ? 0 : (Number(bargaint.eleven) +
                                                                            Number($('#c-twelve').html()) >= 0 ? 0 : (Number(bargaint.twelve))
                                                                    )
                                                            )
                                                    )
                                            )
                                    )
                            )
                    )
            )
    ));

    $('#atp-four').html(Number($('#c-four').html()) + Number(temp.four) - Number(bargaint.four) -(
            Number($('#c-five').html()) >= 0 ? 0 : (Number(bargaint.five) +
                    Number($('#c-six').html()) >= 0 ? 0 : (Number(bargaint.six) +
                            Number($('#c-seven').html()) >= 0 ? 0 : (Number(bargaint.seven) +
                                    Number($('#c-eight').html()) >= 0 ? 0 : (Number(bargaint.eight) +
                                            Number($('#c-nine').html()) >= 0 ? 0 : (Number(bargaint.nine) +
                                                    Number($('#c-ten').html()) >= 0 ? 0 : (Number(bargaint.ten) +
                                                            Number($('#c-eleven').html()) >= 0 ? 0 : (Number(bargaint.eleven) +
                                                                    Number($('#c-twelve').html()) >= 0 ? 0 : (Number(bargaint.twelve))
                                                            )
                                                    )
                                            )
                                    )
                            )
                    )
            )
    ));

    $('#atp-five').html(Number($('#c-five').html()) + Number(temp.five) - Number(bargaint.five) -(
            Number($('#c-six').html()) >= 0 ? 0 : (Number(bargaint.six) +
                    Number($('#c-seven').html()) >= 0 ? 0 : (Number(bargaint.seven) +
                            Number($('#c-eight').html()) >= 0 ? 0 : (Number(bargaint.eight) +
                                    Number($('#c-nine').html()) >= 0 ? 0 : (Number(bargaint.nine) +
                                            Number($('#c-ten').html()) >= 0 ? 0 : (Number(bargaint.ten) +
                                                    Number($('#c-eleven').html()) >= 0 ? 0 : (Number(bargaint.eleven) +
                                                            Number($('#c-twelve').html()) >= 0 ? 0 : (Number(bargaint.twelve))
                                                    )
                                            )
                                    )
                            )
                    )
            )
    ));

    $('#atp-six').html(Number($('#c-six').html()) + Number(temp.six) - Number(bargaint.six) -(
            Number($('#c-seven').html()) >= 0 ? 0 : (Number(bargaint.seven) +
                    Number($('#c-eight').html()) >= 0 ? 0 : (Number(bargaint.eight) +
                            Number($('#c-nine').html()) >= 0 ? 0 : (Number(bargaint.nine) +
                                    Number($('#c-ten').html()) >= 0 ? 0 : (Number(bargaint.ten) +
                                            Number($('#c-eleven').html()) >= 0 ? 0 : (Number(bargaint.eleven) +
                                                    Number($('#c-twelve').html()) >= 0 ? 0 : (Number(bargaint.twelve))
                                            )
                                    )
                            )
                    )
            )
    ));

    $('#atp-seven').html(Number($('#c-seven').html()) + Number(temp.seven) - Number(bargaint.seven) -(
            Number($('#c-eight').html()) >= 0 ? 0 : (Number(bargaint.eight) +
                    Number($('#c-nine').html()) >= 0 ? 0 : (Number(bargaint.nine) +
                            Number($('#c-ten').html()) >= 0 ? 0 : (Number(bargaint.ten) +
                                    Number($('#c-eleven').html()) >= 0 ? 0 : (Number(bargaint.eleven) +
                                            Number($('#c-twelve').html()) >= 0 ? 0 : (Number(bargaint.twelve))
                                    )
                            )
                    )
            )
    ));

    $('#atp-eight').html(Number($('#c-eight').html()) + Number(temp.eight) - Number(bargaint.eight) -(
            Number($('#c-nine').html()) >= 0 ? 0 : (Number(bargaint.nine) +
                    Number($('#c-ten').html()) >= 0 ? 0 : (Number(bargaint.ten) +
                            Number($('#c-eleven').html()) >= 0 ? 0 : (Number(bargaint.eleven) +
                                    Number($('#c-twelve').html()) >= 0 ? 0 : (Number(bargaint.twelve))
                            )
                    )
            )
    ));

    $('#atp-nine').html(Number($('#c-nine').html()) + Number(temp.nine) - Number(bargaint.nine) -(
            Number($('#c-ten').html()) >= 0 ? 0 : (Number(bargaint.ten) +
                    Number($('#c-eleven').html()) >= 0 ? 0 : (Number(bargaint.eleven) +
                            Number($('#c-twelve').html()) >= 0 ? 0 : (Number(bargaint.twelve))
                    )
            )
    ));

    $('#atp-ten').html(Number($('#c-ten').html()) + Number(temp.ten) - Number(bargaint.ten) -(
                Number($('#c-eleven').html()) >= 0 ? 0 : (Number(bargaint.eleven) +
                        Number($('#c-twelve').html()) >= 0 ? 0 : (Number(bargaint.twelve))
                )
    ));

    $('#atp-eleven').html(Number($('#c-eleven').html()) + Number(temp.eleven) - Number(bargaint.eleven) -(
                Number($('#c-twelve').html()) >= 0 ? 0 : (Number(bargaint.twelve))
));
    var res = "[ 计算ATP ] -- ATP = 计划生产量 + 计划接收量 - 从本次起到下一次产出的所有合同需求量";
    return res;
}

var getChanchu = function() {
    var temp = JSON.parse($('#material').find("option:selected").attr("data"));
    temp.one = $('#c-one').html();
    temp.two = $('#c-two').html();
    temp.three = $('#c-three').html();
    temp.four = $('#c-four').html();
    temp.five = $('#c-five').html();
    temp.six = $('#c-six').html();
    temp.seven = $('#c-seven').html();
    temp.eight = $('#c-eight').html();
    temp.nine = $('#c-nine').html();
    temp.ten = $('#c-ten').html();
    temp.eleven = $('#c-eleven').html();
    temp.twelve = $('#c-twelve').html();
    return temp;
}

var getJieshou = function() {
    var temp = JSON.parse($('#material').find("option:selected").attr("data"));
    temp.one = $('#j-one').val();
    temp.two = $('#j-two').val();
    temp.three = $('#j-three').val();
    temp.four = $('#j-four').val();
    temp.five = $('#j-five').val();
    temp.six = $('#j-six').val();
    temp.seven = $('#j-seven').val();
    temp.eight = $('#j-eight').val();
    temp.nine = $('#j-nine').val();
    temp.ten = $('#j-ten').val();
    temp.eleven = $('#j-eleven').val();
    temp.twelve = $('#j-twelve').val();
    return temp;
}

var initJieshou = function() {
    $('#j-one').val(0);
    $('#j-two').val(0);
    $('#j-three').val(0);
    $('#j-four').val(0);
    $('#j-five').val(0);
    $('#j-six').val(0);
    $('#j-seven').val(0);
    $('#j-eight').val(0);
    $('#j-nine').val(0);
    $('#j-ten').val(0);
    $('#j-eleven').val(0);
    $('#j-twelve').val(0);
    return false;
}