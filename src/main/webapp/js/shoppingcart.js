/*
    功能列表
    1，全选功能
        选中所有行，汇总价格
    2，单选功能
        选中或取消选中一行
    3，数量加减按钮
        增减商品数量，计算小计价格
    4，删除按钮
        移除当前行，重新计算总计价格
    5，删除被选中的商品
*/

// 获取所有加减按钮(得到的是一个数组)
var add = document.querySelectorAll(".Increase");
var reduce = document.querySelectorAll(".Reduce");
// 获取所有文本框
var inputs = document.querySelectorAll(".unum");
// 获取所有行
var rows = document.querySelectorAll(".row");
// 获取所有单选框
var chooses = document.querySelectorAll(".choose");
// 获取所有全选按钮
var choose_alls = document.querySelectorAll(".choose_all");
// 获取所有删除按钮
var btn_dels = document.querySelectorAll(".btn-del");
// 删除选中的商品
var del_check = document.querySelector(".del_check");


// 给所有的加减按钮绑定点击事件
for(var i=0; i<add.length; i++){
    add[i].onclick=function(){

        // 获取对应的父节点
        var amount = this.parentNode;
        // 获取文本框
        var input = amount.querySelector(".unum");
        // 获取文本框中的数量
        var num = input.value;
        num++;
        // 修改文本框的值
        input.value=num;

        // 计算小计
        // 获取当前行
        var tr =  amount.parentNode.parentNode;
        // 获取商品单价
        var unit = tr.querySelector(".unit");
        var price = unit.innerHTML;
        // 重新计算小计价格
        smallTotal = num*price;
        // 保留两位小数
        smallTotal = smallTotal.toFixed(2);

        // 将计算好的小计价格设置给金额
        var u_price = tr.querySelector(".u-price");
        u_price.innerHTML = smallTotal;

        // 使当前行被选中
        var choose = tr.querySelector(".choose");
        // 把它当成逻辑变量，赋true false也可以
        choose.checked = "checked";

        // 计算总计
        setTotal();
    }
}

for(var i=0; i<reduce.length; i++){
    reduce[i].onclick=function(){

        // 获取对应的父节点
        var amount = this.parentNode;
        // 获取文本框
        var input = amount.querySelector(".unum");
        // 获取文本框中的数量
        var num = input.value;
        if(num > 1){
            num--;
        }
        // 修改文本框的值
        input.value=num;

        // 计算小计
        // 获取当前行
        var tr =  amount.parentNode.parentNode;
        // 获取商品单价
        var unit = tr.querySelector(".unit");
        var price = unit.innerHTML;
        // 重新计算小计价格
        smallTotal = num*price;
        // 保留两位小数
        smallTotal = smallTotal.toFixed(2);

        // 将计算好的小计价格设置给金额
        var u_price = tr.querySelector(".u-price");
        u_price.innerHTML = smallTotal;

        // 使当前行被选中
        var choose = tr.querySelector(".choose");
        // 把它当成逻辑变量，赋true false也可以
        choose.checked = "checked";

        setTotal();
    }
}

// 用户手动修改文本框中的商品数量
for(var i=0; i<inputs.length; i++){
    // 给每个文本框绑定 失焦 事件
    inputs[i].onblur = function(){
        // 防止出现负数
        if(this.value < 1){
            this.value = 1;
        }
        // 防止输入小数或其它字符
        this.value = parseInt(this.value);

        // 计算小计
        // 获取当前行
        var tr =  this.parentNode.parentNode.parentNode;
        // 获取商品单价
        var unit = tr.querySelector(".unit");
        var price = unit.innerHTML;
        // 重新计算小计价格
        smallTotal = this.value*price;
        // 保留两位小数
        smallTotal = smallTotal.toFixed(2);

        // 将计算好的小计价格设置给金额
        var u_price = tr.querySelector(".u-price");
        u_price.innerHTML = smallTotal;

        // 使当前行被选中
        var choose = tr.querySelector(".choose");
        // 把它当成逻辑变量，赋true false也可以
        choose.checked = "checked";

        setTotal();
    }
}

// 计算总计价格 & 计算选中的商品总数 & 同时判断是否全选
function setTotal(){
    var total = 0;  // 商品总价
    var allNum = 0; // 商品总数
    // 重新获取行
    rows = document.querySelectorAll(".row");
    // 遍历所有行
    for(var i=0; i<rows.length; i++){
        // 查找被选中的行
        var checkbox = rows[i].querySelector(".choose");
        if(checkbox.checked){

            // 获取小计价格（得到的是字符串，不是数字，需要转化）
            var smallTotal = rows[i].querySelector(".u-price").innerHTML;
            // 获取商品数量
            var num = rows[i].querySelector(".unum").value;
            // 把小计价格转化为数字
            smallTotal = Number(smallTotal);
            total += smallTotal;
            // 计算商品总数
            num = Number(num);
            allNum += num;
        }
    }

    // 把总计放在它应在的位置
    var totalPrice = document.querySelector(".t-price");
    totalPrice.innerHTML = total.toFixed(2);
    // 设置商品总数
    document.querySelector(".t-number").innerHTML = allNum;

    var isCheckAll = true;
    for(var i=0; i<rows.length; i++){
        var checkbox = rows[i].querySelector(".choose");
        if(!checkbox.checked){
            isCheckAll = false;
            break;
        }
    }
    if(rows.length<=0){
        isCheckAll = false;
    }
    // 将两个全选框设置为和全选变量相同的值
    choose_alls[0].checked = isCheckAll;
    choose_alls[1].checked = isCheckAll;
}

// 单选框点击事件
for(var i=0; i<chooses.length; i++){
    chooses[i].onclick = function(){
        // 求一下总计就行了
        setTotal();
    }
}

// 全选框点击事件
for(var i=0; i<choose_alls.length; i++){
    choose_alls[i].onclick = function(){
        // 全选/全不选所有单选框
        for(var i=0; i<rows.length; i++){
            var checkbox = rows[i].querySelector(".choose");
            checkbox.checked = this.checked;
        }
        // 与另外一个全选框联动
        choose_alls[0].checked = this.checked;
        choose_alls[1].checked = this.checked;
        // 计算总计
        setTotal();
    }
}

// 删除当前行
for(var i=0; i<btn_dels.length; i++){
    btn_dels[i].onclick = function(){
        var tr = this.parentNode.parentNode;
        tr.parentNode.removeChild(tr);
        setTotal();
    }
}

// 删除选中行
del_check.onclick = function(){
    rows = document.querySelectorAll(".row");
    for(var i=0; i<rows.length; i++){
        var checkbox = rows[i].querySelector(".choose");
        if(checkbox.checked){
            rows[i].parentNode.removeChild(rows[i]);
        }
    }
}

