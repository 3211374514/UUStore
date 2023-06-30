//我方飞机构造函数
var planeBox = document.getElementById('plane');
var planescore = document.getElementsByTagName('strong')[0];
var zscore = 0;

function Myplane(w, h, imgsrc, boomsrc) {
    this.w = w;
    this.h = h;
    this.imgsrc = imgsrc;
    this.boomsrc = boomsrc;
    this.createMyplane();
}

//创建我方飞机
Myplane.prototype.createMyplane = function() {
    this.plane = document.createElement('img');
    this.plane.src = this.imgsrc;
    this.plane.style.cssText = 'width:' + this.w + 'px;height:' + this.h + 'px;position:absolute;left:' + (planeBox.offsetWidth - this.w) / 2 + 'px;top:' + (planeBox.offsetHeight - this.h) + 'px;';
    planeBox.appendChild(this.plane);
    this.move();
    this.shoot();
};

//我方飞机移动
Myplane.prototype.move = function() {
    var that = this;
    document.onmousemove = function(ev) {
        var ev = ev || window.event;
        that.oLeft = ev.clientX - plane.offsetLeft - that.w / 2;
        that.oTop = ev.clientY - plane.offsetTop - that.h / 2;
        if (that.oLeft < 0) {
            that.oLeft = 0;
        } else if (that.oLeft >= plane.offsetWidth - that.w) {
            that.oLeft = plane.offsetWidth - that.w
        }

        if (that.oTop < 0) {
            that.oTop = 0;
        } else if (that.oTop >= plane.offsetHeight - that.h) {
            that.oTop = plane.offsetHeight - that.h;
        }

        that.plane.style.left = that.oLeft + 'px';
        that.plane.style.top = that.oTop + 'px';
        return false;
    }
};
//我方飞机发射子弹
Myplane.prototype.shoot = function() {
    var that = this;
    document.onmousedown = function(ev) {
        var ev = ev || window.event;
        if (ev.which == 1) {
            bulletshoot();
            that.timer = setInterval(bulletshoot, 200);

            function bulletshoot() {
                var bullet = new Bullet(that.plane.offsetLeft + that.w / 2 - 3, that.plane.offsetTop - 14, 6, 14, 'img/bullet.png');
            }
        }
        return false;
    }
    document.onmouseup = function(ev) {
        var ev = ev || window.event;
        if (ev.which == 1) {
            clearInterval(that.timer);
        }
    }
    document.oncontextmenu = function() {
        return false;
    }
};



//子弹的构造函数
function Bullet(x, y, w, h, imgsrc) {
    this.x = x; //位置
    this.y = y;
    this.w = w; //尺寸
    this.h = h;
    this.imgsrc = imgsrc;
    this.createBullet();
}

//创建子弹
Bullet.prototype.createBullet = function() {
    this.bullet = document.createElement('img');
    this.bullet.src = this.imgsrc;
    this.bullet.style.cssText = 'width:' + this.w + 'px;height:' + this.h + 'px;position:absolute;left:' + this.x + 'px;top:' + this.y + 'px;';
    planeBox.appendChild(this.bullet);
    this.move();
}

//子弹移动
Bullet.prototype.move = function() {
    var that = this;
    this.timer = setInterval(function() {
        that.y -= 5;
        if (that.y <= -that.h) {
            clearInterval(that.timer);
            planeBox.removeChild(that.bullet);
        }
        that.bullet.style.top = that.y + 'px';
        that.hit();
    }, 20);
};

Bullet.prototype.hit = function() {
    var allEnemy = document.getElementsByClassName('planeEnemy');
    for (var i = 0; i < allEnemy.length; i++) {
        if ((this.x + this.w) >= allEnemy[i].offsetLeft && this.x <= (allEnemy[i].offsetLeft + allEnemy[i].offsetWidth) && this.y <= (allEnemy[i].offsetTop + allEnemy[i].offsetHeight)) {
            clearInterval(this.timer);
            try{

            planeBox.removeChild(this.bullet);
            }catch(e){

            }
            allEnemy[i].hp--;
            allEnemy[i].checkhp();
        }
    }
};


//敌方飞机的构造函数
function Enemyplane(x, y, w, h, imgsrc, boomsrc, speed, hp, score) {
    this.x = x; //位置
    this.y = y;
    this.w = w; //尺寸
    this.h = h;
    this.imgsrc = imgsrc;
    this.boomsrc = boomsrc;
    this.speed = speed;
    this.hp = hp;
    this.score = score;
    this.createEnemy();
}

//创建敌机
Enemyplane.prototype.createEnemy = function() {
    var that = this;
    this.enemy = document.createElement('img');
    this.enemy.src = this.imgsrc;
    this.enemy.className = 'planeEnemy'; //通过设置类名，方便后面获取
    this.enemy.style.cssText = 'width:' + this.w + 'px;height:' + this.h + 'px;position:absolute;left:' + this.x + 'px;top:' + this.y + 'px;';
    planeBox.appendChild(this.enemy);
    this.enemy.hp = this.hp; //变化的
    this.enemy.score = this.score; //变化的
    this.enemy.checkhp = function() { //this==this.enemy 
        if (this.hp <= 0) {
            clearInterval(this.timer);
            this.className = '';
            this.src = that.boomsrc;
            setTimeout(function() {
                planeBox.removeChild(that.enemy);
            }, 1000);
            zscore += this.score
            planescore.innerHTML = zscore;
        }
    }
    this.move();
}

Enemyplane.prototype.move = function() {
    var that = this;
    this.enemy.timer = setInterval(function() {
        that.y += that.speed;
        if (that.y >= planeBox.offsetHeight) {
            clearInterval(that.enemy.timer);
            planeBox.removeChild(that.enemy);
        }
        that.enemy.style.top = that.y + 'px';
        that.enemyhit();
    }, 50);
}


Enemyplane.prototype.enemyhit = function() {
    if ((this.y + this.h) >= myplane.oTop && this.y <= (myplane.oTop + myplane.h) && (this.x + this.w) > myplane.oLeft && this.x <= (myplane.oLeft + myplane.w)) {
        var allEnemy = document.getElementsByClassName('planeEnemy');
        for (var i = 0; i < allEnemy.length; i++) {
            clearInterval(allEnemy[i].timer);
        }
        clearInterval(timer);
        document.onmousedown = null;
        document.onmousemove = null;
        myplane.plane.src = myplane.boomsrc;
        setTimeout(function() {
            alert('game over!!');
            window.location.reload(); //重刷新
        }, 3000);
    }
}

var myplane = new Myplane(66, 80, 'img/myplane.gif', 'img/myplaneBoom.gif');

for (var i = 0; i < getrandom(1, 2); i++) { //随机创建各类飞机
    var timer = setInterval(function() {
        var num = getrandom(1, 20); //1-15 小飞机  16-20 中飞机  20打飞机
        if (num >= 1 && num < 15) {
            var enemy = new Enemyplane(getrandom(0, planeBox.offsetWidth - 34), -24, 34, 24, 'img/smallplane.png', 'img/smallplaneboom.gif', getrandom(3, 5), 1, 1);
        } else if (num >= 15 && num < 20) {
            var enemy = new Enemyplane(getrandom(0, planeBox.offsetWidth - 46), -60, 46, 60, 'img/midplane.png', 'img/midplaneboom.gif', getrandom(2, 4), 3, 5);
        } else if (num == 20) {
            var enemy = new Enemyplane(getrandom(0, planeBox.offsetWidth - 110), -164, 110, 164, 'img/bigplane.png', 'img/bigplaneboom.gif', getrandom(1, 2), 10, 10);
        }
    }, 1000)
}
