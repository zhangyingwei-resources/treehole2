/**
 * Created by zhangyw on 2017/4/23.
 */
$(function(){
    var data = {}
    var index = 0;
    var canNext = true;
    const steps = getSetps();//select all steps
    console.log("find "+ steps.length +" steps")
    showSteps(steps,index)
    firstStep()
    addValieListener();
    $("#prew").click(function () {
        prew(prewStep)
    })

    $("#next").click(function () {
        next(nextStep)
    })

    $("#submit").click(function(){
        submit()
    })

    function addValieListener(){
        $(".not-empty").blur(function(){
            const text = $(this).val()
            if(is.empty(text)){
                layer.tips("必填哦",$(this))
                $(this).parent().addClass("has-error")
                canNext = false
            }else{
                $(this).parent().removeClass("has-error")
                canNext = true
            }
        })
    }

    /**
     * show next step
     */
    function next(callBack){
        console.log("next",index)
        console.log(index<steps.length-1)
        var validToNext = true;
        if(index<steps.length-1){
            validToNext = validStep(steps[index]) && callBack(steps[index],index)
            if(validToNext){
                closeStep(steps,index)
                index++
                showSteps(steps,index)
                notFirstStep()
            }
        }
        if(index>=steps.length-1){
            if(validToNext){
                lastStep()
            }
        }
    }

    /**
     * show prew step
     */
    function prew(callBack){
        console.log("prew")
        if(index>0){
            callBack(steps[index])
            closeStep(steps,index)
            index--
            showSteps(steps,index)
            notLastStep()
        }
        if(index<=0){
            firstStep()
        }
    }

    function firstStep(){
        $("#prew").addClass("disabled")
    }
    function notFirstStep(){
        $("#prew").removeClass("disabled")
    }
    function lastStep() {
        $("#next").addClass("disabled")
        $("#submit").removeClass("hidden")
    }
    function notLastStep() {
        $("#next").removeClass("disabled")
        $("#submit").addClass("hidden")
    }

    /**
     * get all step divs
     * @returns {jQuery|HTMLElement}
     */
    function getSetps(){
        return $(".steps").find(".step")
    }

    /**
     * show one step
     */
    function showSteps() {
        const text = $(steps[index]).children(".msg").text()
        $("#step-tip").text("第 " + (index + 1) + " 步" +" ["+" "+text+" "+"]")
        $(steps[index]).show(0)
    }

    /**
     * close one step
     */
    function closeStep(){
        $(steps[index]).hide(0)
    }

    /**
     * call when click prew button
     * @param step
     */
    function prewStep(step){
        console.log("prewStep")
    }

    /**
     * call when click next button
     * @param step
     * @returns {boolean}
     */
    function nextStep(step,index){
        var type = $(step).find(".info").text();
        var resultFlag = true;
        if(type === 'database'){
            var db = {}
            var inputs = $(step).find("input")
            db.url = $(inputs[0]).val();
            db.username = $(inputs[1]).val();
            db.password = strEnc($(inputs[2]).val(),"treehole");
            var loadIndex = layer.load(1);
            $.ajax({ //valid database infomation
                type: "POST",
                async:false,
                url:"/install/db/mysql",
                data:db,
                success:function(data){
                    layer.close(loadIndex)
                    if(data.message === "验证成功"){
                        resultFlag = true;
                    }else{
                        layer.msg("数据库验证失败");
                        resultFlag = false;
                    }
                }
            })
        }
        return resultFlag;
    }

    /**
     * valid one step infomation
     * @param step
     */
    function validStep(step){
        var flag = true;
        var notEmptys = $(step).find(".not-empty")
        for (var i = 0;i<notEmptys.length;i++){
            if(is.empty($(notEmptys[i]).val())){
                $(notEmptys[i]).parent().addClass("has-error")
                flag = false;
            }
        }
        if(!flag){
            layer.msg("请按要求完善信息")
        }
        return flag;
    }

    /**
     * infomation submit function
     *
     * 1 valid admin infomation
     * 2 submit all info
     */
    function submit(){
        validStep(steps[steps.length-1])
        validPasswd()
        if(!canNext){
            return;
        }
        var data = {}
        data.url = $("input[name=dburl]").val();
        data.username = $("input[name=dbusername]").val();
        data.password = $("input[name=dbpassword]").val();
        data.blogname = $("input[name=blogname]").val();
        data.blogurl = $("input[name=blogurl]").val();
        data.blogdesc = $("input[name=blogdesc]");
        data.adminusername = $("input[name=adminusername]").val();
        data.adminpassword = $("input[name=adminpassword]").val();
        console.log(data)
        var loading = layer.load(1)
        layer.close(loading);
    }

    /**
     * valid passwd and qrpasswd
     */
    function validPasswd(){
        var pass = $("#passwd").val()
        var qrpass = $("#qrpasswd").val()
        console.log(pass,qrpass)
        if(!is.equal(pass,qrpass)){
            canNext = false
            layer.msg("两次密码不相同")
        }
    }
})