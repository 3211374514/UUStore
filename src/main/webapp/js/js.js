//缓冲运动
function getStyle(obj, attr) {
    if (obj.currentStyle) {
        return obj.currentStyle[attr];
    } else {
        return getComputedStyle(obj)[attr];
    }
}

function startMove(obj, json, fn) {
    var cur = 0;
    var timer = null;
    var speed = null;
    clearInterval(obj.timer)
    obj.timer = setInterval(function() {
        var bstop = true;
        for (var attr in json) {
            if (attr == 'opacity') {//求初始值
                cur = Math.round(getStyle(obj, attr) * 100);
            } else {
                cur = parseInt(getStyle(obj, attr));
            }
            speed = (json[attr] - cur) / 8;
            speed = speed > 0 ? Math.ceil(speed) : Math.floor(speed);
            if (cur != json[attr]) {
                bstop = false;
                if (attr == 'opacity') {
                    obj.style[attr] = (cur + speed) / 100;
                    obj.style.filter = 'alpha(opacity=' + (cur + speed) + ')';
                } else {
                    obj.style[attr] = cur + speed + 'px';
                }
            }
        }
        if (bstop) {
            clearInterval(obj.timer);
            fn && fn();
        }
    }, 30);
}


//通过类名获取元素
function getClass(oClass, oParent) {
    var oP = oParent || document;
    var arr = [];
    var aEle = oP.getElementsByTagName('*');
    var reg = new RegExp('\\b' + oClass + '\\b');
    for (var i = 0; i < aEle.length; i++) {
        if (reg.test(aEle[i].className)) {
            arr.push(aEle[i]);
        }
    }
    return arr;
}

//取任意的随机数，范围是min-max之间
function getrandom(min,max){
    return Math.floor(Math.random()*(max-min+1))+min;
}




